package dao.csv;

import entities.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CsvUserRepositoryImplTest {

    private CsvUserRepositoryImpl repository;

    private User user;

    @Before
    public void init(){
        repository = new CsvUserRepositoryImpl();
        user = new User(1L,"user","user");
    }

    @Test
    public void findAll(){
        Assert.assertNotNull(repository.findAll());
    }

    @Test
    public void save(){
        repository.save(user);
        Assert.assertEquals(1,repository.findAll().size());
    }

    @Test
    public void findById(){
        User userFromFile = repository.findById(1L);
        Assert.assertEquals(user,userFromFile);
    }

    @Test
    public void remove(){
        repository.remove(1L);
        Assert.assertEquals(0,repository.findAll().size());
    }


}