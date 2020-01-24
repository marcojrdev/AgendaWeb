<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
        
      <%@ page import="java.util.*,
br.com.agenda.marco.bd.*,
br.com.agenda.marco.modelo.*" %>

<%@ page import=" java.text.*,java.text.SimpleDateFormat.*,
 java.util.Date.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alteracontatos</title>
<link rel="stylesheet" href="./css/bootstrap.css">

</head>
<body>

	 
		<%
		ContatoDao d = new ContatoDao();
		Contato c = d.getContatoById(request.getParameter("id"));
		SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");

		%>
	
	<div class="container">
	
	<h1>Altera Contatos</h1>
	<hr />
	<form action="alteraContato">
		
		Id:<br /> 
		 <input type="text" name="id" value="<%=c.getId()  %>"/><br/> 
		Nome: <br /> 
		<input type="text" name="nome" value="<%=c.getNome()%>"/><br /> 
		E-mail: <br /> 
		<input type="text" name="email" value="<%=c.getEmail()%>" /><br />
		Endereço:<br /> 
		 <input type="text" name="endereco" value="<%=c.getEndereco()%>"/><br />
		Data Nascimento:<br /> 
		 <input type="text"	name="dataNascimento" value="<%=formataData.format(c.getDataNascimento().getTimeInMillis())%>"/><br />
		
		
		<br /> <input class="btn btn-primary" type="submit"></button>
	
		
	
	</form>
		
		<br/><a href="index.html"><button type="button" class="btn btn-primary">Pagina Inicial</button></a>
		
		</div>
		
		<script src="./js/jquery-3.3.1.slim.min.js"></script>
<script src="./js/bootstrap.js"></script>
<script src="./js/popper.js"></script>
</body>
</html>