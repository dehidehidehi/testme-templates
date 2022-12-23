package example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SampleClassTest {

    SampleClass sampleClass = new SampleClass("big", 0d, Short.valueOf((short) 0));

    @Test
    void testGetBig() {
        String result = sampleClass.getBig();
        Assertions.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    void testGetTheDouble() {
        double result = sampleClass.getTheDouble();
        Assertions.assertEquals(0d, result);
    }

    @Test
    void testGetTheShort() {
        Short result = sampleClass.getTheShort();
        Assertions.assertEquals(Short.valueOf((short) 0), result);
    }
}
