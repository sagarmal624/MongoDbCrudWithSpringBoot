<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
    <head>
  		<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet"> 
  		<link href="/style.css" rel="stylesheet">
	</head>
    <body>
        <h1>Add Student</h1>
        <br>
		<br>
        <form:form method="POST" action="/addstudent" modelAttribute="student">
             <table class="form-table">
                <tr>
                    <td><form:label class="form-label" path="firstName">First Name:</form:label></td>
                    <td><form:input path="firstName" size="30"/></td>
                </tr>
                <tr>
                    <td><form:label class="form-label" path="lastName">Last Name:</form:label></td>
                    <td><form:input path="lastName" size="30"/></td>
                </tr>
                 <tr>
                    <td><form:label class="form-label" path="phoneNumber">Phone Number:</form:label></td>
                    <td><form:input path="phoneNumber" size="30"/></td>
                </tr>
                <tr>
                    <td><form:label class="form-label" path="major">Major:</form:label></td>
                    <td><form:input path="major" size="30"/></td>
                </tr>
                <tr>
                    <td><form:label class="form-label" path="studentIdentifier">Student ID:</form:label></td>
                    <td><form:input path="studentIdentifier" size="30"/><form:hidden path="id" value="${student.id}"/></td>
                </tr>
                <tr>
                	<td><input class="form-button-submit" type="submit" value="Submit"/></td>
                </tr>
                <tr>
                   <td><h2>Add Course</h2></td>
                </tr>
                 <tr>
               		<td><form:label class="form-label" path="courseID">Course:</form:label></td>
		            <td>
		                 <form:select path = "courseID">
		                    <form:option value = "NONE" label = "Select"/>
		                    <form:options items = "${courseMap}" />
		                 </form:select>     	
		            </td>
            </tr>   	
            </table>
        </form:form>
        
        <c:if test="${not empty message}">
    		<p class="message">
    			${message}
    		</p>
		</c:if>
		<br>
 		<br>
 		<div style="text-align:center">
 			<a href="/menu" class="link-btn-menu">RETURN TO MENU</a>
 		</div>
    </body>
</html>