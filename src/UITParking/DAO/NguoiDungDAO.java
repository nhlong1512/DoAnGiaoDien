/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UITParking.DAO;

import UITParking.DTO.NguoiDungDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ADMIN
 */
public class NguoiDungDAO {
    SQLConnectUnit connect;
    
    /**
     * Lấy thông tin từ Database
     */
    public ArrayList<NguoiDungDTO> docDB(String condition, String orderBy) throws Exception {
        // kết nối CSDL
        connect = new SQLConnectUnit();
        
        ResultSet result = this.connect.Select("NGUOIDUNG", condition, orderBy);
        ArrayList<NguoiDungDTO> nguoidungs = new ArrayList<>();
        while ( result.next() ) {
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
     * @return true nếu thành công
     */
    public Boolean them(NguoiDungDTO nd) throws Exception {
        connect = new SQLConnectUnit();
        
        // tạo đối tượng truyền vào
        HashMap<String, Object> insertValues = new HashMap<>();
        insertValues.put("MaND", nd.getStrMaND());
        insertValues.put("Email", nd.getStrEmail());
        insertValues.put("MatKhau", nd.getStrMatKhau());
        insertValues.put("HoTen", nd.getStrHoTen());
        insertValues.put("GioiTinh", nd.getStrGioiTinh());
        insertValues.put("NgSinh", nd.getStrNgSinh());
        insertValues.put("DiaChi", nd.getStrDiaChi());
        insertValues.put("QueQuan", nd.getStrQueQuan());
        insertValues.put("SDT", nd.getStrSDT());
        insertValues.put("VaiTro", nd.getStrVaiTro());
        
        Boolean check = connect.Insert("NGUOIDUNG", insertValues);
        
        connect.Close();
        return check;
    }
    
    /** 
     * @param nd chuyền vào dữ liệu người dùng để xóa
     * @return true nếu thành công
     */
    public Boolean xoa(NguoiDungDTO nd) throws Exception {
        connect = new SQLConnectUnit();
        String condition = " MaND = "+nd.getStrMaND();
        
        Boolean check = connect.Delete("NGUOIDUNG", condition);
        
        connect.Close();
        return check;
    }
    
    /**
     * @param nd truyền vào dữ liệu người dùng mới
     * Sửa thông tin đăng nhập hoặc là cấp bậc của 1 người dùng
     * @return true nếu thành công
     */
    public Boolean sua(NguoiDungDTO nd) throws Exception {
        connect = new SQLConnectUnit();
        
        // tạo đối tượng truyền vào
        HashMap<String, Object> insertValues = new HashMap<>();
        insertValues.put("Email", nd.getStrEmail());
        insertValues.put("MatKhau", nd.getStrMatKhau());
        insertValues.put("HoTen", nd.getStrHoTen());
        insertValues.put("GioiTinh", nd.getStrGioiTinh());
        insertValues.put("NgSinh", nd.getStrNgSinh());
        insertValues.put("DiaChi", nd.getStrDiaChi());
        insertValues.put("QueQuan", nd.getStrQueQuan());
        insertValues.put("SDT", nd.getStrSDT());
        insertValues.put("VaiTro", nd.getStrVaiTro());
        
        String condition = " MaND = " + nd.getStrMaND();
        
        Boolean check = connect.Update("NGUOIDUNG", insertValues, condition);
        
        connect.Close();
        return check;
    }
}

