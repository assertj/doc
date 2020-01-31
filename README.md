# AssertJ User Guide
[![Publish](https://github.com/assertj/doc/workflows/Publish/badge.svg)](https://github.com/assertj/doc/actions?query=workflow%3APublish) 

The AssertJ User Guide is available here: https://assertj.github.io/doc/

This project contains the AsciiDoc sources for the guide.

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
