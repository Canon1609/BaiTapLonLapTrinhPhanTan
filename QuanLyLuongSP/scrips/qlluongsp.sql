USE quanlyluongsp;

-- Chèn dữ liệu vào bảng TaiKhoan
INSERT INTO TaiKhoan (TaiKhoan, MatKhau) VALUES ('admin', 'admin123@');

-- Chèn dữ liệu vào bảng NhanVien
INSERT INTO NhanVien (maNhanVien, HoTen, CCCD, NgaySinh, GioiTinh, DiaChi, SoDienThoai, LuongCoBan, PhuCap, PhongBan, HeSoLuong)
VALUES ('NV01', 'Nguyen Van A', '123456789', '1990-01-01', 'Nam', '123 Duong ABC', '0123456789', 1000000, 500000, N'Quản Lý', 2.34),
       ('NV02', 'Tran Thi B', '987654321', '1995-05-05', N'Nữ', '456 Duong XYZ', '0987654321', 1200000, 600000, N'Nhân Sự', 2.34),
	    ('NV03', 'Nguyen Van E', '111111111', '1992-02-02', 'Nam', '789 Duong DEF', '0123456789', 1100000, 550000, N'Kế Toán', 2.34),
    ('NV04', 'Tran Thi F', '222222222', '1994-04-04', N'Nữ', '987 Duong LMN', '0987654321', 1300000, 650000, N'Kinh Doanh', 2.34),
    ('NV05', 'Le Van G', '333333333', '1991-03-03', 'Nam', '456 Duong GHI', '0123456789', 1000000, 500000, N'Kỹ Thuật', 2.34),
    ('NV06', 'Pham Thi H', '444444444', '1993-05-05', N'Nữ', '654 Duong KLM', '0987654321', 1200000, 600000, N'Quản Lý', 2.34),
    ('NV07', 'Hoang Van I', '555555555', '1990-06-06', 'Nam', '321 Duong JKL', '0123456789', 1500000, 750000, N'Thu Mua', 2.34),
    ('NV08', 'Tran Van K', '666666666', '1996-07-07', 'Nam', '159 Duong OPQ', '0987654321', 1400000, 700000, N'Sản Xuất', 2.34),
    ('NV09', 'Le Thi L', '777777777', '1989-08-08', N'Nữ', '357 Duong RST', '0123456789', 1600000, 800000, N'Thư Ký', 2.34),
    ('NV10', 'Nguyen Van M', '888888888', '1995-09-09', 'Nam', '753 Duong UVW', '0987654321', 1700000, 850000, N'Kế Toán', 2.34),
    ('NV11', 'Tran Thi N', '999999999', '1992-10-10', N'Nữ', '258 Duong XYZ', '0123456789', 1800000, 900000, N'Kinh Doanh', 2.34),
    ('NV12', 'Hoang Van O', '101010101', '1994-11-11', 'Nam', '852 Duong DEF', '0987654321', 1900000, 950000, N'Kỹ Thuật', 2.34),
    ('NV13', 'Le Thi P', '121212121', '1991-12-12', N'Nữ', '963 Duong GHI', '0123456789', 2000000, 1000000, N'Quản Lý', 2.34),
    ('NV14', 'Nguyen Van Q', '131313131', '1993-01-01', 'Nam', '741 Duong JKL', '0987654321', 2100000, 1050000, N'Thu Mua', 2.34),
    ('NV15', 'Tran Van R', '141414141', '1990-02-02', 'Nam', '159 Duong OPQ', '0123456789', 2200000, 1100000, N'Sản Xuất', 2.34),
    ('NV16', 'Le Thi S', '151515151', '1995-03-03', N'Nữ', '357 Duong RST', '0987654321', 2300000, 1150000, N'Thư Ký', 2.34),
    ('NV17', 'Nguyen Van T', '161616161', '1992-04-04', 'Nam', '753 Duong UVW', '0123456789', 2400000, 1200000, N'Kế Toán', 2.34);

-- Chèn dữ liệu vào bảng CongNhan
INSERT INTO CongNhan (maCongNhan, HoTen, GioiTinh, NgaySinh, CCCD, SoDienThoai, PhuCap, PhongBan, TrinhDoTayNghe, DiaChi)
VALUES ('CN01', 'Nguyen Van C', 'Nam', '1988-08-08', '234567890', '0123456789', 600000, N'Kỹ Thuật', 'Ky su', N'789 Đường XYZ'),
       ('CN02', 'Tran Thi D', N'Nữ', '1993-03-03', '678901234', '0987654321', 700000, N'Sản Xuất', 'Cong nhan', N'345 Đường ABC'),
	   ('CN03', 'Nguyen Van U', 'Nam', '1987-07-07', '444444444', '0123456789', 800000, N'Kỹ Thuật', 'Cong nhan', N'789 Đường XYZ'),
    ('CN04', 'Tran Thi V', N'Nữ', '1996-06-06', '555555555', '0987654321', 900000, N'Sản Xuất', 'Ky su', N'345 Đường ABC'),
    ('CN05', 'Le Van W', 'Nam', '1993-05-05', '666666666', '0123456789', 700000, N'Kỹ Thuật', 'Cong nhan', N'789 Đường DEF'),
    ('CN06', 'Pham Thi X', N'Nữ', '1992-04-04', '777777777', '0987654321', 600000, N'Sản Xuất', 'Ky su', N'345 Đường XYZ'),
    ('CN07', 'Hoang Van Y', 'Nam', '1991-03-03', '888888888', '0123456789', 500000, N'Kỹ Thuật', 'Cong nhan', N'789 Đường GHI'),
    ('CN08', 'Tran Van Z', 'Nam', '1990-02-02', '999999999', '0987654321', 400000, N'Sản Xuất', 'Ky su', N'345 Đường LMN'),
    ('CN09', 'Le Thi A', N'Nữ', '1989-01-01', '101010101', '0123456789', 300000, N'Kỹ Thuật', 'Cong nhan', N'789 Đường OPQ'),
    ('CN10', 'Nguyen Van B', 'Nam', '1988-12-12', '121212121', '0987654321', 200000, N'Sản Xuất', 'Ky su', N'345 Đường RST'),
    ('CN11', 'Tran Thi C', N'Nữ', '1987-11-11', '131313131', '0123456789', 100000, N'Kỹ Thuật', 'Cong nhan', N'789 Đường UVW'),
    ('CN12', 'Hoang Van D', 'Nam', '1986-10-10', '141414141', '0987654321', 90000, N'Sản Xuất', 'Ky su', N'345 Đường XYZ'),
    ('CN13', 'Le Thi E', N'Nữ', '1985-09-09', '151515151', '0123456789', 80000, N'Kỹ Thuật', 'Cong nhan', N'789 Đường ABC'),
    ('CN14', 'Nguyen Van F', 'Nam', '1984-08-08', '161616161', '0987654321', 70000, N'Sản Xuất', 'Ky su', N'345 Đường DEF'),
    ('CN15', 'Tran Thi G', N'Nữ', '1983-07-07', '171717171', '0123456789', 60000, N'Kỹ Thuật', 'Cong nhan', N'789 Đường GHI'),
    ('CN16', 'Hoang Van H', 'Nam', '1982-06-06', '181818181', '0987654321', 50000, N'Sản Xuất', 'Ky su', N'345 Đường LMN');

-- Chèn dữ liệu vào bảng SanPham
INSERT INTO SanPham (maSanPham, TenSanPham, KieuDang, ChatLieu, SoLuong)
VALUES ('SP01', 'San pham A', 'Kieu dang A', 'Chat lieu A', 100),
       ('SP02', 'San pham B', 'Kieu dang B', 'Chat lieu B', 150),
	    ('SP03', 'Sản phẩm C', 'Kiểu dáng C', 'Chất liệu C', 200),
    ('SP04', 'Sản phẩm D', 'Kiểu dáng D', 'Chất liệu D', 250),
    ('SP05', 'Sản phẩm E', 'Kiểu dáng E', 'Chất liệu E', 300),
    ('SP06', 'Sản phẩm F', 'Kiểu dáng F', 'Chất liệu F', 180),
    ('SP07', 'Sản phẩm G', 'Kiểu dáng G', 'Chất liệu G', 220),
    ('SP08', 'Sản phẩm H', 'Kiểu dáng H', 'Chất liệu H', 280),
    ('SP09', 'Sản phẩm I', 'Kiểu dáng I', 'Chất liệu I', 320),
    ('SP10', 'Sản phẩm J', 'Kiểu dáng J', 'Chất liệu J', 200),
    ('SP11', 'Sản phẩm K', 'Kiểu dáng K', 'Chất liệu K', 240),
    ('SP12', 'Sản phẩm L', 'Kiểu dáng L', 'Chất liệu L', 280),
    ('SP13', 'Sản phẩm M', 'Kiểu dáng M', 'Chất liệu M', 260),
    ('SP14', 'Sản phẩm N', 'Kiểu dáng N', 'Chất liệu N', 300),
    ('SP15', 'Sản phẩm O', 'Kiểu dáng O', 'Chất liệu O', 320),
    ('SP16', 'Sản phẩm P', 'Kiểu dáng P', 'Chất liệu P', 180),
    ('SP17', 'Sản phẩm Q', 'Kiểu dáng Q', 'Chất liệu Q', 220);

-- Chèn dữ liệu vào bảng CongDoan
INSERT INTO CongDoan (maCongDoan, congDoanYeuCau, GiaCongDoan, soLuong, TenCongDoan, tenSanPham, maSanPham)
VALUES 
    ('CD01', N'May vá', 50000, 100, 'Cong doan 1', 'Ao so mi', 'SP01'),
    ('CD02', N'Sơn phủ', 70000, 80, 'Cong doan 2', 'Giày thể thao', 'SP02'),
	 ('CD03', N'Kiểm tra', 80000, 150, 'Công đoạn 3', 'Sản phẩm C', 'SP03'),
    ('CD04', N'Đóng gói', 90000, 120, 'Công đoạn 4', 'Sản phẩm D', 'SP04'),
    ('CD05', N'Vận chuyển', 100000, 180, 'Công đoạn 5', 'Sản phẩm E', 'SP05'),
    ('CD06', N'Kiểm tra', 110000, 200, 'Công đoạn 6', 'Sản phẩm F', 'SP06'),
    ('CD07', N'Đóng gói', 120000, 220, 'Công đoạn 7', 'Sản phẩm G', 'SP07'),
    ('CD08', N'Vận chuyển', 130000, 240, 'Công đoạn 8', 'Sản phẩm H', 'SP08'),
    ('CD09', N'Kiểm tra', 140000, 260, 'Công đoạn 9', 'Sản phẩm I', 'SP09'),
    ('CD10', N'Đóng gói', 150000, 280, 'Công đoạn 10', 'Sản phẩm J', 'SP10'),
    ('CD11', N'Vận chuyển', 160000, 300, 'Công đoạn 11', 'Sản phẩm K', 'SP11'),
    ('CD12', N'Kiểm tra', 170000, 320, 'Công đoạn 12', 'Sản phẩm L', 'SP12'),
    ('CD13', N'Đóng gói', 180000, 340, 'Công đoạn 13', 'Sản phẩm M', 'SP13'),
    ('CD14', N'Vận chuyển', 190000, 360, 'Công đoạn 14', 'Sản phẩm N', 'SP14'),
    ('CD15', N'Kiểm tra', 200000, 380, 'Công đoạn 15', 'Sản phẩm O', 'SP15'),
    ('CD16', N'Đóng gói', 210000, 400, 'Công đoạn 16', 'Sản phẩm P', 'SP16'),
    ('CD17', N'Vận chuyển', 220000, 420, 'Công đoạn 17', 'Sản phẩm Q', 'SP17');

-- Chèn dữ liệu vào bảng CongCuaNhanVien
INSERT INTO CongCuaNhanVien (maCongCuaNhanVien, maNhanVien, NgayChamCong, CaLam, GioLam, LuongCaLam, TrangThai, NghiPhep)
VALUES ('C01', 'NV01', '2024-04-01', N'Ca sáng', '8h-12h', 1, N'Có Mặt', N'Không'),
       ('C02', 'NV02', '2024-04-01', N'Ca chiều', '13h-17h', 1, N'Có Mặt', N'Không'),
	    ('C03', 'NV03', '2024-04-02', N'Ca sáng', '8h-12h', 1, N'Có Mặt', N'Không'),
    ('C04', 'NV04', '2024-04-02', N'Ca chiều', '13h-17h', 1, N'Có Mặt', N'Không'),
    ('C05', 'NV05', '2024-04-03', N'Ca sáng', '8h-12h', 1, N'Có Mặt', N'Không'),
    ('C06', 'NV06', '2024-04-03', N'Ca chiều', '13h-17h', 1, N'Có Mặt', N'Không'),
    ('C07', 'NV07', '2024-04-04', N'Ca sáng', '8h-12h', 1, N'Có Mặt', N'Không'),
    ('C08', 'NV08', '2024-04-04', N'Ca chiều', '13h-17h', 1, N'Có Mặt', N'Không'),
    ('C09', 'NV09', '2024-04-05', N'Ca sáng', '8h-12h', 1, N'Có Mặt', N'Không'),
    ('C10', 'NV10', '2024-04-05', N'Ca chiều', '13h-17h', 1, N'Có Mặt', N'Không'),
    ('C11', 'NV11', '2024-04-06', N'Ca sáng', '8h-12h', 1, N'Có Mặt', N'Không'),
    ('C12', 'NV12', '2024-04-06', N'Ca chiều', '13h-17h', 1, N'Có Mặt', N'Không'),
    ('C13', 'NV13', '2024-04-07', N'Ca sáng', '8h-12h', 1, N'Có Mặt', N'Không'),
    ('C14', 'NV14', '2024-04-07', N'Ca chiều', '13h-17h', 1, N'Có Mặt', N'Không'),
    ('C15', 'NV15', '2024-04-08', N'Ca sáng', '8h-12h', 1, N'Có Mặt', N'Không'),
    ('C16', 'NV16', '2024-04-08', N'Ca chiều', '13h-17h', 1, N'Có Mặt', N'Không'),
    ('C17', 'NV17', '2024-04-09', N'Ca sáng', '8h-12h', 1, N'Có Mặt', N'Không');

-- Chèn dữ liệu vào bảng PhanCong
INSERT INTO PhanCong (maPhanCong, soLuongSanPhamCanLam, tenCongDoan, tenCongNhan, maCongDoan, maCongNhan)
VALUES 
    ('PC01', 100, 'Cong Doan A', 'Nguyen Van A', 'CD01', 'CN01'),
    ('PC02', 120, 'Cong Doan B', 'Tran Thi B', 'CD02', 'CN02'),
	 ('PC03', 150, 'Công đoạn 3', 'Nguyen Van U', 'CD03', 'CN03'),
    ('PC04', 180, 'Công đoạn 4', 'Tran Thi V', 'CD04', 'CN04'),
    ('PC05', 200, 'Công đoạn 5', 'Le Van W', 'CD05', 'CN05'),
    ('PC06', 220, 'Công đoạn 6', 'Pham Thi X', 'CD06', 'CN06'),
    ('PC07', 240, 'Công đoạn 7', 'Hoang Van Y', 'CD07', 'CN07'),
    ('PC08', 260, 'Công đoạn 8', 'Tran Van Z', 'CD08', 'CN08'),
    ('PC09', 280, 'Công đoạn 9', 'Le Thi A', 'CD09', 'CN09'),
    ('PC10', 300, 'Công đoạn 10', 'Nguyen Van B', 'CD10', 'CN10'),
    ('PC11', 320, 'Công đoạn 11', 'Tran Thi C', 'CD11', 'CN11'),
    ('PC12', 340, 'Công đoạn 12', 'Hoang Van D', 'CD12', 'CN12'),
    ('PC13', 360, 'Công đoạn 13', 'Le Thi E', 'CD13', 'CN13'),
    ('PC14', 380, 'Công đoạn 14', 'Nguyen Van F', 'CD14', 'CN14'),
    ('PC15', 400, 'Công đoạn 15', 'Tran Thi G', 'CD15', 'CN15'),
    ('PC16', 420, 'Công đoạn 16', 'Hoang Van H', 'CD16', 'CN16'),
    ('PC17', 440, 'Công đoạn 17', 'Nguyen Van I', 'CD17', 'CN17');

-- Chèn dữ liệu vào bảng CongCuaCongNhan
INSERT INTO CongCuaCongNhan (maCongCuaCongNhan, caLam, gioLam, luongCaLam, ngayChamCong, nghiPhep, soLuongSanPhamDaLam, tenCongDoan, tenCongNhan, trangThai, maCongNhan, maCongDoan, maPhanCong)
VALUES ('C01', N'Ca sáng', '8h-12h', 300000, '2024-04-05', N'Không', 80, 'Cong doan 1', 'Nguyen Van C', N'Có mặt', 'CN01', 'CD01', 'PC01'),
       ('C02', N'Ca chiều', '13h-17h', 250000, '2024-04-06', N'Không', 70, 'Cong doan 2', 'Tran Thi D', N'Có mặt', 'CN02', 'CD02', 'PC02'),
	     ('C03', N'Ca sáng', '8h-12h', 240000, '2024-04-10', N'Không', 130, 'Công đoạn 3', 'Nguyen Van U', N'Có mặt', 'CN03', 'CD03', 'PC03'),
    ('C04', N'Ca chiều', '13h-17h', 270000, '2024-04-11', N'Không', 140, 'Công đoạn 4', 'Tran Thi V', N'Có mặt', 'CN04', 'CD04', 'PC04'),
    ('C05', N'Ca sáng', '8h-12h', 300000, '2024-04-12', N'Không', 150, 'Công đoạn 5', 'Le Van W', N'Có mặt', 'CN05', 'CD05', 'PC05'),
    ('C06', N'Ca chiều', '13h-17h', 330000, '2024-04-13', N'Không', 160, 'Công đoạn 6', 'Pham Thi X', N'Có mặt', 'CN06', 'CD06', 'PC06'),
    ('C07', N'Ca sáng', '8h-12h', 360000, '2024-04-14', N'Không', 170, 'Công đoạn 7', 'Hoang Van Y', N'Có mặt', 'CN07', 'CD07', 'PC07'),
    ('C08', N'Ca chiều', '13h-17h', 390000, '2024-04-15', N'Không', 180, 'Công đoạn 8', 'Tran Van Z', N'Có mặt', 'CN08', 'CD08', 'PC08'),
    ('C09', N'Ca sáng', '8h-12h', 420000, '2024-04-16', N'Không', 190, 'Công đoạn 9', 'Le Thi A', N'Có mặt', 'CN09', 'CD09', 'PC09'),
    ('C10', N'Ca chiều', '13h-17h', 450000, '2024-04-17', N'Không', 200, 'Công đoạn 10', 'Nguyen Van B', N'Có mặt', 'CN10', 'CD10', 'PC10'),
    ('C11', N'Ca sáng', '8h-12h', 480000, '2024-04-18', N'Không', 210, 'Công đoạn 11', 'Tran Thi C', N'Có mặt', 'CN11', 'CD11', 'PC11'),
    ('C12', N'Ca chiều', '13h-17h', 510000, '2024-04-19', N'Không', 220, 'Công đoạn 12', 'Hoang Van D', N'Có mặt', 'CN12', 'CD12', 'PC12'),
    ('C13', N'Ca sáng', '8h-12h', 540000, '2024-04-20', N'Không', 230, 'Công đoạn 13', 'Le Thi E', N'Có mặt', 'CN13', 'CD13', 'PC13'),
    ('C14', N'Ca chiều', '13h-17h', 570000, '2024-04-21', N'Không', 240, 'Công đoạn 14', 'Nguyen Van F', N'Có mặt', 'CN14', 'CD14', 'PC14'),
    ('C15', N'Ca sáng', '8h-12h', 600000, '2024-04-22', N'Không', 250, 'Công đoạn 15', 'Tran Thi G', N'Có mặt', 'CN15', 'CD15', 'PC15'),
    ('C16', N'Ca chiều', '13h-17h', 630000, '2024-04-23', N'Không', 260, 'Công đoạn 16', 'Hoang Van H', N'Có mặt', 'CN16', 'CD16', 'PC16'),
    ('C17', N'Ca sáng', '8h-12h', 660000, '2024-04-24', N'Không', 270, 'Công đoạn 17', 'Nguyen Van I', N'Có mặt', 'CN17', 'CD17', 'PC17');

-- Chèn dữ liệu vào bảng HopDong
INSERT INTO HopDong (maHopDong, donGia, ngayGiao, ngayLap, soLuong, tenKhachHang, tenNhanVien, tenSanPham, maNhanVien, maSanPham)
VALUES 
    ('HD01', 200000, '2024-05-01', '2024-04-20', 50, N'Công ty ABC', 'Nguyen Van A', 'Ao so mi', 'NV01', 'SP01'),
    ('HD02', 300000, '2024-05-05', '2024-04-22', 30, N'Công ty XYZ', 'Tran Thi B', N'Giày thể thao', 'NV02', 'SP02'),
	 ('HD03', 250000, '2024-05-10', '2024-04-25', 70, N'Công ty DEF', 'Nguyen Van E', 'Sản phẩm C', 'NV03', 'SP03'),
    ('HD04', 350000, '2024-05-15', '2024-04-26', 40, N'Công ty GHI', 'Tran Thi F', 'Sản phẩm D', 'NV04', 'SP04'),
    ('HD05', 450000, '2024-05-20', '2024-04-27', 60, N'Công ty JKL', 'Le Van G', 'Sản phẩm E', 'NV05', 'SP05'),
    ('HD06', 550000, '2024-05-25', '2024-04-28', 80, N'Công ty MNO', 'Pham Thi H', 'Sản phẩm F', 'NV06', 'SP06'),
    ('HD07', 650000, '2024-05-30', '2024-04-29', 90, N'Công ty PQR', 'Hoang Van I', 'Sản phẩm G', 'NV07', 'SP07'),
    ('HD08', 750000, '2024-06-05', '2024-04-30', 100, N'Công ty STU', 'Tran Van K', 'Sản phẩm H', 'NV08', 'SP08'),
    ('HD09', 850000, '2024-06-10', '2024-05-01', 110, N'Công ty VWX', 'Le Thi L', 'Sản phẩm I', 'NV09', 'SP09'),
    ('HD10', 950000, '2024-06-15', '2024-05-02', 120, N'Công ty YZA', 'Nguyen Van M', 'Sản phẩm J', 'NV10', 'SP10'),
    ('HD11', 1050000, '2024-06-20', '2024-05-03', 130, N'Công ty BCD', 'Tran Thi N', 'Sản phẩm K', 'NV11', 'SP11'),
    ('HD12', 1150000, '2024-06-25', '2024-05-04', 140, N'Công ty EFG', 'Hoang Van O', 'Sản phẩm L', 'NV12', 'SP12'),
    ('HD13', 1250000, '2024-06-30', '2024-05-05', 150, N'Công ty HIJ', 'Le Thi P', 'Sản phẩm M', 'NV13', 'SP13'),
    ('HD14', 1350000, '2024-07-05', '2024-05-06', 160, N'Công ty KLM', 'Nguyen Van Q', 'Sản phẩm N', 'NV14', 'SP14'),
    ('HD15', 1450000, '2024-07-10', '2024-05-07', 170, N'Công ty NOP', 'Tran Thi R', 'Sản phẩm O', 'NV15', 'SP15'),
    ('HD16', 1550000, '2024-07-15', '2024-05-08', 180, N'Công ty QRS', 'Hoang Van S', 'Sản phẩm P', 'NV16', 'SP16'),
    ('HD17', 1650000, '2024-07-20', '2024-05-09', 190, N'Công ty TUV', 'Nguyen Van T', 'Sản phẩm Q', 'NV17', 'SP17');

-- Chèn dữ liệu vào bảng LuongCongNhan
INSERT INTO LuongCongNhan (maLuongCongNhan, namNhan, thangNhan, soNgayDiLam, tenCongNhan, ThucNhan, maCongNhan)
VALUES 
    ('L01', 2024, 4, 22, 'Nguyen Van A', 5000000, 'CN01'),
    ('L02', 2024, 4, 20, 'Tran Thi B', 4500000, 'CN02'),
	 ('L03', 2024, 4, 22, 'Nguyen Van U', 6000000, 'CN03'),
    ('L04', 2024, 4, 20, 'Tran Thi V', 5500000, 'CN04'),
    ('L05', 2024, 4, 20, 'Le Van W', 5000000, 'CN05'),
    ('L06', 2024, 4, 22, 'Pham Thi X', 6000000, 'CN06'),
    ('L07', 2024, 4, 24, 'Hoang Van Y', 7000000, 'CN07'),
    ('L08', 2024, 4, 22, 'Tran Van Z', 6000000, 'CN08'),
    ('L09', 2024, 4, 20, 'Le Thi A', 5000000, 'CN09'),
    ('L10', 2024, 4, 20, 'Nguyen Van B', 5000000, 'CN10'),
    ('L11', 2024, 4, 22, 'Tran Thi C', 6000000, 'CN11'),
    ('L12', 2024, 4, 24, 'Hoang Van D', 7000000, 'CN12'),
    ('L13', 2024, 4, 22, 'Le Thi E', 6000000, 'CN13'),
    ('L14', 2024, 4, 20, 'Nguyen Van F', 5000000, 'CN14'),
    ('L15', 2024, 4, 20, 'Tran Thi G', 5000000, 'CN15'),
    ('L16', 2024, 4, 22, 'Hoang Van H', 6000000, 'CN16'),
    ('L17', 2024, 4, 24, 'Nguyen Van I', 7000000, 'CN17');

-- Chèn dữ liệu vào bảng LuongNhanVien
INSERT INTO LuongNhanVien (maLuongNhanVien, namNhan, thangNhan, soNgayDiLam, tenNhanVien, thucNhan, maNhanVien)
VALUES 
    ('L01', 2024, 4, 22, 'Nguyen Van A', 7000000, 'NV01'),
    ('L02', 2024, 4, 20, 'Tran Thi B', 6500000, 'NV02'),
	 ('L03', 2024, 4, 22, 'Nguyen Van E', 7500000, 'NV03'),
    ('L04', 2024, 4, 20, 'Tran Thi F', 7000000, 'NV04'),
    ('L05', 2024, 4, 20, 'Le Van G', 6500000, 'NV05'),
    ('L06', 2024, 4, 22, 'Pham Thi H', 7500000, 'NV06'),
    ('L07', 2024, 4, 24, 'Hoang Van I', 8500000, 'NV07'),
    ('L08', 2024, 4, 22, 'Tran Van K', 7500000, 'NV08'),
    ('L09', 2024, 4, 20, 'Le Thi L', 6500000, 'NV09'),
    ('L10', 2024, 4, 20, 'Nguyen Van M', 6500000, 'NV10'),
    ('L11', 2024, 4, 22, 'Tran Thi N', 7500000, 'NV11'),
    ('L12', 2024, 4, 24, 'Hoang Van O', 8500000, 'NV12'),
    ('L13', 2024, 4, 22, 'Le Thi P', 7500000, 'NV13'),
    ('L14', 2024, 4, 20, 'Nguyen Van Q', 6500000, 'NV14'),
    ('L15', 2024, 4, 20, 'Tran Thi R', 6500000, 'NV15'),
    ('L16', 2024, 4, 22, 'Hoang Van S', 7500000, 'NV16'),
    ('L17', 2024, 4, 24, 'Nguyen Van T', 8500000, 'NV17');
