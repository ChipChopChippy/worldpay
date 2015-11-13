package com.folkes.worldpay.constants;

public enum StringValuesLtTwenty implements StringValue {
    ZERO(0, "zero"),
    ONE(1, "one"),
    TWO(2, "two"),
    THREE(3, "three"),
    FOUR(4, "four"),
    FIVE(5, "five"),
    SIX(6, "six"),
    SEVEN(7, "seven"),
    EIGHT(8, "eight"),
    NINE(9, "nine"),
    TEN(10, "ten"),
    ELEVEN(11, "eleven"),
    TWELVE(12, "twelve"),
    THIRTEEN(13, "thirteen"),
    FOURTEEN(14, "fourteen"),
    FIFTEEN(15, "fifteen"),
    SIXTEEN(16, "sixteen"),
    SEVENTEEN(17, "seventeen"),
    EIGHTEEN(18, "eighteen"),
    NINETEEN(19, "nineteen");

    private int number;
    private String stringValue;
    
    private StringValuesLtTwenty(int number, String stringValue) {
        this.number = number;
        this.stringValue = stringValue;
    }
    
    @Override
    public int getNumber() {
        return this.number;
    }
    
    @Override
    public String getStringValue() {
        return this.stringValue;
    }     
}
