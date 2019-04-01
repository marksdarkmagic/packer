package com.mobiquityinc.packer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mobiquityinc.dto.PackageDto;
import com.mobiquityinc.dto.PackageThingsDto;
import com.mobiquityinc.exception.APIException;
import org.apache.commons.lang3.StringUtils;

public class Packer {

    private static final String delimiter = ",";

    public static String pack(String filePath) throws APIException {
        List<String> packages = readInputFile(filePath);
       return "";
    }

    static List<String> readInputFile(String filePath){
        List<String> response;
        try(BufferedReader br = new BufferedReader(new FileReader(new File(filePath)))) {
            String lineItem;
            response = new ArrayList<>();
            while ((lineItem = br.readLine()) != null) {
                response.add(lineItem);
            }
        } catch (Exception ex) {
            throw new APIException("Error reading file", ex);
        }
        return response;
    }

    static boolean validateInput(String inputLine){
        boolean response;
        String inputFilePattern = "^\\d{1,3}\\s*:{1}\\s*(\\(\\d+,+\\d+.?\\d*,+€{1}\\d+\\)\\s*){1,15}";
        Pattern pattern = Pattern.compile(inputFilePattern);
        Matcher matcher = pattern.matcher(inputLine);
        response = matcher.matches();
        return response;
    }

    static List<PackageDto> convertInputToObjects(List<String> inputList){
        List<PackageDto> response = new ArrayList<>();
        for(String input : inputList){
            PackageDto packageDto = new PackageDto();
            packageDto.setWeightLimit(retrievePackageWeight(input));
            List<String> thingsList = retrievePackageThings(input);
            for(String things : thingsList) {
                String[] thingDetails = things.split(delimiter);
                PackageThingsDto packageThingsDto = new PackageThingsDto();
                packageThingsDto.setIndexNo(Integer.parseInt(thingDetails[0]));
                packageThingsDto.setWeight(Integer.parseInt(thingDetails[1]));
                packageThingsDto.setPrice(Double.parseDouble(thingDetails[2]));
                packageDto.getPackageThings().add(packageThingsDto);
            }
            response.add(packageDto)  ;
        }

        return response;
    }

    private static int retrievePackageWeight(String lineItem){
        int response;
        String weightLimit = StringUtils.substringBefore(lineItem,":").trim();
        response = Integer.parseInt(weightLimit);
        return response;
    }

    private static List<String> retrievePackageThings(String lineItem){
        String[] response = StringUtils.substringsBetween(lineItem, "(", ")");
        return Arrays.asList(response);
    }

}
