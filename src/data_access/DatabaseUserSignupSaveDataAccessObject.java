package data_access;

import entity.User;

import java.sql.*;

public class DatabaseUserSignupSaveDataAccessObject implements UserSignupDataAccessInterface {
    private final Connection connection;
    private final Statement statement;
    private PreparedStatement preparedStatement = null;
    private User user;

    public DatabaseUserSignupSaveDataAccessObject() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/207project", "root", "Hz04.05.19");
        statement = connection.createStatement();
        this.user = user;

    }
    @Override
    public boolean existsByUTorID(String identifier) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT id FROM tb_user");
        while (resultSet.next()) {
            if (resultSet.getString("id").equals(identifier)) {
                resultSet.close();
                statement.close();
                connection.close();
                return true;
            }
        }
        resultSet.close();
        statement.close();
        connection.close();
        return false;

    }

    @Override
    public void saveUser(User user) throws SQLException {
        String insertSQL = "INSERT INTO tb_user (id, name, email, password, createdate) VALUES (?,?,?,?,?)";
        preparedStatement = connection.prepareStatement(insertSQL);

        preparedStatement.setString(1, user.getUtroid());
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3, user.getPassword());
        preparedStatement.setString(4, user.getPassword());

        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        preparedStatement.setDate(5, sqlDate);
        preparedStatement.executeUpdate();

        preparedStatement.close();
        statement.close();
        connection.close();
    }

    public static void main(String[] args) throws SQLException {
        DatabaseUserSignupSaveDataAccessObject dataAccessObject = new DatabaseUserSignupSaveDataAccessObject();
        System.out.println(dataAccessObject.existsByUTorID("1"));

    }
}
