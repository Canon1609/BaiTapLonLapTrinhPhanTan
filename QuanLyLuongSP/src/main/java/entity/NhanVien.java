package entity;

import java.io.Serializable;


import lombok.*;
import jakarta.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "NhanVien")
public class NhanVien implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8614112716853544884L;
	@Id
	@Column(name = "maNhanVien", nullable = false, columnDefinition = "nvarchar(255)")
	private String maNhanVien;
	@Column(name = "hoTen", columnDefinition = "nvarchar(255)")
	private String hoTen;
	@Column(name = "CCCD", columnDefinition = "nvarchar(255)")
	private String CCCD;
	@Column(name = "ngaySinh", columnDefinition = "date")
	private String ngaySinh;
	@Column(name = "gioiTinh", columnDefinition = "nvarchar(255)")
	private String gioiTinh;
	@Column(name = "diaChi", columnDefinition = "nvarchar(255)")
	private String diaChi;
	@Column(name = "soDienThoai", columnDefinition = "nvarchar(255)")
	private String soDienThoai;
	@Column(name ="luongCoBan",columnDefinition = "float")
	private double luongCoBan;
	@Column(name = "phuCap", columnDefinition = "float")
	private double phuCap;
	@Column(name = "phongban", columnDefinition = "nvarchar(255)")
	private String phongban;
	@Column(name = "heSoLuong", columnDefinition = "float")
	private double heSoLuong;
	public NhanVien(String maNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
	}
	
	

	
}
