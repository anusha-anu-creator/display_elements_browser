<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form action="MainController" method="post">
	<table align="center">
		<c:forEach var="currentQuestion" items="${requestScope.questionsList}" varStatus="i">
			<tr>
				<td colspan="4">${i.count}.${currentQuestion.questionName}</td>
			</tr>
			<tr>
				<td><input type="radio"
					name="questions${currentQuestion.questionId}" 
					value="${currentQuestion.option1}"/>${currentQuestion.option1}</td>
				<td><input type="radio"
					name="questions${currentQuestion.questionId}" 
					value="${currentQuestion.option2}"/>${currentQuestion.option2}</td>
				<td><input type="radio"
					name="questions${currentQuestion.questionId}" 
					value="${currentQuestion.option3}"/>${currentQuestion.option3}</td>
				<td><input type="radio"
					name="questions${currentQuestion.questionId}" 
					value="${currentQuestion.option4}"/>${currentQuestion.option4}</td>
			</tr>
			<tr>
				<td colspan="4">&nbsp;</td>
			</tr>
		</c:forEach>
	    <tr>
			<td><input type="hidden" name="actionName" value="submit"/></td>
		<tr>
			<td colspan="4"><input type="submit" value="Submit Exam" /></td>
		</tr>	
	</table>
</form>
