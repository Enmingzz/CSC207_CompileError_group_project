package data_access.factories.objects.Product;

import data_access.factories.interfaces.Product.DatabaseProductReadByNameDataAccessObjectFactoryInterface;
import data_access.interfaces.Prouct.ProductReadByNameDataAccessInterface;
import data_access.objects.Product.DatabaseProductReadByNameDataAccessObject;
import entity.product.ProductFactory;

public class DatabaseProductReadByNameDataAccessObjectFactory implements DatabaseProductReadByNameDataAccessObjectFactoryInterface {

    public ProductReadByNameDataAccessInterface create(ProductFactory productFactory){
        return new DatabaseProductReadByNameDataAccessObject(productFactory);
    }
}
