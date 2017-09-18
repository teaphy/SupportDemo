package com.teaphy.supportdemo

import android.os.Bundle
import com.teaphy.supportdemo.adapter.AdapterFeature
import com.teaphy.supportdemo.base.BaseItemActivity
import com.teaphy.supportdemo.callback.OnItemClickCallback
import com.teaphy.supportdemo.downloadableFonts.DownloadFontActivity
import com.teaphy.supportdemo.font.FontActivity
import org.jetbrains.anko.startActivity

class MainActivity : BaseItemActivity<AdapterFeature.MyHolder, AdapterFeature>() {

    override fun initAdapter(): AdapterFeature {
        mAdapter = AdapterFeature(mApisList, object : OnItemClickCallback {
            override fun onClick(position: Int) {
                when (position) {
                    0 -> startActivity<DownloadFontActivity>()
                    1 -> startActivity<FontActivity>()
                }
            }
        })
        return mAdapter
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initTitle(): String {
        return "Support API列表"
    }

    override fun initData() {
        mApisList.addAll(resources.getStringArray(R.array.appisArray))
    }

    override fun initView() {

    }

    override fun setListener() {

    }

    private val mApisList = mutableListOf<String>()
    lateinit var mAdapter: AdapterFeature

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}
