package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class dbHelper extends SQLiteOpenHelper {
  public static  final String DATABASE_NAME="dbMovies";
    public static  final String TABLE_NAME="movies2022";
    public static  final String MOVIE_NAME_COL="movie_Name" ;
    public static  final String ACTOR_NAME_COL="actor_Name";
    public static  final String ACTORES_NAME_COL="actores_Name";
    public static  final String BUDGET_COL="budget";
    public static  final String RELEASE_COL="release_Date";


    public void onCreate(SQLiteDatabase db){

        String query="CREATE TABLE "+TABLE_NAME+"("+
                MOVIE_NAME_COL+"TEXT ,"+
                ACTOR_NAME_COL+"TEXT ,"+
                ACTORES_NAME_COL+"TEXT ,"+
                BUDGET_COL+"TEXT ,"+
                RELEASE_COL+"TEXT )";
db.execSQL(query);
db.close();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    dbHelper(Context context){
        super(context,DATABASE_NAME,null,1);
    }

    public void addMovies(String movieName,String actorName,String actoresName,String budget,String releaseDate){
        SQLiteDatabase sql=this.getWritableDatabase();

        ContentValues values=new ContentValues();

        values.put(MOVIE_NAME_COL,movieName);
        values.put(ACTOR_NAME_COL,actoresName);
        values.put(ACTORES_NAME_COL,actoresName);
        values.put(BUDGET_COL,budget);
        values.put(RELEASE_COL,releaseDate);

        sql.insert(TABLE_NAME,null,values);




    }


    public ArrayList<ArrayList<String>> veiwMovies() {
        SQLiteDatabase query = this.getReadableDatabase();
        Cursor cursor = query.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();

        if (cursor.moveToFirst()) {
            do {

                ArrayList<String> temp = new ArrayList<>();
                temp.add(cursor.getString(1) + " |" + cursor.getString(2) + " |" +
                        cursor.getString(2) + " |" + cursor.getString(3) + " |" + cursor.getString(4) + " |" +
                        cursor.getString(5));

                list.add(temp);

            } while (cursor.moveToNext());

        }


    return list;
    }






}
