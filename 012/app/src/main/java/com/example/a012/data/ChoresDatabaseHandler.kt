package com.example.a012.data

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.a012.models.*
import java.sql.Date
import java.text.DateFormat

class ChoresDatabaseHandler(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_CHORE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" +
                KEY_ID + " INTEGER PRIMARY KEY," +
                KEY_CHORE_NAME + " Text," +
                KEY_CHORE_ASSIGNED_BY + " TEXT," +
                KEY_CHORE_ASSIGNED_TO + " TEXT," +
                KEY_CHORE_ASSIGNED_TIME + " LONG" + ")"
        db?.execSQL(CREATE_CHORE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")

//        create table again
        onCreate(db)
    }

//    CRUD - CREATE, READ, UPDATE, DELETE

    fun createChore(chore: Chore) {
        val db: SQLiteDatabase = writableDatabase
        val values = ContentValues()
        values.put(KEY_CHORE_NAME, chore.choreName)
        values.put(KEY_CHORE_ASSIGNED_BY, chore.assignedBy)
        values.put(KEY_CHORE_ASSIGNED_TO, chore.assignedTo)
        values.put(KEY_CHORE_ASSIGNED_TIME, System.currentTimeMillis())

        db.insert(TABLE_NAME, null, values)

        Log.d("DATA_INSERTED", "SUCCESS")
        db.close()
    }

    fun readAChore(): ArrayList<Chore> {
        val db: SQLiteDatabase = readableDatabase
        var list: ArrayList<Chore> = ArrayList()

//        val cursor: Cursor = db.query(TABLE_NAME, arrayOf(KEY_ID,
//                                    KEY_CHORE_NAME, KEY_CHORE_ASSIGNED_BY,
//                                    KEY_CHORE_ASSIGNED_TIME,
//                                    KEY_CHORE_ASSIGNED_TO), KEY_ID + "=?", arrayOf(id.toString()),
//                                null, null, null, null)


        val selectAll = "SELECT * FROM " + TABLE_NAME
        val cursor: Cursor = db.rawQuery(selectAll, null)

        if (cursor.moveToFirst()) {
            do {
                val chore = Chore()
                chore.choreName = cursor.getString(cursor.getColumnIndex(KEY_CHORE_NAME))
                chore.assignedTo = cursor.getString(cursor.getColumnIndex(KEY_CHORE_ASSIGNED_TO))
                chore.assignedTime = cursor.getLong(cursor.getColumnIndex(KEY_CHORE_ASSIGNED_TIME))
                chore.assignedBy = cursor.getString(cursor.getColumnIndex(KEY_CHORE_ASSIGNED_BY))

                val formatData: java.text.DateFormat = DateFormat.getDateInstance()
                var formatedData = formatData.format(
                    Date(cursor.getLong(cursor.getColumnIndex(KEY_CHORE_ASSIGNED_TIME))).time //July 6 2020
                )

                list.add(chore)
            } while (cursor.moveToNext())
        }
        return list
    }


    fun updateChore(chore: Chore) {
        var db: SQLiteDatabase = writableDatabase

        var updata_values = ContentValues()
        updata_values.put(KEY_CHORE_NAME, chore.choreName)
        updata_values.put(KEY_CHORE_ASSIGNED_BY, chore.assignedBy)
        updata_values.put(KEY_CHORE_ASSIGNED_TO, chore.assignedTo)
        updata_values.put(KEY_CHORE_ASSIGNED_TIME, System.currentTimeMillis())

//        update row

        db.update(TABLE_NAME, updata_values, KEY_ID + "=?", arrayOf(chore.id.toString()))

    }

    fun deleteChore(chore: Chore) {
        var db: SQLiteDatabase = writableDatabase
        db.delete(TABLE_NAME, KEY_ID + "=?", arrayOf(chore.id.toString()))
        db.close()
    }

    fun getChoresCount(): Int {
        var db: SQLiteDatabase = readableDatabase
        var countQuery = "SELECT * FROM " + TABLE_NAME
        var cursor: Cursor = db.rawQuery(countQuery, null)

        return cursor.count
    }
}
