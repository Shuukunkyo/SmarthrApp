package com.example.diceroller

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.diceroller.R
import com.example.diceroller.databinding.ActivityTipBinding
import kotlin.math.round

class TipActivity : AppCompatActivity() {
    //绑定对象实例,可以访问activity_tip.xml布局中的视图
    lateinit var binding: ActivityTipBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        //初始化binding，用于访问视图中的ui文件(view对象)
        binding = ActivityTipBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        //使用了viewBinding  所以不实用传统的viewById
        //root：根，连接到所有人
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)
        //在按钮上设置点击监听器，执行计算小费的方法calculateTip（）
        binding.buttonCalculate.setOnClickListener { calculateTip() }
    }

    private fun calculateTip() {
        val inputAmount = binding.costOfService.text.toString()
        val cost = inputAmount.toDouble()

        //根据选择的单项按钮选择百分比
        val tipPercentage=when(binding.radioGroup.checkedRadioButtonId) {
            R.id.amazing21 -> 0.21
            R.id.good16 -> 0.16
            else -> 0.1
        }
         var tip = cost * tipPercentage
        //四舍五入
        if(binding.roundUpTip.isChecked) {
            tip = round(tip)
        }
        //显示小费金额
        binding.tipAmount.text=tip.toString()
    }
}