package dao;

import Entities.Employee;
import dao.db.EmployeeRepositoryImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.sql.SQLException;
import java.util.List;

public class EmployeeRepositoryImplTest {

    private EmployeeRepositoryImpl employeeRepositoryImpl;

    private Employee expected;

    @BeforeEach
    public void init() throws SQLException, ClassNotFoundException {
        employeeRepositoryImpl = new EmployeeRepositoryImpl();
        expected = new Employee("qwe", "qwe", "34567", "asd");
        expected.setId(1L);
    }

    @Test
    public void findById() {
        Employee employeeFromDb = employeeRepositoryImpl.findById(1L);
        Assert.assertEquals(expected, employeeFromDb);
    }


    @Test
    public void findAll() {
        List<Employee> employees = employeeRepositoryImpl.findAll();
        Assert.assertNotNull(employees);
    }


}