package ch.zhaw.checkout.checkout;

import java.util.List;

public class PercentageVoucher implements Voucher {

    private int discount;

    public PercentageVoucher(int discount) {
        this.discount=discount;
    }

    @Override
    public double getDiscount(List<Product> products) {
        if (products.stream().mapToDouble(x-> x.getPrice()).sum()>0) {
            return products.stream().mapToDouble(x-> x.getPrice()).sum()*discount/100;
            
            
        } else {
            return 0.0;
        }
        
    }
}
