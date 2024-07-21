package use_case.modify_product;

import data_access.interfaces.product.ProductUpdateAddressDataAccessInterface;
import data_access.interfaces.product.ProductUpdateNameDataAccessInterface;
import entity.product.CommonProductFactory;
import entity.product.Product;
import entity.product.ProductFactory;

import java.sql.SQLException;
import java.util.Objects;

public class ChangeProductAddress implements ChangeProductAddressInterface{
    private final ProductUpdateAddressDataAccessInterface productUpdateAddressDataAccessInterface;

    public ChangeProductAddress(ProductUpdateAddressDataAccessInterface productUpdateAddressDataAccessInterface) {
        this.productUpdateAddressDataAccessInterface = productUpdateAddressDataAccessInterface;
    }

    public Product execute(Product changedProduct, String address) throws SQLException {
        if (Objects.equals(address, changedProduct.getAddress())) {
            return changedProduct;
        }
        else {
            //System.out.println(System.identityHashCode(changedProduct));
            ProductFactory commonProductFactory = new CommonProductFactory();
            Product newProduct = commonProductFactory.createProduct(changedProduct.getImage(),
                    changedProduct.getDescription(), changedProduct.getTitle(),
                    changedProduct.getPrice(),
                    changedProduct.getRating(),
                    changedProduct.getState(), changedProduct.geteTransferEmail(),
                    changedProduct.getSellerStudentNumber(), address,
                    changedProduct.getListTags(), changedProduct.getProductID(),
                    changedProduct.getSchedule());
            productUpdateAddressDataAccessInterface.updateProductAddress(changedProduct, address);
            return newProduct;
        }
    }

}
