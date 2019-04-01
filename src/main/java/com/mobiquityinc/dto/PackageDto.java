package com.mobiquityinc.dto;

import java.util.ArrayList;
import java.util.List;

public class PackageDto {

    private int weightLimit;
    private List<PackageThingsDto> packageThings;

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

}
