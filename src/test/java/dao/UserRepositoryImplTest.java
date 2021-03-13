package dao;

import entities.User;
import dao.db.UserRepositoryImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserRepositoryImplTest {

    private UserRepositoryImpl userRepositoryImpl;

    private User expectedUser;

    @BeforeEach
    void init() throws SQLException, ClassNotFoundException {
        userRepositoryImpl = new UserRepositoryImpl();
        expectedUser = new User();
        expectedUser.setId(1L);
        expectedUser.setUsername("bimo211");
        expectedUser.setPassword("1337322");
    }


    @Test
    public void findById() {
        User userFromDb = userRepositoryImpl.findById(1L);

        assertEquals(expectedUser, userFromDb);
    }

    @Test
    public void findAll() {
        List<User> users = userRepositoryImpl.findAll();
        Assert.assertNotNull(users);

    }

}