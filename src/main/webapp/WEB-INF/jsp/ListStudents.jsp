<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
    <link href="/style.css" rel="stylesheet">
</head>
<body>
<h1>List Of Students</h1>
<br>
<br>


<c:if test="${not empty students}">
    <table class="allcenter">
        <tr>
            <td>
                <table class="fancytable">
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Phone Number</th>
                        <th>Major</th>
                        <th>Student ID</th>
                    </tr>
                    <c:forEach var="student1" items="${students}">
                        <tr>
                            <td>${student1.firstName}</td>
                            <td>${student1.lastName}</td>
                            <td>${student1.phoneNumber}</td>
                            <td>${student1.major}</td>
                            <td>${student1.studentIdentifier}</td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
            <td>
                <table>
                    <tr>
                        <th class="noborder">&nbsp;</th>
                    </tr>
                    <c:forEach var="student2" items="${students}">
                        <tr>
                            <td class="cellimages">
                                <a href="<spring:url value="/editstudent/${student2.id}"/>">
                                    <img alt="Edit" src="Edit.png" width="20" height="20">
                                </a>
                            </td>
                            <td class="cellimages">
                                <a href="<spring:url value="/deletestudent/${student2.id}"/>">
                                    <img alt="Delete" src="Remove.png" width="20" height="20">
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