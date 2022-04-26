/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package LoginForm;

import java.sql.Connection;
import java.sql.SQLDataException;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class CheckOracleConnection {

    /**
     * @param args the command line arguments
     */
    public static Connection getMyConnection() throws SQLDataException,
            ClassNotFoundException,
            SQLException {
        return OracleConnection.getOracleConnection();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // TODO code application logic here
        System.out.println("Get connection... ");
        Connection conn = CheckOracleConnection.getMyConnection();
        System.out.println("Get connection " + conn);
        System.out.println("Done!");
    }

}
