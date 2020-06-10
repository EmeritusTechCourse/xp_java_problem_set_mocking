package com.galvanize.curriculum.xp.orm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class OrmTest {

    @Test
    public void blackBoxTestSaveAndLoad() {
        // Setup
        Orm orm = new Orm(new SuperComplexDriver());
        Object expected = "test";
        int id = expected.hashCode();

        // Setup & exercise
        orm.save(expected);
        Object actual = orm.get(id);

        // Assert
        assertEquals(expected, actual, "Orm should save and load");
    }
}
