<%--  Created by IntelliJ IDEA.  User: Влад Храмых  Date: 02.06.2019  Time: 18:02  To change this template use File | Settings | File Templates.--%><%@ page contentType="text/html;charset=UTF-8" language="java" %><html><head>    <title>Регистрация</title></head><body><h1>Result - ${done}</h1><form method="post">    <label>Mail:        <br/>        <input type="text" name="mail"/>    </label>    <br/>    <label>Пароль:        <br/>        <input type="text" name="password"/>    </label>    <br/>    <label>Имя:        <br/>        <input type="text" name="firstName"/>    </label>    <br/>    <label>Фамилия:        <br/>        <input type="text" name="secondName"/>    </label>    <br/>    <button type="submit">Регистрация</button></form><button onclick="location.href='/'">Назад</button></body></html>