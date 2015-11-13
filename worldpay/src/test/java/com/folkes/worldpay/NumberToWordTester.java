package com.folkes.worldpay;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.folkes.worldpay.renderer.NumberToWordRenderer;
import com.folkes.worldpay.renderer.Renderer;

public class NumberToWordTester {
    
    private Renderer renderer;
    private NumberToWord numberWord;
    
    @Before
    public void setUp() throws Exception {
        renderer = new NumberToWordRenderer();
        numberWord = new NumberToWord(renderer);
    }
    
    @Test
    public void givenNumber_shouldReturnCorrectStringRepresentation() {
        assertEquals("five", numberWord.checkNumber(5));
        assertEquals("three", numberWord.checkNumber(3));
        assertNotEquals("seven", numberWord.checkNumber(4));
        assertEquals("nineteen", numberWord.checkNumber(19));
        assertEquals("twenty", numberWord.checkNumber(20));
    }
    
    @Test
    public void givenNumberSequence_shouldReturnConcatenatedString() {
        assertEquals("forty five", getNumberAsWord(45));
        assertEquals("ninety nine", getNumberAsWord(99));
        assertEquals("nine hundred and ninety nine", getNumberAsWord(999));
        assertEquals("one thousand two hundred and thirty four", getNumberAsWord(1_234));
        assertEquals("one million and six", getNumberAsWord(1_000_006));
        assertEquals("one thousand and five", getNumberAsWord(1005));
        assertEquals("ninety nine thousand four hundred and fifty six", getNumberAsWord(99_456));
    }

    @Test
    public void integration() {
        assertEquals("nine hundred and ninety nine million nine hundred and ninety nine "
                + "thousand nine hundred and ninety nine", getNumberAsWord(999_999_999));
    }

    private String getNumberAsWord(int number) {
        return renderer.getStringValue(number);
    }
}
