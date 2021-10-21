create database TOURDULICH;
go
use TOURDULICH;
go

create table LoaiHinhTour(
	MaLoai nvarchar(50) primary key,
	TenLoai nvarchar(50),
    Status int default 1
);

create table Tour(
	MaTour nvarchar(50) primary key,
	MaLoai nvarchar(50) not null,
	TenTour nvarchar(50),
	DacDiem nvarchar,
    Status int default 1
);

create table GiaTour(
	MaGia nvarchar(50) primary key,
	MaTour nvarchar(50) not null,
	ThanhTien nvarchar(50),
	TgBatDau date,
	TgKetThuc date,
	HienHanh int,
    Status int default 1
);

create table DiaDiemThamQuan(
	MaTour nvarchar(50) not null,
	MaDiaDiem nvarchar(50) not null,
	ThuTu int not null,
    Status int default 1,
	primary key (MaTour, MaDiaDiem, ThuTu)
);

create table DiaDiem(
	MaDiaDiem nvarchar(50) primary key,
	TenDiaDiem nvarchar(50),
    Status int default 1
);

create table DoanDuLich(
	MaDoan nvarchar(50) primary key,
	MaTour nvarchar(50) not null,
	TenDoan nvarchar(50),
	GiaTour nvarchar(50),
	NgayKhoiHanh date,
	NgayKetThuc date,
	ChiTietNoiDung nvarchar,
    Status int default 1
);

create table ChiTietDoan(
	MaDoan nvarchar(50) not null,
	MaKhachHang nvarchar(50) not null,
    Status int default 1,
	primary key (MaDoan, MaKhachHang)
);

create table KhachHang(
	MaKhachHang nvarchar(50) primary key,
	TenKhachHang nvarchar(50),
	Cmnd nvarchar(50),
	DiaChi nvarchar(50),
	GioiTinh nvarchar(50),
	Sdt nvarchar(50),
	Mail nvarchar(50),
	QuocTich nvarchar(50),
	Status int default 1
);

create table ChiPhi(
	MaChiPhi nvarchar(50) primary key,
	MaDoan nvarchar(50) not null,
	MaLoaiChiPhi nvarchar(50),
	SoTien nvarchar(50),
	GhiChu nvarchar,
    Status int default 1
);

create table LoaiChiPhi(
	MaLoaiChiPhi nvarchar(50) primary key,
	TenLoai nvarchar(50),
    Status int default 1
);

create table NhiemVuNhanVien(
	MaNhanVien nvarchar(50) not null,
	MaDoan nvarchar(50) not null,
	TenNhiemVu nvarchar(50),
    Status int default 1
);

create table NhanVien(
	MaNhanVien nvarchar(50) primary key,
	TenNhanVien nvarchar(50),
	Sdt nvarchar(50),
	DiaChi nvarchar(50),
    Status int default 1
);

go



alter table NhiemVuNhanVien add constraint Fk_NhiemVuNhanVien_NhanVien
foreign key (MaNhanVien) references NhanVien(MaNhanVien);
alter table NhiemVuNhanVien add constraint Fk_NhiemVuNhanVien_DoanDuLich
foreign key (MaDoan) references DoanDuLich(MaDoan);

alter table ChiPhi add constraint Fk_ChiPhi_DoanDuLich
foreign key (MaDoan) references DoanDuLich(MaDoan);
alter table ChiPhi add constraint Fk_ChiPhi_LoaiChiPhi
foreign key (MaLoaiChiPhi) references LoaiChiPhi(MaLoaiChiPhi);

alter table ChiTietDoan add constraint Fk_ChiTietDoan_DoanDuLich
foreign key (MaDoan) references DoanDuLich(MaDoan);
alter table ChiTietDoan add constraint Fk_ChiTietDoan_KhachHang
foreign key (MaKhachHang) references KhachHang(MaKhachHang);

alter table DoanDuLich add constraint Fk_DoanDuLich_Tour
foreign key (MaTour) references Tour(MaTour);

alter table DiaDiemThamQuan add constraint Fk_DiaDiemThamQuan_Tour
foreign key (MaTour) references Tour(MaTour);
alter table DiaDiemThamQuan add constraint Fk_DiaDiemThamQuan_DiaDiem
foreign key (MaDiaDiem) references DiaDiem(MaDiaDiem);

alter table GiaTour add constraint Fk_GiaTour_Tour
foreign key (MaTour) references Tour(MaTour);

alter table Tour add constraint Fk_Tour_LoaiHinhTour
foreign key (MaLoai) references LoaiHinhTour(MaLoai);

