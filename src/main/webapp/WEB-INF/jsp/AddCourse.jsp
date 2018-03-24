<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
    <head>
  		<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet"> 
  		<link href="style.css" rel="stylesheet">
	</head>
    <body>
        <h1>Add Course</h1>
        <br>
		<br>
        <form:form method="POST" action="/addcourse" modelAttribute="course">
             <table class="form-table">
             	<tr>
                    <td><form:label class="form-label" path="courseID">Course ID:</form:label></td>
                    <td><form:input path="courseID" size="30"/><form:hidden path="id" value="${course.id}"/></td>
                </tr>
                <tr>
                    <td><form:label class="form-label" path="name">Name:</form:label></td>
                    <td><form:input path="name" size="30"/></td>
                </tr>
                <tr>
                    <td><form:label class="form-label" path="description">Description:</form:label></td>
                    <td><form:input path="description" size="30"/></td>
                </tr>
                 <tr>
                   <td><h2>Instructor</h2></td>
                </tr>
                 <tr>
                    <td><form:label class="form-label" path="instructorFirstName">Instructor First Name:</form:label></td>
                    <td><form:input path="instructorFirstName" size="30"/></td>
                </tr>
                <tr>
                    <td><form:label class="form-label" path="instructorLastName">Instructor Last Name:</form:label></td>
                    <td><form:input path="instructorLastName" size="30"/></td>
                </tr>
                <tr>
                    <td><form:label class="form-label" path="instructorDepartment">Department:</form:label></td>
                    <td><form:input path="instructorDepartment" size="30"/></td>
                </tr>
                <tr>
                   <td><h2>Topic</h2></td>
                </tr>
                 <tr>
               		<td><form:label class="form-label" path="topicID">Topic:</form:label></td>
		            <td>
		                 <form:select path = "topicID">
		                    <form:option value = "NONE" label = "Select"/>
		                    <form:options items = "${topicMap}" />
		                 </form:select>     	
		            </td>
            	</tr>   	
               	<tr>
                    <td><br><br><br></td>
                <tr>
                	<td><input class="form-button-submit" type="submit" value="Submit"/></td>
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