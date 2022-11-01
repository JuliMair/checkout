package ch.zhaw.checkout.checkout;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.apache.logging.log4j.message.Message;

import com.fasterxml.jackson.databind.RuntimeJsonMappingException;

public class PercentageVoucher implements Voucher {

    private int discount;

    public PercentageVoucher(int discount) {
        this.discount=discount;
    }

    @Override
    public double getDiscount(List<Product> products) {
        if (discount > 50){
            throw new RuntimeException("Error - Discount value must less or equal 50.");
        } else if (discount <= 0){
            throw new RuntimeException("Error - Discount value must be greater zero");
        } else {
            if (products.stream().mapToDouble(x-> x.getPrice()).sum()>0) {
                return products.stream().mapToDouble(x-> x.getPrice()).sum()*discount/100;
            } else {
                return 0.0;
            }
        }
        


        
        
    }
}
