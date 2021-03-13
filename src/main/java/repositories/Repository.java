package repositories;

import java.io.Serializable;
import java.util.List;

public interface Repository<T, ID extends Serializable> {

    T findById(ID id);

    void save(T entity);

    List<T> findAll();

    void remove(ID id);
}
