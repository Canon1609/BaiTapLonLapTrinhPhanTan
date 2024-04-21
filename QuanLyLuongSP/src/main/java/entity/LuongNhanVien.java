package entity;

import lombok.*;
import jakarta.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "LuongNhanVien")
public class LuongNhanVien {
	@Id
	@Column(name = "maLuongNhanVien", nullable = false, columnDefinition = "nvarchar(255)")
	private String maLuongNhanVien;
	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinColumn(name = "maNhanVien", columnDefinition = "nvarchar(255)")
	private NhanVien maNhanVien;
	@Column(name = "tenNhanVien", columnDefinition = "nvarchar(255)")
	private String tenNhanVien;
	@Column(name = "soNgayDiLam", columnDefinition = "int", nullable = false)
	private int soNgayDiLam;
	@Column(name = "thangNhan", columnDefinition = "int", nullable = false)
	private int ThangNhan;
	@Column(name = "namNhan", columnDefinition = "int", nullable = false)
	private int NamNhan;
	@Column(name = "thucNhan", columnDefinition = "float", nullable = false)
	private double thucNhan;
}
