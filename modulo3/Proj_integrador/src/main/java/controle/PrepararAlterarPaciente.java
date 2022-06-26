package controle;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Paciente;
import servico.PacienteServico;


@WebServlet("/PrepararAlterarPaciente")
public class PrepararAlterarPaciente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PrepararAlterarPaciente() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		PacienteServico servico = new PacienteServico();
		Paciente paciente = new Paciente();
		
		String idRequisicao = request.getParameter("id");
		
		paciente = servico.buscarPorId(Integer.parseInt(idRequisicao));
		
		if(!Objects.isNull(paciente)) {
			session.setAttribute("pacienteSelecionado", paciente);
			response.sendRedirect("alterar.jsp");
		} else {
			response.sendRedirect("erro.jsp");
		}
		
	}

}
