package lv.javaguru.java2.database.annotations;


import lv.javaguru.java2.database.enumerations.RelationTypes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Relation {

    //ONE_TO_MANY, MANY_TO_ONE and others from RelationTypes enum
    RelationTypes relationType();

    Class targetClass();

    //Column name, where relation in DB is stored
    String columnName();

    //Describes, if class is an owner of a relationship



    /*Stores relation of the owner of this container
    to other casses:
    --@relation - class owner is related to
    --@type - type of relations(One-To-Many, One-To-One...)
    Defined by annotation @field - field of owner class to wich relation will be set
    @method - method to get the relation
    --@columnName - name of the column from DB ow owners table*/




}
