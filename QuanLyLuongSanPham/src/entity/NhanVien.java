package entity;

import java.util.Objects;

public class NhanVien {
	private String maNhanVien;
	private String hoTen;
	private String cCCD;
	private String ngaySinh;
	private String gioiTinh;
	private String diaChi;
	private String soDienThoai;
	private double luongCoBan;
	private double phuCap;
	private String phongBan;
	private double heSoLuong;
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public NhanVien(String maNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
	}

	public NhanVien(String maNhanVien, String hoTen, String cCCD, String ngaySinh, String gioiTinh, String diaChi,
			String soDienThoai, double luongCoBan, double phuCap, String phongBan, double heSoLuong) {
		super();
		this.maNhanVien = maNhanVien;
		this.hoTen = hoTen;
		this.cCCD = cCCD;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.luongCoBan = luongCoBan;
		this.phuCap = phuCap;
		this.phongBan = phongBan;
		this.heSoLuong = heSoLuong;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getcCCD() {
		return cCCD;
	}

	public void setcCCD(String cCCD) {
		this.cCCD = cCCD;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public double getLuongCoBan() {
		return luongCoBan;
	}

	public void setLuongCoBan(double luongCoBan) {
		this.luongCoBan = luongCoBan;
	}

	public double getPhuCap() {
		return phuCap;
	}

	public void setPhuCap(double phuCap) {
		this.phuCap = phuCap;
	}

	public String getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(String phongBan) {
		this.phongBan = phongBan;
	}

	public double getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maNhanVien);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNhanVien, other.maNhanVien);
	}

	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", hoTen=" + hoTen + ", cCCD=" + cCCD + ", ngaySinh=" + ngaySinh
				+ ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + ", soDienThoai=" + soDienThoai + ", luongCoBan="
				+ luongCoBan + ", phuCap=" + phuCap + ", phongBan=" + phongBan + ", heSoLuong=" + heSoLuong + "]";
	}
	
	
	
}