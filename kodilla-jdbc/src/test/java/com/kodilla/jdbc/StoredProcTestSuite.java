package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoredProcTestSuite {

    @Test
    public void testUpdateVipLevels() throws SQLException {
        // Given
        DbManager dbManager = DbManager.getInstance();
        Statement statement = dbManager.getConnection().createStatement();
        String sqlUpdate = "UPDATE READERS SET VIP_LEVEL='Not set'";
        statement.executeUpdate(sqlUpdate);

        // When
        String sqlProcedureCall = "CALL UpdateVipLevels()";
        statement.execute(sqlProcedureCall);

        // Then
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM READERS WHERE VIP_LEVEL='Not set'";
        ResultSet rs = statement.executeQuery(sqlCheckTable);
        int howMany = -1;
        if (rs.next()) {
            howMany = rs.getInt("HOW_MANY");
        }
        rs.close();
        statement.close();
        assertEquals(0, howMany);
    }

    @Test
    void testUpdateBestsellers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();
        Statement statement = dbManager.getConnection().createStatement();
        String updateBestseller = "update books set bestseller = 0";
        statement.executeUpdate(updateBestseller);

        //When
        String callUpdateProcedure = "call UpdateBestsellers()";
        statement.execute(callUpdateProcedure);

        //Then
        String query = "select count(*) as result from books where bestseller = 1";
        ResultSet rs = statement.executeQuery(query);
        int result = 0;
        while (rs.next()) {
            result = rs.getInt("result");
        }
        rs.close();
        statement.close();
        assertEquals(1, result);
    }
}
