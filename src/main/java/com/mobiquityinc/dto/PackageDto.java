package com.mobiquityinc.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mobiquityinc.common.SortByIndexNo;
/*this DTO represents the box. its got the weight limit and stuff you can put inside called packageThings
* this is used to represent the input and then later the solution*/
public class PackageDto {

    private int weightLimit;
    private List<PackageThingsDto> packageThings;

    public PackageDto(){};

    public PackageDto(List<PackageThingsDto> packageThings,int weightLimit){
        this.weightLimit = weightLimit;
        this.packageThings = packageThings;
    }

    public int getWeightLimit() {
        return weightLimit;
    }

    public void setWeightLimit(final int weightLimit) {
        this.weightLimit = weightLimit;
    }

    public List<PackageThingsDto> getPackageThings() {
        if(packageThings == null){
            packageThings = new ArrayList<>();
        }
        return packageThings;
    }


    /*I did this to make it easy to print the index numbers with commas*/
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(!packageThings.isEmpty()) {
            Collections.sort(packageThings,new SortByIndexNo());
            for (PackageThingsDto item : packageThings) {
                sb.append(item.getIndexNo()+",");
            }
            sb.deleteCharAt(sb.length()-1);
        }else{
            sb.append("-");
        }
        return sb.toString();
    }


}
