package entity;

import java.util.Objects;

public class CongDoan {
	private String maCongDoan;
	private String tenCongDoan;
	private double giaCongDoan;
	private SanPham sanPham;
	private String tenSanPham;
	private int soLuong;
	private String congDoanYC;
	public CongDoan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CongDoan(String maCongDoan) {
		super();
		this.maCongDoan = maCongDoan;
	}
	public CongDoan(String maCongDoan, String tenCongDoan, double giaCongDoan, SanPham sanPham, String tenSanPham,
			int soLuong, String congDoanYC) {
		super();
		this.maCongDoan = maCongDoan;
		this.tenCongDoan = tenCongDoan;
		this.giaCongDoan = giaCongDoan;
		this.sanPham = sanPham;
		this.tenSanPham = tenSanPham;
		this.soLuong = soLuong;
		this.congDoanYC = congDoanYC;
	}
	public String getMaCongDoan() {
		return maCongDoan;
	}
	public void setMaCongDoan(String maCongDoan) {
		this.maCongDoan = maCongDoan;
	}
	public String getTenCongDoan() {
		return tenCongDoan;
	}
	public void setTenCongDoan(String tenCongDoan) {
		this.tenCongDoan = tenCongDoan;
	}
	public double getGiaCongDoan() {
		return giaCongDoan;
	}
	public void setGiaCongDoan(double giaCongDoan) {
		this.giaCongDoan = giaCongDoan;
	}
	public SanPham getSanPham() {
		return sanPham;
	}
	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getCongDoanYC() {
		return congDoanYC;
	}
	public void setCongDoanYC(String congDoanYC) {
		this.congDoanYC = congDoanYC;
	}
	@Override
	public int hashCode() {
		return Objects.hash(congDoanYC, giaCongDoan, maCongDoan, sanPham, soLuong, tenCongDoan, tenSanPham);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CongDoan other = (CongDoan) obj;
		return Objects.equals(congDoanYC, other.congDoanYC)
				&& Double.doubleToLongBits(giaCongDoan) == Double.doubleToLongBits(other.giaCongDoan)
				&& Objects.equals(maCongDoan, other.maCongDoan) && Objects.equals(sanPham, other.sanPham)
				&& soLuong == other.soLuong && Objects.equals(tenCongDoan, other.tenCongDoan)
				&& Objects.equals(tenSanPham, other.tenSanPham);
	}
	@Override
	public String toString() {
		return "CongDoan [maCongDoan=" + maCongDoan + ", tenCongDoan=" + tenCongDoan + ", giaCongDoan=" + giaCongDoan
				+ ", sanPham=" + sanPham + ", tenSanPham=" + tenSanPham + ", soLuong=" + soLuong + ", congDoanYC="
				+ congDoanYC + "]";
	}
	
	
}
