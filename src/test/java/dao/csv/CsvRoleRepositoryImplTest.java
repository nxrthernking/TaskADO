package dao.csv;

import entities.Role;
import org.junit.Before;
import org.junit.Test;

public class CsvRoleRepositoryImplTest {


    private Role role;

    private CsvRoleRepositoryImpl repository;

    @Before
    public void init(){
        role = new Role(1L,"ADMIN");
        repository = new CsvRoleRepositoryImpl();
    }

    @Test
    public void findById() {
    }

    @Test
    public void save() {
        repository.save(role);
    }

    @Test
    public void findAll() {
    }

    @Test
    public void remove() {
    }
}