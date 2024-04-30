package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import entity.LuongCongNhan;

public interface LuonngCongNhanDao extends Remote{
	ArrayList<LuongCongNhan> getAlltbLuongCuaCongNhan()throws RemoteException;
	boolean create(LuongCongNhan luongCN)throws RemoteException;
	boolean delete(String maLuongCN)throws RemoteException;
	int getMaxMaLuongCN()throws RemoteException;
	
}
