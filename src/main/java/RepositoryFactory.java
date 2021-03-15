import dao.csv.CsvEmployeeRepositoryImpl;
import dao.csv.CsvRoleRepositoryImpl;
import dao.csv.CsvUserRepositoryImpl;
import dao.db.EmployeeRepositoryImpl;
import dao.db.RoleRepositoryImpl;
import dao.db.UserRepositoryImpl;
import entities.Employee;
import entities.Role;
import entities.User;
import repositories.Repository;

import java.sql.SQLException;

public class RepositoryFactory {

    private enum RepositoryKind{
        EMPLOYEE_DB{
            @Override
            Repository<Employee,Long> getRepository() throws SQLException, ClassNotFoundException {
                return new EmployeeRepositoryImpl();
            }
        },
        EMPLOYEE_CSV{
            @Override
            Repository<Employee,Long> getRepository() throws SQLException, ClassNotFoundException {
                return new CsvEmployeeRepositoryImpl();
            }
        },
        ROLE_DB{
            @Override
            Repository<Role,Long> getRepository() throws SQLException, ClassNotFoundException {
                return new RoleRepositoryImpl();
            }
        },
        ROLE_CSV{
            @Override
            Repository<Role,Long> getRepository() throws SQLException, ClassNotFoundException {
                return new CsvRoleRepositoryImpl();
            }
        },
        USER_DB{
            @Override
            Repository<User,Long> getRepository() throws SQLException, ClassNotFoundException {
                return new UserRepositoryImpl();
            }
        },
        USER_CSV{
            @Override
            Repository<User,Long> getRepository() throws SQLException, ClassNotFoundException {
                return new CsvUserRepositoryImpl();
            }
        }
        ;
        abstract Repository getRepository() throws SQLException, ClassNotFoundException;
    }

    public static Repository getRepositoryFromFactory(String repositoryType) throws SQLException,
            ClassNotFoundException {
        return RepositoryKind.valueOf(repositoryType).getRepository();
    }
}
