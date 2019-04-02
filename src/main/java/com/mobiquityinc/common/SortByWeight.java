package com.mobiquityinc.common;

import java.util.Comparator;

import com.mobiquityinc.dto.PackageThingsDto;

/*created this comparator to sort the packages by weight in order to pick a lighter object if the value is the same*/
public class SortByWeight implements Comparator<PackageThingsDto> {

    @Override
    public int compare(final PackageThingsDto o1, final PackageThingsDto o2) {
        return o1.getWeight()-o2.getWeight();
    }
}
