package com.mobiquityinc.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mobiquityinc.common.SortByIndexNo;

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
