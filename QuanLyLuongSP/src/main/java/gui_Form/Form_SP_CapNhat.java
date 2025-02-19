package gui_Form;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.Color;
import javax.swing.Box;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import com.toedter.components.JSpinField;

import dao.Impl.SanPhamDAOImpl;
import entity.SanPham;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;



public class Form_SP_CapNhat extends JPanel {
	private JTable table;
	private JTextField txtMaSanPham;
	private JTextField txtKieuDang;
	private JTextField txtTenSanPham;
	private JTextField txtChatLieu;
	private DefaultTableModel tableModel;
	private JSpinField jsfSoLuong;
	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction tx;
	private SanPhamDAOImpl sp_dao;

	/**
	 * Create the panel.
	 * @throws RemoteException 
	 */
	public Form_SP_CapNhat() throws RemoteException {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pnNorth = new JPanel();
		add(pnNorth, BorderLayout.NORTH);
		
		JLabel lblSanPham = new JLabel("SẢN PHẨM");
		lblSanPham.setForeground(Color.RED);
		lblSanPham.setFont(new Font("Arial", Font.BOLD, 16));
		pnNorth.add(lblSanPham);
		
		JPanel pnCenter = new JPanel();
		pnCenter.setPreferredSize(new Dimension(1200, 210));
		add(pnCenter, BorderLayout.CENTER);
		
		JPanel pnNhap = new JPanel();
		pnNhap.setPreferredSize(new Dimension(1200, 150));
		pnNhap.setBorder(new TitledBorder(null, "Th\u00F4ng Tin S\u1EA3n Ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnCenter.add(pnNhap);
		
		Box box1 = Box.createVerticalBox();
		pnNhap.add(box1);
		
		Box boxMaSanPham = Box.createHorizontalBox();
		box1.add(boxMaSanPham);
		
		JLabel lblMaSanPham = new JLabel("Mã Sản Phẩm :");
		lblMaSanPham.setFont(new Font("Arial", Font.BOLD, 14));
		boxMaSanPham.add(lblMaSanPham);
		
		txtMaSanPham = new JTextField();
		txtMaSanPham.setPreferredSize(new Dimension(7, 30));
		txtMaSanPham.setEditable(false);
		txtMaSanPham.setColumns(20);
		boxMaSanPham.add(txtMaSanPham);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setPreferredSize(new Dimension(0, 50));
		box1.add(verticalStrut);
		
		Box boxKieuDang = Box.createHorizontalBox();
		box1.add(boxKieuDang);
		
		JLabel lblKieuDang = new JLabel("Kiểu Dáng :");
		lblKieuDang.setFont(new Font("Arial", Font.BOLD, 14));
		boxKieuDang.add(lblKieuDang);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		boxKieuDang.add(horizontalStrut);
		
		txtKieuDang = new JTextField();
		txtKieuDang.setPreferredSize(new Dimension(7, 30));
		boxKieuDang.add(txtKieuDang);
		txtKieuDang.setColumns(20);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		horizontalStrut_2.setPreferredSize(new Dimension(60, 0));
		pnNhap.add(horizontalStrut_2);
		
		Box box2 = Box.createVerticalBox();
		pnNhap.add(box2);
		
		Box boxTenSanPham = Box.createHorizontalBox();
		box2.add(boxTenSanPham);
		
		JLabel lblTenSanPham = new JLabel("Tên Sản Phẩm :");
		lblTenSanPham.setFont(new Font("Arial", Font.BOLD, 14));
		boxTenSanPham.add(lblTenSanPham);
		
		txtTenSanPham = new JTextField();
		txtTenSanPham.setPreferredSize(new Dimension(7, 30));
		boxTenSanPham.add(txtTenSanPham);
		txtTenSanPham.setColumns(20);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalStrut_1.setPreferredSize(new Dimension(0, 50));
		box2.add(verticalStrut_1);
		
		Box boxChatLieu = Box.createHorizontalBox();
		box2.add(boxChatLieu);
		
		JLabel lblChatLieu = new JLabel("Chất Liệu :");
		lblChatLieu.setFont(new Font("Arial", Font.BOLD, 14));
		boxChatLieu.add(lblChatLieu);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setPreferredSize(new Dimension(33, 0));
		boxChatLieu.add(horizontalStrut_1);
		
		txtChatLieu = new JTextField();
		txtChatLieu.setPreferredSize(new Dimension(7, 30));
		boxChatLieu.add(txtChatLieu);
		txtChatLieu.setColumns(20);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		horizontalStrut_3.setPreferredSize(new Dimension(60, 0));
		pnNhap.add(horizontalStrut_3);
		
		Box box3 = Box.createVerticalBox();
		pnNhap.add(box3);
		
		Box boxSoLuong = Box.createHorizontalBox();
		box3.add(boxSoLuong);
		
		JLabel lblSoLuong = new JLabel("Số Lượng ");
		lblSoLuong.setFont(new Font("Arial", Font.BOLD, 14));
		boxSoLuong.add(lblSoLuong);
		
		jsfSoLuong = new JSpinField();
		jsfSoLuong.getSpinner().setPreferredSize(new Dimension(30, 40));
		jsfSoLuong.setPreferredSize(new Dimension(100, 29));
		boxSoLuong.add(jsfSoLuong);
		
		JPanel pnChucNang = new JPanel();
		pnChucNang.setPreferredSize(new Dimension(1000, 50));
		pnCenter.add(pnChucNang);
		
		JButton btnThemSanPham = new JButton("Thêm Sản Phẩm");
		btnThemSanPham.setIcon(new ImageIcon(Form_SP_CapNhat.class.getResource("/img/Graphicloads-Colorful-Long-Shadow-Cart-add.256 (1).png")));
		btnThemSanPham.setBackground(Color.ORANGE);
		btnThemSanPham.setFont(new Font("Arial", Font.BOLD, 14));
		pnChucNang.add(btnThemSanPham);
		
		JButton btnXoaSanPham = new JButton("Xóa Sản Phẩm");
		btnXoaSanPham.setBackground(Color.CYAN);
		btnXoaSanPham.setIcon(new ImageIcon(Form_SP_CapNhat.class.getResource("/img/Custom-Icon-Design-Flatastic-11-Shopping-basket-remove.512 (2).png")));
		btnXoaSanPham.setFont(new Font("Arial", Font.BOLD, 14));
		pnChucNang.add(btnXoaSanPham);
		
		JButton btnSuaThongTin = new JButton("Sửa Thông Tin");
		btnSuaThongTin.setBackground(Color.GREEN);
		btnSuaThongTin.setIcon(new ImageIcon(Form_SP_CapNhat.class.getResource("/img/fixinfomation.png")));
		btnSuaThongTin.setFont(new Font("Arial", Font.BOLD, 14));
		pnChucNang.add(btnSuaThongTin);
		
		JButton btnXoaRong = new JButton("Xóa Rỗng");
		btnXoaRong.setIcon(new ImageIcon(Form_SP_CapNhat.class.getResource("/img/xoarong.png")));
		btnXoaRong.setBackground(Color.MAGENTA);
		btnXoaRong.setFont(new Font("Arial", Font.BOLD, 14));
		pnChucNang.add(btnXoaRong);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setBackground(Color.RED);
		btnThoat.setIcon(new ImageIcon(Form_SP_CapNhat.class.getResource("/img/exit.png")));
		btnThoat.setFont(new Font("Arial", Font.BOLD, 14));
		pnChucNang.add(btnThoat);
		
		JPanel pnSouth = new JPanel();
		pnSouth.setPreferredSize(new Dimension(1200, 420));
		pnSouth.setBorder(new TitledBorder(null, "Danh S\u00E1ch S\u1EA3n Ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(pnSouth, BorderLayout.SOUTH);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(1100, 380));
		pnSouth.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 S\u1EA3n Ph\u1EA9m", "T\u00EAn S\u1EA3n Ph\u1EA9m", "Ki\u1EC3u D\u00E1ng", "Ch\u1EA5t Li\u1EC7u", "S\u1ED1 L\u01B0\u1EE3ng"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			
			boolean[] columnEditables = new boolean[] {false, false, false, false,false};

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setFont(new Font("Arial", Font.PLAIN, 10));

		/* XỬ LÝ TỪ ĐÂY*/
		tableModel = (DefaultTableModel) table.getModel();
		String[] columnNames = { "Mã Sản Phẩm", "Tên Sản Phẩm", "Kiểu Dáng", "Chất Liệu", "Số Lượng"};
		tableModel.setColumnIdentifiers(columnNames);
		

        sp_dao = new SanPhamDAOImpl();



		btnThemSanPham.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        if(valid()) {
		            // Lấy thông tin từ các trường nhập liệu
		            String tenSanPham = txtTenSanPham.getText().trim();
		            String kieuDang = txtKieuDang.getText().trim();
		            String chatLieu = txtChatLieu.getText().trim();
		            
		            // Xử lý số lượng
		            int soLuong = jsfSoLuong.getValue();
		            
		            // Lấy mã sản phẩm mới từ cơ sở dữ liệu
		            int maxSPNumber = sp_dao.getMaxSPNumber(); 
		            int nextSPNumber = maxSPNumber + 1;
		            String ma = String.format("SP%02d", nextSPNumber);
		            
		            // Tạo đối tượng Sản Phẩm mới
		            SanPham sp = new SanPham(ma, tenSanPham, kieuDang, chatLieu, soLuong);
		            
		            // Thêm sản phẩm mới vào cơ sở dữ liệu
		            boolean success = sp_dao.ThemSanPham(sp);
		            
		            if(success)
		            {
		            	//Thêm dòng mới vào bảng hiển thị
			            tableModel.addRow(new Object[] {ma, tenSanPham, kieuDang, chatLieu, soLuong});
			            
			            JOptionPane.showMessageDialog(null, "Thêm sản phẩm thành công");
			            
			            // Xóa nội dung của các trường nhập liệu sau khi thêm
			            txtMaSanPham.setText("");
			            txtMaSanPham.requestFocus();
			            txtTenSanPham.setText("");
			            txtChatLieu.setText("");
			            jsfSoLuong.setValue(0);
			        } else {
			            JOptionPane.showMessageDialog(null, "Thêm sản phẩm không thành công");
			        }
		         } else {
		        	 JOptionPane.showMessageDialog(null, "Thông tin nhập không hợp lệ");
		         }
		    }
		});
		

		// Xóa Sản phẩm
		btnXoaSanPham.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        int selectedRow = table.getSelectedRow();
		        if(selectedRow < 0) {
		            JOptionPane.showMessageDialog(null, "Chọn sản phẩm cần xóa");
		        } else {
		            // Lấy mã sản phẩm từ dòng được chọn trong bảng
					String maSP = (String) table.getValueAt(selectedRow, 0);
					
					// Gọi phương thức xóa sản phẩm từ DAO
					String result = sp_dao.XoaSanPham(maSP);
					
					if(result.equals("Xóa sản phẩm thành công")) {
					    tableModel.removeRow(selectedRow); 
					    JOptionPane.showMessageDialog(null, result); 
					} else {
					    JOptionPane.showMessageDialog(null, result); 
					}
		        }
		    } 
		});
		
		// Sửa thông tin sản phẩm
		btnSuaThongTin.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        int selectedRow = table.getSelectedRow();
		        if (selectedRow < 0) {
		            JOptionPane.showMessageDialog(null, "Chọn một sản phẩm trong bảng để sửa.");
		            return;
		        }

		        // Lấy thông tin sản phẩm từ dòng được chọn trong bảng
		        String maSP = (String) table.getValueAt(selectedRow, 0);
		        String tenSP = txtTenSanPham.getText().trim();
		        String kieuDang = txtKieuDang.getText().trim();
		        String chatLieu = txtChatLieu.getText().trim();
		        // Xử lý số lượng
		        int soLuong = jsfSoLuong.getValue();
		        // Lấy thông tin sản phẩm hiện tại từ bảng
		        String tenSPTable = (String) table.getValueAt(selectedRow, 1);
		        String kieuDangTable = (String) table.getValueAt(selectedRow, 2);
		        String chatLieuTable = (String) table.getValueAt(selectedRow, 3);
		        int soLuongTable = (int) table.getValueAt(selectedRow, 4);

		        // Chỉ cập nhật thông tin sản phẩm nếu có sự thay đổi
		        if (!tenSP.equals(tenSPTable) || !kieuDang.equals(kieuDangTable) || !chatLieu.equals(chatLieuTable) || soLuong != soLuongTable) {
		            // Tạo đối tượng Sản Phẩm mới
		            SanPham sp = new SanPham(maSP, tenSP, kieuDang, chatLieu, soLuong);

		            // Gọi phương thức DAO để cập nhật thông tin sản phẩm
		            boolean updated = sp_dao.CapNhatSanPham(sp);

		            if (updated) {
		                // Cập nhật lại thông tin trong bảng
		                tableModel.setValueAt(tenSP, selectedRow, 1);
		                tableModel.setValueAt(kieuDang, selectedRow, 2);
		                tableModel.setValueAt(chatLieu, selectedRow, 3);
		                tableModel.setValueAt(soLuong, selectedRow, 4);
		                JOptionPane.showMessageDialog(null, "Cập nhật thông tin sản phẩm thành công");
		            } else {
		                JOptionPane.showMessageDialog(null, "Cập nhật thông tin sản phẩm thất bại");
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "Không có thay đổi để cập nhật");
		        }
		    }
		});
		
		// Xóa rỗng
		btnXoaRong.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Đặt giá trị của các trường nhập liệu về rỗng hoặc giá trị mặc định
		        txtMaSanPham.setText("");
		        txtTenSanPham.setText("");
		        txtKieuDang.setText("");
		        txtChatLieu.setText("");
		        jsfSoLuong.setValue(0);
		    }
		});
		
		// Thoát
		btnThoat.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        setVisible(false); // Chỉ ẩn cửa sổ, không giải phóng tài nguyên
		    }
		});
		
//		// Đưa dữ liệu từ bảng lên các trường nhập liệu khi click vào một dòng trong bảng
		table.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        int row = table.getSelectedRow();
		        if (row >= 0) {
		            String maSP = (String) table.getValueAt(row, 0);
		            String tenSP = (String) table.getValueAt(row, 1);
		            String kieuDang = (String) table.getValueAt(row, 2);
		            String chatLieu = (String) table.getValueAt(row, 3);
		            int soLuong = (int) table.getValueAt(row, 4);

		            txtMaSanPham.setText(maSP);
		            txtTenSanPham.setText(tenSP);
		            txtKieuDang.setText(kieuDang);
		            txtChatLieu.setText(chatLieu);
		            jsfSoLuong.setValue(soLuong);

		        }
		    }
		});
		
		// khởi tạo kết nối đến CSDL
//		try {
//			Conection_DB.getInstance().connect();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		sp_dao = new DAO_SanPham();
		DocDuLieuDBVaoTableSanPham();
//		
//		// THÊM NHÂN VIÊN
//		btnThemSanPham.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if(valid()) {
//					int maxSPNumber = sp_dao.getMaxProductNumberNumber(); 
//					// Tăng giá trị mã sản phẩm lớn nhất lên 1
//					int nextSPNumber = maxSPNumber + 1;
//					// Định dạng số thứ tự thành chuỗi với độ dài 2 và tạo mã sản phẩm
//					String ma = String.format("SP%02d", nextSPNumber);
//
//			        // Gán mã nhân viên đã tạo vào trường nhập liệu
//			        txtMaSanPham.setText(ma);
//					String tenSanPham = txtTenSanPham.getText().trim();
//					String kieuDang = txtKieuDang.getText().trim();
//					String chatLieu = txtChatLieu.getText().trim();
//					
//					// Xử lý số lượng
//					int soLuong = jsfSoLuong.getValue();
//					
//					SanPham sp = new SanPham(ma, tenSanPham, kieuDang, chatLieu, soLuong);
//					sp_dao.create(sp);
//					tableModel.addRow(new Object[] {sp.getMaSanPham(),sp.getTenSanPham(),sp.getKieuDang(),sp.getChatLieu(),sp.getSoLuong()});
//					JOptionPane.showMessageDialog(null, "Thêm sản phẩm thành công");
//					// Xóa nội dung của các trường nhập liệu sau khi thêm
//					txtMaSanPham.setText("");
//					txtMaSanPham.requestFocus();
//					txtTenSanPham.setText("");
//					txtChatLieu.setText("");
//					jsfSoLuong.validate();
//				}else {
//					JOptionPane.showMessageDialog(null, "Thêm sản phẩm không thành công");
//				}
//			}
//		});
//		//XÓA Sản phẩm
//		btnXoaSanPham.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				int row = table.getSelectedRow();
//				if(row < 0) {
//					JOptionPane.showMessageDialog(null, "Chọn sản phẩm cần xóa");
//				}else {
//					String maSP = (String) table.getValueAt(row, 0);
//					sp_dao.deleteSP(maSP);
//					tableModel.removeRow(row); 
//					JOptionPane.showMessageDialog(null, "Xóa sản phẩm thành công"); 
//				}
//			} 
//		}); 
//		//SỬA Sản phẩm
//		btnSuaThongTin.addActionListener(new ActionListener() {
//		    @Override
//		    public void actionPerformed(ActionEvent e) {
//		        int selectedRow = table.getSelectedRow();
//		        if (selectedRow < 0) {
//		            JOptionPane.showMessageDialog(null, "Chọn một sản phẩm trong bảng để sửa.");
//		            return;
//		        }
//
//		        // Lấy thông tin sản phẩm từ dòng được chọn trong bảng
//		        String maSP = txtMaSanPham.getText().trim();
//		        String tenSP = txtTenSanPham.getText().trim();
//		        String kieuDang = txtKieuDang.getText().trim();
//		        String chatLieu = txtChatLieu.getText().trim();
//		        // Xử lý số lượng
//		        int soLuong = jsfSoLuong.getValue();
//		        // Tạo đối tượng NhanVien mới
//		        SanPham sp = new SanPham(maSP, tenSP, kieuDang, chatLieu, soLuong);
//		        // Gọi phương thức DAO để cập nhật thông tin nhân viên
//		        boolean updated = sp_dao.update(sp);
//
//		        if (updated) {
//		            // Cập nhật lại thông tin trong bảng
//		            tableModel.setValueAt(tenSP, selectedRow, 1);
//		            tableModel.setValueAt(kieuDang, selectedRow, 2);
//		            tableModel.setValueAt(chatLieu, selectedRow, 3);
//		            tableModel.setValueAt(soLuong, selectedRow, 4);
//		            JOptionPane.showMessageDialog(null, "Cập nhật thông tin sản phẩm thành công");
//		        } else {
//		            JOptionPane.showMessageDialog(null, "Cập nhật thông tin sản phẩm thất bại");
//		        }
//		    }
//		});
//		
//		// XÓA RỖNG
//		btnXoaRong.addActionListener(new ActionListener() {
//		    @Override
//		    public void actionPerformed(ActionEvent e) {
//		        // Đặt giá trị của các trường nhập liệu về rỗng hoặc giá trị mặc định
//		        txtMaSanPham.setText("");
//		        txtTenSanPham.setText("");
//		        txtKieuDang.setText("");
//		        txtChatLieu.setText("");
//		        jsfSoLuong.setValue(0);
//		    }
//		});
//		
//		//THOÁT
//		btnThoat.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
//			}
//		});
//		// Đưa dữ liệu từ bảng lên các trường nhập liệu khi click vào một dòng trong bảng
//				table.addMouseListener(new MouseAdapter() {
//				    @Override
//				    public void mouseClicked(MouseEvent e) {
//				        int row = table.getSelectedRow();
//				        if (row >= 0) {
//				            String maSP = (String) table.getValueAt(row, 0);
//				            String tenSP = (String) table.getValueAt(row, 1);
//				            String kieuDang = (String) table.getValueAt(row, 2);
//				            String chatLieu = (String) table.getValueAt(row, 3);
//				            String soLuong = (String) table.getValueAt(row, 4).toString();
//
//				            txtMaSanPham.setText(maSP);
//				            txtTenSanPham.setText(tenSP);
//				            txtKieuDang.setText(kieuDang);
//				            txtChatLieu.setText(chatLieu);
//				            jsfSoLuong.setValue(0);
//
//				        }
//				    }
//				});
//
//				/////////////////
	}
//	CHƯA LÀM ĐƯỢC
	public void DocDuLieuDBVaoTableSanPham() {
		List<SanPham> list = sp_dao.getDanhSachSanPham();
		for (SanPham sp : list) {
			tableModel.addRow(new Object[] {sp.getMaSanPham(),sp.getTenSanPham(),sp.getKieuDang(),sp.getChatLieu(),sp.getSoLuong()});
		}
	}
	public boolean valid() {
//	    if (txtTenSanPham.getText().equals("") || txtKieuDang.getText().equals("") || txtChatLieu.getText().equals("") ) 
//	    {
//	        JOptionPane.showMessageDialog(null, "Không được rỗng !!!");
//	        return false;
//	    }
//	    if(jsfSoLuong.getValue() <= 0) {
//	    	JOptionPane.showMessageDialog(null, "Chưa nhập số lượng");
//	        return false;
//	    }
//	    
//	    if (!(txtTenSanPham.getText().matches("[\\p{L}' ]+"))) {
//	        JOptionPane.showMessageDialog(null, "Tên sản phẩm theo mẫu: Giày thể thao");
//	        txtTenSanPham.requestFocus();
//	        return false;
//	    }
//
//	    if (!(txtKieuDang.getText().matches("[\\p{L},' ]+"))) {
//	        JOptionPane.showMessageDialog(null, "Kiểu dáng sản phẩm theo mẫu: to");
//	        txtKieuDang.requestFocus();
//	        return false;
//	    }
//
//	    if (!(txtChatLieu.getText().matches("[\\p{L}0-9' ]+"))) {
//	        JOptionPane.showMessageDialog(null, "Chất liệu sản phẩm theo mẫu: vải cao cấp");
//	        txtChatLieu.requestFocus();
//	        return false;
//	    }

	    return true;
	}
	//
}
