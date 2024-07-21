package use_case.modify_product;

import data_access.interfaces.product.ProductUpdateAddressDataAccessInterface;
import entity.product.CommonProductFactory;
import entity.product.Product;
import entity.product.ProductFactory;

import java.sql.SQLException;
import java.util.Objects;

/**
 * This class is responsible for changing the address of a product.
 * It uses a data access object to update the product's address in the database.
 */
public class ChangeProductAddress implements ChangeProductAddressInterface {
    private final ProductUpdateAddressDataAccessInterface productUpdateAddressDataAccessInterface;

    /**
     * Constructs a ChangeProductAddress with the specified data access interface.
     *
     * @param productUpdateAddressDataAccessInterface the data access interface for updating the product's address
     */
    public ChangeProductAddress(ProductUpdateAddressDataAccessInterface productUpdateAddressDataAccessInterface) {
        this.productUpdateAddressDataAccessInterface = productUpdateAddressDataAccessInterface;
    }

    /**
     * Executes the address change operation for the specified product.
     * If the new address is different from the current address, a new product instance is created with the updated address,
     * and the change is persisted in the database.
     *
     * @param changedProduct the product whose address is to be changed
     * @param address the new address for the product
     * @return a new product instance with the updated address if the address is changed, or the original product if the address is the same
     * @throws SQLException if there is an error updating the product's address in the database
     */
    public Product execute(Product changedProduct, String address) throws SQLException {
        if (Objects.equals(address, changedProduct.getAddress())) {
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
                    changedProduct.geteTransferEmail(),
                    changedProduct.getSellerStudentNumber(),
                    address,
                    changedProduct.getListTags(),
                    changedProduct.getProductID(),
                    changedProduct.getSchedule()
            );
            productUpdateAddressDataAccessInterface.updateProductAddress(changedProduct, address);
            return newProduct;
        }
    }
}
