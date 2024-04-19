package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.Conection_DB;
import entity.HopDong;
import entity.NhanVien;
import entity.SanPham;

public class DAO_HopDong {
	public DAO_HopDong() {
		// TODO Auto-generated constructor stub
	}

	public static ArrayList<HopDong> getAllHopDong() {
	    ArrayList<HopDong> dshd = new ArrayList<HopDong>();

	    Conection_DB.getInstance();
	    Connection con = Conection_DB.getCon();
	    String sql = "select * from hopdong";
	    Statement statement;

	    try {
	        statement = con.createStatement();
	        ResultSet rs = statement.executeQuery(sql);
	        while (rs.next()) {
	            String maHD = rs.getString("maHopDong");
	            String tenKH = rs.getString("TenKhachHang");
	            String ngayLap = rs.getString("NgayLap");
	            String ngayGiao = rs.getString("NgayGiao");
	            int soLuong = rs.getInt("SoLuong");
	            double donGia = rs.getDouble("DonGia");

	            // Tạo các đối tượng SanPham và NhanVien và gán thông tin từ cơ sở dữ liệu
	            SanPham maSP = new SanPham(rs.getString("maSanPham"));
	            String tenSP = rs.getString("tenSanPham");
	            NhanVien maNV = new NhanVien(rs.getString("maNhanVien"));
	            String tenNV = rs.getString("tenNhanVien");

	            HopDong hd = new HopDong(maHD, maSP, tenSP, tenKH, maNV, tenNV, ngayLap, ngayGiao, soLuong, donGia);
	            dshd.add(hd);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return dshd;
	}

	public boolean create(HopDong hd) {
	    Conection_DB.getInstance();
	    Connection con = Conection_DB.getCon();
	    PreparedStatement stmt = null;
	    int n = 0;

	    try {
	        stmt = con.prepareStatement("insert into hopdong values(?,?,?,?,?,?,?,?,?,?)");
	        stmt.setString(1, hd.getMaHopDong());
	        stmt.setString(2, hd.getSanPham().getMaSanPham());
	        stmt.setString(3, hd.getTenSPham());
	        stmt.setString(4, hd.getTenKH());
	        stmt.setString(5, hd.getNhanVien().getMaNhanVien());
	        stmt.setString(6, hd.getTenNVien());
	        stmt.setString(7, hd.getNgayLap());
	        stmt.setString(8, hd.getNgayGiao());
	        stmt.setInt(9, hd.getSoLuongSanPham());
	        stmt.setDouble(10, hd.getDonGia());

	        n = stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return n > 0;
	}


	public boolean delete(String maHD) {
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		try {
			PreparedStatement stmt = con.prepareStatement("delete from hopdong where mahopdong = ?");
			stmt.setString(1, maHD);
			int n = stmt.executeUpdate();
			if (n > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean update(HopDong hd) {
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		PreparedStatement stmt = null;
		int n = 0;

		try {
			stmt = con.prepareStatement(
				    "UPDATE hopdong SET maSanPham=?, tenSanPham=?, tenKhachHang=?, maNhanVien=?, tenNhanVien=?, "
				    + "ngayLap=?, ngayGiao=?, soLuong=?, donGia=? WHERE maHopDong=?");
				stmt.setString(1, hd.getSanPham().getMaSanPham());
				stmt.setString(2, hd.getTenNVien());
				stmt.setString(3, hd.getTenKH());
				stmt.setString(4, hd.getNhanVien().getMaNhanVien());
				stmt.setString(5, hd.getTenNVien());
				stmt.setString(6, hd.getNgayLap());
				stmt.setString(7, hd.getNgayGiao());
				stmt.setInt(8, hd.getSoLuongSanPham());
				stmt.setDouble(9, hd.getDonGia());
				stmt.setString(10, hd.getMaHopDong());

			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public List<HopDong> timKiemMaSP(String maSP) {
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<HopDong> dsnv = new ArrayList<>();

		try {
			stmt = con.prepareStatement("select * from HopDong where maSanPham = ?");
			stmt.setString(1, maSP);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String maHD = rs.getString("maHopDong");
	            String tenKH = rs.getString("TenKhachHang");
	            String ngayLap = rs.getString("NgayLap");
	            String ngayGiao = rs.getString("NgayGiao");
	            int soLuong = rs.getInt("SoLuong");
	            double donGia = rs.getDouble("DonGia");

	            // Tạo các đối tượng SanPham và NhanVien và gán thông tin từ cơ sở dữ liệu
	            SanPham maSP1 = new SanPham(rs.getString("maSanPham"));
	            String tenSP = rs.getString("tenSanPham");
	            NhanVien maNV = new NhanVien(rs.getString("maNhanVien"));
	            String tenNV = rs.getString("tenNhanVien");

	            HopDong hd = new HopDong(maHD, maSP1, tenSP, tenKH, maNV, tenNV, ngayLap, ngayGiao, soLuong, donGia);
	            dsnv.add(hd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsnv;
	}
	// Tim kiem theo ten
		public List<HopDong> timKiemMaHopDong(String ma) {
			Conection_DB.getInstance();
			Connection con = Conection_DB.getCon();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			List<HopDong> dshd = new ArrayList<>();

			try {
				stmt = con.prepareStatement("select * from HopDong where maHopDong = ?");
				stmt.setString(1, ma);
				rs = stmt.executeQuery();
				while (rs.next()) {
					String maHD = rs.getString("maHopDong");
		            String tenKH = rs.getString("TenKhachHang");
		            String ngayLap = rs.getString("NgayLap");
		            String ngayGiao = rs.getString("NgayGiao");
		            int soLuong = rs.getInt("SoLuong");
		            double donGia = rs.getDouble("DonGia");

		            // Tạo các đối tượng SanPham và NhanVien và gán thông tin từ cơ sở dữ liệu
		            SanPham maSP = new SanPham(rs.getString("maSanPham"));
		            String tenSP = rs.getString("tenSanPham");
		            NhanVien maNV = new NhanVien(rs.getString("maNhanVien"));
		            String tenNV = rs.getString("tenNhanVien");

		            HopDong hd = new HopDong(maHD, maSP, tenSP, tenKH, maNV, tenNV, ngayLap, ngayGiao, soLuong, donGia);
		            dshd.add(hd);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dshd;
		}

		public List<HopDong> timKiemTenKhachHang(String ten) {
			Conection_DB.getInstance();
			Connection con = Conection_DB.getCon();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			List<HopDong> dsnv = new ArrayList<>();

			try {
				stmt = con.prepareStatement("select * from HopDong where tenKhachHang = ?");
				stmt.setString(1, ten);
				rs = stmt.executeQuery();
				while (rs.next()) {
					String maHD = rs.getString("maHopDong");
		            String tenKH = rs.getString("TenKhachHang");
		            String ngayLap = rs.getString("NgayLap");
		            String ngayGiao = rs.getString("NgayGiao");
		            int soLuong = rs.getInt("SoLuong");
		            double donGia = rs.getDouble("DonGia");

		            // Tạo các đối tượng SanPham và NhanVien và gán thông tin từ cơ sở dữ liệu
		            SanPham maSP = new SanPham(rs.getString("maSanPham"));
		            String tenSP = rs.getString("tenSanPham");
		            NhanVien maNV = new NhanVien(rs.getString("maNhanVien"));
		            String tenNV = rs.getString("tenNhanVien");

		            HopDong hd = new HopDong(maHD, maSP, tenSP, tenKH, maNV, tenNV, ngayLap, ngayGiao, soLuong, donGia);
		            dsnv.add(hd);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dsnv;
		}

		public List<HopDong> timKiemMaNhanVien(String ma) {
			Conection_DB.getInstance();
			Connection con = Conection_DB.getCon();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			List<HopDong> dshd = new ArrayList<>();

			try {
				stmt = con.prepareStatement("select * from HopDong where maNhanVien = ?");
				stmt.setString(1, ma);
				rs = stmt.executeQuery();
				while (rs.next()) {
					String maHD = rs.getString("maHopDong");
		            String tenKH = rs.getString("TenKhachHang");
		            String ngayLap = rs.getString("NgayLap");
		            String ngayGiao = rs.getString("NgayGiao");
		            int soLuong = rs.getInt("SoLuong");
		            double donGia = rs.getDouble("DonGia");

		            // Tạo các đối tượng SanPham và NhanVien và gán thông tin từ cơ sở dữ liệu
		            SanPham maSP = new SanPham(rs.getString("maSanPham"));
		            String tenSP = rs.getString("tenSanPham");
		            NhanVien maNV = new NhanVien(rs.getString("maNhanVien"));
		            String tenNV = rs.getString("tenNhanVien");

		            HopDong hd = new HopDong(maHD, maSP, tenSP, tenKH, maNV, tenNV, ngayLap, ngayGiao, soLuong, donGia);
		            dshd.add(hd);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dshd;
		}

		// all
		public List<HopDong> timKiemALL(String ma, String tenKH1) {
			Conection_DB.getInstance();
			Connection con = Conection_DB.getCon();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			List<HopDong> dshd = new ArrayList<>();

			try {
				stmt = con.prepareStatement("select * from HopDong where maNhanVien = ? tenKhachHang=?");
				stmt.setString(1, ma);
				stmt.setString(2, tenKH1);
				rs = stmt.executeQuery();
				while (rs.next()) {
					String maHD = rs.getString("maHopDong");
		            String tenKH = rs.getString("TenKhachHang");
		            String ngayLap = rs.getString("NgayLap");
		            String ngayGiao = rs.getString("NgayGiao");
		            int soLuong = rs.getInt("SoLuong");
		            double donGia = rs.getDouble("DonGia");

		            // Tạo các đối tượng SanPham và NhanVien và gán thông tin từ cơ sở dữ liệu
		            SanPham maSP = new SanPham(rs.getString("maSanPham"));
		            String tenSP = rs.getString("tenSanPham");
		            NhanVien maNV = new NhanVien(rs.getString("maNhanVien"));
		            String tenNV = rs.getString("tenNhanVien");

		            HopDong hd = new HopDong(maHD, maSP, tenSP, tenKH, maNV, tenNV, ngayLap, ngayGiao, soLuong, donGia);
		            dshd.add(hd);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dshd;
		}

		public List<HopDong> timKiemTenNhanVien(String ten) {
			Conection_DB.getInstance();
			Connection con = Conection_DB.getCon();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			List<HopDong> dsnv = new ArrayList<>();

			try {
				stmt = con.prepareStatement("select * from HopDong where tenNhanVien = ?");
				stmt.setString(1, ten);
				rs = stmt.executeQuery();
				while (rs.next()) {
					String maHD = rs.getString("maHopDong");
		            String tenKH = rs.getString("TenKhachHang");
		            String ngayLap = rs.getString("NgayLap");
		            String ngayGiao = rs.getString("NgayGiao");
		            int soLuong = rs.getInt("SoLuong");
		            double donGia = rs.getDouble("DonGia");

		            // Tạo các đối tượng SanPham và NhanVien và gán thông tin từ cơ sở dữ liệu
		            SanPham maSP = new SanPham(rs.getString("maSanPham"));
		            String tenSP = rs.getString("tenSanPham");
		            NhanVien maNV = new NhanVien(rs.getString("maNhanVien"));
		            String tenNV = rs.getString("tenNhanVien");

		            HopDong hd = new HopDong(maHD, maSP, tenSP, tenKH, maNV, tenNV, ngayLap, ngayGiao, soLuong, donGia);
		            dsnv.add(hd);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dsnv;
		}

		// Tim kiem theo gioi tinh
		

		public List<HopDong> timKiemNgayLMonth(String date) {
			Conection_DB.getInstance();
			Connection con = Conection_DB.getCon();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			List<HopDong> dsnv = new ArrayList<>();

			try {
				stmt = con.prepareStatement("select * from HopDong where month(ngayLap) =?");
				stmt.setString(1, date);
				rs = stmt.executeQuery();
				while (rs.next()) {
					String maHD = rs.getString("maHopDong");
		            String tenKH = rs.getString("TenKhachHang");
		            String ngayLap = rs.getString("NgayLap");
		            String ngayGiao1 = rs.getString("NgayGiao");
		            int soLuong = rs.getInt("SoLuong");
		            double donGia = rs.getDouble("DonGia");

		            // Tạo các đối tượng SanPham và NhanVien và gán thông tin từ cơ sở dữ liệu
		            SanPham maSP = new SanPham(rs.getString("maSanPham"));
		            String tenSP = rs.getString("tenSanPham");
		            NhanVien maNV = new NhanVien(rs.getString("maNhanVien"));
		            String tenNV = rs.getString("tenNhanVien");

		            HopDong hd = new HopDong(maHD, maSP, tenSP, tenKH, maNV, tenNV, ngayLap, ngayGiao1, soLuong, donGia);
		            dsnv.add(hd);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dsnv;
		}
		public List<HopDong> timKiemNgayLYear(String date) {
			Conection_DB.getInstance();
			Connection con = Conection_DB.getCon();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			List<HopDong> dsnv = new ArrayList<>();

			try {
				stmt = con.prepareStatement("select * from HopDong where year(ngayLap) =?");
				stmt.setString(1, date);
				rs = stmt.executeQuery();
				while (rs.next()) {
					String maHD = rs.getString("maHopDong");
		            String tenKH = rs.getString("TenKhachHang");
		            String ngayLap = rs.getString("NgayLap");
		            String ngayGiao1 = rs.getString("NgayGiao");
		            int soLuong = rs.getInt("SoLuong");
		            double donGia = rs.getDouble("DonGia");

		            // Tạo các đối tượng SanPham và NhanVien và gán thông tin từ cơ sở dữ liệu
		            SanPham maSP = new SanPham(rs.getString("maSanPham"));
		            String tenSP = rs.getString("tenSanPham");
		            NhanVien maNV = new NhanVien(rs.getString("maNhanVien"));
		            String tenNV = rs.getString("tenNhanVien");

		            HopDong hd = new HopDong(maHD, maSP, tenSP, tenKH, maNV, tenNV, ngayLap, ngayGiao1, soLuong, donGia);
		            dsnv.add(hd);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dsnv;
		}
		public List<HopDong> timKiem(String month, String year, String maHD) {
			Conection_DB.getInstance();
			Connection con = Conection_DB.getCon();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			List<HopDong> dsnv = new ArrayList<>();

			try {
				stmt = con.prepareStatement("select * from HopDong where month(ngayLap) =? AND YEAR(NgayLap) = ? AND maHopDong = ?");
				stmt.setString(1, month);
				stmt.setString(2, year);
				stmt.setString(3, maHD);
				rs = stmt.executeQuery();
				while (rs.next()) {
					String maHD1 = rs.getString("maHopDong");
		            String tenKH = rs.getString("TenKhachHang");
		            String ngayLap = rs.getString("NgayLap");
		            String ngayGiao1 = rs.getString("NgayGiao");
		            int soLuong = rs.getInt("SoLuong");
		            double donGia = rs.getDouble("DonGia");

		            // Tạo các đối tượng SanPham và NhanVien và gán thông tin từ cơ sở dữ liệu
		            SanPham maSP = new SanPham(rs.getString("maSanPham"));
		            String tenSP = rs.getString("tenSanPham");
		            NhanVien maNV = new NhanVien(rs.getString("maNhanVien"));
		            String tenNV = rs.getString("tenNhanVien");

		            HopDong hd = new HopDong(maHD1, maSP, tenSP, tenKH, maNV, tenNV, ngayLap, ngayGiao1, soLuong, donGia);
		            dsnv.add(hd);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dsnv;
		}
		public List<HopDong> timKiemMonthYear(String month, String year) {
			Conection_DB.getInstance();
			Connection con = Conection_DB.getCon();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			List<HopDong> dsnv = new ArrayList<>();

			try {
				stmt = con.prepareStatement("select * from HopDong where month(ngayLap) =? AND YEAR(NgayLap) = ? ");
				stmt.setString(1, month);
				stmt.setString(2, year);
				
				rs = stmt.executeQuery();
				while (rs.next()) {
					String maHD1 = rs.getString("maHopDong");
		            String tenKH = rs.getString("TenKhachHang");
		            String ngayLap = rs.getString("NgayLap");
		            String ngayGiao1 = rs.getString("NgayGiao");
		            int soLuong = rs.getInt("SoLuong");
		            double donGia = rs.getDouble("DonGia");

		            // Tạo các đối tượng SanPham và NhanVien và gán thông tin từ cơ sở dữ liệu
		            SanPham maSP = new SanPham(rs.getString("maSanPham"));
		            String tenSP = rs.getString("tenSanPham");
		            NhanVien maNV = new NhanVien(rs.getString("maNhanVien"));
		            String tenNV = rs.getString("tenNhanVien");

		            HopDong hd = new HopDong(maHD1, maSP, tenSP, tenKH, maNV, tenNV, ngayLap, ngayGiao1, soLuong, donGia);
		            dsnv.add(hd);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dsnv;
		}
		public List<HopDong> timKiemMonthMaHD(String month, String maHD) {
			Conection_DB.getInstance();
			Connection con = Conection_DB.getCon();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			List<HopDong> dsnv = new ArrayList<>();

			try {
				stmt = con.prepareStatement("select * from HopDong where month(ngayLap) =? AND maHopDong = ?");
				stmt.setString(1, month);
			
				stmt.setString(2, maHD);
				rs = stmt.executeQuery();
				while (rs.next()) {
					String maHD1 = rs.getString("maHopDong");
		            String tenKH = rs.getString("TenKhachHang");
		            String ngayLap = rs.getString("NgayLap");
		            String ngayGiao1 = rs.getString("NgayGiao");
		            int soLuong = rs.getInt("SoLuong");
		            double donGia = rs.getDouble("DonGia");

		            // Tạo các đối tượng SanPham và NhanVien và gán thông tin từ cơ sở dữ liệu
		            SanPham maSP = new SanPham(rs.getString("maSanPham"));
		            String tenSP = rs.getString("tenSanPham");
		            NhanVien maNV = new NhanVien(rs.getString("maNhanVien"));
		            String tenNV = rs.getString("tenNhanVien");

		            HopDong hd = new HopDong(maHD1, maSP, tenSP, tenKH, maNV, tenNV, ngayLap, ngayGiao1, soLuong, donGia);
		            dsnv.add(hd);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dsnv;
		}
		public List<HopDong> timKiemYearMaHD(String year, String maHD) {
			Conection_DB.getInstance();
			Connection con = Conection_DB.getCon();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			List<HopDong> dsnv = new ArrayList<>();

			try {
				stmt = con.prepareStatement("select * from HopDong where YEAR(NgayLap) = ? AND maHopDong = ?");
				
				stmt.setString(1, year);
				stmt.setString(2, maHD);
				rs = stmt.executeQuery();
				while (rs.next()) {
					String maHD1 = rs.getString("maHopDong");
		            String tenKH = rs.getString("TenKhachHang");
		            String ngayLap = rs.getString("NgayLap");
		            String ngayGiao1 = rs.getString("NgayGiao");
		            int soLuong = rs.getInt("SoLuong");
		            double donGia = rs.getDouble("DonGia");

		            // Tạo các đối tượng SanPham và NhanVien và gán thông tin từ cơ sở dữ liệu
		            SanPham maSP = new SanPham(rs.getString("maSanPham"));
		            String tenSP = rs.getString("tenSanPham");
		            NhanVien maNV = new NhanVien(rs.getString("maNhanVien"));
		            String tenNV = rs.getString("tenNhanVien");

		            HopDong hd = new HopDong(maHD1, maSP, tenSP, tenKH, maNV, tenNV, ngayLap, ngayGiao1, soLuong, donGia);
		            dsnv.add(hd);

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
			String query = "SELECT MAX(CAST(SUBSTRING(MaHopDong, 3, LEN(MaNhanVien) - 2) AS INT)) FROM hopdong";
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
