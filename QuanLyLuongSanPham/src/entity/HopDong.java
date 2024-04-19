package entity;

import java.util.Objects;

public class HopDong {
	private String maHopDong;
	private SanPham sanPham;
	private String tenSPham;
	private String tenKH;
	private NhanVien nhanVien;
	private String tenNVien;
	private String ngayLap;
	private String ngayGiao;
	private int soLuongSanPham;
	private double donGia;
	
	
	public HopDong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HopDong(String maHopDong) {
		super();
		this.maHopDong = maHopDong;
	}
	public HopDong(String maHopDong, SanPham sanPham, String tenSPham, String tenKH, NhanVien nhanVien, String tenNVien,
			String ngayLap, String ngayGiao, int soLuongSanPham, double donGia) {
		super();
		this.maHopDong = maHopDong;
		this.sanPham = sanPham;
		this.tenSPham = tenSPham;
		this.tenKH = tenKH;
		this.nhanVien = nhanVien;
		this.tenNVien = tenNVien;
		this.ngayLap = ngayLap;
		this.ngayGiao = ngayGiao;
		this.soLuongSanPham = soLuongSanPham;
		this.donGia = donGia;
	}
	
	public String getMaHopDong() {
		return maHopDong;
	}
	public void setMaHopDong(String maHopDong) {
		this.maHopDong = maHopDong;
	}
	public SanPham getSanPham() {
		return sanPham;
	}
	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}
	public String getTenSPham() {
		return tenSPham;
	}
	public void setTenSPham(String tenSPham) {
		this.tenSPham = tenSPham;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public String getTenNVien() {
		return tenNVien;
	}
	public void setTenNVien(String tenNVien) {
		this.tenNVien = tenNVien;
	}
	public String getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(String ngayLap) {
		this.ngayLap = ngayLap;
	}
	public String getNgayGiao() {
		return ngayGiao;
	}
	public void setNgayGiao(String ngayGiao) {
		this.ngayGiao = ngayGiao;
	}
	public int getSoLuongSanPham() {
		return soLuongSanPham;
	}
	public void setSoLuongSanPham(int soLuongSanPham) {
		this.soLuongSanPham = soLuongSanPham;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maHopDong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HopDong other = (HopDong) obj;
		return Objects.equals(maHopDong, other.maHopDong);
	}
	@Override
	public String toString() {
		return "HopDong [maHopDong=" + maHopDong + ", sanPham=" + sanPham + ", tenSPham=" + tenSPham + ", tenKH="
				+ tenKH + ", nhanVien=" + nhanVien + ", tenNVien=" + tenNVien + ", ngayLap=" + ngayLap + ", ngayGiao="
				+ ngayGiao + ", soLuongSanPham=" + soLuongSanPham + ", donGia=" + donGia + "]";
	}
	
	
	
	
	
	
	
	
	
}
