package CsvServices;

import DbServices.UserService;
import Entities.User;
import Repositories.UserRepository;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CsvUserService implements UserRepository<User,Long> {

    private final CsvToBean<User> csvToBean;

    private final StatefulBeanToCsv sbc;

    @SuppressWarnings({"rawtypes", "unchecked"})
    public CsvUserService() throws IOException {
        csvToBean = new CsvToBeanBuilder(Files.newBufferedReader(Paths.get("src/User.csv")))
                .withType(User.class).withIgnoreLeadingWhiteSpace(true)
                .build();

        sbc =  new StatefulBeanToCsvBuilder(new FileWriter("src/User.csv"))
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .build();
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public void save(User user) {
        try {
            List<User> list = new UserService().findAll();
            sbc.write(list);
        } catch (SQLException | ClassNotFoundException | CsvRequiredFieldEmptyException
                | CsvDataTypeMismatchException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public List<User> findAll() {
        List<User> users = new LinkedList<>();

        for (User user : (Iterable<User>) csvToBean) {
            users.add(user);
        }

       return users;
    }

    @Override
    public void remove(Long id) {

    }
}
