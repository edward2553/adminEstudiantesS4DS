<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="estilos/estilos.css" type="text/css"/>
<title>Bienvenidos</title>
</head>
<body>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


<div class="row text-center titulo"  >
	<div class="col-sm-12 col-md-12 col-lg-12">Administrador de estudiantes</div>
</div>
<br>
<br>

         <!-- formulario para login -->
         
<form method="post" action="login" >
<div class="row text-center"  >
	<div class="col-sm-12 col-md-6 col-lg-6 labelLogin" style="text-align: right;" >Usuario</div>
	<div class="col-sm-12 col-md-6 col-lg-6">
		<input class="form-control" type="text" style="width: 200px; height: 35px;" required="required" name="usu">
	</div>
</div>
<br>


<div class="row text-center"  >
	<div class="col-sm-12 col-md-6 col-lg-6 labelLogin" style="text-align: right;">Contraseña</div>
	<div class="col-sm-12 col-md-6 col-lg-6">
		<input class="form-control" type="password" style="width: 200px; height: 35px;" required="required" name="pass">
	</div>
</div>
<br>
<div class="row text-center"  >
	<div class="col-sm-12 col-md-12 col-lg-12">
		<input class="form-control btn btn-danger " style="width: 200px; height: 35px;" type="submit" value="Ingresar">
	</div>
</div>
</form>






<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>