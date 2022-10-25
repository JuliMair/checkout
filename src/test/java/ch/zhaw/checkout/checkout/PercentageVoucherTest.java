package ch.zhaw.checkout.checkout;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.ArrayList;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PercentageVoucherTest {

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 5, 20, 49, 50, Integer.MAX_VALUE - 1 })
    public void testEven2(int value) {
        ArrayList<Product> products = new ArrayList<Product>();
        PercentageVoucher percentageVoucher = new PercentageVoucher(value);
        assertEquals(percentageVoucher.getDiscount(products), 0.0);

    }

    @ParameterizedTest
    @ValueSource(ints = {42})
    public void testEven3(int value) {
        ArrayList<Product> products = new ArrayList<Product>();
        PercentageVoucher percentageVoucher = new PercentageVoucher(value);
        Product pro1 = new Product("88", "Cola ", "Getränk", 42.00);
        Product pro2 = new Product("89", "Fanta ", "Getränk", 77.00);
        products.add(pro1);
        products.add(pro2);
        assertEquals(percentageVoucher.getDiscount(products), 49.98);

    }

}
