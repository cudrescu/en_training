<%--
  Created by IntelliJ IDEA.
  User: cudrescu
  Date: 5/27/2014
  Time: 4:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../assets/ico/favicon.ico">

    <title>Federated Search For Movie Database</title>

    <!-- Bootstrap core CSS -->
    <link href="/resources/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/resources/justified-nav.css" rel="stylesheet">

</head>

<body>

<div class="container">

    <div class="masthead">
        <h3 class="text-muted">Movie Database Search Engine</h3>
        <ul class="nav nav-justified">
            <li><a href="/home">Home</a></li>
            <li class="active"><a href="">Search Engine</a></li>
            <li><a href="/contact">Contact</a></li>
        </ul>
    </div>

    <div>
        <form method="post" action="http://localhost:8080/">
            <div class="col-lg-6">
                <div class="input-group">
                    <input type="text" class="form-control" name="query">
          <span class="input-group-btn">
            <button class="btn btn-default" type="submit">Search!</button>
          </span>
                </div><!-- /input-group -->
            </div><!-- /.col-lg-6 -->
        </form>
    </div>

    <p><br><br><br></p>
    <div>
        <p><h3>
            Search results: </h3></p>

        <table id = "table"

            <c:forEach items="${list}" var="item">
                <tr>
                    <td width="30%">
                        <img alt="" src="${item.poster}" style="width: 240px; height: 320px; float: left;"/>
                    </td>
                    <td width="35%">
                        <p
                            style="text-align: left;">
                            <strong>Title:</strong> ${item.title} &nbsp;
                        </p>

                        <p
                             style="text-align: left;">
                             <strong>Genre:</strong> ${item.genre} &nbsp;
                        </p>

                        <p
                            style="text-align: left;">
                            <strong>IMDB Rating:</strong> ${item.imdbRating} &nbsp;
                        </p>

                        <p
                                style="text-align: left;">
                            <strong>Director:</strong> ${item.director} &nbsp;
                        </p>

                        <p
                                style="text-align: left;">
                            <strong>Writer:</strong> ${item.writer} &nbsp;
                        </p>

                        <p
                                style="text-align: left;">
                            <strong>Awards:</strong> ${item.awards} &nbsp;
                        </p>

                        <p
                                style="text-align: left;">
                            <strong>Actors:</strong> ${item.actors} &nbsp;
                        </p>
                    </td>

                    <td width="35%">
                        <p
                                style="text-align: left;">
                            <strong>Network:</strong> ${item.network} &nbsp;
                        </p>

                        <p
                                style="text-align: left;">
                            <strong>Air day:</strong> ${item.air_day} &nbsp;
                        </p>

                        <p
                                style="text-align: left;">
                            <strong>Air time:</strong> ${item.air_time} &nbsp;
                        </p>

                        <p
                                style="text-align: left;">
                            <strong>Status:</strong> ${item.status} &nbsp;
                        </p>

                        <p
                                style="text-align: left;">
                            <strong>Plot:</strong> ${item.plot} &nbsp;
                        </p>

                        <p
                                style="text-align: left;">
                            <strong>URL:</strong> <a href=${item.url} target="_blank"> ${item.url}</a> &nbsp;
                        </p>
                    </td>

                </tr>
            </c:forEach>
        </table>

        <c:forEach var="i" begin="0" end="${size-1}">
            <c:if test="${size > 1}">
                 <input  type="button" onclick="paging(${i})"  value="${i+1}" />
            </c:if>
        </c:forEach>

        <script type="text/javascript">
            function paging(index) {
                row_start = 5*index+index;
                row_end = 5*(index+1) + index;
                var table = document.getElementById("table");
                var rowCount = table.rows.length;
                for (var i = 0; i < rowCount; i++) {
                    if (i >= row_start && i <= row_end) {
                        table.rows[i].style.display = "block";
                    }
                    else {
                        table.rows[i].style.display = "none";
                    }
                }
            }
            window.onload = paging(0);

        </script>


    </div>

    <!-- Site footer -->
    <div class="footer">
        <p>&copy; Endava 2014</p>
    </div>

</div> <!-- /container -->

</body>

</html>

