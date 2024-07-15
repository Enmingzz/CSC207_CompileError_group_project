package use_case.profile.modify_profile;

import data_access.in_memory.user.InMemoryUserDataReadAccessObject;
import data_access.in_memory.user.InMemoryUserUpdateNameDataAccessObject;
import data_access.in_memory.user.InMemoryUserUpdatePasswordDataAccessObject;
import data_access.interfaces.user.UserReadDataAccessInterface;
import data_access.interfaces.user.UserUpdateNameDataAccessInterface;
import data_access.interfaces.user.UserUpdatePasswordDataAccessInterface;
import entity.user.CommonUser;
import entity.user.CommonUserFactory;
import entity.user.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ModifyProfileNameInteractorTest {
    private UserUpdateNameDataAccessInterface inMemoryUserUpdateNameDataAccessObject;
    private UserReadDataAccessInterface inMemoryUserDataReadAccessObject;
    private UserUpdatePasswordDataAccessInterface inMemoryUserUpdatePasswordDataAccessObject;

    private ModifyProfileInputData modifyProfileInputData;
    private ModifyProfileInputBoundary modifyProfileInputBoundary;
    private ModifyProfileOutputBoundary modifyProfileOutputBoundary;

    private User user;
    private ArrayList<User> users;


    @BeforeEach
    void setUp() {
        user =  new CommonUser("hanrui", "123456", "hanrui@mail", 0, "123456");
        modifyProfileInputData = new ModifyProfileInputData(user);

        users = new ArrayList<User>();
        users.add(user);

        inMemoryUserUpdateNameDataAccessObject = new InMemoryUserUpdateNameDataAccessObject(users, new CommonUserFactory());
        inMemoryUserDataReadAccessObject = new InMemoryUserDataReadAccessObject(users, new CommonUserFactory());
        inMemoryUserUpdatePasswordDataAccessObject = new InMemoryUserUpdatePasswordDataAccessObject(users, new CommonUserFactory());
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void executeOnlyOneUser() throws SQLException {
        String newName = "Hello";
        User newUser = new CommonUser(newName, "123456", "hanrui@mail", 0, "123456");
        modifyProfileInputData = new ModifyProfileInputData(user);

        modifyProfileOutputBoundary = new ModifyProfileOutputBoundary() {
            @Override
            public void prepareSuccessfulView(ModifyProfileOutputData modifyProfileOutputData) {
                assertEquals(modifyProfileOutputData.getMessage(), "Have successfully changed username");
            }

            @Override
            public void prepareFailedView(ModifyProfileOutputData modifyProfileOutputData) {
                System.out.println("This should not happened in this test case!");
            }
        };

        modifyProfileInputBoundary = new ModifyProfileInteractor(inMemoryUserUpdateNameDataAccessObject,
                inMemoryUserUpdatePasswordDataAccessObject, inMemoryUserDataReadAccessObject, modifyProfileOutputBoundary);

        modifyProfileInputBoundary.execute(modifyProfileInputData);
    }
}