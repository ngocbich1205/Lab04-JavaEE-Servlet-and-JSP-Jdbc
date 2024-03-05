<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core&quot; prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css&quot; rel="stylesheet">
</head>
<body>


<section class="container">
       <h1> THÔNG TIN PHÒNG BAN</h1>
    <p style="color: red;">${errorString}</p>
    <table class="table table-bordered" >
    <thead style="background:#f1f1f1">
        <tr>
        <th>Code</th>
        <th>Name</th>
        <th>Price</th>
        <th>Edit</th>
        <th>Delete</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${department}" var="department" >
        <tr>
        <td>${department.getDeptId()}</td>
        <td>${department.getDeptName()}</td>
        <td>${department.getDeptNo()}</td>
        <td>
        <a href="productEdit?code=${department.getDeptId()}">Edit</a>
        </td>
        <td>
        <a href="productDelete?code=${department.getDeptId()}">Delete</a>
        </td>
        </tr>
        </c:forEach>
    </tbody>
    </table>
   
    <a href="productCreate" >Create Product</a>
</section>

</body>
</html>