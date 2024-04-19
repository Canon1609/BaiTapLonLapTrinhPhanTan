package entity;

import java.util.Objects;

public class CongNhan {
	private String maCongNhan;
	private String hoTen;
	private String gioiTinh;
	private String ngaySinh;
	private String cCCD;
	private String soDienThoai;
	private double phuCap;
	private String phongBan;
	private String trinhDoTayNghe;
	private String diaChi;
	public CongNhan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CongNhan(String maCongNhan) {
		super();
		this.maCongNhan = maCongNhan;
	}
	public CongNhan(String maCongNhan, String hoTen, String gioiTinh, String ngaySinh, String cCCD, String soDienThoai,
			double phuCap, String phongBan, String trinhDoTayNghe, String diaChi) {
		super();
		this.maCongNhan = maCongNhan;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.cCCD = cCCD;
		this.soDienThoai = soDienThoai;
		this.phuCap = phuCap;
		this.phongBan = phongBan;
		this.trinhDoTayNghe = trinhDoTayNghe;
		this.diaChi = diaChi;
	}
	public String getMaCongNhan() {
		return maCongNhan;
	}
	public void setMaCongNhan(String maCongNhan) {
		this.maCongNhan = maCongNhan;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getcCCD() {
		return cCCD;
	}
	public void setcCCD(String cCCD) {
		this.cCCD = cCCD;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
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
	public String getTrinhDoTayNghe() {
		return trinhDoTayNghe;
	}
	public void setTrinhDoTayNghe(String trinhDoTayNghe) {
		this.trinhDoTayNghe = trinhDoTayNghe;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maCongNhan);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CongNhan other = (CongNhan) obj;
		return Objects.equals(maCongNhan, other.maCongNhan);
	}
	@Override
	public String toString() {
		return "CongNhan [maCongNhan=" + maCongNhan + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", ngaySinh="
				+ ngaySinh + ", cCCD=" + cCCD + ", soDienThoai=" + soDienThoai + ", phuCap=" + phuCap + ", phongBan="
				+ phongBan + ", trinhDoTayNghe=" + trinhDoTayNghe + ", diaChi=" + diaChi + "]";
	}
	
	
}
