package use_case;

import entity.product.Product;

public class ViewProductInputData {
    private final Product product;

    public ViewProductInputData(Product product){
        this.product = product;
    }

    public Product getProduct(){
        return product;
    }
}
