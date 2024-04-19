package entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "HopDong")
public class HopDong {
	@Id
	@Column(name = "maHopDong", nullable = false, columnDefinition = "nvarchar(255)")
	private String maHopDong;
	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinColumn(name = "maSanPham")
	private SanPham maSanPham;
	private String tenSanPham;
	private String tenKhachHang;
	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinColumn(name = "maNhanVien")
	private NhanVien maNhanVien;
	private String tenNhanVien;
	private LocalDate ngayLap;
	private LocalDate ngayGiao;
	private int soLuong;
	@Column( name = "DonGia", columnDefinition = "float",nullable = false)
	private double donGia;
	
}
