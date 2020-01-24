package br.com.agenda.marco.bd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.agenda.marco.modelo.Contato;
import com.mysql.jdbc.PreparedStatement;


public class ContatoDao {
	// a conex�o com o banco de dados
	private Connection connection;

	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Contato contato) {
		String sql = "insert into contatos"
				+ "(nome,email,endereco,dataNascimento)" + "	values	(?,?,?,?)";
		try {
			// prepared statement para inser��o
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			// seta os valores
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento()
					.getTimeInMillis()));
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<Contato> getLista() {
		 try {
		 List<Contato> contatos = new ArrayList<Contato>();
		 PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement("select * from contatos");
		 ResultSet rs = stmt.executeQuery();
		 
		while (rs.next()) {
		 // criando o objeto Contato
		 Contato contato = new Contato();
		 contato.setId(rs.getInt("id"));
		 contato.setNome(rs.getString("nome"));
		 contato.setEmail(rs.getString("email"));
		 contato.setEndereco(rs.getString("endereco"));
		
		 // montando a data atrav�s do Calendar
		 Calendar data = Calendar.getInstance();
		 data.setTime(rs.getDate("dataNascimento"));
		 contato.setDataNascimento(data);
		
		 // adicionando o objeto � lista
		 contatos.add(contato);
		 }
		 rs.close();
		 stmt.close();
		 return contatos;
		 } catch (SQLException e) {
		 throw new RuntimeException(e);
		 }
		 }
	
	public	void	remove(Contato	contato) {
		try	{
			java.sql.PreparedStatement stmt = connection.prepareStatement("delete from contatos	where id=?");
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();
		} catch	(SQLException	e)	{
			throw new	RuntimeException(e);
		}
	}

	 public Contato getContatoById(String id) {
         Contato contato = new Contato();

         try {
             java.sql.PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM contatos WHERE id=?");
             stmt.setLong(1, Long.parseLong(id));
             ResultSet rs = stmt.executeQuery();

             while (rs.next()) {
                 contato.setId(rs.getLong("id"));
                 contato.setNome(rs.getString("nome"));
                 contato.setEmail(rs.getString("email"));
                 contato.setEndereco(rs.getString("endereco"));

                 Calendar data = Calendar.getInstance();
                 data.setTime(rs.getDate("dataNascimento"));
                 contato.setDataNascimento(data);
             }
             rs.close();
             stmt.close();

         } catch (SQLException e) {
             throw new RuntimeException(e);
         }

         return contato;
     }

	 public	void	altera(Contato	contato) {
			String	sql	= "update contatos set	nome=?,	email=?,"+
"endereco=?, dataNascimento=? where id=?";
try	{
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1,contato.getNome());
			stmt.setString(2,contato.getEmail());
			stmt.setString(3,contato.getEndereco());
			stmt.setDate(4,	new	Date(contato.getDataNascimento()
			.getTimeInMillis()));
			stmt.setLong(5,	contato.getId());
			stmt.execute();
			stmt.close();
			}	catch	(SQLException e)	{
throw new	RuntimeException(e);
			}
}
}

