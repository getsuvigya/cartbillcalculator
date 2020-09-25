package com.cart.biller.util;

import com.cart.biller.model.CustomerTypeEnum;
import com.cart.biller.model.DiscountSlab;

import java.util.ArrayList;
import java.util.List;

public class DiscountSlabCreatorUtil {
    public static final void createDiscountSlabsForCustomer(String customer, double discountSlabArray[][]){
        List<DiscountSlab> discountSlabList = new ArrayList<DiscountSlab>();
        for(int i=0; i<discountSlabArray.length; i++){
            DiscountSlab discountSlab = new DiscountSlab(discountSlabArray[i][0],discountSlabArray[i][1],discountSlabArray[i][2]);
            discountSlabList.add(discountSlab);
        }
        if(customer.equals("Regular")){
            CustomerTypeEnum.REGULAR.setCustomerType(customer);
            CustomerTypeEnum.REGULAR.setDiscountSlabs(discountSlabList);
        }

        if(customer.equals("Premium")){
            CustomerTypeEnum.PREMIUM.setCustomerType(customer);
            CustomerTypeEnum.PREMIUM.setDiscountSlabs(discountSlabList);
        }
    }
}
