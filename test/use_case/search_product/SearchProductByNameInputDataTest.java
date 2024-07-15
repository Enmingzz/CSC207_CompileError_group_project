package use_case.search_product;

import entity.product.Product;
import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchProductByNameInputDataTest {
    private User user;
    private String productName;
    private SearchProductByNameInputData searchProductByNameInputData;

    @BeforeEach
    void setUp() {
        String name = "tabby cat";
        String password = "password";
        String email = "tabby@mail.utoronto.ca";
        float userRating = 5;
        String studentNumber = "1234567890";

        UserFactory userFactory = new CommonUserFactory();
        user = userFactory.createUser(name, password, email, userRating, studentNumber);

        productName = "cat";

        searchProductByNameInputData = new SearchProductByNameInputData(user, productName);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getUser() {assertEquals(user, searchProductByNameInputData.getUser());
    }

    @Test
    void getProductName() {assertEquals(productName, searchProductByNameInputData.getProductName());
    }
}