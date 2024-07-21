package data_access.objects.question;

import data_access.interfaces.question.QuestionUpdateDataAccessInterface;
import entity.comment.Question;

import java.sql.*;

/**
 * DatabaseQuestionUpdateDataAccessObject is responsible for updating a question in the database.
 * It implements the QuestionUpdateDataAccessInterface.
 */
public class DatabaseQuestionUpdateDataAccessObject implements QuestionUpdateDataAccessInterface {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private String query;

    /**
     * Constructs a DatabaseQuestionUpdateDataAccessObject and establishes a connection to the database.
     *
     * @throws SQLException if a database access error occurs
     */
    public DatabaseQuestionUpdateDataAccessObject() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
    }

    /**
     * Updates the specified question in the database.
     *
     * @param question the question to be updated
     * @throws SQLException if a database access error occurs
     */
    @Override
    public void updateQuestion(Question question) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");

        query = "UPDATE Comments SET AnswerUserID = ?, AnswerDescription = ? WHERE CommentID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, question.getAnswer().getStudentNumber());
        preparedStatement.setString(2, question.getAnswer().getDescription());
        preparedStatement.setString(3, question.getQuestionID());
        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
