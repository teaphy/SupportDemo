package com.teaphy.supportdemo.downloadableFonts

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.teaphy.supportdemo.R
import com.teaphy.supportdemo.base.BaseActivity

/**
 * @desc  字体来源于GooglePlay
 * @author Tiany
 * @date 2017/9/14 0014
 */
class GooglePlayActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_google_play
    }

    override fun initTitle(): String {
        return "GooglePlay"
    }

    override fun initData() {

    }

    override fun initView() {

    }

    override fun setListener() {
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
