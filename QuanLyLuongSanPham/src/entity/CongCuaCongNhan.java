package entity;

import java.util.Objects;

public class CongCuaCongNhan {
	private String maCongCN;
	private CongNhan congNhan;
	private String tenCongNhan;
	private PhanCong phanCong;
	private CongDoan congDoan;
	private String tenCongDoan;
	private String ngayChamCong;
	private String caLam;
	private String giolam;
	private double luongCaLam;
	private int slSPDaLam;
	private String trangThai;
	private String nghiPhep;
	
	public CongCuaCongNhan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CongCuaCongNhan(String maCongCN) {
		super();
		this.maCongCN = maCongCN;
	}
	public CongCuaCongNhan(String maCongCN, CongNhan congNhan, String tenCongNhan, PhanCong phanCong, CongDoan congDoan,
			String tenCongDoan, String ngayChamCong, String caLam, String giolam, double luongCaLam, int slSPDaLam,
			String trangThai, String nghiPhep) {
		super();
		this.maCongCN = maCongCN;
		this.congNhan = congNhan;
		this.tenCongNhan = tenCongNhan;
		this.phanCong = phanCong;
		this.congDoan = congDoan;
		this.tenCongDoan = tenCongDoan;
		this.ngayChamCong = ngayChamCong;
		this.caLam = caLam;
		this.giolam = giolam;
		this.luongCaLam = luongCaLam;
		this.slSPDaLam = slSPDaLam;
		this.trangThai = trangThai;
		this.nghiPhep = nghiPhep;
	}
	public String getMaCongCN() {
		return maCongCN;
	}
	public void setMaCongCN(String maCongCN) {
		this.maCongCN = maCongCN;
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
	public PhanCong getPhanCong() {
		return phanCong;
	}
	public void setPhanCong(PhanCong phanCong) {
		this.phanCong = phanCong;
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
	public String getGiolam() {
		return giolam;
	}
	public void setGiolam(String giolam) {
		this.giolam = giolam;
	}
	public double getLuongCaLam() {
		return luongCaLam;
	}
	public void setLuongCaLam(double luongCaLam) {
		this.luongCaLam = luongCaLam;
	}
	public int getSlSPDaLam() {
		return slSPDaLam;
	}
	public void setSlSPDaLam(int slSPDaLam) {
		this.slSPDaLam = slSPDaLam;
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
	@Override
	public int hashCode() {
		return Objects.hash(maCongCN);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CongCuaCongNhan other = (CongCuaCongNhan) obj;
		return Objects.equals(maCongCN, other.maCongCN);
	}
	@Override
	public String toString() {
		return "CongCuaCongNhan [maCongCN=" + maCongCN + ", congNhan=" + congNhan + ", tenCongNhan=" + tenCongNhan
				+ ", phanCong=" + phanCong + ", congDoan=" + congDoan + ", tenCongDoan=" + tenCongDoan
				+ ", ngayChamCong=" + ngayChamCong + ", caLam=" + caLam + ", giolam=" + giolam + ", luongCaLam="
				+ luongCaLam + ", slSPDaLam=" + slSPDaLam + ", trangThai=" + trangThai + ", nghiPhep=" + nghiPhep + "]";
	}
	
	
	
	
	
	
}
