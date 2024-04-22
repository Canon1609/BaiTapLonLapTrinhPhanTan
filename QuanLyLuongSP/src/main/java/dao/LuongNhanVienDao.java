package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.LuongNhanVien;

public interface LuongNhanVienDao extends Remote{

	int getMaxSalaryId()throws RemoteException;

	boolean tinhLuongNhanVien(LuongNhanVien luongNV)throws RemoteException;
	
	List<LuongNhanVien> getDanhSachLuongNhanVien()throws RemoteException;

}
