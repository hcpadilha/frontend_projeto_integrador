<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="modelo.Paciente"%>

<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="ISO-8859-1">
<title>Lista de Paciente</title>
<script>
function confirmarExclusao(id){
	var resposta = confirm("Confirma a exclusão do registro?");
	
	if(resposta == true){
		window.location.href = "ExcluirPacienteServlet?id=" + id;
	}
}

</script>

<style type="text/css">
body {
	background: rgb(13, 134, 247);
	justfy-content: center;
}

div {
	
}

table {
	border: 1px;
}
</style>
</head>
<body>

	<div>
		<img src="img/user4.png" class="bg">
	</div>

	<h1 style="text-decoration: #fff">Controle de Pacientes</h1>
	<div>
		<table border=1>
			<tr>
				<th>ID</th>
				<th>NOME TUTOR</th>
				<th>CPF</th>
				<th>ENDEREÇO</th>
				<th>CELULAR</th>
				<th>NOME PET</th>
				<th>IDADE PET</th>
				<th>RAÇA</th>
				<th>DESCRIÇÃO</th>
				<th>EDITAR</th>
				<th>EXCLUIR</th>
				<th colspan=2></th>

			</tr>
			<%
			List<Paciente> resultado = new ArrayList<Paciente>();
			resultado = (ArrayList<Paciente>) session.getAttribute("tabela");

			for (Paciente paciente : resultado) {
				if (paciente.getId() != 1) {
			%>


			<tr>
				<td>
					<%
					out.print(paciente.getId());
					%>
				</td>
				<td>
					<%
					out.print(paciente.getNome());
					%>
				</td>
				<td>
					<%
					out.print(paciente.getCpf());
					%>
				</td>
				<td>
					<%
					out.print(paciente.getEndereco());
					%>
				</td>
				<td>
					<%
					out.print(paciente.getCel());
					%>
				</td>
				<td>
					<%
					out.print(paciente.getNomePet());
					%>
				</td>
				<td>
					<%
					out.print(paciente.getIdadePet());
					%>
				</td>
				<td>
					<%
					out.print(paciente.getRaca());
					%>
				</td>
				<td>
					<%
					out.print(paciente.getDescricao());
					%><br>
				</td>
				<td><a href="PrepararAlterarPaciente?id=<%=paciente.getId()%>"><img
						src="img/edit.png" width="24px" /></a></td>
				<td><img src="img/delete.png" width="24px"
					onclick="confirmarExclusao(<%=paciente.getId()%>)" /></td>
			</tr>


			<%
			}
			}
			%>
		</table>
	</div>
<a href="cadastro.jsp"><button type="submit" class="btn btn-primary btn-block mt-2">Adicionar Pacientes</button></a>

</body>
</html>