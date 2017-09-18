package com.teaphy.supportdemo.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.teaphy.supportdemo.R

import kotlinx.android.synthetic.main.layout_title.*

/**
 * @desc
 * @author Tiany
 * @date 2017/9/14 0014
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())

        initData()

        initView()

        subscribeTitle()

        setListener()

        doBack()

    }


    private fun subscribeTitle() {
        tvTitle.text = initTitle()
    }

    private fun doBack() {
        ivBack.setOnClickListener {
            finish()
        }
    }

    abstract fun getLayoutId(): Int

    abstract fun initTitle(): String

    abstract fun initData()

    abstract fun initView()

    abstract fun setListener()


}