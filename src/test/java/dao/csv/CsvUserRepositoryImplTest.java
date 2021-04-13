package dao.csv;

import entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;


class CsvUserRepositoryImplTest {

    public static final CsvUserRepositoryImpl repository = new CsvUserRepositoryImpl();

    public static final long ID = 1L;

    public static final Long INCORRECT_ID = 33L;

    private static final User USER = new User(ID, "user", "user");

    @Test
    void shouldGetNotEmptyUserListOnFindAll() {
        Assertions.assertEquals(List.of(USER), repository.findAll());
    }

    @Test
    void shouldGetUserOnFindById() {
        Assertions.assertEquals(USER, repository.findById(ID));
    }

    @Test
    void shouldThrowNoSuchElementExceptionOnFindById(){
        Assertions.assertThrows(NoSuchElementException.class,() -> repository.findById(INCORRECT_ID));
    }
}