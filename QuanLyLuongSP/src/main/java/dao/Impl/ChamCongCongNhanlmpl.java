package dao.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.ChamCongCongNhanDao;
import entity.CongCuaCongNhan;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class ChamCongCongNhanlmpl extends UnicastRemoteObject implements ChamCongCongNhanDao{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9186046784410094386L;
	private EntityManagerFactory emf;

	public ChamCongCongNhanlmpl() throws RemoteException {
		// Khởi tạo EntityManagerFactory
		emf = Persistence.createEntityManagerFactory("jpa-mssql");
	}
	@Override
	public List<CongCuaCongNhan> getAlltbCongCuaCongNhan() {
		
			EntityManager em = emf.createEntityManager(); // Mở EntityManager
			try {
				// Sử dụng JPQL để truy vấn danh sách công nhân viên
				TypedQuery<CongCuaCongNhan> query = em.createQuery("SELECT ccnv FROM CongCuaCongNhan ccnv",
						CongCuaCongNhan.class);
				List<CongCuaCongNhan> listCongNV = query.getResultList(); // Thực hiện truy vấn và lấy kết quả

				return listCongNV;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				em.close(); // Đóng EntityManager sau khi sử dụng
			}
			
		return null;
	}

	@Override
	public boolean create(CongCuaCongNhan congCN) {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			em.persist(congCN);

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
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		try {
			// Sử dụng JPQL để truy vấn mã nhân viên lớn nhất, mã công nhân viên ví dụ: C01, C02, C03,...
			TypedQuery<Integer> query = em.createQuery(
					"SELECT MAX(CAST(SUBSTRING(ccnv.maCongCuaCongNhan, 2, LENGTH(ccnv.maCongCuaCongNhan) - 1) AS int)) FROM CongCuaCongNhan ccnv",
					Integer.class);
			Integer maxMaCongNV = query.getSingleResult(); // Thực hiện truy vấn và lấy kết quả
			
			// Nếu không có kết quả, trả về 0
			if (maxMaCongNV == null) {
				return 0;
			}
			return maxMaCongNV;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close(); // Đóng EntityManager sau khi sử dụng
		}
		return 0;
	}

	@Override
	public boolean delete(String maCongCN) {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			CongCuaCongNhan congNV = em.find(CongCuaCongNhan.class, maCongCN);
			em.remove(congNV);

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
	public int getMaxMaCongCN() {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		try {
			// Sử dụng JPQL để truy vấn mã nhân viên lớn nhất, mã công nhân viên ví dụ: C01, C02, C03,...
			TypedQuery<Integer> query = em.createQuery(
					"SELECT MAX(CAST(SUBSTRING(ccnv.maCongCN, 2, LENGTH(ccnv.maCongCN) - 1) AS int)) FROM CongCuaCongNhan ccnv",
					Integer.class);
			Integer maxMaCongNV = query.getSingleResult(); // Thực hiện truy vấn và lấy kết quả
			
			// Nếu không có kết quả, trả về 0
			if (maxMaCongNV == null) {
				return 1;
			}
			return maxMaCongNV;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close(); // Đóng EntityManager sau khi sử dụng
		}
		return 100;
	}
	public static void main(String[] args) {
		try {
			ChamCongCongNhanlmpl c =new ChamCongCongNhanlmpl();
			int n =c.getMaxMaCongCN();
			System.out.println(n);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
