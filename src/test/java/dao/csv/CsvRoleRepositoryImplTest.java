package dao.csv;

import Utils.FileUtils;
import entities.Role;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CsvRoleRepositoryImplTest {


    private Role role;

    private CsvRoleRepositoryImpl repository;

    @Before
    public void init(){
        role = new Role(1L,"ADMIN");
        repository = new CsvRoleRepositoryImpl();
    }


    @Test
    public void tanyaCalculator(){
        System.out.println(96%13);
    }

    @Test
    public void findById() {
        Role actualRole = repository.findById(1L);
        Assert.assertEquals(role,actualRole);
    }

    @Test
    public void save() {
        repository.save(role);
    }

    @Test
    public void findAll() {
        List<Role> roles = repository.findAll();
        Assert.assertEquals(3L,roles.size());
    }

    @Test
    public void remove() {
        repository.remove(1L);
        Assert.assertEquals(2,repository.findAll().size());
    }
}