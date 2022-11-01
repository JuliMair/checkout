package ch.zhaw.checkout.checkout;

import java.util.List;

public class FiveBucksVoucher implements Voucher {

    @Override
    public double getDiscount(List<Product> products){
        if (products.stream().mapToDouble(x-> x.getPrice()).sum() >= 10.0) {
        return 5.0;
    } else {
        return 0.0;
    }
}

    public FiveBucksVoucher() {

    }

    public static boolean isEven(double value) {
        return value % 2 == 0;
    }

}
