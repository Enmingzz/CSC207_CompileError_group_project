package data_access;

import entity.User;

import java.sql.*;

public class DatabaseUserSignupSaveDataAccessObject implements UserSignupDataAccessInterface {
    private final Connection connection;
    private final Statement statement;
    private PreparedStatement preparedStatement = null;
    private User user;

    public DatabaseUserSignupSaveDataAccessObject() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "Hz04.05.19");
        statement = connection.createStatement();

    }
    @Override
    public boolean existsByUTorID(String identifier) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT id FROM tb_user");
        while (resultSet.next()) {
            if (resultSet.getString("id").equals(identifier)) {
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

        preparedStatement.setInt(1, 123);
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3, user.getPassword());
        preparedStatement.setString(4, user.getPassword());

        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        preparedStatement.setDate(5, sqlDate);
        preparedStatement.executeUpdate();

        statement.close();
        connection.close();

    }
    public void save() throws SQLException {
        String insertSQL = "INSERT INTO tb_user (id, name, email, password, createdate) VALUES (?,?,?,?,?)";
        preparedStatement = connection.prepareStatement(insertSQL);

        preparedStatement.setInt(1, 1);
        preparedStatement.setString(2, "Haoliang");
        preparedStatement.setString(3, "zhaohaoliang@sina.cn");
        preparedStatement.setString(4, "zh20040519");

        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        preparedStatement.setDate(5, sqlDate);
        preparedStatement.executeUpdate();

        statement.close();
        connection.close();
    }

    public static void main(String[] args) throws SQLException {
        DatabaseUserSignupSaveDataAccessObject test = new DatabaseUserSignupSaveDataAccessObject();
        test.save();
    }
}
