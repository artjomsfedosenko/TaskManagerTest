package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.configs.SpringConfig;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.enumerations.Priorities;
import lv.javaguru.java2.domain.enumerations.TaskStates;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class TaskDaoHibernateTest {

    @Autowired
    private TaskDaoHibernate taskDAO;

    @Test
    public void getById() throws Exception {

        Optional<Task> taskOpt = taskDAO.getById(1L);

        assertTrue(taskOpt.isPresent());

        Task task = taskOpt.get();

        assertEquals(Long.valueOf(1L), task.getTaskId());
        assertEquals("Summary", task.getSummary());
        assertEquals("Description", task.getDescription());

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //Date creationDate = dateFormat.parse("2017-04-02 20:13:15");

        assertEquals(dateFormat.parse("2017-04-02 20:13:15"), task.getCreationDate());
        assertEquals(dateFormat.parse("2017-04-02 20:13:15"), task.getEstimate());
        assertEquals(dateFormat.parse("2017-04-02 20:13:15"), task.getLastUpdated());
        assertEquals(TaskStates.NEW, task.getTaskState());
        assertEquals(Priorities.LOW, task.getPriority());
        assertEquals(Long.valueOf(1002L), task.getAssignedTo().getUserId());
        assertEquals(Long.valueOf(1003L), task.getCreatedBy().getUserId());
        assertEquals(Long.valueOf(1004L), task.getLastUpdatedBy().getUserId());

    }
}