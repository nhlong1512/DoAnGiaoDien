/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LoginForm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class OracleConnection {

    public static Connection getOracleConnection() throws SQLException, ClassNotFoundException {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String userName = "hr";
        String password = "hr";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection(url, userName, password);
        return conn;
    }
}

