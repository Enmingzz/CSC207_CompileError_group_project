package entity;

/**
 * The superclass of CommonAnswer and CommonQuestion. Two getter method override the methods in two interfaces Answer and Question.
 * Two attributes private String description and private CommonUser postUser
 * @author CompileError group
 */
public class CommonComment implements Comment{
    private String description;
    private CommonUser postedUser;

    public CommonComment(String description, CommonUser postedUser) {
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
