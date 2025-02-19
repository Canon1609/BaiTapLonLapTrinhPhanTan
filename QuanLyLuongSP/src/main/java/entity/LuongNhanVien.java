package entity;

import lombok.*;
import jakarta.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "LuongNhanVien")
public class LuongNhanVien implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8439429844870732916L;
	@Id
	@Column(name = "maLuongNhanVien", nullable = false, columnDefinition = "nvarchar(255)")
	private String maLuongNhanVien;
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "maNhanVien", referencedColumnName = "maNhanVien")
	private NhanVien maNhanVien;
	@Column(name = "tenNhanVien", columnDefinition = "nvarchar(255)")
	private String tenNhanVien;
	@Column(name = "soNgayDiLam", columnDefinition = "int")
	private int soNgayDiLam;
	@Column(name = "thangNhan", columnDefinition = "int")
	private int ThangNhan;
	@Column(name = "namNhan", columnDefinition = "int")
	private int NamNhan;
	@Column(name = "thucNhan", columnDefinition = "float")
	private double thucNhan;
}
