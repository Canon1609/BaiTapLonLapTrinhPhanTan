package dao;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.CongNhan;



public interface CongNhanDao extends Remote{
	List<CongNhan> getAlltbCongNhan()throws RemoteException;
	boolean create(CongNhan cn)throws RemoteException;
	int getCNNumber()throws RemoteException;
	boolean deleteCN(String maCN)throws RemoteException;
	boolean update(CongNhan cn)throws RemoteException;
	List<CongNhan> timKiemGT(String gt)throws RemoteException;
	int getMaxEmployeeNumber()throws RemoteException;
	List<CongNhan> timKiemTen(String ten)throws RemoteException;
	
}
