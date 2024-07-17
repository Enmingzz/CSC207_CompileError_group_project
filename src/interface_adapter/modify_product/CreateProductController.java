package interface_adapter.modify_product;

import entity.user.User;
import use_case.modify_product.CreateProductInputBoundary;
import use_case.modify_product.CreateProductInputData;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class CreateProductController {
    private final CreateProductInputBoundary createProductInteractor;

    public CreateProductController(CreateProductInputBoundary createProductInteractor) {
        this.createProductInteractor = createProductInteractor;
    }

    public static void execute(User user, Image image, String description, String price, String title, String
            eTransferEmail, String address, ArrayList<String> listTags) throws SQLException, IOException {

        CreateProductInputData createProductInputData = new CreateProductInputData(user, image, description, price, title,
                eTransferEmail, address, listTags);
        createProductInteractor.execute(createProductInputData);
    }
}
