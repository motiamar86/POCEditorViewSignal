package com.example.poceditorviewsignal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var mBTNOpenEditorView : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mBTNOpenEditorView = findViewById(R.id.btn_open_editor_view)
        openEditorView()
    }

    private fun openEditorView() {
        mBTNOpenEditorView.setOnClickListener {
            //
        }
    }
}