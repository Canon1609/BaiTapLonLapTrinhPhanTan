package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.LuongCongNhan;

public interface ThongKe_CN_Dao extends Remote{
	List<LuongCongNhan> getmatbNhanVien(String Ma)throws RemoteException;
	List<LuongCongNhan> timKiemNgayLYear(String Year)throws RemoteException;
	List<LuongCongNhan> timKiemNgayLMonth(String month)throws RemoteException;
	List<LuongCongNhan> timKiemMonthMaHD(String date,String ma)throws RemoteException;
	List<LuongCongNhan> timKiemMonthYear(String date,String year)throws RemoteException;
	List<LuongCongNhan> timKiemYearMaHD(String year,String ma)throws RemoteException;
	List<LuongCongNhan> timKiem(String date,String year,String ma)throws RemoteException;
}
