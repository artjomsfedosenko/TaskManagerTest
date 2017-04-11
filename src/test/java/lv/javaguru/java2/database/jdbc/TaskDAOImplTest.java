package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.domain.Comment;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static lv.javaguru.java2.domain.UserBuilder.createUser;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TaskDAOImplTest extends DBUnitTestCase {

    @Override
    protected String getDatabaseFile() {
        return "dbscripts/TaskDAOImplTest.xml";
    }

    @Test
    public void testGetFromDB() throws Exception {

        Task task = new Task();

        User user = createUser()
                .withFirstName("F")
                .withLastName("L").build();

        List<Comment> comments = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Comment comment = new Comment();
            comments.add(comment);
        }



        //assertTrue(userFromDB.isPresent());



        /*assertEquals(user.getUserId(), userFromDB.get().getUserId());
        assertEquals(user.getFirstName(), userFromDB.get().getFirstName());
        assertEquals(user.getLastName(), userFromDB.get().getLastName());*/
    }
}
