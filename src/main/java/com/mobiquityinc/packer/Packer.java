package com.mobiquityinc.packer;

import java.util.ArrayList;
import java.util.List;

import com.mobiquityinc.common.InputConverter;
import com.mobiquityinc.common.InputFileReader;
import com.mobiquityinc.common.InputValidator;
import com.mobiquityinc.dto.PackageDto;
import com.mobiquityinc.exception.APIException;

public class Packer {


    public static String pack(String filePath) throws APIException {
        List<PackageDto> packageDtoList = readAndExtractDataToPack(filePath);
        System.out.println(packageDtoList);
        return "";
    }

    private static List<PackageDto> readAndExtractDataToPack(String filePath){
        List<PackageDto> response = new ArrayList<>();
        List<String> inputStringList  = InputFileReader.readInputFile(filePath);
        boolean inputValid;
        for(String inputString : inputStringList){
            inputValid = InputValidator.validateInput(inputString);
            if(!inputValid){
                throw new APIException("Input in file is not correct."+inputString);
            }else{
                PackageDto packageDto = InputConverter.convertIntoPackageDto(inputString);
                response.add(packageDto);
            }
        }
        return response;
    }

}
