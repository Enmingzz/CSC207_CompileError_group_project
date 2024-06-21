package use_case;

import java.sql.SQLException;

public interface ReplyQuestionInputBoundary {
    public void execute(ReplyQuestionInputData replyQuestionInputData) throws SQLException;
}
