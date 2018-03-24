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
        <h1>Add Topic</h1>
        <br>
		<br>
        <form:form method="POST" action="/topics" modelAttribute="topic">
             <table class="form-table">
                <tr>
                    <td><form:label class="form-label" path="name">Name:</form:label></td>
                    <td><form:input path="name" size="30"/></td>
                </tr>
                <tr>
                    <td><form:label class="form-label" path="description">Description:</form:label></td>
                    <td><form:input path="description" size="30"/><form:hidden path="id" value="${topic.id}"/></td>
                </tr>
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