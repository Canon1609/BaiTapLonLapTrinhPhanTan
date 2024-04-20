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
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.Box;
import javax.swing.JCheckBox;
import java.awt.Component;
import com.toedter.calendar.JDateChooser;



import javax.swing.JTextField;
import javax.swing.JComboBox;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;

public class Form_NV_ChamCong extends JPanel {
	private JTextField txtNhanVien;
	private JTextField txtGioLam;
	private JTextField txtPhongBan;
	private JTextField txtLuongCa;
	private JTable tblDanhSachNV;
	private JTable tblDanhSachChamCong;
	private DefaultTableModel tableModel;
	private DefaultTableModel tableModelDSChamCong;
	private JDateChooser dateChooser;

	/**
	 * Create the panel.
	 */
	public Form_NV_ChamCong() {
		setLayout(new BorderLayout(0, 0));

		JPanel pnNorth = new JPanel();
		add(pnNorth, BorderLayout.NORTH);

		JLabel lblChamCongNV = new JLabel("CHẤM CÔNG NHÂN VIÊN HÀNH CHÍNH");
		lblChamCongNV.setForeground(Color.RED);
		lblChamCongNV.setFont(new Font("Arial", Font.BOLD, 16));
		pnNorth.add(lblChamCongNV);

		JPanel pnCenter = new JPanel();
		pnCenter.setPreferredSize(new Dimension(1800, 360));
		add(pnCenter, BorderLayout.CENTER);

		JPanel pnNhap = new JPanel();
		pnNhap.setBorder(new TitledBorder(null, "Th\u00F4ng tin ch\u1EA5m c\u00F4ng", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pnNhap.setPreferredSize(new Dimension(1800, 300));
		pnCenter.add(pnNhap);

		Box boxTrai1 = Box.createVerticalBox();
		boxTrai1.setPreferredSize(new Dimension(250, 170));
		pnNhap.add(boxTrai1);

		Box boxNgayCham = Box.createHorizontalBox();
		boxTrai1.add(boxNgayCham);

		JLabel lblNgayCham = new JLabel("Ngày Chấm :");
		lblNgayCham.setFont(new Font("Arial", Font.BOLD, 12));
		boxNgayCham.add(lblNgayCham);

		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		horizontalStrut_3.setPreferredSize(new Dimension(5, 0));
		boxNgayCham.add(horizontalStrut_3);

		dateChooser = new JDateChooser();
		dateChooser.setPreferredSize(new Dimension(30, 25));
		boxNgayCham.add(dateChooser);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		boxTrai1.add(verticalStrut_1);

		Box boxNhanVien = Box.createHorizontalBox();
		boxTrai1.add(boxNhanVien);

		JLabel lblNhanVien = new JLabel("Nhân Viên :");
		lblNhanVien.setFont(new Font("Arial", Font.BOLD, 12));
		boxNhanVien.add(lblNhanVien);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		horizontalStrut_2.setPreferredSize(new Dimension(10, 0));
		boxNhanVien.add(horizontalStrut_2);

		txtNhanVien = new JTextField();
		txtNhanVien.setEditable(false);
		txtNhanVien.setFont(new Font("Arial", Font.PLAIN, 12));
		txtNhanVien.setPreferredSize(new Dimension(30, 25));
		boxNhanVien.add(txtNhanVien);
		txtNhanVien.setColumns(10);

		Component verticalStrut = Box.createVerticalStrut(20);
		boxTrai1.add(verticalStrut);

		Box boxGioLam = Box.createHorizontalBox();
		boxTrai1.add(boxGioLam);

		JLabel lblGioLam = new JLabel("Giờ Làm :");
		lblGioLam.setFont(new Font("Arial", Font.BOLD, 12));
		boxGioLam.add(lblGioLam);

		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		boxGioLam.add(horizontalStrut_4);

		txtGioLam = new JTextField();
		txtGioLam.setEditable(false);
		txtGioLam.setFont(new Font("Arial", Font.PLAIN, 12));
		txtGioLam.setPreferredSize(new Dimension(30, 25));
		boxGioLam.add(txtGioLam);
		txtGioLam.setColumns(10);

		Component verticalStrut_4 = Box.createVerticalStrut(20);
		boxTrai1.add(verticalStrut_4);

		Box boxNghiPhep = Box.createHorizontalBox();
		boxTrai1.add(boxNghiPhep);

		JCheckBox chkCoMat = new JCheckBox("Có Mặt");
		chkCoMat.setSelected(true);
		chkCoMat.setFont(new Font("Arial", Font.BOLD, 12));
		boxNghiPhep.add(chkCoMat);

		JCheckBox chkCoPhep = new JCheckBox("Có Phép");
		chkCoPhep.setFont(new Font("Arial", Font.BOLD, 12));
		boxNghiPhep.add(chkCoPhep);
		chkCoMat.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (chkCoMat.isSelected()) {
					chkCoPhep.setSelected(false);
				} else if (chkCoPhep.isSelected()) {
					chkCoMat.setSelected(false);
				}

			}
		});

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		pnNhap.add(horizontalStrut_1);

		Box boxTrai2 = Box.createVerticalBox();
		boxTrai2.setPreferredSize(new Dimension(250, 170));
		pnNhap.add(boxTrai2);

		Box horizontalBox_3 = Box.createHorizontalBox();
		boxTrai2.add(horizontalBox_3);

		JLabel lblCaLam = new JLabel("Ca Làm :");
		lblCaLam.setFont(new Font("Arial", Font.BOLD, 12));
		horizontalBox_3.add(lblCaLam);

		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		horizontalStrut_6.setPreferredSize(new Dimension(25, 0));
		horizontalBox_3.add(horizontalStrut_6);

		JComboBox cmbCaLam = new JComboBox();
		cmbCaLam.setModel(new DefaultComboBoxModel(new String[] { "Ca sáng", "Ca chiều", "Ca tối" ,"Sáng CN"}));
		cmbCaLam.setPreferredSize(new Dimension(30, 25));
		horizontalBox_3.add(cmbCaLam);
		cmbCaLam.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (cmbCaLam.getSelectedItem().toString().equals("Ca sáng")) {
					txtGioLam.setText("7h-11h");
					txtLuongCa.setText("1.0");
				} else if (cmbCaLam.getSelectedItem().toString().equals("Ca chiều")) {
					txtGioLam.setText("13h-17h");
					txtLuongCa.setText("1.0");
				} else if (cmbCaLam.getSelectedItem().toString().equals("Ca tối")){
					txtGioLam.setText("18h-21h");
					txtLuongCa.setText("2.0");
				}else {
					txtGioLam.setText("7h-11h");
					txtLuongCa.setText("2.0");
				}

			}
		});

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		boxTrai2.add(verticalStrut_2);

		Box horizontalBox_4 = Box.createHorizontalBox();
		boxTrai2.add(horizontalBox_4);

		JLabel lblPhongBan = new JLabel("Phòng Ban :");
		lblPhongBan.setFont(new Font("Arial", Font.BOLD, 12));
		horizontalBox_4.add(lblPhongBan);

		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		horizontalStrut_5.setPreferredSize(new Dimension(5, 0));
		horizontalBox_4.add(horizontalStrut_5);

		txtPhongBan = new JTextField();
		txtPhongBan.setEditable(false);
		txtPhongBan.setPreferredSize(new Dimension(30, 25));
		horizontalBox_4.add(txtPhongBan);
		txtPhongBan.setColumns(10);

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		boxTrai2.add(verticalStrut_3);

		Box horizontalBox_5 = Box.createHorizontalBox();
		boxTrai2.add(horizontalBox_5);

		JLabel lblLuongCa = new JLabel("Lương Ca :");
		lblLuongCa.setFont(new Font("Arial", Font.BOLD, 12));
		horizontalBox_5.add(lblLuongCa);

		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		horizontalStrut_7.setPreferredSize(new Dimension(10, 0));
		horizontalBox_5.add(horizontalStrut_7);

		txtLuongCa = new JTextField();
		txtLuongCa.setEditable(false);
		txtLuongCa.setPreferredSize(new Dimension(30, 25));
		horizontalBox_5.add(txtLuongCa);
		txtLuongCa.setColumns(10);

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 40));
		boxTrai2.add(panel);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		pnNhap.add(horizontalStrut);

		JPanel pnDanhSachNhanVien = new JPanel();
		pnDanhSachNhanVien.setPreferredSize(new Dimension(950, 250));
		pnDanhSachNhanVien.setBorder(new TitledBorder(null, "Danh s\u00E1ch nh\u00E2n vi\u00EAn", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pnDanhSachNhanVien.setFont(new Font("Arial", Font.PLAIN, 12));
		pnNhap.add(pnDanhSachNhanVien);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(900, 220));
		pnDanhSachNhanVien.add(scrollPane);

		tblDanhSachNV = new JTable();
		tblDanhSachNV.setFont(new Font("Arial", Font.PLAIN, 10));
		scrollPane.setViewportView(tblDanhSachNV);
		tblDanhSachNV.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 Nh\u00E2n Vi\u00EAn", "H\u1ECD T\u00EAn", "CMND/CCCD", "Ng\u00E0y Sinh",
						"Gi\u1EDBi T\u00EDnh", "\u0110\u1ECBa Ch\u1EC9", "S\u1ED1 \u0110i\u1EC7n Tho\u1EA1i",
						"L\u01B0\u01A1ng", "Ph\u1EE5 C\u1EA5p", "Ph\u00F2ng Ban", "H\u1EC7 S\u1ED1 L\u01B0\u01A1ng" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class,
					String.class, String.class, Double.class, Double.class, String.class, Double.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false, false,
					false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		/* XỬ LÝ TỪ ĐÂY */
		tableModel = (DefaultTableModel) tblDanhSachNV.getModel();
		String[] columnNames = { "Mã Nhân Viên", "Họ Tên", "CMND/CCCD", "Ngày Sinh", "Giới Tính", "Địa Chỉ",
				"Số Điện Thoại", "Lương Cơ bản", "Phụ Cấp", "Phòng Ban", "Hệ Số Lương" };
		tableModel.setColumnIdentifiers(columnNames);
//		// khởi tạo kết nối đến CSDL
//		try {
//			Conection_DB.getInstance().connect();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		nv_dao = new DAO_NhanVien();
//		// Đưa dữ liệu từ bảng lên các trường nhập liệu khi click vào một dòng trong
//		// bảng
//		tblDanhSachNV.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				int row = tblDanhSachNV.getSelectedRow();
//				if (row >= 0) {
//					String ma = (String) tblDanhSachNV.getValueAt(row, 0);
//					String ten = (String) tblDanhSachNV.getValueAt(row, 1);
//					String cmnd = (String) tblDanhSachNV.getValueAt(row, 2);
//					String ngaySinhStr = (String) tblDanhSachNV.getValueAt(row, 3);
//					String gioiTinh = (String) tblDanhSachNV.getValueAt(row, 4);
//					String diaChi = (String) tblDanhSachNV.getValueAt(row, 5);
//					String soDienThoai = (String) tblDanhSachNV.getValueAt(row, 6);
//					String luongCoBan = (String) tblDanhSachNV.getValueAt(row, 7).toString();
//					String phuCap = (String) tblDanhSachNV.getValueAt(row, 8).toString();
//					String phongBan = (String) tblDanhSachNV.getValueAt(row, 9);
//					String heSoLuong = (String) tblDanhSachNV.getValueAt(row, 10).toString();
//
//					txtPhongBan.setText(phongBan);
//					txtNhanVien.setText(ma);
//				}
//			}
//		});
//
//		DocDuLieuDBVaoTable();
		JPanel pnChucNang = new JPanel();
		pnChucNang.setPreferredSize(new Dimension(1000, 50));
		pnCenter.add(pnChucNang);

		JButton btnChamCongNV = new JButton("Chấm Công");
		btnChamCongNV.setBackground(Color.GREEN);
		btnChamCongNV.setIcon(new ImageIcon(Form_NV_ChamCong.class.getResource("/img/themChamCong.png")));
		btnChamCongNV.setFont(new Font("Arial", Font.BOLD, 12));
		pnChucNang.add(btnChamCongNV);

		JButton btnChamCongTC = new JButton("Chấm Công Tất Cả");
		btnChamCongTC.setBackground(Color.yellow);
		btnChamCongTC.setIcon(new ImageIcon(Form_NV_ChamCong.class.getResource("/img/themChamCong.png")));
		btnChamCongTC.setFont(new Font("Arial", Font.BOLD, 12));
		pnChucNang.add(btnChamCongTC);

		JButton btnXoaChamCongNV = new JButton("Xóa Chấm Công");
		btnXoaChamCongNV.setIcon(new ImageIcon(Form_NV_ChamCong.class.getResource("/img/xoaChamCong.png")));
		btnXoaChamCongNV.setBackground(Color.LIGHT_GRAY);
		btnXoaChamCongNV.setFont(new Font("Arial", Font.BOLD, 12));
		pnChucNang.add(btnXoaChamCongNV);

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon(Form_NV_ChamCong.class.getResource("/img/exit.png")));
		btnThoat.setBackground(Color.RED);
		btnThoat.setFont(new Font("Arial", Font.BOLD, 12));
		pnChucNang.add(btnThoat);

		JPanel pnSouth = new JPanel();
		pnSouth.setBorder(new TitledBorder(null, "Danh s\u00E1ch ch\u1EA5m c\u00F4ng", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pnSouth.setPreferredSize(new Dimension(1200, 280));
		add(pnSouth, BorderLayout.SOUTH);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setPreferredSize(new Dimension(1250, 250));
		pnSouth.add(scrollPane_1);

		tblDanhSachChamCong = new JTable();
		scrollPane_1.setViewportView(tblDanhSachChamCong);
		tblDanhSachChamCong.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 C\u00F4ng", "T\u00EAn Nh\u00E2n Vi\u00EAn", "Ng\u00E0y Ch\u1EA5m",
						"Ca L\u00E0m", "Gi\u1EDD L\u00E0m", "Lương ca làm", "Tr\u1EA1ng Th\u00E1i",
						"Ngh\u1EC9 Ph\u00E9p" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class,
					Double.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblDanhSachChamCong.setFont(new Font("Arial", Font.PLAIN, 10));
		tableModelDSChamCong = (DefaultTableModel) tblDanhSachChamCong.getModel();
		String[] columnNames1 = { "Mã Công", "Mã Nhân Viên", "Ngày Chấm", "Ca Làm", "Giờ Làm", "Lương Ca Làm",
				"Trạng Thái", "Nghỉ Phép" };
		tableModelDSChamCong.setColumnIdentifiers(columnNames1);
//		DocDLDanhSachChamCong();
//		dao_congNV = new DAO_ChamCongNhanVIen();
//		// Cham Cong
//		btnChamCongNV.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if(tblDanhSachNV.getSelectedRow()<0) {
//					JOptionPane.showMessageDialog(null, "Chua chon nhan vien de cham cong");
//					return;
//				}
//				if (valid()) {
//					int maxMaCongNV = dao_congNV.getMaxMaCongNV();
//					int nextMaCongNV = maxMaCongNV + 1;
//					String ma = String.format("C%02d", nextMaCongNV);
//					String maNV = txtNhanVien.getText();
//					String caLam = cmbCaLam.getSelectedItem().toString();
//					String gioLam = txtGioLam.getText();
//					Double luongCa = Double.parseDouble(txtLuongCa.getText());
//					String trangThai = "";
//					if (chkCoMat.isSelected()) {
//						trangThai = "Có mặt";
//					} else {
//						trangThai = "Nghỉ";
//					}
//					String nghiPhep = "";
//					if (chkCoPhep.isSelected()) {
//						nghiPhep = "Có";
//					} else {
//						nghiPhep = "Không";
//					}
//
//					Date ngayCham = (Date) dateChooser.getDate();
//					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//					String ngayChamStr = dateFormat.format(ngayCham);
//
//					NhanVien nv = new NhanVien(maNV);
//					CongCuaNhanVien congNV = new CongCuaNhanVien(ma, nv, ngayChamStr, caLam, gioLam, luongCa, trangThai,
//							nghiPhep);
//					dao_congNV.create(congNV);
//					tableModelDSChamCong.addRow(new Object[] { congNV.getMaCongNV(),
//							congNV.getNhanVien().getMaNhanVien(), congNV.getNgayChamCong(), congNV.getCaLam(),
//							congNV.getGioLam(), congNV.getLuongCaLam(), congNV.getTrangThai(), congNV.getNghiPhep() });
//					txtNhanVien.setText("");
//					txtGioLam.setText("");
//					txtLuongCa.setText("");
//					txtPhongBan.setText("");
//					dateChooser.setDate(null);
//					cmbCaLam.setSelectedIndex(0);
//					JOptionPane.showMessageDialog(null, "Chấm công thành công");
//				} else {
//					JOptionPane.showMessageDialog(null, "Chấm công không thành công");
//				}
//			}
//		});
//		btnXoaChamCongNV.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				int row = tblDanhSachChamCong.getSelectedRow();
//				if (row < 0) {
//					JOptionPane.showMessageDialog(null, "Chọn công cần xóa");
//				} else {
//					String maCongNV = (String) tblDanhSachChamCong.getValueAt(row, 0);
//					dao_congNV.delete(maCongNV);
//					tableModelDSChamCong.removeRow(row);
//					JOptionPane.showMessageDialog(null, "Xóa chấm công thành công");
//				}
//
//			}
//		});
//		// THOÁT
//		btnThoat.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
//			}
//		});
//
	}
//
//	public void DocDuLieuDBVaoTable() {
//		List<NhanVien> list = DAO_NhanVien.getAlltbNhanVien();
//		for (NhanVien nv : list) {
//			tableModel.addRow(new Object[] { nv.getMaNhanVien(), nv.getHoTen(), nv.getcCCD(), nv.getNgaySinh(),
//					nv.getGioiTinh(), nv.getDiaChi(), nv.getSoDienThoai(), nv.getLuongCoBan(), nv.getPhuCap(),
//					nv.getPhongBan(), nv.getHeSoLuong() });
//		}
//
//	}
//
//	public void DocDLDanhSachChamCong() {
//		List<CongCuaNhanVien> list = DAO_ChamCongNhanVIen.getAlltbCongCuaNhanVien();
//		for (CongCuaNhanVien congNV : list) {
//			tableModelDSChamCong.addRow(new Object[] { congNV.getMaCongNV(), congNV.getNhanVien().getMaNhanVien(),
//					congNV.getNgayChamCong(), congNV.getCaLam(), congNV.getGioLam(), congNV.getLuongCaLam(),
//					congNV.getTrangThai(), congNV.getNghiPhep() });
//
//		}
//	}
//
//	public boolean valid() {
//		Date ngayCham = (Date) dateChooser.getDate();
//		if (ngayCham == null) {
//			JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày chấm công.");
//			return false;
//		}
//
//		// Kiểm tra xem ngày chấm có nhỏ hơn hoặc bằng ngày hiện tại hay không
//		Date ngayHienTai = new Date(); // Ngày hiện tại
//		if (ngayCham.after(ngayHienTai)) {
//			JOptionPane.showMessageDialog(null, "Ngày chấm công phải nhỏ hơn hoặc bằng ngày hiện tại.");
//			return false;
//		}
//		return true;
//	}

	// tinh tong ngay cong
	public int tinhTongNgayCong(String maNhanVien, int thang) {
		int tongNgayCong = 0;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		for (int row = 0; row < tableModelDSChamCong.getRowCount(); row++) {
			String maNVTrongBang = (String) tableModelDSChamCong.getValueAt(row, 1); // Cột Mã Nhân Viên
			String trangThai = (String) tableModelDSChamCong.getValueAt(row, 6); // Cột Trạng Thái
			String ngayChamCongStr = (String) tableModelDSChamCong.getValueAt(row, 2); // Cột Ngày Chấm Công
			Date ngayChamCong;

			try {
				ngayChamCong = dateFormat.parse(ngayChamCongStr);
			} catch (ParseException e) {
				// Xử lý ngoại lệ nếu định dạng ngày không hợp lệ
				e.printStackTrace();
				continue;
			}

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(ngayChamCong);
			int thangChamCong = calendar.get(Calendar.MONTH) + 1;

			if (maNVTrongBang.equals(maNhanVien) && "Có mặt".equals(trangThai) && thangChamCong == thang) {
				tongNgayCong++;
			}
		}

		return tongNgayCong;
	}

	// TB luong ca
	public double tinhTrungBinhLuongCa(String maNhanVien, int thang) {
		double tongLuongCa = 0;
		int soLuongChamCong = 0;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		for (int row = 0; row < tableModelDSChamCong.getRowCount(); row++) {
			String maNVTrongBang = (String) tableModelDSChamCong.getValueAt(row, 1); // Cột Mã Nhân Viên
			String ngayChamCongStr = (String) tableModelDSChamCong.getValueAt(row, 2); // Cột Ngày Chấm Công
			Object luongCaLamObj = tableModelDSChamCong.getValueAt(row, 5); // Cột Lương Ca Làm
			String trangThai = (String) tableModelDSChamCong.getValueAt(row, 6); // Cột Trạng Thái

			try {
				Date ngayChamCong = dateFormat.parse(ngayChamCongStr);
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(ngayChamCong);
				int thangChamCong = calendar.get(Calendar.MONTH) + 1;

				if (maNVTrongBang.equals(maNhanVien) && "Có mặt".equals(trangThai) && thangChamCong == thang) {
					if (luongCaLamObj instanceof Double) {
						double luongCaLam = (Double) luongCaLamObj;
						tongLuongCa += luongCaLam;
						soLuongChamCong++;
					}
				}
			} catch (ParseException e) {
				// Xử lý ngoại lệ nếu định dạng ngày không hợp lệ
				e.printStackTrace();
				continue;
			}
		}

		if (soLuongChamCong == 0) {
			return 0.0; // Tránh chia cho 0
		} else {
			return tongLuongCa / soLuongChamCong;
		}
	}

	//
}
