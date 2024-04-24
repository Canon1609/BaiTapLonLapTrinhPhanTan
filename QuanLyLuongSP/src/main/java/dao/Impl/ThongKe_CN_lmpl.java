package dao.Impl;

import java.rmi.RemoteException;
import java.util.List;

import dao.ThongKe_CN_Dao;
import entity.LuongCongNhan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ThongKe_CN_lmpl implements ThongKe_CN_Dao{
	private EntityManagerFactory emf;

	public ThongKe_CN_lmpl() throws RemoteException {
		// Khởi tạo EntityManagerFactory
		emf = Persistence.createEntityManagerFactory("jpa-mssql");
	}
	@Override
	public List<LuongCongNhan> getmatbNhanVien(String Ma) {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		return em.createQuery("select lcn from LuongCongNhan lcn where lcn.maCongNhan.maCongNhan = :year", LuongCongNhan.class)
				.setParameter("year", Ma)
				.getResultList();
		
	}
	@Override
	public List<LuongCongNhan> timKiemNgayLYear(String Year) {
		//select * from LuongCongNhan where thangNhan =?
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		return em.createQuery("select lcn from LuongCongNhan lcn where lcn.NamNhan = :year", LuongCongNhan.class)
				.setParameter("year", Year)
				.getResultList();

		
	}
	@Override
	public List<LuongCongNhan> timKiemNgayLMonth(String month) {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		return em.createQuery("select lcn from LuongCongNhan lcn where lcn.ThangNhan = :year", LuongCongNhan.class)
				.setParameter("year", month)
				.getResultList();

		
	}
	
	
	@Override
	public List<LuongCongNhan> timKiemMonthMaHD(String date, String ma) {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		return em.createQuery("select lcn from LuongCongNhan lcn where lcn.ThangNhan = :year AND lcn.maCongNhan.maCongNhan =:ma", LuongCongNhan.class)
				.setParameter("year", date)
				.setParameter("ma", ma)
				.getResultList();
		
	}
	@Override
	public List<LuongCongNhan> timKiemMonthYear(String date, String year) {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		return em.createQuery("select lcn from LuongCongNhan lcn where lcn.ThangNhan = :year AND lcn.NamNhan =:ma", LuongCongNhan.class)
				.setParameter("year", date)
				.setParameter("ma", year)
				.getResultList();
	}
	@Override
	public List<LuongCongNhan> timKiemYearMaHD(String year, String ma) {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		return em.createQuery("select lcn from LuongCongNhan lcn where lcn.NamNhan = :year AND lcn.maCongNhan.maCongNhan =:ma", LuongCongNhan.class)
				.setParameter("year", year)
				.setParameter("ma", ma)
				.getResultList();
	}
	@Override
	public List<LuongCongNhan> timKiem(String date, String year, String ma) {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		return em.createQuery("select lcn from LuongCongNhan lcn where lcn.NamNhan = :year AND lcn.maCongNhan.maCongNhan =:ma AND lcn.ThangNhan = :date", LuongCongNhan.class)
				.setParameter("year", year)
				.setParameter("ma", ma)
				.setParameter("date", date)
				.getResultList();
	}
}
