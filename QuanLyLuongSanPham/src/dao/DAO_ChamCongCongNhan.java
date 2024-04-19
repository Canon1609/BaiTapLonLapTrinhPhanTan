package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.Conection_DB;
import entity.CongCuaCongNhan;
import entity.CongCuaNhanVien;
import entity.CongDoan;
import entity.CongNhan;
import entity.PhanCong;

public class DAO_ChamCongCongNhan {
	public DAO_ChamCongCongNhan() {
		// TODO Auto-generated constructor stub
	}
	public static ArrayList<CongCuaCongNhan> getAlltbCongCuaCongNhan(){
		ArrayList<CongCuaCongNhan> dscongCN = new ArrayList<CongCuaCongNhan>();
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		String sql = "select * from CongCuaCongNhan";
		Statement statement;
		
		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maCong = rs.getString(1);
				String maCN = rs.getString(2);
				String tenCN = rs.getString(3);
				String maPC = rs.getString(4);
				String maCD = rs.getString(5);
				String tenCD = rs.getString(6);
				String ngayCham = rs.getString(7);
				String caLam = rs.getString(8);
				String gioLam = rs.getString(9);
				double luongCaLam = rs.getDouble(10);
				int soSP = rs.getInt(11);
				String trangThai = rs.getString(12);
				String nghiPhep = rs.getString(13);
				
				CongNhan cn = new CongNhan(maCN);
				PhanCong pc = new PhanCong(maPC);
				CongDoan cd = new CongDoan(maCD);
				
				CongCuaCongNhan congCN = new CongCuaCongNhan(maCong, cn, tenCN, pc, cd, tenCD, ngayCham, caLam, gioLam, luongCaLam,soSP, trangThai, nghiPhep);
				dscongCN.add(congCN);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dscongCN;
	}
	public boolean create(CongCuaCongNhan congCN) {
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		PreparedStatement stmt = null;
		int n=0;
		
		try {
			stmt = con.prepareStatement("insert into " + "CongCuaCongNhan values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, congCN.getMaCongCN());
			stmt.setString(2, congCN.getCongNhan().getMaCongNhan());
			stmt.setString(3, congCN.getTenCongNhan());
			stmt.setString(4, congCN.getPhanCong().getMaPhanCong());
			stmt.setString(5, congCN.getCongDoan().getMaCongDoan());
			stmt.setString(6, congCN.getTenCongDoan());
			stmt.setString(7, congCN.getNgayChamCong());
			stmt.setString(8, congCN.getCaLam());
			stmt.setString(9, congCN.getGiolam());
			stmt.setDouble(10, congCN.getLuongCaLam());
			stmt.setInt(11, congCN.getSlSPDaLam());
			stmt.setString(12, congCN.getTrangThai());
			stmt.setString(13, congCN.getNghiPhep());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n>0;
	}
	public boolean delete(String maCongCN) {
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		
		try {
			PreparedStatement stmt = con.prepareStatement("delete from CongCuaCongNhan where maCongCuaCongNhan = ?");
			stmt.setString(1, maCongCN);
			int n = stmt.executeUpdate();
			if(n>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public int getMaxMaCongCN() {
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String query = "SELECT MAX(CAST(SUBSTRING(maCongCuaCongNhan, 3, LEN(maCongCuaCongNhan) - 2) AS INT)) FROM CongCuaCongNhan";
		
		try {
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			if(rs.next()) {
				int maxMaCongCN = rs.getInt(1);
				return maxMaCongCN;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	//
}
