package entity;

import java.io.Serializable;
import java.util.Set;

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
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "maCongDoan" , nullable = false , columnDefinition = "nvarchar(255)")
	private String maCongDoan;
	@Column(name = "TenCongDoan" , columnDefinition = "nvarchar(255)")
	private String tenCongDoan;
	@Column(name = "GiaCongDoan",columnDefinition ="float" , nullable = false)
	private double giaCongDoan;
	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinColumn(name = "maSanPham", nullable = false,columnDefinition = "nvarchar(255)")
	private SanPham sanPham;
	@Column(name = "tenSanPham", columnDefinition = "nvarchar(255)")
	private String tenSanPham;
	@Column(name = "soLuong" , columnDefinition = "int" , nullable = false)
	private int soLuong;
	@Column(name = "congDoanYeuCau" , columnDefinition = "nvarchar(255)")
	private String congDoanYeuCau;
	
	
}
