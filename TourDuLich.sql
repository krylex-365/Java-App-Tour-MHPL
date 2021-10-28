create database TOURDULICH;
go
use TOURDULICH;
go

create table LoaiHinhTour(
    MaLoai  nvarchar(50) primary key,
    TenLoai nvarchar(50),
    Status  int default 1
);

create table Tour(
    MaTour nvarchar(50) primary key,
    MaLoai nvarchar(50) not null,
    TenTour nvarchar(50),
    DacDiem nvarchar(100),
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
    ChiTietNoiDung nvarchar(100),
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
    GhiChu nvarchar(100),
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

create table MaDuLieuCuoi(
    MaLoai nvarchar(50),
    MaTour nvarchar(50),
    MaGia nvarchar(50),
    MaDiaDiem nvarchar(50),
    MaDoan nvarchar(50),
    MaKhachHang nvarchar(50),
    MaChiPhi nvarchar(50),
    MaLoaiChiPhi nvarchar(50),
    MaNhanVien nvarchar(50)
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


insert into LoaiHinhTour
values ('LH000001', 'Du lich', 1),
       ('LH000002', 'Tham quan', 1);

insert into Tour
values ('TR000001', 'LH000001', 'Nha Trang - Da Nang', 'Bai bien dep', 1),
       ('TR000002', 'LH000002', 'Hue - Vinh Ha Long', 'Canh quan dep', 1),
       ('TR000003', 'LH000001', 'Ha Tien - Phu Quoc', 'Khu nghi duong', 1);

insert into DiaDiem
values ('DD000001', 'Sai Gon', 1),
       ('DD000002', 'Nha Trang', 1),
       ('DD000003', 'Phu Quoc', 1),
       ('DD000004', 'Vinh Ha Long', 1),
       ('DD000005', 'Da Nang', 1),
       ('DD000006', 'Hue', 1),
       ('DD000007', 'Ha Tien', 1);

insert into DiaDiemThamQuan
values ('TR000001', 'DD000002', 1, 1),
       ('TR000001', 'DD000005', 2, 1),
       ('TR000002', 'DD000006', 1, 1),
       ('TR000002', 'DD000004', 2, 1),
       ('TR000003', 'DD000007', 1, 1),
       ('TR000003', 'DD000003', 2, 1);

insert into GiaTour
values ('GT000001', 'TR000001', '2500', '2021-09-01', '2021-12-31', 1, 1),
       ('GT000002', 'TR000002', '2000', '2022-01-01', '2022-04-30', 1, 1),
       ('GT000003', 'TR000003', '2200', '2022-05-01', '2021-08-31', 1, 1);

insert into DoanDuLich
values ('DL000001', 'TR000001', 'Doan 1', '2500', '2021-10-13', '2021-10-27', 'Vui ve than thien',1);

insert into MaDuLieuCuoi
values ('LH000002','TR000003','GT000003','DD000007','DL000001','KH000000','CP000000','LP000000','NV000000')

