package com.mahad.madproject.RecyclerView

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mahad.madproject.PlayScreen.PlayingActivity
import com.mahad.madproject.R

class Adapter(val context: Context, val audioList: MutableList<Model>):
    RecyclerView.Adapter<Adapter.AdapterViewHolder>()
{
    inner class AdapterViewHolder(singlelItem: View): RecyclerView.ViewHolder(singlelItem)
    {
        val Name: TextView = singlelItem.findViewById(R.id.Name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        return AdapterViewHolder(
            LayoutInflater.from(context).inflate(R.layout.single_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return audioList.size
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.Name.text = audioList[position].name
        holder.Name.setOnClickListener {
            val context = it.context
            val intent = Intent(context, PlayingActivity::class.java)
            intent.putExtra("position", position)
            intent.putExtra("name", holder.Name.text)

            context.startActivity(intent)
        }
    }
}