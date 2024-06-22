package use_case;

import java.sql.SQLException;

public interface ViewProductInputBoundary {
    public void execute(ViewProductInputData viewProductInputData) throws SQLException;
}

