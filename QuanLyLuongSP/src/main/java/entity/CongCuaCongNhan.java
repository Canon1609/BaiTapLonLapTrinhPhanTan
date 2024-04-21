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
	@JoinColumn(name = "maCongNhan" , columnDefinition = "nvarchar(255)")
	private CongNhan congNhan;
	@Column(columnDefinition = "nvarchar(255)")
	private String tenCongNhan;
	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinColumn(name = "maPhanCong",columnDefinition = "nvarchar(255)")
	private PhanCong maPhanCong;
	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinColumn( name = "maCongDoan",columnDefinition = "nvarchar(255)")
	private CongDoan maCongDoan;
	@Column(columnDefinition = "nvarchar(255)")
	private String tenCongDoan;
	@Column(name = "ngayChamCong" , columnDefinition = "date")
	private String ngayChamCong;
	@Column(name = "caLam",columnDefinition = "nvarchar(255)",nullable = false)
	private String caLam;
	@Column(name = "gioLam",columnDefinition = "nvarchar(255)")
	private String giolam;
	@Column(name = "luongCaLam",columnDefinition = "float",nullable = false)
	private double luongCaLam;
	@Column(name = "soLuongSanPhamDaLam",columnDefinition = "int",nullable = false)
	private int soLuongSanPhamDaLam;
	@Column(columnDefinition = "nvarchar(255)",nullable = false)
	private String trangThai;
	@Column(columnDefinition = "nvarchar(255)",nullable = false)
	private String nghiPhep;
	
	
	
}

