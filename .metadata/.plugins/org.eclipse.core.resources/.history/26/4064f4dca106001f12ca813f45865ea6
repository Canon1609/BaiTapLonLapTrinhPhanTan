package gui_Form;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.Box;
import java.awt.Component;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.Impl.ChamCongNhanVienDaoImpl;
import dao.Impl.LuongCongNhanlmpl;
import dao.Impl.LuongNhanVienDaoImpl;
import dao.Impl.NhanVienDaoImpl;
import dao.Impl.ThongKe_NV_Daolmpl;
import entity.LuongNhanVien;
import entity.NhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import javax.swing.DefaultComboBoxModel;

public class Form_NV_ThongKe extends JPanel {
	private JTable tbl_c;

	private JComboBox cmb_tenNV;
	private JComboBox cmb_maNV;
	private DefaultTableModel tableModel;
	private JLabel lbl_hienThiTongTienLuong;
	private JLabel lbl_hienThiTongNV;
	private JLabel lbl_hienThuSoNgayLam;
	private JLabel lbl_hienThiSoNgayNghi;
	private JLabel lbl_hienThiLuongCaoNhat;

	private EntityManagerFactory emf;

	private EntityManager em;

	private EntityTransaction tx;

	private NhanVienDaoImpl nv_dao;

	private ChamCongNhanVienDaoImpl cnv_dao;

	private LuongNhanVienDaoImpl lnv;

	private ThongKe_NV_Daolmpl tk_nv_dao;

	/**
	 * Create the panel.
	 * @throws RemoteException 
	 */
	public Form_NV_ThongKe() throws RemoteException {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_Nouth = new JPanel();
		panel_Nouth.setPreferredSize(new Dimension(1200, 50));
		add(panel_Nouth, BorderLayout.NORTH);
		
		JLabel lbl_tieuDe = new JLabel("THỐNG KÊ LƯƠNG NHÂN VIÊN");
		lbl_tieuDe.setFont(new Font("Arial", Font.BOLD, 15));
		panel_Nouth.add(lbl_tieuDe);
		
		JPanel panel_T = new JPanel();
		panel_T.setPreferredSize(new Dimension(600, 300));
		panel_T.setBorder(new TitledBorder(null, "Thống kê nhân viên ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_T, BorderLayout.WEST);
		panel_T.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Box b = Box.createVerticalBox();
		panel_T.add(b);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		b.add(verticalStrut_3);
		
		Box b1 = Box.createHorizontalBox();
		b.add(b1);
		
		JLabel lbl_thang = new JLabel("Tháng: ");
		lbl_thang.setPreferredSize(new Dimension(100, 30));
		lbl_thang.setFont(new Font("Arial", Font.PLAIN, 12));
		b1.add(lbl_thang);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		b1.add(horizontalStrut);
		
		JComboBox cmb_thang = new JComboBox();
		cmb_thang.setModel(new DefaultComboBoxModel(new String[] {"Tất cả", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cmb_thang.setPreferredSize(new Dimension(100, 30));
		cmb_thang.setFont(new Font("Arial", Font.PLAIN, 12));
		b1.add(cmb_thang);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setPreferredSize(new Dimension(40, 0));
		b1.add(horizontalStrut_1);
		
		JLabel lbl_nam = new JLabel("Năm: ");
		lbl_nam.setFont(new Font("Arial", Font.PLAIN, 12));
		b1.add(lbl_nam);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		b1.add(horizontalStrut_2);
		
		JComboBox comboBox_1 = new JComboBox();
		// Lấy năm hiện tại
		int namHienTai = Calendar.getInstance().get(Calendar.YEAR);
		// Thêm các năm từ 2024 đến năm hiện tại vào JComboBox
				for (int nam = 2024; nam <= namHienTai; nam++) {
					comboBox_1.addItem(nam);
				}
				b1.add(comboBox_1);

		comboBox_1.setPreferredSize(new Dimension(100, 30));
		comboBox_1.setFont(new Font("Arial", Font.PLAIN, 12));
		
		Component verticalStrut = Box.createVerticalStrut(20);
		b.add(verticalStrut);
		
		Box b2 = Box.createHorizontalBox();
		b.add(b2);
		
		JLabel lbl_maNV = new JLabel("Mã Nhân Viên : ");
		lbl_maNV.setPreferredSize(new Dimension(100, 30));
		lbl_maNV.setFont(new Font("Arial", Font.PLAIN, 12));
		b2.add(lbl_maNV);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		b2.add(horizontalStrut_3);
		
		cmb_maNV = new JComboBox();
		cmb_maNV.setModel(new DefaultComboBoxModel(new String[] {"Tất cả"}));
		cmb_maNV.setPreferredSize(new Dimension(100, 30));
		cmb_maNV.setFont(new Font("Arial", Font.PLAIN, 12));
		b2.add(cmb_maNV);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		b.add(verticalStrut_1);
		
		Box b3 = Box.createHorizontalBox();
		b.add(b3);
		
//		JLabel lbl_tenNV = new JLabel("Tên Nhân Viên: ");
//		lbl_tenNV.setPreferredSize(new Dimension(100, 30));
//		lbl_tenNV.setFont(new Font("Arial", Font.PLAIN, 12));
//		b3.add(lbl_tenNV);
//		
//		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
//		b3.add(horizontalStrut_4);
		
//		cmb_tenNV = new JComboBox();
//		cmb_tenNV.setModel(new DefaultComboBoxModel(new String[] {"Tất cả"}));
//		cmb_tenNV.setFont(new Font("Arial", Font.PLAIN, 12));
//		b3.add(cmb_tenNV);
//		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		verticalStrut_2.setPreferredSize(new Dimension(0, 50));
		b.add(verticalStrut_2);
		
		Box b4 = Box.createHorizontalBox();
		b4.setPreferredSize(new Dimension(300, 50));
		b.add(b4);
		
		JButton btn_thongKe = new JButton("Thống Kê");
		btn_thongKe.setIcon(new ImageIcon(Form_NV_ThongKe.class.getResource("/img/thongke.png")));
		btn_thongKe.setPreferredSize(new Dimension(150, 40));
		btn_thongKe.setFont(new Font("Arial", Font.BOLD, 14));
		btn_thongKe.setBackground(Color.ORANGE);
		b4.add(btn_thongKe);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		horizontalStrut_5.setPreferredSize(new Dimension(40, 0));
		b4.add(horizontalStrut_5);
		
		JButton btn_in = new JButton("In");
		btn_in.setIcon(new ImageIcon(Form_NV_ThongKe.class.getResource("/img/in.png")));
		btn_in.setPreferredSize(new Dimension(140, 40));
		btn_in.setFont(new Font("Arial", Font.BOLD, 14));
		btn_in.setBackground(Color.GREEN);
		b4.add(btn_in);
		
		JPanel panel_South = new JPanel();
		panel_South.setPreferredSize(new Dimension(550, 320));
		panel_South.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "B\u1EA3ng th\u1ED1ng k\u00EA nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		add(panel_South, BorderLayout.SOUTH);
		
		JScrollPane src_c = new JScrollPane();
		src_c.setPreferredSize(new Dimension(1100, 270));
		panel_South.add(src_c);
		
		JTable tbl_c = new JTable(new DefaultTableModel(
			    new Object[][] {},
			    new String[] {  "Mã Nhân Viên","Họ Tên", "Số Ngày Làm", "Lương" }
			) {
			    Class[] columnTypes = new Class[] { String.class, String.class, Integer.class,  Double.class };
			    public Class getColumnClass(int columnIndex) {
			        return columnTypes[columnIndex];
			    }
			});

			DefaultTableModel tableModel = (DefaultTableModel) tbl_c.getModel();
			tableModel.setColumnIdentifiers(new String[] { "Mã Nhân Viên","Họ Tên", "Số Ngày Làm", "Lương" });




		//tbl_c.getColumnModel().getColumn(6).setResizable(true);
		tbl_c.setFont(new Font("Arial", Font.PLAIN, 12));
		src_c.setViewportView(tbl_c);
		
		JPanel panel_Center = new JPanel();
		panel_Center.setPreferredSize(new Dimension(600, 300));
		panel_Center.setBorder(new TitledBorder(null, "Th\u1ED1ng k\u00EA ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel_Center, BorderLayout.CENTER);
		panel_Center.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_CenTer_T = new JPanel();
		panel_Center.add(panel_CenTer_T, BorderLayout.WEST);
		
		Box bc = Box.createVerticalBox();
		panel_CenTer_T.add(bc);
		
		Component verticalStrut_5 = Box.createVerticalStrut(20);
		bc.add(verticalStrut_5);
		
		Box bc1 = Box.createHorizontalBox();
		bc.add(bc1);
		
		JLabel lbl_tongTienLuong = new JLabel("Tổng tiền lương: ");
		lbl_tongTienLuong.setFont(new Font("Arial", Font.PLAIN, 14));
		bc1.add(lbl_tongTienLuong);
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		bc.add(verticalStrut_4);
		
		Box bc2 = Box.createHorizontalBox();
		bc.add(bc2);
		
		JLabel lbl_tongNV = new JLabel("Tổng nhân viên: ");
		lbl_tongNV.setPreferredSize(new Dimension(150, 30));
		lbl_tongNV.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tongNV.setFont(new Font("Arial", Font.PLAIN, 14));
		bc2.add(lbl_tongNV);
		
		Component verticalStrut_6 = Box.createVerticalStrut(20);
		bc.add(verticalStrut_6);
		
		Box bc3 = Box.createHorizontalBox();
		bc.add(bc3);
		
		JLabel lbl_soNgayLam = new JLabel("Số ngày làm trung bình: ");
		lbl_soNgayLam.setPreferredSize(new Dimension(160, 30));
		lbl_soNgayLam.setFont(new Font("Arial", Font.PLAIN, 14));
		bc3.add(lbl_soNgayLam);
		
		Component verticalStrut_7 = Box.createVerticalStrut(20);
		bc.add(verticalStrut_7);
		
		Box bc4 = Box.createHorizontalBox();
		bc.add(bc4);
		
//		JLabel lbl_soNgayNghi = new JLabel("Số ngày nghĩ trung bình: ");
//		lbl_soNgayNghi.setPreferredSize(new Dimension(160, 30));
//		lbl_soNgayNghi.setFont(new Font("Arial", Font.PLAIN, 14));
//		bc4.add(lbl_soNgayNghi);
		
//		Component verticalStrut_8 = Box.createVerticalStrut(20);
//		bc.add(verticalStrut_8);
		
		Box bc5 = Box.createHorizontalBox();
		bc.add(bc5);
		
		JLabel lbl_luongCaoNhat = new JLabel("Lương cao nhất: ");
		lbl_luongCaoNhat.setPreferredSize(new Dimension(160, 30));
		lbl_luongCaoNhat.setFont(new Font("Arial", Font.PLAIN, 14));
		bc5.add(lbl_luongCaoNhat);
		
		Component verticalStrut_9 = Box.createVerticalStrut(20);
		bc.add(verticalStrut_9);
		
		Box bc6 = Box.createHorizontalBox();
		bc.add(bc6);
		
		JLabel lbl_luongThapNhat = new JLabel("Lương thấp nhất: ");
		lbl_luongThapNhat.setPreferredSize(new Dimension(160, 30));
		lbl_luongThapNhat.setFont(new Font("Arial", Font.PLAIN, 14));
		bc6.add(lbl_luongThapNhat);
		
		JPanel panel_Center_Center = new JPanel();
		panel_Center.add(panel_Center_Center, BorderLayout.CENTER);
		panel_Center_Center.setLayout(new GridLayout(0, 1, 0, 0));
		
		Box bc_1 = Box.createVerticalBox();
		panel_Center_Center.add(bc_1);
		
		Component verticalStrut_5_1 = Box.createVerticalStrut(20);
		bc_1.add(verticalStrut_5_1);
		
		Box bc1_1 = Box.createHorizontalBox();
		bc_1.add(bc1_1);
		
		 lbl_hienThiTongTienLuong = new JLabel("???");
		lbl_hienThiTongTienLuong.setPreferredSize(new Dimension(150, 30));
		lbl_hienThiTongTienLuong.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_hienThiTongTienLuong.setFont(new Font("Arial", Font.PLAIN, 14));
		bc1_1.add(lbl_hienThiTongTienLuong);
		
		Component verticalStrut_4_1 = Box.createVerticalStrut(20);
		bc_1.add(verticalStrut_4_1);
		
		Box bc2_1 = Box.createHorizontalBox();
		bc_1.add(bc2_1);
		
		 lbl_hienThiTongNV = new JLabel("???");
		lbl_hienThiTongNV.setPreferredSize(new Dimension(150, 30));
		lbl_hienThiTongNV.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_hienThiTongNV.setFont(new Font("Arial", Font.PLAIN, 14));
		bc2_1.add(lbl_hienThiTongNV);
		
		Component verticalStrut_6_1 = Box.createVerticalStrut(20);
		bc_1.add(verticalStrut_6_1);
		
		Box bc3_1 = Box.createHorizontalBox();
		bc_1.add(bc3_1);
		
		 lbl_hienThuSoNgayLam = new JLabel("???");
		lbl_hienThuSoNgayLam.setPreferredSize(new Dimension(160, 30));
		lbl_hienThuSoNgayLam.setFont(new Font("Arial", Font.PLAIN, 14));
		bc3_1.add(lbl_hienThuSoNgayLam);
		
		Component verticalStrut_7_1 = Box.createVerticalStrut(20);
		bc_1.add(verticalStrut_7_1);
		
		Box bc4_1 = Box.createHorizontalBox();
		bc_1.add(bc4_1);
//		
//		 lbl_hienThiSoNgayNghi = new JLabel("???");
//		lbl_hienThiSoNgayNghi.setPreferredSize(new Dimension(160, 30));
//		lbl_hienThiSoNgayNghi.setFont(new Font("Arial", Font.PLAIN, 14));
//		bc4_1.add(lbl_hienThiSoNgayNghi);
//		
//		Component verticalStrut_8_1 = Box.createVerticalStrut(20);
//		verticalStrut_8_1.setPreferredSize(new Dimension(0, 0));
//		bc_1.add(verticalStrut_8_1);
		
		Box bc5_1 = Box.createHorizontalBox();
		bc_1.add(bc5_1);
		
		 lbl_hienThiLuongCaoNhat = new JLabel("???");
		lbl_hienThiLuongCaoNhat.setPreferredSize(new Dimension(160, 30));
		lbl_hienThiLuongCaoNhat.setFont(new Font("Arial", Font.PLAIN, 14));
		bc5_1.add(lbl_hienThiLuongCaoNhat);
		
		Component verticalStrut_9_1 = Box.createVerticalStrut(20);
		bc_1.add(verticalStrut_9_1);
		verticalStrut_9_1.setPreferredSize(new Dimension(0, 0));
		
		Box bc6_1 = Box.createHorizontalBox();
		bc_1.add(bc6_1);
		
		JLabel lbl_hienThiLuongThapNhat = new JLabel("???");
		lbl_hienThiLuongThapNhat.setPreferredSize(new Dimension(160, 30));
		lbl_hienThiLuongThapNhat.setFont(new Font("Arial", Font.PLAIN, 14));
		bc6_1.add(lbl_hienThiLuongThapNhat);
//		
		emf = Persistence.createEntityManagerFactory("jpa-mssql");
        em = emf.createEntityManager();
        tx = em.getTransaction();
		nv_dao =new NhanVienDaoImpl();
        
        
		List<NhanVien> list =nv_dao.getDanhSachNhanVien();
//		
		for (NhanVien nhanVien : list) {
			cmb_maNV.addItem(nhanVien.getMaNhanVien());
		//	cmb_tenNV.addItem(nhanVien.getHoTen());
		}
		cnv_dao =new ChamCongNhanVienDaoImpl();
		lnv =new LuongNhanVienDaoImpl();
		List<LuongNhanVien> dscnv =lnv.getDanhSachLuongNhanVien();
		for (LuongNhanVien luongNhanVien : dscnv) {
			tableModel.addRow(new Object[] {luongNhanVien.getMaNhanVien().getMaNhanVien(),
											luongNhanVien.getTenNhanVien(),
											luongNhanVien.getSoNgayDiLam(),
											luongNhanVien.getThucNhan()  });
		}
		tk_nv_dao =new ThongKe_NV_Daolmpl();
		
		btn_thongKe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String ma =cmb_maNV.getSelectedItem().toString();
				String date =cmb_thang.getSelectedItem().toString();
				String year =comboBox_1.getSelectedItem().toString();
				tableModel.setRowCount(0);
				int tongNhanVien=0;
				int soNgayLamTrungBinh=0;
				int soNgayNghiTrungBinh=0;
				float n,m;
				double tongLuong =0;
				double luongCao =0;
				double luongThap =0;
				double max =0;
				double min =0;
				if(date.equals("Tất cả") && year.equals("Tất cả"))
				{
					List<LuongNhanVien> list_hd;
					try {
						list_hd = tk_nv_dao.getmatbLuongNhanVien(ma);
						for (LuongNhanVien luongNhanVien : list_hd) {
							tableModel.addRow(new Object[] {luongNhanVien.getMaNhanVien().getMaNhanVien(),
									luongNhanVien.getTenNhanVien(),
									luongNhanVien.getSoNgayDiLam(),
									luongNhanVien.getThucNhan()  });
						
							tongNhanVien++;
							soNgayLamTrungBinh+=luongNhanVien.getSoNgayDiLam();
							tongLuong+=luongNhanVien.getThucNhan();
							if(max<luongNhanVien.getThucNhan())
							{
								max=luongNhanVien.getThucNhan();
							}
							if(min>luongNhanVien.getThucNhan())
							{
								min=luongNhanVien.getThucNhan();
							}

							lbl_hienThiTongNV.setText(tongNhanVien+"");
							lbl_hienThiLuongThapNhat.setText(min+"");
							lbl_hienThiLuongCaoNhat.setText(max+"");
							lbl_hienThiTongTienLuong.setText(tongLuong+"");
			if (tongNhanVien != 0) {
								
							    m = soNgayLamTrungBinh / tongNhanVien;
							    lbl_hienThuSoNgayLam.setText(String.valueOf(m));
							} else {
							    lbl_hienThuSoNgayLam.setText("0");
							    // Hoặc có thể xử lý khác tùy thuộc vào yêu cầu của bạn
							}
					}
					}catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						
						
					
				}
				else if(ma.equals("Tất cả") && date.equals("Tất cả"))
				{
					List<LuongNhanVien> list_hd;
					try {
						list_hd = tk_nv_dao.timKiemNgayLYear(year);
						for (LuongNhanVien luongNhanVien : list_hd) {
							tableModel.addRow(new Object[] {luongNhanVien.getMaNhanVien().getMaNhanVien(),
									luongNhanVien.getTenNhanVien(),
									luongNhanVien.getSoNgayDiLam(),
									luongNhanVien.getThucNhan()  });
							

							tongNhanVien++;
							soNgayLamTrungBinh+=luongNhanVien.getSoNgayDiLam();
							tongLuong+=luongNhanVien.getThucNhan();
							if(max<luongNhanVien.getThucNhan())
							{
								max=luongNhanVien.getThucNhan();
							}
							if(min>luongNhanVien.getThucNhan())
							{
								min=luongNhanVien.getThucNhan();
							}
							
						}
						lbl_hienThiTongNV.setText(tongNhanVien+"");
						lbl_hienThiLuongThapNhat.setText(min+"");
						lbl_hienThiLuongCaoNhat.setText(max+"");
						lbl_hienThiTongTienLuong.setText(tongLuong+"");
		if (tongNhanVien != 0) {
							
						    m = soNgayLamTrungBinh / tongNhanVien;
						    lbl_hienThuSoNgayLam.setText(String.valueOf(m));
						} else {
						    lbl_hienThuSoNgayLam.setText("0");
						    // Hoặc có thể xử lý khác tùy thuộc vào yêu cầu của bạn
						}
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				
				}
				else if(year.equals("Tất cả") && ma.equals("Tất cả"))
				{
					List<LuongNhanVien> list_hd;
					try {
						list_hd = tk_nv_dao.timKiemNgayLMonth(date);
						for (LuongNhanVien luongNhanVien : list_hd) {
							tableModel.addRow(new Object[] {luongNhanVien.getMaNhanVien().getMaNhanVien(),
									luongNhanVien.getTenNhanVien(),
									luongNhanVien.getSoNgayDiLam(),
									luongNhanVien.getThucNhan()  });

							tongNhanVien++;
							soNgayLamTrungBinh+=luongNhanVien.getSoNgayDiLam();
							tongLuong+=luongNhanVien.getThucNhan();
							if(max<luongNhanVien.getThucNhan())
							{
								max=luongNhanVien.getThucNhan();
							}
							if(min>luongNhanVien.getThucNhan())
							{
								min=luongNhanVien.getThucNhan();
							}
							
						}
						lbl_hienThiTongNV.setText(tongNhanVien+"");
						lbl_hienThiLuongThapNhat.setText(min+"");
						lbl_hienThiLuongCaoNhat.setText(max+"");
						lbl_hienThiTongTienLuong.setText(tongLuong+"");
		if (tongNhanVien != 0) {
							
						    m = soNgayLamTrungBinh / tongNhanVien;
						    lbl_hienThuSoNgayLam.setText(String.valueOf(m));
						} else {
						    lbl_hienThuSoNgayLam.setText("0");
						    // Hoặc có thể xử lý khác tùy thuộc vào yêu cầu của bạn
						}
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
					}
					
				
				else if(year.equals("Tất cả"))
				{
					List<LuongNhanVien> list_hd;
					try {
						list_hd = tk_nv_dao.timKiemMonthMaHD(date, ma);
						for (LuongNhanVien luongNhanVien : list_hd) {
							tableModel.addRow(new Object[] {luongNhanVien.getMaNhanVien().getMaNhanVien(),
									luongNhanVien.getTenNhanVien(),
									luongNhanVien.getSoNgayDiLam(),
									luongNhanVien.getThucNhan()  });

							tongNhanVien++;
							soNgayLamTrungBinh+=luongNhanVien.getSoNgayDiLam();
							tongLuong+=luongNhanVien.getThucNhan();
							if(max<luongNhanVien.getThucNhan())
							{
								max=luongNhanVien.getThucNhan();
							}
							if(min>luongNhanVien.getThucNhan())
							{
								min=luongNhanVien.getThucNhan();
							}
							
						}
						lbl_hienThiTongNV.setText(tongNhanVien+"");
						lbl_hienThiLuongThapNhat.setText(min+"");
						lbl_hienThiLuongCaoNhat.setText(max+"");
						lbl_hienThiTongTienLuong.setText(tongLuong+"");
		if (tongNhanVien != 0) {
							
						    m = soNgayLamTrungBinh / tongNhanVien;
						    lbl_hienThuSoNgayLam.setText(String.valueOf(m));
						} else {
						    lbl_hienThuSoNgayLam.setText("0");
						    // Hoặc có thể xử lý khác tùy thuộc vào yêu cầu của bạn
						}
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
				}
				else if(ma.equals("Tất cả"))
				{
					List<LuongNhanVien> list_hd;
					try {
						list_hd = tk_nv_dao.timKiemMonthYear(date, year);
						for (LuongNhanVien luongNhanVien : list_hd) {
							tableModel.addRow(new Object[] {luongNhanVien.getMaNhanVien().getMaNhanVien(),
									luongNhanVien.getTenNhanVien(),
									luongNhanVien.getSoNgayDiLam(),
									luongNhanVien.getThucNhan()  });

							tongNhanVien++;
							soNgayLamTrungBinh+=luongNhanVien.getSoNgayDiLam();
							tongLuong+=luongNhanVien.getThucNhan();
							if(max<luongNhanVien.getThucNhan())
							{
								max=luongNhanVien.getThucNhan();
							}
							if(min>luongNhanVien.getThucNhan())
							{
								min=luongNhanVien.getThucNhan();
							}
							
						}
						lbl_hienThiTongNV.setText(tongNhanVien+"");
						lbl_hienThiLuongThapNhat.setText(min+"");
						lbl_hienThiLuongCaoNhat.setText(max+"");
						lbl_hienThiTongTienLuong.setText(tongLuong+"");
		if (tongNhanVien != 0) {
							
						    m = soNgayLamTrungBinh / tongNhanVien;
						    lbl_hienThuSoNgayLam.setText(String.valueOf(m));
						} else {
						    lbl_hienThuSoNgayLam.setText("0");
						    // Hoặc có thể xử lý khác tùy thuộc vào yêu cầu của bạn
						}
						
						
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				}
				else if(date.equals("Tất cả"))
				{
					List<LuongNhanVien> list_hd;
					try {
						list_hd = tk_nv_dao.timKiemYearMaHD(year, ma);
						for (LuongNhanVien luongNhanVien : list_hd) {
							tableModel.addRow(new Object[] {luongNhanVien.getMaNhanVien().getMaNhanVien(),
									luongNhanVien.getTenNhanVien(),
									luongNhanVien.getSoNgayDiLam(),
									luongNhanVien.getThucNhan()  });

							tongNhanVien++;
							soNgayLamTrungBinh+=luongNhanVien.getSoNgayDiLam();
							tongLuong+=luongNhanVien.getThucNhan();
							if(max<luongNhanVien.getThucNhan())
							{
								max=luongNhanVien.getThucNhan();
							}
							if(min>luongNhanVien.getThucNhan())
							{
								min=luongNhanVien.getThucNhan();
							}
							
						}
		if (tongNhanVien != 0) {
							
						    m = soNgayLamTrungBinh / tongNhanVien;
						    lbl_hienThuSoNgayLam.setText(String.valueOf(m));
						} else {
						    lbl_hienThuSoNgayLam.setText("0");
						    // Hoặc có thể xử lý khác tùy thuộc vào yêu cầu của bạn
						}
						lbl_hienThiTongNV.setText(tongNhanVien+"");
						lbl_hienThiLuongThapNhat.setText(min+"");
						lbl_hienThiLuongCaoNhat.setText(max+"");
						lbl_hienThiTongTienLuong.setText(tongLuong+"");
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				
					
					
				}
			
					
				else
					{
						List<LuongNhanVien> list_hd;
						try {
							list_hd = tk_nv_dao.timKiem(date,year,ma);
							for (LuongNhanVien luongNhanVien : list_hd) {
								tableModel.addRow(new Object[] {luongNhanVien.getMaNhanVien().getMaNhanVien(),
										luongNhanVien.getTenNhanVien(),
										luongNhanVien.getSoNgayDiLam(),
										luongNhanVien.getThucNhan()  });

								tongNhanVien++;
								soNgayLamTrungBinh+=luongNhanVien.getSoNgayDiLam();
								tongLuong+=luongNhanVien.getThucNhan();
								if(max<luongNhanVien.getThucNhan())
								{
									max=luongNhanVien.getThucNhan();
								}
								if(min>luongNhanVien.getThucNhan())
								{
									min=luongNhanVien.getThucNhan();
								}
								
							}
							if (tongNhanVien != 0) {
								
							    m = soNgayLamTrungBinh / tongNhanVien;
							    lbl_hienThuSoNgayLam.setText(String.valueOf(m));
							} else {
							    lbl_hienThuSoNgayLam.setText("0");
							    // Hoặc có thể xử lý khác tùy thuộc vào yêu cầu của bạn
							}
							lbl_hienThiTongNV.setText(tongNhanVien+"");
							lbl_hienThiLuongThapNhat.setText(min+"");
							lbl_hienThiLuongCaoNhat.setText(max+"");
							lbl_hienThiTongTienLuong.setText(tongLuong+"");
							
												
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}
				 if(date.equals("Tất cả") && year.equals("Tất cả") && ma.equals("Tất cả"))
				{
					
					List<LuongNhanVien> list_hd =lnv.getDanhSachLuongNhanVien();
					for (LuongNhanVien luongNhanVien : list_hd) {
						tableModel.addRow(new Object[] {luongNhanVien.getMaNhanVien().getMaNhanVien(),
								luongNhanVien.getTenNhanVien(),
								luongNhanVien.getSoNgayDiLam(),
								luongNhanVien.getThucNhan()  });

						tongNhanVien++;
						soNgayLamTrungBinh+=luongNhanVien.getSoNgayDiLam();
						tongLuong+=luongNhanVien.getThucNhan();
						if(max<luongNhanVien.getThucNhan())
						{
							max=luongNhanVien.getThucNhan();
						}
						if(min>luongNhanVien.getThucNhan())
						{
							min=luongNhanVien.getThucNhan();
						}
						
					}
					if (tongNhanVien != 0) {
						
					    m = soNgayLamTrungBinh / tongNhanVien;
					    lbl_hienThuSoNgayLam.setText(String.valueOf(m));
					} else {
					    lbl_hienThuSoNgayLam.setText("0");
					    // Hoặc có thể xử lý khác tùy thuộc vào yêu cầu của bạn
					}
					lbl_hienThiTongNV.setText(tongNhanVien+"");
					lbl_hienThiLuongThapNhat.setText(min+"");
					lbl_hienThiLuongCaoNhat.setText(max+"");
					lbl_hienThiTongTienLuong.setText(tongLuong+"");
					
					

				}
				
			}
		});
	}
//	public static int laySoNgayTrongThang(int nam, int thang) {
//        YearMonth thangCuThe = YearMonth.of(nam, thang);
//        return thangCuThe.lengthOfMonth();
//    }
	

}
