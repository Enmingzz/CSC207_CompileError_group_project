package use_case.modify_product;

import entity.product.Product;

public class ChangeProductOutputData {
    private Product product;
    private String message;

    public ChangeProductOutputData(Product product, String message) {
        this.product = product;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    public Product getProduct() {
        return product;
    }

}
