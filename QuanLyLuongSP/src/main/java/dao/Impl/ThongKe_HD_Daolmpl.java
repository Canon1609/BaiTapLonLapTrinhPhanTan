package dao.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import javax.naming.CommunicationException;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import dao.ThongKe_HD_Dao;
import entity.HopDong;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ThongKe_HD_Daolmpl extends UnicastRemoteObject implements ThongKe_HD_Dao{
	private static final long serialVersionUID = 5929402348281005343L;
	private EntityManagerFactory emf;
	private EntityManager entityManager;
	public ThongKe_HD_Daolmpl() throws RemoteException {
		// Khởi tạo EntityManagerFactory
		emf = Persistence.createEntityManagerFactory("jpa-mssql");
	}
	@Override
	public List<HopDong> getmatbNhanVien(String Ma) throws RemoteException {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		return em.createQuery("select hd from HopDong hd where hd.maHopDong = :year", HopDong.class)
				.setParameter("year", Ma)
				.getResultList();
		
	}

	@Override
	public List<HopDong> timKiemNgayLMonth(String Year) throws RemoteException {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		  Session session = em.unwrap(Session.class);
		    String sql = "SELECT * FROM HopDong WHERE MONTH(ngayLap) = :month";
		    NativeQuery<HopDong> query = session.createNativeQuery(sql, HopDong.class);
		    query.setParameter("month", Year);
		    return query.getResultList();
	}

	@Override
	public List<HopDong> timKiemNgayLYear(String month) throws RemoteException {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		  Session session = em.unwrap(Session.class);
		    String sql = "SELECT * FROM HopDong WHERE YEAR(ngayLap) = :month";
		    NativeQuery<HopDong> query = session.createNativeQuery(sql, HopDong.class);
		    query.setParameter("month", month);
		    return query.getResultList();
	}

	@Override
	public List<HopDong> timKiemMonthMaHD(String date, String ma) throws RemoteException {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		  Session session = em.unwrap(Session.class);
		    String sql = "SELECT * FROM HopDong WHERE MONTH(ngayLap) = :month AND maHopDong = :ma";
		    NativeQuery<HopDong> query = session.createNativeQuery(sql, HopDong.class);
		    query.setParameter("month", date);
		    query.setParameter("ma", ma);
		    return query.getResultList();
	}

	@Override
	public List<HopDong> timKiemMonthYear(String date, String year) throws RemoteException {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		  Session session = em.unwrap(Session.class);
		    String sql = "SELECT * FROM HopDong WHERE MONTH(ngayLap) = :month AND YEAR(ngayLap) = :ma";
		    NativeQuery<HopDong> query = session.createNativeQuery(sql, HopDong.class);
		    query.setParameter("month", date);
		    query.setParameter("ma", year);
		    return query.getResultList();
	}

	@Override
	public List<HopDong> timKiemYearMaHD(String year, String ma) throws RemoteException {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		  Session session = em.unwrap(Session.class);
		    String sql = "SELECT * FROM HopDong WHERE YEAR(ngayLap) = :month AND maHopDong = :ma";
		    NativeQuery<HopDong> query = session.createNativeQuery(sql, HopDong.class);
		    query.setParameter("month", year);
		    query.setParameter("ma", ma);
		    return query.getResultList();
	}

	@Override
	public List<HopDong> timKiem(String date, String year, String ma) throws RemoteException {
		EntityManager em = emf.createEntityManager(); // Mở EntityManager
		  Session session = em.unwrap(Session.class);
		    String sql = "SELECT * FROM HopDong WHERE YEAR(ngayLap) = :year AND maHopDong = :ma AND MONTH(ngayLap)  = :month";
		    NativeQuery<HopDong> query = session.createNativeQuery(sql, HopDong.class);
		    query.setParameter("year", year);
		    query.setParameter("ma", ma);
		    query.setParameter("month", date);
		    return query.getResultList();
	}
	public static void main(String[] args) {
		try {
			ThongKe_HD_Daolmpl h =new ThongKe_HD_Daolmpl();
			List<HopDong> list =h.timKiem("04","2024","HD01");
			
				System.out.println(list);
			
			for (HopDong hopDong : list) {
				System.out.println(hopDong);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
