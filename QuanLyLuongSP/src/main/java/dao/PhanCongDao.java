package dao;

import java.util.List;

import entity.PhanCong;

public interface PhanCongDao {
	boolean themPhanCong();
	List<PhanCong> getDanhSachPhanCong();
	
}
