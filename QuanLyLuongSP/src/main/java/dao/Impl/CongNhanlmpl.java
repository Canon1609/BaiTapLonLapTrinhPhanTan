package dao.Impl;



import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.CongNhanDao;
import entity.CongNhan;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class CongNhanlmpl extends UnicastRemoteObject implements CongNhanDao{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6400740473052409241L;
	private EntityManagerFactory emf;

	public CongNhanlmpl() throws Exception{
		// Khởi tạo EntityManagerFactory
		emf = Persistence.createEntityManagerFactory("jpa-mssql");
	}
	@Override
	public List<CongNhan> getAlltbCongNhan() {
		EntityManager em = emf.createEntityManager(); 
		
		try {
			// Sử dụng JPQL để truy vấn danh sách nhân viên
			TypedQuery<CongNhan> query = em.createQuery("SELECT cn FROM CongNhan cn", CongNhan.class);

			List<CongNhan> list = query.getResultList(); // Thực hiện truy vấn và lấy kết quả

			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close(); // Đóng EntityManager sau khi sử dụng
		}

		return null; // Trả về giá trị mặc định nếu có lỗi
	}


	@Override
	public boolean create(CongNhan cn) {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			em.persist(cn);

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

	@Override
	public int getCNNumber() {
//		EntityManager em = emf.createEntityManager(); // Mở EntityManager
//		try {
//			// Sử dụng JPQL để truy vấn mã nhân viên lớn nhất
//			TypedQuery<Integer> query = em.createQuery(
//					"SELECT MAX(CAST(SUBSTRING(cn.maCongNhan, 3, LEN(cn.maCongNhan) - 2) AS INT)) FROM CongNhan cn",
//					Integer.class);
//
//			Integer maxEmployeeNumber = query.getSingleResult(); // Thực hiện truy vấn và lấy kết quả
//
//			// Nếu không có kết quả, trả về 0
//			if (maxEmployeeNumber == null) {
//				return 0;
//			}
//
//			return maxEmployeeNumber;
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			em.close(); // Đóng EntityManager sau khi sử dụng
//		}
//
//	
		return 0;
	}

	@Override
	public boolean deleteCN(String maCN) {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			CongNhan nv = em.find(CongNhan.class, maCN);
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

	@Override
	public boolean update(CongNhan cn) {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			em.merge(cn);

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

	@Override
	public List<CongNhan> timKiemGT(String gt) {
		EntityManager em = emf.createEntityManager();
		try {
			// Sử dụng JPQL để truy vấn nhân viên theo giới tính
			TypedQuery<CongNhan> query = em.createQuery("SELECT cn FROM CongNhan cn WHERE cn.gioiTinh = :gt",
					CongNhan.class);
			query.setParameter("gt", gt); // Set tham số cho câu truy vấn

			List<CongNhan> list = query.getResultList(); // Thực hiện truy vấn và lấy kết quả

			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close(); // Đóng EntityManager sau khi sử dụng
		}
		return null;
	}

	@Override
	public int getMaxEmployeeNumber() {
		EntityManager em = emf.createEntityManager(); 
		try {
			// Sử dụng JPQL để truy vấn mã nhân viên lớn nhất
			TypedQuery<Integer> query = em.createQuery(
					"SELECT MAX(CAST(SUBSTRING(nv.maCongNhan, 3, LENGTH(nv.maCongNhan) - 2) AS int)) FROM CongNhan nv",
					Integer.class);

			Integer maxEmployeeNumber = query.getSingleResult(); // Thực hiện truy vấn và lấy kết quả
			
			// Nếu không có kết quả, trả về 0
			if (maxEmployeeNumber == null) {
				
				return 1;
			}
			else
			{
				return maxEmployeeNumber;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close(); // Đóng EntityManager sau khi sử dụng
		}

		return 0; // Trả về giá trị mặc định nếu có lỗi
		
	}

	@Override
	public List<CongNhan> timKiemTen(String ten) {
		EntityManager em = emf.createEntityManager();
		try {
			// Sử dụng JPQL để truy vấn nhân viên theo tên
			TypedQuery<CongNhan> query = em.createQuery("SELECT cn FROM CongNhan cn WHERE cn.hoTen = :ten",
					CongNhan.class);
			query.setParameter("ten", ten); // Set tham số cho câu truy vấn

			List<CongNhan> list = query.getResultList(); // Thực hiện truy vấn và lấy kết quả

			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close(); // Đóng EntityManager sau khi sử dụng
		}
		return null;
	}
	


}
