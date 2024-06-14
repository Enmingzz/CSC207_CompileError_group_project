package entity;

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
