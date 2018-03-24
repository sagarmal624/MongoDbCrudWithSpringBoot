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
        <h1>List Of Courses</h1>
        <br>
		<br>
        <c:if test="${not empty courses}">
        	<table class="allcenter">
        		<tr>
        			<td>
        				<table class="fancytable">
							  <tr>
							    <th>Course ID </th>
							    <th>Name</th>
							    <th>Description</th>
							  </tr>
							  <c:forEach var="course1" items="${courses}">
								  	<tr>
										<td>${course1.courseID}</td>
								    	<td>${course1.name}</td>
								    	<td>${course1.description}</td>
									</tr>
							  </c:forEach>
						</table>
        			</td>
        			<td>
        				<table>
							  <tr>
							    <th class="noborder">&nbsp;</th>
							  </tr>
							  <c:forEach var="course2" items="${courses}">
								  	<tr>
										<td class="cellimages">
											<a href="/editcourse/${course2.id}">
												<img border="0" alt="Edit" src="Edit.png" width="20" height="20">
											</a>
										</td>
										<td class="cellimages">
											<a href="/deletecourse/${course2.id}">
												<img border="0" alt="Delete" src="Remove.png" width="20" height="20">
											</a>
										</td>
									</tr>
							  </c:forEach>
						</table>
        			</td>
        		</tr>
        	</table>
		</c:if>
		<br>
 		<br>
 		<div style="text-align:center">
 			<a href="/menu" class="link-btn-menu">RETURN TO MENU</a>
 		</div>
    </body>
</html>