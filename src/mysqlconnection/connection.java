/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqlconnection;

/**
 *
 * @author justj
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
    private static Connection mConnection;
    public static Connection getMySQLConnection() throws SQLException {
        if (mConnection == null) {
            String hostName = "localhost";
            String dbName = "cnpm";
            String userName = "root";
            mConnection = getMySQLConnection(hostName, dbName, userName);
        }
        return mConnection;        
    }
    public static Connection getMySQLConnection(String hostName, String dbName, String userName) throws SQLException {
        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName + "?user=" + userName;
        return DriverManager.getConnection(connectionURL);
    }
}
