package ch.zhaw.checkout.checkout;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

public class FiveBucksVoucherTest {

    @Test
    public void testEmpty() {
        ArrayList<Product> products = new ArrayList<Product>();
        FiveBucksVoucher fiveBucksVoucher = new FiveBucksVoucher();
        assertEquals(fiveBucksVoucher.getDiscount(products), 0.0);
    }

    @Test
    public void testTen() {
        ArrayList<Product> products = new ArrayList<Product>();
        FiveBucksVoucher fiveBucksVoucher = new FiveBucksVoucher();
        Product pro1 = new Product("88", "Cola ", "Getränk", 10.00);
        products.add(pro1);
        assertEquals(fiveBucksVoucher.getDiscount(products), 5.0);
    }
}
