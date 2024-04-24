package entity;



import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Entity
@Table(name = "CongCuaNhanVien")
public class CongCuaNhanVien implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -507197132000975830L;


	@Id
	@Column(name = "maCongCuaNhanVien", nullable = false, columnDefinition = "nvarchar(255)")
	private String maCongCuaNhanVien;
	
	
//	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
//	@JoinColumn(name = "maNhanVien" , columnDefinition = "nvarchar(255)")
//	private NhanVien maNhanVien;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maNhanVien", referencedColumnName = "maNhanVien") // Thay đổi referencedColumnName thành trường khóa chính của bảng NhanVien
    private NhanVien maNhanVien;
	
	
	
	@Column(columnDefinition = "date")
	private String ngayChamCong;
	@Column( name = "caLam" ,columnDefinition = "nvarchar(255)")
	private String caLam;
	@Column(name = "gioLam", columnDefinition = "nvarchar(255)")
	private String gioLam;
	@Column(name = "luongCaLam", columnDefinition = "float")
	private float luongCaLam;
	@Column(name = "trangThai", columnDefinition = "nvarchar(255)")
	private String trangThai;
	@Column(name = "nghiPhep", columnDefinition = "nvarchar(255)")
	private String nghiPhep;
}
