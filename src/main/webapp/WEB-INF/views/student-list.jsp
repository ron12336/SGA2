<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Student List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>All Students</h2>
    <a class="btn btn-primary mb-3" href="${pageContext.request.contextPath}/students/new">Add New Student</a>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/">Home</a>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Name</th>
            <th>Courses</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="student" items="${students}">
            <tr>
                <td>${student.name}</td>
                <td>
                    <c:forEach var="course" items="${student.courses}" varStatus="status">
                        ${course.title}<c:if test="${!status.last}">, </c:if>
                    </c:forEach>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/students/edit/${student.id}" class="btn btn-warning btn-sm">Edit</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>