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
        User userFromDb = repository.findById(2L);
        assertEquals(user, userFromDb);
    }

    @Test
    public void save(){
        repository.save(user);
    }

    @Test
    public void findAll() {
        List<User> users = repository.findAll();
        Assert.assertNotNull(users);

    }

}