package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TaiKhoan")
public class TaiKhoan implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5216257311351101482L;
	@Id
	private String taiKhoan;
	private String matKhau;
	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TaiKhoan(String taiKhoan, String matKhau) {
		super();
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
	}
	public String getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	@Override
	public String toString() {
		return "DangNhap [taiKhoan=" + taiKhoan + ", matKhau=" + matKhau + "]";
	}
	
	
}
