package dao.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.NhanVienDao;
import entity.NhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class NhanVienDaoImpl extends UnicastRemoteObject implements NhanVienDao {

	private static final long serialVersionUID = 5929402348281005333L;
	private EntityManagerFactory emf;

	public NhanVienDaoImpl() throws RemoteException {
		// Khởi tạo EntityManagerFactory
		emf = Persistence.createEntityManagerFactory("jpa-mssql");
	}

	public int getMaxEmployeeNumber() {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		try {
			// Sử dụng JPQL để truy vấn mã nhân viên lớn nhất
			TypedQuery<Integer> query = em.createQuery(
					"SELECT MAX(CAST(SUBSTRING(nv.maNhanVien, 3, LENGTH(nv.maNhanVien) - 2) AS int)) FROM NhanVien nv",
					Integer.class);

			Integer maxEmployeeNumber = query.getSingleResult(); // Thực hiện truy vấn và lấy kết quả

			// Nếu không có kết quả, trả về 0
			if (maxEmployeeNumber == null) {
				return 0;
			}

			return maxEmployeeNumber;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close(); // Đóng EntityManager sau khi sử dụng
		}

		return 0; // Trả về giá trị mặc định nếu có lỗi
	}

	// Viết phương thức thêm 1 nhân viên vào cơ sở dữ liệu trả về boolean
	@Override
	public boolean ThemNhanVien(NhanVien nv) {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			em.persist(nv);

			tx.commit();

			return true;
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close(); // Đóng EntityManager sau khi sử dụng
		}

		return false;

	}

	// Viết phương thức xóa 1 nhân viên khỏi cơ sở dữ liệu trả về boolean
	@Override
	public boolean XoaNhanVien(String maNhanVien) {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			NhanVien nv = em.find(NhanVien.class, maNhanVien);
			em.remove(nv);

			tx.commit();

			return true;
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close(); // Đóng EntityManager sau khi sử dụng
		}
		return false;
	}
	
	// Viết phương thức cập nhật thông tin nhân viên vào cơ sở dữ liệu trả về boolean
	@Override
	public boolean CapNhatNhanVien(NhanVien nv) {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			em.merge(nv);

			tx.commit();

			return true;
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close(); // Đóng EntityManager sau khi sử dụng
		}

		return false;
	}

	// Viết phương thức trả về danh sách nhân viên có trong cơ sở dữ liệu
	@Override
	public List<NhanVien> getDanhSachNhanVien() {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		try {
			// Sử dụng JPQL để truy vấn danh sách nhân viên
			TypedQuery<NhanVien> query = em.createQuery("SELECT nv FROM NhanVien nv", NhanVien.class);

			List<NhanVien> list = query.getResultList(); // Thực hiện truy vấn và lấy kết quả

			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close(); // Đóng EntityManager sau khi sử dụng
		}

		return null; // Trả về giá trị mặc định nếu có lỗi
	}
	
	//Viết phương thức trả về list nhân viên theo mã nhân viên
	@Override
	public List<NhanVien> getNhanVienTheoMa(String maNhanVien) {
	    EntityManager em = emf.createEntityManager(); // Mở EntityManager
	    try {
	        // Sử dụng JPQL để truy vấn nhân viên theo mã nhân viên
	        TypedQuery<NhanVien> query = em.createQuery("SELECT nv FROM NhanVien nv WHERE nv.maNhanVien = :maNhanVien", NhanVien.class);
	        
	        // Đặt giá trị cho tham số ":maNhanVien"
	        query.setParameter("maNhanVien", maNhanVien);
	        
	        List<NhanVien> list = query.getResultList(); // Thực hiện truy vấn và lấy kết quả
	        return list;
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        em.close(); // Đóng EntityManager sau khi sử dụng
	    }
	    return null; // Trả về giá trị mặc định nếu có lỗi
	}

	
	// Viết phương thức trả về thông tin nhân viên theo tên nhân viên trả về list
	@Override
	public List<NhanVien> getNhanVienTheoTen(String tenNhanVien) {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		try {
			// Sử dụng JPQL để truy vấn nhân viên theo tên nhân viên
			TypedQuery<NhanVien> query = em
					.createQuery("SELECT nv FROM NhanVien nv WHERE nv.hoTen = :hoTen", NhanVien.class);
			query.setParameter("hoTen", tenNhanVien);

			List<NhanVien> list = query.getResultList(); // Thực hiện truy vấn và lấy kết quả

			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close(); // Đóng EntityManager sau khi sử dụng
		}

		return null; // Trả về giá trị mặc định nếu có lỗi
	}
	
	// Viết phương thức trả về thông tin nhân viên theo giới tính
	@Override
	public List<NhanVien> getNhanVienTheoGioiTinh(String gioiTinh) {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		try {
			// Sử dụng JPQL để truy vấn nhân viên theo giới tính
			TypedQuery<NhanVien> query = em.createQuery("SELECT nv FROM NhanVien nv WHERE nv.gioiTinh = :gioiTinh",
					NhanVien.class);
			query.setParameter("gioiTinh", gioiTinh);

			List<NhanVien> list = query.getResultList(); // Thực hiện truy vấn và lấy kết quả

			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close(); // Đóng EntityManager sau khi sử dụng
		}

		return null; // Trả về giá trị mặc định nếu có lỗi
	}
	
	
	
            

}
