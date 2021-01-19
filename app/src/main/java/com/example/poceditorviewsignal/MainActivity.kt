package com.example.poceditorviewsignal

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.poceditorviewsignal.secondActivity.SecondActivity
import java.util.jar.Manifest


class MainActivity : AppCompatActivity() {

    companion object{

       var READ_STORAGE_PERMISSION_REQUEST_CODE = 122
    }
    lateinit var mBTNOpenEditorView : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mBTNOpenEditorView = findViewById(R.id.btn_open_editor_view)

        openEditorView()
    }

    private fun openEditorView() {
        mBTNOpenEditorView.setOnClickListener {
            var intnet = Intent(this, SecondActivity::class.java)
            startActivity(intnet)
        }
    }

    @Throws(Exception::class)
    fun requestPermissionForReadExtertalStorage() {
        try {
            ActivityCompat.requestPermissions(
                (this as Activity?)!!,
                arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
                READ_STORAGE_PERMISSION_REQUEST_CODE
            )
        } catch (e: Exception) {
            e.printStackTrace()
            throw e
        }
    }

    fun checkPermissionForReadExtertalStorage(): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val result = ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            )
            return result == PackageManager.PERMISSION_GRANTED
        }
        return false
    }

}