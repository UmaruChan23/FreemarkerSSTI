<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Регистрация</title>
    <style>body {
        margin: 0; /* Убираем отступы */
        height: 100%; /* Высота страницы */
        background: url("https://images-na.ssl-images-amazon.com/images/S/sgp-catalog-images/region_GB/hasbro_studios-TV_MLP_FIM_S1-Full-Image_GalleryBackground-en-GB-1524863227706._RI_V8918956fdb3966c471b5063544987401_TTW_.jpg ");
        background-size: 100%; /* Фон занимает всю доступную площадь */
    }

    .registration_form {
        position: absolute;
        left: 20%;
        top: 50%;
        transform: translate(-50%, -50%);
        overflow: hidden;
        background-color: #2F6F8D;
        margin: 5px;
    }

    .registration_form form {
        margin: 10px;
    }

    .registration_form input {
        color: black;
        text-align: center;
        padding: 15px 20px;
        text-decoration: none;
        font-size: 17px;
    }

    .registration_form input:hover {
        background-color: #ddd;
        color: black;
    }

    .registration_form input.active {
        background-color: #04AA6D;
        color: white;
    }

    .registration_form button {
        margin-left: 30px;
        color: black;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
        font-size: 17px;
    }

    .registration_form a {
        float: left;
        color: #f2f2f2;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
        font-size: 17px;
    }

    .registration_form a:hover {
        background-color: #ddd;
        color: black;
    }

    .registration_form a.active {
        background-color: #04AA6D;
        color: white;
    }

    .registration_form h2 {
        margin-left: 45px;
        color: white;
        padding: 14px 16px;
    }
    </style>

</head>

<body>
<div class="registration_form">
    <form:form method="POST" modelAttribute="userForm">
        <h2>Регистрация</h2>
        <div>
            <form:input type="text" path="username" placeholder="Username"
                        autofocus="true"></form:input>
            <form:errors path="username"></form:errors>
                ${usernameError}
        </div>
        <div>
            <form:input type="password" path="password" placeholder="Password"></form:input>
        </div>
        <div>
            <form:input type="password" path="passwordConfirm"
                        placeholder="Confirm your password"></form:input>
            <form:errors path="password"></form:errors>
                ${passwordError}
        </div>
        <button type="submit">Зарегистрироваться</button>
    </form:form>
    <a href="/">Главная</a>
</div>
</body>
</html>