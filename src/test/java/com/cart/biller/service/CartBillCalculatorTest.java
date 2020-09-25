package com.cart.biller.service;

import com.cart.biller.model.CustomerTypeEnum;
import com.cart.biller.model.ShoppingCart;
import com.cart.biller.util.DiscountSlabCreatorUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartBillCalculatorTest {
    private static final String Regular = "Regular";
    private static final String Premium = "Premium";
    private static ShoppingCart regularCart;
    private static ShoppingCart premiumCart;
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

    @BeforeAll
    public static  void createCart(){
        regularCart = new ShoppingCart(CustomerTypeEnum.REGULAR, 15000.00d);

        premiumCart = new ShoppingCart(CustomerTypeEnum.PREMIUM, 20000.00d);
        DiscountSlabCreatorUtil.createDiscountSlabsForCustomer(Regular,regularClientMatrix);
        DiscountSlabCreatorUtil.createDiscountSlabsForCustomer(Premium,premiumClientMatrix);
    }

    @Test
    public void testCalculateBill() {
        CartBillCalculator cartBillCalculator = new CartBillCalculator();
        double expectedRegularCost = 13500;
        double expectedPremiumCost = 15800;
        double calculatedRegularCost = cartBillCalculator.calculateBill(regularCart);
        double calculatedPremiumCost = cartBillCalculator.calculateBill(premiumCart);
        assertEquals(calculatedRegularCost,expectedRegularCost);
        assertEquals(calculatedPremiumCost,calculatedPremiumCost);

    }
}