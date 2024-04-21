package entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "LuongCongNhan")
public class LuongCongNhan {
	@Id
	@Column(name = "maLuongCongNhan", nullable = false, columnDefinition = "nvarchar(255)")
	private String maLuongCongNhan;
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "maCongNhan" , columnDefinition = "nvarchar(255)")
	private CongNhan maCongNhan;
	@Column(name = "tenCongNhan", columnDefinition = "nvarchar(255)")
	private String tenCongNhan;
	@Column(name = "soNgayDiLam", columnDefinition = "int", nullable = false)
	private int soNgayDiLam;
	@Column(name = "thangNhan", columnDefinition = "int", nullable = false)
	private int ThangNhan;
	@Column(name = "namNhan", columnDefinition = "int", nullable = false)
	private int NamNhan;
	@Column(name = "ThucNhan", columnDefinition = "float", nullable = false)
	private double thucNhan;
}
