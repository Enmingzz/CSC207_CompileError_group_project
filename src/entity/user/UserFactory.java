package entity.user;

public interface UserFactory {
    public User createUser(String name, String Password, String email, float userRating, String studentNumber);
    }
