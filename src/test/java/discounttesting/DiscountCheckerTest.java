package discounttesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import junit.framework.TestCase;

/**
 * DiscountCheckerTest
 */
public class DiscountCheckerTest extends TestCase {

    public void testAbsolute() throws ParseException {
        //Given
        int productPrice = 500;
        String productName = "Inspiron";
        String discountType = "Absolute";
        Discount discount = new Discount(200);
        Date currentDate = new Date();

        //When
        int finalPrice = DiscountChecker.applyDiscount(productPrice, productName, discount, discountType, currentDate);

        //Then
        assertEquals(300, finalPrice);
    }

    public void testPercentage() throws ParseException {
        //Given
        int productPrice = 100;
        String productName = "Alienware";
        String discountType = "Percentage";
        Discount discount = new Discount(30);
        Date currentDate = new Date();

        //When
        int finalPrice = DiscountChecker.applyDiscount(productPrice, productName, discount, discountType, currentDate);

        //Then
        assertEquals(70, finalPrice);
    }

    public void testValidityPeriod() throws ParseException {
        //Given
        int productPrice = 1000;
        String productName = "Alienware";
        String discountType = "Validity";
        Discount discount = new Discount(500);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        Date currentDate = sdf.parse("18/8/2019");

        //When
        int finalPrice = DiscountChecker.applyDiscount(productPrice, productName, discount, discountType, currentDate);

        //Then
        assertEquals(500, finalPrice);
    }

    public void testSpecifiedProduct() throws ParseException {
        //Given
        int productPrice = 1000;
        String productName = "Precision";
        String discountType = "SpecifiedProduct";
        Discount discount = new Discount(400);
        Date currentDate = new Date();

        //When
        int finalPrice = DiscountChecker.applyDiscount(productPrice, productName, discount, discountType, currentDate);

        //Then
        assertEquals(600, finalPrice);
    }

    public void testShoppingCart() {
        //Given
        int[] productPrices = {200, 400, 700};
        String discountType = "Cart";
        Discount discount = new Discount(300);

        //When
        int finalPrice = DiscountChecker.applyCartDiscount(discount, discountType, productPrices);

        //Then
        assertEquals(1000, finalPrice);
    }
}