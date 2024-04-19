package entity;

import java.util.Objects;

public class LuongNhanVien {
	private String maLuongNhanVien;
	private NhanVien nhanVien;
	private String tenNhanVien;
	private int soNgayDiLam;
	private int thangNhan;
	private int namNhan;
	private double thucNhan;

	public LuongNhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public LuongNhanVien(String maLuongNhanVien) {
		super();
		this.maLuongNhanVien = maLuongNhanVien;
	}


	public LuongNhanVien(String maLuongNhanVien, NhanVien nhanVien, String tenNhanVien, int soNgayDiLam, int thangNhan,
			int namNhan, double thucNhan) {
		super();
		this.maLuongNhanVien = maLuongNhanVien;
		this.nhanVien = nhanVien;
		this.tenNhanVien = tenNhanVien;
		this.soNgayDiLam = soNgayDiLam;
		this.thangNhan = thangNhan;
		this.namNhan = namNhan;
		this.thucNhan = thucNhan;
	}


	public String getMaLuongNhanVien() {
		return maLuongNhanVien;
	}


	public void setMaLuongNhanVien(String maLuongNhanVien) {
		this.maLuongNhanVien = maLuongNhanVien;
	}


	public NhanVien getNhanVien() {
		return nhanVien;
	}


	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}


	public String getTenNhanVien() {
		return tenNhanVien;
	}


	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
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
		return Objects.hash(maLuongNhanVien);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LuongNhanVien other = (LuongNhanVien) obj;
		return Objects.equals(maLuongNhanVien, other.maLuongNhanVien);
	}


	@Override
	public String toString() {
		return "LuongNhanVien [maLuongNhanVien=" + maLuongNhanVien + ", nhanVien=" + nhanVien + ", tenNhanVien="
				+ tenNhanVien + ", soNgayDiLam=" + soNgayDiLam + ", thangNhan=" + thangNhan + ", namNhan=" + namNhan
				+ ", thucNhan=" + thucNhan + "]";
	}
	
	
}
