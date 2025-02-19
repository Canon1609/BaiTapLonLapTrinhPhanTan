package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.SanPham;

public interface SanPhamDAO extends Remote{
	boolean ThemSanPham(SanPham sp) throws RemoteException;

	boolean CapNhatSanPham(SanPham sp) throws RemoteException;

	String XoaSanPham(String maSP) throws RemoteException;

	List<SanPham> getDanhSachSanPham() throws RemoteException;

	List<SanPham> TimSanPhamTheoTen(String tenSP) throws RemoteException;

	List<SanPham> TimSanPhamTheoKieuDang(String kieuDang) throws RemoteException;

	int getSoLuong(String maSanPham) throws RemoteException;

}
