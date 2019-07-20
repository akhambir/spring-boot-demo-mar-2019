package com.akhambir.tdd.lesson;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MyClassTest {

    @Mock
    private MyClassCollaborator mcc;
    @InjectMocks
    private MyClass myClass;

    @Test
    public void testSum() {
        int expectedResult = 10;
        int actualResult = myClass.sum(5, 5);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testStringExtension() {
        String s = "test";
        String m = "mock";
        String expectedResult = m.concat(s);
        when(mcc.getSomeString()).thenReturn(m);
        String actualResult = myClass.extendString(s);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testMockStringAsParam() {
        String m = "mock";
        when(mcc.replaceAWith2(any(String.class))).thenReturn(m);
        assertEquals(m, myClass.replaceChars(m));
    }
}
