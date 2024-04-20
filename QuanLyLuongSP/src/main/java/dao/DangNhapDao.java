package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import entity.TaiKhoan;

public interface DangNhapDao extends Remote{
	List<TaiKhoan> TimKiem(String tk, String mk) throws RemoteException;

}
