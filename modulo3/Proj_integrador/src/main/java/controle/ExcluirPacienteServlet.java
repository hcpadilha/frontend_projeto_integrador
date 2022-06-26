package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servico.PacienteServico;


@WebServlet("/ExcluirPacienteServlet")
public class ExcluirPacienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ExcluirPacienteServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		PacienteServico servico = new PacienteServico();
		
		if(servico.excluir(id)) {
			response.sendRedirect("cadastro.jsp");
		}
		
	}

}
