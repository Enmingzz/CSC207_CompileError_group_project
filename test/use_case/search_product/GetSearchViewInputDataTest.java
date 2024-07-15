package use_case.search_product;

import entity.user.CommonUser;
import entity.user.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetSearchViewInputDataTest {
    private User user;
    private GetSearchViewInputData getSearchViewInputData;

    @BeforeEach
    void setUp() {
        user = new CommonUser("tabby cat", "password", "tabby@mail.utoronto.ca",
                5, "1234567890");
        getSearchViewInputData = new GetSearchViewInputData(user);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getUser() {assertEquals(user, getSearchViewInputData.getUser());
    }
}