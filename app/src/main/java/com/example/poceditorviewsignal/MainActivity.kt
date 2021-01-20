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


class MainActivity : AppCompatActivity() {

    companion object {

        var READ_STORAGE_PERMISSION_REQUEST_CODE = 122
        var PICK_IMAGE = 101
        var PICK_VIDEO = 102
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.openImageGallery).setOnClickListener {
            sendImageGalleryIntent()
        }
        findViewById<Button>(R.id.openVideoGalery).setOnClickListener {
            sendVideoGalleryIntent()
        }
    }

    private fun sendImageGalleryIntent() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE)
    }

    private fun sendVideoGalleryIntent() {
        val intent = Intent()
        intent.type = "video/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_VIDEO)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            PICK_IMAGE -> {
                val uri = data?.data ?: return
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("URI", uri.toString())
                intent.putExtra("type", "image")
                startActivity(intent)
            }
            PICK_VIDEO -> {
                val uri = data?.data ?: return
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("URI", uri.toString())
                intent.putExtra("type", "video")
                startActivity(intent)
            }
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