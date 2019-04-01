package com.mobiquityinc.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.mobiquityinc.exception.APIException;

public class InputFileReader {

    public static List<String> readInputFile(String filePath){
        List<String> response;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"UTF-8"))) {
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
}
