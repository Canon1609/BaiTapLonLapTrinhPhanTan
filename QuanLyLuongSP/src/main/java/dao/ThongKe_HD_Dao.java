package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.HopDong;

public interface ThongKe_HD_Dao extends Remote{
	 List<HopDong> getmatbNhanVien(String Ma) throws RemoteException;
	 List<HopDong> timKiemNgayLYear(String Year) throws RemoteException;
	 List<HopDong> timKiemNgayLMonth(String month) throws RemoteException;
	 List<HopDong> timKiemMonthMaHD(String date,String ma) throws RemoteException;
	 List<HopDong> timKiemMonthYear(String date,String year) throws RemoteException;
	 List<HopDong> timKiemYearMaHD(String year,String ma) throws RemoteException;
	 List<HopDong> timKiem(String date,String year,String ma) throws RemoteException;
}
