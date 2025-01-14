package com.example.myapplication

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.data.DatabaseHelper


class MainActivity : AppCompatActivity() {

    private lateinit var dbHelper: DatabaseHelper
    private var db: SQLiteDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 로그 추가
        Log.d("DatabaseHelper", "onCreate calle3534543d")
        // DatabaseHelper 초기화
        dbHelper = DatabaseHelper(this)
        val db = dbHelper.writableDatabase // 이 코드가 있어야 데이터를 쓸 수 있습니다.

        // 데이터 삽입
        dbHelper.insertData(
            lottoNo = 2,
            col1 = 2,
            col2 = 12,
            col3 = 233,
            col4 = 34,
            col5 = 45,
            col6 = 16,
            col7 = 7
        )

        // 데이터 조회 로그
        val cursor = dbHelper.getAllData()
        while (cursor.moveToNext()) {
            Log.d(
                "DatabaseHelper",
                "Row: ${cursor.getInt(0)}, ${cursor.getInt(1)}, ${cursor.getInt(2)}, " +
                        "${cursor.getInt(3)}, ${cursor.getInt(4)}, ${cursor.getInt(5)}, ${cursor.getInt(6)}, ${cursor.getInt(7)}"
            )
        }
        cursor.close()

        // 더 이상 필요하지 않으면 데이터베이스 연결을 닫습니다.
        db?.close()
        // UI 요소 연결
        val textView: TextView = findViewById(R.id.textView)
        val button: Button = findViewById(R.id.button)

        // 버튼 클릭 리스너
        button.setOnClickListener {
            textView.text = "You clickedgsdfsdfdsdf the button!"
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        db?.close()  // 활동이 종료될 때 데이터베이스 연결을 닫습니다.
    }
}
