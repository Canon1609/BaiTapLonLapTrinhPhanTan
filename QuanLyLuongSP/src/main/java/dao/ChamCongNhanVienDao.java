package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.CongCuaNhanVien;

public interface ChamCongNhanVienDao extends Remote{

	boolean ChamCongNhanVien(CongCuaNhanVien congNV) throws RemoteException;

	boolean deleteCongNV(String maCongNV) throws RemoteException;

	List<CongCuaNhanVien> getAllCongNV() throws RemoteException;

	boolean ChamCongChoTatCaNhanVien(CongCuaNhanVien congNV) throws RemoteException;


}
