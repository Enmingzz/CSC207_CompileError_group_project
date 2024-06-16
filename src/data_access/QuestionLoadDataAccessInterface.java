package data_access;

import entity.Question;

import java.sql.SQLException;

public interface QuestionLoadDataAccessInterface {
    public Question loadQuestion(String question) throws SQLException;
}
