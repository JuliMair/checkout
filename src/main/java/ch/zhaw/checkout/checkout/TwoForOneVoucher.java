package ch.zhaw.checkout.checkout;

import java.util.List;

public class TwoForOneVoucher implements Voucher {
    private Product product;


    public TwoForOneVoucher(Product product) {
        this.product = product;
    }



    @Override
    public double getDiscount(List<Product> products) {
        long sameProducts = products.stream().filter(x -> x.getId().equals(product.getId())).count();
        sameProducts /= 2;
        return (int) sameProducts * product.getPrice();
    }


}