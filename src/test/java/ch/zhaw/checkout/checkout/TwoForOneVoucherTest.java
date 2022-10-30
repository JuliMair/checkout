package ch.zhaw.checkout.checkout;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TwoForOneVoucherTest {


    @Test
    public void testdiscount() {
        ArrayList<Product> products = new ArrayList<Product>();
        Product pro1 = new Product("88", "Cola ", "Getränk", 42.00);
        Product pro2 = new Product("44", "Wurst", "Fleisch", 77.0);
        products.add(pro1);
        products.add(pro2);
        TwoForOneVoucher twoForOneVoucher = new TwoForOneVoucher(pro1);
        assertEquals(twoForOneVoucher.getDiscount(products), 0.0);
    }

    @ParameterizedTest
    @CsvSource({"0,0", "1,0", "2,1", "3,1", "4,2"})
    public void testdiscount2(String inputString, String expectedString){
        int input = Integer.parseInt(inputString);
        int expected = Integer.parseInt(expectedString);
        ArrayList<Product> products = new ArrayList<Product>();
        Product pro1 = new Product("88", "Cola ", "Getränk", 77.00);
        for (int i = 0; i < input; i++) {
            products.add(pro1);
        }
        TwoForOneVoucher twoForOneVoucher = new TwoForOneVoucher(pro1);
        assertEquals(twoForOneVoucher.getDiscount(products), expected * pro1.getPrice());
    }
}