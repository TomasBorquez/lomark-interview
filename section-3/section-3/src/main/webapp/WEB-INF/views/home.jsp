<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="me.tomas.borquez.section3.Product" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container mt-5">
    <h1>Product List</h1>

    <table class="table table-striped">
        <thead>
            <tr>
                <th>Name</th>
                <th>Price</th>
                <th>Description</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.name}</td>
                <td>$${product.price}</td>
                <td>${product.description}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <h2 class="mt-5">Add New Product</h2>
    <form id="addProductForm" action="${pageContext.request.contextPath}/addProduct" method="post" onsubmit="return validateForm()">
        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <input type="text" class="form-control" id="name" name="name" required>
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">Price</label>
            <input type="number" class="form-control" id="price" name="price" step="0.01" required>
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">Description</label>
            <textarea class="form-control" id="description" name="description" rows="3" required></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Add Product</button>
    </form>
</div>

<script>
    function validateForm() {
        var name = document.getElementById('name').value;
        var price = document.getElementById('price').value;
        var description = document.getElementById('description').value;

        if (name.trim() === '') {
            alert('Name cannot be empty');
            return false;
        }

        if (isNaN(price) || parseFloat(price) <= 0) {
            alert('Price must be a positive number');
            return false;
        }

        if (description.trim() === '') {
            alert('Description cannot be empty');
            return false;
        }

        return true;
    }
</script>
</body>
</html>
