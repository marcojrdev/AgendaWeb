package br.com.agenda.marco.modelo;

import java.util.Calendar;

import br.com.agenda.marco.bd.ContatoDao;

public class teste {

	
	public static void main(String[] args) {
		//pronto	para	gravar
		Contato	contato	=	new	Contato();
		contato.setNome("Caelum");
		contato.setEmail("contato@caelum.com.br");
		contato.setEndereco("R.	Vergueiro	3185	cj57");
		contato.setDataNascimento(Calendar.getInstance());
//grave	nessa	conex�o!!!
		ContatoDao	dao	=	new	ContatoDao();
//m�todo	elegante
		dao.adiciona(contato);
		System.out.println("Gravado!");
	}

}
