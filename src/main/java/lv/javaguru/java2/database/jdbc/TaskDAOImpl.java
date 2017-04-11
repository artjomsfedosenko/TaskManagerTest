package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.*;
import lv.javaguru.java2.database.annotations.Relation;
import lv.javaguru.java2.database.enumerations.RelationTypes;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.enumerations.Priorities;
import lv.javaguru.java2.domain.enumerations.TaskStates;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TaskDAOImpl extends DAOImpl implements TaskDAO {

    private List<RelationContainer> relations = new ArrayList<>();

    public TaskDAOImpl() {
        super();

        RelationContainer rc = new RelationContainer();
        rc.setRelation(User.class);
        rc.setColumnName("assigned_to");
        rc.setType(RelationTypes.MANY_TO_ONE);
        rc.setField("assignedTo");
        rc.setMethod("getById");

        this.relations.add(rc);
    }

    @Override
    public Optional<Task> getById(Long id) {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM tasks WHERE id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Task task = null;

            if (resultSet.next()) {
                task = new Task();

                task.setTaskId(resultSet.getLong("id"));
                task.setSummary(resultSet.getString("summary"));
                task.setDescription(resultSet.getString("content"));

                task.setCreationDate(resultSet.getTimestamp("creation_date"));
                task.setEstimate(resultSet.getTimestamp("estimate"));
                task.setLastUpdated(resultSet.getTimestamp("last_updated"));
                task.setPriority(Priorities.valueOf(resultSet.getString("priority")));
                task.setTaskState(TaskStates.valueOf(resultSet.getString("task_state")));
                System.out.println(resultSet);
                //Resolve dependencies
                RelationResolver relationResolver = new RelationResolver();

                task = (Task) relationResolver.resolve(task, resultSet);

            }

            return Optional.ofNullable(task);
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.getById()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Task> getAll() {
        return null;
    }

    @Override
    public Task save(Task task) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Task task) {

    }

}
