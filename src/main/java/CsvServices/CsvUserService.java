package CsvServices;

import DbServices.UserService;
import Entities.User;
import Repositories.UserRepository;
import com.opencsv.CSVWriter;
import com.opencsv.bean.*;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@SuppressWarnings({"rawtypes", "unchecked"})
public class CsvUserService implements UserRepository<User,Long> {

    private  CsvToBean<User> csvToBean;

    private  StatefulBeanToCsv sbc;


    public CsvUserService() {
        try {
            csvToBean = new CsvToBeanBuilder(new FileReader("src/User.csv"))
                    .withType(User.class)
                    .withSeparator(',')
                    .build();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findById(Long id) {
        List<User> list = csvToBean.parse();
        return list.stream().
                filter(s -> s.getId().equals(id)).findFirst().orElseThrow();
    }

    @Override
    public void save(User user) {
        List<User> list = csvToBean.parse();
        try(Writer writer = new FileWriter("src/User.csv")) {
            sbc = new StatefulBeanToCsvBuilder(writer)
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                    .build();
            sbc.write(list);
        } catch (IOException | CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> findAll() {

        return csvToBean.parse();
    }

    @Override
    public void remove(Long id) {

    }
}
