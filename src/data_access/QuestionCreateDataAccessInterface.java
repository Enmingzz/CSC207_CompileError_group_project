package data_access;

import entity.Question;

import java.sql.SQLException;

public interface QuestionCreateDataAccessInterface {
    void saveQuestion(Question question) throws SQLException;
}
