package data_access.interfaces;

import entity.Question;

import java.sql.SQLException;

public interface QuestionReadDataAccessInterface {
    Question getQuestion(String question) throws SQLException;
}
