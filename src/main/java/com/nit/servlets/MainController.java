package com.nit.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nit.dao.QuestionDaoImpl;
import com.nit.dao.QuestionsDao;
import com.nit.model.Questions;


public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String actionName = request.getParameter("actionName");		
		String question1 = request.getParameter("questions1");		
		String question2 = request.getParameter("questins2");
		String question3 = request.getParameter("questions3");
		String question4 = request.getParameter("questions4");
		String question5 = request.getParameter("questions5");				
		
	    QuestionsDao questionsDao = new QuestionDaoImpl();	  
	    List<Questions> allQuestions = questionsDao.getAllQuestions(); 	    
 	
	    List<String> answersList = questionsDao.getQuestionWithAnswers();
	    System.out.println("AnswersList:::::" + answersList);  
	    int correctAnswers = 0;
	    for(String correct:answersList) {
	    	
	    	if(question1 != null && correct.equals(question1)) {
	    		correctAnswers++;
	    	}else if(question2 != null && correct.equals(question2)) {
	    		correctAnswers++;
	    	}else if(question3 != null && correct.equals(question3)) {
	    		correctAnswers++;
	    	}
	    } 	         
    	request.setAttribute("questionsList", allQuestions);
    	RequestDispatcher rd= request.getRequestDispatcher("questions.jsp");
	    rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
