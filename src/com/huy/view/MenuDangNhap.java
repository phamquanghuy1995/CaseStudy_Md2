package com.huy.view;

import com.huy.controller.QuanLyUser;
import com.huy.model.User;

import java.util.Scanner;

public class MenuDangNhap {
    public Scanner scanner = new Scanner(System.in);
    private QuanLyUser quanLyUser = new QuanLyUser();
    private MenuThucPham menuThucPham = new MenuThucPham();

    public void run(){
        int choice = -1;
        do {
            System.out.println("Quản Lý Gian Hàng Nông Sản");
            menu();
            System.out.println("Nhập lựa chọn của bạn");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    Login();
                    break;
                }
                case 2: {
                    Register();
                    break;
                }
            }
        } while (choice != 0);
    }

    private void Login() {
        System.out.println("Nhập username:");
        String username = scanner.nextLine();
        System.out.println("Nhập password:");
        String password = scanner.nextLine();
        boolean isLogin = quanLyUser.checkUserLogin(username, password);
        if (isLogin) {
            System.out.println("Đăng nhập thành công!");
                menuThucPham.run();
        } else {
            System.err.println("Username hoặc password không đúng!");
        }
    }

    private void Register() {
        System.out.println("Đăng ký tài khoản mới!");
        User user = TaoNguoiDung();
        quanLyUser.DangKi(user);
    }

    private User TaoNguoiDung(){
        String username = Tennguoidung();
        String password = ThemPassword();
        User user = new User(username, password);
        return user;
    }

    private String Tennguoidung(){
        String username;
        do {
            System.out.println("Nhập tên tài khoản (6-12 ký tự):");
            username = scanner.nextLine();
            if (username.length() < 6) {
                System.err.println("Tài khoản phải có ít nhất 6 ký tự!");
            } else if (username.length() > 12) {
                System.err.println("Tài khoản chỉ được phép tối đa 12 ký tự!");
            } else if (quanLyUser.checkUsernameExist(username)) {
                System.err.println("Tài khoản đã được đăng kí");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while (username.length()<6 || username.length() > 12 || quanLyUser.checkUsernameExist(username));
        return username;
    }

    private String ThemPassword(){
        String password;
        do {
            System.out.println("Nhập mật khẩu (6-12 ký tự):");
            password = scanner.nextLine();
            if (password.length() < 6) {
                System.err.println("Mật khẩu phải có ít nhất 6 ký tự!");
            } else if (password.length() > 12) {
                System.err.println("Mật khẩu chỉ được phép tối đa 12 ký tự!");
            }
        } while (password.length() < 6 || password.length() > 12);
        return password;
    }

    private void menu() {
        System.out.println("1. Đăng nhập");
        System.out.println("2. Đăng ký");
        System.out.println("0. Thoát");
    }
}
