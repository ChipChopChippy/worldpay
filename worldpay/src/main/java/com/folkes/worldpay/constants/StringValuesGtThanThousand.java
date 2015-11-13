package com.folkes.worldpay.constants;

public enum StringValuesGtThanThousand implements StringValue {
    THOUSAND(1_000, "thousand"),
    MILLION(1_000_000, "million");

    private int number;
    private String stringValue;
    
    private StringValuesGtThanThousand(int number, String stringValue) {
        this.number = number;
        this.stringValue = stringValue;
    }
    
    @Override
    public String getStringValue() {
        return this.stringValue;
    }

    @Override
    public int getNumber() {
        return this.number;
    }

}
