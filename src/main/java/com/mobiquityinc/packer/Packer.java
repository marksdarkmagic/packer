package com.mobiquityinc.packer;

import java.util.ArrayList;
import java.util.List;

import com.mobiquityinc.common.InputConverter;
import com.mobiquityinc.common.InputFileReader;
import com.mobiquityinc.common.InputValidator;
import com.mobiquityinc.dto.PackageDto;
import com.mobiquityinc.dto.PackageThingsDto;
import com.mobiquityinc.exception.APIException;

public class Packer {


    public static String pack(String filePath) throws APIException {
        StringBuilder sb = new StringBuilder();
        List<PackageDto> packageDtoList = readAndExtractDataToPack(filePath);
        for(PackageDto packageDto :packageDtoList) {
            PackageDto result = calc(packageDto.getPackageThings().toArray(new PackageThingsDto[packageDto.getPackageThings().size()]),packageDto.getWeightLimit());
            sb.append(result.toString());
            sb.append(System.getProperty("line.separator"));
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
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

    private static PackageDto calc(PackageThingsDto[] items,int capacity) {
        int NB_ITEMS = items.length;
        // we use a matrix to store the max value at each n-th item
        int[][] matrix = new int[NB_ITEMS + 1][capacity + 1];

        // first line is initialized to 0
        for (int i = 0; i <= capacity; i++)
            matrix[0][i] = 0;

        // we iterate on items
        for (int i = 1; i <= NB_ITEMS; i++) {
            // we iterate on each capacity
            for (int j = 0; j <= capacity; j++) {
                if (items[i - 1].getWeight() > j) {
                    matrix[i][j] = matrix[i - 1][j];
                }else {
                    // we maximize value at this rank in the matrix
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i - 1][j - items[i - 1].getWeight()] + items[i - 1].getPrice());
                }
            }
        }

        int res = matrix[NB_ITEMS][capacity];
        int w = capacity;
        List<PackageThingsDto> itemsSolution = new ArrayList<>();

        for (int i = NB_ITEMS; i > 0  &&  res > 0; i--) {
            if (res != matrix[i-1][w]) {
                itemsSolution.add(items[i-1]);
                // we remove items value and weight
                res -= items[i-1].getPrice();
                w -= items[i-1].getWeight();
            }
        }

        return new PackageDto(itemsSolution, matrix[NB_ITEMS][capacity]);
    }

}