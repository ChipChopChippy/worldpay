package com.folkes.worldpay.renderer;

import com.folkes.worldpay.constants.StringValue;
import com.folkes.worldpay.constants.StringValuesGtThanThousand;
import com.folkes.worldpay.constants.StringValuesGtTwenty;
import com.folkes.worldpay.constants.StringValuesLtTwenty;

import static com.folkes.worldpay.constants.InputValues.*;

public class NumberToWordRenderer implements Renderer {

    @Override
    public String getStringValue(int number) {
        String equivalentNumber = convertNumberToWords(number);
        return equivalentNumber.trim();
    }

    @Override
    public String getSimpileStringNumber(int number) {
        String equivalentNumber = "";
        for (StringValue sv : getConstantValues(number)) {
            if (sv.getNumber() == number) {
                equivalentNumber += sv.getStringValue();
            }
        }
        return equivalentNumber.trim();
    }

    private StringValue[] getConstantValues(int number) {
        if (number < 20) {
            return StringValuesLtTwenty.values();
        } else if (number < 1000) {
            return StringValuesGtTwenty.values();
        } else {
            return StringValuesGtThanThousand.values();
        }
    }

    private String convertNumberToWords(int inputNumber) {
        if (inputNumber <= 999) {
            return convertHundreds(inputNumber);
        }
        String numberString = null;
        int intCharacter = 0;
        int number = inputNumber;
        while (number > 0) {
            if (number % 1000 != 0) {
                String workingString = convertHundreds(number % 1000);
                if (intCharacter > 0) {
                    workingString = workingString + " " + getConstant(intCharacter -1);
                }
                if (numberString == null) {
                    numberString = insertAnd(intCharacter, number, workingString);
                } else {
                    numberString = workingString + " " + numberString;
                }
            }
            number /= 1000;
            intCharacter++;
        }
        return numberString;
    }

    private String insertAnd(int intCharacter, int number, String workingString) {
        String numberString;
        if (intCharacter == 0 && number % 1000 < 10) {
            numberString = "and " + workingString;
        } else {
            numberString = workingString;
        }
        return numberString;
    }

    private String getConstant(int intCharacter) {
        return getConstantValues(MAX_VALUE.getValue())[intCharacter].getStringValue();
    }

    private String convertHundreds(int number) {
        String numberString = getSimpileStringNumber(number / 100) + " hundred and";
        String workingString = convertTens(number % 100);
        if (number <= 99) {
            return workingString;
        } else if (number % 100 == 0) {
            return numberString;
        } else {
            return numberString + " " + workingString;
        }
    }

    private String convertTens(int number) {
        if (number < 20) {
            return getSimpileStringNumber(number);
        }
        String numberString = getConstantValues(number)[number / 10 - 2].getStringValue();
        if (number % 10 == 0) {
            return numberString;
        }
        return numberString + " " + getConstantValues(number % 10)[number % 10].getStringValue();
    }
}