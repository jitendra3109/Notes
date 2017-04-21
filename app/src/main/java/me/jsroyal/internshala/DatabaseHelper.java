package me.jsroyal.internshala;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by jsroyal on 16/4/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static String CREATE_TABLE1;

    //    Database name
    static String DATABASE_NAME = "ImportantNotes";

    //    Talble name
    public static final String TABLE1_NAME = "Notes";

    //      Fields for table
    public static final String ID = "id";
    public static final String Title = "title";
    public static final String Message = "message";

    //      Required resorces to manage database
    private ContentValues cValues;
    private SQLiteDatabase dataBase = null;
    private Cursor cursor;

    public DatabaseHelper(Context context) {
        super(context, context.getExternalFilesDir(null).getAbsolutePath()
                + "/" + DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        CREATE_TABLE1 = "CREATE TABLE " + TABLE1_NAME + "(" + ID
                + " INTEGER PRIMARY KEY autoincrement, " + Title
                + " TEXT, " + Message + " TEXT)";


        db.execSQL(CREATE_TABLE1);
        System.out
                .println("Table is created...........................!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE1_NAME);

        onCreate(db);
    }

    public void insertRecord(String title, String message) {

        dataBase = getWritableDatabase();
        cValues = new ContentValues();

        cValues.put(Title, title);
        cValues.put(Message, message);

        // insert data into database
        dataBase.insert(TABLE1_NAME, null, cValues);

        dataBase.close();
    }
    public boolean updateNote(String Utitle,String Umessage) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Title,Utitle);
        contentValues.put(Message,Umessage);
        db.update(TABLE1_NAME, contentValues, "Title = ?",new String[] { Utitle });
        return true;
    }
    public void updateRecord(String title, String message) {

        dataBase = getWritableDatabase();

        cValues = new ContentValues();

        cValues.put(Title, title);
        cValues.put(Message, message);
//    Update data from database table
        dataBase.update(DatabaseHelper.TABLE1_NAME, cValues,
                null, null);

        dataBase.close();
    }


    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE1_NAME,null);
        return res;
    }

    public void deleteRecord() {

        dataBase = getWritableDatabase();

//    Deleting all records from database table
        dataBase.delete(TABLE1_NAME, null, null);

        dataBase.close();
    }
    public void  deleteTitle(String title) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE1_NAME, "Title = ?",new String[] {title});
        db.close();
    }

}



