package data_access.factories.objects.Product;

import data_access.factories.interfaces.Product.DatabaseProductReadByTagDataAccessObjectFactoryInterface;
import data_access.interfaces.Prouct.ProductReadByNameDataAccessInterface;
import data_access.interfaces.Prouct.ProductReadByTagDataAccessInterface;
import data_access.objects.Product.DatabaseProductReadByNameDataAccessObject;
import data_access.objects.Product.DatabaseProductReadByTagDataAccessObject;
import entity.product.ProductFactory;

public class DatabaseProductReadByTagDataAccessObjectFactory implements DatabaseProductReadByTagDataAccessObjectFactoryInterface {

    public ProductReadByTagDataAccessInterface create(ProductFactory productFactory){
        return new DatabaseProductReadByTagDataAccessObject(productFactory);
    }
}
