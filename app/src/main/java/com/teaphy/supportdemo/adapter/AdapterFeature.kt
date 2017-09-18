package com.teaphy.supportdemo.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.teaphy.supportdemo.R
import com.teaphy.supportdemo.callback.OnItemClickCallback

/**
 * @desc
 * @author Tiany
 * @date 2017/9/13 0013
 */
class AdapterFeature(val list: MutableList<String>, val callback: OnItemClickCallback): RecyclerView.Adapter<AdapterFeature.MyHolder>() {
    override fun onBindViewHolder(holder: MyHolder?, position: Int) {
        holder?.tvFeature?.text = list[position]

        holder?.itemView?.setOnClickListener {
            callback.onClick(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyHolder {
        val inflater = LayoutInflater.from(parent?.context)
        val view = inflater.inflate(R.layout.item_feture, parent, false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }


    class MyHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvFeature: TextView = view.findViewById(R.id.tvFeature)
    }
}