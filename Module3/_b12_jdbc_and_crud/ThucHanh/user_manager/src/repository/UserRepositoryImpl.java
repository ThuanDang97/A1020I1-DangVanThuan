package repository;

import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
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
            while (resultSet.next()){
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
    public boolean deleteUser(int id) {
        int row = 0;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(
                    "delete from users where id = ?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return row > 0;
    }

    @Override
    public void updateUser(int id, User user) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(
                    "update users set `name` = ?,email= ?, country =? where id = ?");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setInt(4,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertUser(User user) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(
                    "INSERT INTO users\" + \"  (`name`, email, country) VALUES \" +\n" +
                            "            \" (?, ?, ?);");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
