package use_case.profile.modify_profile;

import data_access.in_memory.user.InMemoryUserDataReadAccessObject;
import data_access.in_memory.user.InMemoryUserUpdateNameDataAccessObject;
import data_access.interfaces.user.UserReadDataAccessInterface;
import data_access.interfaces.user.UserUpdateNameDataAccessInterface;
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

class ModifyProfileNameInteractorTest {
    private UserUpdateNameDataAccessInterface inMemoryUserUpdateNameDataAccessObject;
    private UserReadDataAccessInterface inMemoryUserDataReadAccessObject;

    private ModifyProfileInputData modifyProfileInputData;
    private ModifyProfileNameInterface modifyProfileNameInterface;

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

        modifyProfileNameInterface = new ModifyProfileName(inMemoryUserUpdateNameDataAccessObject, inMemoryUserDataReadAccessObject);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void executeOneUser() throws SQLException {
        String newName = "Hello";
        User newUser = new CommonUser(newName, "123456", "hanrui@mail", 0, "123456");
        modifyProfileInputData = new ModifyProfileInputData(newUser);

        boolean allMatch = users.stream().allMatch(element -> newName.equals(element.getName()));
        assert modifyProfileNameInterface.execute(modifyProfileInputData.getUser());
        assert allMatch;
    }

    @Test
    void executeMultipleUser() throws SQLException {
        for (int i = 0; i < 3; i++){
            byte[] array = new byte[7];
            new Random().nextBytes(array);
            String generatedString = new String(array, StandardCharsets.UTF_8);
            users.add(new CommonUser(generatedString, "123456", "hanrui@mail",
                    0, String.valueOf(i * 10)));
        }
        String newName = "Hello";
        User newUser = new CommonUser(newName, "123456", "hanrui@mail", 0, "123456");

        inMemoryUserUpdateNameDataAccessObject = new InMemoryUserUpdateNameDataAccessObject(users, new CommonUserFactory());
        inMemoryUserDataReadAccessObject = new InMemoryUserDataReadAccessObject(users, new CommonUserFactory());

        modifyProfileInputData = new ModifyProfileInputData(newUser);
        modifyProfileNameInterface = new ModifyProfileName(inMemoryUserUpdateNameDataAccessObject, inMemoryUserDataReadAccessObject);


        assert modifyProfileNameInterface.execute(modifyProfileInputData.getUser());
        assertEquals(newName, users.get(0).getName());
    }

    @Test
    void executeNoChanged() throws SQLException {

        boolean allMatch = users.stream().allMatch(element -> "hanrui".equals(element.getName()));
        assert !modifyProfileNameInterface.execute(modifyProfileInputData.getUser());
        assert allMatch;
    }
}