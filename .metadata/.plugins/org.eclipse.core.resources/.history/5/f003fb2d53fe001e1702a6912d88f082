package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.Conection_DB;
import entity.SanPham;


public class DAO_SanPham {
	public DAO_SanPham() {
		// TODO Auto-generated constructor stub
	}

	public static ArrayList<SanPham> getAlltbSanPham() {
		ArrayList<SanPham> dssp = new ArrayList<SanPham>();

		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		String sql = "select * from sanpham";

		Statement statement;

		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maSanPham = rs.getString(1);
				String tenSanPham = rs.getString(2);
				String kieuDang = rs.getString(3);
				String chatLieu = rs.getString(4);
				int soLuong = rs.getInt(5);
				SanPham sp = new SanPham(maSanPham, tenSanPham, kieuDang, chatLieu, soLuong);
				dssp.add(sp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dssp;
	}
	
	public boolean create(SanPham sp) {
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		PreparedStatement stmt = null;
		int n = 0;

		try {
			stmt = con.prepareStatement("insert into SanPham values(?,?,?,?,?)");
			stmt.setString(1, sp.getMaSanPham());
			stmt.setString(2, sp.getTenSanPham());
			stmt.setString(3, sp.getKieuDang());
			stmt.setString(4, sp.getChatLieu());
			stmt.setInt(5, sp.getSoLuong());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean deleteSP(String maSP) {
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		try {
			PreparedStatement stmt = con.prepareStatement("delete from SANPHAM where MASANPHAM = ?");
			stmt.setString(1, maSP);
			int n = stmt.executeUpdate();
			if (n > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public boolean update(SanPham sp) {
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		PreparedStatement stmt = null;
		int n = 0;

		try {
			stmt = con.prepareStatement(
					"UPDATE SanPham SET TENSANPHAM=?, KIEUDANG=?, CHATLIEU=?, SOLUONG=? WHERE MASANPHAM=?");
			stmt.setString(1, sp.getTenSanPham());
			stmt.setString(2, sp.getKieuDang());
			stmt.setString(3, sp.getChatLieu());
			stmt.setInt(4, sp.getSoLuong());
			stmt.setString(5, sp.getMaSanPham());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	//Tim kiem theo ten
	public List<SanPham> timKiemTen(String ten){
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<SanPham> dssp = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("select * from SanPham where TENSANPHAM = ?");
			stmt.setString(1,ten);
			rs = stmt.executeQuery();
			while(rs.next()) {
				String maSanPham = rs.getString(1);
				String tenSanPham = rs.getString(2);
				String kieuDang = rs.getString(3);
				String chatLieu = rs.getString(4);
				int soLuong = rs.getInt(5);
				SanPham sp = new SanPham(maSanPham, tenSanPham, kieuDang, chatLieu, soLuong);
				dssp.add(sp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dssp;
	}
	//Tim kiem theo ten
		public List<SanPham> timKiemMa(String ma){
			Conection_DB.getInstance();
			Connection con = Conection_DB.getCon();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			List<SanPham> dssp = new ArrayList<>();
			
			try {
				stmt = con.prepareStatement("select * from SanPham where maSanPham = ?");
				stmt.setString(1,ma);
				rs = stmt.executeQuery();
				while(rs.next()) {
					String maSanPham = rs.getString(1);
					String tenSanPham = rs.getString(2);
					String kieuDang = rs.getString(3);
					String chatLieu = rs.getString(4);
					int soLuong = rs.getInt(5);
					SanPham sp = new SanPham(maSanPham, tenSanPham, kieuDang, chatLieu, soLuong);
					dssp.add(sp);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dssp;
		}
		
		//Tim kiem theo kieu dang
		public List<SanPham> timKiemKD(String kd){
			Conection_DB.getInstance();
			Connection con = Conection_DB.getCon();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			List<SanPham> dssp = new ArrayList<>();
			
			try {
				stmt = con.prepareStatement("select * from SanPham where KieuDang = ?");
				stmt.setString(1, kd);
				rs = stmt.executeQuery();
				while(rs.next()) {
					String maSanPham = rs.getString(1);
					String tenSanPham = rs.getString(2);
					String kieuDang = rs.getString(3);
					String chatLieu = rs.getString(4);
					int soLuong = rs.getInt(5);
					SanPham sp = new SanPham(maSanPham, tenSanPham, kieuDang, chatLieu, soLuong);
					dssp.add(sp);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dssp;
		}
		public List<SanPham> timKiem(String ma , String ten){
			Conection_DB.getInstance();
			Connection con = Conection_DB.getCon();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			List<SanPham> dssp = new ArrayList<>();
			
			try {
				stmt = con.prepareStatement("select * from SanPham where maSanPham = ? and tenSanPham = ?");
				stmt.setString(1, ma);
				stmt.setString(2, ten);
				rs = stmt.executeQuery();
				while(rs.next()) {
					String maSanPham = rs.getString(1);
					String tenSanPham = rs.getString(2);
					String kieuDang = rs.getString(3);
					String chatLieu = rs.getString(4);
					int soLuong = rs.getInt(5);
					SanPham sp = new SanPham(maSanPham, tenSanPham, kieuDang, chatLieu, soLuong);
					dssp.add(sp);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dssp;
		}
	
	public int getSoLuong(String maSanPham) {
	    int soLuong = 0;

	    Connection con = Conection_DB.getCon();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;

	    try {
	        // Truy vấn để lấy ra số lượng của sản phẩm có mã là maSanPham
	        String sql = "SELECT SOLUONG FROM SanPham WHERE MASANPHAM = ?";
	        stmt = con.prepareStatement(sql);
	        stmt.setString(1, maSanPham);

	        rs = stmt.executeQuery();

	        if (rs.next()) {
	            soLuong = rs.getInt("SOLUONG");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return soLuong;
	}

	// Lấy mã sản phẩm lớn nhất có trong csdl để tránh bị trùng
	public int getMaxProductNumberNumber() {
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			// Truy vấn để lấy ra mã sản phẩm lớn nhất
			String query = "SELECT MAX(CAST(SUBSTRING(MaSanPham, 3, LEN(MaSanPham) - 2) AS INT)) FROM SanPham";
			stmt = con.prepareStatement(query);
			// Thực hiện truy vấn
			rs = stmt.executeQuery();
			if (rs.next()) {
				int maxProductNumber = rs.getInt(1);
				return maxProductNumber;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
		return 0; // Trả về giá trị mặc định nếu có lỗi
	}
	

}
