package dao;


import java.util.List;

import entity.CongNhan;



public interface CongNhanDao {
	public List<CongNhan> getAlltbCongNhan();
	public boolean create(CongNhan cn);
	public int getCNNumber();
	public boolean deleteCN(String maCN);
	public boolean update(CongNhan cn);
	public List<CongNhan> timKiemGT(String gt);
	public int getMaxEmployeeNumber();
	public List<CongNhan> timKiemTen(String ten);
	
}
