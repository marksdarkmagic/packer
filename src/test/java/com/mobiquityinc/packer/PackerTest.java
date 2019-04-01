package com.mobiquityinc.packer;

import org.junit.Test;

public class PackerTest {

    @Test
    public void testPack(){
        String results = Packer.pack("C:\\AAA\\Code\\DO\\Packer\\packages.txt");
        System.out.println(results);
    }

}
