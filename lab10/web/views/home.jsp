<%--  Created by IntelliJ IDEA.  User: Влад Храмых  Date: 03.06.2019  Time: 19:50  To change this template use File | Settings | File Templates.--%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ page contentType="text/html;charset=UTF-8" language="java" %><html><head>    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">    <title>Главная страница</title></head><body><div class="w3-bar w3-teal">    <form method="post">        <button class="w3-bar-item w3-button" type="submit" name="button" value="logOut" style="vertical-align: bottom">Выйти из аккаунта</button>    </form>    <button class="w3-bar-item w3-button" onclick="location.href='/'" style="margin-top: -15px">Назад</button></div>    <h3>${date}</h3>    <h2>${user.getFirstName()}</h2>    <h2>${user.getSecondName()}</h2>    <h2>${user.getMail()}</h2>    <h2>${user.getId()}</h2>    <h2>${user.getPrivilege()}</h2>    <br><br>    <table class="w3-table-all w3-hoverable">        <tr>            <th> Id </th>            <th> Имя </th>            <th> Фамилия </th>            <th> Mail </th>            <th> Роль </th>        </tr>        <c:forEach var="user" items="${users}">            <tr>                <td>${user.getId()}</td>                <td>${user.getFirstName()}</td>                <td>${user.getSecondName()}</td>                <td>${user.getMail()}</td>                <td>${user.getPrivilege()}</td>                </tr>        </c:forEach>    </table></body></html>