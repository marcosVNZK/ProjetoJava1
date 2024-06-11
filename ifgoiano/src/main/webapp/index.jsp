<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<div>
		<h1>Adicione sua informações:</h1>
		<form action="CadastroServlet" method="get">
			<input class="nome" type="text" name="nome" id="nome"> <br>
			
			<input type="email" name="email" id="email"> <br>
			
			<input type="password" name="senha" id="senha"> <br>
			<button type="submit">Confirmar</button>
		</form>
	</div>
</body>
</html>