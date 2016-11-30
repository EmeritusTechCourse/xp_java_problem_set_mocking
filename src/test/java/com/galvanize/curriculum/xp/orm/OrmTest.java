package com.galvanize.curriculum.xp.orm;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OrmTest {

    @Test
    public void utilizesDriverToSaveObject() {
        // Setup
        MockDriver mockDriver = new MockDriver();
        Orm orm = new Orm(mockDriver);

        // Exercise
        orm.save("A Test String");

        // Assert
        assertThat(mockDriver.saveCalls.size(), is(1));
        assertThat(mockDriver.saveCalls.get(0), is("A Test String"));
    }

    @Test
    public void utilizesDriverToGetObject() {
        // Setup
        MockDriver mockDriver = new MockDriver();
        mockDriver.getWillReturn = "Fake Return Value";
        Orm orm = new Orm(mockDriver);

        // Exercise
        Object retrievedValue = orm.get(42);

        // Assert
        assertThat(mockDriver.getCalls.size(), is(1));
        assertThat(mockDriver.getCalls.get(0), is(42));
        assertThat(retrievedValue, is("Fake Return Value"));
    }
}
