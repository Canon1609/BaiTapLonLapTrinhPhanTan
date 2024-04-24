USE quanlyluongsp;

-- Chèn dữ liệu vào bảng TaiKhoan
INSERT INTO TaiKhoan (TaiKhoan, MatKhau) VALUES ('admin', 'admin123@');

-- Chèn dữ liệu vào bảng NhanVien
INSERT INTO NhanVien (maNhanVien, HoTen, CCCD, NgaySinh, GioiTinh, DiaChi, SoDienThoai, LuongCoBan, PhuCap, PhongBan, HeSoLuong)
VALUES ('NV01', 'Nguyen Van A', '123456789', '1990-01-01', 'Nam', '123 Duong ABC', '0123456789', 1000000, 500000, N'Quản Lý', 2.34),
       ('NV02', 'Tran Thi B', '987654321', '1995-05-05', N'Nữ', '456 Duong XYZ', '0987654321', 1200000, 600000, N'Nhân Sự', 2.34);

-- Chèn dữ liệu vào bảng CongNhan
INSERT INTO CongNhan (maCongNhan, HoTen, GioiTinh, NgaySinh, CCCD, SoDienThoai, PhuCap, PhongBan, TrinhDoTayNghe, DiaChi)
VALUES ('CN01', 'Nguyen Van C', 'Nam', '1988-08-08', '234567890', '0123456789', 600000, N'Kỹ Thuật', 'Ky su', N'789 Đường XYZ'),
       ('CN02', 'Tran Thi D', N'Nữ', '1993-03-03', '678901234', '0987654321', 700000, N'Sản Xuất', 'Cong nhan', N'345 Đường ABC');

-- Chèn dữ liệu vào bảng SanPham
INSERT INTO SanPham (maSanPham, TenSanPham, KieuDang, ChatLieu, SoLuong)
VALUES ('SP01', 'San pham A', 'Kieu dang A', 'Chat lieu A', 100),
       ('SP02', 'San pham B', 'Kieu dang B', 'Chat lieu B', 150);

-- Chèn dữ liệu vào bảng CongDoan
INSERT INTO CongDoan (maCongDoan, congDoanYeuCau, GiaCongDoan, soLuong, TenCongDoan, tenSanPham, maSanPham)
VALUES 
    ('CD01', N'May vá', 50000, 100, 'Cong doan 1', 'Ao so mi', 'SP01'),
    ('CD02', N'Sơn phủ', 70000, 80, 'Cong doan 2', N'Giày thể thao', 'SP02');

-- Chèn dữ liệu vào bảng CongCuaNhanVien
INSERT INTO CongCuaNhanVien (maCongCuaNhanVien, maNhanVien, NgayChamCong, CaLam, GioLam, LuongCaLam, TrangThai, NghiPhep)
VALUES ('C01', 'NV01', '2024-04-01', N'Ca sáng', '8h-12h', 1, N'Có mặt', N'Không'),
       ('C02', 'NV02', '2024-04-01', N'Ca chiều', '13h-17h', 1, N'Có mặt', N'Không');

-- Chèn dữ liệu vào bảng PhanCong
INSERT INTO PhanCong (maPhanCong, soLuongSanPhamCanLam, tenCongDoan, tenCongNhan, maCongDoan, maCongNhan)
VALUES 
    ('PC01', 100, 'Cong Doan A', 'Nguyen Van A', 'CD01', 'CN01'),
    ('PC02', 120, 'Cong Doan B', 'Tran Thi B', 'CD02', 'CN02');

-- Chèn dữ liệu vào bảng CongCuaCongNhan
INSERT INTO CongCuaCongNhan (maCongCuaCongNhan, caLam, gioLam, luongCaLam, ngayChamCong, nghiPhep, soLuongSanPhamDaLam, tenCongDoan, tenCongNhan, trangThai, maCongNhan, maCongDoan, maPhanCong)
VALUES ('C01', N'Ca sáng', '8h-12h', 300000, '2024-04-05', N'Không', 80, 'Cong doan 1', 'Nguyen Van C', N'Có mặt', 'CN01', 'CD01', 'PC01'),
       ('C02', N'Ca chiều', '13h-17h', 250000, '2024-04-06', N'Không', 70, 'Cong doan 2', 'Tran Thi D', N'Có mặt', 'CN02', 'CD02', 'PC02');

-- Chèn dữ liệu vào bảng HopDong
INSERT INTO HopDong (maHopDong, donGia, ngayGiao, ngayLap, soLuong, tenKhachHang, tenNhanVien, tenSanPham, maNhanVien, maSanPham)
VALUES 
    ('HD01', 200000, '2024-05-01', '2024-04-20', 50, N'Công ty ABC', 'Nguyen Van A', 'Ao so mi', 'NV01', 'SP01'),
    ('HD02', 300000, '2024-05-05', '2024-04-22', 30, N'Công ty XYZ', 'Tran Thi B', N'Giày thể thao', 'NV02', 'SP02');

-- Chèn dữ liệu vào bảng LuongCongNhan
INSERT INTO LuongCongNhan (maLuongCongNhan, namNhan, thangNhan, soNgayDiLam, tenCongNhan, ThucNhan, maCongNhan)
VALUES 
    ('L01', 2024, 4, 22, 'Nguyen Van A', 5000000, 'CN01'),
    ('L02', 2024, 4, 20, 'Tran Thi B', 4500000, 'CN02');

-- Chèn dữ liệu vào bảng LuongNhanVien
INSERT INTO LuongNhanVien (maLuongNhanVien, namNhan, thangNhan, soNgayDiLam, tenNhanVien, thucNhan, maNhanVien)
VALUES 
    ('L01', 2024, 4, 22, 'Nguyen Van A', 7000000, 'NV01'),
    ('L02', 2024, 4, 20, 'Tran Thi B', 6500000, 'NV02');
