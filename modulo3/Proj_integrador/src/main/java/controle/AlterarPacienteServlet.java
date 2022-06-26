package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Paciente;
import servico.PacienteServico;


@WebServlet("/AlterarPacienteServlet")
public class AlterarPacienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AlterarPacienteServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Paciente pac = new Paciente();
		PacienteServico servico = new PacienteServico();
		
		pac.setId(Integer.parseInt(request.getParameter("id")));
		pac.setNome(request.getParameter("nome"));
		pac.setCpf(request.getParameter("cpf"));
		pac.setEndereco(request.getParameter("endereco"));
		pac.setCel(request.getParameter("cel"));
		pac.setNomePet(request.getParameter("nome_pet"));
		pac.setIdadePet(Integer.parseInt(request.getParameter("idade_pet")));
		pac.setRaca(request.getParameter("raca"));
		pac.setDescricao(request.getParameter("descricao"));
		
		if(servico.alterar(pac)) {
			response.sendRedirect("tabela.jsp");
		}
	}

}
