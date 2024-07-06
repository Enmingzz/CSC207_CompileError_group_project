package use_case.modify_product;

import entity.product.Product;

public class CreateProductInputData {
    private final Product product;

    public CreateProductInputData(Product product) {
        this.product = product;
    }

    Product getProduct() {return product;}
}
