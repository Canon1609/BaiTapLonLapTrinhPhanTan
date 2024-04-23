package entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "CongNhan")
public class CongNhan implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7357105777743026473L;
	@Id
	@Column(name = "maCongNhan", nullable = false, columnDefinition = "nvarchar(255)")
	private String maCongNhan;
	@Column(name = "hoTen", columnDefinition = "nvarchar(255)")
	private String hoTen;
	@Column(name = "gioiTinh", columnDefinition = "nvarchar(255)")
	private String gioiTinh;
	@Column(name = "ngaySinh", columnDefinition = "date")
	private String ngaySinh;
	@Column(name = "CCCD", columnDefinition = "nvarchar(255)")
	private String CCCD;
	@Column(name = "soDienThoai", columnDefinition = "nvarchar(255)")
	private String soDienThoai;
	@Column(name = "PhuCap", columnDefinition = "float")
	private double phuCap;
	@Column(name = "phongBan", columnDefinition = "nvarchar(255)")
	private String phongBan;
	@Column(name = "trinhDoTayNghe", columnDefinition = "nvarchar(255)")
	private String trinhDoTayNghe;
	@Column(name = "diaChi", columnDefinition = "nvarchar(255)")
	private String diaChi;
	public CongNhan(String maCongNhan) {
		super();
		this.maCongNhan = maCongNhan;
	}
	
}
