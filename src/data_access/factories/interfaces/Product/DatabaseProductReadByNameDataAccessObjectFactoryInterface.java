package data_access.factories.interfaces.Product;

import data_access.interfaces.Prouct.ProductReadByNameDataAccessInterface;
import data_access.objects.Product.DatabaseProductReadByNameDataAccessObject;
import entity.product.ProductFactory;

public interface DatabaseProductReadByNameDataAccessObjectFactoryInterface {

    public ProductReadByNameDataAccessInterface create(ProductFactory productFactory);
}
