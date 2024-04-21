package entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "SanPham")
public class SanPham implements Serializable{
	@Id
	@Column(name = "maSanPham" , nullable = false , columnDefinition = "nvarchar(255)")
	private String  maSanPham;
	@Column(name = "tenSanPham" , columnDefinition = "nvarchar(255)")
	private String tenSanPham;
	@Column(name = "kieuDang" , columnDefinition = "nvarchar(255)")
	private String kieuDang;
	@Column(name = "chatLieu" , columnDefinition = "nvarchar(255)")
	private String chatLieu;
	@Column(name = "soLuong" , columnDefinition = "int" , nullable = false)
	private int soLuong;

}
