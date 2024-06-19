package data_access;

import entity.Question;

import java.sql.*;

public class DatabaseQuestionReadDataAccessObject implements QuestionReadDataAccessInterface {
    private final Connection connection;
    private final Statement statement;

    public DatabaseQuestionReadDataAccessObject() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/207project", "root", "Hz04.05.19");
        this.statement = connection.createStatement();
    }

    @Override
    public Question loadQuestion(String posterId) throws SQLException {
        String query = "SELECT * FROM Questions WHERE PostUserID = '" + posterId + "'";
        ResultSet resultSet = statement.executeQuery(query);
        if (resultSet.next()) {
            String postUserID = resultSet.getString("PostUserID");
            String description = resultSet.getString("Description");
            String answerID = resultSet.getString("AnswerID");

        }
        return null;
    }
}
