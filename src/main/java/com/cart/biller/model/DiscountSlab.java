package com.cart.biller.model;

public class DiscountSlab {
    private double minPurchaseValue;
    private double maxPurchaseValue;
    private double discountPercent;

    public DiscountSlab(){}

    public DiscountSlab(double minPurchaseValue, double maxPurchaseValue, double discountPercent){
        this.minPurchaseValue = minPurchaseValue;
        this.maxPurchaseValue = maxPurchaseValue;
        this.discountPercent = discountPercent;
    }

    public double getMinPurchaseValue() {
        return minPurchaseValue;
    }

    public void setMinPurchaseValue(double minPurchaseValue) {
        this.minPurchaseValue = minPurchaseValue;
    }

    public double getMaxPurchaseValue() {
        return maxPurchaseValue;
    }

    public void setMaxPurchaseValue(double maxPurchaseValue) {
        this.maxPurchaseValue = maxPurchaseValue;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }
}
