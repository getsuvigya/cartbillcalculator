package com.cart.biller;

import com.cart.biller.model.CustomerTypeEnum;
import com.cart.biller.model.DiscountSlab;
import com.cart.biller.model.ShoppingCart;
import com.cart.biller.service.CartBillCalculator;
import com.cart.biller.util.DiscountSlabCreatorUtil;

public class CartBillingEngine {
    private static final String Regular = "Regular";
    private static final String Premium = "Premium";
    static double regularClientMatrix[][] =
            {
                    {0.00d, 5000.00d, 0.00d},
                    {5000.00d, 10000.00d, 10.00d},
                    {10000.00d, Double.MAX_VALUE, 20.00d}

            };
    static double premiumClientMatrix[][] =
            {
                    {0.00d, 4000.00d, 10.00d},
                    {4000.00d, 8000.00d, 15.00d},
                    {8000.00d, 12000.00d, 20.00d},
                    {12000.00d, Double.MAX_VALUE, 30.00d}
            };
    public static void main(String[] args) {
        DiscountSlabCreatorUtil.createDiscountSlabsForCustomer(Regular,regularClientMatrix);
        DiscountSlabCreatorUtil.createDiscountSlabsForCustomer(Premium,premiumClientMatrix);

        CartBillCalculator cartBillCalculator = new CartBillCalculator();
        ShoppingCart regularCart = new ShoppingCart(CustomerTypeEnum.REGULAR, 15000.00d);
        System.out.println(cartBillCalculator.calculateBill(regularCart));

        ShoppingCart premiumCart = new ShoppingCart(CustomerTypeEnum.PREMIUM, 20000.00d);
        System.out.println(cartBillCalculator.calculateBill(premiumCart));
    }

}
