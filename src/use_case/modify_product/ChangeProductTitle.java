package use_case.modify_product;

import data_access.interfaces.product.ProductUpdateDescriptionDataAccessInterface;
import data_access.interfaces.product.ProductUpdateNameDataAccessInterface;
import entity.product.CommonProductFactory;
import entity.product.Product;
import entity.product.ProductFactory;

import java.sql.SQLException;
import java.util.Objects;

public class ChangeProductTitle implements ChangeProductTitleInterface{
    private final ProductUpdateNameDataAccessInterface productUpdateNameDataAccessInterface;

    public ChangeProductTitle(ProductUpdateNameDataAccessInterface productUpdateNameDataAccessInterface) {
        this.productUpdateNameDataAccessInterface = productUpdateNameDataAccessInterface;
    }

    public Product execute(Product changedProduct, String title) throws SQLException {
        if (Objects.equals(title, changedProduct.getTitle())) {
            return changedProduct;
        }
        else {
            //System.out.println(System.identityHashCode(changedProduct));
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
