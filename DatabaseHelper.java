package com.example.pamsimas10;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.os.strictmode.SqliteObjectLeakedViolation;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper{
    public DatabaseHelper(@Nullable Context context) {
        super(context, "dbpamsimas.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table tblogin(username text,pin text)");
        db.execSQL("create table tbparameter(kodePdam varchar(4),kodeRayon varchar (3),tahun varchar(4),url varchar(100))");
        db.execSQL("create table tbpelanggan(no_pelanggan varchar (50),nama_pelanggan varchar (50),awal integer(50),blntagih varchar(2),alamat text (50),thntagih varchar (50))");
        db.execSQL("create table tbtransaksi(no_pelanggan text,nama_pelanggan text,awal integer(50),akhir integer(50),kodePdam text,kodeRayon text,lang text,lat text,bulan text,tahun text,username text,tglcatat date)");
        db.execSQL("create table tblogin2(username text,pin text)");
        db.execSQL("create table tbupdate(nama_pelanggan varchar(50),no_pelanggan varchar(50),stanawal varchar(50),blntagih varchar(50),alamat varchar(50),thntagih varhcar (50))");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists tblogin");
        db.execSQL("drop table if exists tbparameter");
        db.execSQL("drop table if exists tbpelanggan");
        db.execSQL("drop table if exists tbtransaksi");
        db.execSQL("drop table if exists tblogin2");
        db.execSQL("drop table if exists tbupdate");

    }

    public Boolean insert(String username,String pin){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("pin",pin);
        long ins = db.insert("tblogin",null,contentValues);

        if(ins==-1)
            return false;
        else
            return true;
    }

    public Boolean checkname(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from tblogin where username = ?",new String[]{username});
        if(cursor.getCount()>0){
            return false;
        }
        else{
            return true;
        }
    }

    public Boolean checkdata(String username,String pin){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from tblogin where username = ? and pin = ?", new String[]{username,pin});
            if(cursor.getCount()>0)return true;
            else return false;

    }
    public Boolean insert2(String a,String b,String c,String d){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("kodePdam",a);
        contentValues.put("kodeRayon",b);
        contentValues.put("tahun",c);
        contentValues.put("url",d);

        long ins = db.insert("tbparameter",null,contentValues);

        if(ins==-1)return false;
        else return true;
    }
    public Boolean checkParam(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from tbparameter",null);
        if(cursor.getCount()>0)return true;
        else return false;
    }
    public Boolean insert3(String a,String b,int c,String d,String e,String f){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("no_pelanggan",b);
        contentValues.put("nama_pelanggan",a);
        contentValues.put("awal",c);
        contentValues.put("blntagih",d);
        contentValues.put("alamat",e);
        contentValues.put("thntagih",f);

        long ins = db.insert("tbpelanggan",null,contentValues);

        if(ins==-1)return false;
        else return true;
    }
    public Boolean checknomorpelanggan(String a){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from tbpelanggan where no_pelanggan=?",new String[]{a});
        if(cursor.getCount()>0)return true;
        else return false;
    }

    public Boolean insert4(String a, String b, String c, String d, String e, String f, String g, String h, String i, String j, String k,String l){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("no_pelanggan",a);
        contentValues.put("nama_pelanggan",b);
        contentValues.put("awal",c);
        contentValues.put("akhir",d);
        contentValues.put("kodePdam",e);
        contentValues.put("kodeRayon",f);
        contentValues.put("lang",g);
        contentValues.put("lat",h);
        contentValues.put("bulan",i);
        contentValues.put("tahun",j);
        contentValues.put("username",k);
        contentValues.put("tglcatat",l);
        long ins = db.insert("tbtransaksi",null,contentValues);
        if(ins==-1)return false;
        else return true;
    }
    public Boolean insert5(String username,String pass){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("pin",pass);
        long ins = db.insert("tblogin2",null,contentValues);
        if(ins==-1){
            return false;
        }
        else{
            return true;
        }
    }

    public String nama_pelanggan(String a){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from tbpelanggan where no_pelanggan = ?",new String[]{a});
        String c = null;
        cursor.moveToFirst();
        if(cursor.getCount()>0){
            c = cursor.getString(1).toString();
            return c;
        }
        else
            return null;
    }
    public String angka_awal(String a){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from tbpelanggan where no_pelanggan = ?",new String[]{a});
        String c = null;
        cursor.moveToFirst();
        if(cursor.getCount()>0){
            c = cursor.getString(2);
            return c;
        }
        else return null;
    }
    public String kodePdam(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from tbparameter",null);
        String c = null;
        cursor.moveToLast();
        if(cursor.getCount()>0){
            c = cursor.getString(0);
            return c;
        }
        else return null;
    }
    public String kodeRayon(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from tbparameter",null);
        String c = null;
        cursor.moveToLast();
        if(cursor.getCount()>0){
            c = cursor.getString(1);
            return c;
        }
        else return null;
    }
    public Integer delete(String a){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("tblogin2","username=?",new String[]{a});
    }
    public String username(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from tblogin2",null);
        String c = null;
        cursor.moveToLast();
        if(cursor.getCount()>0){
            c = cursor.getString(0);
            return c;
        }
        else
            return c;
    }
    public Boolean checkKodePdam(String a){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from tbparameter where kodePdam=?",new String[]{a});
        if(cursor.getCount()>0)return false;
        else return true;
    }
    public Boolean checkKodeRayon(String a){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from tbparameter where kodeRayon=?",new String[]{a});
        if(cursor.getCount()>0)return false;
        else return true;
    }
    public Boolean update1(String a,String b,String c){
        SQLiteDatabase update = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("no_pelanggan",a);
        contentValues.put("awal",b);
        contentValues.put("akhir",c);
        update.update("tbtransaksi",contentValues,"no_pelanggan=?",new String[]{a});
        return true;
    }
    public Integer delete1(String a){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("tbtransaksi","no_pelanggan=?",new String[]{a});
    }
    public Boolean checkpelanggan(String a){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from tbpelanggan where no_pelanggan=?",new String[]{a});
        if(cursor.getCount()>0)return true;
        else return false;
    }
    public String alamat(String a){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from tbpelanggan where no_pelanggan=?",new String[]{a});
        String c = null;
        cursor.moveToFirst();
        if(cursor.getCount()>0){
            c = cursor.getString(4);
            return c;
        }else{
            return null;
        }
    }
    public String url(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor  = db.rawQuery("Select * from tbparameter",null);
        String a = null;
        cursor.moveToLast();
        if(cursor.getCount()>0){
            a = cursor.getString(3);
            return a;
        }
        else return null;
    }
    public String bulantagih(String a){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from tbpelanggan where no_pelanggan=?",new String[]{a});
        String c = null;
        cursor.moveToFirst();
        if(cursor.getCount()>0){
            a = cursor.getString(3);
            return a;
        }
        else return a;
    }
    public String tahuntagih(String a){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from tbpelanggan where no_pelanggan=?",new String[]{a});
        String c = null;
        cursor.moveToFirst();
        if(cursor.getCount()>0){
            c = cursor.getString(5);
            return c;
        }
        else return c;
    }
    public boolean checkupload(String a,String b){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from tbupdate where nama_pelanggan = ? and stanawal = ?",new String[]{a,b});
        if(cursor.getCount()>0)return true;
        else return false;
    }
    public boolean insertupdate (String a,String b,String c,String d,String e,String f){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nama_pelanggan",a);
        contentValues.put("no_pelanggan",b);
        contentValues.put("stanawal",c);
        contentValues.put("blntagih",d);
        contentValues.put("alamat",e);
        contentValues.put("thntagih",f);
        long in = db.insert("tbupdate",null,contentValues);
        if(in==-1)return false;
        else return true;
    }
}
