package use_case.view_product;

import java.sql.SQLException;

public interface ReplyQuestionInputBoundary {
    public void execute(ReplyQuestionInputData replyQuestionInputData) throws SQLException;
}
