package dao.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import dao.LuonngCongNhanDao;
import entity.LuongCongNhan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class LuongCongNhanlmpl extends UnicastRemoteObject implements LuonngCongNhanDao{
	private EntityManagerFactory emf;

	public LuongCongNhanlmpl() throws RemoteException {
		// Khởi tạo EntityManagerFactory
		emf = Persistence.createEntityManagerFactory("jpa-mssql");
	}
	@Override
	public ArrayList<LuongCongNhan> getAlltbLuongCuaCongNhan() {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		try {
			// Sử dụng JPQL để truy vấn danh sách công nhân viên
			TypedQuery<LuongCongNhan> query = em.createQuery("SELECT ccnv FROM LuongCongNhan ccnv",
					LuongCongNhan.class);
			List<LuongCongNhan> listCongNV = query.getResultList(); // Thực hiện truy vấn và lấy kết quả

			return (ArrayList<LuongCongNhan>)listCongNV;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close(); // Đóng EntityManager sau khi sử dụng
		}
		
		return null;
	}

	@Override
	public boolean create(LuongCongNhan luongCN) {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			em.persist(luongCN);

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
	public boolean delete(String maLuongCN) {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			LuongCongNhan congNV = em.find(LuongCongNhan.class, maLuongCN);
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
	public int getMaxMaLuongCN() {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		try {
			// Sử dụng JPQL để truy vấn mã nhân viên lớn nhất, mã công nhân viên ví dụ: C01, C02, C03,...
			TypedQuery<Integer> query = em.createQuery(
					"SELECT MAX(CAST(SUBSTRING(ccnv.maLuongCongNhan, 2, LENGTH(ccnv.maLuongCongNhan) - 1) AS int)) FROM LuongCongNhan ccnv",
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
	public static void main(String[] args) {
		try {
			LuongCongNhanlmpl l =new LuongCongNhanlmpl();
			System.out.println(l.getMaxMaLuongCN());
			LuongCongNhan luong =new LuongCongNhan();
			l.create(luong);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
