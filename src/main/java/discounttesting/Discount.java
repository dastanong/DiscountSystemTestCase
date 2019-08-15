package discounttesting;

import java.util.Date;

/**
 * Discount
 */
public class Discount {
    public int absoluteValue;
    public int percentageValue;
    public String[] applicableProducts = {"Alienware", "Inspiron", "Precision"};
    Date startDate = new Date();
    Date endDate = new Date();
    
    Discount(int discountAmount) {
        this.absoluteValue = discountAmount;
        this.percentageValue = discountAmount;
    }

}