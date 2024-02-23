package com.mahad.madproject

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.mahad.madproject.GetFiles.GetFiles
import com.mahad.madproject.RecyclerView.Adapter
import com.mahad.madproject.RecyclerView.Model
import com.mahad.madproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mMainBinding: ActivityMainBinding
    private lateinit var audioList: MutableList<Model>
    private lateinit var adapter: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mMainBinding.root)
    }

    override fun onStart() {
        super.onStart()

        val getFiles = GetFiles()
        if(ActivityCompat.checkSelfPermission(applicationContext, android.Manifest.permission.READ_EXTERNAL_STORAGE)
            == PackageManager.PERMISSION_GRANTED){
            audioList = getFiles.getAudioFiles()

        }
        else{
            ActivityCompat.requestPermissions(this,
                arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
                1234)
        }
        adapter = Adapter(this, audioList)
        mMainBinding.srv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mMainBinding.srv.adapter = adapter
    }
}


