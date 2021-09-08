<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Log in with your account</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
    <style>
        #root_container{
            position: absolute;
            left: 50%;
            top: 50%;
            transform: translate(-50%,-50%);
        }
    </style>
</head>

<body>
<div id="root_container">
    <a href="/">Главная</a>
    <table>
        <thead>
        <th>ID</th>
        <th>Name</th>
        <th>Text</th>
        </thead>
        <c:forEach items="${allItems}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.text}</td>
            </tr>
        </c:forEach>
    </table>
    <form method="POST" action="/news">
        <h2>Оставть комментарий</h2>
        <div>
            <input name="name" type="text" placeholder="название"
                   autofocus="true"/>
            <input name="text" type="text" placeholder="текст"/>
            <button type="submit">Send</button>
        </div>
    </form>
</div>
</body>
</html>