package com.udemy.quizapp

/*  DATA MODEL OF QUESTIONS */

data class Question(

	//We need to define what information do we need for each question
	
	//an "id" to address each question differently
	val id: Int,
	
	//the ACTUAL "question" (the text)
	val question: String,
	
	//the "image" that goes with the question. In Android we can create images based on ints
	val image: Int,
	
	//each and every "option"
	val optionOne: String,
	val optionTwo: String,
	val optionThree: String,
	val optionFour: String,
	
	//and the number of the "correct answer"
	val correctAnswer: Int
)
