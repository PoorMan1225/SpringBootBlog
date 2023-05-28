<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../layout/header.jsp" %>
<div class="container">
    <form action="#" method="post">
        <div class="form-group">
            <%--라벨 사용시 for 와 id 가 같아야함! --%>
            <label for="username">UserName</label>
            <input type="text" name="username" class="form-control" placeholder="Enter UserName" id="username">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" name="password" class="form-control" placeholder="Enter password" id="password">
        </div>
        <div class="form-group form-check">
            <label class="form-check-label">
                <input name="remember" class="form-check-input" type="checkbox"> Remember me
            </label>
        </div>
        <button id="btn-login" class="btn btn-primary">로그인</button>
    </form>
</div>
<%--<script src="<c:url value="/js/user.js"/>"></script>--%>
<%@ include file="../layout/footer.jsp" %>



