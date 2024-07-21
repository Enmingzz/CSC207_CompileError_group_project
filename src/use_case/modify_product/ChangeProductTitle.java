package use_case.modify_product;

import data_access.interfaces.product.ProductUpdateNameDataAccessInterface;
import entity.product.CommonProductFactory;
import entity.product.Product;
import entity.product.ProductFactory;

import java.sql.SQLException;
import java.util.Objects;

/**
 * Class responsible for changing the title of a product. It checks if the new title is different from the current one,
 * updates it in the data access layer, and creates a new product instance with the updated title.
 */
public class ChangeProductTitle implements ChangeProductTitleInterface {
    private final ProductUpdateNameDataAccessInterface productUpdateNameDataAccessInterface;

    /**
     * Constructs a ChangeProductTitle instance with the specified data access interface.
     *
     * @param productUpdateNameDataAccessInterface the data access interface for updating the product title
     */
    public ChangeProductTitle(ProductUpdateNameDataAccessInterface productUpdateNameDataAccessInterface) {
        this.productUpdateNameDataAccessInterface = productUpdateNameDataAccessInterface;
    }

    /**
     * Executes the process of changing the title of a product. It checks if the new title is different from the current one,
     * updates the title in the data access layer, and creates a new product instance with the updated title.
     *
     * @param changedProduct the product whose title is to be changed
     * @param title the new title to be set
     * @return the updated product instance if the title is different, otherwise the original product
     * @throws SQLException if a database access error occurs
     */
    public Product execute(Product changedProduct, String title) throws SQLException {
        if (Objects.equals(title, changedProduct.getTitle())) {
            return changedProduct;
        } else {
            ProductFactory commonProductFactory = new CommonProductFactory();
            Product newProduct = commonProductFactory.createProduct(changedProduct.getImage(),
                    changedProduct.getDescription(), title,
                    changedProduct.getPrice(),
                    changedProduct.getRating(),
                    changedProduct.getState(), changedProduct.geteTransferEmail(),
                    changedProduct.getSellerStudentNumber(), changedProduct.getAddress(),
                    changedProduct.getListTags(), changedProduct.getProductID(),
                    changedProduct.getSchedule());
            productUpdateNameDataAccessInterface.updateProductName(changedProduct, title);
            return newProduct;
        }
    }
}
