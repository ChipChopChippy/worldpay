package com.folkes.worldpay;

import com.folkes.worldpay.renderer.Renderer;
import com.folkes.worldpay.verify.VerifyParameters;

/**
 * Takes an int value between 0 and 999,999,999 and returns a String representation of
 * the int. For example and input of 1105 would return one thousand one hundred and five.
 * The default implementation is restricted to British English, however by injecting in 
 * a alternative renderer (default is NumberToWordRenderer) the behaviour may be altered.  
 * @author Duncan
 *
 */
public class NumberToWord {
    
    private Renderer renderer;
    private VerifyParameters verifier;
    
    public NumberToWord(Renderer renderer) {
        this.renderer = renderer;
        this.verifier = new VerifyParameters();
    }
      
    public String checkNumber(int number) {
        verifier.checkRenderer(renderer);
        verifier.checkInputParameter(number);
        return renderer.getStringValue(number);
    }
}
