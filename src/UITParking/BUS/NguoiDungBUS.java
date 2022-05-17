/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UITParking.BUS;

import UITParking.DAO.NguoiDungDAO;
import UITParking.DTO.NguoiDungDTO;
import java.util.ArrayList;

public class NguoiDungBUS {

    private ArrayList<NguoiDungDTO> list_ND;
    /**
     * Xử lý các lệnh trong SQL
     */
    private NguoiDungDAO ndDAO;

    public NguoiDungBUS() throws Exception {
        list_ND = new ArrayList<>();
        ndDAO = new NguoiDungDAO();
        list_ND = ndDAO.docDB();
    }

    public int getNumbND() {
        return list_ND.size();
    }

    public ArrayList<NguoiDungDTO> getList_ND() {
        return list_ND;
    }

    public void setList_ND(ArrayList<NguoiDungDTO> list_ND) {
        this.list_ND = list_ND;
    }

    public NguoiDungDTO getInfor(String strMaND) {
        for (NguoiDungDTO nd : list_ND) {
            if (nd.getStrMaND().equals(strMaND)) {
                return nd;
            }
        }

        return null;
    }

    /**
     * thêm 1 người dùng vào danh sách và database
     *
     * @return true nếu thành công
     */
    public Boolean them(NguoiDungDTO nd) throws Exception {
        if (ndDAO.them(nd)) {
            list_ND.add(nd);
        }
        return false;
    }

    /**
     * xóa 1 người dùng khỏi danh sách và database
     *
     * @return true nếu thành công
     */
    public Boolean xoa(NguoiDungDTO nd) throws Exception {
        if (ndDAO.xoa(nd)) {

            // duyệt từng phẩn tử
            for (NguoiDungDTO taikhoan : list_ND) {
                if (taikhoan.getStrMaND().equals(nd.getStrMaND())) {
                    list_ND.remove(taikhoan);
                    break;
                }
            }
        }

        return false;
    }

    /**
     * sửa thông tin của 1 khách hàng <br>
     * - Trừ thông tin đăng nhập của khách hàng đó
     *
     * @return true nếu thực hiện thành công
     */
    public Boolean sua(NguoiDungDTO nd) throws Exception {
        ndDAO.sua(nd);

        // duyệt từng phẩn tử
        for (NguoiDungDTO taikhoan : list_ND) {
            if (taikhoan.getStrMaND().equals(nd.getStrMaND())) {
                taikhoan.setStrEmail(nd.getStrEmail());
                taikhoan.setStrMatKhau(nd.getStrMatKhau());
                taikhoan.setStrHoTen(nd.getStrHoTen());
                taikhoan.setStrGioiTinh(nd.getStrGioiTinh());
                taikhoan.setStrNgSinh(nd.getStrNgSinh());
                taikhoan.setStrDiaChi(nd.getStrDiaChi());
                taikhoan.setStrQueQuan(nd.getStrQueQuan());
                taikhoan.setStrSDT(nd.getStrSDT());
                taikhoan.setStrVaiTro(nd.getStrVaiTro());
                return true;
            }

        }

        return false;
    }
}
