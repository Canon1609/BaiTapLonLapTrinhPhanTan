package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.Conection_DB;
import entity.CongNhan;
import entity.LuongCongNhan;
import entity.LuongNhanVien;
import entity.NhanVien;

public class DAO_TinhLuongCongNhan {
	public DAO_TinhLuongCongNhan() {
		// TODO Auto-generated constructor stub
	}
	public static ArrayList<LuongCongNhan> getAlltbCongCuaNhanVien(){
		ArrayList<LuongCongNhan> dsluongNV = new ArrayList<LuongCongNhan>();
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		String sql = "select * from LuongCongNhan";
		Statement statement;
		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maLuong = rs.getString(1);
				String maNV = rs.getString("maCongNhan");
				String tenNV = rs.getString(3);
				int soNgayDiLam = rs.getInt(4);
				int thangNhan = rs.getInt(5);
				int namNhan = rs.getInt(6);
				double thucNhan = rs.getDouble(7);
				
				CongNhan cn = new CongNhan(maNV);
				LuongCongNhan luongNV =new LuongCongNhan(maLuong, cn, tenNV, soNgayDiLam, thangNhan, namNhan, thucNhan);
				dsluongNV.add(luongNV);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsluongNV;
	}
	public static ArrayList<LuongCongNhan> getmatbNhanVien(String ma) {
		ArrayList<LuongCongNhan> dsnv = new ArrayList<LuongCongNhan>();

		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();


		String sql = "select * from luongCongNhan where maCongNhan=?";
		
		
		
		PreparedStatement stmt =null;
		try {
			stmt =con.prepareStatement(sql);
			stmt.setString(1, ma);
			ResultSet rs =stmt.executeQuery();
			while (rs.next()) {
				String maLuong = rs.getString(1);
				String maNV = rs.getString("maCongNhan");
				String tenNV = rs.getString(3);
				int soNgayDiLam = rs.getInt(4);
				int thangNhan = rs.getInt(5);
				int namNhan = rs.getInt(6);
				double thucNhan = rs.getDouble(7);
				
				CongNhan cn = new CongNhan(maNV);
				LuongCongNhan luongNV =new LuongCongNhan(maLuong, cn, tenNV, soNgayDiLam, thangNhan, namNhan, thucNhan);
				dsnv.add(luongNV);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsnv;
	}
	public List<LuongCongNhan> timKiemNgayLMonth(String date) {
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<LuongCongNhan> dsnv = new ArrayList<>();

		try {
			stmt = con.prepareStatement("select * from LuongCongNhan where thangNhan =?");
			stmt.setString(1, date);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String maLuong = rs.getString(1);
				String maNV = rs.getString("maCongNhan");
				String tenNV = rs.getString(3);
				int soNgayDiLam = rs.getInt(4);
				int thangNhan = rs.getInt(5);
				int namNhan = rs.getInt(6);
				double thucNhan = rs.getDouble(7);
				
				CongNhan cn = new CongNhan(maNV);
				LuongCongNhan luongNV =new LuongCongNhan(maLuong, cn, tenNV, soNgayDiLam, thangNhan, namNhan, thucNhan);
				dsnv.add(luongNV);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsnv;
	}
	public List<LuongCongNhan> timKiemNgayLYear(String date) {
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<LuongCongNhan> dsnv = new ArrayList<>();

		try {
			stmt = con.prepareStatement("select * from LuongCongNhan where namNhan =?");
			stmt.setString(1, date);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String maLuong = rs.getString(1);
				String maNV = rs.getString("maCongNhan");
				String tenNV = rs.getString(3);
				int soNgayDiLam = rs.getInt(4);
				int thangNhan = rs.getInt(5);
				int namNhan = rs.getInt(6);
				double thucNhan = rs.getDouble(7);
				
				CongNhan cn = new CongNhan(maNV);
				LuongCongNhan luongNV =new LuongCongNhan(maLuong, cn, tenNV, soNgayDiLam, thangNhan, namNhan, thucNhan);
				dsnv.add(luongNV);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsnv;
	}
	public List<LuongCongNhan> timKiem(String month, String year, String maHD) {
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<LuongCongNhan> dsnv = new ArrayList<>();

		try {
			stmt = con.prepareStatement("select * from LuongCongNhan where thangNhan =? AND namNhan = ? AND maCongNhan = ?");
			stmt.setString(1, month);
			stmt.setString(2, year);
			stmt.setString(3, maHD);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String maLuong = rs.getString(1);
				String maNV = rs.getString("maCongNhan");
				String tenNV = rs.getString(3);
				int soNgayDiLam = rs.getInt(4);
				int thangNhan = rs.getInt(5);
				int namNhan = rs.getInt(6);
				double thucNhan = rs.getDouble(7);
				
				CongNhan cn = new CongNhan(maNV);
				LuongCongNhan luongNV =new LuongCongNhan(maLuong, cn, tenNV, soNgayDiLam, thangNhan, namNhan, thucNhan);
				dsnv.add(luongNV);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsnv;
	}
	public List<LuongCongNhan> timKiemMonthYear(String month, String year) {
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<LuongCongNhan> dsnv = new ArrayList<>();

		try {
			stmt = con.prepareStatement("select * from LuongCongNhan where thangNhan =? AND namNhan = ? ");
			stmt.setString(1, month);
			stmt.setString(2, year);
			
			rs = stmt.executeQuery();
			while (rs.next()) {
				String maLuong = rs.getString(1);
				String maNV = rs.getString("maCongNhan");
				String tenNV = rs.getString(3);
				int soNgayDiLam = rs.getInt(4);
				int thangNhan = rs.getInt(5);
				int namNhan = rs.getInt(6);
				double thucNhan = rs.getDouble(7);
				
				CongNhan cn = new CongNhan(maNV);
				LuongCongNhan luongNV =new LuongCongNhan(maLuong, cn, tenNV, soNgayDiLam, thangNhan, namNhan, thucNhan);
				dsnv.add(luongNV);


			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsnv;
	}
	public List<LuongCongNhan> timKiemMonthMaHD(String month, String maHD) {
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<LuongCongNhan> dsnv = new ArrayList<>();

		try {
			stmt = con.prepareStatement("select * from LuongCongNhan where thangNhan =? AND maCongNhan = ?");
			stmt.setString(1, month);
		
			stmt.setString(2, maHD);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String maLuong = rs.getString(1);
				String maNV = rs.getString("maCongNhan");
				String tenNV = rs.getString(3);
				int soNgayDiLam = rs.getInt(4);
				int thangNhan = rs.getInt(5);
				int namNhan = rs.getInt(6);
				double thucNhan = rs.getDouble(7);
				
				CongNhan cn = new CongNhan(maNV);
				LuongCongNhan luongNV =new LuongCongNhan(maLuong, cn, tenNV, soNgayDiLam, thangNhan, namNhan, thucNhan);
				dsnv.add(luongNV);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsnv;
	}
	public List<LuongCongNhan> timKiemYearMaHD(String year, String maHD) {
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<LuongCongNhan> dsnv = new ArrayList<>();

		try {
			stmt = con.prepareStatement("select * from LuongCongNhan where namNhan = ? AND maCongNhan = ?");
			
			stmt.setString(1, year);
			stmt.setString(2, maHD);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String maLuong = rs.getString(1);
				String maNV = rs.getString("maCongNhan");
				String tenNV = rs.getString(3);
				int soNgayDiLam = rs.getInt(4);
				int thangNhan = rs.getInt(5);
				int namNhan = rs.getInt(6);
				double thucNhan = rs.getDouble(7);
				
				CongNhan cn = new CongNhan(maNV);
				LuongCongNhan luongNV =new LuongCongNhan(maLuong, cn, tenNV, soNgayDiLam, thangNhan, namNhan, thucNhan);
				dsnv.add(luongNV);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsnv;
	}
	public int getMaxMaLuongNV() {
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String query = "SELECT MAX(CAST(SUBSTRING(maLuongNhanVien, 3, LEN(maLuongNhanVien) - 2) AS INT)) FROM LuongNhanVien";
		
		try {
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			if(rs.next()) {
				int maxMaLuongNV = rs.getInt(1);
				return maxMaLuongNV;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
