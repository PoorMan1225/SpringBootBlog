<%@ page language="java" contentType="text/html; ISO-8859-1" pageEncoding="UTF-8" %>
<%@ include file="../layout/header.jsp" %>
<div class="container">
    <form>
        <div class="form-group">
            <%--라벨 사용시 for 와 id 가 같아야함! --%>
            <label for="username">UserName</label>
            <input type="text" class="form-control" placeholder="Enter UserName" id="username">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" placeholder="Enter password" id="password">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" placeholder="Enter email" id="email">
        </div>
    </form>
    <button id="btn-save" class="btn btn-primary">화원가입완료</button>
</div>
<%--스프링 에서 기본 경로 js 를 static.js 를 참조함 --%>
<%--js 파일을 참조할때도 기본적으로 컨텍스트가 들어가야함. 스프링 의 경로에서 찾아야 하기 때문에 --%>
<%--js 는 인터프리터 언어기 때문에 일단 먼저 div 같은 요소가 그려지고 난다음에 동작해야 함--%>
<script src="<c:url value="/js/user.js"/>"></script>
<%@ include file="../layout/footer.jsp" %>



