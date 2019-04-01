package com.mobiquityinc.packer;

import org.junit.Test;

public class PackerTest {

    @Test
    public void testPack(){
        String results = Packer.pack("packages.txt");
        System.out.println(results);
    }

}
