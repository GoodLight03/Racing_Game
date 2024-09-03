package com.example.game_dua_xe;

public class box {
    private int Hinh;
    private String giatri;

    public box(int hinh, String giatri) {
        Hinh = hinh;
        this.giatri = giatri;
    }

    public int getHinh() {
        return Hinh;
    }

    public String getGiatri() {
        return giatri;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }

    public int setGiatri(String giatri) {
        this.giatri = giatri;
        return 0;
    }
}
