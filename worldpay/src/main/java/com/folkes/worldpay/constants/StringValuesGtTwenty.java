package com.folkes.worldpay.constants;


public enum StringValuesGtTwenty implements StringValue {
    TWENTY(20, "twenty"),
    THIRTY(30, "thirty"),
    FORTY(40, "forty"),
    FIFTY(50, "fifty"),
    SIXTY(60, "sixty"),
    SEVENTY(70, "seventy"),
    EIGHTY(80, "eighty"),
    NINETY(90, "ninety");
    
    private int number;
    private String stringValue;

    private StringValuesGtTwenty(int number, String stringValue) {
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
