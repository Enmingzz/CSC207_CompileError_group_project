package use_case.view_product;

import entity.product.Product;
import entity.user.User;

public class ViewProductInputData {
    private final Product product;
    private final User user;

    public ViewProductInputData(Product product, User user){
        this.product = product;
        this.user = user;
    }

    public Product getProduct(){
        return product;
    }
    public User getUser(){return user;}
}
