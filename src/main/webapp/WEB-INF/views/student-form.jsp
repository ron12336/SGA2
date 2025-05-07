<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Student Form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>${student.id == null ? 'Add New Student' : 'Edit Student'}</h2>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/">Home</a>
    <form action="${pageContext.request.contextPath}/students/save" method="post">
        <input type="hidden" name="id" value="${student.id}"/>

        <div class="form-group">
            <label>Name:</label>
            <input type="text" class="form-control" name="name" value="${student.name}" required/>
        </div>

        <div class="form-group">
            <label>Select Courses:</label>
            <c:forEach var="course" items="${courses}">
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="courses" value="${course.id}"
                           <c:if test="${student.courses.contains(course)}">checked</c:if> />
                    <label class="form-check-label">${course.title}</label>
                </div>
            </c:forEach>
        </div>

        <button type="submit" class="btn btn-success">Save</button>
    </form>
</div>
</body>
</html>