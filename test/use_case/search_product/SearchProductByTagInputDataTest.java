package use_case.search_product;

import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchProductByTagInputDataTest {
    private User user;
    private String tag;
    private SearchProductByTagInputData searchProductByTagInputData;

    @BeforeEach
    void setUp() {
        String name = "tabby cat";
        String password = "password";
        String email = "tabby@mail.utoronto.ca";
        float userRating = 5;
        String studentNumber = "1234567890";

        UserFactory userFactory = new CommonUserFactory();
        user = userFactory.createUser(name, password, email, userRating, studentNumber);

        tag = "Tag1";

        searchProductByTagInputData = new SearchProductByTagInputData(user, tag);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getUser() {assertEquals(user, searchProductByTagInputData.getUser());
    }

    @Test
    void getTag() {assertEquals(tag, searchProductByTagInputData.getTag());
    }
}