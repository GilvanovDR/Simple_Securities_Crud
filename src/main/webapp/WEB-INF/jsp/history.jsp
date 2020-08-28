<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<section>
    <h3>История ценных бумаг</h3>
    <a href="history/create">Добавить историю</a>
    <hr>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>secId</th>
            <th>regNumber</th>
            <th>name</th>
            <th>emitentTitle</th>
            <th>tradedate</th>
            <th>numtrades</th>
            <th>open</th>
            <th>close</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${history}" var="history">
            <jsp:useBean id="history" scope="page" type="ru.GilvanovDR.model.History"/>
            <tr>
                <td>${history.security.secID}</td>
                <td>${history.security.regNumber}</td>
                <td>${history.security.name}</td>
                <td>${history.security.emitentTitle}</td>
                <td>${history.tradeDate}</td>
                <td>${history.numTrades}</td>
                <td>${history.open}</td>
                <td>${history.close}</td>
                <td><a href="history/update?id=${history.id}">Обновить</a></td>
                <td><a href="history/delete?id=${history.id}">Удалить</a></td>
            </tr>
        </c:forEach>
    </table>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>