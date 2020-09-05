<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="jumbotron pt-4">
    <div class="container">
        <h3 class="text-center">История ценных бумаг</h3>
        <a class="btn btn-primary" href="history/create">
            <span class="fa fa-plus"></span>
            Добавить историю
        </a>
        <hr>
        <div class="card border-dark">
            <div class="card-body pb-0">
                <form method="GET" action="history/filterBy">
                    <div class="form-group">
                        <label>emitentTitle:</label> <input class="form-control" type="text" name="emitentTitle">
                    </div>
                    <div class="form-group">
                        <label>tradedate:</label> <input class="form-control" type="date" name="tradeDate">
                    </div>
                    <input class="btn btn-primary mr-5" type="submit" value="Фильтровать">

                </form>
            </div>
        </div>
        <hr>
        <div class="table-responsive">
            <table border="1" cellpadding="4" cellspacing="0">
                <thead>
                <tr class="table table-dark">
                    <th><a href="history/sortBy?field=security.secID">secId</a></th>
                    <th>regNumber</th>
                    <th>name</th>
                    <th><a href="history/sortBy?field=security.emitentTitle">emitentTitle</a></th>
                    <th><a href="history/sortBy?field=tradeDate">tradedate</a></th>
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
                        <td><a class="btn btn-primary" href="history/update?id=${history.id}">Обновить</a></td>
                        <td><a class="btn btn-danger" href="history/delete?id=${history.id}">Удалить</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>