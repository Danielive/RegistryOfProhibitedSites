<%@ page import="live.daniel.webapps.service.WebService" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--DOM--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Реестр запрещенных сайтов</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/main.css">
</head>
<body class="registryOfProhibitedSites">
<div class="container">
    <div class="row">
        <div class="col-md-10">
            <form class="form-horizontal" action="deletesite" method="POST">
                <div class="panel-heading">Реестр запрещенных сайтов</div>
                <menu>
                    <ul>
                        <a href="http://localhost:8080/registry" class="btn btn-primary" role="button">
                            <li>
                                Список сайтов
                            </li>
                        </a>
                        <a href="http://localhost:8080/addsite" class="btn btn-primary" role="button">
                            <li>
                                Добавить сайт в список
                            </li>
                        </a>
                        <a href="http://localhost:8080/deletesite" class="btn btn-primary" role="button">
                            <li>
                                Удалить сайт из списка
                            </li>
                        </a>
                    </ul>
                </menu>
                <legend>Удаление сайта</legend>
                <div class="form-group">
                    <label class="col-sm-4 control-label">Ссылка</label>
                    <c:if test="${not empty allSites}">
                        <select class="form-control" name="id">
                            <c:forEach var="site" items="${allSites}">
                                <%--<c:forEach var="listIDValue" items="${listsID}">--%>
                                <option value=${site.id}>${site.link}</option>
                                <%--</c:forEach>--%>
                            </c:forEach>
                        </select>
                    </c:if>
                </div>

                <div class="form-group">
                    <div class="col-sm-8 col-sm-offset-4">
                        <button class="btn btn-default">Удалить</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
</html>