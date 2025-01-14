package com.example.myapplication.data

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "my_database.db"
        private const val DATABASE_VERSION = 1
        const val TABLE_NAME = "my_table"
        const val LOTTO_NO = "lotto_no"
        const val COL1 = "col1"
        const val COL2 = "col2"
        const val COL3 = "col3"
        const val COL4 = "col4"
        const val COL5 = "col5"
        const val COL6 = "col6"
        const val COL7 = "col7"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = "CREATE TABLE $TABLE_NAME (" +
                "$LOTTO_NO INTEGER PRIMARY KEY, " +
                "$COL1 INTEGER, " +
                "$COL2 INTEGER, " +
                "$COL3 INTEGER, " +
                "$COL4 INTEGER, " +
                "$COL5 INTEGER, " +
                "$COL6 INTEGER, " +
                "$COL7 INTEGER)"
        db?.execSQL(createTableQuery)

        // 로그 추가
        Log.d("DatabaseHelper", "Database created and table created.")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        Log.d("DatabaseHelper", "onUpgrade called. Old version: $oldVersion, New version: $newVersion")
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    // 데이터 삽입
    fun insertData(lottoNo: Int, col1: Int, col2: Int, col3: Int, col4: Int, col5: Int, col6: Int, col7: Int) {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(LOTTO_NO, lottoNo)
            put(COL1, col1)
            put(COL2, col2)
            put(COL3, col3)
            put(COL4, col4)
            put(COL5, col5)
            put(COL6, col6)
            put(COL7, col7)
        }
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    // 모든 데이터 조회
    fun getAllData(): Cursor {
        val db = this.readableDatabase
        return db.query(TABLE_NAME, null, null, null, null, null, null)
    }
}

