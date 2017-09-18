package com.teaphy.supportdemo.font

import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v4.graphics.TypefaceCompat
import com.teaphy.supportdemo.R
import com.teaphy.supportdemo.base.BaseActivity

import kotlinx.android.synthetic.main.activity_font.*
import android.widget.TextView
import android.text.Spannable
import android.text.style.StyleSpan
import android.text.SpannableString



class FontActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_font
    }

    override fun initTitle(): String {
        return "Font in XML"
    }

    override fun initData() {
    }

    override fun initView() {
        //设置斜体
        val tmp = tvAlfaItalic.text.toString()
        val sp = SpannableString(tmp)
        sp.setSpan(StyleSpan(android.graphics.Typeface.BOLD_ITALIC), 0, tmp.length, Spannable.SPAN_EXCLUSIVE_INCLUSIVE)
        tvAlfaItalic.text = sp

        // 以编程方式使用字体
        val typeFace = ResourcesCompat.getFont(this, R.font.teaphy)
        tvAldrich.typeface = typeFace
    }

    override fun setListener() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
