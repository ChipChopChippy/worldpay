package com.folkes.worldpay.verify;

import static com.folkes.worldpay.constants.InputValues.MAX_VALUE;
import static com.folkes.worldpay.constants.InputValues.MIN_VALUE;
import static com.folkes.worldpay.exception.ThrowableCaptor.thrownBy;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.folkes.worldpay.NumberToWord;
import com.folkes.worldpay.renderer.NumberToWordRenderer;
import com.folkes.worldpay.renderer.Renderer;

public class VerifyParametersTester {

    private Renderer renderer;
    private NumberToWord numberWord;
    
    @Before
    public void setUp() throws Exception {
        renderer = new NumberToWordRenderer();
        numberWord = new NumberToWord(renderer);
    }
    
    @Test
    public void rendererShouldNotBeNull() {
        Renderer render = null;
        NumberToWord word = new NumberToWord(render);
        Throwable actual = thrownBy(() -> word.checkNumber(MIN_VALUE.getValue()));
        String message = actual.getMessage();
        assertNotNull(message);
        assertEquals("You must pass in a valid renderer", message);
        assertTrue(actual instanceof IllegalArgumentException);
    }
    
    @Test
    public void givenLessThanZero_shouldReturnException() {
        Throwable actual = thrownBy(() -> numberWord.checkNumber(MIN_VALUE.getValue() - 1));
        String message = actual.getMessage();
        assertNotNull(message);
        assertEquals("Number must not be less than: " + MIN_VALUE.getValue(), message);
        assertTrue(actual instanceof IllegalArgumentException);  
    }
    
    @Test
    public void givenGreaterThanMaxValue_shouldReturnException() {
        Throwable actual = thrownBy(() -> numberWord.checkNumber(MAX_VALUE.getValue() + 1));
        String message = actual.getMessage();
        assertNotNull(message);
        assertEquals("Number must not be greater than: " + MAX_VALUE.getValue(), message);
        assertTrue(actual instanceof IllegalArgumentException);  
    }
    
    @Test
    public void givenAnInputOfZero_shouldReturnZero() {
        assertEquals("zero", numberWord.checkNumber(MIN_VALUE.getValue()));
    }
}
