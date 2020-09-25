package com.cart.biller.model;

import java.util.List;

public enum CustomerTypeEnum {
    REGULAR, PREMIUM;
    private String customerType;
    private List<DiscountSlab> discountSlabs;

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public List<DiscountSlab> getDiscountSlabs() {
        return discountSlabs;
    }

    public void setDiscountSlabs(List<DiscountSlab> discountSlabs) {
        this.discountSlabs = discountSlabs;
    }
}
