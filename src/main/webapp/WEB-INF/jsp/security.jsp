<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="jumbotron pt-4">
    <div class="container">
        <h3 class="text-center">Ценные бумаги</h3>
        <a class="btn btn-primary" href="security/create">
            <span class="fa fa-plus"></span>
            Добавить ценную бумагу
        </a>
        <hr>
        <table border="1" cellpadding="8" cellspacing="0">
            <thead>
            <tr class="table table-dark">
                <th>secId</th>
                <th>regNumber</th>
                <th>name</th>
                <th>emitentTitle</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${security}" var="security">
                <jsp:useBean id="security" scope="page" type="ru.GilvanovDR.model.Security"/>
                <tr>
                    <td>${security.secID}</td>
                    <td>${security.regNumber}</td>
                    <td>${security.name}</td>
                    <td>${security.emitentTitle}</td>
                    <td><a class="btn btn-primary" href="security/update?id=${security.id}">Обновить</a></td>
                    <td><a class="btn btn-danger" href="security/delete?id=${security.id}">Удалить</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>