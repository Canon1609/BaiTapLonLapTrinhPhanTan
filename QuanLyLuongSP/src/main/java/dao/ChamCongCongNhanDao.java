package dao;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.CongCuaCongNhan;

public interface ChamCongCongNhanDao extends Remote{
	List<CongCuaCongNhan> getAlltbCongCuaCongNhan()throws RemoteException;
	boolean create(CongCuaCongNhan congCN)throws RemoteException;
	int getCNNumber()throws RemoteException;
	boolean delete(String maCongCN)throws RemoteException;
	int getMaxMaCongCN()throws RemoteException;
}
