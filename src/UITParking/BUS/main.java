/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package UITParking.BUS;

import UITParking.DTO.NguoiDungDTO;
import UITParking.DAO.NguoiDungDAO;
import UITParking.DTO.HDMuaVeDTO;
import UITParking.DTO.LoaiVeDTO;
import UITParking.DTO.VeDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Huu Long
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
//        NguoiDungDTO nd022 = new NguoiDungDTO("ND022", "huulong22@gmail.com", "longlong", "Nguyen Huu Long", "Nam", "19-MAR-02", "28 Nguyen Thi Ly phuong 2", "TP. Quang Tri", "0775504619", "Khach hang");
//        NguoiDungBUS nguoidungtbl = new NguoiDungBUS();
//        System.out.println(nguoidungtbl.getNumbND());
//        nguoidungtbl.them(nd022);
//        System.out.println(nguoidungtbl.getInfor("ND015"));
//        NguoiDungDTO nd015 = new NguoiDungDTO("ND015", "20521083@gmail.uit.edu.vn", "ttna0000", "Tran Thi Ngoc Anh", "Nu", "19-MAR-02", "28 Nguyen Thi Ly, phuong 2", "TP. Quang Tri", "0985766322", "Khach hang");
//        nguoidungtbl.xoa(nd015);
//        System.out.println(nguoidungtbl.getNumbND());
//        ArrayList<NguoiDungDTO> list_ND = nguoidungtbl.getList_ND();
//        for (NguoiDungDTO nd : list_ND) {
//            System.out.println(nd);
//        }
//        list_ND.add(nd019);
//        for (NguoiDungDTO nd : list_ND) {
//            System.out.println("New----" + nd);
//        }

//        nguoidungtbl.xoa(nd022);
//        for (NguoiDungDTO nd : list_ND) {
//            System.out.println("New----" + nd);
//        }
//        
//        nd022 = new NguoiDungDTO("ND022", "huulong232@gmail.com", "longrong", "Nguyen Huu Lodfsdfsdfdsg", "Nam", "19-MAR-02", "28 Nguyen Thi Ly phuong 2", "TP. Quang Tri", "0775504619", "Khach hang");
//        nguoidungtbl.sua(nd022);
//        for (NguoiDungDTO nd : list_ND) {
//            System.out.println("New----" + nd);
//        } 
//          NguoiDungDTO nd = nguoidungtbl.getInfor("ND015"); 
//          System.out.println(nd.getStrHoTen());
        KhachHangBUS khachhangtbl = new KhachHangBUS();
        System.out.println(khachhangtbl.getNumbKH());

        VeBUS vetbl = new VeBUS();
        System.out.println(vetbl.getNumbVe());

        ArrayList<VeDTO> list_Ve = vetbl.getList_Ve();
        for (VeDTO ve : list_Ve) {
            System.out.println("New----" + ve);
        }
        
        LoaiVeBUS loaivetbl = new LoaiVeBUS();
        System.out.println(loaivetbl.getNumbLV());
        
        ArrayList<LoaiVeDTO> list_LV = loaivetbl.getList_LV();
        for (LoaiVeDTO ve : list_LV) {
            System.out.println("New----" + ve);
        }
        
        HDMuaVeBUS hdmuavetbl = new HDMuaVeBUS();
        System.out.println(hdmuavetbl.getNumbHD());
        ArrayList<HDMuaVeDTO> list_HD = hdmuavetbl.getList_HD();
        for (HDMuaVeDTO ve : list_HD) {
            System.out.println("New----" + ve);
        }
        
    }
}
