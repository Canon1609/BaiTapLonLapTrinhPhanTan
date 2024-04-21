package entity;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "CongNhan")
public class CongNhan {
	@Id
	@Column(name = "maCongNhan", nullable = false, columnDefinition = "nvarchar(255)")
	private String maCongNhan;
	@Column(name = "HoTen", columnDefinition = "nvarchar(255)")
	private String hoTen;
	@Column(name = "GioiTinh", columnDefinition = "nvarchar(255)",nullable = false)
	private String gioiTinh;
	private LocalDate ngaySinh;
	private String CCCD;
	private String soDienThoai;
	@Column(name = "PhuCap", columnDefinition = "float",nullable = false)
	private double phuCap;
	private String phongBan;
	private String trinhDoTayNghe;
	private String diaChi;
//	@OneToMany(mappedBy = "CongNhan" , fetch = FetchType.LAZY)
//	private Set<PhanCong> phanCongs;
//	@OneToMany(mappedBy = "CongNhan" , fetch = FetchType.LAZY)
//	private Set<LuongCongNhan> luongCongNhans;
//	@OneToMany(mappedBy = "CongNhan" , fetch = FetchType.LAZY)
//	private Set<CongCuaCongNhan> congCuaCongNhans;
//	
}
