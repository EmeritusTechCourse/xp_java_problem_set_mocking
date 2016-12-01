package com.galvanize.curriculum.xp.orm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class OrmTest {

    @Mock
    Driver mockDriver;

    @Test
    public void utilizesDriverToSaveObject() {
        Orm orm = new Orm(mockDriver);

        orm.save("A Test String");

        then(mockDriver).should(times(1)).save("A Test String");

        orm.save(new int[] { 1, 2, 3});

        then(mockDriver).should(times(2)).save(any());
        then(mockDriver).should(times(1)).save(new int[] { 1, 2, 3});
    }

    @Test
    public void utilizesDriverToGetObject() {
        given(mockDriver.get(anyInt())).willReturn("Fake Return Value");
        Orm orm = new Orm(mockDriver);

        Object retrievedValue = orm.get(42);

        then(mockDriver).should(times(1)).get(42);
        assertThat(retrievedValue, is("Fake Return Value"));

        Object anotherValue = orm.get(99);

        then(mockDriver).should(times(2)).get(anyInt());
        then(mockDriver).should(times(1)).get(99);
        assertThat(anotherValue, is("Fake Return Value"));
    }
}
