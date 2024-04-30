package dao.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.naming.CommunicationException;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import dao.ThongKe_HD_Dao;
import dao.ThongKe_NV_Dao;
import entity.HopDong;
import entity.LuongNhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ThongKe_NV_Daolmpl extends UnicastRemoteObject implements ThongKe_NV_Dao{
	private static final long serialVersionUID = 5929402348281005343L;
	private EntityManagerFactory emf;
	private EntityManager entityManager;
	public ThongKe_NV_Daolmpl() throws RemoteException {
		// Khởi tạo EntityManagerFactory
		emf = Persistence.createEntityManagerFactory("jpa-mssql");
	}
	@Override
	public List<LuongNhanVien> getmatbLuongNhanVien(String Ma) throws RemoteException {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		return em.createQuery("select lnv from LuongNhanVien lnv where lnv.maNhanVien.maNhanVien = :year", LuongNhanVien.class)
				.setParameter("year", Ma)
				.getResultList();
		
	}

	@Override
	public List<LuongNhanVien> timKiemNgayLMonth(String Year) throws RemoteException {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		return em.createQuery("select lnv from LuongNhanVien lnv where lnv.ThangNhan = :year", LuongNhanVien.class)
				.setParameter("year", Year)
				.getResultList();
	}

	@Override
	public List<LuongNhanVien> timKiemNgayLYear(String month) throws RemoteException {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		return em.createQuery("select lnv from LuongNhanVien lnv where lnv.NamNhan = :year", LuongNhanVien.class)
				.setParameter("year", month)
				.getResultList();
	}

	@Override
	public List<LuongNhanVien> timKiemMonthMaHD(String date, String ma) throws RemoteException {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		return em.createQuery("select lnv from LuongNhanVien lnv where lnv.ThangNhan = :year AND lnv.maNhanVien.maNhanVien = :ma", LuongNhanVien.class)
				.setParameter("year", date)
				.setParameter("ma", ma)
				.getResultList();
	}

	@Override
	public List<LuongNhanVien> timKiemMonthYear(String date, String year) throws RemoteException {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		return em.createQuery("select lnv from LuongNhanVien lnv where lnv.ThangNhan = :year AND lnv.NamNhan = :ma", LuongNhanVien.class)
				.setParameter("year", date)
				.setParameter("ma", year)
				.getResultList();
	}

	@Override
	public List<LuongNhanVien> timKiemYearMaHD(String year, String ma) throws RemoteException {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		return em.createQuery("select lnv from LuongNhanVien lnv where lnv.NamNhan = :year AND lnv.maNhanVien.maNhanVien = :ma", LuongNhanVien.class)
				.setParameter("year", year)
				.setParameter("ma", ma)
				.getResultList();
	}

	@Override
	public List<LuongNhanVien> timKiem(String date, String year, String ma) throws RemoteException {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		return em.createQuery("select lnv from LuongNhanVien lnv where lnv.ThangNhan = :date AND lnv.NamNhan = :year AND lnv.maNhanVien.maNhanVien = :ma", LuongNhanVien.class)
				.setParameter("date", date)
				.setParameter("year", year)
				.setParameter("ma", ma)
				.getResultList();
	}
	public static void main(String[] args) {
		try {
			ThongKe_NV_Daolmpl h =new ThongKe_NV_Daolmpl();
			List<LuongNhanVien> list =h.getmatbLuongNhanVien("NV01");
			
				System.out.println(list);
			
			for (LuongNhanVien hopDong : list) {
				System.out.println(hopDong);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
