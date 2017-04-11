package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.GenericCrudDAO;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.Comment;

import java.util.HashMap;
import java.util.Map;

public class DAOFactory {

    private static DAOFactory instance;
    private static Map<Class, GenericCrudDAO> mappings = new HashMap<>(); //Map class to interface

    private DAOFactory() {
        mappings.put(User.class, new UserDAOImpl());
        mappings.put(Task.class, new TaskDAOImpl());
    }

    public static DAOFactory getDaoFactory() {
        if (instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }

    public static GenericCrudDAO getDao(Class c) {

        if (mappings.containsKey(c)) {
            return mappings.get(c);
        }

        return null;
    }
}
