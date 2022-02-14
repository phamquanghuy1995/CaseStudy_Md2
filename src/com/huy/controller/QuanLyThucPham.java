package com.huy.controller;

import com.huy.model.ThucPham;

import java.util.ArrayList;
import java.util.List;

public class QuanLyThucPham {
    private List<ThucPham> thucPhams = new ArrayList<>();

    public int size() {
        return thucPhams.size();
    }

    public void themSanPham(ThucPham thucPham) {
        this.thucPhams.add(thucPham);
    }

    public void displayAllSanPham() {
        for (ThucPham thucpham : thucPhams) {
            System.out.println(thucpham);
        }
    }

    public int timSanphamBangId(String id) {
        int index = -1;
        for (int i = 0; i < thucPhams.size(); i++) {
            if (thucPhams.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }
    public ThucPham getThucPham(int index){
        return thucPhams.get(index);
    }

    public boolean CapnhapSanphamBangId(String id, ThucPham thucPham) {
        int index = timSanphamBangId(id);
        if (index != -1) {
            thucPhams.set(index, thucPham);
            return true;
        } else {
            return false;
        }
    }

    public boolean XoaSanphamBangId(String id) {
        int index = timSanphamBangId(id);
        if (index != -1) {
            thucPhams.remove(index);
            return true;
        } else {
            return false;
        }
    }

    public void xapXepLuaChon() {
        int min;
        for (int i = 0; i < thucPhams.size() - 1; i++) {
            min = i;
            for (int j = i + 1; j < thucPhams.size(); j++) {
                if (thucPhams.get(j).getGiaTien() < thucPhams.get(min).getGiaTien()) {
                    min = j;
                }
            }
            if (min != i) {
                ThucPham temp = thucPhams.get(min);
                thucPhams.set(min, thucPhams.get(i));
                thucPhams.set(i, temp);
            }
        }
    }
}
