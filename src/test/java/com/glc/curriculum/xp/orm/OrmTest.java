package com.glc.curriculum.xp.orm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class OrmTest {

    // @Test
    // public void blackBoxTestSaveAndLoad() {
    //     // Setup
    //     Orm orm = new Orm(new SuperComplexDriver());
    //     Object expected = "test";
    //     int id = expected.hashCode();

    //     // Setup & exercise
    //     orm.save(expected);
    //     Object actual = orm.get(id);

    //     // Assert
    //     assertEquals(expected, actual, "Orm should save and load");
    // }

    @Test
    public void utilizesDriverToSaveObject() {
        Driver mockDriver = mock(Driver.class);
        Orm orm = new Orm(mockDriver);
        orm.save("A Test String");
        then(mockDriver).should(times(1)).save("A Test String");
        // orm.save("A Different String");
        // then(mockDriver).should(times(1)).save("A Different String");
        // orm.save(new int[] {1,2,3});
        // then(mockDriver).should(times(3)).save(any());
        // then(mockDriver).should(times(1)).save(new int[] {1,2,3});
    }

    @Test
    public void utilizesDriverToGetObject(){
        Driver mockDriver = mock(Driver.class);
        given(mockDriver.get(anyInt())).willReturn("Fake Return Value");
        Orm orm = new Orm(mockDriver);
        Object retrievedValue = orm.get(42);
        then(mockDriver).should(times(1)).get(42);
        // assertEquals("Fake Return Value", retrievedValue);
        // Object anotherValue = orm.get(99);
        // then(mockDriver).should(times(2)).get(anyInt());
        // then(mockDriver).should(times(1)).get(99);
        // assertEquals("Fake Return Value", anotherValue);

        
    }
}
