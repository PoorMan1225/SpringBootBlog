<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>RJH 블로그</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <%--    추가되는 js 라이브러리의 경우는 여기에다가 추가--%>
    <%--    slim 이 추가되어있는 경우 제이쿼리 사용 불가능--%>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-md bg-dark navbar-dark">
    <%--          <c:url 태그는 자동으로 suffix 를 붙여준다.      --%>
    <a class="navbar-brand" href="<c:url value="/"/>">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <c:choose>
            <c:when test="${empty sessionScope.principal}">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/user/loginForm"/>">로그인</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/user/joinForm"/>">회원가입</a>
                    </li>
                </ul>
            </c:when>
            <c:otherwise>
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/board/writeForm"/>">글쓰기</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/user/userForm"/>">회원정보</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/user/logout"/>">로그아웃</a>
                    </li>
                </ul>
            </c:otherwise>
        </c:choose>
    </div>
</nav>
<br>