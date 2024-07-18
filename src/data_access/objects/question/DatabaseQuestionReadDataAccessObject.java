package data_access.objects.question;

import data_access.interfaces.question.QuestionReadDataAccessInterface;
import entity.comment.*;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseQuestionReadDataAccessObject implements QuestionReadDataAccessInterface {
    private Connection connection;
    private final QuestionFactory questionFactory;
    private final AnswerFactory answerFactory;
    private PreparedStatement preparedStatement;
    private String query;
    private ResultSet resultSet;


    public DatabaseQuestionReadDataAccessObject(QuestionFactory questionFactory, AnswerFactory answerFactory) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
        this.questionFactory = questionFactory;
        this.answerFactory = answerFactory;
    }

    @Override
    public ArrayList<Question> getQuestion(String productID) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
        String questionUserID;
        String answerUserID;
        String questionDescription;
        String answerDescription;
        Answer answer;
        ArrayList<Question> listQuestions = new ArrayList<Question>();

        query = "SELECT * FROM Comments WHERE ProductID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, productID);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            questionUserID = resultSet.getString("QuestionUserID");
            questionDescription = resultSet.getString("QuestionDescription");
            answerUserID = resultSet.getString("AnswerUserID");
            answerDescription = resultSet.getString("AnswerDescription");

            answer = answerFactory.createAnswer(answerDescription, answerUserID);
            listQuestions.add(questionFactory.createQuestion(questionDescription, questionUserID, answer, questionUserID));
        }
        return listQuestions;
    }
}
