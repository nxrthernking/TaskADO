package dao.db;

import entities.User;
import handlers.DbHandler;
import repositories.UserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository<User,Long> {

    private  Connection connection;
    private Statement statement;

    public UserRepositoryImpl() throws SQLException, ClassNotFoundException {
        this.connection = DbHandler.getConnection();
        this.statement = connection.createStatement();
    }

    @Override
    public User findById(Long id) {
        User user = null;
        String sql = "SELECT * FROM t_user WHERE id=" + id;
        try {
            ResultSet resultset = statement.executeQuery(sql);
            while(resultset.next()){
                user = new User();
                user.setId(resultset.getLong("id"));
                user.setUsername(resultset.getString("username"));
                user.setPassword(resultset.getString("password"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO t_user(username,password) VALUES(?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        User user = null;
        String sql = "SELECT * FROM t_user";
        try {
            ResultSet resultset = statement.executeQuery(sql);
            while(resultset.next()){
                user = new User();
                user.setId(resultset.getLong("id"));
                user.setUsername(resultset.getString("username"));
                user.setPassword(resultset.getString("password"));
                users.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return users;
    }

    @Override
    public void remove(Long id) {
        String sql = "DELETE FROM t_user WHERE id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1,id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
