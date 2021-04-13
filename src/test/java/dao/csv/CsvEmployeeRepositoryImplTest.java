package dao.csv;

import entities.Employee;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

class CsvEmployeeRepositoryImplTest {

    public static final Long ID = 1L;

    public static final Long INCORRECT_ID = 2L;

    private static final Employee EMPLOYEE = new Employee(ID,
            "Petter",
            "Griffin",
            "+375293221312",
            "st. Spooner");;

    private static final CsvEmployeeRepositoryImpl repository =  new CsvEmployeeRepositoryImpl();;

    @Test
    void shouldGetEmployeeOnFindById(){
        Assertions.assertEquals(EMPLOYEE,repository.findById(ID));
    }

    @Test
    void shouldGetEmployeeListOnFindAll(){
        Assertions.assertEquals(List.of(EMPLOYEE),repository.findAll());
    }

    @Test
    void shouldThrowNoSuchElementExceptionOnFindById(){
        Assertions.assertThrows(NoSuchElementException.class,() -> repository.findById(INCORRECT_ID));
    }

}