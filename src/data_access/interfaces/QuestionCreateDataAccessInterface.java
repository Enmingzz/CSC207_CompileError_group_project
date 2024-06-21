package data_access.interfaces;

import entity.Question;

import java.sql.SQLException;

public interface QuestionCreateDataAccessInterface {
    void saveQuestion(Question question) throws SQLException;
}
