package lv.javaguru.java2.database;

import java.util.List;
import java.util.Optional;

public interface GenericCrudDAO<T, PK> {

    Optional<T> getById(PK id);

    List<T> getAll();

}
