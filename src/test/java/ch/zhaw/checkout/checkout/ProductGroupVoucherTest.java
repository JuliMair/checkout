package ch.zhaw.checkout.checkout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

    @Test
    public void productGroupNull() {
        ArrayList<Product> products = new ArrayList<Product>();
        ProductGroupVoucher productGroupVoucher = new ProductGroupVoucher(42, null);

        Product p1 = mock(Product.class);
        Product p2 = mock(Product.class);
        when(p1.getPrice()).thenReturn(12.0); 
        when(p2.getPrice()).thenReturn(42.0);
        when(p1.getProductGroup()).thenReturn("Getraenk");
        when(p2.getProductGroup()).thenReturn("Getraenk");
        products.add(p1);
        products.add(p2);


        Exception exception = assertThrows(RuntimeException.class, () -> {
            productGroupVoucher.getDiscount(products);
        });
        String expectedMessage = "ProdLeer";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
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

    @ParameterizedTest
    @CsvSource({"p1,5,p1,7,p1,10,10", "p1,5,p1,3,p1,10,8", "p1,5,p2,7,p1,10,5",  "p2,5,p2,7,p1,10,0", "p1,5,p1,7,p2,10,0" })
    public void rabattBerechnung(String productgrp1, double price1,  String productgrp2, double price2, String Grp, int discount, double expected){
  
        ArrayList<Product> products = new ArrayList<Product>();
        ProductGroupVoucher productGroupVoucher = new ProductGroupVoucher(discount, Grp);

        Product prod1 = mock(Product.class);
        Product prod2 = mock(Product.class);
        when(prod1.getPrice()).thenReturn(price1); 
        when(prod2.getPrice()).thenReturn(price2);
        when(prod1.getProductGroup()).thenReturn(productgrp1);
        when(prod2.getProductGroup()).thenReturn(productgrp2);
        products.add(prod1);
        products.add(prod2);

        assertEquals(expected, productGroupVoucher.getDiscount(products), 0.01);

    }

}
