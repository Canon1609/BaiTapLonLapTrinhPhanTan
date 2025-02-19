package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.HopDong;


public interface HopDongDAO extends Remote{
	boolean ThemHopDong(HopDong hd) throws RemoteException;
	
	boolean CapNhatHopDong(HopDong hd) throws RemoteException;
	
	String XoaHopDong(String maHD) throws RemoteException;
	
	List<HopDong> getDanhSachHopDong() throws RemoteException;

	List<HopDong> getHopDongTheoMaNV(String maNV) throws RemoteException;

	List<HopDong> getHopDongTheoTenKH(String tenKH) throws RemoteException;

}
