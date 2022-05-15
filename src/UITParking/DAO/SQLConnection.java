/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UITParking.DAO;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimeZone;
import java.sql.Connection;

/**
 *
 * @author ADMIN
 */
public class SQLConnection {
    String Username = "";
    String Password = "";
    String Sid = "";
    
    Connection connect = null;
    Statement statement = null;
    ResultSet resultSet = null;

    public SQLConnection(String Username, String Password, String Sid) {
        this.Username = Username;
        this.Password = Password;
        this.Sid = Sid;
    }
    
    
    protected void driveTest () throws Exception {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }
        catch (ClassNotFoundException e) {
            throw new Exception("SQl Developer not found driveTest");
        }
    }
    
    protected Connection getConnect() throws Exception {
//        nếu connection null thì khởi tạo mới
        if (this.connect == null) {
            driveTest();
            
//            Tạo url để kết nối tới Database
            String url = "jdbc:oracle:thin:@localhost:1521:" + this.Sid;
            try{
//                tạo connet thông qua url
                this.connect = DriverManager.getConnection(url, this.Username, this.Password);
            }        
            catch (SQLException e) {
                throw new Exception("không thể kết nối tới Database" + url +e.getMessage());
            }
        }
        
        return this.connect;
    }
    
//    tạo statement để thực thi Queury
    protected Statement getStatement() throws Exception {
//        kiểm tra stament đã đóng chưa
        if (this.statement == null) {
//            khởi tạo statement mới
            this.statement = getConnect().createStatement();
        }
        else {
            this.statement.isClosed();
        }
        return this.statement;
    }
    
    //hàm thực thi các câu lệnh SQl 
    public ResultSet excuteQuery(String Query) throws Exception{
        try {
            // thực thi câu lệnh
            this.resultSet = getStatement().executeQuery(Query);
            
        } catch (Exception e) {
            throw new Exception("Error excuteQuery " + e.getMessage());
        }
        
        return this.resultSet;
    }
    
//    thực thi các Insert, Update, Delete
    public int executeUpdate(String Query) throws Exception {
        //khai báo biến int để lưu trữ kết quả torng quá trình thực thi
        int res = Integer.MIN_VALUE;
        
        try {
            //thực thi câu lệnh
            res = getStatement().executeUpdate(Query);
        } catch (Exception e) {
            throw new Exception("Error " + e.getMessage());
        }
        
        return res;
    }
    
    //hàm đóng kết nối
    public void Close() throws Exception {
        if (this.resultSet != null && this.resultSet.isClosed()) {
            this.resultSet.close();
            this.resultSet = null;
        }
        if (this.statement != null && this.statement.isClosed()) {
            this.statement.close();
            this.statement = null;
        }
        if (this.connect != null && this.connect.isClosed()) {
            this.connect.close();
            this.connect = null;
        }
    }
}

