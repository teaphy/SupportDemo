package com.teaphy.supportdemo.downloadableFonts

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.teaphy.supportdemo.R
import com.teaphy.supportdemo.adapter.AdapterFeature
import com.teaphy.supportdemo.base.BaseItemActivity
import com.teaphy.supportdemo.callback.OnItemClickCallback
import org.jetbrains.anko.startActivity

class DownloadFontActivity : BaseItemActivity<AdapterFeature.MyHolder, AdapterFeature>() {
    override fun getLayoutId(): Int {
        return R.layout.activity_download_font
    }

    override fun initTitle(): String {
        return "Downloadable Fonts"
    }

    override fun initData() {
        mApisList.addAll(resources.getStringArray(R.array.downloadFontArray))
    }

    override fun initView() {
    }

    override fun setListener() {
    }

    override fun initAdapter(): AdapterFeature {
        mAdapter = AdapterFeature(mApisList, object : OnItemClickCallback {
            override fun onClick(position: Int) {
                when (position) {
                    0 -> startActivity<GooglePlayActivity>()
                    1 -> startActivity<ProgrammaticallyActivity>()
                }
            }
        })
        return mAdapter
    }

    private val mApisList = mutableListOf<String>()
    lateinit var mAdapter: AdapterFeature

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
