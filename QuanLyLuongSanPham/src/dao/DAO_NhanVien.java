package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.Conection_DB;
import entity.NhanVien;

public class DAO_NhanVien {
	public DAO_NhanVien() {
		// TODO Auto-generated constructor stub
	}

	public static ArrayList<NhanVien> getAlltbNhanVien() {
		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();

		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		String sql = "select * from nhanvien";

		Statement statement;

		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maNV = rs.getString(1);
				String hoTen = rs.getString(2);
				String cCCD = rs.getString(3);
				String ngaySinh = rs.getString(4);
				String gioiTinh = rs.getString(5);
				String diaChi = rs.getString(6);
				String soDienThoai = rs.getString(7);
				double luongCoBan = rs.getDouble(8);
				double phuCap = rs.getDouble(9);
				String phongBan = rs.getString(10);
				double heSoLuong = rs.getDouble(11);
				NhanVien nv = new NhanVien(maNV, hoTen, cCCD, ngaySinh, gioiTinh, diaChi, soDienThoai, luongCoBan,
						phuCap, phongBan, heSoLuong);
				dsnv.add(nv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsnv;
	}
	public static ArrayList<NhanVien> getmatbNhanVien(String ma) {
		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();

		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();


		String sql = "select * from nhanvien where maNhanVien=?";
		
		
		
		PreparedStatement stmt =null;
		try {
			stmt =con.prepareStatement(sql);
			stmt.setString(1, ma);
			ResultSet rs =stmt.executeQuery();
			while (rs.next()) {
				String maNV = rs.getString(1);
				String hoTen = rs.getString(2);
				String cCCD = rs.getString(3);
				String ngaySinh = rs.getString(4);
				String gioiTinh = rs.getString(5);
				String diaChi = rs.getString(6);
				String soDienThoai = rs.getString(7);
				double luongCoBan = rs.getDouble(8);
				double phuCap = rs.getDouble(9);
				String phongBan = rs.getString(10);
				double heSoLuong = rs.getDouble(11);
				NhanVien nv = new NhanVien(maNV, hoTen, cCCD, ngaySinh, gioiTinh, diaChi, soDienThoai, luongCoBan,
						phuCap, phongBan, heSoLuong);
				dsnv.add(nv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsnv;
	}
	public boolean create(NhanVien nv) {
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		PreparedStatement stmt = null;
		int n = 0;

		try {
			stmt = con.prepareStatement("insert into NhanVien values(?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, nv.getMaNhanVien());
			stmt.setString(2, nv.getHoTen());
			stmt.setString(3, nv.getcCCD());
			stmt.setString(4, nv.getNgaySinh());
			stmt.setString(5, nv.getGioiTinh());
			stmt.setString(6, nv.getDiaChi());
			stmt.setString(7, nv.getSoDienThoai());
			stmt.setDouble(8, nv.getLuongCoBan());
			stmt.setDouble(9, nv.getPhuCap());
			stmt.setString(10, nv.getPhongBan());
			stmt.setDouble(11, nv.getHeSoLuong());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean deleteNV(String maNV) {
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		try {
			PreparedStatement stmt = con.prepareStatement("delete from NhanVien where MANHANVIEN = ?");
			stmt.setString(1, maNV);
			int n = stmt.executeUpdate();
			if (n > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean update(NhanVien nv) {
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		PreparedStatement stmt = null;
		int n = 0;

		try {
			stmt = con.prepareStatement(
					"UPDATE NhanVien SET HOTEN=?, CCCD=?, NGAYSINH=?, GIOITINH=?, DIACHI=?, SODIENTHOAI=?, LUONGCOBAN=?, PHUCAP=?, PHONGBAN=?, HESOLUONG=? WHERE MANHANVIEN=?");
			stmt.setString(1, nv.getHoTen());
			stmt.setString(2, nv.getcCCD());
			stmt.setString(3, nv.getNgaySinh());
			stmt.setString(4, nv.getGioiTinh());
			stmt.setString(5, nv.getDiaChi());
			stmt.setString(6, nv.getSoDienThoai());
			stmt.setDouble(7, nv.getLuongCoBan());
			stmt.setDouble(8, nv.getPhuCap());
			stmt.setString(9, nv.getPhongBan());
			stmt.setDouble(10, nv.getHeSoLuong());
			stmt.setString(11, nv.getMaNhanVien());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	//Tim kiem theo ten
	public List<NhanVien> timKiemTen(String ten){
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<NhanVien> dsnv = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("select * from NhanVien where HoTen = ?");
			stmt.setString(1, ten);
			rs = stmt.executeQuery();
			while(rs.next()) {
				String maNV = rs.getString(1);
				String hoTen = rs.getString(2);
				String cCCD = rs.getString(3);
				String ngaySinh = rs.getString(4);
				String gioiTinh = rs.getString(5);
				String diaChi = rs.getString(6);
				String soDienThoai = rs.getString(7);
				double luongCoBan = rs.getDouble(8);
				double phuCap = rs.getDouble(9);
				String phongBan = rs.getString(10);
				double heSoLuong = rs.getDouble(11);
				NhanVien nv = new NhanVien(maNV, hoTen, cCCD, ngaySinh, gioiTinh, diaChi, soDienThoai, luongCoBan,
						phuCap, phongBan, heSoLuong);
				dsnv.add(nv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsnv;
	}
	//Tim kiem theo gioi tinh
	public List<NhanVien> timKiemGT(String gt){
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<NhanVien> dsnv = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("select * from NhanVien where GioiTinh = ?");
			stmt.setString(1, gt);
			rs = stmt.executeQuery();
			while(rs.next()) {
				String maNV = rs.getString(1);
				String hoTen = rs.getString(2);
				String cCCD = rs.getString(3);
				String ngaySinh = rs.getString(4);
				String gioiTinh = rs.getString(5);
				String diaChi = rs.getString(6);
				String soDienThoai = rs.getString(7);
				double luongCoBan = rs.getDouble(8);
				double phuCap = rs.getDouble(9);
				String phongBan = rs.getString(10);
				double heSoLuong = rs.getDouble(11);
				NhanVien nv = new NhanVien(maNV, hoTen, cCCD, ngaySinh, gioiTinh, diaChi, soDienThoai, luongCoBan,
						phuCap, phongBan, heSoLuong);
				dsnv.add(nv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsnv;
	}

	// Lấy mã nhân viên lớn nhất có trong csdl để tránh bị trùng
	public int getMaxEmployeeNumber() {
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			// Truy vấn để lấy ra mã nhân viên lớn nhất
			String query = "SELECT MAX(CAST(SUBSTRING(MaNhanVien, 3, LEN(MaNhanVien) - 2) AS INT)) FROM NhanVien";
			stmt = con.prepareStatement(query);
			// Thực hiện truy vấn
			rs = stmt.executeQuery();
			if (rs.next()) {
				int maxEmployeeNumber = rs.getInt(1);
				return maxEmployeeNumber;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
		return 0; // Trả về giá trị mặc định nếu có lỗi
	}

	//

}
