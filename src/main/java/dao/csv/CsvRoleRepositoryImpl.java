package dao.csv;

import Utils.FileUtils;
import entities.Role;
import repositories.RoleRepository;

import java.io.File;
import java.util.List;


public class CsvRoleRepositoryImpl implements RoleRepository<Role,Long> {

    private final FileUtils<Role> fileUtils;

    private File file;

    private List<Role> roles;

    public CsvRoleRepositoryImpl() {
        fileUtils = new FileUtils<>();
        file = new File("src/roles.csv");
        roles = fileUtils.read(file,Role.class);
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
        fileUtils.write(file,roles);
    }

    @Override
    public List<Role> findAll() {
        return roles;
    }

    @Override
    public void remove(Long id) {
        Role role = roles.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst().orElseThrow();
        roles.remove(role);
        fileUtils.write(file,roles);
    }
}
