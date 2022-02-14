package com.huy.view;

import com.huy.controller.QuanLyThucPham;
import com.huy.model.ThucPham;

import java.util.Scanner;

public class MenuThucPham {
    public Scanner scanner = new Scanner(System.in);

    public void run() {
        QuanLyThucPham quanLyThucPham = new QuanLyThucPham();
        int choice = -1;
        do {
            menu();
            System.out.println("Nhập Lựa chọn");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    hienThiSanPham(quanLyThucPham);
                    break;
                }
                case 2: {
                    taoSanpham(quanLyThucPham);
                    break;
                }
                case 3: {
                    capNhatSanPham(quanLyThucPham);
                    break;
                }
                case 4: {
                    xoaSanPham(quanLyThucPham);
                    break;
                }
                case 5: {
                    quanLyThucPham.xapXepLuaChon();
                    break;
                }
                case 6: {
                    timkiemSanPham(quanLyThucPham);
                    break;
                }
            }
        } while (choice != 0);
    }

    private void timkiemSanPham(QuanLyThucPham quanLyThucPham) {
        System.out.println("Tìm Kiếm Sản Phẩm");
        System.out.println("Nhập mã Sản Phẩm cần tìm");
        scanner.nextLine();
        String id = scanner.nextLine();
        int index = quanLyThucPham.timSanphamBangId(id);
        if (index != -1) {
            System.out.println("Thông tin Sản Phẩm cần tìm" + quanLyThucPham.getThucPham(index));
        } else {
            System.out.println("Không có Sản Phẩm");
        }
    }

    private void xoaSanPham(QuanLyThucPham quanLyThucPham) {
        System.out.println("Xóa Sản Phẩm");
        System.out.println("Nhập mã Sản Phẩm cần xóa");
        String id = scanner.nextLine();
        boolean isDelete = quanLyThucPham.XoaSanphamBangId(id);
        if (isDelete) {
            System.out.println("Đã xóa");
        } else {
            System.out.println("không có mã Sản Phẩm để xóa");
        }
    }

    private void capNhatSanPham(QuanLyThucPham quanLyThucPham) {
        System.out.println("Sửa thông tin Sản Phẩm ");
        System.out.println("Nhập mã Sản Phẩm");
        String id = scanner.nextLine();
        int index = quanLyThucPham.timSanphamBangId(id);
        if (index != -1) {
            ThucPham thucPham = thongTinSanPham();
            quanLyThucPham.CapnhapSanphamBangId(id, thucPham);
            System.out.println("Đã cập nhập");
        } else {
            System.out.println("Không có mã Sảm phẩm");
        }
    }

    private void taoSanpham(QuanLyThucPham quanLyThucPham) {
        System.out.println("Thêm Sản Phẩm");
        ThucPham thucPham = thongTinSanPham();
        quanLyThucPham.themSanPham(thucPham);
    }

    private void hienThiSanPham(QuanLyThucPham quanLyThucPham) {
        int size = quanLyThucPham.size();
        if (size == 0) {
            System.out.println("Đã Hết Hàng");
        } else {
            System.out.println("Danh sách Thực Phẩm");
            quanLyThucPham.displayAllSanPham();
        }
    }

    private ThucPham thongTinSanPham() {
        System.out.println("Nhập mã Sản Phẩm");
        scanner.nextLine();
        String id = scanner.nextLine();
        System.out.println("Nhập tên Sản Phẩm");
        String name = scanner.nextLine();
        System.out.println("Nhập nguồn gốc Sản Phẩm");
        String nguonGoc = scanner.nextLine();
        System.out.println("Nhập gian hàng");
        String gianHang = scanner.nextLine();
        System.out.println("Nhập Giá tiền");
        double giaTien = scanner.nextInt();
        ThucPham thucPham = new ThucPham(id, name, nguonGoc, gianHang, giaTien);
        return thucPham;
    }

    public void menu() {
        System.out.println("1. Xem danh sách Sản Phẩm");
        System.out.println("2. Thêm Sản Phẩm mới");
        System.out.println("3. Cập nhập Sản Phẩm");
        System.out.println("4. Xóa");
        System.out.println("5. Sắp xếp Giá Sản Phẩm tăng dần");
        System.out.println("6. Tìm kiếm Sản Phẩm");
        System.out.println("0. Thoát");
    }

}
