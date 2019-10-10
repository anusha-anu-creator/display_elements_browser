package com.nit.dao;

import java.util.List;

import com.nit.model.Questions;

public interface QuestionsDao {
	
    public List<Questions> getAllQuestions();
	
	public Questions getQuestionById(String questionId);
	
	public List<String> getQuestionWithAnswers();
}
 