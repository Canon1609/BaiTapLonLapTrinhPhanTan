package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.CongDoan;
import entity.SanPham;

public interface SanPhamDao extends Remote {
	boolean themSanPham(SanPham sp) throws RemoteException;
	boolean xoaSanPham(String maSanPham)  throws RemoteException;
	boolean capNhatSanPham(SanPham sp)  throws RemoteException;
	List<SanPham> getDanhSachSanPham()  throws RemoteException;

}
