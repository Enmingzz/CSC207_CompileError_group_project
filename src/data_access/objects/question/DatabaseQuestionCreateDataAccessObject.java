package data_access.objects.question;

import data_access.interfaces.question.QuestionCreateDataAccessInterface;
import entity.comment.Question;
import entity.product.Product;

import java.sql.*;

/**
 * DatabaseQuestionCreateDataAccessObject is responsible for saving a question related to a product in the database.
 * It implements the QuestionCreateDataAccessInterface.
 */
public class DatabaseQuestionCreateDataAccessObject implements QuestionCreateDataAccessInterface {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private String query;

    /**
     * Constructs a DatabaseQuestionCreateDataAccessObject and establishes a connection to the database.
     *
     * @throws SQLException if a database access error occurs
     */
    public DatabaseQuestionCreateDataAccessObject() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");
    }

    /**
     * Saves the given question related to the specified product in the database.
     *
     * @param question the question to be saved
     * @param product  the product related to the question
     * @throws SQLException if a database access error occurs
     */
    @Override
    public void saveQuestion(Question question, Product product) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlserver://207project.database.windows.net:1433;" +
                "database=207Project;user=root207@207project;password={Project207};encrypt=true;trustServerCertificate=false;" +
                "hostNameInCertificate=*.database.windows.net;loginTimeout=30");

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
