package use_case.profile.modify_profile;

import data_access.in_memory.product.InMemoryProductReadByUserDataAccessObject;
import data_access.in_memory.user.InMemoryUserDataReadAccessObject;
import data_access.in_memory.user.InMemoryUserUpdateNameDataAccessObject;
import data_access.in_memory.user.InMemoryUserUpdatePasswordDataAccessObject;
import data_access.interfaces.user.UserReadDataAccessInterface;
import data_access.interfaces.user.UserUpdateNameDataAccessInterface;
import data_access.interfaces.user.UserUpdatePasswordDataAccessInterface;
import entity.user.CommonUser;
import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.profile.manage_product.ManageProductOutputBoundary;
import use_case.profile.manage_product.ManageProductOutputData;

import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ModifyProfileInteractorTest {

    private UserReadDataAccessInterface inMemoryUserDataReadAccessObject;
    private UserUpdateNameDataAccessInterface inMemoryUserUpdateNameDataAccessObject;
    private UserUpdatePasswordDataAccessInterface inMemoryUserUpdatePasswordDataAccessObject;

    private ModifyProfileOutputBoundary modifyProfileOutputBoundary;

    private ModifyProfileInputBoundary modifyProfileInputInteractor;
    private ModifyProfileInputData modifyProfileInputData;

    private final UserFactory userFactory = new CommonUserFactory();
    private ArrayList<User> users = new ArrayList<>();
    private User user;

    @BeforeEach
    void setUp() {
        User userHan = new CommonUser("hanrui", "123456", "hanrui@mail", 0, "123456");
        users.add(userHan);
        for (int i = 0; i < 3; i++){
            user =  new CommonUser(("hanrui" + String.valueOf(i)), "123456", "hanrui@mail",
                    0, String.valueOf(i * 10));
            users.add(user);
        }

        modifyProfileInputData = new ModifyProfileInputData(userHan);

        inMemoryUserDataReadAccessObject = new InMemoryUserDataReadAccessObject(users, userFactory);
        inMemoryUserUpdateNameDataAccessObject = new InMemoryUserUpdateNameDataAccessObject(users, userFactory);
        inMemoryUserUpdatePasswordDataAccessObject = new InMemoryUserUpdatePasswordDataAccessObject(users, userFactory);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void executeOnlyName() throws SQLException {
        String newName = "Hello";
        User newUser = new CommonUser(newName, "123456", "hanrui@mail", 0, "123456");
        modifyProfileInputData = new ModifyProfileInputData(newUser);

        modifyProfileOutputBoundary = new ModifyProfileOutputBoundary() {
            @Override
            public void prepareSuccessfulView(ModifyProfileOutputData modifyProfileOutputData) {
                assertEquals("Have successfully changed username", modifyProfileOutputData.getMessage());
                assertEquals(newName, users.get(0).getName());
            }

            @Override
            public void prepareFailedView(ModifyProfileOutputData modifyProfileOutputData) {
                System.out.println("This should not happened in this case!");
            }
        };

        modifyProfileInputInteractor = new ModifyProfileInteractor(inMemoryUserUpdateNameDataAccessObject,
                inMemoryUserUpdatePasswordDataAccessObject, inMemoryUserDataReadAccessObject, modifyProfileOutputBoundary);
        modifyProfileInputInteractor.execute(modifyProfileInputData);
    }

    @Test
    void executeOnlyPassword() throws SQLException {
        String newPassword = "111111";
        User newUser = new CommonUser("hanrui", newPassword, "hanrui@mail", 0, "123456");
        modifyProfileInputData = new ModifyProfileInputData(newUser);

        modifyProfileOutputBoundary = new ModifyProfileOutputBoundary() {
            @Override
            public void prepareSuccessfulView(ModifyProfileOutputData modifyProfileOutputData) {
                assertEquals("Have successfully changed password", modifyProfileOutputData.getMessage());
                assertEquals(newPassword, users.get(0).getPassword());
            }

            @Override
            public void prepareFailedView(ModifyProfileOutputData modifyProfileOutputData) {
                System.out.println("This should not happened in this case!");
            }
        };

        modifyProfileInputInteractor = new ModifyProfileInteractor(inMemoryUserUpdateNameDataAccessObject,
                inMemoryUserUpdatePasswordDataAccessObject, inMemoryUserDataReadAccessObject, modifyProfileOutputBoundary);
        modifyProfileInputInteractor.execute(modifyProfileInputData);
    }

    @Test
    void executeBoth() throws SQLException {
        String newName = "Hello";
        String newPassword = "11111";
        User newUser = new CommonUser(newName, newPassword, "hanrui@mail", 0, "123456");
        modifyProfileInputData = new ModifyProfileInputData(newUser);

        modifyProfileOutputBoundary = new ModifyProfileOutputBoundary() {
            @Override
            public void prepareSuccessfulView(ModifyProfileOutputData modifyProfileOutputData) {
                assertEquals("Have successfully changed username and password", modifyProfileOutputData.getMessage());
                assertEquals(newPassword, users.get(0).getPassword());
                assertEquals(newName, users.get(0).getName());
            }

            @Override
            public void prepareFailedView(ModifyProfileOutputData modifyProfileOutputData) {
                System.out.println("This should not happened in this case!");
            }
        };

        modifyProfileInputInteractor = new ModifyProfileInteractor(inMemoryUserUpdateNameDataAccessObject,
                inMemoryUserUpdatePasswordDataAccessObject, inMemoryUserDataReadAccessObject, modifyProfileOutputBoundary);
        modifyProfileInputInteractor.execute(modifyProfileInputData);
    }

    @Test
    void executeNoChanged() throws SQLException {

        modifyProfileOutputBoundary = new ModifyProfileOutputBoundary() {
            @Override
            public void prepareSuccessfulView(ModifyProfileOutputData modifyProfileOutputData) {
                System.out.println("This should not happened in this case!");
            }

            @Override
            public void prepareFailedView(ModifyProfileOutputData modifyProfileOutputData) {
                assertEquals("Did not change anything", modifyProfileOutputData.getMessage());
                assertEquals("123456", users.get(0).getPassword());
                assertEquals("hanrui", users.get(0).getName());
            }
        };

        modifyProfileInputInteractor = new ModifyProfileInteractor(inMemoryUserUpdateNameDataAccessObject,
                inMemoryUserUpdatePasswordDataAccessObject, inMemoryUserDataReadAccessObject, modifyProfileOutputBoundary);
        modifyProfileInputInteractor.execute(modifyProfileInputData);
    }
}