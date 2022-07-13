package com.udemy.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

// "QuizQuestionsActivity" class is inheriting from "AppCompatActivity()"
// and implementing "View.OnClickListener" so now it will allow us to click onto items inside of it.
// Of course we need to implement/override the members of "View.OnClickListener" (a.k.a. "onClick" function)
class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {
	
	// The user name that was passed on by MainActivity
	private var mUserName: String? = null
	private var mCorrectAnswers: Int = 0
	
	private var mCurrentQuestionIndex = 1
	private var mQuestionsList: ArrayList<Question>? = null
	private var mSelectedOptionPosition = 0
	
	
	private var tv_que: TextView? = null
	private var iv_img: ImageView? = null
	private var progressBar: ProgressBar? = null
	private var tv_progress: TextView? = null
	private var tv_opt1: TextView? = null
	private var tv_opt2: TextView? = null
	private var tv_opt3: TextView? = null
	private var tv_opt4: TextView? = null
	private var btn_submit: Button? = null
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_quiz_questions)
		
		// This is the way to get dat from another activity
		mUserName = intent.getStringExtra(Constants.USER_NAME)
		
		tv_que = findViewById(R.id.tv_que)
		iv_img = findViewById(R.id.iv_img)
		progressBar = findViewById(R.id.progressBar)
		tv_progress = findViewById(R.id.tv_progress)
		tv_opt1 = findViewById(R.id.tv_opt1)
		tv_opt2 = findViewById(R.id.tv_opt2)
		tv_opt3 = findViewById(R.id.tv_opt3)
		tv_opt4 = findViewById(R.id.tv_opt4)
		btn_submit = findViewById(R.id.btn_submit)
		
		
		// We basically say that "this" (meaning the "QuizQuestionsActivity" class)
		// should be the OnClickListener which it is as it implements the latter
		tv_opt1?.setOnClickListener(this)
		tv_opt2?.setOnClickListener(this)
		tv_opt3?.setOnClickListener(this)
		tv_opt4?.setOnClickListener(this)
		btn_submit?.setOnClickListener(this)
		
		mQuestionsList = Constants.getQuestions()
		
		setQuestion()
	}
	
	private fun setQuestion() {
		
		//Displays text onto the "Logcat" section below
		// "i" stands for information log and has white color on "logcat"
		Log.i("QuestionsList size is:", "${mQuestionsList?.size}")
		
		for (q in mQuestionsList!!) {
			// "e" stands for error log and has red color on "logcat"
			Log.e("Questions", q.question)
		}
		
		// First of all set the options in their default background
		defaultOptionsView()
		
		val q: Question = mQuestionsList!![mCurrentQuestionIndex-1]
		
		//Setting the content
		tv_que?.text = q.question
		iv_img?.setImageResource(q.image)
		
		progressBar?.progress = mCurrentQuestionIndex
		tv_progress?.text  = "${mCurrentQuestionIndex}/${progressBar?.max}"
		
		tv_opt1?.text = q.optionOne
		tv_opt2?.text = q.optionTwo
		tv_opt3?.text = q.optionThree
		tv_opt4?.text = q.optionFour
		
		//if we are at he last question change the button text from "submit" to "finish"
		if (mCurrentQuestionIndex== mQuestionsList?.size){
			btn_submit?.text = "Finish"
		}else {
			btn_submit?.text = "Submit"
		}
	}
	
	
	// Functions that sets the options in their default manner
	private fun defaultOptionsView() {
		// We create an array list with all the options...
		val options = ArrayList<TextView>()
		
		// and we add each option into the array list using "let" because they may be null
		tv_opt1?.let {
			options.add(0, it)
		}
		tv_opt2?.let {
			options.add(1, it)
		}
		tv_opt3?.let {
			options.add(2, it)
		}
		tv_opt4?.let {
			options.add(3, it)
		}
		
		for (opt in options) {
			
			// Setting the text color of the text of the TextView
			opt.setTextColor(Color.parseColor("#7A8089"))
			
			// Setting the "typeface"(font,style etc) of the text of the TextView to "DEFAULT"
			opt.typeface = Typeface.DEFAULT
			
			// Setting the background of the TextView using the file we created in the "drawable" folder
			opt.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
			
		}
	}
	
	
	// Function that has as arguments the TextView that was selected and needs to change and its number
	private fun selectedOptionsView(tv: TextView, selectedOptionNum: Int) {
	
		defaultOptionsView()
		
		mSelectedOptionPosition = selectedOptionNum
		
		// Setting the text color of the text of the TextView
		tv.setTextColor(Color.parseColor("#363A43"))
		
		// Setting the "typeface"(font,style etc) of the text of the TextView to "BOLD"
		// We can NOT use "tv.typeface = Typeface.BOLD" as we did in "defaultOptionsView()"
		tv.setTypeface(tv.typeface, Typeface.BOLD)
		
		// Setting the background of the TextView using the file we created in the "drawable" folder
		tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
	
	}
	
	// In order for this function to run it needs to be called
	// for each and every one option using "onClickListener()"
	override fun onClick(view: View?) {
		
		// When the view (TexView) is clicked then call the
		// "selectedOptionsView()" function for that particular view
		when (view?.id) {
			R.id.tv_opt1 -> { selectedOptionsView( tv_opt1!!, 1 ) }
			R.id.tv_opt2 -> { selectedOptionsView( tv_opt2!!, 2 ) }
			R.id.tv_opt3 -> { selectedOptionsView( tv_opt3!!, 3 ) }
			R.id.tv_opt4 -> { selectedOptionsView( tv_opt4!!, 4 ) }
			
			
			
			R.id.btn_submit -> {
				
				// If we have NOT selected an option then...
				if (mSelectedOptionPosition == 0) {
					mCurrentQuestionIndex++
					
					// if we have questions left set the next question
					if(mCurrentQuestionIndex <= mQuestionsList!!.size) {
						setQuestion()
					}
					
					// else(if we do NOT have any more questions) go to the FinishActivity
					else {
						val intent = Intent(this, FinishActivity::class.java)
						
						intent.putExtra(Constants.USER_NAME, mUserName)
						intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
						intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList?.size)
						
						startActivity(intent)
						finish()
					}
					
				}
				
				// else (if we HAVE selected an option)
				else {
					// keep the current question in a separate variable
					val question = mQuestionsList?.get(mCurrentQuestionIndex-1)
					
					// if the user picked the wrong option, highlight that option with red (wrong_option_border_bg)
					if (question!!.correctAnswer != mSelectedOptionPosition) {
						answerView(mSelectedOptionPosition,R.drawable.wrong_option_border_bg)
					} else {
						//Increase the correct answers by  1
						mCorrectAnswers++
					}
					
					// In general(whether the user picked it or not) highlight the
					// correct option with green (correct_option_border_bg)
					answerView(question.correctAnswer, R.drawable.correct_option_border_bg)
					
					// Change the text of the button whether we have more questions or not
					if(mCurrentQuestionIndex == mQuestionsList!!.size) {
						btn_submit?.text = "Finish"
					} else {
						btn_submit?.text = "Next Question"
					}
					
					// We need to change "mSelectedOptionPosition" back to because if not
					// we will always stay at the current selected option
					mSelectedOptionPosition = 0
				}
			}
		}
	}
	
	// "drawableView" is an Int that points to the location of a (drawable) file
	// each file has an id that is of type Int
	private fun answerView(answer: Int, drawableView: Int) {
		
		when(answer){
			1 -> tv_opt1?.background = ContextCompat.getDrawable(this, drawableView)
			2 -> tv_opt2?.background = ContextCompat.getDrawable(this, drawableView)
			3 -> tv_opt3?.background = ContextCompat.getDrawable(this, drawableView)
			4 -> tv_opt4?.background = ContextCompat.getDrawable(this, drawableView)
			
		}
	}
}
