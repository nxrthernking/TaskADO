package dao.csv;

import Utils.FileUtils;
import entities.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class CsvEmployeeRepositoryImplTest {

    private  Employee employee;

    private CsvEmployeeRepositoryImpl repository;


    @BeforeEach
    public void init(){
        employee = new Employee(1L,
                "Griffin",
                "Petter",
                "+375293221312",
                "st. Spooner");
        repository = new CsvEmployeeRepositoryImpl();
    }

    @Test
    void findById() {
        Employee actualEmployee = repository.findById(1L);
        Assert.assertEquals(employee,actualEmployee);
    }

    @Test
    void save() {
        repository.save(employee);
        Assert.assertEquals(1L,repository.findAll().size());
    }

    @Test
    void findAll() {
        Assert.assertNotNull(repository.findAll());
    }

    @Test
    void remove() {
        repository.remove(1L);
        Assert.assertEquals(0,repository.findAll().size());
    }
}