package data_access.objects;

import data_access.interfaces.QuestionReadDataAccessInterface;
import entity.CommonQuestionFactory;
import entity.Question;
import entity.QuestionFactory;

import java.sql.*;

public class DatabaseQuestionReadDataAccessObject implements QuestionReadDataAccessInterface {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private QuestionFactory questionFactory = (QuestionFactory) new CommonQuestionFactory();

    public DatabaseQuestionReadDataAccessObject() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
    }

    @Override
    public Question getQuestion(String posterId) throws SQLException {
        String query = "SELECT * FROM Comments WHERE UserID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, posterId);
        resultSet = preparedStatement.executeQuery();
        Question question = null;
        if (resultSet.next()) {
            String userID = resultSet.getString("UserID");
            String description = resultSet.getString("Description");
            String answer = resultSet.getString("Answer");
//            question = questionFactory.createQuestion(description, userID, answer);
        }
        return null;
    }
}
