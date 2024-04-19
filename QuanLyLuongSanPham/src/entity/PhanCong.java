package entity;

import java.util.Objects;

public class PhanCong {
	private String maPhanCong;
	private CongNhan congNhan;
	private String tenCongNhan;
	private CongDoan congDoan;
	private String tenCongDoan;
	private int sLSPCanLam;
	
	
	public PhanCong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PhanCong(String maPhanCong) {
		super();
		this.maPhanCong = maPhanCong;
	}
	public PhanCong(String maPhanCong, CongNhan congNhan, String tenCongNhan, CongDoan congDoan, String tenCongDoan,
			int sLSPCanLam) {
		super();
		this.maPhanCong = maPhanCong;
		this.congNhan = congNhan;
		this.tenCongNhan = tenCongNhan;
		this.congDoan = congDoan;
		this.tenCongDoan = tenCongDoan;
		this.sLSPCanLam = sLSPCanLam;
	}
	
	public String getMaPhanCong() {
		return maPhanCong;
	}
	public void setMaPhanCong(String maPhanCong) {
		this.maPhanCong = maPhanCong;
	}
	public CongNhan getCongNhan() {
		return congNhan;
	}
	public void setCongNhan(CongNhan congNhan) {
		this.congNhan = congNhan;
	}
	public String getTenCongNhan() {
		return tenCongNhan;
	}
	public void setTenCongNhan(String tenCongNhan) {
		this.tenCongNhan = tenCongNhan;
	}
	public CongDoan getCongDoan() {
		return congDoan;
	}
	public void setCongDoan(CongDoan congDoan) {
		this.congDoan = congDoan;
	}
	public String getTenCongDoan() {
		return tenCongDoan;
	}
	public void setTenCongDoan(String tenCongDoan) {
		this.tenCongDoan = tenCongDoan;
	}
	public int getsLSPCanLam() {
		return sLSPCanLam;
	}
	public void setsLSPCanLam(int sLSPCanLam) {
		this.sLSPCanLam = sLSPCanLam;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maPhanCong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhanCong other = (PhanCong) obj;
		return Objects.equals(maPhanCong, other.maPhanCong);
	}
	@Override
	public String toString() {
		return "PhanCong [maPhanCong=" + maPhanCong + ", congNhan=" + congNhan + ", tenCongNhan=" + tenCongNhan
				+ ", congDoan=" + congDoan + ", tenCongDoan=" + tenCongDoan + ", sLSPCanLam=" + sLSPCanLam + "]";
	}
	
	
	
	
}
