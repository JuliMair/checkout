package ch.zhaw.checkout.checkout;

import java.util.List;

public class TwoForOneVoucher implements Voucher {

    private Product product;

    public TwoForOneVoucher(Product product) {

    }

    @Override
    public double getDiscount(List<Product> products) {
        int count; /*
        if (count = products.stream().filter(x -> x.getId.equals(product)).count() >=2){
                return 0.0;
                 
            }*/
        return 0.0;
        
    }
}
