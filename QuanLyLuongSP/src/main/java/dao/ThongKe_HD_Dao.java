package dao;

import java.rmi.RemoteException;
import java.util.List;

import entity.HopDong;

public interface ThongKe_HD_Dao {
	public List<HopDong> getmatbNhanVien(String Ma) throws RemoteException;
	public List<HopDong> timKiemNgayLYear(String Year) throws RemoteException;
	public List<HopDong> timKiemNgayLMonth(String month) throws RemoteException;
	public List<HopDong> timKiemMonthMaHD(String date,String ma) throws RemoteException;
	public List<HopDong> timKiemMonthYear(String date,String year) throws RemoteException;
	public List<HopDong> timKiemYearMaHD(String year,String ma) throws RemoteException;
	public List<HopDong> timKiem(String date,String year,String ma) throws RemoteException;
}
