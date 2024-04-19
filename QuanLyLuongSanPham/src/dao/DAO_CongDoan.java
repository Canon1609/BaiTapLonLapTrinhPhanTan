package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.Conection_DB;
import entity.CongDoan;
import entity.SanPham;


public class DAO_CongDoan {
	public DAO_CongDoan() {
		// TODO Auto-generated constructor stub
	}
	public static ArrayList<CongDoan> getAlltbCongDoan(){
		ArrayList<CongDoan> dscd = new ArrayList<CongDoan>();

		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		String sql = "select * from CongDoan";

		Statement statement;
		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maCongDoan = rs.getString(1);
				String tenCongDoan = rs.getString(2);
				double giaCongDoan = rs.getDouble(3);
				String maSP = rs.getString(4);
				String tenSP = rs.getString(5);
				int soLuong = rs.getInt(6);
				String congDoanYC = rs.getString(7);
				SanPham sp = new SanPham(maSP);
				CongDoan cd = new CongDoan(maCongDoan, tenCongDoan, giaCongDoan, sp, tenSP, soLuong, congDoanYC);
				dscd.add(cd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dscd;
	}
	public boolean create(CongDoan cd) {
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt = con.prepareStatement("insert into " + "CongDoan values (?,?,?,?,?,?,?)");
			stmt.setString(1, cd.getMaCongDoan());
			stmt.setString(2, cd.getTenCongDoan());
			stmt.setDouble(3, cd.getGiaCongDoan());
			stmt.setString(4, cd.getSanPham().getMaSanPham());
			stmt.setString(5, cd.getTenSanPham());
			stmt.setInt(6, cd.getSoLuong());
			stmt.setString(7, cd.getCongDoanYC());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n>0;
	}
	public boolean delete(String maCD) {
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		
		try {
			PreparedStatement stmt = con.prepareStatement("delete from CongDoan where maCongDoan = ?");
			stmt.setString(1, maCD);
			int n = stmt.executeUpdate();
			if(n>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean update(CongDoan cd) {
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		PreparedStatement stmt = null;
		int n = 0;

		try {
			stmt = con.prepareStatement(
					"UPDATE CongDoan SET tenCongDoan=?, GiaCongDoan=?, MaSanPham=?, tenSanPham=?, SoLuong=?, CongDoanyeuCau=? WHERE MACONGDOAN=?");
			stmt.setString(1, cd.getTenCongDoan());
			stmt.setDouble(2, cd.getGiaCongDoan());
			stmt.setString(3, cd.getSanPham().getMaSanPham());
			stmt.setString(4, cd.getTenSanPham());
			stmt.setInt(5, cd.getSoLuong());
			stmt.setString(6, cd.getCongDoanYC());
			stmt.setString(7, cd.getMaCongDoan());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public int getMaxMaCongDoan() {
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String query = "SELECT MAX(CAST(SUBSTRING(maCongDoan, 7, LEN(maCongDoan) - 6) AS INT)) FROM CongDoan";
		
		try {
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			if(rs.next()) {
				int maxMaCongDoan = rs.getInt(1);
				return maxMaCongDoan;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public List<String> getAllCongDoanYeuCau() {
	    List<String> congDoanYeuCauList = new ArrayList<>();

	    Conection_DB.getInstance();
	    Connection con = Conection_DB.getCon();
	    String sql = "SELECT DISTINCT tenCongDoan FROM CongDoan WHERE tenCongDoan IS NOT NULL";

	    try {
	        Statement statement = con.createStatement();
	        ResultSet rs = statement.executeQuery(sql);
	        while (rs.next()) {
	            String congDoanYC = rs.getString("tenCongDoan");
	            congDoanYeuCauList.add(congDoanYC);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return congDoanYeuCauList;
	}

	public static boolean coCongDoanYeuCau(String maCongDoan) {
	    Conection_DB.getInstance();
	    Connection con = Conection_DB.getCon();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    String query = "SELECT COUNT(*) FROM CongDoan WHERE maCongDoan = ? AND congDoanYeuCau IS NOT NULL";

	    try {
	        stmt = con.prepareStatement(query);
	        stmt.setString(1, maCongDoan);
	        rs = stmt.executeQuery();

	        if (rs.next()) {
	            int count = rs.getInt(1);
	            return count > 0; // Trả về true nếu có công đoạn yêu cầu, ngược lại là false
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false; // Trả về false nếu có lỗi xảy ra
	}
	  // Phương thức trả về giá công đoạn theo mã công đoạn
    public static double getGiaCongDoanByMaCongDoan(String maCongDoan) {
    	Conection_DB.getInstance();
	    Connection con = Conection_DB.getCon();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        double giaCongDoan = 0;

        try {
            String query = "SELECT giaCongDoan FROM CongDoan WHERE maCongDoan = ?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, maCongDoan);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                giaCongDoan = rs.getDouble("giaCongDoan");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        return giaCongDoan;
    }

//
	
}
