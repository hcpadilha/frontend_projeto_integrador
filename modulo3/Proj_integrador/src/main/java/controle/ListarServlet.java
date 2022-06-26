package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PacienteDAO;
import modelo.Paciente;


@WebServlet("/ListarServlet")
public class ListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public ListarServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		
		PacienteDAO dao = new PacienteDAO();
		List<Paciente> tabela = new ArrayList<Paciente>();
		
		tabela = dao.listar();
		
		
		
		session.setAttribute("tabela", tabela);
		//session.setAttribute("dao", dao);
		response.sendRedirect("tabela.jsp");
	}

}
