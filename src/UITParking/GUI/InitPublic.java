/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UITParking.GUI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class InitPublic {

    public static String getID(String id) {
        id = id.replaceAll("\\D+", "");
        int id_num = Integer.parseInt(id);
        id_num++;
        String id_format = String.format("%03d", id_num);
        return id_format;
    }

    public static String getThoiGianThuc() throws ParseException {
        SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");
        LocalDate today = LocalDate.now();
        String strToday = today.toString();
        return strToday;
    }

    public static Date getDateThoiGianThuc() throws ParseException {
        SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");
        LocalDate today = LocalDate.now();
        String strToday = today.toString();
        Date dateToday = DateFormat.parse(strToday);
        return dateToday;
    }

    public static Date getDateThoiGianVeTuan() throws ParseException {
        SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //Cộng 7 ngày
        LocalDate today = LocalDate.now().plusDays(7);
        String strToday = today.toString();
        Date dateToday = DateFormat.parse(strToday);
        return dateToday;
    }

    public static Date getDateThoiGianVeThang() throws ParseException {
        SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //Cộng 7 ngày
        LocalDate today = LocalDate.now().plusMonths(1);
        String strToday = today.toString();
        Date dateToday = DateFormat.parse(strToday);
        return dateToday;
    }

    public static Date getConvertYYYYMMDD(String data) throws ParseException {
        SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date rs = DateFormat.parse(data);
        return rs;
    }

    public static String getStringConvertYYYYMMDD(String data) throws ParseException {
        SimpleDateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date rs = DateFormat.parse(data);
        return rs.toString();
    }

//    public static Date getDateTimeThoiGianThuc() {
//        java.util.Date utilDate = new java.util.Date();
//        LocalDateTime dateValue = utilDate;
//        String dateFormat = "yyyy-MM-dd'T'HH:mm:ss";
//        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern(dateFormat);
//        SimpleDateFormat sdf1 = new SimpleDateFormat(dateFormat);
//        try {
//            utilDate = sdf1.parse(dateValue.format(dtf1));
//        } catch (ParseException e) {
//            utilDate = null; // handle the exception
//        }
//        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
//    }

    public static LocalDate getConvertStringToLocalDate(String data) {
        LocalDate localDate = LocalDate.parse(data, DateTimeFormatter.ISO_LOCAL_DATE);
        return localDate;
    }

    public LocalDate convertDatetoLocalDate(Date now) {
        Instant instant = Instant.ofEpochMilli(now.getTime());
        LocalDate localDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
        return localDate;
    }
}
