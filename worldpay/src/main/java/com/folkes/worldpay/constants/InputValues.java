package com.folkes.worldpay.constants;

public enum InputValues {

    MAX_VALUE(999_999_999), MIN_VALUE(0);

    private int value;

    private InputValues(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}