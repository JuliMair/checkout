package ch.zhaw.checkout.checkout;

import java.util.List;

public class PercentageVoucher implements Voucher {

    private int discount;

    public PercentageVoucher(int discount) {

    }

    @Override
    public double getDiscount(List<Product> products) {
        if (discount != 0) {
            int CHFdiscount = (int) (products.stream().mapToDouble(x-> x.getPrice()).sum()*(discount/100));
            return discount = CHFdiscount;
            
        } else {
            return 0.0;
        }
        
    }
}
