package interface_adapter.profile.manage_product;

import entity.product.Product;
import entity.product.ProductFactory;

import java.util.ArrayList;

public class ManageProductState {
    private Product product;
    private ArrayList<Product> products = new ArrayList<Product>();

    public ManageProductState(ProductFactory productFactory) {
        this.product = productFactory.createProduct(null,"","",0,0,
                0,"","","",null,"",
                null);
        this.products.add(product);
    }
    public ArrayList<Product> getProduct() {return products;}

    public void setProduct(ArrayList<Product> products) {this.products = products;}

}
