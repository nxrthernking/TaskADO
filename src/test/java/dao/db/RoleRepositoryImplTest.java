package dao.db;

import entities.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

class RoleRepositoryImplTest {

    private static final Long ID = 1L;

    private static final Role ROLE = new Role(ID,"ROLE_USER");

    private RoleRepositoryImpl repository;

    @BeforeEach
    void setUp() throws SQLException, ClassNotFoundException {
        repository = new RoleRepositoryImpl();
    }

    @Test
    void shouldGetRoleOnFindById(){
        Assertions.assertEquals(ROLE,repository.findById(ID));
    }

    @Test
    void shouldGetRoleListOnFindAll(){
        Assertions.assertEquals(List.of(ROLE),repository.findAll());
    }

}
