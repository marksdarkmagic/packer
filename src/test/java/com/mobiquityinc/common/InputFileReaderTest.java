package com.mobiquityinc.common;

import java.util.List;
import com.mobiquityinc.exception.APIException;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class InputFileReaderTest {

    @Test
    public void readInputFileIntoStringList() {
        String absoluteFilePath = "C:\\AAA\\Code\\DO\\Packer\\packages.txt";
        List<String> response = InputFileReader.readInputFile(absoluteFilePath);
        assertTrue( !response.isEmpty() );
    }

    @Test(expected = APIException.class)
    public void readNonExistingInputFile() {
        List<String> response = InputFileReader.readInputFile("C:\\AAA\\Code\\DO\\Packer\\nonexist.txt");
    }
}
