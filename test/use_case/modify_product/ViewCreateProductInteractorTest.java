package use_case.modify_product;

import entity.user.CommonUserFactory;
import entity.user.User;

import entity.user.UserFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ViewCreateProductInteractorTest {
    private User user;

    @BeforeEach
    void setUp() {
        String name = "Calico";
        String password = "Cat123";
        String email = "calico.cat@mail.utoronto.ca";
        float userRating = 4;
        String studentNumber = "1010101010";

        UserFactory userFactory = new CommonUserFactory();
        user = userFactory.createUser(name, password, email, userRating, studentNumber);


    }

    @AfterEach
    void tearDown() {
    }
    @Test
    void prepareSuccessfulViewTest() throws SQLException, IOException {

        ViewCreateProductOutputBoundary viewCreateProductPresenter = new ViewCreateProductOutputBoundary() {
            @Override
            public void prepareSuccessfulView(ViewCreateProductOutputData viewCreateProductOutputData) {
                assertEquals(viewCreateProductOutputData.getUser(), user);
            }
        };
        ViewCreateProductInteractor viewCreateProductInteractor = new ViewCreateProductInteractor(viewCreateProductPresenter);
        ViewCreateProductInputData inputData = new ViewCreateProductInputData(user);
        viewCreateProductInteractor.execute(inputData);
    }
}