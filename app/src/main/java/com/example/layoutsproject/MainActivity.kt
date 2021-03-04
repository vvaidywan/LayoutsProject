package com.example.layoutsproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)
        val btn4 = findViewById<Button>(R.id.btn4)
        val btn5 = findViewById<Button>(R.id.btn5)
        val btn6 = findViewById<Button>(R.id.btn6)

        btn1.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, LinearLayoutActivity::class.java)
            startActivity(intent)
        })

        btn2.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, RelativeLayoutActivity::class.java)
            startActivity(intent)
        })

        btn3.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, ConstraintLayoutActivity::class.java)
            startActivity(intent)
        })

        btn4.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, RecyclerViewActivity::class.java)
            startActivity(intent)
        })

        btn5.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, HeterogeneousActivity::class.java)
            startActivity(intent)
        })

        btn6.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, PaginationActivity::class.java)
            startActivity(intent)
        })
    }
}