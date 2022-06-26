package servico;

import java.util.List;

import dao.PacienteDAO;
import modelo.Paciente;

public class PacienteServico {
	PacienteDAO paciente = new PacienteDAO();

	public Paciente consultarUsuario(String login, String senha) {
		return paciente.consultarUsuario(login, senha);
	}

	public boolean cadastrar(Paciente pac) {
		return paciente.cadastrarPaciente(pac);
	}

	public List<Paciente> listar() {
	 return paciente.listar();
	}
	
	public boolean excluir(String id) {
		int idPaciente;
		
		idPaciente = Integer.parseInt(id);
		
		return paciente.excluirPaciente(idPaciente);
	}
	
	public boolean alterar(Paciente pac) {
		return paciente.alterarPaciente(pac);
	}
	public Paciente buscarPorId(int id) {
		return paciente.buscarPorId(id);
	}
}
