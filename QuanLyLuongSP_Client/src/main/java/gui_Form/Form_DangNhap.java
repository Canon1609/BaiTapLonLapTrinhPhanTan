package gui_Form;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client.Client;
import entity.TaiKhoan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.Label;

import dao.Impl.DangNhapDaoImpl;
import dao.DangNhapDao;

public class Form_DangNhap extends JFrame {
	private JTextField txttaiKhoan;
	private JPasswordField passwordField;
	private JPasswordField txtPass;
	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction tx;
	private static Client client = new Client();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_DangNhap frame = new Form_DangNhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Form_DangNhap() {
		client = Client.getInstance();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(TrangChu.class.getResource("/img/ungdung.png")));
		setBounds(100, 100, 841, 446);
		this.setTitle("Đăng Nhập");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbltieuDe = new JLabel("ĐĂNG NHẬP HỆ THỐNG QUẢN LÝ LƯƠNG SẢN PHẨM");
		lbltieuDe.setForeground(new Color(0, 255, 0));
		lbltieuDe.setFont(new Font("Arial", Font.BOLD, 20));
		lbltieuDe.setBounds(185, 10, 529, 29);
		contentPane.add(lbltieuDe);
		
		JLabel lbltenDangNhap = new JLabel("Tài Khoản:");
		lbltenDangNhap.setFont(new Font("Arial", Font.BOLD, 11));
		lbltenDangNhap.setBounds(530, 95, 58, 14);
		contentPane.add(lbltenDangNhap);
		
		JLabel lblmatKhau = new JLabel("Mật Khẩu:");
		lblmatKhau.setFont(new Font("Arial", Font.BOLD, 11));
		lblmatKhau.setBounds(531, 145, 57, 22);
		contentPane.add(lblmatKhau);
		
		txttaiKhoan = new JTextField();
		txttaiKhoan.setBounds(598, 89, 175, 28);
		contentPane.add(txttaiKhoan);
		txttaiKhoan.setColumns(10);
		
		JCheckBox chckhienMatKhau = new JCheckBox("Hiển Thị Mật Khẩu");
		chckhienMatKhau.setFont(new Font("Arial", Font.BOLD, 11));
		chckhienMatKhau.setBounds(646, 202, 127, 29);
		contentPane.add(chckhienMatKhau);
        chckhienMatKhau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chckhienMatKhau.isSelected()) {
                    txtPass.setEchoChar((char) 0); 
                } else {
                    txtPass.setEchoChar('*'); 
                }
            }
        });
		
        txtPass = new JPasswordField();
        txtPass.setBounds(598, 142, 175, 29);
        contentPane.add(txtPass);

		
		
		JButton btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setBackground(new Color(128, 255, 128));
		btnDangNhap.setBounds(575, 253, 99, 34);
		contentPane.add(btnDangNhap);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setBackground(new Color(255, 128, 128));
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThoat.setBounds(684, 253, 89, 34);
		contentPane.add(btnThoat);
		
		JLabel AnhNen = new JLabel("");
		AnhNen.setIcon(new ImageIcon(Form_DangNhap.class.getResource("/img/AnhLogin.jpg")));
		AnhNen.setBounds(0, 0, 827, 50);
		contentPane.add(AnhNen);
		
		JLabel Nen1 = new JLabel("");
		Nen1.setBounds(72, 178, 46, 14);
		contentPane.add(Nen1);
		
		JLabel lblAnhNen = new JLabel("");
		lblAnhNen.setIcon(new ImageIcon(Form_DangNhap.class.getResource("/img/trangchu - Copy.jpg")));
		lblAnhNen.setFont(new Font("Arial", Font.BOLD, 11));
		lblAnhNen.setBounds(10, 60, 500, 339);
		contentPane.add(lblAnhNen);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-mssql");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();

        btnDangNhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DangNhapDao dn_dao = new DangNhapDaoImpl();
                    tx.begin();

                    // Thực hiện truy vấn để tìm kiếm tài khoản
                    List<TaiKhoan> danhSachTaiKhoan = dn_dao.TimKiem(txttaiKhoan.getText(), txtPass.getText());
                    // in  ra danh sách tài khoản
                    System.out.println(danhSachTaiKhoan);

                    if (!txttaiKhoan.getText().isEmpty() && txtPass.getPassword().length > 0) {
                        if (danhSachTaiKhoan != null && !danhSachTaiKhoan.isEmpty()) {
                            // Nếu có tài khoản tồn tại
                            JOptionPane.showMessageDialog(null, "Đăng nhập hệ thống thành công");
                            TrangChu tc = new TrangChu();
                            tc.setVisible(true);
                            setVisible(false);
                        } else {
                            // Nếu không tìm thấy tài khoản
                            JOptionPane.showMessageDialog(null, "Thông tin tài khoản hoặc mật khẩu không chính xác");
                            txttaiKhoan.setText("");
                            txtPass.setText("");
                            txttaiKhoan.requestFocus();
                        }
                    } else {
                        // Nếu chưa nhập thông tin đăng nhập
                        JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin");
                    }

                    tx.commit();
                } catch (Exception ex) {
                    // Xử lý ngoại lệ nếu có
                    if (tx != null && tx.isActive()) {
                        tx.rollback();
                    }
                    ex.printStackTrace();
                } finally {
                    // Đóng EntityManager
                    em.close();
                }
            }
        });

        // Kiểm tra phím "Enter" trên trường mật khẩu
        txtPass.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnDangNhap.doClick();
                }
            }
        });

        btnThoat.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thoát không?",
                        "Xác nhận thoát", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    System.exit(0); // Đóng ứng dụng nếu người dùng chọn "Có"
                }

            }
        });
        //
    }
}