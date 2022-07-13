package com.udemy.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		
		
		val btnStart : Button = findViewById(R.id.btn_start)
		val etName : EditText = findViewById(R.id.et_name)
		
		btnStart.setOnClickListener{
			if (etName.text.isEmpty()) {
				Toast.makeText(this, "Enter your name", Toast.LENGTH_SHORT).show()
			} else {
				
				//We create an Intent to move to another activity
				val intent = Intent(this, QuizQuestionsActivity::class.java)
				
				// This is the way to pass information from one activity to another
				// We pass a String(Constants.USER_NAME) as the reference and the data which the former refers to
				// Using "intent.putExtra("user_name", etName.text.toString())" is also correct
				intent.putExtra(Constants.USER_NAME, etName.text.toString())
				
				//We don't only have to create an intent to change activity but to START it as well
				startActivity(intent)
				
				//The "finish()" function will close the current activity(MainActivity) which means
				// we CAN'T come back to the current activity using the "back" button
				finish()
			}
		}
	}
}