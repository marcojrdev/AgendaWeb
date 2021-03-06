package br.com.agenda.marco.serveliste;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.marco.bd.ContatoDao;
import br.com.agenda.marco.modelo.Contato;

@WebServlet("/alteraContato")
public class AlteraContatoServlet extends HttpServlet {
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		PrintWriter out = response.getWriter();
		Long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataEmTexto = request.getParameter("dataNascimento");
		Calendar dataNascimento = null;

		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		} catch (ParseException e) {
			RequestDispatcher rd = request
	                .getRequestDispatcher("/Errodata.jsp");
	        rd.forward(request,response);
			//out.println("Erro de convers�o da data");
			return; // para a execu��o do m�todo
		}

		Contato contato = new Contato();
		contato.setId(id); 
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);

		// salva o contato
		ContatoDao dao = new ContatoDao();
		dao.altera(contato);

		
		RequestDispatcher rd = request
                .getRequestDispatcher("Listar.jsp");
        rd.forward(request,response);
	}

}
