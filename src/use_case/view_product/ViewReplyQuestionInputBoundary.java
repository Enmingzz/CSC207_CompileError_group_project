package use_case.view_product;

import java.sql.SQLException;

public interface ViewReplyQuestionInputBoundary {
    void execute(ViewReplyQuestionInputData viewReplyQuestionInputData) throws SQLException;
}
