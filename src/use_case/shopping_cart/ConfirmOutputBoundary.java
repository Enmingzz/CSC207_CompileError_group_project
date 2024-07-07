package use_case.shopping_cart;

import java.io.IOException;
import java.sql.SQLException;

public interface ConfirmOutputBoundary {
    void prepareSuccessView(ConfirmOutputData confirmOutputData) throws IOException, SQLException;
}
