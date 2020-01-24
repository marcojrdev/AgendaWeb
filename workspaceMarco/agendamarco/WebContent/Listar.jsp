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
<link rel="stylesheet" href="./css/bootstrap.css">
<title>Lista de contatos </title>
</head>
<body>	
	<table class="table">
  <thead class="thead-light">
    <tr>
    
      <th scope="col">Alterar</th>
      <th scope="col">Remover</th>
      <th scope="col">Nome</th>
      <th scope="col">Endereco</th>
      <th scope="col">Email</th>
      <th scope="col">Data Nascimento</th>
    </tr>
  </thead>
  <tbody>
  <%
		ContatoDao dao = new ContatoDao();
		List<Contato> contatos = dao.getLista();
		SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
		for (Contato contato : contatos ) {
			
		%>
    <tr>
      
      <td><a href="Alterar.jsp?id=<%=contato.getId()%>"><button type="button" class="btn btn-warning">Alterar</button></a></td>
			<td><a href="Remover.jsp?id=<%=contato.getId()%>"><button type="button" class="btn btn-danger">Remover</button></a></td>
			<td><%=contato.getNome() %></td>
			<td><%=contato.getEndereco() %></td>
			<td><%=contato.getEmail() %></td>
			<td><%=formataData.format(contato.getDataNascimento().getTimeInMillis())%></td>
    </tr>
    <%} %>
  </tbody>
</table>
		<a href="adiciona-contato.html"><button type="button" class="btn btn-success">Adicionar Contato</button></a>

		<a href="index.html"><button type="button" class="btn btn-primary">Pagina Inicial</button></a>
		<script src="./js/jquery-3.3.1.slim.min.js"></script>
<script src="./js/bootstrap.js"></script>
<script src="./js/popper.js"></script>
</body>
</html>