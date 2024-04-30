package gui_Form;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.Box;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dao.Impl.PhanCongDaoImpl;
import dao.Impl.SanPhamDAOImpl;
import entity.CongDoan;
import entity.CongNhan;
import entity.PhanCong;
import entity.SanPham;

import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Form_CN_PhanCong extends JPanel {
	private JTextField txtMaPhanCong;
	private JTextField txtTenSanPham;
	private JTextField txtSLCanLam;
	private JTable table;
	private JTable tblPhanCong;
	private TableModel tableModelSP;
	private JComboBox cmbMaCongNhan;
	private JComboBox cmbTenCongNhan;
	private JComboBox cmbTenCongDoan;
	private JComboBox cmbCongDoanYC;
	private DefaultTableModel tableModelPC;

	private JTextField txtSoLuongConLai;
	private int soLuongCanLam;
	private int soLuongConLai;
	private PhanCongDaoImpl pc_dao = new PhanCongDaoImpl();
	private SanPhamDAOImpl sp_dao;
	/**
	 * Create the panel.
	 * @throws RemoteException 
	 */
	public Form_CN_PhanCong() throws RemoteException {
		setLayout(new BorderLayout(0, 0));

		JPanel pnNorth = new JPanel();
		add(pnNorth, BorderLayout.NORTH);

		JLabel lblChamCong = new JLabel("PHÂN CÔNG");
		lblChamCong.setForeground(Color.RED);
		lblChamCong.setFont(new Font("Arial", Font.BOLD, 16));
		pnNorth.add(lblChamCong);

		JPanel pnCenter = new JPanel();
		pnCenter.setPreferredSize(new Dimension(1300, 400));
		add(pnCenter, BorderLayout.CENTER);

		JPanel pnNhap = new JPanel();
		pnNhap.setPreferredSize(new Dimension(1200, 330));
		pnNhap.setBorder(new TitledBorder(null, "Th\u00F4ng Tin Ph\u00E2n C\u00F4ng", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pnCenter.add(pnNhap);

		Box box1 = Box.createVerticalBox();
		pnNhap.add(box1);

		Box boxMaPhanCong = Box.createHorizontalBox();
		box1.add(boxMaPhanCong);

		JLabel lblMaPhanCong = new JLabel("Mã Phân Công :");
		lblMaPhanCong.setFont(new Font("Arial", Font.BOLD, 14));
		boxMaPhanCong.add(lblMaPhanCong);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		boxMaPhanCong.add(horizontalStrut);

		txtMaPhanCong = new JTextField();
		txtMaPhanCong.setEditable(false);
		txtMaPhanCong.setPreferredSize(new Dimension(7, 30));
		boxMaPhanCong.add(txtMaPhanCong);
		txtMaPhanCong.setColumns(15);

		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setPreferredSize(new Dimension(0, 35));
		box1.add(verticalStrut);

		Box boxMaCongNhan = Box.createHorizontalBox();
		box1.add(boxMaCongNhan);

		JLabel lblMaCongNhan = new JLabel("Mã Công nhân :");
		lblMaCongNhan.setFont(new Font("Arial", Font.BOLD, 14));
		boxMaCongNhan.add(lblMaCongNhan);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		boxMaCongNhan.add(horizontalStrut_1);

		cmbMaCongNhan = new JComboBox();
		//cmbMaCongNhan.setEditable(true);
		cmbMaCongNhan.setPreferredSize(new Dimension(140, 30));
		boxMaCongNhan.add(cmbMaCongNhan);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalStrut_1.setPreferredSize(new Dimension(0, 35));
		box1.add(verticalStrut_1);

		Box boxSLCanTim = Box.createHorizontalBox();
		box1.add(boxSLCanTim);

		JLabel lblSLCanLam = new JLabel("SL Cần Làm :");
		lblSLCanLam.setFont(new Font("Arial", Font.BOLD, 14));
		boxSLCanTim.add(lblSLCanLam);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		horizontalStrut_2.setPreferredSize(new Dimension(33, 0));
		boxSLCanTim.add(horizontalStrut_2);

		txtSLCanLam = new JTextField();
		txtSLCanLam.setPreferredSize(new Dimension(7, 30));
		boxSLCanTim.add(txtSLCanLam);
		txtSLCanLam.setColumns(15);

		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		horizontalStrut_3.setPreferredSize(new Dimension(30, 0));
		pnNhap.add(horizontalStrut_3);

		Box box2 = Box.createVerticalBox();
		pnNhap.add(box2);

		Box boxTenCongNhan = Box.createHorizontalBox();
		box2.add(boxTenCongNhan);

		JLabel lblTenCongNhan = new JLabel("Tên Công Nhân :");
		lblTenCongNhan.setFont(new Font("Arial", Font.BOLD, 14));
		boxTenCongNhan.add(lblTenCongNhan);

		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		boxTenCongNhan.add(horizontalStrut_5);

		cmbTenCongNhan = new JComboBox();
		cmbTenCongNhan.setEditable(true);
		cmbTenCongNhan.setPreferredSize(new Dimension(140, 30));
		boxTenCongNhan.add(cmbTenCongNhan);

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		verticalStrut_2.setPreferredSize(new Dimension(0, 35));
		box2.add(verticalStrut_2);

		Box boxTenCongDoan = Box.createHorizontalBox();
		box2.add(boxTenCongDoan);

		JLabel lblTenCongDoan = new JLabel("Tên Công Đoạn :");
		lblTenCongDoan.setFont(new Font("Arial", Font.BOLD, 14));
		boxTenCongDoan.add(lblTenCongDoan);

		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		boxTenCongDoan.add(horizontalStrut_6);

		cmbTenCongDoan = new JComboBox();
		cmbTenCongDoan.setEditable(true);
		cmbTenCongDoan.setPreferredSize(new Dimension(140, 30));
		boxTenCongDoan.add(cmbTenCongDoan);

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		verticalStrut_3.setPreferredSize(new Dimension(0, 35));
		box2.add(verticalStrut_3);

		Box boxCongDoanYC = Box.createHorizontalBox();
		box2.add(boxCongDoanYC);

		JLabel lblCongDoanYC = new JLabel("Mã Công Đoạn:");
		lblCongDoanYC.setFont(new Font("Arial", Font.BOLD, 14));
		boxCongDoanYC.add(lblCongDoanYC);

		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		horizontalStrut_7.setPreferredSize(new Dimension(27, 0));
		boxCongDoanYC.add(horizontalStrut_7);

		cmbCongDoanYC = new JComboBox();
		cmbCongDoanYC.setPreferredSize(new Dimension(140, 30));
		boxCongDoanYC.add(cmbCongDoanYC);

		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		horizontalStrut_4.setPreferredSize(new Dimension(40, 0));
		pnNhap.add(horizontalStrut_4);

		JPanel pnDanhSachSanPham = new JPanel();
		pnDanhSachSanPham.setPreferredSize(new DimensionUIResource(500, 300));
		pnDanhSachSanPham.setBorder(new TitledBorder(null, "Danh S\u00E1ch S\u1EA3n Ph\u1EA9m", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pnNhap.add(pnDanhSachSanPham);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(490, 240));
		pnDanhSachSanPham.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 S\u1EA3n Ph\u1EA9m", "T\u00EAn S\u1EA3n Ph\u1EA9m", "Ki\u1EC3u D\u00E1ng",
						"Ch\u1EA5t Li\u1EC7u", "S\u1ED1 L\u01B0\u1EE3ng " }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, Integer.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		// xu ly
		tableModelSP = table.getModel();
		String[] columName = { "Mã Sản Phẩm", "Tên Sản Phẩm", "Kiểu Dáng", "Chất Liệu", "Số Lượng" };
		((DefaultTableModel) tableModelSP).setColumnIdentifiers(columName);

		updateMaCongNhanComboBox();
		updateMaCongDoanComboBox();
		
		// Sự kiện cho combobox mã công nhân
		cmbMaCongNhan.addMouseListener(new MouseAdapter() {
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
		    public void mouseClicked(MouseEvent e) {
		        // Khi người dùng chọn một mã công nhân
		        String selectedMaCongNhan = cmbMaCongNhan.getSelectedItem().toString();

		        // Lấy tên công nhân tương ứng và hiển thị lên combobox tên công nhân
		        String tenCongNhan = null;
				try {
					tenCongNhan = pc_dao.GetTenCongNhanTheoMa(selectedMaCongNhan);
					cmbTenCongNhan.setSelectedItem(tenCongNhan);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        
		    }
		});

		// Sự kiện cho combobox mã công đoạn
		cmbCongDoanYC.addMouseListener(new MouseAdapter() {
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
		    public void mouseClicked(MouseEvent e) {  	
		        // Khi người dùng chọn một mã công đoạn
		        String selectedMaCongDoan = cmbCongDoanYC.getSelectedItem().toString();

		        // Lấy tên công đoạn tương ứng và hiển thị lên combobox tên công đoạn
		        String tenCongDoan = null;
				try {
					tenCongDoan = pc_dao.GetTenCongDoanTheoMa(selectedMaCongDoan);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        cmbTenCongDoan.setSelectedItem(tenCongDoan);
		    }
	
		});
		sp_dao = new SanPhamDAOImpl();
		
		table.addMouseListener((MouseListener) new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		        int selectedRow = table.getSelectedRow();

		        if (selectedRow >= 0 && selectedRow < table.getRowCount()) {
		            String maSanPham = table.getValueAt(selectedRow, 0).toString();
		            

		            if (tblPhanCong.getRowCount() > 0 && tblPhanCong.getColumnCount() > 3) {
		            	String maCD = tblPhanCong.getValueAt(selectedRow, 3).toString();
		                int soLuongDaPhanCong = pc_dao.getSoLuongDaPhanCong(maCD);
		                int soLuongTonKho = sp_dao.getSoLuong(maSanPham);
		                int soLuongConLai = soLuongTonKho - soLuongDaPhanCong;

		                txtSoLuongConLai.setText(String.valueOf(soLuongConLai));

		            } else {
		                int soLuongBanDau = sp_dao.getSoLuong(maSanPham);
		                txtSoLuongConLai.setText(String.valueOf(soLuongBanDau));
		            }
		        } else {
		            txtSoLuongConLai.setText("");
		        }
		    }
		});





		JLabel lblSLConLai = new JLabel("Số lượng còn lại: ");
		txtSoLuongConLai = new JTextField();
		txtSoLuongConLai.setEditable(false);
		txtSoLuongConLai.setPreferredSize(new Dimension(7, 25));
		pnDanhSachSanPham.add(lblSLConLai);
		pnDanhSachSanPham.add(txtSoLuongConLai);
		txtSoLuongConLai.setColumns(10);

		JPanel pnChucNang = new JPanel();
		pnChucNang.setPreferredSize(new Dimension(1200, 60));
		pnCenter.add(pnChucNang);

		JButton btnThemPhanCong = new JButton("Thêm Phân Công");
		btnThemPhanCong.setBackground(Color.LIGHT_GRAY);
		btnThemPhanCong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThemPhanCong.setIcon(new ImageIcon(Form_CN_PhanCong.class.getResource("/img/add.png")));
		btnThemPhanCong.setFont(new Font("Arial", Font.BOLD, 14));
		pnChucNang.add(btnThemPhanCong);

		JButton btnXoaPhanCong = new JButton("Xóa Phân Công");
		btnXoaPhanCong.setBackground(Color.CYAN);
		btnXoaPhanCong.setIcon(new ImageIcon(Form_CN_PhanCong.class.getResource("/img/delete.png")));
		btnXoaPhanCong.setFont(new Font("Arial", Font.BOLD, 14));
		pnChucNang.add(btnXoaPhanCong);

		JButton btnSuaPhanCong = new JButton("Sửa Phân Công");
		btnSuaPhanCong.setBackground(Color.GREEN);
		btnSuaPhanCong.setIcon(new ImageIcon(Form_CN_PhanCong.class.getResource("/img/fixinfomation.png")));
		btnSuaPhanCong.setFont(new Font("Arial", Font.BOLD, 14));
		pnChucNang.add(btnSuaPhanCong);

		JButton btnXoaRong = new JButton("Xóa Rỗng");
		btnXoaRong.setBackground(Color.MAGENTA);
		btnXoaRong.setIcon(new ImageIcon(Form_CN_PhanCong.class.getResource("/img/xoarong.png")));
		btnXoaRong.setFont(new Font("Arial", Font.BOLD, 14));
		pnChucNang.add(btnXoaRong);

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setBackground(Color.RED);
		btnThoat.setIcon(new ImageIcon(Form_CN_PhanCong.class.getResource("/img/exit.png")));
		btnThoat.setFont(new Font("Arial", Font.BOLD, 14));
		pnChucNang.add(btnThoat);

		JPanel pnSouth = new JPanel();
		pnSouth.setPreferredSize(new Dimension(1200, 240));
		pnSouth.setBorder(new TitledBorder(null, "Danh S\u00E1ch Ph\u00E2n C\u00F4ng", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		add(pnSouth, BorderLayout.SOUTH);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setPreferredSize(new Dimension(1100, 200));
		pnSouth.add(scrollPane_1);

		
		tblPhanCong = new JTable();
		scrollPane_1.setViewportView(tblPhanCong);
		tblPhanCong.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 Ph\u00E2n C\u00F4ng", "Mã Công Nhân", "T\u00EAn C\u00F4ng Nh\u00E2n",
						"Mã Công Đoạn", "T\u00EAn C\u00F4ng \u0110o\u1EA1n", "S\u1ED1 L\u01B0\u1EE3ng C\u1EA7n Làm" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class,
					Integer.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableModelPC = (DefaultTableModel) tblPhanCong.getModel();
		String[] columnNames = { "M\u00E3 Ph\u00E2n C\u00F4ng", "Mã Công Nhân", "Tên Công Nhân", "Mã Công Đoạn", "Tên Công \u0110oạn", "Số Lượng Cần Làm" };

		
		tableModelPC.setColumnIdentifiers(columnNames);
		tblPhanCong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tblPhanCong.getSelectedRow();
				if(row>=0) {
					String maPC = (String) tblPhanCong.getValueAt(row, 0);
					String maCN = (String) tblPhanCong.getValueAt(row, 1);
					String tenCN = (String) tblPhanCong.getValueAt(row, 2);
					String maCD = (String) tblPhanCong.getValueAt(row, 3);
					String tenCD = (String) tblPhanCong.getValueAt(row, 4);
					String soLuongCanLam = (String) tblPhanCong.getValueAt(row, 5).toString();
					
					txtMaPhanCong.setText(maPC);
					cmbMaCongNhan.setSelectedItem(maCN);
					cmbTenCongNhan.setSelectedItem(tenCN);
					cmbCongDoanYC.setSelectedItem(maCD);
					cmbTenCongDoan.setSelectedItem(tenCD);
					txtSLCanLam.setText(soLuongCanLam);

				}
			}
		});
//		pc_dao = new DAO_PhanCong();
		DocDuLieuSanPhamDBVaoTable();
		docDLPhanCongvaoTB();
		btnThemPhanCong.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()<0) {
					JOptionPane.showMessageDialog(null, "Chua chon san pham");
					return;
				}
				if(valid()) {
					int maxMaPC = pc_dao.getMaxPhanCongNumber();
					int nextMaPC = maxMaPC+1;
					String maPC = String.format("PC%02d", nextMaPC);
					String maCN = cmbMaCongNhan.getSelectedItem().toString();
					String tenCN = cmbTenCongNhan.getSelectedItem().toString();
					String maCD = cmbCongDoanYC.getSelectedItem().toString();
					String tenCD = cmbTenCongDoan.getSelectedItem().toString();
					int soLuongCanLam = Integer.parseInt(txtSLCanLam.getText().trim());
					CongNhan cn = new CongNhan(maCN);
					CongDoan cd = new CongDoan(maCD);
					PhanCong pc = new PhanCong(maPC, cn, tenCN, cd, tenCD, soLuongCanLam);
					try {
					  boolean add = 	pc_dao.themPhanCong(pc);
					  if(add)
					  {
						  JOptionPane.showMessageDialog(null, "Thêm phân công thành công");
					  }
						else {
							JOptionPane.showMessageDialog(null, "Thêm phân công không thành công");
						}
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					tableModelPC.addRow(new Object[] {pc.getMaPhanCong(),pc.getMaCongNhan().getMaCongNhan(),pc.getTenCongNhan()
					,pc.getCongDoan().getMaCongDoan(),pc.getTenCongDoan(),pc.getSoLuongSanPhamCanLam()});
					
					txtMaPhanCong.setText("");
					txtSLCanLam.setText("");
					cmbCongDoanYC.setSelectedIndex(0);
					//cmbTenCongDoan.setSelectedIndex(0);
					cmbMaCongNhan.setSelectedIndex(0);
					//cmbTenCongNhan.setSelectedIndex(0);
				
				}
				
			}
		});
		btnXoaPhanCong.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = tblPhanCong.getSelectedRow();
				if(row < 0) {
					JOptionPane.showMessageDialog(null, "Chọn phân công cần xóa");
				}else {
					String maPC = (String) tblPhanCong.getValueAt(row, 0);
					try {
						pc_dao.xoaPhanCong(maPC);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					tableModelPC.removeRow(row);
					JOptionPane.showMessageDialog(null, "Xóa phân công thành công");
				}
				
			}
		});
		btnSuaPhanCong.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = tblPhanCong.getSelectedRow();
				if(row<0) {
					JOptionPane.showMessageDialog(null, "Chọn một Phan cong trong bảng để sửa.");
		            return;
				}
				String maPC = txtMaPhanCong.getText().trim();
				String maCN = cmbMaCongNhan.getSelectedItem().toString();
				String tenCN = cmbTenCongNhan.getSelectedItem().toString();
				String maCD = cmbCongDoanYC.getSelectedItem().toString();
				String tenCD = cmbTenCongDoan.getSelectedItem().toString();
				int soLuongCanLam = Integer.parseInt(txtSLCanLam.getText().trim());
				CongNhan cn = new CongNhan(maCN);
				CongDoan cd = new CongDoan(maCD);
				PhanCong pc = new PhanCong(maPC, cn, tenCN, cd, tenCD, soLuongCanLam);
				boolean updated = false;
				try {
					updated = pc_dao.suaPhanCong(pc);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 if (updated) {
			            // Cập nhật lại thông tin trong bảng
			            tableModelPC.setValueAt(maCN, row, 1);
			            tableModelPC.setValueAt(tenCN, row, 2);
			            tableModelPC.setValueAt(maCD, row, 3);
			            tableModelPC.setValueAt(tenCD, row, 4);
			            tableModelPC.setValueAt(soLuongCanLam, row, 5);

			            JOptionPane.showMessageDialog(null, "Cập nhật thông tin Phan cong thành công");
			        } else {
			            JOptionPane.showMessageDialog(null, "Cập nhật thông tin Phan cong thất bại");
			        }
				
			}
		});
		btnXoaRong.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtMaPhanCong.setText("");
				txtSLCanLam.setText("");
				cmbMaCongNhan.setSelectedIndex(-1);
				cmbTenCongNhan.setSelectedIndex(-1);
				cmbCongDoanYC.setSelectedIndex(-1);
				cmbTenCongDoan.setSelectedIndex(-1);
				
			}
		});
		//THOÁT
				btnThoat.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
//
	}

	public void DocDuLieuSanPhamDBVaoTable() throws RemoteException {
	
		List<SanPham> list = pc_dao.getDSSanPham();
		((DefaultTableModel) tableModelSP).setRowCount(0);
		for (SanPham sp : list) {
			((DefaultTableModel) tableModelSP).addRow(new Object[] { sp.getMaSanPham(), sp.getTenSanPham(),
					sp.getKieuDang(), sp.getChatLieu(), sp.getSoLuong() });
		}
	}
	public void docDLPhanCongvaoTB() throws RemoteException {
		List<PhanCong> list = pc_dao.getDSPhanCong();
		for(PhanCong pc : list) {
			tableModelPC.addRow(new Object[] {pc.getMaPhanCong(),pc.getMaCongNhan().getMaCongNhan(),pc.getTenCongNhan()
					,pc.getCongDoan().getMaCongDoan(),pc.getTenCongDoan(),pc.getSoLuongSanPhamCanLam()});
		}
	}
	public boolean valid() {
		    
		    if(txtSoLuongConLai.getText().trim().equals("")) {
		    	JOptionPane.showMessageDialog(null, "Bạn cần chọn sản phẩm để biết số sản phẩm chưa được phân công");
		    	return false;
		    }else 
		    	soLuongCanLam = Integer.parseInt(txtSLCanLam.getText().trim());
			    soLuongConLai = Integer.parseInt(txtSoLuongConLai.getText().trim());
		
		    if (soLuongCanLam > soLuongConLai) {
		        JOptionPane.showMessageDialog(null, "Số lượng cần làm không hợp lệ, đã vượt quá số lượng còn lại");
		        return false;
		    }
		    if (txtSLCanLam.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "Số lượng cần làm không được để trống");
				txtSLCanLam.requestFocus();
				return false;
			}
//		    String maCD = cmbCongDoanYC.getSelectedItem().toString();
//		    System.out.println("Mã công đoạn: " + maCD);
//		    boolean cdyc = DAO_CongDoan.coCongDoanYeuCau(maCD);
//		    if(cdyc==true) {
//		    	System.out.println("co");
//		    }
//		    if(soLuongConLai>0 && cdyc ) {
//		    	JOptionPane.showMessageDialog(null, "Công đoạn truoc chưa hoàn thành cần phân công tiếp");
//		        return false;
//		    }
		return true;
	}
//	public boolean valid() {
//		if (txtSLCanLam.getText().trim().equals("")) {
//			JOptionPane.showMessageDialog(null, "Số lượng cần làm không được để trống");
//			txtSLCanLam.requestFocus();
//			return false;
//		}
//		return true;
//	}
	 private void updateMaCongNhanComboBox() throws RemoteException {
	        // Xóa dữ liệu cũ
	        cmbMaCongNhan.removeAllItems();

	        // Lấy danh sách mã công nhân từ CSDL
	        List<String> maCongNhanList = pc_dao.getDSMaCongNhan();
	        
	        // Thêm vào JComboBox
	        for (String maCongNhan : maCongNhanList) {
	            cmbMaCongNhan.addItem(maCongNhan);
	        }
	    }

	    private void updateMaCongDoanComboBox() throws RemoteException {
	        // Xóa dữ liệu cũ
	        cmbCongDoanYC.removeAllItems();

	        // Lấy danh sách mã công đoạn từ CSDL
	        List<CongDoan> CongDoanList = pc_dao.getDSCongDoan();
	        // Thêm vào JComboBox
	        for (CongDoan cd : CongDoanList) {
	            cmbCongDoanYC.addItem(cd.getMaCongDoan().toString());
	        }
	    }
	    
	//
}
