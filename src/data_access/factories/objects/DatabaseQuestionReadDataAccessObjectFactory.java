package data_access.factories.objects;

import data_access.interfaces.QuestionReadDataAccessInterface;
import data_access.factories.interfaces.DatabaseQuestionReadDataAccessObjectFactoryInterface;
import data_access.objects.DatabaseQuestionReadDataAccessObject;
import entity.comment.AnswerFactory;
import entity.comment.QuestionFactory;

import java.sql.SQLException;

public class DatabaseQuestionReadDataAccessObjectFactory implements DatabaseQuestionReadDataAccessObjectFactoryInterface {
    @Override
    public QuestionReadDataAccessInterface create(QuestionFactory questionFactory, AnswerFactory answerFactory) throws SQLException {
        return new DatabaseQuestionReadDataAccessObject(questionFactory, answerFactory);
    }
}
