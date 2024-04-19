package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conection_DB {
	// khởi tạo biến connection để lưu trữ đối tượng kết nối JDBC
	public static Connection con = null;
	// khai báo biến instance để nhằm mục đích kết nối đến CSDL
	public static Conection_DB instance = new Conection_DB();

	public static Connection getCon() {
		return con;
	}

	public static Conection_DB getInstance() {
		return instance;
	}


	public void connect() throws SQLException {
		String url = "jdbc:sqlserver://localhost:1433;databasename=QuanLyLuongSanPham";
		String user = "sa";
		String password = "sapassword";
		con = DriverManager.getConnection(url, user, password);
	}

	// Ngắt kết nối, giải phóng tài nguyên
	public void disconnect() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}