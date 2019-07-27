package sg.edu.np.s10179199k.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHandler extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "accountDB.db";
    public static final String ACCOUNTS = "Accounts";
    public static final String COLUMN_USERNAME = "Username";
    public static final String COLUMN_PASSWORD = "Password";

    public DbHandler(Context c, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(c, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ACCOUNTS_TABLE = "CREATE TABLE " + ACCOUNTS + " (" + COLUMN_USERNAME + "TEXT," + COLUMN_PASSWORD + "TEXT)";
        db.execSQL(CREATE_ACCOUNTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ACCOUNTS);
        onCreate(db);
    }

    public void addAccount(Account a) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_PASSWORD, a.getPassword());
        values.put(COLUMN_USERNAME, a.getUsername());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ACCOUNTS, null, values);
        db.close();
    }

    public boolean findAccount (String username, String password, Account a)
    {
        String query = "SELECT * FROM " + ACCOUNTS + " WHERE " + COLUMN_USERNAME + " = \"" + username + "\"" + " AND " + COLUMN_PASSWORD + " = \"" + password + "\"";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            a.setUsername(cursor.getString(6));
            a.setPassword(cursor.getString(7));
            db.close();
            return true;
        }
        db.close();
        return false;
    }
}

