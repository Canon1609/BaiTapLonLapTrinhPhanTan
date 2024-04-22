package dao.Impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.LuongNhanVienDao;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class LuongNhanVienDaoImpl extends UnicastRemoteObject implements LuongNhanVienDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3091377733054205270L;
	private EntityManagerFactory emf;

	protected LuongNhanVienDaoImpl() throws RemoteException {
		// Khởi tạo EntityManagerFactory
		emf = Persistence.createEntityManagerFactory("jpa-mssql");
	}

}
