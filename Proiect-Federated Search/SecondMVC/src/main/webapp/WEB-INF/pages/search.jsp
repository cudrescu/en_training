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

<!-- Site footer -->
<div class="footer">
    <p>&copy; Endava 2014</p>
</div>

</div> <!-- /container -->

</body>

</html>

