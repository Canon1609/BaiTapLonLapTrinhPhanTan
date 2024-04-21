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
	@JoinColumn(name = "maSanPham",nullable = false,columnDefinition = "nvarchar(255)")
	private SanPham maSanPham;
	@Column(name = "tenSanPham", columnDefinition = "nvarchar(255)")
	private String tenSanPham;
	@Column(name = "tenKhachHang", columnDefinition = "nvarchar(255)")
	private String tenKhachHang;
	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinColumn(name = "maNhanVien" , columnDefinition = "nvarchar(255)")
	private NhanVien maNhanVien;
	@Column(columnDefinition = "nvarchar(255)")
	private String tenNhanVien;
	@Column(name = "ngayLap", columnDefinition = "date")
	private String ngayLap;
	@Column(name = "ngayGiao", columnDefinition = "date")
	private String ngayGiao;
	@Column(name = "soLuong", columnDefinition = "int")
	private int soLuong;
	@Column( name = "donGia", columnDefinition = "float",nullable = false)
	private double donGia;
	
}
