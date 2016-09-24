package finalprojectmovieapp.mobile.com.finalprojectmovieapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    //constants
    static String DATABASE_NAME="Movies";
    public static final String TABLE_NAME="fav_movies";
    //fields in the table
    public static final String  poster_path="PosterPath";
    public static final String title="title";
    public static final String release_date="release_date";
    public static final String vote_average="vote_average";
    public static final String overview="overview";
    public static final String Movieid="Movieid";
    public static final String id="id";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 2);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+" ("+Movieid+" INTEGER PRIMARY KEY, "+id+" TEXT, "+title+" TEXT, "+release_date+" TEXT, "+overview+" TEXT, "+vote_average+" TEXT, "+poster_path+" TEXT  )";
        db.execSQL(CREATE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

}
