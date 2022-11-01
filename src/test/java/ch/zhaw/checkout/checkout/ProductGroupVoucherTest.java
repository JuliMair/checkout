package ch.zhaw.checkout.checkout;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ProductGroupVoucherTest {
    

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 5, 20, 49 })
    public void testEven3(int value) {
        ArrayList<Product> products = new ArrayList<Product>();
        PercentageVoucher percentageVoucher = new PercentageVoucher(value);
        Product pro1 = new Product("88", "Cola ", "a", 42.00);
        Product pro2 = new Product("89", "Fanta ", "a", 77.00);
        products.add(pro1);
        products.add(pro2);
        Exception exception = assertThrows(RuntimeException.class, () -> {
            percentageVoucher.getDiscount(products);
        });
        String expectedMessage = "Error: Discount value must be greater than";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

    }
}
