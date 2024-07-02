package data_access.factories.objects.question;

import data_access.interfaces.question.QuestionReadDataAccessInterface;
import data_access.factories.interfaces.question.DatabaseQuestionReadDataAccessObjectFactoryInterface;
import data_access.objects.question.DatabaseQuestionReadDataAccessObject;
import entity.comment.AnswerFactory;
import entity.comment.QuestionFactory;

import java.sql.SQLException;

public class DatabaseQuestionReadDataAccessObjectFactory implements DatabaseQuestionReadDataAccessObjectFactoryInterface {
    @Override
    public QuestionReadDataAccessInterface create(QuestionFactory questionFactory, AnswerFactory answerFactory) throws SQLException {
        return new DatabaseQuestionReadDataAccessObject(questionFactory, answerFactory);
    }
}
