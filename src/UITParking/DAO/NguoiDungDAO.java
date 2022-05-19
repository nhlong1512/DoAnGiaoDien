/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UITParking.DAO;

import UITParking.DTO.NguoiDungDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Nguyen Huu Long
 */
public class NguoiDungDAO {

    
    SQLConnectUnit connect;
    public static SQLConnection connection = new SQLConnection("hr", "hr", "orcl");;
    public static PreparedStatement pst = null;

    /**
     * Lấy thông tin từ Database
     */
    public ArrayList<NguoiDungDTO> docDB(String condition, String orderBy) throws Exception {
        // kết nối CSDL
        connect = new SQLConnectUnit();

        ResultSet result = this.connect.Select("NGUOIDUNG", condition, orderBy);
        ArrayList<NguoiDungDTO> nguoidungs = new ArrayList<>();
        while (result.next()) {
            NguoiDungDTO nguoidung = new NguoiDungDTO();
            nguoidung.setStrMaND(result.getString("MaND"));
            nguoidung.setStrEmail(result.getString("Email"));
            nguoidung.setStrMatKhau(result.getString("MatKhau"));
            nguoidung.setStrHoTen(result.getString("HoTen"));
            nguoidung.setStrGioiTinh(result.getString("GioiTinh"));
            nguoidung.setStrNgSinh(result.getString("NgSinh"));
            nguoidung.setStrDiaChi(result.getString("DiaChi"));
            nguoidung.setStrQueQuan(result.getString("QueQuan"));
            nguoidung.setStrSDT(result.getString("SDT"));
            nguoidung.setStrVaiTro(result.getString("VaiTro"));
            nguoidungs.add(nguoidung);
        }
        connect.Close();
        return nguoidungs;
    }

    public ArrayList<NguoiDungDTO> docDB(String condition) throws Exception {
        return docDB(condition, null);
    }

    public ArrayList<NguoiDungDTO> docDB() throws Exception {
        return docDB(null);
    }

    /**
     * Tạo thêm 1 người dùng dựa theo đã có thông tin trước
     *
     * @return true nếu thành công
     */
    public Boolean them(NguoiDungDTO nd) throws Exception {
        String sql = "INSERT INTO NGUOIDUNG (MaND, Email, MatKhau, HoTen, GIOITINH, NGSINH, DIACHI, QUEQUAN, SDT, VAITRO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            pst = this.connection.getConnect().prepareStatement(sql);

            pst.setString(1, nd.getStrMaND());
            pst.setString(2, nd.getStrEmail());
            pst.setString(3, nd.getStrMatKhau());
            pst.setString(4, nd.getStrHoTen());
            pst.setString(5, nd.getStrGioiTinh());
            pst.setString(6, nd.getStrNgSinh());
            pst.setString(7, nd.getStrDiaChi());
            pst.setString(8, nd.getStrQueQuan());
            pst.setString(9, nd.getStrSDT());
            pst.setString(10, nd.getStrVaiTro());

            return pst.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }
    
    /** 
     * @param nd chuyền vào dữ liệu người dùng để xóa
     * @return true nếu thành công
     */
    public Boolean xoa(NguoiDungDTO nd) throws Exception {
        String sql = "DELETE FROM NGUOIDUNG WHERE MaND = ?";
        try {
            pst = this.connection.getConnect().prepareStatement(sql);

            pst.setString(1, nd.getStrMaND());

            return pst.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }
    
    /**
     * @param nd truyền vào dữ liệu người dùng mới
     * Sửa thông tin đăng nhập hoặc là cấp bậc của 1 người dùng
     * @return true nếu thành công
     */
    public Boolean sua(NguoiDungDTO nd) throws Exception {
        String sql = "UPDATE NGUOIDUNG SET Email = ?, MatKhau = ?, HoTen = ?, "
                + "GIOITINH = ?, NGSINH = ?, DIACHI = ?, QUEQUAN = ?, SDT = ?, "
                + "VAITRO = ? WHERE MAND = ?";
        try {
            pst = this.connection.getConnect().prepareStatement(sql);

            pst.setString(10, nd.getStrMaND());
            pst.setString(1, nd.getStrEmail());
            pst.setString(2, nd.getStrMatKhau());
            pst.setString(3, nd.getStrHoTen());
            pst.setString(4, nd.getStrGioiTinh());
            pst.setString(5, nd.getStrNgSinh());
            pst.setString(6, nd.getStrDiaChi());
            pst.setString(7, nd.getStrQueQuan());
            pst.setString(8, nd.getStrSDT());
            pst.setString(9, nd.getStrVaiTro());

            return pst.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }
}