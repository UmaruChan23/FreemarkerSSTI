<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Log in with your account</title>
    <style>
        body {
            margin: 0; /* Убираем отступы */
            height: 100%; /* Высота страницы */
            background: url("https://smolteddy.ru/wp-content/uploads/2019/04/maj-litl-poni-4.jpg");
            background-size: 100%; /* Фон занимает всю доступную площадь */
        }
        .login_form {
            position: absolute;
            left: 50%;
            top: 30%;
            transform: translate(-50%, -50%);
            overflow: hidden;
            background-color: #333;
            margin: auto;
        }

        .login_form input {
            margin-left: 12px;
            color: black;
            text-align: center;
            padding: 15px 20px;
            text-decoration: none;
            font-size: 17px;
        }

        .login_form input:hover {
            background-color: #ddd;
            color: black;
        }

        .login_form input.active {
            background-color: #04AA6D;
            color: white;
        }

        .login_form button {
            margin-left: 95px;
            color: black;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
        }

        .login_form a {
            float: left;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
        }

        .login_form a:hover {
            background-color: #ddd;
            color: black;
        }

        .login_form a.active {
            background-color: #04AA6D;
            color: white;
        }

        .login_form h2 {
            margin-left: 35px;
            color: white;
            padding: 14px 16px;
        }
    </style>
</head>

<body>
<sec:authorize access="isAuthenticated()">
    <% response.sendRedirect("/"); %>
</sec:authorize>
<div class="login_form">
    <form method="POST" action="/login">
        <h2>Вход в систему</h2>
        <div>
            <input name="username" type="text" placeholder="Username"
                   autofocus="true"/>
            <br>
            <input name="password" type="password" placeholder="Password"/>
            <br>
            <p></p>
            <button type="submit">Log In</button>
            <br>
            <a href="/registration">Зарегистрироваться</a>
            <a href="/">Главная</a>
        </div>
    </form>
</div>

</body>
</html>