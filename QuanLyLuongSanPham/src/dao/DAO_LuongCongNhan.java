package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.Conection_DB;
import entity.CongNhan;
import entity.LuongCongNhan;

public class DAO_LuongCongNhan {
	public DAO_LuongCongNhan() {
		// TODO Auto-generated constructor stub
	}
	public static ArrayList<LuongCongNhan> getAlltbLuongCuaCongNhan(){
		ArrayList<LuongCongNhan> dsluongCN = new ArrayList<LuongCongNhan>();
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		String sql = "select * from LuongCongNhan";
		Statement statement;
		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maLuong = rs.getString(1);
				String maCN = rs.getString(2);
				String tenCN = rs.getString(3);
				int soNgayDiLam = rs.getInt(4);
				int thangNhan = rs.getInt(5);
				int namNhan = rs.getInt(6);
				double thucNhan = rs.getDouble(7);
				
				CongNhan cn = new CongNhan(maCN);
				LuongCongNhan luongCN = new LuongCongNhan(maLuong, cn, tenCN, soNgayDiLam, thangNhan, namNhan, thucNhan);
				dsluongCN.add(luongCN);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsluongCN;
	}
	
	public boolean create(LuongCongNhan luongCN) {
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		PreparedStatement stmt = null;
		int n=0;
		
		try {
			stmt = con.prepareStatement("insert into " + "LuongCongNhan values (?,?,?,?,?,?,?)");
			stmt.setString(1, luongCN.getMaLuongCongNhan());
			stmt.setString(2, luongCN.getCongNhan().getMaCongNhan());
			stmt.setString(3, luongCN.getTenCongNhan());
			stmt.setInt(4, luongCN.getSoNgayDiLam());
			stmt.setInt(5, luongCN.getThangNhan());
			stmt.setInt(6, luongCN.getNamNhan());
			stmt.setDouble(7, luongCN.getThucNhan());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n>0;
	}
	public boolean delete(String maLuongCN) {
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		
		try {
			PreparedStatement stmt = con.prepareStatement("delete from LuongCongNhan where maLuongCongNhan = ?");
			stmt.setString(1, maLuongCN);
			int n = stmt.executeUpdate();
			if(n>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public int getMaxMaLuongCN() {
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String query = "SELECT MAX(CAST(SUBSTRING(maLuongCongNhan, 3, LEN(maLuongCongNhan) - 2) AS INT)) FROM LuongCongNhan";
		
		try {
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			if(rs.next()) {
				int maxMaLuongCN = rs.getInt(1);
				return maxMaLuongCN;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
