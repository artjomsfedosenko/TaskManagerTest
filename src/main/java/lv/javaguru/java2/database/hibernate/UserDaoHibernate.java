package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import lv.javaguru.java2.domain.User;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;
import java.util.Optional;

@Component
@Transactional
public class UserDaoHibernate {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public Optional<User> getById(Long id) throws DBException {
        User user =  (User) sessionFactory.getCurrentSession()
                .createCriteria(User.class)
                .add(Restrictions.eq("userId", id)).uniqueResult();

        return Optional.ofNullable(user);
    }
}
