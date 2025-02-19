package dao.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.ThongKe_SP_Dao;
import entity.HopDong;
import entity.LuongNhanVien;
import entity.SanPham;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ThongKe_SP_lmpl extends UnicastRemoteObject implements ThongKe_SP_Dao{
	private static final long serialVersionUID = 5929402348281005543L;
	private EntityManagerFactory emf;
	private EntityManager entityManager;
	public ThongKe_SP_lmpl() throws RemoteException {
		// Khởi tạo EntityManagerFactory
		emf = Persistence.createEntityManagerFactory("jpa-mssql");
	}
	@Override
	public List<SanPham> getTheoMaSP(String ma) throws RemoteException {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		return em.createQuery("select sp from SanPham sp where sp.maSanPham= :ma", SanPham.class)
				.setParameter("ma", ma)
				.getResultList();
	}

	@Override
	public List<SanPham> getTheoTenSP(String ten) throws RemoteException {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		return em.createQuery("select sp from SanPham sp where sp.tenSanPham= :ma", SanPham.class)
				.setParameter("ma", ten)
				.getResultList();
	}

	@Override
	public List<SanPham> getAllSP() throws RemoteException {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		return em.createQuery("select sp from SanPham sp", SanPham.class)
				.getResultList();
	}
public static void main(String[] args) {
	try {
		ThongKe_SP_lmpl s =new ThongKe_SP_lmpl();
		System.out.println(s.getTheoTenSP("San pham A"));
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
@Override
public List<HopDong> getHDTheoMaSP(String ma) throws RemoteException {
	EntityManager em = emf.createEntityManager(); // Mở EntityManager
	return em.createQuery("select hd from HopDong hd where hd.maSanPham.maSanPham = :year", HopDong.class)
			.setParameter("year", ma)
			.getResultList();
}
@Override
public List<SanPham> getMAANDTEN(String ma, String ten) throws RemoteException {
	EntityManager em = emf.createEntityManager(); // Mở EntityManager
	return em.createQuery("select sp from SanPham sp where sp.maSanPham= :ma AND sp.tenSanPham= :ten", SanPham.class)
			.setParameter("ma", ma)
			.setParameter("ten", ten)
			.getResultList();
}

}
