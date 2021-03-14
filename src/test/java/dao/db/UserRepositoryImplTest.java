package dao.db;

import entities.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserRepositoryImplTest {

    private UserRepositoryImpl repository;

    private User user;

    @Before
    public void init()  {
        repository = new UserRepositoryImpl();
        user = new User(2L,"bimo211","1234567");
    }


    @Test
    public void findById() {
        assertEquals(user, repository.findById(2L));
    }

    @Test
    public void save(){
        User user = new User();
        user.setUsername("dasda");
        user.setPassword("14124");
        repository.save(user);

    }

    @Test
    public void findAll() {
        Assert.assertNotNull(repository.findAll());
    }

    @Test
    public void remove(){
        repository.remove(5L);
        Assert.assertEquals(3L,repository.findAll().size());

    }

}