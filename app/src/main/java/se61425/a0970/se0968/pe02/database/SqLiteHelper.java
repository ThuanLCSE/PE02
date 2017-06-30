package se61425.a0970.se0968.pe02.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import se61425.a0970.se0968.pe02.App;
import se61425.a0970.se0968.pe02.Bonsai;

/**
 * Created by Thuans on 4/27/2017.
 */

public class SqLiteHelper extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_BONSAI = "bonsai";

    private static final String DATABASE_NAME = "BONSSSAAAI";

    private static final String TAG = "SQLite Helper utils";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PICTURE = "pictu";
    private static final String KEY_DETAIL = "dete";
    private static final String KEY_ORIGIN = "orig";
    private static final String KEY_PRICE = "pric";

    public SqLiteHelper( ) {
        super(App.getContext(), DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG,"bat dau tao table");
                //All necessary tables you like to create will create here
        db.execSQL("CREATE TABLE " + TABLE_BONSAI  + "("
                + KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT    ,"
                +  KEY_NAME+ "  TEXT ," +
                KEY_PICTURE+ "  INTEGER  ,"+
                KEY_DETAIL + "  TEXT  ,"+
                KEY_ORIGIN + "  TEXT  ,"+
                KEY_PRICE + "  REAL  "+ ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, String.format("SQLiteDatabase.onUpgrade(%d -> %d)", oldVersion, newVersion));

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BONSAI);

        onCreate(db);
    }

    public int insert(Bonsai bons) {
        SQLiteDatabase db = SQLiteManager.getInstance().openDatabase();

        int newId  = (int) db.insert(TABLE_BONSAI, null, createContent(bons));
        SQLiteManager.getInstance().closeDatabase();

        return newId;
    }

    public static List<Bonsai> getAll(){
        List<Bonsai> result = new ArrayList<Bonsai>();

        SQLiteDatabase db = SQLiteManager.getInstance().openDatabase();
        String selectQuery =  " SELECT * "
                + " FROM " + TABLE_BONSAI
                ;

        Cursor cursor = db.rawQuery(selectQuery,  new String[]{});
        if (cursor.moveToFirst()) {
            do {
                Bonsai bonsaiEntity = getByCursor(cursor);
                result.add(bonsaiEntity);
            } while (cursor.moveToNext());
        }

        cursor.close();
        SQLiteManager.getInstance().closeDatabase();

        return result;
    }

    public void delete( ) {
        SQLiteDatabase db = SQLiteManager.getInstance().openDatabase();
        db.delete(TABLE_BONSAI,null,null);
        SQLiteManager.getInstance().closeDatabase();
    }

    private static ContentValues createContent(Bonsai bonsai){
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, bonsai.getName());
        values.put(KEY_DETAIL, bonsai.getDetail());
        values.put(KEY_ORIGIN, bonsai.getOrigin());
        values.put(KEY_PICTURE, bonsai.getPicture());
        values.put(KEY_PRICE, bonsai.getPrice());
        return values;
    }
    private static Bonsai getByCursor(Cursor cursor){
        Bonsai bonsaiEntity = new Bonsai();
        bonsaiEntity.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
        bonsaiEntity.setName(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
        bonsaiEntity.setDetail(cursor.getString(cursor.getColumnIndex(KEY_DETAIL)));
        bonsaiEntity.setOrigin(cursor.getString(cursor.getColumnIndex(KEY_ORIGIN)));
        bonsaiEntity.setPicture(cursor.getInt(cursor.getColumnIndex(KEY_PICTURE)));
        bonsaiEntity.setPrice(cursor.getDouble(cursor.getColumnIndex(KEY_PRICE)));

        return bonsaiEntity;
    }

}
