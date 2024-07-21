package data_access.objects.question;

import data_access.interfaces.question.QuestionReadDataAccessInterface;
import entity.comment.*;

import java.sql.*;
import java.util.ArrayList;

/**
 * DatabaseQuestionReadDataAccessObject is responsible for retrieving questions related to a product from the database.
 * It implements the QuestionReadDataAccessInterface.
 */
public class DatabaseQuestionReadDataAccessObject implements QuestionReadDataAccessInterface {
    private Connection connection;
    private final QuestionFactory questionFactory;
    private final AnswerFactory answerFactory;
    private PreparedStatement preparedStatement;
    private String query;
    private ResultSet resultSet;

    /**
     * Constructs a DatabaseQuestionReadDataAccessObject and establishes a connection to the database.
     *
     * @param questionFactory a factory for creating Question objects
     * @param answerFactory   a factory for creating Answer objects
     * @throws SQLException if a database access error occurs
     */
    public DatabaseQuestionReadDataAccessObject(QuestionFactory questionFactory, AnswerFactory answerFactory) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
        this.questionFactory = questionFactory;
        this.answerFactory = answerFactory;
    }

    /**
     * Retrieves questions related to the specified product from the database.
     *
     * @param productID the ID of the product whose questions are to be retrieved
     * @return a list of questions related to the specified product
     * @throws SQLException if a database access error occurs
     */
    @Override
    public ArrayList<Question> getQuestion(String productID) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");

        String questionUserID;
        String answerUserID;
        String questionDescription;
        String answerDescription;
        String questionID;
        Answer answer;
        ArrayList<Question> listQuestions = new ArrayList<>();

        query = "SELECT * FROM Comments WHERE ProductID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, productID);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            questionID = resultSet.getString("CommentID");
            questionUserID = resultSet.getString("QuestionUserID");
            questionDescription = resultSet.getString("QuestionDescription");
            answerUserID = resultSet.getString("AnswerUserID");
            answerDescription = resultSet.getString("AnswerDescription");

            answer = answerFactory.createAnswer(answerDescription, answerUserID);
            listQuestions.add(questionFactory.createQuestion(questionDescription, questionUserID, answer, questionID));
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return listQuestions;
    }
}
