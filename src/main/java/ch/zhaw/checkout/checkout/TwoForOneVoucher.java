package ch.zhaw.checkout.checkout;

import java.util.List;

public class TwoForOneVoucher implements Voucher{
private Product product;

public TwoForOneVoucher(Product product){

    
}

@Override
    public double getDiscount(List<Product> products) {
        // TODO Auto-generated method stub
        return 0;
    }
}
