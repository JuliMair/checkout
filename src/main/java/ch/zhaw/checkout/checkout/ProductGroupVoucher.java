package ch.zhaw.checkout.checkout;

import java.util.List;

public class ProductGroupVoucher implements Voucher{
    private int discount;
    private String productGroup;

    public ProductGroupVoucher(int discount, String productGroup) {
        this.discount = discount;
        this.productGroup = productGroup;
}

    @Override
    public double getDiscount(List<Product> products) {
        if (productGroup == null || productGroup == " ") {
            throw new RuntimeException("Error: Productgroup must contain a name");
        }
        long count = products.stream().filter(x -> x.getProductGroup().equals(productGroup)).count();
        if (count > 0) {
            if (discount >= products.stream().mapToDouble(x -> x.getPrice()).sum()) {
                return products.stream().mapToDouble(x -> x.getPrice()).sum();
            } 
        } else {
                return (double) discount;
            }
        return 0.0;
    }
}


