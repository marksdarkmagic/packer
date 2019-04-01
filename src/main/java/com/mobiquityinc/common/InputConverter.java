package com.mobiquityinc.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mobiquityinc.dto.PackageDto;
import com.mobiquityinc.dto.PackageThingsDto;

public class InputConverter {

    private static final String thingsPattern = "\\d+,{1}\\d+.?\\d*,{1}€{1}\\d+";
    private static final String weightPattern = "^\\d{1,3}\\s*:{1}";

    public static PackageDto convertIntoPackageDto(String validInputLine){
        PackageDto response = new PackageDto();
        List<String> things = extractThings(validInputLine);
        response.getPackageThings().addAll(convertIntoPackageThings(things));
        response.setWeightLimit(extractMaxWeight(validInputLine));
        return response;
    }

    private static List<PackageThingsDto> convertIntoPackageThings(List<String> thingsList){
        List<PackageThingsDto> response = new ArrayList<>();
        for(String thing: thingsList) {
            PackageThingsDto thingDto = new PackageThingsDto();
            String[] thingDetail = thing.split(",");
            thingDto.setIndexNo(Integer.parseInt(thingDetail[0]));
            String[] itemWeight = thingDetail[1].split("\\.");
            String newItemWeight = itemWeight[0] + (itemWeight[1].length() < 2 ? itemWeight[1]+"0" : itemWeight[1]);
            thingDto.setWeight(Integer.parseInt(newItemWeight));
            String price = thingDetail[2];
            thingDto.setCurrency(price.substring(0,1));
            thingDto.setPrice(Integer.parseInt(price.substring(1,price.length())));
            response.add(thingDto);
        }
        Collections.sort(response,new SortByWeight());
        return response;
    }

    private static int extractMaxWeight(String validInputLine){
        int response = 0;
        Pattern pattern = Pattern.compile(weightPattern);
        Matcher matcher = pattern.matcher(validInputLine);
        if(matcher.find()){
            String weight = matcher.group();
            response = Integer.parseInt(weight.substring(0,weight.indexOf(':')).trim());
        }
        return response*100;
    }

    private static List<String> extractThings(String validInputLine){
        List<String> response = new ArrayList<>();
        Pattern pattern = Pattern.compile(thingsPattern);
        Matcher matcher = pattern.matcher(validInputLine);
        while(matcher.find()){
            response.add(matcher.group());
        }
        return response;
    }

}
