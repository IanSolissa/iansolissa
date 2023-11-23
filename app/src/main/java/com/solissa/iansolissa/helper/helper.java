package com.solissa.iansolissa.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class helper extends SQLiteOpenHelper{

   private static final int DATABASE_VERSION=1;
   static final String DATABASE_NAME="crud";

   public helper(Context context){
       super(context,DATABASE_NAME,null,DATABASE_VERSION);
   }
//dieksekusi hanya 1 kali ketika membuat database
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    final String SQL_CREATE_TABLE="CREATE TABLE user(id INTEGER  PRIMARY KEY autoincrement,name TEXT NOT NULL,email TEXT NOT NULL)";
    sqLiteDatabase.execSQL(SQL_CREATE_TABLE);

   }
//dieksekusi ketika database di upgrade
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,int i,int i1) {

       sqLiteDatabase.execSQL("DROP TABLE IF EXISTS user");
       onCreate(sqLiteDatabase);
    }

    public ArrayList<HashMap<String, String>> getall(){
ArrayList<HashMap<String, String>>list=new ArrayList<>();
String QUERY = "SELECT * FROM user";
SQLiteDatabase database=this.getWritableDatabase();
        Cursor cursor =  database.rawQuery(QUERY,null);
        if(cursor.moveToFirst()){
            do {
                HashMap<String, String>map=new HashMap<>();
                map.put("id",cursor.getString(0));
                map.put("name",cursor.getString(1));
                map.put("email",cursor.getString(2));
            list.add(map);

            }while(cursor.moveToNext());
        }
   cursor.close();
        return list;
   }
   public void insert(String name,String email){
       SQLiteDatabase database = this.getWritableDatabase();
       String QUERY="INSERT INTO USER (NAME,EMAIL)VALUES('"+name+"' , '"+email+"' )";
       database.execSQL(QUERY);

   }
   public void update(int id,String name,String email){
       SQLiteDatabase database=this.getWritableDatabase();
       String QUERY="UPDATE user SET name='"+name+"',email='"+email+"' Where id= "+id;
       database.execSQL(QUERY);
   }

   public void delete(int id){
SQLiteDatabase database=this.getWritableDatabase();
String QUERY="DELETE FROM user WHERE id="+id;
database.execSQL(QUERY);
   }

}
