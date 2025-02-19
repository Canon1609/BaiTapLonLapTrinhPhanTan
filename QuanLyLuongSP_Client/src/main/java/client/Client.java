package client;

import dao.ChamCongCongNhanDao;
import dao.ChamCongNhanVienDao;
import dao.CongDoanDao;
import dao.CongNhanDao;
import dao.HopDongDAO;
import dao.LuongNhanVienDao;
import dao.LuonngCongNhanDao;
import dao.NhanVienDao;
import dao.PhanCongDao;
import dao.SanPhamDAO;
import dao.ThongKe_CN_Dao;
import dao.ThongKe_HD_Dao;
import dao.ThongKe_NV_Dao;
import dao.ThongKe_SP_Dao;


public class Client {
	private static final String URL = "rmi://TRANQUOCANH:9996/";
	private static Client instance;
	private ChamCongCongNhanDao chamCongCongNhanDao;
	private ChamCongNhanVienDao chamCongNhanVienDao;
	private CongDoanDao congDoanDao;
	private CongNhanDao congNhanDao;
	private HopDongDAO hopDongDAO;
	private LuongNhanVienDao luongNhanVienDao;
	private LuonngCongNhanDao luongCongNhanDao;
	private NhanVienDao nhanVienDao;
	private PhanCongDao phanCongDao;
	private SanPhamDAO sanPhamDAO;
	private ThongKe_CN_Dao thongKe_CN_Dao;
	private ThongKe_HD_Dao thongKe_HD_Dao;
	private ThongKe_NV_Dao thongKe_NV_Dao;
	private ThongKe_SP_Dao thongKe_SP_Dao;

	public Client() {
		try {
			chamCongCongNhanDao = (ChamCongCongNhanDao) java.rmi.Naming.lookup(URL + "chamCongCongNhanDao");
			chamCongNhanVienDao = (ChamCongNhanVienDao) java.rmi.Naming.lookup(URL + "chamCongNhanVienDao");
			congDoanDao = (CongDoanDao) java.rmi.Naming.lookup(URL + "congDoanDao");
			congNhanDao = (CongNhanDao) java.rmi.Naming.lookup(URL + "congNhanDao");
			hopDongDAO = (HopDongDAO) java.rmi.Naming.lookup(URL + "hopDongDAO");
			luongNhanVienDao = (LuongNhanVienDao) java.rmi.Naming.lookup(URL + "luongNhanVienDao");
			luongCongNhanDao = (LuonngCongNhanDao) java.rmi.Naming.lookup(URL + "luonngCongNhanDao");
			nhanVienDao = (NhanVienDao) java.rmi.Naming.lookup(URL + "nhanVienDao");
			phanCongDao = (PhanCongDao) java.rmi.Naming.lookup(URL + "phanCongDao");
			sanPhamDAO = (SanPhamDAO) java.rmi.Naming.lookup(URL + "sanPhamDAO");
			thongKe_CN_Dao = (ThongKe_CN_Dao) java.rmi.Naming.lookup(URL + "thongKe_CN_Dao");
			thongKe_HD_Dao = (ThongKe_HD_Dao) java.rmi.Naming.lookup(URL + "thongKe_HD_Dao");
			thongKe_NV_Dao = (ThongKe_NV_Dao) java.rmi.Naming.lookup(URL + "thongKe_NV_Dao");
			thongKe_SP_Dao = (ThongKe_SP_Dao) java.rmi.Naming.lookup(URL + "thongKe_SP_Dao");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Client getInstance() {
		if (instance == null) {
			instance = new Client();
		}
		return instance;
	}

}

/**
 * public static void main(String[] args) { final String SERVER_ADDRESS =
 * "localhost"; // Đổi thành địa chỉ IP thực của máy chủ final int PORT = 9999;
 * 
 * try (Socket socket = new Socket(SERVER_ADDRESS, PORT); PrintWriter out = new
 * PrintWriter(socket.getOutputStream(), true); BufferedReader in = new
 * BufferedReader(new InputStreamReader(socket.getInputStream()))) {
 * 
 * if (socket.isConnected()) { System.out.println("Connected to server: " +
 * socket);
 * 
 * // Gửi yêu cầu hiển thị giao diện cho server out.println("SHOW_INTERFACE");
 * 
 * // Đọc phản hồi từ server String response = in.readLine(); if
 * (response.equals("DISPLAY_INTERFACE")) { System.out.println("Server requested
 * to display the interface."); // Hiển thị giao diện ở đây // Ví dụ:
 * Form_DangNhap formDangNhap = new Form_DangNhap();
 * formDangNhap.setLocationRelativeTo(null); formDangNhap.setVisible(true); }
 * else { System.out.println("Unexpected response from server: " + response); }
 * }
 * 
 * } catch (IOException e) { e.printStackTrace(); } }
 */