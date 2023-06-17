/*----------------------------------------------------------------------
	FILE        : Card.java
	AUTHOR		: Baris Er
	LAST UPDATE	: 17.06.2023

	Card class

	Copyleft (c) 2023 by Baris ER
	All Rights Free
-----------------------------------------------------------------------*/
package com.erbaris.PaymentCard.entity;

import org.csystem.util.numeric.NumberUtil;

public class Card {
    public long cardNumber;
    public int bankId;
    public int cardTypeCode;
    public int cardSerialNumber;
    private final int[] digits;

    public Card(long cardNumber) {
        if(NumberUtil.countDigits(cardNumber) != 16)
            throw new IllegalArgumentException("Card Number must be 16 digit");
        this.cardNumber = cardNumber;

        digits = NumberUtil.getDigits(cardNumber);

        for(int i = 0; i < 6; i++){
            bankId += digits[i] * (int)Math.pow(10, 5 - i);
        }

        cardTypeCode = 10 * digits[6] + digits[7];

        for(int i = 8; i < 16; i++){
            cardSerialNumber += digits[i] * (int)Math.pow(10, 14 - i);
        }

    }

    private int sumOfDoubleSecondDigits()
    {
        int sum = 0;

        for(int i = 0; i < digits.length; i += 2){
            int tmp = digits[i] * 2;
            if(tmp > 9)
                sum += tmp - 9;
            else
                sum += tmp;
        }

        return sum;
    }

    private int sumOfOddDigits()
    {
        int sum = 0;

        for(int i = 1; i < digits.length; i += 2){
            sum += digits[i];
        }

        return sum;
    }
    private int sumAllDigits()
    {
        return sumOfDoubleSecondDigits() + sumOfOddDigits();
    }

    public boolean isValid()
    {
        return sumAllDigits() % 10 == 0;
    }

    @Override
    public String toString() {
        return "Card{ cardNumber=" + cardNumber + "}";
    }

    @Override
    public int hashCode() {
        return Long.hashCode(cardNumber);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Card c && c.cardNumber == cardNumber;
    }
}
