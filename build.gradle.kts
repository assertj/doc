import java.util.Properties
import org.asciidoctor.gradle.jvm.AsciidoctorTask

plugins {
	java
	id("org.ajoberstar.git-publish") version "3.0.0"
	id("org.asciidoctor.jvm.convert") version "3.3.2"
}

val properties = Properties().load(project.rootProject.file("./gradle.properties").inputStream())
val assertjCoreVersion: String by project
val assertjJodaTimeVersion: String by project
val assertjDbVersion: String by project
val assertjGuavaVersion: String by project
val version: String by project
val releaseBranch: String by project
val junit4Version: String by project
val junit5Version: String by project

dependencies {
	testImplementation("org.assertj:assertj-core:$assertjCoreVersion")
	testImplementation("org.assertj:assertj-joda-time:$assertjJodaTimeVersion")
	testImplementation("org.assertj:assertj-db:$assertjDbVersion")
	testImplementation("junit:junit:$junit4Version")
	testImplementation("org.junit.jupiter:junit-jupiter-api:$junit5Version")
	testImplementation("org.junit.jupiter:junit-jupiter-params:$junit5Version")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junit5Version")
}

extra["docsVersion"] = if (version.contains("SNAPSHOT")) "snapshot" else version
extra["generatedAsciiDocPath"] = buildDir.toPath().resolve("generated/asciidoc")

tasks {
	withType<Test> {
		useJUnitPlatform()

		testLogging {
			events("passed", "skipped", "failed")
		}

		reports {
			html.required.set(true)
		}
	}

	withType<AsciidoctorTask> {
		baseDirFollowsSourceFile()

		sources {
			include("**/index.adoc")
		}

		resources(delegateClosureOf<CopySpec> {
			from(sourceDir) {
				include("**/images/**")
				include("**/highlight/**")
				include("**/tocbot-3.0.2/**")
				include("**/*.css")
				include("**/font-awesome/css/*.css")
				include("**/javadoc/**")
				include("**/reports/**")
			}
		})

		attributes(
			mapOf(
				"release-branch" to releaseBranch,
				"docs-version" to ext["docsVersion"],
				"revnumber" to version,
				"releaseBranch" to version,
				"testDir" to "../../../test/java",
				"outdir" to outputDir.absolutePath,
				"source-highlighter" to "highlightjs",
				"highlightjsdir" to "highlight",
				"highlightjs-theme" to "railscasts",
				"tabsize" to "3",
				"toc" to "left",
				"icons" to "font",
				"sectanchors" to true,
				"idprefix" to "",
				"idseparator" to "-",
				"assertj-core-version" to assertjCoreVersion,
				"assertj-guava-version" to assertjGuavaVersion,
				"assertj-joda-time-version" to assertjJodaTimeVersion,
				"assertj-db-version" to assertjDbVersion,
				"stylesheet" to "../../../docs/asciidoc/asciidoctor.css",
				"docinfo" to "shared"
			)
		)
	}
}

asciidoctorj {
	modules {
		diagram.use()
	}
}

gitPublish {
	repoUri.set("https://github.com/assertj/doc.git")
	branch.set("gh-pages")
	contents {
		from(file("$buildDir/asciidoc/user-guide"))
	}
}

repositories {
	mavenCentral()
}