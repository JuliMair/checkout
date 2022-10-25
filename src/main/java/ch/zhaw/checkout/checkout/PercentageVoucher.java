package ch.zhaw.checkout.checkout;

import java.util.List;


public class PercentageVoucher implements Voucher{
    private int discount;

    public PercentageVoucher(int discount){

    }

    @Override
    public double getDiscount(List<Product> products) {
        // TODO Auto-generated method stub
        return 0;
    }
}
