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
	@JoinColumn(name = "maCongNhan")
	private CongNhan maCongNhan;
	private String tenCongNhan;
	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinColumn(name = "maCongDoan")
	private CongDoan CongDoan;
	private String tenCongDoan;
	@Column(name = "SoLuongSanPhamCanLam", columnDefinition = "date", nullable = false)
	private int soLuongSanPhamCanLam;
	
}
