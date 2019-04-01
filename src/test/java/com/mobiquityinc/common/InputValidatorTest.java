package com.mobiquityinc.common;

import org.junit.Test;

import static com.mobiquityinc.common.InputValidator.validateInput;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InputValidatorTest {

    @Test
    public void validateCorrectInput(){
        String normal = "81 : (1,53.38,€45) (2,88.62,€98)";
        String noSpaces = "81:(1,53.38,€45)(2,88.62,€98)";
        String tabSpaces = "81  :   (1,53.38,€45)   (2,88.62,€98)";
        String fifteenBrackets = "81 : (1,53.38,€45) (1,53.38,€45) (1,53.38,€45) (1,53.38,€45) " +
                "(1,53.38,€45) (1,53.38,€45) (1,53.38,€45) (1,53.38,€45) " +
                "(1,53.38,€45) (1,53.38,€45) (1,53.38,€45) (1,53.38,€45) " +
                "(1,53.38,€45) (1,53.38,€45) (1,53.38,€45)";
        assertTrue(validateInput(normal));
        assertTrue(validateInput(noSpaces));
        assertTrue(validateInput(tabSpaces));
        assertTrue(validateInput(fifteenBrackets));
    }

    @Test
    public void validateIncorrectInput(){
        String missingSecondMiddle = "81 : (1,53.38,€45) (2,,€98)";
        String missingColon = "81  (1,53.38,€45) (2,53.38,€98)";
        String missingCurrency = "81 : (1,53.38,45) (2,53.38,€98)";
        String missingSecondCurrency = "81 : (1,53.38,€45) (2,53.38,98)";
        String missingValueInBrackets = "81 : (53.38,€45) (2,53.38,€98)";
        String missingBrackets = "81 : ";
        String tooManyCommas = "81 : (1,,53.38,€45) ";
        String sixteenBrackets = "81 : (1,53.38,€45) (1,53.38,€45) (1,53.38,€45) (1,53.38,€45) " +
                "(1,53.38,€45) (1,53.38,€45) (1,53.38,€45) (1,53.38,€45) " +
                "(1,53.38,€45) (1,53.38,€45) (1,53.38,€45) (1,53.38,€45) " +
                "(1,53.38,€45) (1,53.38,€45) (1,53.38,€45) (1,53.38,€45)";
        String missingLimit = " : (1,53.38,€45) (2,88.62,€98)";
        assertFalse(validateInput(missingSecondMiddle));
        assertFalse(validateInput(missingColon));
        assertFalse(validateInput(missingCurrency));
        assertFalse(validateInput(missingSecondCurrency));
        assertFalse(validateInput(missingValueInBrackets));
        assertFalse(validateInput(missingBrackets));
        assertFalse(validateInput(tooManyCommas));
        assertFalse(validateInput(sixteenBrackets));
        assertFalse(validateInput(missingLimit));
    }

}
