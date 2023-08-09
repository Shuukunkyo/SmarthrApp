package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //本案例使用findById找到ui  此次按钮id为 button
//        Android 会自动将ID号码指派给应用程式的资源
//        资源ID的形式为R.<type>.<name>
//        对于View的ID<type>为id 例如R.id.button

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            //呼叫Toast.makeText()方法即可建立内含文字"Dice Rolled!"的Toast
            Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
            //进行滚动的功能
            rollDice()
        }
    }

//    骰子蓝图 class Dice
//    具有滚动的功能 fun roll（）

    private fun rollDice() {
        //建立新的Dice物件执行个体
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()

        //定义图片变量并且找到它
        val luckyTextView: TextView = findViewById(R.id.textView2)
        //定义幸运数字luckyNumber为6
        val luckyNumber = 6
        if (luckyNumber == diceRoll) {
            luckyTextView.text = getString(R.string.luckyNumber)
        } else {
            luckyTextView.text = ""
        }

        //定义图片变数并且找到他
        val diceImage: ImageView = findViewById(R.id.imageView)

// 1.0 ********************if用法找到图片**********************
//        if(diceRoll==1){
//            diceImage.setImageResource(R.drawable.dice_1)
//        }else if(diceRoll==2){
//            diceImage.setImageResource(R.drawable.dice_2)
//        }else if(diceRoll==3){
//            diceImage.setImageResource(R.drawable.dice_3)
//        }else if(diceRoll==4){
//            diceImage.setImageResource(R.drawable.dice_4)
//        }else if(diceRoll==5){
//            diceImage.setImageResource(R.drawable.dice_5)
//        }else{
//            diceImage.setImageResource(R.drawable.dice_6)
//        }
// 2.0 ****************相同的逻辑if更改为when陈述式简化**********
        val drawableResource = when (diceRoll) {
//            1 -> diceImage.setImageResource(R.drawable.dice_1)
//            2 -> diceImage.setImageResource(R.drawable.dice_2)
//            3 -> diceImage.setImageResource(R.drawable.dice_3)
//            4 -> diceImage.setImageResource(R.drawable.dice_4)
//            5 -> diceImage.setImageResource(R.drawable.dice_5)
//            6 -> diceImage.setImageResource(R.drawable.dice_6)
//        }
//3.0 *************相同的逻辑的When陈述式继续简化*****************
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
    }

    class Dice(private val numSides: Int) {
        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}
