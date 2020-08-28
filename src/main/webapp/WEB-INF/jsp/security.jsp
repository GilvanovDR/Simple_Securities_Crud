<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<section>
    <h3>Ценные бумаги</h3>
    <a href="security/create">добавить ценную бумагу</a>
    <hr>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
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
                <td><a href="security/update?id=${security.id}">Обновить</a></td>
                <td><a href="security/delete?id=${security.id}">Удалить</a></td>
            </tr>
        </c:forEach>
    </table>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>