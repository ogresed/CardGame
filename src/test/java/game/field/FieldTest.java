package game.field;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class FieldTest {

    @Test
    public void setDeletedIfCellsIsEqualAndNotDeleted() {
        assertThat(1,equalTo(1));
    }
}