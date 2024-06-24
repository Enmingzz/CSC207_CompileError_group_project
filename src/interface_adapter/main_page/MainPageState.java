package interface_adapter.main_page;

import entity.user.User;

public class MainPageState {

    private User user = null;

    public MainPageState() {}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
