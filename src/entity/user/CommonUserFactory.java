package entity.user;

public class CommonUserFactory implements UserFactory{

    /**
     * Creates a new instance of {@link CommonUser} with the specified name, password, email, user rating, and student number.
     *
     * @param name         the name of the user
     * @param password     the password of the user
     * @param email        the email address of the user
     * @param userRating   the rating of the user
     * @param studentNumber the student number associated with the user
     * @return a new {@link CommonUser} instance
     */

    public User createUser(String name, String password, String email, float userRating, String studentNumber){
        return new CommonUser(name, password, email, userRating, studentNumber);
    }
}
