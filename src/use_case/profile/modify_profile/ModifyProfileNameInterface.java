package use_case.profile.modify_profile;

import entity.user.User;

import java.sql.SQLException;

public interface ModifyProfileNameInterface {

    boolean execute(User user) throws SQLException;
}