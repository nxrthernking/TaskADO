package Repositories;

import java.io.Serializable;

public interface EmployeeRepository<T,ID extends Serializable> extends Repository<T,ID> {
}
