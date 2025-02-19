package entity;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "CongDoan")

public class CongDoan implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2054612670321170819L;
	@Id
	@Column(name = "maCongDoan" , nullable = false , columnDefinition = "nvarchar(255)")
	private String maCongDoan;
	@Column(name = "TenCongDoan" , columnDefinition = "nvarchar(255)")
	private String tenCongDoan;
	@Column(name = "GiaCongDoan",columnDefinition ="float" )
	private double giaCongDoan;
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "maSanPham", referencedColumnName = "maSanPham")
	private SanPham sanPham;
	@Column(name = "tenSanPham", columnDefinition = "nvarchar(255)")
	private String tenSanPham;
	@Column(name = "soLuong" , columnDefinition = "int" )
	private int soLuong;
	@Column(name = "congDoanYeuCau" , columnDefinition = "nvarchar(255)")
	private String congDoanYeuCau;
	public CongDoan(String maCongDoan) {
		super();
		this.maCongDoan = maCongDoan;
	}
	
	
	
	
}
