package dao.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.DangNhapDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.List;

import entity.TaiKhoan;
public class DangNhapDaoImpl extends UnicastRemoteObject implements DangNhapDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3657173358827158039L;
private EntityManager em;
	
	public DangNhapDaoImpl() throws RemoteException {
		em = Persistence.createEntityManagerFactory("jpa-mssql")
				.createEntityManager();
	}
	
	// viết phương thức tìm kiếm tài khoản trả về list
		@Override
		public List<TaiKhoan> TimKiem(String tk, String mk) {
			// TODO Auto-generated method stub
			try {
	            em.getTransaction().begin();
	            List<TaiKhoan> list = em.createQuery("SELECT tk FROM TaiKhoan tk WHERE tk.taiKhoan = :tk AND tk.matKhau = :mk", TaiKhoan.class)
	                    .setParameter("tk", tk)
	                    .setParameter("mk", mk)
	                    .getResultList();
	            em.getTransaction().commit();
	            return list;
	        } catch (Exception e) {
				em.getTransaction().rollback();
				return null;
	        }
		}
	

}
