package data_access.interfaces;

import entity.Question;

import java.sql.SQLException;

public interface QuestionUpdateDataAccessInterface {
    void updateQuestion(Question question) throws SQLException;
}
