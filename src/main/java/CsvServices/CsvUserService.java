package CsvServices;

import Entities.User;
import Repositories.UserRepository;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@SuppressWarnings({"rawtypes", "unchecked"})
public class CsvUserService implements UserRepository<User,Long> {

    //private final CsvToBean<User> csvToBean;

    private  StatefulBeanToCsv sbc;


    @Override
    public User findById(Long aLong) {
        return null;
    }

    @Override
    public void save(User user) {
//        try (Writer writer = new FileWriter("src/main/java/test.csv")){
//            ColumnPositionMappingStrategy mappingStrategy = new ColumnPositionMappingStrategy();
//            mappingStrategy.setType(User.class);
//            mappingStrategy.setColumnMapping("id","username","password");
//            sbc = new StatefulBeanToCsvBuilder(writer)
//                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
//                    .withMappingStrategy(mappingStrategy)
//                    .build();
//            sbc.write(user);
//        } catch (IOException
//                | CsvRequiredFieldEmptyException
//                | CsvDataTypeMismatchException e) {
//            e.printStackTrace();
//        }

        try(Writer writer = new FileWriter("src/main/java/test.csv")) {
            sbc = new StatefulBeanToCsvBuilder(writer)
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                    .build();
            sbc.write(user);
        } catch (IOException | CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void remove(Long aLong) {

    }
}
