package entity.user;

/**
 * The core business rule.
 * studentNumber is the key to access all modify_product belonging to the user.
 * studentNumber should be unique, and we can use this to check if a user does exist.
 * Provide all getter method
 * @author CompileError group
 */

public class CommonUser implements User{
    String name;
    String password;
    String email;
    float userRating;
    String studentNumber;

    public CommonUser(String name, String Password, String email, float userRating, String studentNumber){
        this.name = name;
        this.password = Password;
        this.email = email;
        this.userRating = userRating;
        this.studentNumber = studentNumber;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public float getUserRating() {
        return userRating;
    }

    @Override
    public String getStudentNumber() {
        return studentNumber;
    }
}
