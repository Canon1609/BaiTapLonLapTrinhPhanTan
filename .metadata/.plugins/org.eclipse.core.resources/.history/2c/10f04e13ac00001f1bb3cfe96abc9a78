package entity;

import jakarta.persistence.*;
import lombok.*;



@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Entity
@Table(name = "CongCuaCongNhan")
public class CongCuaCongNhan implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6812493825045614282L;
	@Id
	@Column(name = "maCongCuaCongNhan" , nullable = false,columnDefinition = "nvarchar(255)")
	private String maCongCN;
	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinColumn(name = "maCongNhan" , referencedColumnName = "maCongNhan")
	private CongNhan congNhan;
	@Column(columnDefinition = "nvarchar(255)")
	private String tenCongNhan;
	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinColumn(name = "maPhanCong",referencedColumnName = "maPhanCong")
	private PhanCong maPhanCong;
	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinColumn( name = "maCongDoan",referencedColumnName = "maCongDoan")
	private CongDoan maCongDoan;
	@Column(columnDefinition = "nvarchar(255)")
	private String tenCongDoan;
	@Column(name = "ngayChamCong" , columnDefinition = "date")
	private String ngayChamCong;
	@Column(name = "caLam",columnDefinition = "nvarchar(255)")
	private String caLam;
	@Column(name = "gioLam",columnDefinition = "nvarchar(255)")
	private String giolam;
	@Column(name = "luongCaLam",columnDefinition = "float")
	private double luongCaLam;
	@Column(name = "soLuongSanPhamDaLam",columnDefinition = "int")
	private int soLuongSanPhamDaLam;
	@Column(columnDefinition = "nvarchar(255)")
	private String trangThai;
	@Column(columnDefinition = "nvarchar(255)")
	private String nghiPhep;
	
	
	
}

