package com.mobiquityinc.common;

import java.util.Comparator;

import com.mobiquityinc.dto.PackageThingsDto;

/*created this comparator to sort the index in order for the output to be in ascending order*/
public class SortByIndexNo implements Comparator<PackageThingsDto> {

    @Override
    public int compare(final PackageThingsDto o1, final PackageThingsDto o2) {
        return o1.getIndexNo()-o2.getIndexNo();
    }
}
