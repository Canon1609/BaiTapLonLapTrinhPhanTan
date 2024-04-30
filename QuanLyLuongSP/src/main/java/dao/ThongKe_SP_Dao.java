package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.HopDong;
import entity.SanPham;

public interface ThongKe_SP_Dao extends Remote{
	List<SanPham> getTheoMaSP(String ma) throws RemoteException;
	List<SanPham> getTheoTenSP(String ten) throws RemoteException;
	List<SanPham> getAllSP() throws RemoteException;
	List<SanPham> getMAANDTEN(String ma, String ten) throws RemoteException;
	List<HopDong> getHDTheoMaSP(String ma) throws RemoteException;
}
