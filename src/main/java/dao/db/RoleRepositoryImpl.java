package dao.db;

import entities.Role;
import handlers.DbHandler;
import repositories.RoleRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class RoleRepositoryImpl implements RoleRepository<Role,Long> {

    private Connection connection;
    private Statement statement;

    public RoleRepositoryImpl() throws SQLException, ClassNotFoundException {
        this.connection = DbHandler.getConnection();
        this.statement = connection.createStatement();
    }

    @Override
    public Role findById(Long id) {
        Role role = null;
        String sql = "SELECT * FROM roles WHERE id=" + id;

        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                role = new Role();
                role.setId(resultSet.getLong("id"));
                role.setName(resultSet.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return role;
    }

    @Override
    public void save(Role role) {
        String sql = "INSERT INTO roles(username) values(?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1,role.getId());
            ps.setString(2,role.getName());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Role> findAll() {
        List<Role> roles = new LinkedList<>();
        Role role = null;
        String sql = "SELECT * FROM roles";

        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                role = new Role();
                role.setId(resultSet.getLong("id"));
                role.setName(resultSet.getString("name"));
                roles.add(role);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return roles;
    }

    @Override
    public void remove(Long id) {
        String sql = "DELETE FROM roles WHERE id=" + id;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
