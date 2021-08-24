package dev.dgarc.week823challenge;

import org.junit.Test;

import static dev.dgarc.week823challenge.ValidateCreditCard.validateCreditCard;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ValidateCreditCardTest {

    private ValidateCreditCard validateCreditCard;

    @Test
    public void invalidCardIsFalseTest(){
        assertAll(
                () -> assertFalse(validateCreditCard(1234L)),
                () -> assertFalse(validateCreditCard(1234567890123456L))
        );
    }

    @Test
    public void validCardIsTrueTest(){
        assertTrue(validateCreditCard(8067966582689910L));
    }

}
