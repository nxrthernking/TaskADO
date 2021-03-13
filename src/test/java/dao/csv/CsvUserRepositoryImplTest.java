package dao.csv;

import entities.User;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

class CsvUserRepositoryImplTest {

    private CsvUserRepositoryImpl service;

    private User user;


    @BeforeEach
    void init() throws IOException {
        service = new CsvUserRepositoryImpl();
        user = new User();
        user.setId(3L);
        user.setUsername("qwe");
        user.setPassword("pass");
    }

    @Test
    void save() {
        service.save(user);
    }

    @Test
    void read() {
        List<User> list = service.findAll();
        Assert.assertEquals(3,list.size());
    }
}