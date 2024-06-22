package data_access.objects;

import data_access.interfaces.QuestionCreateDataAccessInterface;
import entity.comment.Question;
import entity.product.Product;

import java.sql.*;

public class DatabaseQuestionCreateDataAccessObject implements QuestionCreateDataAccessInterface {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private String query;

    public DatabaseQuestionCreateDataAccessObject() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
    }

    @Override
    public void saveQuestion(Question question, Product product) throws SQLException {
        query = "INSERT INTO Comments (ProductID, QuestionUserID, QuestionDescription) VALUES (?,?,?)";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, product.getProductID());
        preparedStatement.setString(2, question.getStudentNumber());
        preparedStatement.setString(3, question.getDescription());
        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }


}
