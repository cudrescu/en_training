<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>JSP is fun!</title>
	</head>
<body>
	  <fieldset>
            <legend>Adauga departament nou</legend>
            <form action="FileCounter" method="post">
                Codul este : <input type="text" name="id"/><br>
                Numele este : <input type="text" name="denumire"/><br> 
                <input type="submit" value="Adauga acest departament"/>
            </form>
        </fieldset>
</body>
</html>