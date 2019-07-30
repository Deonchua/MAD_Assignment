package sg.edu.np.s10179199k.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class NoteDbHandler extends SQLiteOpenHelper
{
    private static final String TAG = "NoteDatabaseHandler";

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "NOTEDB";
    private static final String  TABLE_NAME = "Notes";

    private static final String KEY_ID = "noteId";
    private static final String KEY_TITLE = "title";
    private static final String KEY_CONTENT = "content";

    private static final String[] NOTES_COLUMN = new String[] {KEY_ID, KEY_TITLE, KEY_CONTENT};

    public NoteDbHandler(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
                                " ( " + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT" + ", "
                                + KEY_TITLE + " TEXT NOT NULL" + ", "
                                + KEY_CONTENT + " TEXT"
                                + ") ";

        Log.d(TAG, CREATE_TABLE);
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

        Log.d(TAG, DROP_TABLE);

        db.execSQL(DROP_TABLE);

        onCreate(db);
    }

    public void addNote(Note note){}}

       /* SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, note.getTitle());
        values.put(KEY_CONTENT, note.getContent());

        db.insert(TABLE_NAME, null, values);
        db.close();*/



   /* public Note getContent(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.query(TABLE_NAME, NOTES_COLUMN, KEY_ID
                + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        return null;
    */

        /*if (c != null) {
            c.moveToFirst();
        }*/
        /*db.close();*/

       /* Log.d(TAG, "Get Note Result " + c.getString(0) + ", "
                                            + c.getString(1) + ", "
                                            + c.getString(2));

        Note note = new Note(Integer.parseInt(c.getString(0)),
                                                c.getString(1),
                                                c.getString(2));

        return note;*/



    /*public List<Note> getAllCOntent()
    {
        SQLiteDatabase db = this.getReadableDatabase();

        List<Note> noteList = new ArrayList<>();

        Cursor cursor = db.query(TABLE_NAME, NOTES_COLUMN, null, null, null, null, null);
        {
            if (cursor != null && cursor.moveToFirst())
            {
                do {

                    Note note = new Note();
                    note.setNoteId(Integer.parseInt(cursor.getString(0)));
                    note.setTitle(cursor.getString(1));
                    note.setContent(cursor.getString(2));

                    noteList.add(note);

                } while (cursor.moveToNext());
            }

            db.close();
            return noteList;
        }
    }*/



