package data_access.interfaces;

import entity.comment.Question;

import java.sql.SQLException;

public interface QuestionCreateDataAccessInterface {
    void saveQuestion(Question question) throws SQLException;
}
