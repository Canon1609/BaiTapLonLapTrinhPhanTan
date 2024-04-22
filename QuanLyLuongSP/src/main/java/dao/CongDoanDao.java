package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.CongDoan;

public interface CongDoanDao extends Remote {
	boolean themCongDoan(CongDoan cd) throws RemoteException;
	boolean xoaCongDoan(String maCongDoan)  throws RemoteException;
	boolean capNhatCongDoan(CongDoan cd)  throws RemoteException;
	List<CongDoan> getDanhSachCongDoan()  throws RemoteException;
}
