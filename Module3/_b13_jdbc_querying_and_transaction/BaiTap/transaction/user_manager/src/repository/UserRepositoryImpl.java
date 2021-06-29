package repository;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        try {
            Statement statement = this.baseRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "select id,`name`, email, country\n" +
                            "from users;"
            );
            User user = null;
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public User findById(int id) {
        User user = null;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(
                    "select id,`name`,email,country from users where id =?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void deleteUser(int id) {
        int row = 0;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(
                    "delete from users where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateUser(int id, User user) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(
                    "update users set `name` = ?,email= ?, country =? where id = ?");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertUser(User user) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(
                    "INSERT INTO users(`name`, email, country) VALUES(?, ?, ?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> findCountry(String country) {
        List<User> userList = new ArrayList<>();
        User user = null;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(
                    "select*from users where country = (?);"
            );
            preparedStatement.setString(1, country);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setCountry(resultSet.getString("country"));
                user.setEmail(resultSet.getString("email"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    // ---------------------------  Stored Procedures ---------------------------------- //
    @Override
    public List<User> findAllUser() {
        List<User> userList = new ArrayList<>();
        String query = "call find_all_user()";
        try {
            CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall(query);
            ResultSet resultSet = callableStatement.executeQuery();
            User user = null;
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    @Override
    public User findUserById(int id) {
        User user = null;
        String query = "call get_user_by_id(?)";
        try {
            CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall(query);
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void updateUsers(int id, User user) {
        String query = "call update_user(?,?,?,?)";
        try {
            CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall(query);
            callableStatement.setInt(1, id);
            callableStatement.setString(2, user.getName());
            callableStatement.setString(3, user.getEmail());
            callableStatement.setString(4, user.getCountry());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUsers(int id) {
        String query = "call delete_user(?)";
        try {
            CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall(query);
            callableStatement.setInt(1, id);
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String addUserTransaction(User user) {
        String msg = "transaction successfully!";
        Connection connection = this.baseRepository.getConnection();
        int rowAffect;
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(
                    "INSERT INTO users(`name`, email, country) VALUES(?, ?, ?)");
            if (user.getName().equals("") || user.getEmail().equals("") || user.getCountry().equals("")) {
                rowAffect = 0;
            } else {
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getEmail());
                preparedStatement.setString(3, user.getCountry());
                rowAffect = preparedStatement.executeUpdate();
            }
            if (rowAffect == 1) {
                connection.commit();
            } else {
                msg = "rollback try";
                connection.rollback();
            }
        } catch (SQLException e) {
            try {
                msg = "rollback catch";
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return msg;
    }
}
