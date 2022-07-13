package com.udemy.quizapp

/* STORE ALL THE DIFFERENT CONSTANTS THA WE WANT */

object Constants {
	
	// USER_NAME= the constant name that we are using
	// user_name= how "USER_NAME" is going to be stored internally.
	// 			  Something like the key or the location which helps us pass data from one activity to another.
	const val USER_NAME: String = "user_name"
	const val TOTAL_QUESTIONS: String = "total_questions"
	const val CORRECT_ANSWERS: String = "correct_answers"
	
	// Function that returns ALL the questions
	fun getQuestions():ArrayList<Question>{
		val questionsList = ArrayList<Question>()
		
		//Question 1
		val que1 = Question(
			1,
			"What country does this flag belong to?",
			R.drawable.ic_flag_of_argentina /*this returns an INTEGER*/,
			"Australia",
			"Austria",
			"Argentina",
			"Armenia",
			3
		)
		questionsList.add(que1)
		
		//Question 2
		val que2 = Question(
			2,
			"What country does this flag belong to?",
			R.drawable.ic_flag_of_australia /*this returns an INTEGER*/,
			"Australia",
			"Austria",
			"Argentina",
			"Armenia",
			1
		)
		questionsList.add(que2)
		
		//Question 3
		val que3 = Question(
			3,
			"What country does this flag belong to?",
			R.drawable.ic_flag_of_belgium /*this returns an INTEGER*/,
			"Switzerland",
			"Belgium",
			"Germany",
			"Moldova",
			2
		)
		questionsList.add(que3)
		
		//Question 4
		val que4 = Question(
			4,
			"What country does this flag belong to?",
			R.drawable.ic_flag_of_brazil /*this returns an INTEGER*/,
			"New Guinea",
			"Venezuela",
			"Brazil",
			"Mexico",
			3
		)
		questionsList.add(que4)
		
		//Question 5
		val que5 = Question(
			5,
			"What country does this flag belong to?",
			R.drawable.ic_flag_of_denmark /*this returns an INTEGER*/,
			"Switzerland",
			"Finland",
			"Norway",
			"Denmark",
			4
		)
		questionsList.add(que5)
		
		//Question 6
		val que6 = Question(
			6,
			"What country does this flag belong to?",
			R.drawable.ic_flag_of_fiji /*this returns an INTEGER*/,
			"Faeroe Islands ",
			"Fiji Islands",
			"Peru",
			"New Zealand",
			2
		)
		questionsList.add(que6)
		
		//Question 7
		val que7 = Question(
			7,
			"What country does this flag belong to?",
			R.drawable.ic_flag_of_germany /*this returns an INTEGER*/,
			"France",
			"Belgium",
			"Latvia",
			"Germany",
			4
		)
		questionsList.add(que7)
		
		//Question 8
		val que8 = Question(
			8,
			"What country does this flag belong to?",
			R.drawable.ic_flag_of_india /*this returns an INTEGER*/,
			"India",
			"Nepal",
			"Bhutan",
			"Thailand",
			1
		)
		questionsList.add(que8)
		
		//Question 9
		val que9 = Question(
			9,
			"What country does this flag belong to?",
			R.drawable.ic_flag_of_kuwait /*this returns an INTEGER*/,
			"Yemen",
			"Oman",
			"Bahrain",
			"Kuwait",
			4
		)
		questionsList.add(que9)
		
		//Question 10
		val que10 = Question(
			10,
			"What country does this flag belong to?",
			R.drawable.ic_flag_of_new_zealand /*this returns an INTEGER*/,
			"Australia",
			"New Zealand",
			"Papua New Guinea",
			"Indonesia",
			2
		)
		questionsList.add(que10)
		
		
		return questionsList
	}
	
}