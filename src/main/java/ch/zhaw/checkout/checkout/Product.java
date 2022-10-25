package ch.zhaw.checkout.checkout;

/*import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@RequiredArgsConstructor
@Getter */

public class Product {

    private String id;
    private String name;
    private String productGroup;
    private double price;

    public String getProductGroup() {
        return productGroup;
    }

    public double getPrice() {
        return price;
    }

    public Product(String id, String name, String productGroup, double price) {
        this.id = id;
        this.name = name;
        this.productGroup = productGroup;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName(){
        return name;
    }

}
