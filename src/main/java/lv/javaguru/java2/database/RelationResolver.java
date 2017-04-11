package lv.javaguru.java2.database;

import lv.javaguru.java2.database.annotations.Relation;
import lv.javaguru.java2.database.enumerations.RelationTypes;
import lv.javaguru.java2.database.jdbc.DAOFactory;

import javax.management.ObjectName;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.*;

public class RelationResolver<T> {

    //CallingClass could be here
    //ResulSet could be here
    //CallingObject could be here

    public <T> T resolve(T t, ResultSet resultSet){

        //Get annotated fields
        List<Field> annotatedFields = this.getAnnotatedFields(t);

        if (annotatedFields.isEmpty()) {
            return t;
        }

        for (Field f : annotatedFields) {
            Class targetClass = f.getAnnotation(Relation.class).targetClass();
            RelationTypes relationType = f.getAnnotation(Relation.class).relationType();
            String columnName = f.getAnnotation(Relation.class).columnName();


            //Get method to set the relation on target class
            //Move it to method of resolving relations
            Method m = this.getMethodToSetRelation(f, t);

            if (m == null) {
                //Throw exception
            }

            /*Get relation: need a method to handle Lists
            Logic to handle unidirectional and bidirectional relations shoud be here
            Check if target class has a mapping to callerClass
            */

            //Check relation - if has mapping - decide what to do

            //If targetClas ha relation to callingClass - resolve seriously
            //Else - just set

            Object targetObj = null;

            switch (relationType) {
                case MANY_TO_MANY:  System.out.println("m-t-m");
                                    break;
                case MANY_TO_ONE:
                                    targetObj = this.resolveManyToOne(t, targetClass, resultSet, columnName);
                                    System.out.println("m-t-o");
                                    break;
                case ONE_TO_MANY:   System.out.println("o-t-m");
                                    break;
                case ONE_TO_ONE:    System.out.println("o-t-o");
                                    break;
            }

            try {

                m.invoke(t, targetObj);

            } catch (Throwable e) {
                System.out.println("Cant set relation by invoking " + m);
                e.printStackTrace();
            }


        }


        return t;
    }

    //Should stay here
    private <T> List<Field> getAnnotatedFields(T t) {

        List<Field> annotatedFields = new ArrayList<>();
        Class callingClass = t.getClass();
        Field[] fields = callingClass.getDeclaredFields();

        for (Field f : fields) {
            Relation a = f.getAnnotation(Relation.class);

            if (a != null) {
                annotatedFields.add(f);
            }
        }

        return annotatedFields;
    }

    //Shuld stay here
    private <T> Method getMethodToSetRelation(Field field, T t) {
        Method[] methods = t.getClass().getDeclaredMethods();

        for (Method m : methods) {
            if (m.getName().equalsIgnoreCase("set" + field.getName())) {
                return m;
            }
        }

        return null;
    }

    /*private <T> T getRelatedObject(Class targetClass, ResultSet resultSet, String columnName) {
        //Need a method to handle Lists
        GenericCrudDAO targetDAO = DAOFactory.getDaoFactory().getDao(targetClass);

        try {
            Optional optTarget = targetDAO.getById(resultSet.getLong(columnName));
        } catch (Throwable e) {
            System.out.println("Couldn`t find object related to " + columnName);
            e.printStackTrace();
        }

        return T;
    }*/

    //Should be moved to Abstract class of RelationType
    private boolean hasRelationToCallingClass(Class callingClass, Class targetClass) {

        List<Field> annotatedFields = this.getAnnotatedFields(targetClass);

        if (!annotatedFields.isEmpty()) {
            for (Field f : annotatedFields) {
                Class comparedClass = f.getAnnotation(Relation.class).targetClass();

                if (comparedClass.equals(callingClass)) {
                    return true;
                }
            }
        }

        return false;
    }

    //hould be moved to RelationType abstract
    private boolean isCollectionNeeded(Field field) {

        return Collection.class.isAssignableFrom(field.getType());
    }

    //CO means Calling Object
    //Should be implemented as separate class
    private <CO, T> Object resolveManyToOne(CO co, Class targetClass, ResultSet resultSet, String columnName) {
        Class callingClass = co.getClass();
        GenericCrudDAO targetDAO = DAOFactory.getDaoFactory().getDao(targetClass);

        if (this.hasRelationToCallingClass(callingClass, targetClass)) {
            //Decide, who has FK



        } else {
            //Get the target object by pk
            try {
                Object targetObj = targetDAO.getById(resultSet.getLong(columnName)).get();

                return targetObj;
            } catch (Throwable e) {
                System.out.println("Cant get relation of " + columnName + "to " + targetClass);
                e.printStackTrace();
            }

        }

        return null;
    }
}
