package entity;

/**
 * The superclass of CommonAnswer and CommonQuestion. Two getter method override the methods in two interfaces Answer and Question.
 * Two attributes private String description and private CommonUser postUser
 * @author CompileError group
 */
public class CommonComment implements Comment{
    private String description;
    private User postedUser;

    public CommonComment(String description, User postedUser) {
        this.description = description;
        this.postedUser = postedUser;
    }
    public String getDescription() {
        return description;
    }

    public User getPostedUser() {
        return postedUser;
    }
}
