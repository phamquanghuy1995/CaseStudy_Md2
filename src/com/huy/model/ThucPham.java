package com.huy.model;

public class ThucPham {
    private String id;

    private String name;

    private String nguonGoc;

    private String gianHang;

    private double giaTien;

    public ThucPham(){
    }

    public ThucPham(String id, String name, String nguonGoc, String gianHang, double giaTien) {
        this.id = id;
        this.name = name;
        this.nguonGoc = nguonGoc;
        this.gianHang = gianHang;
        this.giaTien = giaTien;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getnguonGoc() {
        return nguonGoc;
    }

    public void setnguonGoc(String nguonGoc) {
        nguonGoc = nguonGoc;
    }

    public String getGianHang() {
        return gianHang;
    }

    public void setGianHang(String gianHang) {
        gianHang = gianHang;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        giaTien = giaTien;
    }

    @Override
    public String toString(){
        return id + ", "+name+", "+nguonGoc+", "+gianHang+", "+giaTien;
    }
}
