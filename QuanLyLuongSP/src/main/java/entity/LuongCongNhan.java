package entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "LuongCongNhan")
public class LuongCongNhan implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5663635798650816907L;
	@Id
	@Column(name = "maLuongCongNhan", nullable = false, columnDefinition = "nvarchar(255)")
	private String maLuongCongNhan;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maCongNhan" , referencedColumnName = "maCongNhan")
	private CongNhan maCongNhan;
	@Column(name = "tenCongNhan", columnDefinition = "nvarchar(255)")
	private String tenCongNhan;
	@Column(name = "soNgayDiLam", columnDefinition = "int")
	private int soNgayDiLam;
	@Column(name = "thangNhan", columnDefinition = "int")
	private int ThangNhan;
	@Column(name = "namNhan", columnDefinition = "int")
	private int NamNhan;
	@Column(name = "ThucNhan", columnDefinition = "float")
	private double thucNhan;
}
