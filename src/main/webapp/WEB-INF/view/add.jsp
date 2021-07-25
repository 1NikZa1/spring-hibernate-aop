<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Employee</title>
    <link rel="stylesheet" type="text/css"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">

</head>
<body>
<br>
<div class="container">
    <div style="text-align: center">
        <div class="badge bg-dark text-center">
            <h5>Add Employee</h5>
        </div>
    </div>

    <form:form action="save" modelAttribute="emp">

        <form:hidden path="id"/>
        Name
        <form:input cssClass="form-control" path="name"/>
        <br>
        Surname
        <form:input cssClass="form-control" path="surname"/>
        <br>
        Department
        <form:input cssClass="form-control" path="department"/>
        <br>
        Salary
        <form:input cssClass="form-control" path="salary"/>
        <br>
        <input type="submit" class="btn-dark" value="OK"/>
    </form:form>

</div>
</body>
</html>
