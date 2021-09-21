<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Log in with your account</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
    <style>

        body {
            margin: 0; /* Убираем отступы */
            height: 100%; /* Высота страницы */
            background: url("https://mlp.my1.ru/_ph/3/562637110.jpg");
            background-size: cover;
            background-attachment: fixed;
            background-repeat: repeat-x;
        }

        #root_container{
            position: absolute;
            left: 30%;
            top: 50%;
            height: 100%;
            width: 50%;
            transform: translate(-50%,-50%);
            background: #dddddd;
            scroll-behavior: smooth;
            overflow: auto;
        }
    </style>
</head>

<body>
<div id="root_container">
    <a href="/">Главная</a>
        <c:forEach items="${allItems}" var="item">
            <tr>
                <p>${item.name}</p>
                <p>${item.text}</p>
            </tr>
        </c:forEach>
    <form method="POST" action="/news">
        <h2>Оставить комментарий</h2>
        <div>
            <input name="text" type="text" placeholder="текст"/>
            <button type="submit">Send</button>
        </div>
    </form>
</div>
</body>
</html>