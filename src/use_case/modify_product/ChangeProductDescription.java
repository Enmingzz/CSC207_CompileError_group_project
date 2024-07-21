package use_case.modify_product;

import data_access.interfaces.product.ProductUpdateDescriptionDataAccessInterface;
import entity.product.CommonProductFactory;
import entity.product.Product;
import entity.product.ProductFactory;

import java.sql.SQLException;
import java.util.Objects;

/**
 * Interactor for changing the description of a product.
 */
public class ChangeProductDescription implements ChangeProductDescriptionInterface {

    private final ProductUpdateDescriptionDataAccessInterface productUpdateDescriptionDataAccessInterface;

    /**
     * Constructs a ChangeProductDescription interactor with the specified data access interface.
     *
     * @param productUpdateDescriptionDataAccessInterface the data access interface for updating product descriptions
     */
    public ChangeProductDescription(ProductUpdateDescriptionDataAccessInterface productUpdateDescriptionDataAccessInterface) {
        this.productUpdateDescriptionDataAccessInterface = productUpdateDescriptionDataAccessInterface;
    }

    /**
     * Executes the process of changing the description of the given product.
     *
     * @param changedProduct the product whose description is to be changed
     * @param description the new description for the product
     * @return the updated product with the new description
     * @throws SQLException if there is an error with the SQL execution
     */
    public Product execute(Product changedProduct, String description) throws SQLException {
        if (Objects.equals(description, changedProduct.getDescription())) {
            return changedProduct;
        } else {
            ProductFactory commonProductFactory = new CommonProductFactory();
            Product newProduct = commonProductFactory.createProduct(
                    changedProduct.getImage(),
                    description,
                    changedProduct.getTitle(),
                    changedProduct.getPrice(),
                    changedProduct.getState(),
                    changedProduct.getRating(),
                    changedProduct.geteTransferEmail(),
                    changedProduct.getSellerStudentNumber(),
                    changedProduct.getAddress(),
                    changedProduct.getListTags(),
                    changedProduct.getProductID(),
                    changedProduct.getSchedule());

            productUpdateDescriptionDataAccessInterface.updateProductDescription(changedProduct, description);
            return newProduct;
        }
    }
}
