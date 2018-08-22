# AssertJ User Guide

This subproject contains the AsciiDoc sources for the AssertJ User Guide.
The guide is available here: https://assertj.github.io/doc/

## Structure

- `src/docs/asciidoc`: AsciiDoc files
- `src/test/java`: Java test source code that can be included in the AsciiDoc files
- `src/test/resources`: Classpath resources that can be included in the AsciiDoc files or
  used in tests

## Usage

### Generate AsciiDoc

This following Gradle command generates the HTML version of the User Guide as
`build/asciidoc/index.html`.

```bash
gradlew asciidoctor
```
