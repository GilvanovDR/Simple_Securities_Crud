<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="jumbotron pt-4">
    <div class="container">
        <form method="POST" enctype="multipart/form-data" action="upload">
            <input type="file" name="file">
            <input class="btn btn-primary fa fa-plus" type="submit" value="Загрузить">
        </form>
        <c:if test="${not empty upload}">
            <p>${upload}</p>
        </c:if>
    </div>

</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
