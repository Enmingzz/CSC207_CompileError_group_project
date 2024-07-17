package interface_adapter.profile.manage_product;

import entity.user.CommonUser;
import entity.user.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.profile.manage_product.ManageProductInputBoundary;
import use_case.profile.manage_product.ManageProductInputData;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ManageProductControllerTest {
    private ManageProductInputBoundary manageProductInteractor;
    private ManageProductInputData manageProductInputData;
    private User user;

    @BeforeEach
    void setUp() {
        user = new CommonUser("hanrui", "123456", "hanrui@mail", 0, "123456");
        manageProductInputData = new ManageProductInputData(user);

        manageProductInteractor = new ManageProductInputBoundary() {
            @Override
            public void execute(ManageProductInputData manageProductInputData) throws SQLException, IOException {
                assertEquals(user, manageProductInputData.getUser());
            }
        };
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void execute() throws SQLException, IOException {
        manageProductInteractor.execute(manageProductInputData);
    }
}