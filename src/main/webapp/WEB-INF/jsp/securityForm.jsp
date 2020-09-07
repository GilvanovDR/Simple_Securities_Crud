<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="jumbotron pt-4">
    <div class="container">
        <jsp:useBean id="security" type="ru.GilvanovDR.model.Security" scope="request"/>

        <h3 class="text-center">${security.isNew() ? 'Добавить ценную бумагу' : 'Редактировать ценную бумагу'}</h3>
        <hr>
        <form method="post" action="security">
            <input type="hidden" name="id" value="${security.id}">
            <dl>
                <dt>SecId:</dt>
                <dd><input type="text" value="${security.secID}" size=40 name="secId" required></dd>
            </dl>
            <dl>
                <dt>regNumber:</dt>
                <dd><input type="text" value="${security.regNumber}" size=40 name="regNumber" ></dd>
            </dl>
            <dl>
                <dt>name:</dt>
                <dd><input type="text" value="${security.name}" size=40 name="name" required></dd>
            </dl>
            <dl>
                <dt>emitentTitle:</dt>
                <dd><input type="text" value="${security.emitentTitle}" size=40 name="emitentTitle" required></dd>
            </dl>
            <button class="btn btn-success" type="submit">Сохранить</button>
            <button class="btn btn-warning" onclick="window.history.back()" type="button">Отменить</button>
        </form>
        <c:if test="${not empty error}">
            <div class="alert alert-warning">${error}</div>
        </c:if>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
