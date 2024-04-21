package entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString

@Entity
@Table(name = "CongCuaNhanVien")
public class CongCuaNhanVien implements java.io.Serializable{
	@Id
	@Column(name = "maCongCuaNhanVien", nullable = false, columnDefinition = "nvarchar(255)")
	private String maCongCuaNhanVien;
	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinColumn(name = "maNhanVien")
	private NhanVien maNhanVien;
	private LocalDate ngayChamCong;
	@Column( name = "CaLam" ,columnDefinition = "nvarchar(255)", nullable = false)
	private String caLam;
	private int gioLam;
	@Column(name = "LuongCaLam", columnDefinition = "float", nullable = false)
	private double luongCaLam;
	@Column(name = "TrangThai", columnDefinition = "nvarchar(255)", nullable = false)
	private String trangThai;
	@Column(name = "NghiPhep", columnDefinition = "nvarchar(255)", nullable = false)
	private String nghiPhep;
}
