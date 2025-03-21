package org.krishnalT.tests;

import org.krishnalT.utils.DBUtils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTest {
    @BeforeClass
    public void setup() {
        // Connect to MySQL or H2 (Choose one)
        DBUtils.connectToDB("jdbc:mysql://localhost:3306/TestDB", "root", "password");
        // DBUtils.connectToDB("jdbc:h2:mem:testdb", "sa", "");
    }

    @Test
    public void testUserExists() {
        Assert.assertTrue(DBUtils.validateUserExists("john@example.com"), "User not found in DB!");
    }

    @Test
    public void testFetchUser() throws SQLException {
        ResultSet rs = DBUtils.executeQuery("SELECT Name FROM Users WHERE Email = 'alice@example.com'");
        if (rs.next()) {
            String name = rs.getString("Name");
            Assert.assertEquals(name, "Alice Smith", "User data mismatch!");
        }
    }

    @AfterClass
    public void teardown() {
        DBUtils.closeConnection();
    }
}
