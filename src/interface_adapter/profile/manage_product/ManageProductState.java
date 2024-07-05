package interface_adapter.profile.manage_product;

import entity.product.Product;
import entity.product.ProductFactory;

public class ManageProductState {
    private Product product;

    public ManageProductState(ProductFactory productFactory) {
        this.product = productFactory.createProduct(null,"","",0,0,
                0,"","","",null,"",
                null);
    }
    public Product getProduct() {return product;}

    public void setProduct(Product product) {this.product = product;}

}
