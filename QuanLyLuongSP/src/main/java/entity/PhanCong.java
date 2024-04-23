package entity;

import lombok.*;

import jakarta.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "PhanCong")
public class PhanCong implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1788043444672364325L;
	@Id
	@Column(name = "maPhanCong", nullable = false, columnDefinition = "nvarchar(255)")
	private String maPhanCong;
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "maCongNhan" , referencedColumnName = "maCongNhan")
	private CongNhan maCongNhan;
	@Column(name = "tenCongNhan", columnDefinition = "nvarchar(255)")
	private String tenCongNhan;
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "maCongDoan" , referencedColumnName = "maCongDoan")
	private CongDoan CongDoan;
	@Column(name = "tenCongDoan", columnDefinition = "nvarchar(255)")
	private String tenCongDoan;
	@Column(name = "soLuongSanPhamCanLam", columnDefinition = "int")
	private int soLuongSanPhamCanLam;
	public PhanCong(String maPhanCong) {
		super();
		this.maPhanCong = maPhanCong;
	}
	
	
}
