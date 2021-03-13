package dao.csv;

import Entities.Role;
import Entities.User;
import Repositories.RoleRepository;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@SuppressWarnings({"rawtypes", "unchecked"})
public class CsvRoleRepositoryImpl implements RoleRepository<Role,Long> {


    private CsvToBean<Role> csvToBean;

    private StatefulBeanToCsv sbc;

    private List<Role> roles;

    public CsvRoleRepositoryImpl() {
        try (Writer writer = new FileWriter("src/User.csv")) {
            sbc = new StatefulBeanToCsvBuilder(writer)
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                    .build();

            csvToBean = new CsvToBeanBuilder(new FileReader("src/User.csv"))
                    .withType(User.class)
                    .withSeparator(',')
                    .build();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Role findById(Long aLong) {
        return null;
    }

    @Override
    public void save(Role entity) {

    }

    @Override
    public List<Role> findAll() {
        return null;
    }

    @Override
    public void remove(Long aLong) {

    }
}
