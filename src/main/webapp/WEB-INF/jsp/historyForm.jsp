<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="jumbotron pt-4">
    <div class="container">
        <jsp:useBean id="history" type="ru.GilvanovDR.model.History" scope="request"/>

        <h3 class="text-center">${history.isNew() ? 'Добавить историю' : 'Редактировать истори'}</h3>
        <hr>
        <form method="post" action="history">
            <input type="hidden" name="id" value="${history.id}">
            <dl>
                <dt>SecId:</dt>
                <dd><input type="text" value="${history.security.secID}" size=40 name="secId" required></dd>
            </dl>
            <dl>
                <dt>tradedate:</dt>
                <dd><input type="date" value="${history.tradeDate}" name="tradeDate" ></dd>
            </dl>
            <dl>
                <dt>numtrades:</dt>
                <dd><input type="number" value="${history.numTrades}" size=40 name="numTrades" required></dd>
            </dl>
            <dl>
                <dt>open:</dt>
                <dd><input type="number" step=0.01 value="${history.open}" size=40 name="open" ></dd>
            </dl>
            <dl>
                <dt>close:</dt>
                <dd><input type="number" step=0.01 value="${history.close}" size=40 name="close" ></dd>
            </dl>

            <button class="btn btn-success" type="submit">Сохранить</button>
            <button class="btn btn-warning" onclick="window.history.back()" type="button">Отменить</button>
        </form>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
