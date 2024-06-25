package data_access.objects.Product;

import data_access.interfaces.Prouct.ProductReadByTagDataAccessInterface;
import entity.product.ProductFactory;

public class DatabaseProductReadByTagDataAccessObject implements ProductReadByTagDataAccessInterface {

    final private ProductFactory productFactory;

    public DatabaseProductReadByTagDataAccessObject(ProductFactory productFactory) {
        this.productFactory = productFactory;
    }


}
