package dao.csv;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import entities.Role;
import entities.User;
import repositories.RoleRepository;
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


    // TODO: 14.03.2021 ne seivit normalno. otdelnie methods 
    
    private CsvToBean<Role> csvToBean;

    private StatefulBeanToCsv sbc;

    private List<Role> roles;

    public CsvRoleRepositoryImpl() {
        try (Writer writer = new FileWriter("src/roles.csv")) {
            sbc = new StatefulBeanToCsvBuilder(writer)
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                    .build();

            csvToBean = new CsvToBeanBuilder(new FileReader("src/roles.csv"))
                    .withType(User.class)
                    .withSeparator(',')
                    .build();

            roles = csvToBean.parse();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Role findById(Long id) {
        return roles.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    @Override
    public void save(Role role) {
        roles.add(role);
        try {
            sbc.write(roles);
        } catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Role> findAll() {
        return roles;
    }

    @Override
    public void remove(Long id) {
        Role role = roles.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow();
        roles.remove(role);
        try {
            sbc.write(roles);
        } catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        }
    }
}
