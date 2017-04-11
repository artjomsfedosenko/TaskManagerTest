package lv.javaguru.java2.database.jdbc;

import org.junit.After;
import org.junit.Before;

public abstract class DBUnitTestCase {

    protected DatabaseUtil databaseUtil = new DatabaseUtil();


    @Before
    public void init() throws Exception {
        databaseUtil.setupDatabaseFromFile(getDatabaseFile());
    }

    @After
    public void clean() {
        databaseUtil.cleanDatabase();
    }

    protected abstract String getDatabaseFile();

}
