package data_access.interfaces;

import entity.comment.Question;

import java.sql.SQLException;

public interface QuestionUpdateDataAccessInterface {
    void updateQuestion(Question questionID) throws SQLException;
}
