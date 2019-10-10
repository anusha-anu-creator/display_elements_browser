package com.nit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.nit.model.Questions;

public class QuestionDaoImpl implements QuestionsDao {
	private static Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	static {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:AdvancedJava", "system", "manager");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	public List<Questions> getAllQuestions() {
	     List<Questions> questionsList = new LinkedList<Questions>();
	     try {
	    	pstmt= con.prepareStatement("select * from nit_questions order by question_id;");
			rs = pstmt.executeQuery();
			Questions currentQuestion =null;
			while(rs.next()) {
				currentQuestion = new Questions();
				currentQuestion.setQuestionId(rs.getInt("question_id"));
				currentQuestion.setQuestionName(rs.getString("question_name"));
				currentQuestion.setOption1(rs.getString("option1"));
				currentQuestion.setOption2(rs.getString("option2"));
				currentQuestion.setOption3(rs.getString("option3"));
				currentQuestion.setOption4(rs.getString("option4"));
				questionsList.add(currentQuestion);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	     System.out.println("QuestionList:::" + questionsList);
	     return questionsList;		
	}

	public Questions getQuestionById(String questionId) {
		Questions currentQuestion = new Questions();
		try {
			rs = pstmt.executeQuery("select * from nit_questions where questio_id=?");
			if(rs.next()) {
				
				currentQuestion.setQuestionId(rs.getInt("question_id"));
				currentQuestion.setQuestionName(rs.getString("question_name"));
				currentQuestion.setOption1(rs.getString("option1"));
				currentQuestion.setOption2(rs.getString("option2"));
				currentQuestion.setOption3(rs.getString("option3"));
				currentQuestion.setOption4(rs.getString("option4"));
			}
		} catch (Exception e) {
			System.out.println("Exception got while getQuestionById()....." + e.getMessage());
		}		
		return currentQuestion;
	}
	
		
	public List<String> getQuestionWithAnswers(){		
		List<String> correctAnswersList = new ArrayList();
		try {
			rs = pstmt.executeQuery("select question_id,question_name,correct_answer from nit_questions order by question_id;");
			while(rs.next()) {
				correctAnswersList.add(rs.getString(3));
			}
		} catch (Exception e) {
			System.out.println("Exception got while getQuestionWithAnswers()....." + e.getMessage());
		}
		return correctAnswersList;		
	}
}
