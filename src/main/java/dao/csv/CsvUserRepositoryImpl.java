package dao.csv;

import entities.User;
import repositories.UserRepository;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.util.List;

@SuppressWarnings({"rawtypes", "unchecked"})
public class CsvUserRepositoryImpl implements UserRepository<User, Long> {

    private CsvToBean<User> csvToBean;

    private StatefulBeanToCsv sbc;

    private List<User> users;

    public CsvUserRepositoryImpl() {
        try (Writer writer = new FileWriter("src/User.csv")) {
            sbc = new StatefulBeanToCsvBuilder(writer)
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                    .build();

            csvToBean = new CsvToBeanBuilder(new FileReader("src/User.csv"))
                    .withType(User.class)
                    .withSeparator(',')
                    .build();

            users = csvToBean.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findById(Long id) {
        return users.stream().filter(s -> s.getId().equals(id)).findFirst().orElseThrow();
    }

    @Override
    public void save(User user) {
        users.add(user);
        try {
            sbc.write(users);
        } catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<User> findAll() {
       return users;
    }

    @Override
    public void remove(Long id) {
        User user = users.stream().filter(s -> s.getId().equals(id)).findFirst().orElseThrow();
        users.remove(user);
        try {
            sbc.write(users);
        } catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        }
    }
}
