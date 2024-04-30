package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.LuongNhanVien;


public interface ThongKe_NV_Dao extends Remote{
	List<LuongNhanVien> getmatbLuongNhanVien(String Ma) throws RemoteException;
	List<LuongNhanVien> timKiemNgayLYear(String Year) throws RemoteException;
	List<LuongNhanVien> timKiemNgayLMonth(String month) throws RemoteException;
	List<LuongNhanVien> timKiemMonthMaHD(String date,String ma) throws RemoteException;
	List<LuongNhanVien> timKiemMonthYear(String date,String year) throws RemoteException;
	List<LuongNhanVien> timKiemYearMaHD(String year,String ma) throws RemoteException;
	List<LuongNhanVien> timKiem(String date,String year,String ma) throws RemoteException;
}
