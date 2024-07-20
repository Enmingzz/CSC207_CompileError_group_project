package use_case.modify_product;

import data_access.interfaces.product.ProductUpdateDescriptionDataAccessInterface;
import entity.product.CommonProductFactory;
import entity.product.Product;
import entity.product.ProductFactory;

import java.sql.SQLException;
import java.util.Objects;

import static java.lang.Float.parseFloat;

public class ChangeProductDescription implements ChangeProductDescriptionInterface{
    private final ProductUpdateDescriptionDataAccessInterface productUpdateDescriptionDataAccessInterface;

    public ChangeProductDescription(ProductUpdateDescriptionDataAccessInterface productUpdateDescriptionDataAccessInterface) {
        this.productUpdateDescriptionDataAccessInterface = productUpdateDescriptionDataAccessInterface;
    }

    public Product execute(Product changedProduct, String description) throws SQLException {
        if (Objects.equals(description, "")) {
            return changedProduct;
        }
        else {
            //System.out.println(System.identityHashCode(changedProduct));
            ProductFactory commonProductFactory = new CommonProductFactory();
            Product newProduct = commonProductFactory.createProduct(changedProduct.getImage(),
                    description, changedProduct.getTitle(),
                    changedProduct.getPrice(),
                    changedProduct.getRating(),
                    changedProduct.getState(), changedProduct.geteTransferEmail(),
                    changedProduct.getSellerStudentNumber(), changedProduct.getAddress(),
                    changedProduct.getListTags(), changedProduct.getProductID(),
                    changedProduct.getSchedule());
            productUpdateDescriptionDataAccessInterface.updateProductDescription(changedProduct,
                    description);
            return newProduct;
        }
    }

}
