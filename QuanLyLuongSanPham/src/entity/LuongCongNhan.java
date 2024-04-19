package entity;

import java.util.Objects;

public class LuongCongNhan {
	private String maLuongCongNhan;
	private CongNhan congNhan;
	private String tenCongNhan;
	private int soNgayDiLam;
	private int thangNhan;
	private int namNhan;
	private double thucNhan;
	
	public LuongCongNhan() {
		// TODO Auto-generated constructor stub
	}

	public LuongCongNhan(String maLuongCongNhan) {
		super();
		this.maLuongCongNhan = maLuongCongNhan;
	}

	public LuongCongNhan(String maLuongCongNhan, CongNhan congNhan, String tenCongNhan, int soNgayDiLam, int thangNhan,
			int namNhan, double thucNhan) {
		super();
		this.maLuongCongNhan = maLuongCongNhan;
		this.congNhan = congNhan;
		this.tenCongNhan = tenCongNhan;
		this.soNgayDiLam = soNgayDiLam;
		this.thangNhan = thangNhan;
		this.namNhan = namNhan;
		this.thucNhan = thucNhan;
	}

	public String getMaLuongCongNhan() {
		return maLuongCongNhan;
	}

	public void setMaLuongCongNhan(String maLuongCongNhan) {
		this.maLuongCongNhan = maLuongCongNhan;
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

	public int getSoNgayDiLam() {
		return soNgayDiLam;
	}

	public void setSoNgayDiLam(int soNgayDiLam) {
		this.soNgayDiLam = soNgayDiLam;
	}

	public int getThangNhan() {
		return thangNhan;
	}

	public void setThangNhan(int thangNhan) {
		this.thangNhan = thangNhan;
	}

	public int getNamNhan() {
		return namNhan;
	}

	public void setNamNhan(int namNhan) {
		this.namNhan = namNhan;
	}

	public double getThucNhan() {
		return thucNhan;
	}

	public void setThucNhan(double thucNhan) {
		this.thucNhan = thucNhan;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maLuongCongNhan);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LuongCongNhan other = (LuongCongNhan) obj;
		return Objects.equals(maLuongCongNhan, other.maLuongCongNhan);
	}

	@Override
	public String toString() {
		return "LuongCongNhan [maLuongCongNhan=" + maLuongCongNhan + ", congNhan=" + congNhan + ", tenCongNhan="
				+ tenCongNhan + ", soNgayDiLam=" + soNgayDiLam + ", thangNhan=" + thangNhan + ", namNhan=" + namNhan
				+ ", thucNhan=" + thucNhan + "]";
	}

	
	
	

}
