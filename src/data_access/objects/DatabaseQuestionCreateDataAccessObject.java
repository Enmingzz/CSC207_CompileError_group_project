package data_access.objects;

import data_access.interfaces.QuestionCreateDataAccessInterface;
import entity.Question;

import java.sql.*;

public class DatabaseQuestionCreateDataAccessObject implements QuestionCreateDataAccessInterface {
    @Override
    public void saveQuestion(Question question) throws SQLException {
        //should implement this
    }


}
