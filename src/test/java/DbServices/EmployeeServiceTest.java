package DbServices;

import Entities.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class EmployeeServiceTest {

    private EmployeeService employeeService;

    @Before
    public void init() throws SQLException, ClassNotFoundException {
        employeeService = new EmployeeService();
    }

    @Test
    public void findById() {
        Employee employeeFromDb = employeeService.findById(1L);
        Employee expected = new Employee("qwe","qwe","34567","asd");
        expected.setId(1L);

        Assert.assertEquals(expected,employeeFromDb);
    }

    @Test
    public void save() {
    }

    @Test
    public void findAll() {
        List<Employee> employees = employeeService.findAll();
        Assert.assertNotNull(employees);
    }

    @Test
    public void remove() {
    }
}