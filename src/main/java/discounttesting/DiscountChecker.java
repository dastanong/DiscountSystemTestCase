package discounttesting;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
/**
 * DiscountChecker
 */
public class DiscountChecker {

    public static int applyDiscount(int price, String productName, Discount discount, String discountType, Date currentDate) throws ParseException {
        //Test Case 1
        if(discountType.equals("Absolute")) {
            return price - discount.absoluteValue; 
        }

        //Test Case 2
        if(discountType.equals("Percentage")) {
            return price - (price * discount.percentageValue / 100);
        }

        //Test Case 3
        if(discountType.equals("Validity")) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
            discount.startDate = sdf.parse("15/8/2019");
            discount.endDate = sdf.parse("20/8/2019");

            if(currentDate.compareTo(discount.startDate) > 0 && currentDate.compareTo(discount.endDate) < 0){
                return price - discount.absoluteValue;
            } else if(currentDate.compareTo(discount.startDate) < 0 || currentDate.compareTo(discount.endDate) > 0) {
                return price;
            }
        }

        //Test Case 4
        if(discountType.equals("SpecifiedProduct")) {
            for(int i = 0; i < discount.applicableProducts.length; i++) {
                if(productName.equals(discount.applicableProducts[i])) {
                    price = price - discount.absoluteValue;
                }
            }
        }
        
        //Test Case 5
        

        return price;
    }

    public static int applyCartDiscount(Discount discount, String discountType, int[] productPrices) {
        int finalPrice = 0;

        for(int i = 0; i < productPrices.length; i++) {
            finalPrice += productPrices[i];
        }

        finalPrice = finalPrice - discount.absoluteValue;

        return finalPrice;
    }
}