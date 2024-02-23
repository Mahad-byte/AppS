package com.mahad.madproject.GetFiles

import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.mahad.madproject.RecyclerView.Model
import java.io.File

class GetFiles {
     fun getAudioFiles(): MutableList<Model>{
        val list = mutableListOf<Model>()

        //val audiosssDirectory: File? = ContextCompat.getExternalFilesDirs(applicationContext, Environment.DIRECTORY_DOWNLOADS).firstOrNull()
        val audioDirectory: File = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
        //Log.i("audio Directory", "${audioDirectory.listFiles()}")
        val downloadDirectory: Array<out File>? = audioDirectory.listFiles()

        if (downloadDirectory != null) {
            for(files in downloadDirectory) {
                val filename =  files.name
                if(filename.endsWith("mp3", ignoreCase = true)) {
                    val model = Model("", audioDirectory)
                    model.name = files.name
                    model.file = files.absoluteFile
                    list.add(model)
                }
            }
        }
        return list
    }
}