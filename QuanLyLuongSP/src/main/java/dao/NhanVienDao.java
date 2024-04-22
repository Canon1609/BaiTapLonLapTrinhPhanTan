package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.NhanVien;

public interface NhanVienDao extends Remote{

	boolean ThemNhanVien(NhanVien nv)throws RemoteException;

	List<NhanVien> getDanhSachNhanVien()throws RemoteException;

	boolean XoaNhanVien(String maNhanVien) throws RemoteException;

	boolean CapNhatNhanVien(NhanVien nv)throws RemoteException;

	List<NhanVien> getNhanVienTheoTen(String tenNhanVien)throws RemoteException;

	List<NhanVien> getNhanVienTheoGioiTinh(String gioiTinh)throws RemoteException;

	List<NhanVien> getNhanVienTheoMa(String maNhanVien) throws RemoteException;
	
}
