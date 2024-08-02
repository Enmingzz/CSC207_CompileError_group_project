package interface_adapter.map;

import entity.user.User;

public class MapState {
    User user = null;

    public MapState(User user) {
        this.user = user;
    }

    public MapState(){}

    public User getUser() {return user;}

    public void setUser(User user) {this.user = user;}
}
