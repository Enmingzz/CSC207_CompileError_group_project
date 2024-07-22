package use_case.modify_product;

import data_access.interfaces.product.ProductUpdateTransferEmailDataAccessInterface;
import entity.product.CommonProductFactory;
import entity.product.Product;
import entity.product.ProductFactory;

import java.sql.SQLException;
import java.util.Objects;

/**
 * This class is responsible for changing the email associated with a product.
 * It uses a data access object to update the product's email in the database.
 */
public class ChangeProductEmail implements ChangeProductEmailInterface {
    private final ProductUpdateTransferEmailDataAccessInterface productUpdateTransferEmailDataAccessInterface;

    /**
     * Constructs a ChangeProductEmail with the specified data access interface.
     *
     * @param productUpdateTransferEmailDataAccessInterface the data access interface for updating the product's email
     */
    public ChangeProductEmail(ProductUpdateTransferEmailDataAccessInterface productUpdateTransferEmailDataAccessInterface) {
        this.productUpdateTransferEmailDataAccessInterface = productUpdateTransferEmailDataAccessInterface;
    }

    /**
     * Executes the email change operation for the specified product.
     * If the new email is different from the current email, a new product instance is created with the updated email,
     * and the change is persisted in the database.
     *
     * @param changedProduct the product whose email is to be changed
     * @param email the new email for the product
     * @return a new product instance with the updated email if the email is changed, or the original product if the email is the same
     * @throws SQLException if there is an error updating the product's email in the database
     */
    public Product execute(Product changedProduct, String email) throws SQLException {
        if (Objects.equals(email, changedProduct.geteTransferEmail())) {
            return changedProduct;
        } else {
            ProductFactory commonProductFactory = new CommonProductFactory();
            Product newProduct = commonProductFactory.createProduct(
                    changedProduct.getImage(),
                    changedProduct.getDescription(),
                    changedProduct.getTitle(),
                    changedProduct.getPrice(),
                    changedProduct.getRating(),
                    changedProduct.getState(),
                    email,
                    changedProduct.getSellerStudentNumber(),
                    changedProduct.getAddress(),
                    changedProduct.getListTags(),
                    changedProduct.getProductID(),
                    changedProduct.getSchedule()
            );
            productUpdateTransferEmailDataAccessInterface.updateProductEmail(changedProduct, email);
            return newProduct;
        }
    }
}
