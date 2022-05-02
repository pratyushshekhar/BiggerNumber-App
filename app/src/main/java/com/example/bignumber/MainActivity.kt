package com.example.bignumber

import android.graphics.Color
import android.graphics.Color.green
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsetsAnimation
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        leftBtn.setOnClickListener {
        checkAnswer(true)
        }
        rightBtn.setOnClickListener {
        checkAnswer(false)
        }
    }
    private fun checkAnswer(isLeftBtnSelected:Boolean){
        val leftNum:Int= leftBtn.text.toString().toInt()
        val rightNum:Int= rightBtn.text.toString().toInt()
        val isAnswerCorrect: Boolean=if (isLeftBtnSelected)
            leftNum > rightNum
        else rightNum > leftNum
        if (isAnswerCorrect){
            //change background color
            backgroundView.setBackgroundColor(Color.GREEN)
            Toast.makeText(this,"Correct",Toast.LENGTH_SHORT).show()
        }
        else{
            backgroundView.setBackgroundColor(Color.RED)
            Toast.makeText(this,"Wrong", Toast.LENGTH_SHORT).show()
        }
        assignNumbersToButtons()
    }
    private fun assignNumbersToButtons() {
        val r= Random()
        val leftNum =r.nextInt(10)
        var rightNum= leftNum
        while (leftNum==rightNum){
            rightNum= r.nextInt(10)
        }
        leftBtn.text=leftNum.toString()
        rightBtn.text= rightNum.toString()
    }
}