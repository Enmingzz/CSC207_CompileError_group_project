package use_case.view_product;

import java.sql.SQLException;

public interface PublishQuestionOutputBoundary {
    void prepareSuccessView(PublishQuestionOutputData publishQuestionOutputData) throws SQLException;
}
