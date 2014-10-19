package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by cordi_000 on 18/10/2014.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "DatabaseHelper.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Database.TABLE_NAME + " (" +
                    Database._ID + " INTEGER PRIMARY KEY," +
                    Database.COLUMN_NAME_USER_ID + TEXT_TYPE + COMMA_SEP +
                    Database.COLUMN_NAME_NOM + TEXT_TYPE + COMMA_SEP +
                    Database.COLUMN_NAME_PRENOM + TEXT_TYPE + COMMA_SEP +
                    Database.COLUMN_NAME_SEXE + TEXT_TYPE + COMMA_SEP +
                    Database.COLUMN_NAME_PHONE + TEXT_TYPE + COMMA_SEP +
                    Database.COLUMN_NAME_MAIL + TEXT_TYPE + COMMA_SEP +
                    Database.COLUMN_NAME_PASS + TEXT_TYPE + COMMA_SEP +
                    " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Database.TABLE_NAME;

    public DatabaseHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    /**
     * Ajoute un utilisateur
     * @param user
     */
    public void addUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Database.COLUMN_NAME_NOM, user.get_nom());
        values.put(Database.COLUMN_NAME_PRENOM, user.get__prenom());
        values.put(Database.COLUMN_NAME_SEXE, user.get_sexe());
        values.put(Database.COLUMN_NAME_PHONE, user.get_phone());
        values.put(Database.COLUMN_NAME_MAIL, user.get_mail());
        values.put(Database.COLUMN_NAME_PASS, user.get_pass());

        db.insert(Database.TABLE_NAME, null, values);
        db.close();
    }

    /**
     * Test si un utilisateur existe
     * @param mail
     * @param pass
     * @return
     */
    public boolean checkPass(String mail, String pass){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {
                Database.COLUMN_NAME_MAIL,
                Database.COLUMN_NAME_PASS,

        };

        String selection = "mail = ? AND pass = ?";

        String[] selectionArgs = {
                mail,
                pass,
        };
        Cursor cursor = db.query(Database.TABLE_NAME, projection, selection,selectionArgs,null,null,null);

        if (cursor != null)
        {
            return true;
        }else {
            return false;
        }
    }


    /* Inner class that defines the table contents */
    public static abstract class Database implements BaseColumns {
        public static final String TABLE_NAME = "User";
        public static final String COLUMN_NAME_USER_ID = "userid";
        public static final String COLUMN_NAME_NOM = "nom";
        public static final String COLUMN_NAME_PRENOM = "prenom";
        public static final String COLUMN_NAME_SEXE = "sexe";
        public static final String COLUMN_NAME_PHONE = "phone";
        public static final String COLUMN_NAME_MAIL = "mail";
        public static final String COLUMN_NAME_PASS = "pass";

    }
}
