package com.cart.biller.service;

import com.cart.biller.model.CustomerTypeEnum;
import com.cart.biller.model.DiscountSlab;
import com.cart.biller.model.ShoppingCart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartBillCalculator {
    private static Map<String,CustomerTypeEnum> CustomerDiscountMap = new HashMap<String, CustomerTypeEnum>();
    static {
        CustomerDiscountMap.put("Regular", CustomerTypeEnum.REGULAR);
        CustomerDiscountMap.put("Premium", CustomerTypeEnum.PREMIUM);
    }
    public double calculateBill(ShoppingCart shoppingCart){
        double totalCost = shoppingCart.getTotalCost();
        double totalDiscount = 0;
        List<DiscountSlab> discountSlabs = shoppingCart.getCustomerTypeEnum().getDiscountSlabs();
        for (DiscountSlab discountSlab:discountSlabs){
            double discountPercent = discountSlab.getDiscountPercent()/100;
            if(totalCost>discountSlab.getMaxPurchaseValue()){
                totalDiscount = totalDiscount+ discountPercent*(discountSlab.getMaxPurchaseValue()-discountSlab.getMinPurchaseValue());
            }else{
                totalDiscount = totalDiscount+discountPercent*(totalCost-discountSlab.getMinPurchaseValue());
            }
        }
        return totalCost-totalDiscount;
    }
}
