package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.Conection_DB;
import entity.CongCuaNhanVien;
import entity.LuongNhanVien;
import entity.NhanVien;

public class DAO_LuongNhanVien {
	public DAO_LuongNhanVien() {
		// TODO Auto-generated constructor stub
	}
	public static ArrayList<LuongNhanVien> getAlltbCongCuaNhanVien(){
		ArrayList<LuongNhanVien> dsluongNV = new ArrayList<LuongNhanVien>();
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		String sql = "select * from LuongNhanVien";
		Statement statement;
		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maLuong = rs.getString(1);
				String maNV = rs.getString("maNhanVien");
				String tenNV = rs.getString(3);
				int soNgayDiLam = rs.getInt(4);
				int thangNhan = rs.getInt(5);
				int namNhan = rs.getInt(6);
				double thucNhan = rs.getDouble(7);
				
				NhanVien nv = new NhanVien(maNV);
				LuongNhanVien luongNV = new LuongNhanVien(maLuong, nv, tenNV, soNgayDiLam, thangNhan, namNhan, thucNhan);
				dsluongNV.add(luongNV);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsluongNV;
	}
	
	public boolean create(LuongNhanVien luongNV) {
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		PreparedStatement stmt = null;
		int n=0;
		
		try {
			stmt = con.prepareStatement("insert into " + "LuongNhanVien values (?,?,?,?,?,?,?)");
			stmt.setString(1, luongNV.getMaLuongNhanVien());
			stmt.setString(2, luongNV.getNhanVien().getMaNhanVien());
			stmt.setString(3, luongNV.getTenNhanVien());
			stmt.setInt(4, luongNV.getSoNgayDiLam());
			stmt.setInt(5, luongNV.getThangNhan());
			stmt.setInt(6, luongNV.getNamNhan());
			stmt.setDouble(7, luongNV.getThucNhan());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n>0;
	}
	public boolean delete(String maLuongNV) {
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		
		try {
			PreparedStatement stmt = con.prepareStatement("delete from LuongNhanVien where maLuongNhanVien = ?");
			stmt.setString(1, maLuongNV);
			int n = stmt.executeUpdate();
			if(n>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
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
	//TimKIem
	
		public static ArrayList<LuongNhanVien> getmatbNhanVien(String ma) {
			ArrayList<LuongNhanVien> dsnv = new ArrayList<LuongNhanVien>();

			Conection_DB.getInstance();
			Connection con = Conection_DB.getCon();


			String sql = "select * from luongNhanVien where maNhanVien=?";
			
			
			
			PreparedStatement stmt =null;
			try {
				stmt =con.prepareStatement(sql);
				stmt.setString(1, ma);
				ResultSet rs =stmt.executeQuery();
				while (rs.next()) {
					String maLuong = rs.getString(1);
					String maNV = rs.getString("maNhanVien");
					String tenNV = rs.getString(3);
					int soNgayDiLam = rs.getInt(4);
					int thangNhan = rs.getInt(5);
					int namNhan = rs.getInt(6);
					double thucNhan = rs.getDouble(7);
					
					NhanVien nv = new NhanVien(maNV);
					LuongNhanVien luongNV = new LuongNhanVien(maLuong, nv, tenNV, soNgayDiLam, thangNhan, namNhan, thucNhan);
					dsnv.add(luongNV);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dsnv;
		}
		public List<LuongNhanVien> timKiemNgayLMonth(String date) {
			Conection_DB.getInstance();
			Connection con = Conection_DB.getCon();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			List<LuongNhanVien> dsnv = new ArrayList<>();

			try {
				stmt = con.prepareStatement("select * from luongNhanVien where thangNhan =?");
				stmt.setString(1, date);
				rs = stmt.executeQuery();
				while (rs.next()) {
					String maLuong = rs.getString(1);
					String maNV = rs.getString("maNhanVien");
					String tenNV = rs.getString(3);
					int soNgayDiLam = rs.getInt(4);
					int thangNhan = rs.getInt(5);
					int namNhan = rs.getInt(6);
					double thucNhan = rs.getDouble(7);
					
					NhanVien nv = new NhanVien(maNV);
					LuongNhanVien luongNV = new LuongNhanVien(maLuong, nv, tenNV, soNgayDiLam, thangNhan, namNhan, thucNhan);
					dsnv.add(luongNV);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dsnv;
		}
		public List<LuongNhanVien> timKiemNgayLYear(String date) {
			Conection_DB.getInstance();
			Connection con = Conection_DB.getCon();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			List<LuongNhanVien> dsnv = new ArrayList<>();

			try {
				stmt = con.prepareStatement("select * from luongNhanVien where namNhan =?");
				stmt.setString(1, date);
				rs = stmt.executeQuery();
				while (rs.next()) {
					String maLuong = rs.getString(1);
					String maNV = rs.getString("maNhanVien");
					String tenNV = rs.getString(3);
					int soNgayDiLam = rs.getInt(4);
					int thangNhan = rs.getInt(5);
					int namNhan = rs.getInt(6);
					double thucNhan = rs.getDouble(7);
					
					NhanVien nv = new NhanVien(maNV);
					LuongNhanVien luongNV = new LuongNhanVien(maLuong, nv, tenNV, soNgayDiLam, thangNhan, namNhan, thucNhan);
					dsnv.add(luongNV);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dsnv;
		}
		public List<LuongNhanVien> timKiem(String month, String year, String maHD) {
			Conection_DB.getInstance();
			Connection con = Conection_DB.getCon();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			List<LuongNhanVien> dsnv = new ArrayList<>();

			try {
				stmt = con.prepareStatement("select * from luongNhanVien where thangNhan =? AND namNhan = ? AND maNhanVien = ?");
				stmt.setString(1, month);
				stmt.setString(2, year);
				stmt.setString(3, maHD);
				rs = stmt.executeQuery();
				while (rs.next()) {
					String maLuong = rs.getString(1);
					String maNV = rs.getString("maNhanVien");
					String tenNV = rs.getString(3);
					int soNgayDiLam = rs.getInt(4);
					int thangNhan = rs.getInt(5);
					int namNhan = rs.getInt(6);
					double thucNhan = rs.getDouble(7);
					
					NhanVien nv = new NhanVien(maNV);
					LuongNhanVien luongNV = new LuongNhanVien(maLuong, nv, tenNV, soNgayDiLam, thangNhan, namNhan, thucNhan);
					dsnv.add(luongNV);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dsnv;
		}
		public List<LuongNhanVien> timKiemMonthYear(String month, String year) {
			Conection_DB.getInstance();
			Connection con = Conection_DB.getCon();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			List<LuongNhanVien> dsnv = new ArrayList<>();

			try {
				stmt = con.prepareStatement("select * from luongNhanVien where thangNhan =? AND namNhan = ? ");
				stmt.setString(1, month);
				stmt.setString(2, year);
				
				rs = stmt.executeQuery();
				while (rs.next()) {
					String maLuong = rs.getString(1);
					String maNV = rs.getString("maNhanVien");
					String tenNV = rs.getString(3);
					int soNgayDiLam = rs.getInt(4);
					int thangNhan = rs.getInt(5);
					int namNhan = rs.getInt(6);
					double thucNhan = rs.getDouble(7);
					
					NhanVien nv = new NhanVien(maNV);
					LuongNhanVien luongNV = new LuongNhanVien(maLuong, nv, tenNV, soNgayDiLam, thangNhan, namNhan, thucNhan);
					dsnv.add(luongNV);


				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dsnv;
		}
		public List<LuongNhanVien> timKiemMonthMaHD(String month, String maHD) {
			Conection_DB.getInstance();
			Connection con = Conection_DB.getCon();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			List<LuongNhanVien> dsnv = new ArrayList<>();

			try {
				stmt = con.prepareStatement("select * from luongNhanVien where thangNhan =? AND maNhanVien = ?");
				stmt.setString(1, month);
			
				stmt.setString(2, maHD);
				rs = stmt.executeQuery();
				while (rs.next()) {
					String maLuong = rs.getString(1);
					String maNV = rs.getString("maNhanVien");
					String tenNV = rs.getString(3);
					int soNgayDiLam = rs.getInt(4);
					int thangNhan = rs.getInt(5);
					int namNhan = rs.getInt(6);
					double thucNhan = rs.getDouble(7);
					
					NhanVien nv = new NhanVien(maNV);
					LuongNhanVien luongNV = new LuongNhanVien(maLuong, nv, tenNV, soNgayDiLam, thangNhan, namNhan, thucNhan);
					dsnv.add(luongNV);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dsnv;
		}
		public List<LuongNhanVien> timKiemYearMaHD(String year, String maHD) {
			Conection_DB.getInstance();
			Connection con = Conection_DB.getCon();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			List<LuongNhanVien> dsnv = new ArrayList<>();

			try {
				stmt = con.prepareStatement("select * from luongNhanVien where namNhan = ? AND maNhanVien = ?");
				
				stmt.setString(1, year);
				stmt.setString(2, maHD);
				rs = stmt.executeQuery();
				while (rs.next()) {
					String maLuong = rs.getString(1);
					String maNV = rs.getString("maNhanVien");
					String tenNV = rs.getString(3);
					int soNgayDiLam = rs.getInt(4);
					int thangNhan = rs.getInt(5);
					int namNhan = rs.getInt(6);
					double thucNhan = rs.getDouble(7);
					
					NhanVien nv = new NhanVien(maNV);
					LuongNhanVien luongNV = new LuongNhanVien(maLuong, nv, tenNV, soNgayDiLam, thangNhan, namNhan, thucNhan);
					dsnv.add(luongNV);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dsnv;
		}
}
