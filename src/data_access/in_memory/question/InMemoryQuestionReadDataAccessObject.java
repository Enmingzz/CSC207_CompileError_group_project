package data_access.in_memory.question;

import data_access.interfaces.question.QuestionReadDataAccessInterface;
import entity.comment.Question;

import java.sql.SQLException;
import java.util.ArrayList;

public class InMemoryQuestionReadDataAccessObject implements QuestionReadDataAccessInterface {

    @Override
    public ArrayList<Question> getQuestion(String productID) throws SQLException {
        return null;
    }
}
