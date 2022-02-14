package com.huy.controller;

import com.huy.model.User;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class QuanLyUser implements DocFile, VietFile {
    private List<User> users = new ArrayList<>();

    public QuanLyUser() {
        File file = new File("user.txt");
        if (file.exists()) {
            try {
                docfile("user.txt");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void displayAll() {
        for (User user : users){
            System.out.println(user);
        }
    }

    public void DangKi(User user){
        this.users.add(user);
        try {
            vietFile("user.txt");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void docfile(String path) throws IOException, ClassNotFoundException {

    }

    @Override
    public void vietFile(String path) throws IOException {

    }

    public boolean checkUsernameExist(String username){
        boolean isExisted = false;
        for (int i = 0; i < users.size(); i++) {
            if (username.equals(users.get(i).getUsername())){
                isExisted = true;
                break;
            }
        }
        return isExisted;
    }

    public boolean checkUserLogin(String username, String password){
        boolean isLogin = false;
        for (int i = 0; i < users.size(); i++) {
            if (username.equals(users.get(i).getUsername()) && password.equals(users.get(i).getPassword())){
                isLogin = true;
                break;
            }
        }
        return isLogin;
    }

    public boolean checkadmin(String username,String password){ //kiểm tra xem có phải là admin hay không.
        boolean isAdmin = false;
        for (int i = 0; i < users.size(); i++) {
            if (username.equals(users.get(i).getUsername()) && password.equals(users.get(i).getPassword())&&"admin".equals(users.get(i).getRole())) {
                isAdmin = true;
                break;
            }
        }
        return isAdmin;
    }
}
