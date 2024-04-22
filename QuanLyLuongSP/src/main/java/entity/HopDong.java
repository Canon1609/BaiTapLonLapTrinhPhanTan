package entity;



import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "HopDong")
public class HopDong implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7644218725664413032L;
	@Id
	@Column(name = "maHopDong", nullable = false, columnDefinition = "nvarchar(255)")
	private String maHopDong;
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "maSanPham",referencedColumnName = "maSanPham")
	private SanPham maSanPham;
	@Column(name = "tenSanPham", columnDefinition = "nvarchar(255)")
	private String tenSanPham;
	@Column(name = "tenKhachHang", columnDefinition = "nvarchar(255)")
	private String tenKhachHang;
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "maNhanVien" ,referencedColumnName = "maNhanVien")
	private NhanVien maNhanVien;
	@Column(columnDefinition = "nvarchar(255)")
	private String tenNhanVien;
	@Column(name = "ngayLap", columnDefinition = "date")
	private String ngayLap;
	@Column(name = "ngayGiao", columnDefinition = "date")
	private String ngayGiao;
	@Column(name = "soLuong", columnDefinition = "int")
	private int soLuong;
	@Column( name = "donGia", columnDefinition = "float")
	private double donGia;
	
}
