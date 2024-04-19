package entity;

import jakarta.persistence.*;
import lombok.*;



@Getter
@Setter
@NoArgsConstructor
@ToString

@Entity
@Table(name = "CongCuaCongNhan")
public class CongCuaCongNhan implements java.io.Serializable {
	@Id
	@Column(name = "maCongCuaCongNhan" , nullable = false,columnDefinition = "nvarchar(255)")
	private String maCongCN;
	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinColumn(name = "maCongNhan")
	private CongNhan congNhan;
	private String tenCongNhan;
	private String maPhanCong;
	private String maCongDoan;
	private String tenCongDoan;
	private String ngayChamCong;
	@Column(columnDefinition = "nvarchar(255)",nullable = false)
	private String caLam;
	private String giolam;
	@Column(columnDefinition = "float",nullable = false)
	private double luongCaLam;
	@Column(columnDefinition = "int",nullable = false)
	private int soLuongSanPhamDaLam;
	@Column(columnDefinition = "nvarchar(255)",nullable = false)
	private String trangThai;
	@Column(columnDefinition = "nvarchar(255)",nullable = false)
	private String nghiPhep;
	
	
	
}

