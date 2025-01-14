package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // UI 요소 연결
        val textView: TextView = findViewById(R.id.textView)
        val button: Button = findViewById(R.id.button)

        // 버튼 클릭 리스너
        button.setOnClickListener {
            textView.text = "You clicked the button!"
        }
    }
}
