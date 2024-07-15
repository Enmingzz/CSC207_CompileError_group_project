package use_case.modify_product;

import use_case.profile.modify_profile.ModifyProfileOutputData;

import java.io.IOException;
import java.sql.SQLException;

public interface ChangeProductOutputBoundary {
    public void prepareSuccessfulView(ChangeProductOutputData changeProductOutputData) throws SQLException, IOException;

}
