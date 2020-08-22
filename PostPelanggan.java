package com.example.pamsimas10;

public class PostPelanggan {
    public String nama;
    public String nopelanggan;
    public String stanawal;
    public String blntagih;
    public String alamat;
    public String thntagih;

    public PostPelanggan(String Nama,String Nopelanggan,String Stanawal,String Blntagih,String Alamat,String Thntagih){
        this.nama = Nama;
        this.nopelanggan = Nopelanggan;
        this.stanawal = Stanawal;
        this.blntagih = Blntagih;
        this.alamat = Alamat;
        this.thntagih = Thntagih;
    }
    public String getNama(){
        return nama;
    }
    public String getNopelanggan(){
        return nopelanggan;
    }
    public String getStanawal(){
        return stanawal;
    }
    public String getBlntagih(){
        return blntagih;
    }
    public String getAlamat(){
        return alamat;
    }
    public String getThntagih(){
        return thntagih;
    }
}
