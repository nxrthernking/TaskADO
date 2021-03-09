package DbServices;

import Entities.Employee;
import Handlers.DbHandler;
import Repositories.EmployeeRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class EmployeeService implements EmployeeRepository<Employee,Long> {

    private Connection connection;
    private Statement statement;

    public EmployeeService() throws SQLException,
            ClassNotFoundException {
        this.connection = DbHandler.getConnection();
        this.statement = connection.createStatement();
    }

    @Override
    public Employee findById(Long id) {
        Employee employeeFromDb = new Employee();
        String sql = "SELECT * FROM employees WHERE id=" + id;
        try {
            ResultSet resultset = statement.executeQuery(sql);
            while(resultset.next()){
                employeeFromDb.setId(resultset.getLong("id"));
                employeeFromDb.setFirstName(resultset.getString("first_name"));
                employeeFromDb.setLastName(resultset.getString("last_name"));
                employeeFromDb.setAddress(resultset.getString("address"));
                employeeFromDb.setTelephone(resultset.getString("telephone"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeFromDb;
    }

    @Override
    public void save(Employee employee) {
        String sql = "INSERT INTO employees(first_name,last_name,address,telephone) values(?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,employee.getFirstName());
            ps.setString(2,employee.getLastName());
            ps.setString(3,employee.getAddress());
            ps.setString(4,employee.getTelephone());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Employee> findAll() {
       List<Employee> employees = new LinkedList<>();
        Employee employeeFromDb;
       String sql = "SELECT * FROM employees";
        try {
            ResultSet resultset = statement.executeQuery(sql);
            while(resultset.next()){
                employeeFromDb = new Employee();
                employeeFromDb.setId(resultset.getLong("id"));
                employeeFromDb.setFirstName(resultset.getString("first_name"));
                employeeFromDb.setLastName(resultset.getString("last_name"));
                employeeFromDb.setAddress(resultset.getString("address"));
                employeeFromDb.setTelephone(resultset.getString("telephone"));
                employees.add(employeeFromDb);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return employees;

    }

    @Override
    public void remove(Long id) {
        String sql = "DELETE FROM employee WHERE id=" + id;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
