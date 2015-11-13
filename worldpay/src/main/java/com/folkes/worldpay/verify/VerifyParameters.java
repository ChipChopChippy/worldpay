package com.folkes.worldpay.verify;

import static com.folkes.worldpay.constants.InputValues.MAX_VALUE;
import static com.folkes.worldpay.constants.InputValues.MIN_VALUE;

import com.folkes.worldpay.renderer.Renderer;

public class VerifyParameters {
    public void checkInputParameter(int number) {
        if (number < MIN_VALUE.getValue()) {
            throw new IllegalArgumentException("Number must not be less than: " + MIN_VALUE.getValue());
        } else if (number > MAX_VALUE.getValue()) {
            throw new IllegalArgumentException("Number must not be greater than: " + MAX_VALUE.getValue());
        }
    }

    public void checkRenderer(Renderer renderer) {
        if (renderer == null) {
            throw new IllegalArgumentException("You must pass in a valid renderer");
        }
    }
}
