package use_case.view_product;

import java.sql.SQLException;

public interface PublishQuestionInputBoundary {
    void execute(PublishQuestionInputData publishQuestionInputData) throws SQLException;
}
