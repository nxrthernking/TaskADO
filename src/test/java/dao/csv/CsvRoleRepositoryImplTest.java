package dao.csv;

import Utils.FileUtils;
import entities.Role;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

class CsvRoleRepositoryImplTest {



    public static final Long ID = 1L;

    public static final long INCORRECT_ID = 33L;

    private static final Role ROLE_ADMIN = new Role(1L,"ADMIN");
    private static final Role ROLE_USER = new Role(2L,"USER");
    private static final Role ROLE_EMPLOYEE = new Role(3L,"EMPLOYEE");

    private static final CsvRoleRepositoryImpl repository = new CsvRoleRepositoryImpl();;

    @Test
    void shouldGetRoleAdminOnFindById(){
        Assertions.assertEquals(ROLE_ADMIN,repository.findById(ID));
    }

    @Test
    void shouldGetEmployeeListOnFindAll(){
        Assertions.assertTrue(List.of(ROLE_ADMIN,ROLE_EMPLOYEE,ROLE_USER).containsAll(repository.findAll()));
    }

    @Test
    void shouldThrowNoSuchElementExceptionOnFindById(){
        Assertions.assertThrows(NoSuchElementException.class,() -> repository.findById(INCORRECT_ID));
    }


}