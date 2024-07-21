package use_case.profile.view_profile;

import entity.user.CommonUser;
import entity.user.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ViewUserProfileInputDataTest {

    private ViewUserProfileInputData viewUserProfileInputData;
    private User seller;
    private User buyer;

    @BeforeEach
    void setUp() {
        seller = new CommonUser("hanrui", "123", "hanrui@mail", 0, "12345");
        buyer = new CommonUser("enming", "123", "enming@mail", 0, "12345");
        viewUserProfileInputData = new ViewUserProfileInputData(seller.getStudentNumber(), buyer)
;    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getSellerStudentNumber() {
        assertEquals(seller, viewUserProfileInputData.getSellerStudentNumber());

    }

    @Test
    void getBuyer() {
        assertEquals(buyer, viewUserProfileInputData.getBuyer());
    }
}