package entity;

import java.util.Objects;

public class CongCuaNhanVien {
	private String maCongNV;
	private NhanVien nhanVien;
	private String ngayChamCong;
	private String caLam;
	private String gioLam;
	private double luongCaLam;
	private String trangThai;
	private String nghiPhep;
	
	public CongCuaNhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CongCuaNhanVien(String maCongNV) {
		super();
		this.maCongNV = maCongNV;
	}
	public CongCuaNhanVien(String maCongNV, NhanVien nhanVien, String ngayChamCong, String caLam, String gioLam, double luongCaLam,
			String trangThai, String nghiPhep) {
		super();
		this.maCongNV = maCongNV;
		this.ngayChamCong = ngayChamCong;
		this.caLam = caLam;
		this.gioLam = gioLam;
		this.luongCaLam = luongCaLam;
		this.trangThai = trangThai;
		this.nghiPhep = nghiPhep;
		this.nhanVien = nhanVien;
	}
	public String getMaCongNV() {
		return maCongNV;
	}
	public void setMaCongNV(String maCongNV) {
		this.maCongNV = maCongNV;
	}
	public String getNgayChamCong() {
		return ngayChamCong;
	}
	public void setNgayChamCong(String ngayChamCong) {
		this.ngayChamCong = ngayChamCong;
	}
	public String getCaLam() {
		return caLam;
	}
	public void setCaLam(String caLam) {
		this.caLam = caLam;
	}
	public String getGioLam() {
		return gioLam;
	}
	public void setGioLam(String gioLam) {
		this.gioLam = gioLam;
	}
	public double getLuongCaLam() {
		return luongCaLam;
	}
	public void setLuongCaLam(double luongCaLam) {
		this.luongCaLam = luongCaLam;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public String getNghiPhep() {
		return nghiPhep;
	}
	public void setNghiPhep(String nghiPhep) {
		this.nghiPhep = nghiPhep;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maCongNV);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CongCuaNhanVien other = (CongCuaNhanVien) obj;
		return Objects.equals(maCongNV, other.maCongNV);
	}
	@Override
	public String toString() {
		return "CongCuaNhanVien [maCongNV=" + maCongNV + ", ngayChamCong=" + ngayChamCong + ", caLam=" + caLam
				+ ", gioLam=" + gioLam + ", luongCaLam=" + luongCaLam + ", trangThai=" + trangThai + ", nghiPhep="
				+ nghiPhep + ", nhanVien=" + nhanVien + "]";
	}
	
}