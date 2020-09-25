package com.cart.biller.model;

public class ShoppingCart {
    private CustomerTypeEnum customerTypeEnum;
    private double totalCost;

    public ShoppingCart(CustomerTypeEnum customerTypeEnum, double totalCost) {
        this.customerTypeEnum = customerTypeEnum;
        this.totalCost = totalCost;
    }

    public CustomerTypeEnum getCustomerTypeEnum() {
        return customerTypeEnum;
    }

    public void setCustomerTypeEnum(CustomerTypeEnum customerTypeEnum) {
        this.customerTypeEnum = customerTypeEnum;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
