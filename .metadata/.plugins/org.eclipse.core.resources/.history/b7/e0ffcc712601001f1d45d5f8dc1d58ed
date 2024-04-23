package gui_Form;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.Box;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;

public class Form_CN_TinhLuong extends JPanel {
	private JTextField txtMaCongNhan;
	private JTextField txtMaLuong;
	private JTextField txtThucLanh;
	private JTable table;
	private JTable table_1;
	private JComboBox cmbThang;
	private JComboBox cmbNam;
	private JTable tblDSCongNhan;
	private JTable tblLuongCN;
	private DefaultTableModel tableModelTinhLuong;

	private Form_CN_ChamCong chamCongCN;
	private DefaultTableModel tableModel;

	private JTextField txtTenCongNhan;
	private double phuCap;
	private int tongNgayCong;
	private double tbLuongCa;
	private double thucNhan;


	/**
	 * Create the panel.
	 */
	public Form_CN_TinhLuong() {
		setLayout(new BorderLayout(0, 0));

		JPanel pnNorth = new JPanel();
		add(pnNorth, BorderLayout.NORTH);

		JLabel lblLuongCongNhan = new JLabel("LƯƠNG CÔNG NHÂN");
		lblLuongCongNhan.setForeground(Color.RED);
		lblLuongCongNhan.setFont(new Font("Arial", Font.BOLD, 16));
		pnNorth.add(lblLuongCongNhan);

		JPanel pnCenter = new JPanel();
		pnCenter.setPreferredSize(new Dimension(1800, 360));
		add(pnCenter, BorderLayout.CENTER);

		JPanel pnNhap = new JPanel();
		pnNhap.setPreferredSize(new Dimension(1800, 300));
		pnNhap.setBorder(new TitledBorder(null, "Th\u00F4ng Tin T\u00EDnh L\u01B0\u01A1ng", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pnCenter.add(pnNhap);

		Box box1 = Box.createVerticalBox();
		pnNhap.add(box1);

		Box boxMaCongNhan = Box.createHorizontalBox();
		box1.add(boxMaCongNhan);

		JLabel lblMaCongNhan = new JLabel("Mã Công Nhân :");
		lblMaCongNhan.setFont(new Font("Arial", Font.BOLD, 14));
		boxMaCongNhan.add(lblMaCongNhan);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		boxMaCongNhan.add(horizontalStrut);

		txtMaCongNhan = new JTextField();
		txtMaCongNhan.setPreferredSize(new Dimension(7, 30));
		txtMaCongNhan.setEditable(false);
		boxMaCongNhan.add(txtMaCongNhan);
		txtMaCongNhan.setColumns(15);

		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setPreferredSize(new Dimension(0, 40));
		box1.add(verticalStrut);

		Box boxMaLuong = Box.createHorizontalBox();
		box1.add(boxMaLuong);

		JLabel lblMaLuong = new JLabel("Mã Lương :");
		lblMaLuong.setFont(new Font("Arial", Font.BOLD, 14));
		boxMaLuong.add(lblMaLuong);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setPreferredSize(new Dimension(50, 0));
		boxMaLuong.add(horizontalStrut_1);

		txtMaLuong = new JTextField();
		txtMaLuong.setEditable(false);
		txtMaLuong.setPreferredSize(new Dimension(7, 30));
		boxMaLuong.add(txtMaLuong);
		txtMaLuong.setColumns(10);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalStrut_1.setPreferredSize(new Dimension(0, 40));
		box1.add(verticalStrut_1);

		Box boxThucLanh = Box.createHorizontalBox();
		box1.add(boxThucLanh);

		JLabel lblThucLanh = new JLabel("Thực Lãnh :");
		lblThucLanh.setFont(new Font("Arial", Font.BOLD, 14));
		boxThucLanh.add(lblThucLanh);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		horizontalStrut_2.setPreferredSize(new Dimension(48, 0));
		boxThucLanh.add(horizontalStrut_2);

		txtThucLanh = new JTextField();
		txtThucLanh.setEditable(false);
		txtThucLanh.setPreferredSize(new Dimension(7, 30));
		boxThucLanh.add(txtThucLanh);
		txtThucLanh.setColumns(10);

		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		horizontalStrut_3.setPreferredSize(new Dimension(40, 0));
		pnNhap.add(horizontalStrut_3);

		Box box2 = Box.createVerticalBox();
		pnNhap.add(box2);

		Box boxCongNhan = Box.createHorizontalBox();
		box2.add(boxCongNhan);

		JLabel lblCongNhan = new JLabel("Tên CN :");
		lblCongNhan.setFont(new Font("Arial", Font.BOLD, 14));
		boxCongNhan.add(lblCongNhan);

		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		boxCongNhan.add(horizontalStrut_7);

		txtTenCongNhan = new JTextField();
		txtTenCongNhan.setPreferredSize(new Dimension(140, 30));
		txtTenCongNhan.setEditable(false);
		boxCongNhan.add(txtTenCongNhan);

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		verticalStrut_3.setPreferredSize(new Dimension(0, 40));
		box2.add(verticalStrut_3);

		Box boxThang = Box.createHorizontalBox();
		box2.add(boxThang);

		JLabel lblThang = new JLabel("Tháng :");
		lblThang.setFont(new Font("Arial", Font.BOLD, 14));
		boxThang.add(lblThang);

		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		horizontalStrut_5.setPreferredSize(new Dimension(52, 0));
		boxThang.add(horizontalStrut_5);

		cmbThang = new JComboBox();
		cmbThang.setPreferredSize(new Dimension(29, 30));
		for (int thang = 1; thang <= 12; thang++) {
			cmbThang.addItem(thang);
		}
		boxThang.add(cmbThang);

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		verticalStrut_2.setPreferredSize(new Dimension(0, 40));
		box2.add(verticalStrut_2);

		Box boxNam = Box.createHorizontalBox();
		box2.add(boxNam);

		JLabel lblNam = new JLabel("Năm :");
		lblNam.setFont(new Font("Arial", Font.BOLD, 14));
		boxNam.add(lblNam);

		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		horizontalStrut_6.setPreferredSize(new Dimension(63, 0));
		boxNam.add(horizontalStrut_6);

		cmbNam = new JComboBox();
		cmbNam.setPreferredSize(new Dimension(29, 30));
		// Lấy năm hiện tại
		int namHienTai = Calendar.getInstance().get(Calendar.YEAR);

		// Thêm các năm từ 2020 đến năm hiện tại vào JComboBox
		for (int nam = 2023; nam <= namHienTai; nam++) {
			cmbNam.addItem(nam);
		}
		boxNam.add(cmbNam);

		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		horizontalStrut_4.setPreferredSize(new Dimension(60, 0));
		pnNhap.add(horizontalStrut_4);

		JPanel pnDanhSachCongNhan = new JPanel();
		pnDanhSachCongNhan.setBorder(new TitledBorder(null, "Danh S\u00E1ch C\u00F4ng Nh\u00E2n", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pnNhap.add(pnDanhSachCongNhan);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(850, 200));
		pnDanhSachCongNhan.add(scrollPane);

		tblDSCongNhan = new JTable();
		scrollPane.setViewportView(tblDSCongNhan);
		tblDSCongNhan
				.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Mã Công Nhân", "Họ Tên", "CMND/CCCD",
						"Ngày Sinh", "Giới Tính", "Địa Chỉ", "Số Điện Thoại", "Phụ Cấp", "Tay Nghề", "Phòng Ban" }) {
					Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class,
							String.class, String.class, String.class, Double.class, String.class, String.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
		tableModel = (DefaultTableModel) tblDSCongNhan.getModel();
		String[] columnNames = { "Mã Công Nhân", "Họ Tên", "CMND/CCCD", "Ngày Sinh", "Giới Tính", "Địa Chỉ",
				"Số Điện Thoại", "Phụ Cấp", "Tay Nghề", "Phòng Ban" };
		// khởi tạo kết nối đến CSDL
//		try {
//			Conection_DB.getInstance().connect();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		DocDLVaoTable();
		tblDSCongNhan.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tblDSCongNhan.getSelectedRow();
				if (row >= 0) {
					String maCN = (String) tblDSCongNhan.getValueAt(row, 0);
					String tenCN = (String) tblDSCongNhan.getValueAt(row, 1);
					txtMaCongNhan.setText(maCN);
					txtTenCongNhan.setText(tenCN);
					phuCap = (Double) tblDSCongNhan.getValueAt(row, 7);
				}
			}
		});
		JPanel pnChucNang = new JPanel();
		pnChucNang.setPreferredSize(new Dimension(1200, 50));
		pnCenter.add(pnChucNang);

		JButton btnTinhLuong = new JButton("Tính Lương");
		btnTinhLuong.setIcon(new ImageIcon(Form_CN_TinhLuong.class.getResource("/img/salary.png")));
		btnTinhLuong.setFont(new Font("Arial", Font.BOLD, 14));
		btnTinhLuong.setBackground(Color.ORANGE);
		pnChucNang.add(btnTinhLuong);

		JButton btnXoaLuong = new JButton("Xóa Lương");
		btnXoaLuong.setIcon(new ImageIcon(Form_CN_TinhLuong.class.getResource("/img/delete.png")));
		btnXoaLuong.setFont(new Font("Arial", Font.BOLD, 14));
		btnXoaLuong.setBackground(Color.YELLOW);
		pnChucNang.add(btnXoaLuong);

		JButton btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setIcon(new ImageIcon(Form_CN_TinhLuong.class.getResource("/img/reload.png")));
		btnLamMoi.setFont(new Font("Arial", Font.BOLD, 14));
		btnLamMoi.setBackground(Color.CYAN);
		pnChucNang.add(btnLamMoi);

		JButton btnXuatExcel = new JButton("Xuất Excel");
		btnXuatExcel.setIcon(new ImageIcon(Form_CN_TinhLuong.class.getResource("/img/excel.png")));
		btnXuatExcel.setFont(new Font("Arial", Font.BOLD, 14));
		btnXuatExcel.setBackground(Color.GREEN);
		pnChucNang.add(btnXuatExcel);

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon(Form_CN_TinhLuong.class.getResource("/img/exit.png")));
		btnThoat.setFont(new Font("Arial", Font.BOLD, 14));
		btnThoat.setBackground(Color.RED);
		pnChucNang.add(btnThoat);

		JPanel pnSouth = new JPanel();
		pnSouth.setPreferredSize(new Dimension(1200, 280));
		pnSouth.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh S\u00E1ch L\u01B0\u01A1ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		add(pnSouth, BorderLayout.SOUTH);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setPreferredSize(new Dimension(1100, 250));
		pnSouth.add(scrollPane_1);

		tblLuongCN = new JTable();
		scrollPane_1.setViewportView(tblLuongCN);
		tblLuongCN.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Mã Lương", "Mã Nhân Viên",
				"Họ Tên", "Số Ngày Đi Làm", "Tháng Nhận", "Năm Nhận", "Thực Nhận" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, Integer.class, Integer.class,
					Integer.class, Double.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableModelTinhLuong = (DefaultTableModel) tblLuongCN.getModel();
		String[] columnNames1 = { "Mã Lương", "Mã Nhân Viên", "Họ Tên", "Số Ngày Đi Làm", "Tháng Nhận", "Năm Nhận",
				"Thực Nhận" };
		tableModelTinhLuong.setColumnIdentifiers(columnNames1);
//		docDLLuongCN();
//		congNhan_dao = new DAO_CongNhan();
//		LuongCN_dao = new DAO_LuongCongNhan();
//		chamCongCN = new Form_CN_ChamCong();
//
//		cmbThang.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				tongNgayCong = chamCongCN.tinhTongNgayCong(txtMaCongNhan.getText().trim(),
//						Integer.parseInt(cmbThang.getSelectedItem().toString()));
//				tbLuongCa = chamCongCN.tinhTrungBinhLuongCa(txtMaCongNhan.getText().trim(),
//						Integer.parseInt(cmbThang.getSelectedItem().toString()));
//				String maCongDoanTheoCongNhan = DAO_PhanCong
//						.getMaCongDoanDaLamTheoMaCongNhan(txtMaCongNhan.getText().trim());
//				double giaCongDoanTheoMaCongDoan = DAO_CongDoan.getGiaCongDoanByMaCongDoan(maCongDoanTheoCongNhan);
//				int tongSPCuaCongNhanTheoMaCongDoan = DAO_PhanCong
//						.getTongSoLuongSanPhamDaPhanCong(txtMaCongNhan.getText().trim(), maCongDoanTheoCongNhan);
//
//				thucNhan = (((giaCongDoanTheoMaCongDoan * tongSPCuaCongNhanTheoMaCongDoan * tbLuongCa) / 26)
//						* tongNgayCong) + phuCap;
//				String thucNhanStr = Double.toString(thucNhan);
//				txtThucLanh.setText(thucNhanStr);
//			}
//		});
//
//		// String maCongDoanCanTim = "SP01CD01";
//		// double giaCong = DAO_CongDoan.getGiaCongDoanByMaCongDoan(maCongDoanCanTim);
//		// System.out.println("Giá công đoạn là: " + giaCong);
//		// String maCongNhan = "CN001"; // Thay thế bằng mã nhân viên thực tế
//		// String maCongDoan = "CD001"; // Thay thế bằng mã công đoạn thực tế
//
//		// int tongSoLuong = DAO_PhanCong.getTongSoLuongSanPhamDaPhanCong(maCongNhan,
//		// maCongDoan);
//		// System.out.println("Tổng số lượng sản phẩm đã phân công: " + tongSoLuong);
//		// String maCongNhan = "CN001"; // Thay thế bằng mã nhân viên thực tế
//
//		// String maCongDoan =
//		// DAO_PhanCong.getMaCongDoanDaLamTheoMaCongNhan(maCongNhan);
//		// System.out.println("Mã công đoạn đã làm: " + maCongDoan);
//
//		// THOÁT
//		btnThoat.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
//			}
//		});
//		btnTinhLuong.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if(tblDSCongNhan.getSelectedRow()<0) {
//					JOptionPane.showMessageDialog(null, "Chua chon cong nhan de tinh luong");
//					return;
//				}
//				if(valid()) {
//					int maxLuongNumber = LuongCN_dao.getMaxMaLuongCN();
//					int nextLuongNumber = maxLuongNumber+1;
//					String maLuong = String.format("L%02d", nextLuongNumber);
//					String maCN = txtMaCongNhan.getText().trim();
//					String tenCN = txtTenCongNhan.getText();
//					int ngayDiLam = tongNgayCong;
//					int thangNhan = Integer.parseInt(cmbThang.getSelectedItem().toString());
//					int namNhan = Integer.parseInt(cmbNam.getSelectedItem().toString());
//					double thucNhan = Double.parseDouble(txtThucLanh.getText().trim());
//					CongNhan cn = new CongNhan(maCN);
//					LuongCongNhan luongCN = new LuongCongNhan(maLuong, cn, tenCN, ngayDiLam, thangNhan, namNhan, thucNhan);
//					LuongCN_dao.create(luongCN);
//					tableModelTinhLuong.addRow(new Object[] { luongCN.getMaLuongCongNhan(),
//							luongCN.getCongNhan().getMaCongNhan(), luongCN.getTenCongNhan(), luongCN.getSoNgayDiLam(),
//							luongCN.getThangNhan(), luongCN.getNamNhan(), luongCN.getThucNhan() });
//					txtMaLuong.setText("");
//					txtMaCongNhan.setText("");
//					txtTenCongNhan.setText("");
//					txtThucLanh.setText("");
//					cmbNam.setSelectedIndex(0);
//					cmbThang.setSelectedIndex(0);
//					JOptionPane.showMessageDialog(null, "Tính lương thành công");
//				}else {
//					JOptionPane.showMessageDialog(null, "Tính lương không thành công");
//				}
//			}
//		});
//		btnXoaLuong.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				int row = tblLuongCN.getSelectedRow();
//				if (row < 0) {
//					JOptionPane.showMessageDialog(null, "Chọn Lương cần xóa");
//				} else {
//					String maLuongCN = (String) tblLuongCN.getValueAt(row, 0);
//					LuongCN_dao.delete(maLuongCN);
//					tableModelTinhLuong.removeRow(row);
//					JOptionPane.showMessageDialog(null, "Xóa Lương thành công");
//				}
//
//			}
//		});
//		btnLamMoi.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				txtMaLuong.setText("");
//				txtMaCongNhan.setText("");
//				txtTenCongNhan.setText("");
//				txtThucLanh.setText("");
//				cmbNam.setSelectedIndex(0);
//				cmbThang.setSelectedIndex(0);
//
//			}
//		});
//		btnThoat.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
//			}
//		});
//	}
//
//	public void docDLLuongCN() {
//		List<LuongCongNhan> list = DAO_LuongCongNhan.getAlltbLuongCuaCongNhan();
//		for (LuongCongNhan luongCN : list) {
//			tableModelTinhLuong.addRow(new Object[] { luongCN.getMaLuongCongNhan(),
//					luongCN.getCongNhan().getMaCongNhan(), luongCN.getTenCongNhan(), luongCN.getSoNgayDiLam(),
//					luongCN.getThangNhan(), luongCN.getNamNhan(), luongCN.getThucNhan() });
//		}
//	}
//
//	public void DocDLVaoTable() {
//		List<CongNhan> list = DAO_CongNhan.getAlltbCongNhan();
//		for (CongNhan cn : list) {
//			tableModel.addRow(new Object[] { cn.getMaCongNhan(), cn.getHoTen(), cn.getcCCD(), cn.getNgaySinh(),
//					cn.getGioiTinh(), cn.getDiaChi(), cn.getSoDienThoai(), cn.getPhuCap(), cn.getTrinhDoTayNghe(),
//					cn.getPhongBan() });
//		}
//	}
//	public boolean valid() {
//		if(tblDSCongNhan.getSelectedRow()<0) {
//			JOptionPane.showMessageDialog(null, "Cần chọn công nhân để tính lương");
//			return false;
//		}
//		if(txtMaCongNhan.getText().trim().equals("")) {
//			JOptionPane.showMessageDialog(null, "Chua chon cong nhan de tinh luong");
//			return false;
//		}
//		return true;
	}

}
