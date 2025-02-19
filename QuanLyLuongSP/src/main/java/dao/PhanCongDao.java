package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.CongDoan;
import entity.PhanCong;
import entity.SanPham;

public interface PhanCongDao extends Remote {
	boolean themPhanCong(PhanCong pc) throws RemoteException;
	boolean xoaPhanCong(String maPhanCong) throws RemoteException;
	boolean suaPhanCong(PhanCong pc) throws RemoteException;
	List<PhanCong> getDSPhanCong() throws RemoteException;
	List<SanPham> getDSSanPham() throws RemoteException;
	List<String> getDSMaCongNhan() throws RemoteException;
	List<CongDoan> getDSCongDoan() throws RemoteException;
	String GetTenCongDoanTheoMa(String maCongDoan) throws RemoteException;
	String GetTenCongNhanTheoMa(String maCongNhan) throws RemoteException;
	int getSoLuongDaPhanCong(String maCongDoan)throws RemoteException;
	List<PhanCong> getAlltbPhanCong()throws RemoteException;
	String getMaCongDoanDaLamTheoMaCongNhan(String maCN)throws RemoteException;
	int getTongSoLuongSanPhamDaPhanCong(String maCongNhan, String maCongDoan)throws RemoteException;
}
