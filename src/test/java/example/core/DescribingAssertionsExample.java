package example.core;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class DescribingAssertionsExample {

  @Test
  void describing_assertions() {
// tag::user_guide[]
    TolkienCharacter frodo = TolkienCharacter("Frodo", 33, HOBBIT);
    // failing assertion, remember to call as() before the assertion, not after !
    assertThat(frodo.getAge()).as("check %s's age", frodo.getName())
                              .isEqualTo(100);
// end::user_guide[]
  }

}
