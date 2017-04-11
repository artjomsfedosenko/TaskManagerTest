package lv.javaguru.java2.database;

import lv.javaguru.java2.database.enumerations.RelationTypes;

public class RelationContainer {

    /*Stores relation of the owner of this container
    to other casses:
    @relation - class owner is related to
    @type - type of relations(One-To-Many, One-To-One...)
    @field - field of owner class to wich relation will be set
    @method - method to get the relation
    @columnName - name of the column from DB ow owners table*/

    private Class relation;
    private RelationTypes type;
    private String field;
    private String method;
    private String columnName;

    public Class getRelation() {
        return relation;
    }

    public void setRelation(Class relation) {
        this.relation = relation;
    }

    public RelationTypes getType() {
        return type;
    }

    public void setType(RelationTypes type) {
        this.type = type;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
}
