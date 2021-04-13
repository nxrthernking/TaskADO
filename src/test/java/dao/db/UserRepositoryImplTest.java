package dao.db;

import entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class UserRepositoryImplTest {

    private UserRepositoryImpl repository;

    private static final Long ID = 1L;

    private static final User USER = new User(ID,"user","user");

    @BeforeEach
    public void init()  {
        repository = new UserRepositoryImpl();
    }

    @Test
    void shouldGetUserOnFindById(){
        Assertions.assertEquals(USER,repository.findById(ID));
    }

    @Test
    void shouldGetUserListOnFindAll(){
        Assertions.assertEquals(List.of(USER),repository.findAll());
    }


}