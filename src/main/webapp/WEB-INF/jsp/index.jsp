<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE HTML>
<html>
<head>
    <title>Главная</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/index.css">
    <style>
        body {
            margin: 0; /* Убираем отступы */
            height: auto; /* Высота страницы */
            background: url("https://smolteddy.ru/wp-content/uploads/2019/04/maj-litl-poni-4.jpg");
            background-size: cover;
            background-attachment: fixed;
            background-repeat: repeat-x;
        }

        .main_container {
            position: absolute;
            left: 50%;
            top: 0%;
            transform: translate(-50%, -50%);
        }

        .top-nav {
            overflow: hidden;
            background-color: #333;
        }

        .top-nav a {
            float: left;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
        }

        .top-nav a:hover {
            background-color: #ddd;
            color: black;
        }

        .top-nav a.active {
            background-color: #04AA6D;
            color: white;
        }
    </style>
</head>
<body>
<div class="main_container">
    <div class="top-nav">
        <h3></h3>
        <sec:authorize access="!isAuthenticated()">
            <a href="/login">Войти</a>
            <a href="/registration">Зарегистрироваться</a>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <a href="/logout">Выйти</a>
        </sec:authorize>
        <a href="/hello">Взбодриться</a>
        <a href="/news">Форум</a>
    </div>
</div>
</body>
</html>