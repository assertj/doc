package example.db;

// tag::user_guide[]
import static org.assertj.db.api.Assertions.assertThat;

import org.assertj.db.type.DateValue;
import org.assertj.db.type.Source;
import org.assertj.db.type.Table;

// end::user_guide[]

import org.junit.jupiter.api.Test;

public class TableAssertionExamples {

    private Source dataSource;

    /**
     * This example shows a simple case of test.
     */
    @Test
    public void basic_table_assertion_examples() {
// tag::user_guide[]
Table table = new Table(dataSource, "members");

// Check column "name" values
assertThat(table).column("name")
        .value().isEqualTo("Hewson")
        .value().isEqualTo("Evans")
        .value().isEqualTo("Clayton")
        .value().isEqualTo("Mullen");

// Check row at index 1 (the second row) values
assertThat(table).row(1)
        .value().isEqualTo(2)
        .value().isEqualTo("Evans")
        .value().isEqualTo("David Howell")
        .value().isEqualTo("The Edge")
        .value().isEqualTo(DateValue.of(1961, 8, 8))
        .value().isEqualTo(1.77);
// end::user_guide[]
    }
}
