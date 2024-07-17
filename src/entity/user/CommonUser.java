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

    /**
     * Constructs a {@code CommonUser} object with the specified name, password, email, user rating, and student number.
     *
     * @param name         the name of the user
     * @param password     the password of the user
     * @param email        the email address of the user
     * @param userRating   the rating of the user
     * @param studentNumber the student number associated with the user
     */

    public CommonUser(String name, String password, String email, float userRating, String studentNumber){
        this.name = name;
        this.password = password;
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
