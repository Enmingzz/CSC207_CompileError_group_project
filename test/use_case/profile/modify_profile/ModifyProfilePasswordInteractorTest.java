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

import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ModifyProfilePasswordInteractorTest {
    private UserUpdatePasswordDataAccessInterface inMemoryUserUpdatePasswordDataAccessObject;
    private UserReadDataAccessInterface inMemoryUserDataReadAccessObject;

    private ModifyProfileInputData modifyProfileInputData;
    private ModifyProfilePasswordInterface modifyProfilePasswordInterface;

    private User user;
    private ArrayList<User> users;

    @BeforeEach
    void setUp() {
        user =  new CommonUser("hanrui", "123456", "hanrui@mail", 0, "123456");
        modifyProfileInputData = new ModifyProfileInputData(user);

        users = new ArrayList<User>();
        users.add(user);

        inMemoryUserUpdatePasswordDataAccessObject = new InMemoryUserUpdatePasswordDataAccessObject(users, new CommonUserFactory());
        inMemoryUserDataReadAccessObject = new InMemoryUserDataReadAccessObject(users, new CommonUserFactory());

        modifyProfilePasswordInterface = new ModifyProfilePassword(inMemoryUserDataReadAccessObject,
                inMemoryUserUpdatePasswordDataAccessObject);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void executeOneUser() throws SQLException {
        String newPassword = "1111111";
        User newUser = new CommonUser("hanrui", newPassword, "hanrui@mail", 0, "123456");
        modifyProfileInputData = new ModifyProfileInputData(newUser);

        boolean allMatch = users.stream().allMatch(element -> newPassword.equals(element.getPassword()));
        assert modifyProfilePasswordInterface.execute(modifyProfileInputData.getUser());
        assert allMatch;
    }

    @Test
    void executeMultipleUser() throws SQLException {
        for (int i = 0; i < 3; i++){
            byte[] array = new byte[7];
            new Random().nextBytes(array);
            String generatedString = new String(array, StandardCharsets.UTF_8);
            users.add(new CommonUser(String.valueOf(i), generatedString, "hanrui@mail",
                    0, String.valueOf(i * 10)));
        }
        String newPassword = "1111111";
        User newUser = new CommonUser("hanrui", newPassword, "hanrui@mail", 0, "123456");

        inMemoryUserUpdatePasswordDataAccessObject = new InMemoryUserUpdatePasswordDataAccessObject(users,
                new CommonUserFactory());
        inMemoryUserDataReadAccessObject = new InMemoryUserDataReadAccessObject(users, new CommonUserFactory());

        modifyProfileInputData = new ModifyProfileInputData(newUser);
        modifyProfilePasswordInterface = new ModifyProfilePassword(inMemoryUserDataReadAccessObject,
                inMemoryUserUpdatePasswordDataAccessObject);

        assert modifyProfilePasswordInterface.execute(modifyProfileInputData.getUser());
        assertEquals(newPassword, users.get(0).getPassword());
    }

    @Test
    void executeNoChanged() throws SQLException {

        boolean allMatch = users.stream().allMatch(element -> "123456".equals(element.getPassword()));
        assert !modifyProfilePasswordInterface.execute(modifyProfileInputData.getUser());
        assert allMatch;
    }
}