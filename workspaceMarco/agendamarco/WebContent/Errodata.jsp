<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Erro na da data</title>

<link rel="stylesheet" href="./css/bootstrap.css">

</head>
<body>
<div class="container">

	<h1><% out.println("Erro de conversão da data"); %></h1>
	
		<a href="index.html"><button type="button" class="btn btn-primary">Pagina Inicial</button></a>

		<a href="Listar.jsp"><button type="button" class="btn btn-primary">Lista de contatos</button></a>


</div>
<script src="./js/jquery-3.3.1.slim.min.js"></script>
<script src="./js/bootstrap.js"></script>
<script src="./js/popper.js"></script>
</body>
</html>