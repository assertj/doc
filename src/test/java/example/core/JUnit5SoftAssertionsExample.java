package example.core;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.assertj.core.api.BDDSoftAssertions;
import org.assertj.core.api.SoftAssertions;

// tag::junit5-soft-assertions[]
@ExtendWith(SoftAssertionsParameterResolver.class)
public class JUnit5SoftAssertionsExample {

  @Test
  void junit5_soft_assertions_example(SoftAssertions softly) {
    softly.assertThat("George Martin").as("great authors").isEqualTo("JRR Tolkien");
    softly.assertThat(42).as("response to Everything").isGreaterThan(100);
    softly.assertThat("Gandalf").isEqualTo("Sauron");
    // No need to call softly.assertAll(), this is automatically done by the SoftAssertionsParameterResolver extension
  }

  @Test
  void junit5_bdd_soft_assertions_example(BDDSoftAssertions softly) {
    softly.then("George Martin").as("great authors").isEqualTo("JRR Tolkien");
    softly.then(42).as("response to Everything").isGreaterThan(100);
    softly.then("Gandalf").isEqualTo("Sauron");
    // No need to call softly.assertAll(), this is automatically done by the SoftAssertionsParameterResolver extension
  }

}
// end::junit5-soft-assertions[]
