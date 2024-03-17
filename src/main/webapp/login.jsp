<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>

<style type="text/css">
.container__main {
	width: 40vw;
}
</style>
</head>
<body>
	<main
		class="p-4 d-flex flex-cloumn align-items-center justify-content-center mt-5">
		<div class="container__main">
			<div class="card-body">
				<form action="/reserva-aulas/login" method="post" class="pb-4">
					<h3 class="text-center">Inciar Sesion</h3>
					<label for="username">Usuario:</label> <input type="text"
						class="form-control" id="username" name="username"
						placeholder="usuario"> <br> <br> <label
						for="password">Password:</label> <input type="password"
						class="form-control" id="password" name="password">
					 <input type="hidden"   name="action" value="login">

					<div class="p-4 d-flex flex-rol justify-content-end">
						<input type="submit" value="Login" class="btn btn-primary">
					</div>
				</form>
			</div>
		</div>
	</main>

</body>
</html>