CREATE DATABASE QuanLyLuongSanPham
USE QuanLyLuongSanPham


CREATE TABLE TaiKhoan(
	TaiKhoan nvarchar (30) NOT NULL,
	MatKhau nvarchar (20) NOT NULL,
)
INSERT INTO TaiKhoan (TaiKhoan, MatKhau)
VALUES ('admin', 'admin123@');


CREATE TABLE NhanVien (
    maNhanVien NVARCHAR(255) NOT NULL,
    HoTen NVARCHAR(255) NULL,
    CCCD NVARCHAR(255) NULL,
    NgaySinh DATE NULL,
    GioiTinh NVARCHAR(255) NOT NULL,
    DiaChi NVARCHAR(255) NULL,
    SoDienThoai NVARCHAR(255) NULL,
    LuongCoBan FLOAT NULL,
    PhuCap FLOAT NOT NULL,
    PhongBan NVARCHAR(255) NULL,
    HeSoLuong FLOAT NOT NULL,
    PRIMARY KEY (maNhanVien)
);

CREATE TABLE CongNhan (
    maCongNhan NVARCHAR(255) NOT NULL,
    HoTen NVARCHAR(255) NULL,
    GioiTinh NVARCHAR(255) NOT NULL,
    NgaySinh DATE NULL,
    CCCD NVARCHAR(255) NULL,
    SoDienThoai NVARCHAR(255) NULL,
    PhuCap FLOAT NOT NULL,
    PhongBan NVARCHAR(255) NULL,
    TrinhDoTayNghe NVARCHAR(255) NULL,
    DiaChi NVARCHAR(255) NULL,
    PRIMARY KEY (maCongNhan)
);

CREATE TABLE LuongNhanVien (
    maLuongNhanVien NVARCHAR(255) NOT NULL,
    maNhanVien NVARCHAR(255) NULL,
	tenNhanVien NVARCHAR(255) NULL,
	soNgayDiLam INT Not Null,
    ThangNhan INT NOT NULL,
    NamNhan INT NOT NULL,
    ThucNhan FLOAT NOT NULL,
    PRIMARY KEY (maLuongNhanVien)
);

CREATE TABLE LuongCongNhan (
    maLuongCongNhan NVARCHAR(255) NOT NULL,
    maCongNhan NVARCHAR(255) NULL,
	tenCongNhan NVARCHAR(255) NULL,
	soNgayDiLam INT Not Null,
    ThangNhan INT NOT NULL,
    NamNhan INT NOT NULL,
    ThucNhan FLOAT NOT NULL,
    PRIMARY KEY (maLuongCongNhan)
);

CREATE TABLE PhanCong (
    maPhanCong NVARCHAR(255) NOT NULL,
    maCongNhan NVARCHAR(255) NULL,
	tenCongNhan NVARCHAR(255) NULL,
	maCongDoan NVARCHAR(255) NULL,
	tenCongDoan NVARCHAR(255) NULL,
    SoLuongSanPhamCanLam INT NOT NULL,
    PRIMARY KEY (maPhanCong)
);

CREATE TABLE CongDoan (
    maCongDoan NVARCHAR(255) NOT NULL,
	TenCongDoan NVARCHAR(255) NULL,
	GiaCongDoan FLOAT NOT NULL,
    maSanPham NVARCHAR(255) NULL,
	tenSanPham NVARCHAR(255) NULL,
    SoLuong INT NOT NULL,
	congDoanYeuCau NVARCHAR(255) NULL,
    
    PRIMARY KEY (maCongDoan)
);

CREATE TABLE CongCuaNhanVien (
    maCongCuaNhanVien NVARCHAR(255) NOT NULL,
    maNhanVien NVARCHAR(255) NULL,
    NgayChamCong DATE NULL,
    CaLam NVARCHAR(255) NOT NULL,
    GioLam NVARCHAR(255) NULL,
    LuongCaLam FLOAT NOT NULL,
    TrangThai NVARCHAR(255) NOT NULL,
    NghiPhep NVARCHAR(255) NOT NULL,
    PRIMARY KEY (maCongCuaNhanVien)
);

CREATE TABLE CongCuaCongNhan (
    maCongCuaCongNhan NVARCHAR(255) NOT NULL,
    maCongNhan NVARCHAR(255) NULL,
	tenCongNhan NVARCHAR(255) NULL,
	maPhanCong NVARCHAR(255) NULL,
	maCongDoan NVARCHAR(255) NULL,
	tenCongDoan NVARCHAR(255) NULL,
    NgayChamCong DATE NULL,
    CaLam NVARCHAR(255) NOT NULL,
    GioLam NVARCHAR(255) NULL,
	LuongCaLam FLOAT NOT NULL,
    SoLuongSPDaLam INT NOT NULL,
    TrangThai NVARCHAR(255) NOT NULL,
    NghiPhep NVARCHAR(255) NOT NULL,
    PRIMARY KEY (maCongCuaCongNhan)
);

CREATE TABLE SanPham (
    maSanPham NVARCHAR(255) NOT NULL,
    TenSanPham NVARCHAR(255) NULL,
    KieuDang NVARCHAR(255) NULL,
    ChatLieu NVARCHAR(255) NULL,
    SoLuong INT NOT NULL,
    PRIMARY KEY (maSanPham)
);

CREATE TABLE HopDong (
    maHopDong NVARCHAR(255) NOT NULL,
    maSanPham NVARCHAR(255) NULL,
	tenSanPham NVARCHAR(255) NULL,
	TenKhachHang NVARCHAR(255) NULL,
    maNhanVien NVARCHAR(255) NULL,
	tenNhanVien NVARCHAR(255) NULL,
    NgayLap DATE NULL,
    NgayGiao DATE NULL,
	SoLuong int NULL,
    DonGia FLOAT NOT NULL,
    PRIMARY KEY (maHopDong)
);


ALTER TABLE LuongNhanVien ADD CONSTRAINT FKLuong611492 FOREIGN KEY (maNhanVien) REFERENCES NhanVien (maNhanVien);
ALTER TABLE LuongCongNhan ADD CONSTRAINT FKLuong539741 FOREIGN KEY (maCongNhan) REFERENCES CongNhan (maCongNhan);
ALTER TABLE CongCuaNhanVien ADD CONSTRAINT FKCongCuaNha236440 FOREIGN KEY (maNhanVien) REFERENCES NhanVien (maNhanVien);
ALTER TABLE PhanCong ADD CONSTRAINT FKPhanCong515794 FOREIGN KEY (maCongNhan) REFERENCES CongNhan (maCongNhan);
ALTER TABLE PhanCong ADD CONSTRAINT FKPhanCong389344 FOREIGN KEY (maCongDoan) REFERENCES CongDoan (maCongDoan);
ALTER TABLE CongDoan ADD CONSTRAINT FKCongDoan495862 FOREIGN KEY (maSanPham) REFERENCES SanPham (maSanPham);
ALTER TABLE CongCuaCongNhan ADD CONSTRAINT FKCongCuaCon594751 FOREIGN KEY (maCongNhan) REFERENCES CongNhan (maCongNhan);
ALTER TABLE HopDong ADD CONSTRAINT FKHopDong769542 FOREIGN KEY (maNhanVien) REFERENCES NhanVien (maNhanVien);
ALTER TABLE HopDong ADD CONSTRAINT FKHopDong355434 FOREIGN KEY (maSanPham) REFERENCES SanPham (maSanPham);


use master