package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.domain.Task;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;
import java.util.Optional;

@Component
@Transactional
public class TaskDaoHibernate {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public Optional<Task> getById(Long id) {
        Task task = (Task) sessionFactory.getCurrentSession()
                .createCriteria(Task.class)
                .add(Restrictions.eq("taskId", id)).uniqueResult();

        return Optional.ofNullable(task);
    }

}
