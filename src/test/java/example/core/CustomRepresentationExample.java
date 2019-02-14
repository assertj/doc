package example.core;

import static org.assertj.core.api.Assertions.assertThat;
import example.data.Race;

import org.assertj.core.api.Assertions;
import example.data.TolkienCharacter;
import org.junit.jupiter.api.Test;

public class CustomRepresentationExample {

  @Test
  void overriding_assertion_error_message() {
    try {
      // tag::user_guide[]
      Assertions.useRepresentation(new CustomRepresentation());
      TolkienCharacter frodo = new TolkienCharacter("Frodo", 33, Race.HOBBIT);
      assertThat(frodo).isNull();
      // end::user_guide[]
    } catch (AssertionError error) {
      System.out.println(error.getMessage());
    }
  }

}
