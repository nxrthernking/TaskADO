package DbServices;

import Entities.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserServiceTest {

    private UserService userService;

    private User expectedUser;

    @BeforeEach
    void init() throws SQLException, ClassNotFoundException {
        userService = new UserService();
        expectedUser = new User();
        expectedUser.setId(1L);
        expectedUser.setUsername("bimo211");
        expectedUser.setPassword("1337322");
    }


    @Test
    public void findById() {
        User userFromDb = userService.findById(1L);

        assertEquals(expectedUser, userFromDb);
    }

    @Test
    public void findAll() {
        List<User> users = userService.findAll();
        Assert.assertNotNull(users);

    }

}