package entity;

import lombok.*;

import jakarta.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "PhanCong")
public class PhanCong {
	@Id
	@Column(name = "maPhanCong", nullable = false, columnDefinition = "nvarchar(255)")
	private String maPhanCong;
	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinColumn(name = "maCongNhan" , columnDefinition = "nvarchar(255)")
	private CongNhan maCongNhan;
	@Column(name = "tenCongNhan", columnDefinition = "nvarchar(255)")
	private String tenCongNhan;
	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinColumn(name = "maCongDoan" , columnDefinition = "nvarchar(255)")
	private CongDoan CongDoan;
	@Column(name = "tenCongDoan", columnDefinition = "nvarchar(255)")
	private String tenCongDoan;
	@Column(name = "soLuongSanPhamCanLam", columnDefinition = "int", nullable = false)
	private int soLuongSanPhamCanLam;
	
}
