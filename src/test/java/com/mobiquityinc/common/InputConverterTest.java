package com.mobiquityinc.common;

import com.mobiquityinc.dto.PackageDto;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class InputConverterTest {

    @Test
    public void inputConverterTest(){
        PackageDto packageDto = InputConverter.convertIntoPackageDto("81 : (1,53.38,€45) (2,88.62,€98)");
        assertTrue(packageDto.getPackageThings().size() == 2);
        assertTrue(packageDto.getWeightLimit() == 81);
    }

}
