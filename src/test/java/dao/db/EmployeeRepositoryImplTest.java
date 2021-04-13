package dao.db;

import entities.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

class EmployeeRepositoryImplTest {

    private EmployeeRepositoryImpl repository;

    private static Employee EMPLOYEE =
            new Employee(2L,"Petter","Griffin","+375293221312","Spooner/12");

    private static Long ID = 2L;

    @BeforeEach
    void setUp() throws SQLException, ClassNotFoundException {
        repository = new EmployeeRepositoryImpl();
    }

    @Test
    public void shouldGetEmployeeOnFindById() {
        Assertions.assertEquals(EMPLOYEE,repository.findById(ID));
    }

    @Test
    public void shouldGetEmployeeListOnFindAll(){
        Assertions.assertEquals(List.of(EMPLOYEE),repository.findAll());
    }
}
