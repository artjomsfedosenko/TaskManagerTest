package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.User;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;
import java.util.Optional;

public interface UserDAO extends GenericCrudDAO<User, Long>{

    User save(User user);

    Optional<User> getById(Long id);

    void delete(Long id);

    void update(User user);

    List<User> getAll();

    void testInterface();
}
