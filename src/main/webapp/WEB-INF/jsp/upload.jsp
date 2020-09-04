<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="jumbotron pt-4">
    <div class="container">
        <h3 class="text-center">Загрузить файл с данными московской биржи</h3>
        <form method="POST" enctype="multipart/form-data" action="upload">
            <input type="file" name="file">
            <input class="btn btn-primary" type="submit" value="Загрузить">
        </form>
        <c:if test="${not empty upload}">
            <div class="alert alert-primary">${upload}</div>
        </c:if>
    </div>

</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
