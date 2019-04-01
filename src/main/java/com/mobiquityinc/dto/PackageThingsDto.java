package com.mobiquityinc.dto;

public class PackageThingsDto {

    private int indexNo;
    private double weight;
    private double price;
    private String currency;

    public int getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(final int indexNo) {
        this.indexNo = indexNo;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(final double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(final String currency) {
        this.currency = currency;
    }
}
