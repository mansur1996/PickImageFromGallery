package com.example.pickimagefromgallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.ActivityCompat.startActivityForResult

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.widget.ImageView
import java.io.InputStream
import java.net.URI


class MainActivity : AppCompatActivity() {

    private val RESULT_LOAD_IMG = 1
    lateinit var image_view : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }
    private fun initViews(){
        image_view = findViewById(R.id.iv_image)
        val openGallery = findViewById<Button>(R.id.btn_open_gallery)

        openGallery.setOnClickListener {
            getImageFromGallery()
        }
    }
    private fun getImageFromGallery(){
        val photoPickerIntent = Intent(Intent.ACTION_PICK)
        photoPickerIntent.type = "image/*"

        startActivityForResult(photoPickerIntent, RESULT_LOAD_IMG)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK){
            val imageUri : Uri? = data!!.getData();
            //val  imageStream : InputStream? = getContentResolver().openInputStream(imageUri!!);
            //val selectedImage : Bitmap = BitmapFactory.decodeStream(imageStream);
            //image_view.setImageBitmap(selectedImage);
            image_view.setImageURI(imageUri)
        }
    }
}