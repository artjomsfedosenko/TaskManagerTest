package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.User;

import java.util.List;
import java.util.Optional;

public interface TaskDAO extends GenericCrudDAO<Task, Long>{

    Optional<Task> getById(Long id);

    List<Task> getAll();

    Task save(Task task);

    void delete(Long id);

    void update(Task task);

}
