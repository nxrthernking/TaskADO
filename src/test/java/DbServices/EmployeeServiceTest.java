package DbServices;

import Entities.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.sql.SQLException;
import java.util.List;

public class EmployeeServiceTest {

    private EmployeeService employeeService;

    private Employee expected;

    @BeforeEach
    public void init() throws SQLException, ClassNotFoundException {
        employeeService = new EmployeeService();
        expected = new Employee("qwe", "qwe", "34567", "asd");
        expected.setId(1L);
    }

    @Test
    public void findById() {
        Employee employeeFromDb = employeeService.findById(1L);
        Assert.assertEquals(expected, employeeFromDb);
    }


    @Test
    public void findAll() {
        List<Employee> employees = employeeService.findAll();
        Assert.assertNotNull(employees);
    }


}