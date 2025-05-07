<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Student-Course Join</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Students and Their Courses</h2>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/">Home</a>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Student Name</th>
            <th>Course Title</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="entry" items="${joinedData}">
            <tr>
                <td>${entry.studentName}</td>
                <td>${entry.courseTitle}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>