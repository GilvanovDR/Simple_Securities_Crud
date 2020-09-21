<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<div class="jumbotron pt-4">
    <div class="container">
        СТЕК:
        <ul>
            <pre> Spring, Spring MVC, Data JPA, Hibernate, HSQL, Maven, Log4j/LogBack, JUNIT5, JAXB, Jackson, Tomcat, Heroku</pre>
        </ul>
        Функционал:
        <br>
        <ul>
            <li>Импорт объектов из приложенных файлов (securities_.xml, history_.xml)</li>
            <li>CREATE/UPDATE/DELETE(securities,history)</li>
            <li>При ручном сохранении ценной бумаги проводить валидацию передаваемых данных в поле name - только
                кириллица, цифры и пробел
            </li>
            <li>вывод таблицы с данными из тегов: secid regnumber name emitent_title tradedate numtrades open close
                SortBy emitent_title и tradedate
            </li>
        </ul>
        <br>
        Дополнительно:
        <ul>
            <li>Реализовано хранение и работа с данными в БД (HSQL in memory)</li>
            <li>Реализовано MVC приложение, позволяющее через интерфейс импортировать файлы и работать с таблицей CRUD
                операциями
            </li>
            <li>организован вывод данных по rest в формате json</li>
        </ul>
        <br>
        TODO:
        <ul>
            <li> Доработать импорт данных: при импорте истории по отсутствующей ценной бумаге выполнять rest запрос к
                API
                биржи (роут метода http://iss.moex.com/iss/securities.xml?q=SEARCH_STRING)
            </li>
            <li>Реализовать фоновое выполнение парсинга данных по расписанию</li>
            <li>Реализовать авторизацию (Spring security)</li>
        </ul>
        <br>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>