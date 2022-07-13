package com.udemy.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class FinishActivity : AppCompatActivity() {
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_finish)
		
		val tv_name: TextView = findViewById(R.id.tv_name)
		tv_name.text = intent.getStringExtra(Constants.USER_NAME)
		
		// getIntExtra needs a default value in case we did not get any value
		val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
		val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
		
		val tv_score: TextView = findViewById(R.id.tv_score)
		tv_score.text = "Your score is $correctAnswers out of $totalQuestions"
		
		val btn_finish: Button = findViewById(R.id.btn_finish)
		btn_finish.setOnClickListener{
			startActivity(Intent(this, MainActivity::class.java))
		}
	}
}