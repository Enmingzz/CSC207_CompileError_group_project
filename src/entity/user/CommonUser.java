package entity.user;

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
