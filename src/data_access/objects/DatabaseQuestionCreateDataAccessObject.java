package data_access.objects;

import data_access.interfaces.QuestionCreateDataAccessInterface;
import entity.comment.Question;
import entity.product.Product;

import java.sql.*;

public class DatabaseQuestionCreateDataAccessObject implements QuestionCreateDataAccessInterface {
    @Override
    public void saveQuestion(Question question, Product product) throws SQLException {
        //should implement this
    }


}
