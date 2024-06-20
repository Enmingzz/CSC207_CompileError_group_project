package use_case;


import java.sql.SQLException;

public interface PublishQuestionInputBoundary {
    void execute(PublishQuestionInputData publishQuestionInputData) throws SQLException;
}
