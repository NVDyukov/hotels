<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Главная</title>
</head>

<body>

<div class="nav" role="navigation">
    <ul>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="content" role="main">
    <section class="row">

        <h1>Поиск отелей</h1>

        <div class="outer-container">

            <div>
                <g:form class="content scaffold-create" controller="hotel" action="list" method="POST">
                    <div>
                        <label for="filterByName">Название отеля</label>
                        <g:textField name="filterByName" value="${filterParams.filterByName}"/>
                    </div>

                    <div>
                        <label for="filterByCountryId">Страна</label>
                        <g:select name="filterByCountryId" from="${countryList}" noSelection="${[null: 'Любая']}"
                                  value="${filterParams.filterByCountryId}"
                                  optionKey="id" optionValue="name"/>
                    </div>

                    <div>
                        <input type="submit" value="Найти"/>
                    </div>
                </g:form>
            </div>

            <div>
                <p>${message}</p>
            </div>

    </section>
</div>

</body>
</html>