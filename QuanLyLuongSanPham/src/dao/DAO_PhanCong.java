package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.Conection_DB;
import entity.CongDoan;
import entity.CongNhan;
import entity.NhanVien;
import entity.PhanCong;

public class DAO_PhanCong {
	public DAO_PhanCong() {
		// TODO Auto-generated constructor stub
	}
	public static ArrayList<PhanCong> getAlltbPhanCong(){
		ArrayList<PhanCong> dspc = new ArrayList<PhanCong>();
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		String sql = "select * from PhanCong";

		Statement statement;
		
		try {
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maPC = rs.getString(1);
				String maCN = rs.getString(2);
				String tenCN = rs.getString(3);
				String maCD = rs.getString(4);
				String tenCD = rs.getString(5);
				int slCanLam = rs.getInt(6);
				CongNhan cn = new CongNhan(maCN);
				CongDoan cd = new CongDoan(maCD);
				PhanCong pc = new PhanCong(maPC, cn, tenCN, cd, tenCD, slCanLam);
				dspc.add(pc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dspc;
	}
	public boolean create(PhanCong pc) {
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		PreparedStatement stmt = null;
		int n = 0;
		
		try {
			stmt = con.prepareStatement("insert into PhanCong values(?,?,?,?,?,?)");
			stmt.setString(1, pc.getMaPhanCong());
			stmt.setString(2, pc.getCongNhan().getMaCongNhan());
			stmt.setString(3, pc.getTenCongNhan());
			stmt.setString(4, pc.getCongDoan().getMaCongDoan());
			stmt.setString(5, pc.getTenCongDoan());
			stmt.setInt(6, pc.getsLSPCanLam());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n>0;
	}
	public boolean deletePC(String maPC) {
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		try {
			PreparedStatement stmt = con.prepareStatement("delete from PhanCong where MAPHANCONG = ?");
			stmt.setString(1, maPC);
			int n = stmt.executeUpdate();
			if (n > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	public boolean update(PhanCong pc) {
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		PreparedStatement stmt = null;
		int n = 0;

		try {
			stmt = con.prepareStatement(
					"UPDATE PhanCong SET maCongNhan=?, tenCongNhan=?, maCongDoan=?, tenCongDoan=?, SoLuongSanPhamCanLam=? WHERE maPhanCong=?");
			stmt.setString(1, pc.getCongNhan().getMaCongNhan());
			stmt.setString(2, pc.getTenCongNhan());
			stmt.setString(3, pc.getCongDoan().getMaCongDoan());
			stmt.setString(4, pc.getTenCongDoan());
			stmt.setInt(5, pc.getsLSPCanLam());
			stmt.setString(6, pc.getMaPhanCong());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	public int getPCNumber() {
		Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			// Truy vấn để lấy ra mã nhân viên lớn nhất
			String query = "SELECT MAX(CAST(SUBSTRING(MaPhanCong, 3, LEN(MaPhanCong) - 2) AS INT)) FROM phanCong";
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
	public static String getTenCongNhan(String maCongNhan) {
        String tenCongNhan = "";

        Connection con = Conection_DB.getCon();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT hoten FROM CongNhan WHERE maCongNhan = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, maCongNhan);

            rs = stmt.executeQuery();

            if (rs.next()) {
                tenCongNhan = rs.getString("hoten");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tenCongNhan;
    }

    public static String getTenCongDoan(String maCongDoan) {
        String tenCongDoan = "";

        Connection con = Conection_DB.getCon();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT tenCongDoan FROM CongDoan WHERE maCongDoan = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, maCongDoan);

            rs = stmt.executeQuery();

            if (rs.next()) {
                tenCongDoan = rs.getString("tenCongDoan");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tenCongDoan;
    }
    public static ArrayList<String> getAllMaCongNhan() {
        ArrayList<String> maCongNhanList = new ArrayList<>();

        Connection con = Conection_DB.getCon();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT maCongNhan FROM CongNhan";
            stmt = con.prepareStatement(sql);

            rs = stmt.executeQuery();

            while (rs.next()) {
                maCongNhanList.add(rs.getString("maCongNhan"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return maCongNhanList;
    }

    public static ArrayList<String> getAllMaCongDoan() {
        ArrayList<String> maCongDoanList = new ArrayList<>();

        Connection con = Conection_DB.getCon();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT maCongDoan FROM CongDoan";
            stmt = con.prepareStatement(sql);

            rs = stmt.executeQuery();

            while (rs.next()) {
                maCongDoanList.add(rs.getString("maCongDoan"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return maCongDoanList;
    }
    public int getSoLuongDaPhanCong(String maCongDoan) {
        int soLuongDaPhanCong = 0;

        Connection con = Conection_DB.getCon();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Truy vấn để lấy ra tổng số lượng đã phân công cho công đoàn có mã là maCongDoan
            String sql = "SELECT SUM(SoLuongSanPhamCanLam) FROM PhanCong WHERE maCongDoan = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, maCongDoan);

            rs = stmt.executeQuery();

            if (rs.next()) {
                soLuongDaPhanCong = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return soLuongDaPhanCong;
    }
    // Phương thức trả về tổng số lượng sản phẩm được phân công theo mã nhân viên và mã công đoạn
    public static int getTongSoLuongSanPhamDaPhanCong(String maCongNhan, String maCongDoan) {
    	Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int tongSoLuong = 0;

        try {
            String query = "SELECT SUM(SoLuongSanPhamCanLam) AS TongSoLuong FROM PhanCong WHERE maCongNhan = ? AND maCongDoan = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, maCongNhan);
            ps.setString(2, maCongDoan);
            rs = ps.executeQuery();

            if (rs.next()) {
                tongSoLuong = rs.getInt("TongSoLuong");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        return tongSoLuong;
    }
 // Phương thức trả về mã công đoạn đã làm theo mã công nhân
    public static String getMaCongDoanDaLamTheoMaCongNhan(String maCongNhan) {
    	Conection_DB.getInstance();
		Connection con = Conection_DB.getCon();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String maCongDoan = null;

        try {

            String query = "SELECT DISTINCT maCongDoan FROM PhanCong WHERE maCongNhan = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, maCongNhan);
            rs = ps.executeQuery();

            if (rs.next()) {
                maCongDoan = rs.getString("maCongDoan");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        return maCongDoan;
    }
   

//
}
