package dao.csv;

import Utils.FileUtils;
import entities.Employee;
import repositories.EmployeeRepository;

import java.io.File;
import java.util.List;

public class CsvEmployeeRepositoryImpl implements EmployeeRepository<Employee, Long> {

    private final FileUtils<Employee> fileUtils;

    private final File file;

    private List<Employee> employees;

    public CsvEmployeeRepositoryImpl() {
        fileUtils = new FileUtils<>();
        file = new File("src/employees.csv");
        employees = fileUtils.read(file,Employee.class);
    }

    @Override
    public Employee findById(Long id) {
        return employees.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    @Override
    public void save(Employee employee) {
        employees.add(employee);
        fileUtils.write(file,employees);
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public void remove(Long id) {
        Employee employee = employees.stream()
                .filter( s-> s.getId().equals(id))
                .findFirst()
                .orElseThrow();
        employees.remove(employee);
        fileUtils.write(file,employees);
    }
}
