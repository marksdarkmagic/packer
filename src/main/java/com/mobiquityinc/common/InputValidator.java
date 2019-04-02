package com.mobiquityinc.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*this checks that the input data is in the correct format
  when this passes then i know down the line i wont have issues with the data*/
public class InputValidator {
    /*this req ex pattern is what makes the magic happen. i made it so that spaces is ignored*/
    private static final String inputFilePattern = "^\\d{1,3}\\s*:{1}\\s*(\\(\\d+,{1}\\d+.?\\d*,{1}\\u20AC{1}\\d+\\)\\s*){1,15}";

    public static boolean validateInput(String inputLine){
        boolean response;
        Pattern pattern = Pattern.compile(inputFilePattern);
        Matcher matcher = pattern.matcher(inputLine);
        response = matcher.matches();
        return response;
    }

}
