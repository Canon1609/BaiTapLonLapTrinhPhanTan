package entity;

import java.time.LocalDate;
import java.util.Set;

import lombok.*;
import jakarta.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "NhanVien")
public class NhanVien {
	@Id
	@Column(name = "maNhanVien", nullable = false, columnDefinition = "nvarchar(255)")
	private String maNhanVien;
	@Column(name = "hoTen", columnDefinition = "nvarchar(255)")
	private String hoTen;
	@Column(name = "CCCD", columnDefinition = "nvarchar(255)")
	private String CCCD;
	@Column(name = "ngaySinh", columnDefinition = "date")
	private String ngaySinh;
	@Column(name = "gioiTinh", columnDefinition = "nvarchar(255)",nullable = false)
	private String gioiTinh;
	@Column(name = "diaChi", columnDefinition = "nvarchar(255)")
	private String diaChi;
	@Column(name = "soDienThoai", columnDefinition = "nvarchar(255)")
	private String soDienThoai;
	@Column(name ="luongCoBan",columnDefinition = "float")
	private double luongCoBan;
	@Column(name = "phuCap", columnDefinition = "float",nullable = false)
	private double phuCap;
	@Column(name = "phongban", columnDefinition = "nvarchar(255)")
	private String phongban;
	@Column(name = "heSoLuong", columnDefinition = "float",nullable = false)
	private double heSoLuong;

	
}
