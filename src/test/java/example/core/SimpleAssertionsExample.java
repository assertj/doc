package example.core;

// tag::user_guide[]
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class SimpleAssertionsExample {

  @Test
  void a_few_simple_assertions() {
    assertThat("The Lord of the Rings").isNotNull()  // <1> <2>
                                       .startsWith("The") // <3>
                                       .contains("Lord") // <3>
                                       .endsWith("Rings"); // <3>
  }

}
// end::user_guide[]
