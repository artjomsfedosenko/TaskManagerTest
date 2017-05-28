package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.configs.SpringConfig;
import lv.javaguru.java2.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class UserDaoHibernateTest {

    @Autowired
    private UserDaoHibernate userDao;

    @Test
    public void getById() throws Exception {

        Optional<User> userOpt = userDao.getById(1002L);

        assertTrue(userOpt.isPresent());

        User user = userOpt.get();

        assertEquals(Long.valueOf(1002L), user.getUserId());
        assertEquals("Artjoms", user.getFirstName());
        assertEquals("Fedosenko", user.getLastName());
        assertEquals("12345", user.getPassword());
    }
}