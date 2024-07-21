package use_case.modify_product;

import data_access.interfaces.product.ProductUpdateAddressDataAccessInterface;
import data_access.interfaces.product.ProductUpdateTransferEmailDataAccessInterface;
import entity.product.CommonProductFactory;
import entity.product.Product;
import entity.product.ProductFactory;

import java.sql.SQLException;
import java.util.Objects;

public class ChangeProductEmail implements ChangeProductEmailInterface{
    private final ProductUpdateTransferEmailDataAccessInterface productUpdateTransferEmailDataAccessInterface;

    public ChangeProductEmail(ProductUpdateTransferEmailDataAccessInterface productUpdateTransferEmailDataAccessInterface) {
        this.productUpdateTransferEmailDataAccessInterface = productUpdateTransferEmailDataAccessInterface;
    }

    public Product execute(Product changedProduct, String email) throws SQLException {
        if (Objects.equals(email, changedProduct.geteTransferEmail())) {
            return changedProduct;
        }
        else {
            //System.out.println(System.identityHashCode(changedProduct));
            ProductFactory commonProductFactory = new CommonProductFactory();
            Product newProduct = commonProductFactory.createProduct(changedProduct.getImage(),
                    changedProduct.getDescription(), changedProduct.getTitle(),
                    changedProduct.getPrice(),
                    changedProduct.getRating(),
                    changedProduct.getState(), email,
                    changedProduct.getSellerStudentNumber(), changedProduct.getAddress(),
                    changedProduct.getListTags(), changedProduct.getProductID(),
                    changedProduct.getSchedule());
            productUpdateTransferEmailDataAccessInterface.updateProductEmail(changedProduct, email);
            return newProduct;
        }
    }

}
