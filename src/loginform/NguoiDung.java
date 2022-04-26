/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginform;

/**
 *
 * @author ADMIN
 */
public class NguoiDung {
    private String maND, hoTen, email, matKhau, gioiTinh;

    public NguoiDung() {
    }

    public NguoiDung(String maND, String hoTen, String email, String matKhau, String gioiTinh) {
        this.maND = maND;
        this.hoTen = hoTen;
        this.email = email;
        this.matKhau = matKhau;
        this.gioiTinh = gioiTinh;
    }

    public String getMaND() {
        return maND;
    }

    public void setMaND(String maND) {
        this.maND = maND;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    
    
}
