<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Home</title>
</head>
<body>
    <h1>Welcome to Student-Course App</h1>
    <nav>
        <a href="${pageContext.request.contextPath}/students/list">View Students</a><br>
        <a href="${pageContext.request.contextPath}/students/new">Add Student</a><br>
        <a href="${pageContext.request.contextPath}/courses/list">View Courses</a><br>
        <a href="${pageContext.request.contextPath}/courses/new">Add Course</a><br>
        <a href="${pageContext.request.contextPath}/students/joined">Student-Course Join View</a><br>
    </nav>
</body>
</html>
