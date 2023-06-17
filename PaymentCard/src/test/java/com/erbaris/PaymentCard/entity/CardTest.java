package com.erbaris.PaymentCard.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CardTest {

    @Test
    public void givenCardNumber1_isValidTest()
    {
        long givenCardNumber = 4556_7375_8689_9855L;
        var c = new Card(givenCardNumber);

        Assertions.assertTrue(c.isValid());
    }

    @Test
    public void givenCardNumber2_isNotValidTest()
    {
        long givenCardNumber = 4024_0071_0902_2143L;
        var c = new Card(givenCardNumber);

        Assertions.assertFalse(c.isValid());
    }
}
