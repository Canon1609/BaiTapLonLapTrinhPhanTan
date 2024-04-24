package dao;

import java.rmi.RemoteException;
import java.util.List;

import entity.LuongNhanVien;


public interface ThongKe_NV_Dao {
	public List<LuongNhanVien> getmatbLuongNhanVien(String Ma) throws RemoteException;
	public List<LuongNhanVien> timKiemNgayLYear(String Year) throws RemoteException;
	public List<LuongNhanVien> timKiemNgayLMonth(String month) throws RemoteException;
	public List<LuongNhanVien> timKiemMonthMaHD(String date,String ma) throws RemoteException;
	public List<LuongNhanVien> timKiemMonthYear(String date,String year) throws RemoteException;
	public List<LuongNhanVien> timKiemYearMaHD(String year,String ma) throws RemoteException;
	public List<LuongNhanVien> timKiem(String date,String year,String ma) throws RemoteException;
}
