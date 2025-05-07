<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Course Form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>${course.id == null ? 'Add New Course' : 'Edit Course'}</h2>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/">Home</a>
    <form action="${pageContext.request.contextPath}/courses/save" method="post">
        <input type="hidden" name="id" value="${course.id}"/>
        <div class="form-group">
            <label>Title:</label>
            <input type="text" class="form-control" name="title" value="${course.title}" required/>
        </div>
        <button type="submit" class="btn btn-success">Save</button>
    </form>
</div>
</body>
</html>