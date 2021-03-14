package dao.csv;

import Utils.FileUtils;
import entities.User;
import repositories.UserRepository;

import java.io.File;
import java.util.List;


public class CsvUserRepositoryImpl implements UserRepository<User, Long> {


    private final FileUtils<User> fileUtils;

    private List<User> users;

    private final File file;

    public CsvUserRepositoryImpl() {
        fileUtils = new FileUtils<>();
        file = new File("src/users.csv");
        users = fileUtils.read(file,User.class);
    }

    @Override
    public User findById(Long id) {
        return users.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    @Override
    public void save(User user) {
        users.add(user);
        fileUtils.write(file,users);
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public void remove(Long id) {
        User user = users.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow();
        users.remove(user);
        fileUtils.write(file,users);
    }
}
