package entity;

import java.time.LocalDate;
import java.util.Set;

import lombok.*;
import jakarta.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "NhanVien")
public class NhanVien {
	@Id
	@Column(name = "maNhanVien", nullable = false, columnDefinition = "nvarchar(255)")
	private String maNhanVien;
	@Column(name = "HoTen", columnDefinition = "nvarchar(255)")
	private String hoTen;
	private String CCCD;
	private LocalDate ngaySinh;
	@Column(name = "GioiTinh", columnDefinition = "nvarchar(255)",nullable = false)
	private String gioiTinh;
	private String diaChi;
	private double luongCoBan;
	@Column(name = "PhuCap", columnDefinition = "float",nullable = false)
	private double phuCap;
	private String phongban;
	@Column(name = "HeSoLuong", columnDefinition = "float",nullable = false)
	private double heSoLuong;
//	@OneToMany(mappedBy = "nhanVien" , fetch = FetchType.LAZY)
//	private Set<HopDong> hopDongs;
//	@OneToMany(mappedBy = "nhanVien" , fetch = FetchType.LAZY)
//	private Set<CongCuaCongNhan> congCuacongNhans;
//	@OneToMany(mappedBy = "nhanVien" , fetch = FetchType.LAZY)
//	private Set<LuongNhanVien> luongNhanViens;
	
}
