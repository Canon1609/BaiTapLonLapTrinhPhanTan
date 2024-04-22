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
	@JoinColumn(name = "maNhanVien" , columnDefinition = "nvarchar(255)")
	private NhanVien maNhanVien;
	@Column(columnDefinition = "date")
	private String ngayChamCong;
	@Column( name = "caLam" ,columnDefinition = "nvarchar(255)", nullable = false)
	private String caLam;
	@Column(name = "gioLam", columnDefinition = "nvarchar(255)")
	private String gioLam;
	@Column(name = "luongCaLam", columnDefinition = "float", nullable = false)
	private float luongCaLam;
	@Column(name = "trangThai", columnDefinition = "nvarchar(255)", nullable = false)
	private String trangThai;
	@Column(name = "nghiPhep", columnDefinition = "nvarchar(255)", nullable = false)
	private String nghiPhep;
}
