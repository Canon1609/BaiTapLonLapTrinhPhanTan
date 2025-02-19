package dao.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.LuongNhanVienDao;
import entity.LuongNhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class LuongNhanVienDaoImpl extends UnicastRemoteObject implements LuongNhanVienDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3091377733054205270L;
	private EntityManagerFactory emf;

	public LuongNhanVienDaoImpl() throws RemoteException {
		// Khởi tạo EntityManagerFactory
		emf = Persistence.createEntityManagerFactory("jpa-mssql");
	}

	public int getMaxSalaryId() {
	    EntityManager em = emf.createEntityManager(); // Mở EntityManager
	    try {
	        // Sử dụng JPQL để truy vấn mã lương lớn nhất có dạng L01, L02, L03,...
	        TypedQuery<Integer> query = em.createQuery(
	            "SELECT MAX(CAST(SUBSTRING(maLuongNhanVien, 3, LENGTH(maLuongNhanVien) - 2) AS INTEGER)) FROM LuongNhanVien",
	            Integer.class);
	        
	        Integer maxSalaryId = query.getSingleResult(); // Thực hiện truy vấn và lấy kết quả
	        
	        // Nếu không có kết quả, trả về 0
	        return maxSalaryId != null ? maxSalaryId : 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        em.close(); // Đóng EntityManager sau khi sử dụng
	    }
	    return 0;
	}


	public boolean tinhLuongNhanVien(LuongNhanVien luongNV) {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		jakarta.persistence.EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			em.persist(luongNV);

			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean xoaLuongNhanVien(String maLuong) {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		jakarta.persistence.EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			em.remove(em.find(LuongNhanVien.class, maLuong));

			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	//Lấy tất cả danh sách	lương nhân viên trả về list
	public List<LuongNhanVien> getDanhSachLuongNhanVien() {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		try {
			// Sử dụng JPQL để truy vấn danh sách lương nhân viên
			jakarta.persistence.TypedQuery<LuongNhanVien> query = em.createQuery("SELECT lnv FROM LuongNhanVien lnv",
					LuongNhanVien.class);
			return query.getResultList(); // Thực hiện truy vấn và trả về danh sách lương nhân viên
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close(); // Đóng EntityManager sau khi sử dụng
		}
		return null;
	}
	
	

}
