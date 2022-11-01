package ch.zhaw.checkout.checkout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ProductGroupVoucherTest {

    @ParameterizedTest

    @ValueSource(ints = { 1, 2, 5, 20, 49, 50 })

    public void testExerciseE(int value) {
        ArrayList<Product> products = new ArrayList<Product>();
        ProductGroupVoucher productGroupVoucher = new ProductGroupVoucher(value, "a");
        Product p1 = mock(Product.class);
        Product p2 = mock(Product.class);
        when(p1.getPrice()).thenReturn(102.0);
        when(p2.getPrice()).thenReturn(402.0);
        when(p1.getProductGroup()).thenReturn("a");
        when(p2.getProductGroup()).thenReturn("a");
        products.add(p1);
        products.add(p2);
        assertEquals(value, productGroupVoucher.getDiscount(products), 0.01);
    }

    @ParameterizedTest
    @ValueSource(ints = {  0, -1, -Integer.MAX_VALUE })
    public void testExerciseEwithfails(int value) {
        ArrayList<Product> products = new ArrayList<Product>();
        ProductGroupVoucher productGroupVoucher = new ProductGroupVoucher(value, "a");
        Product p1 = mock(Product.class);
        Product p2 = mock(Product.class);
        when(p1.getPrice()).thenReturn(77.00);
        when(p2.getPrice()).thenReturn(42.00);
        when(p1.getProductGroup()).thenReturn("a");
        when(p2.getProductGroup()).thenReturn("a");
        products.add(p1);
        products.add(p2);
        Exception exception = assertThrows(RuntimeException.class, () -> {
            productGroupVoucher.getDiscount(products);
        });
        String expectedMessage = "Error- discount can not be less than 1";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

}
