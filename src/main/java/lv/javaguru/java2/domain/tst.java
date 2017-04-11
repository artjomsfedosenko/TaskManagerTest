package lv.javaguru.java2.domain;


import lv.javaguru.java2.database.GenericCrudDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.DAOFactory;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static lv.javaguru.java2.domain.UserBuilder.createUser;

public class tst {

    public static void main(String[] args) {

        /*GenericCrudDAO<User, Long> userDAO = DAOFactory.getDaoFactory().getDao(User.class);
        System.out.print(userDAO.getClass());
        User user = userDAO.getById(1002L).get();

        GenericCrudDAO<Task, Long> taskDAO = DAOFactory.getDaoFactory().getDao(Task.class);
        Task task = taskDAO.getById(1L).get();

        System.out.println(user);

        System.out.println(task);*/

        /*User user = createUser()
                .withFirstName("F")
                .withLastName("L").build();

        Field[] fields = Task.class.getDeclaredFields();
        Method[] methods = Task.class.getDeclaredMethods();

        String className = User.class.toString();

        Map<String, Class> map = new HashMap<>();
        map.put("U", User.class);

        Class objClass = map.get("U");

        try {
            Method m = objClass.getDeclaredMethod("getFirstName", null);
            System.out.println("method = " + m.toString());
        } catch (Throwable e) {
            e.printStackTrace();
        }

        String methodToInvoke = "getFirstName";*/

        //int i = Arrays.binarySearch(methods, methodToInvoke);

        //System.out.println(i);
        System.out.println();

        //System.out.println(Arrays.toString(methods));

        GenericCrudDAO<Task, Long> taskDAO = DAOFactory.getDaoFactory().getDao(Task.class);
        Task task = taskDAO.getById(1L).get();

        System.out.println(task.getAssignedTo().getFirstName());
        System.out.println(task.getCreatedBy().getFirstName());
        System.out.println(task.getLastUpdatedBy().getFirstName());

        /*Class clazz = Task.class;

        Field[] fields = clazz.getDeclaredFields();

        for (Field f : fields) {
            if (Collection.class.isAssignableFrom(f.getType())) {
                System.out.println(f);
            }
        }*/











    }

}
