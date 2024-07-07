package data_access.in_memory.question;

import data_access.interfaces.question.QuestionUpdateDataAccessInterface;
import entity.comment.Question;

import java.sql.SQLException;

public class InMemoryQuestionUpdateDataAccessObject implements QuestionUpdateDataAccessInterface {

    @Override
    public void updateQuestion(Question questionID) throws SQLException {

    }
}
