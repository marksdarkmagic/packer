package com.mobiquityinc.packer;

import java.util.Collections;
import java.util.List;

import static com.mobiquityinc.packer.Packer.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.mobiquityinc.exception.APIException;
import org.junit.Test;

public class PackerTest {

    @Test
    public void readInputFileIntoStringList() {
        String absoluteFilePath = "C:\\AAA\\Code\\DO\\Packer\\packages.txt";
        List<String> response = readInputFile(absoluteFilePath);
        assertTrue( !response.isEmpty() );
    }

    @Test(expected = APIException.class)
    public void readNonExistingInputFile() {
        List<String> response = readInputFile("C:\\AAA\\Code\\DO\\Packer\\nonexist.txt");
    }

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
        String sixteenBrackets = "81 : (1,53.38,€45) (1,53.38,€45) (1,53.38,€45) (1,53.38,€45) " +
                                        "(1,53.38,€45) (1,53.38,€45) (1,53.38,€45) (1,53.38,€45) " +
                                        "(1,53.38,€45) (1,53.38,€45) (1,53.38,€45) (1,53.38,€45) " +
                                        "(1,53.38,€45) (1,53.38,€45) (1,53.38,€45) (1,53.38,€45)";
        assertFalse(validateInput(missingSecondMiddle));
        assertFalse(validateInput(missingColon));
        assertFalse(validateInput(missingCurrency));
        assertFalse(validateInput(missingSecondCurrency));
        assertFalse(validateInput(missingValueInBrackets));
        assertFalse(validateInput(missingBrackets));
        assertFalse(validateInput(sixteenBrackets));
    }

}
