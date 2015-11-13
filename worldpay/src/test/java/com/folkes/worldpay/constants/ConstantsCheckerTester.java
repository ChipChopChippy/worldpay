package com.folkes.worldpay.constants;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConstantsCheckerTester {

    @Test
    public void shouldBePredefinedValuesInEnumConstantGtThousand() {
        assertEquals(2, StringValuesGtThanThousand.values().length);
    }
    
    @Test
    public void givenNumber_shouldReturnCorrectStringFromEnumConstantGtThousand() {
        assertEquals("thousand", StringValuesGtThanThousand.THOUSAND.getStringValue());
    }
    
    @Test
    public void shouldBePredefinedValuesInEnumConstantGtTwenty() {
        assertEquals(8, StringValuesGtTwenty.values().length);
    }
    
    @Test
    public void givenNumber_shouldReturnCorrectStringFromEnumConstantGtTwenty() {
        assertEquals("ninety", StringValuesGtTwenty.NINETY.getStringValue());
    }
    
    @Test
    public void shouldBePredefinedValuesInEnumConstantLtTwenty() {
        assertEquals(20, StringValuesLtTwenty.values().length);
    }
    
    @Test
    public void givenNumber_shouldReturnCorrectStringFromEnumConstantLtTwenty() {
        assertEquals("thirteen", StringValuesLtTwenty.THIRTEEN.getStringValue());
        assertEquals("zero", StringValuesLtTwenty.ZERO.getStringValue());
    }
}
