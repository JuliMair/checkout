package ch.zhaw.checkout.checkout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PercentageVoucherTest {

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 5, 20, 49, 50, Integer.MAX_VALUE - 1 })
    public void testEven2(int value) {
        ArrayList<Product> products = new ArrayList<Product>();
        PercentageVoucher percentageVoucher = new PercentageVoucher(value);
        assertEquals(percentageVoucher.getDiscount(products), 0.0);

    }

    @ParameterizedTest
    @ValueSource(ints = { 42 })
    public void testEven3(int value) {
        ArrayList<Product> products = new ArrayList<Product>();
        PercentageVoucher percentageVoucher = new PercentageVoucher(value);
        Product pro1 = new Product("88", "Cola ", "Getränk", 42.00);
        Product pro2 = new Product("89", "Fanta ", "Getränk", 77.00);
        products.add(pro1);
        products.add(pro2);
        assertEquals(percentageVoucher.getDiscount(products), 49.98);

    }

    @Test
    public void testMock() {
        ArrayList<Product> products = new ArrayList<Product>();
        Product p1 = mock(Product.class);
        Product p2 = mock(Product.class);
        when(p1.getPrice()).thenReturn(77.00);
        when(p2.getPrice()).thenReturn(42.00);
        products.add(p1);
        products.add(p2);
        PercentageVoucher percentageVoucher = new PercentageVoucher(42);
        /* assertEquals(percentageVoucher.getDiscount(products), 49.98); */
        Exception exception = assertThrows(RuntimeException.class, () -> {
            percentageVoucher.getDiscount(products);
        });
        String expectedMessage = "Error: Discount value must be greater than";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

    }

    @ParameterizedTest
    @ValueSource(ints = { 0, -2, 51 })
    public void testEven4(int value) {
        ArrayList<Product> products = new ArrayList<Product>();
        PercentageVoucher percentageVoucher = new PercentageVoucher(value);
        Product pro1 = new Product("88", "Cola ", "Getränk", 42.00);
        Product pro2 = new Product("89", "Fanta ", "Getränk", 77.00);
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
