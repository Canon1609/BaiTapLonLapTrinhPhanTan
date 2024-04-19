package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectDB.Conection_DB;
import entity.DangNhap;

public class DAO_DangNhap {
	public List<DangNhap> TimKiem(String tk, String mk) {
	    Conection_DB.getInstance();
	    Connection con = Conection_DB.getCon();
	    PreparedStatement stmt = null;
	    List<DangNhap> dsdn = new ArrayList<>();

	    try {
	        stmt = con.prepareStatement("select * from TaiKhoan where TaiKhoan like ? and MatKhau like ?");
	        stmt.setString(1, tk); // Gán giá trị tham số thứ nhất
	        stmt.setString(2, mk); // Gán giá trị tham số thứ hai
	        ResultSet rs = stmt.executeQuery();
	        while (rs.next()) {
	            DangNhap dn = new DangNhap(rs.getString(1), rs.getString(2));
	            dsdn.add(dn);
	        }
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    return dsdn;
	}

}
