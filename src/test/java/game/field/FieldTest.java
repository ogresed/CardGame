package game.field;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

class FieldTest {

    @Test
    void setDeletedIfCellsIsEqualAndNotDeleted() {
        assertThat(1,equalTo(1));
    }
}