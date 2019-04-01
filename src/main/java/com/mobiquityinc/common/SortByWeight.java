package com.mobiquityinc.common;

import java.util.Comparator;

import com.mobiquityinc.dto.PackageThingsDto;

public class SortByWeight implements Comparator<PackageThingsDto> {

    @Override
    public int compare(final PackageThingsDto o1, final PackageThingsDto o2) {
        return o1.getWeight()-o2.getWeight();
    }
}
