package DbServices;

import Entities.User;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserServiceTest {

    UserService userService;

    public UserServiceTest() throws SQLException, ClassNotFoundException {
        userService = new UserService();
    }



    @Test
    public void findById() {
        User userFromDb = userService.findById(1L);
        User expectedUser = new User();
        expectedUser.setId(1L);
        expectedUser.setUsername("bimo211");
        expectedUser.setPassword("1337322");

        assertEquals(expectedUser,userFromDb);
    }

    @Test
    public void findAll(){
        List<User> users = userService.findAll();

        Assert.assertNotNull(users);

    }

}