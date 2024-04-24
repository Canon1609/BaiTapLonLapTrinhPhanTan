package dao;

import java.util.List;

import entity.LuongCongNhan;

public interface ThongKe_CN_Dao {
	public List<LuongCongNhan> getmatbNhanVien(String Ma);
	public List<LuongCongNhan> timKiemNgayLYear(String Year);
	public List<LuongCongNhan> timKiemNgayLMonth(String month);
	public List<LuongCongNhan> timKiemMonthMaHD(String date,String ma);
	public List<LuongCongNhan> timKiemMonthYear(String date,String year);
	public List<LuongCongNhan> timKiemYearMaHD(String year,String ma);
	public List<LuongCongNhan> timKiem(String date,String year,String ma);
}
