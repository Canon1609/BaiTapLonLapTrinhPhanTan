package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.Conection_DB;
import entity.CongCuaNhanVien;
import entity.NhanVien;

public class DAO_ChamCongNhanVIen {
	public DAO_ChamCongNhanVIen() {
		// TODO Auto-generated constructor stub
	}
	public static ArrayList<CongCuaNhanVien> getAlltbCongCuaNhanVien(){
		ArrayList<CongCuaNhanVien> dscongNV = new ArrayList<CongCuaNhanVien>();
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		String sql = "select * from CongCuaNhanVien";
		Statement statement;
		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maCong = rs.getString(1);
				String maNV = rs.getString("maNhanVien");
				String ngayCham = rs.getString(3);
				String caLam = rs.getString(4);
				String gioLam = rs.getString(5);
				double luongCaLam = rs.getDouble(6);
				String trangThai = rs.getString(7);
				String nghiPhep = rs.getString(8);
				NhanVien nv = new NhanVien(maNV);
				CongCuaNhanVien congNV = new CongCuaNhanVien(maCong, nv, ngayCham, caLam, gioLam, luongCaLam, trangThai, nghiPhep);
				dscongNV.add(congNV);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dscongNV;
	}
	
	public boolean create(CongCuaNhanVien congNV) {
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		PreparedStatement stmt = null;
		int n=0;
		
		try {
			stmt = con.prepareStatement("insert into " + "CongCuaNhanVien values (?,?,?,?,?,?,?,?)");
			stmt.setString(1, congNV.getMaCongNV());
			stmt.setString(2, congNV.getNhanVien().getMaNhanVien());
			stmt.setString(3, congNV.getNgayChamCong());
			stmt.setString(4, congNV.getCaLam());
			stmt.setString(5, congNV.getGioLam());
			stmt.setDouble(6, congNV.getLuongCaLam());
			stmt.setString(7, congNV.getTrangThai());
			stmt.setString(8, congNV.getNghiPhep());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n>0;
	}
	public boolean delete(String maCongNV) {
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		
		try {
			PreparedStatement stmt = con.prepareStatement("delete from CongCuaNhanVien where maCongCuaNhanVien = ?");
			stmt.setString(1, maCongNV);
			int n = stmt.executeUpdate();
			if(n>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public int getMaxMaCongNV() {
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String query = "SELECT MAX(CAST(SUBSTRING(maCongCuaNhanVien, 3, LEN(maCongCuaNhanVien) - 2) AS INT)) FROM CongCuaNhanVien";
		
		try {
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			if(rs.next()) {
				int maxMaCongNV = rs.getInt(1);
				return maxMaCongNV;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	//
}
