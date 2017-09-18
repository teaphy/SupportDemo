package com.teaphy.supportdemo.base

import android.graphics.drawable.PaintDrawable
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.MotionEvent
import com.teaphy.supportdemo.R
import com.teaphy.supportdemo.downloadableFonts.GooglePlayActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_title.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * @desc
 * @author Tiany
 * @date 2017/9/14 0014
 */
abstract class BaseItemActivity<VH: RecyclerView.ViewHolder, out T : RecyclerView.Adapter<VH>>: BaseActivity(){

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView)
        val manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val divider = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        val paintDrawable = PaintDrawable(resources.getColor(R.color.colorDc))
        paintDrawable.intrinsicHeight = 3
        divider.setDrawable(paintDrawable)
        recyclerView.apply {
            layoutManager = manager
            adapter = initAdapter()
            addItemDecoration(divider)
        }


    }

    abstract fun initAdapter(): T
}