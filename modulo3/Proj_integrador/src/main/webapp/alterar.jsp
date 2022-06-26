<%@page import="modelo.Paciente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EditarPaciente VetDuBom</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/app.css">
<link rel="icon" href="img/user4.png">
</head>
<body>
	<%
	Paciente pac = (Paciente)session.getAttribute("pacienteSelecionado");
	%>
	<div class="container-fluid">
		<div class="row justify-content-center mt-5">
			<section class="col-12 colsm-6 col-md-5">
				<img src="img/user4.png" class="bg">
				<form class="form-container" action="AlterarPacienteServlet">
					<h4 class="text-center mt-4">Editar Paciente</h4>
					
						<input type="hidden" name="id" id="id" required value="<%=pac.getId()%>" >
						
						<input type="text" class="form-control" name="nome"
							placeholder="Nome Completo" required value="<%=pac.getNome() %>"/>
						
				
						<input type="text" class="form-control" name="cpf"
							placeholder="CPF" required value="<%=pac.getCpf() %>">
					

					
						<input type="text" class="form-control" name="endereco"
							placeholder="Endere�o" value="<%=pac.getEndereco() %>">
				

				
						<input type="tel" class="form-control" name="cel"
							placeholder="(00)00000-0000" value="<%=pac.getCel() %>">
			

				
						<input type="text" class="form-control" name="nome_pet"
							placeholder="Nome do Pet" value="<%=pac.getNomePet() %>">
					

			
						<input type="text" class="form-control" name="idade_pet"
							placeholder="Idade do Pet" value="<%=pac.getIdadePet() %>">
					

					
						<input type="text" class="form-control" name="raca"
							placeholder="Ra�a do Pet" value="<%=pac.getRaca() %>">
					


					
						<input type="text" class="form-control" name="descricao"
							placeholder="Descri��o do caso" value="<%=pac.getDescricao() %>">
				


					<a href="cadastro.jsp"><button type="submit" class="btn btn-primary btn-block mt-2">Alterar</button></a>

				
					
				</form>
				
			</section>
		</div>
	</div>





	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>

</body>
</html>