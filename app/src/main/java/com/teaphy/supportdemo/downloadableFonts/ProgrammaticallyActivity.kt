package com.teaphy.supportdemo.downloadableFonts

import android.graphics.Typeface
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.support.v4.provider.FontRequest
import android.support.v4.provider.FontsContractCompat
import com.teaphy.supportdemo.R
import com.teaphy.supportdemo.base.BaseActivity

import kotlinx.android.synthetic.main.activity_programmatically.*
import org.jetbrains.anko.toast


class ProgrammaticallyActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_programmatically
    }

    override fun initTitle(): String {
        return "编程方式下载字体"
    }

    override fun initData() {
    }

    override fun initView() {
    }

    override fun setListener() {
    }

    lateinit var mFontRequestCallback: FontsContractCompat.FontRequestCallback

    private lateinit var mHandler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val handlerThread = HandlerThread("fonts")
        handlerThread.start()
        mHandler = Handler(handlerThread.looper)

        /**
         * 1. 创建一个android.graphics.fonts.FontRequest类的实例来请求字体提供程序的字体。
         * 参数列表
         * providerAuthority：字体提供程序的权限
         * providerPackage：字体提供程序包，以验证字体提供程序的身份
         * providerQuery:字体的字符串查询。有关查询格式的更多信息，可以参阅字体提供程序的文档，如Google字体。
         * providerCerts:证书的一组哈希表，用于验证提供程序的身份证书的一组哈希表
         */
        val request = FontRequest("com.google.android.gms.fonts",
                "com.google.android.gms", "Aldrich", R.array.com_google_android_gms_fonts_certs)

        /**
         * 2. 创建FontsContract.FontRequestCallback实例
         */
        mFontRequestCallback = object : FontsContractCompat.FontRequestCallback() {

            override fun onTypefaceRetrieved(typeface: Typeface?) {
                super.onTypefaceRetrieved(typeface)

                toast("下载字体成功！")

                tvProgram.typeface = typeface
            }

            override fun onTypefaceRequestFailed(reason: Int) {
                super.onTypefaceRequestFailed(reason)
                toast("下载字体失败！reason: $reason")
            }
        }

        FontsContractCompat.requestFont(this@ProgrammaticallyActivity,
                request,
                mFontRequestCallback,
                mHandler)
    }

}
