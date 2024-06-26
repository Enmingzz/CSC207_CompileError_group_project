package data_access.objects.Product;

import data_access.interfaces.Prouct.ProductReadByNameDataAccessInterface;
import entity.product.ProductFactory;

public class DatabaseProductReadByNameDataAccessObject implements ProductReadByNameDataAccessInterface {

    final private ProductFactory productFactory;

    public DatabaseProductReadByNameDataAccessObject(ProductFactory productFactory) {
        this.productFactory = productFactory;
    }

}
