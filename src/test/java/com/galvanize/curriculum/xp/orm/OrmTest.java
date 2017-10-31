package com.galvanize.curriculum.xp.orm;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.fail;

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
        Assert.assertEquals("Orm should save and load", expected, actual);
    }
}
