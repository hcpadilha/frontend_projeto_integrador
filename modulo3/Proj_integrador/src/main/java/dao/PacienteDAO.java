package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Paciente;



public class PacienteDAO {
	Connection cnx = null;
	
	
	//LOGIN-----------------------------------------------------------
	public Paciente consultarUsuario(String login, String senha) {
		Paciente usuario = null;
		ResultSet rs = null;
		
		cnx = DAO.createConnection();
		
		String sql = "SELECT * FROM  tb_paciente WHERE usuario = ? AND senha = ?";
		
		try {
			
			PreparedStatement ps = cnx.prepareStatement(sql);
			
			ps.setString(1, login);
			ps.setString(2, senha);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				usuario = new Paciente();
				
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setSenha(rs.getString("senha"));
				
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return usuario;	
	}
	
	//Cadastrar---------------------------------------------------
	public boolean cadastrarPaciente(Paciente paciente) {
		boolean resultado = true;
		  int retornoQuery;
		  
		  cnx = DAO.createConnection();
		
		  String sql = "INSERT INTO tb_paciente(nome, usuario, senha, cpf, endereco, cel, nome_pet, idade_pet, raca, descricao) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		  try {
				PreparedStatement ps = cnx.prepareStatement(sql);
				ps.setString(1, paciente.getNome());
				ps.setString(2, paciente.getUsuario());
				ps.setString(3, paciente.getSenha());
				ps.setString(4, paciente.getCpf());
				ps.setString(5, paciente.getEndereco());
				ps.setString(6, paciente.getCel());
				ps.setString(7, paciente.getNomePet());
				ps.setInt(8, paciente.getIdadePet());
				ps.setString(9, paciente.getRaca());
				ps.setString(10, paciente.getDescricao());
				
				retornoQuery = ps.executeUpdate();
				
				if(retornoQuery <= 0) {
					resultado = false;
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return resultado;
		
	}
	
	//Exibição da tabela do banco de dados----------------------------------
	public List<Paciente> listar(){
		List<Paciente> listaDePaciente = new ArrayList<Paciente>();
		
		ResultSet rs = null;
		Paciente paciente = null;
		
		cnx = DAO.createConnection();
		
		String sql = "SELECT * FROM tb_paciente";
		
		try {
			PreparedStatement ps = cnx.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				paciente = new Paciente();
				
				paciente.setId(rs.getInt("id"));
				paciente.setNome(rs.getString("nome"));
				paciente.setUsuario(rs.getString("usuario"));
				paciente.setSenha(rs.getString("senha"));
				paciente.setCpf(rs.getString("cpf"));
				paciente.setEndereco(rs.getString("endereco"));
				paciente.setCel(rs.getString("cel"));
				paciente.setNomePet(rs.getString("nome_pet"));
				paciente.setIdadePet(rs.getInt("idade_pet"));
				paciente.setRaca(rs.getString("raca"));
				paciente.setDescricao(rs.getString("descricao"));
				
				
				listaDePaciente.add(paciente);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaDePaciente;
	}
	public boolean excluirPaciente(int id) {
		boolean resultado = true;
		int retornoQuery;
		
		cnx = DAO.createConnection();
		
		String sql = "DELETE FROM tb_paciente WHERE id=?";
		
		try {
			PreparedStatement ps = cnx.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			retornoQuery = ps.executeUpdate();
			
			if(retornoQuery <= 0) {
				resultado = false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
	}
	public boolean alterarPaciente(Paciente paciente) {
		boolean resultado = true; 
		int retornoQuery;
		
		cnx= DAO.createConnection();
		
		String sql = "UPDATE tb_paciente SET nome=?, cpf=?, endereco=?, cel=?, nome_pet=?, idade_pet=?, raca=?, descricao=? WHERE id=?";
		
		try {
			PreparedStatement ps = cnx.prepareStatement(sql);
			
			
			ps.setString(1, paciente.getNome());
			ps.setString(2,  paciente.getCpf());
			ps.setString(3, paciente.getEndereco());
			ps.setString(4, paciente.getCel());
			ps.setString(5, paciente.getNomePet());
			ps.setInt(6, paciente.getIdadePet());
			ps.setString(7, paciente.getRaca());
			ps.setString(8, paciente.getDescricao());
			ps.setInt(9, paciente.getId());
			
			retornoQuery = ps.executeUpdate();
			
			if(retornoQuery <= 0) {
				resultado = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
		
	}
	public Paciente buscarPorId(int id) {
		Paciente paciente = null;
		ResultSet rs = null;
		
		cnx = DAO.createConnection();
		
		String sql = "SELECT * FROM tb_paciente WHERE id=?";
		
		try {
			PreparedStatement ps = cnx.prepareStatement(sql);
			
			ps.setInt(1,id);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				paciente = new Paciente();
				
				paciente.setId(rs.getInt("id"));
				paciente.setNome(rs.getString("nome"));
				paciente.setCpf(rs.getString("cpf"));
				paciente.setEndereco(rs.getString("endereco"));
				paciente.setCel(rs.getString("cel"));
				paciente.setNomePet(rs.getString("nome_pet"));
				paciente.setIdadePet(rs.getInt("idade_pet")); 
				paciente.setRaca(rs.getString("raca"));
				paciente.setDescricao(rs.getString("descricao"));
				
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return paciente;
	}
}
