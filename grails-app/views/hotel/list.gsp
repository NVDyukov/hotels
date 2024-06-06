<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'hotel.label', default: 'Hotel')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-hotel" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.newsearch.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div>
            <p>${message}</p>
        </div>
        <div id="list-hotel" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.hotel.label" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <table>
                <tr>
                    <th><g:message code="hotel.name.label"/></th>
                    <th><g:message code="hotel.starRating.label"/></th>
                    <th><g:message code="hotel.country.label"/></th>
                    <th><g:message code="hotel.action"/></th>
                </tr>
                <g:each in="${hotelList}" var="hotel" status="n">
                    <tr class="${(n % 2) == 0 ? 'even' : 'odd'}">
                        <td>
                            ${hotel.name}
                            <g:if test="${(hotel.webSite)}">
                                <br>
                                <a href="${hotel.webSite}" target="_blank"><g:message code="hotel.webSite.link"/></a>
                            </g:if>
                        </td>
                        <td>
                            <g:each in="${1..hotel.starRating}">
                                ★
                            </g:each>
                        </td>
                        <td>${hotel.country.name}</td>
                        <td>
                            <g:link class="button-link" controller="hotel" action="show" id="${hotel.id}">
                                <g:message code="default.button.edit.label"/>
                            </g:link>
                        </td>
                    </tr>
                </g:each>
            </table>

            <div class="pagination">
                <g:paginate total="${hotelCount ?: 0}" />
            </div>
        </div>
    </body>
</html>