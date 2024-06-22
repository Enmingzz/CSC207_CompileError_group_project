package data_access.objects;

import data_access.interfaces.QuestionUpdateDataAccessInterface;
import entity.comment.Answer;
import entity.comment.Question;

import java.sql.*;

public class DatabaseQuestionUpdateDataAccessObject implements QuestionUpdateDataAccessInterface {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private String query;

    public DatabaseQuestionUpdateDataAccessObject() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
    }

    @Override
    public void updateQuestion(Question question) throws SQLException {
        query = "UPDATE Comments SET AnswerUserID = ?, AnswerDescription = ? WHERE QuestionUserID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, question.getAnswer().getStudentNumber());
        preparedStatement.setString(2, question.getAnswer().getDescription());
        preparedStatement.setString(3, question.getStudentNumber());
        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }
}
