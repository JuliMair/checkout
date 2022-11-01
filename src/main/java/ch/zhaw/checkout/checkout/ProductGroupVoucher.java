package ch.zhaw.checkout.checkout;

import java.util.List;

public class ProductGroupVoucher implements Voucher {
    private int discount;
    private String productGroup;

    public ProductGroupVoucher(int discount, String productGroup) {
        this.discount = discount;
        this.productGroup = productGroup;
    }

    @Override

    public double getDiscount(List<Product> products) {

        long vorhanden = products.stream().filter(x -> x.getProductGroup().equals(productGroup)).count();

        if (productGroup == " " || productGroup == null) {
            throw new RuntimeException("ProdLeer");
        } else if (products.stream().mapToDouble(x -> x.getPrice()).sum() < discount) {
            throw new RuntimeException("Error – discount is higher than the shopping cart");
        } else if(discount <= 0){
            throw new RuntimeException("Error- discount can not be less than 1");
        }else if (vorhanden > 0) {
            return discount;
        }

        return 0;

    }
}
