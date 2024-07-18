package entity.user;

/**
 * Provide the interface of CommonUserFactory
 * @author CompileError group
 */

public interface UserFactory {
    public User createUser(String name, String Password, String email, float userRating, String studentNumber);
    }
