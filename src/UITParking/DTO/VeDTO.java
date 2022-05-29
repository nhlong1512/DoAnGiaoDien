/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UITParking.DTO;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class VeDTO {
    private String strMaVe, strMaLoaiVe, strMaKH, strTrangThai;
    private Date dateNgayKichHoat;
    private Date dateNgayHetHan;

    public VeDTO() {
    }

    public VeDTO(String strMaVe, String strMaLoaiVe, String strMaKH, String strTrangThai, Date dateNgayKichHoat, Date dateNgayHetHan) {
        this.strMaVe = strMaVe;
        this.strMaLoaiVe = strMaLoaiVe;
        this.strMaKH = strMaKH;
        this.strTrangThai = strTrangThai;
        this.dateNgayKichHoat = dateNgayKichHoat;
        this.dateNgayHetHan = dateNgayHetHan;
    }

    @Override
    public String toString() {
        return "VeDTO{" + "strMaVe=" + strMaVe + ", strMaLoaiVe=" + strMaLoaiVe + ", strMaKH=" + strMaKH + ", strTrangThai=" + strTrangThai + ", dateNgayKichHoat=" + dateNgayKichHoat + ", dateNgayHetHan=" + dateNgayHetHan + '}';
    }

    public String getStrMaVe() {
        return strMaVe;
    }

    public void setStrMaVe(String strMaVe) {
        this.strMaVe = strMaVe;
    }

    public String getStrMaLoaiVe() {
        return strMaLoaiVe;
    }

    public void setStrMaLoaiVe(String strMaLoaiVe) {
        this.strMaLoaiVe = strMaLoaiVe;
    }

    public String getStrMaKH() {
        return strMaKH;
    }

    public void setStrMaKH(String strMaKH) {
        this.strMaKH = strMaKH;
    }

    public String getStrTrangThai() {
        return strTrangThai;
    }

    public void setStrTrangThai(String strTrangThai) {
        this.strTrangThai = strTrangThai;
    }

    public Date getDateNgayKichHoat() {
        return dateNgayKichHoat;
    }

    public void setDateNgayKichHoat(Date dateNgayKichHoat) {
        this.dateNgayKichHoat = dateNgayKichHoat;
    }

    public Date getDateNgayHetHan() {
        return dateNgayHetHan;
    }

    public void setDateNgayHetHan(Date dateNgayHetHan) {
        this.dateNgayHetHan = dateNgayHetHan;
    }

}
