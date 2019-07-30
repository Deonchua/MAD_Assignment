package sg.edu.np.s10179199k.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import static sg.edu.np.s10179199k.myapplication.inDB.COL_CREATED_AT;
import static sg.edu.np.s10179199k.myapplication.inDB.COL_ID;
import static sg.edu.np.s10179199k.myapplication.inDB.COL_IS_COMPLETED;
import static sg.edu.np.s10179199k.myapplication.inDB.COL_ITEM_NAME;
import static sg.edu.np.s10179199k.myapplication.inDB.COL_NAME;
import static sg.edu.np.s10179199k.myapplication.inDB.COL_TODO_ID;
import static sg.edu.np.s10179199k.myapplication.inDB.DB_NAME;
import static sg.edu.np.s10179199k.myapplication.inDB.DB_VERSION;
import static sg.edu.np.s10179199k.myapplication.inDB.TABLE_TODO;
import static sg.edu.np.s10179199k.myapplication.inDB.TABLE_TODO_ITEM;

public class NewDbHandler extends SQLiteOpenHelper {


    public NewDbHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createToDoTable = "CREATE TABLE " + TABLE_TODO + " (" +
                COL_ID + " integer PRIMARY KEY AUTOINCREMENT," +
                COL_CREATED_AT + " datetime DEFAULT CURRENT_TIMESTAMP," +
                COL_NAME + " varchar)";


        String createToDoItemTable =
                "CREATE TABLE " + TABLE_TODO_ITEM + " (" +
                        COL_ID + " integer PRIMARY KEY AUTOINCREMENT," +
                        COL_CREATED_AT + " datetime DEFAULT CURRENT_TIMESTAMP," +
                        COL_TODO_ID + " integer," +
                        COL_ITEM_NAME + " varchar," +
                        COL_IS_COMPLETED + " integer)";



        db.execSQL(createToDoTable);
        db.execSQL(createToDoItemTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    boolean addToDo(NewToDo todo) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_NAME, todo.getName());
        long result = db.insert(TABLE_TODO, null, cv);
        return result != -1;
    }


    void updateToDo(NewToDo todo) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_NAME, todo.getName());
        db.update(TABLE_TODO, cv, COL_ID + "=?", new String[]{String.valueOf(todo.getId())});
    }

    void deleteToDo(Long todoId) {

        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_TODO_ITEM, COL_TODO_ID + "=?", new String[]{String.valueOf(todoId)});
        db.delete(TABLE_TODO, COL_ID + "=?", new String[]{String.valueOf(todoId)});
    }

    void updateToDoItemCompletedStatus(Long todoId, Boolean isCompleted) {

        SQLiteDatabase db = getWritableDatabase();
        Cursor queryResult = db.rawQuery("SELECT * FROM " + TABLE_TODO_ITEM + " WHERE " + COL_TODO_ID + "=" + todoId, null);
        if (queryResult.moveToFirst()) {
            do {
                NewItemToDo item = new NewItemToDo();
                item.setId(queryResult.getLong(queryResult.getColumnIndex(COL_ID)));
                item.setToDoId(queryResult.getLong(queryResult.getColumnIndex(COL_TODO_ID)));
                item.setItemName(queryResult.getString(queryResult.getColumnIndex(COL_ITEM_NAME)));
                item.setCompleted(isCompleted);
                updateToDoItem(item);
            } while (queryResult.moveToNext());
        }
        queryResult.close();
    }

    public void updateToDoItem(NewItemToDo item) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_ITEM_NAME, item.getItemName());
        cv.put(COL_TODO_ID, item.getToDoId());
        cv.put(COL_IS_COMPLETED, item.isCompleted());
        db.update(TABLE_TODO_ITEM, cv, COL_ID + "=?", new String[]{String.valueOf(item.getId())});
    }

    ArrayList<NewToDo> getToDos() {

        ArrayList<NewToDo> result = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor queryResult = db.rawQuery("SELECT * from " + TABLE_TODO, null);
        if (queryResult.moveToFirst()) {
            do {
                NewToDo todo = new NewToDo();
                todo.setId(queryResult.getLong(queryResult.getColumnIndex(COL_ID)));
                todo.setName(queryResult.getString(queryResult.getColumnIndex(COL_NAME)));
                result.add(todo);
            } while (queryResult.moveToNext());
        }
        queryResult.close();
        return result;
    }

    public boolean addToDoItem(NewItemToDo item) {


        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_ITEM_NAME, item.getItemName());
        cv.put(COL_TODO_ID, item.getToDoId());
        cv.put(COL_IS_COMPLETED, item.isCompleted());

        long result = db.insert(TABLE_TODO_ITEM, null, cv);
        return result != -1;
    }

    public void deleteToDoItem(long itemId) {

        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_TODO_ITEM, COL_ID + "=?", new String[]{String.valueOf(itemId)});

    }

    public ArrayList<NewItemToDo> getToDoItems(long todoId) {

        ArrayList<NewItemToDo> result = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor queryResult = db.rawQuery("SELECT * FROM " + TABLE_TODO_ITEM + " WHERE " + COL_TODO_ID + "=" + todoId, null);
        if (queryResult.moveToFirst()) {
            do {
                NewItemToDo item = new NewItemToDo();
                item.setId(queryResult.getLong(queryResult.getColumnIndex(COL_ID)));
                item.setToDoId(queryResult.getLong(queryResult.getColumnIndex(COL_TODO_ID)));
                item.setItemName(queryResult.getString(queryResult.getColumnIndex(COL_ITEM_NAME)));
                item.setCompleted(queryResult.getInt(queryResult.getColumnIndex(COL_IS_COMPLETED)) == 1);
                result.add(item);

            } while (queryResult.moveToNext());
        }

        queryResult.close();
        return result;
    }
}


