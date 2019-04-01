package com.mobiquityinc.dto;

public class PackageThingsDto {

    private int indexNo;
    private int weight;
    private int price;
    private String currency;

    public int getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(final int indexNo) {
        this.indexNo = indexNo;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(final int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(final int price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(final String currency) {
        this.currency = currency;
    }
}
