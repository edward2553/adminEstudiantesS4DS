<%@page import="java.sql.ResultSet"%>
<%@page import="com.s4ds.persistencia.ListStudentsDAO"%>
<%@page import="com.s4ds.entidades.Estudiante"%>
<%@page import="com.s4ds.persistencia.ListarNotas"%>
<%@page import="com.s4ds.entidades.Nota"%>
<%@page import="com.s4ds.persistencia.EstudianteDAO"%>
<%@page import="com.s4ds.utilidades.calculoNotas"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="estilos/estilos.css" type="text/css" />
<title>Administrador de estudiantes</title>
</head>
<body>
	<br>
	<br>
	<br>
	<br>

	<div class="row text-center titulo ">
		<div class="col-sm-12 col-md-12 col-lg-12">Administrador de
			estudiantes</div>
	</div>
	<br>
	<br>
	<div class="container">
		<div class="row justify-content-center">

			<div class="col-sm-12 col-md-4 col-lg-4 text-center">
				<button type="button" class="btn btn-success" data-toggle="modal"
					data-target="#Crear_EstudianteModal"
					style="width: 135px; height: 35px;">Crear</button>
			</div>
			<div class="col-sm-12 col-md-4 col-lg-4 text-center">
				<form action="logOut" method="get">
					<input type="submit" class="btn form-control btn-danger lfsdf"
						style="width: 135px; height: 35px;" value="Cerrar session">
				</form>
			</div>
			<div class="col-sm-12 col-md-4 col-lg-4 text-center">

				<form class="form">
					<div class="input-group mb-3" style="width: 361px;">
						<input type="text" id="filterInput" class="form-control"
							placeholder="buscar por nombre" name="txt_buscar"
							aria-label="Username" aria-describedby="basic-addon1"> <input
							type="submit" class="form-control" value="buscar" />

					</div>
				</form>
			</div>
		</div>
	</div>


	<%
		String nombreBuscar = request.getParameter("txt_buscar");

		//contador para los modales
		int cont = 0;
		//estudiantes
		EstudianteDAO estDAO = new EstudianteDAO();
		ListStudentsDAO obj_listarEst = new ListStudentsDAO();
		ResultSet estudiantes;
		//notas
		ListarNotas obj_listarNot = new ListarNotas();
		ResultSet notas;

		if (nombreBuscar != null) {
			estudiantes = estDAO.SearchStudentByID(nombreBuscar);
		} else {
			estudiantes = obj_listarEst.listarEstudiantes();
		}
	%>

	<!-- Tabla para ver a los estudiantes -->
	<br>
	<div class="container">
		<div class="row justify-content-center">
			<table class="table table-responsive-lg text-center table-bordered"">
				<thead class="thead-light">
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Nombre</th>
						<th scope="col">Apellido</th>
						<th scope="col">Grado</th>
						<th scope="col">Promedio</th>
						<th scope="col">Acciones</th>
					</tr>
				</thead>

				<tbody>
					<%
						int n_est = 0;
						calculoNotas obj_calNotas = new calculoNotas();
						double[][] vect_notas;
						vect_notas = obj_calNotas.obtenerNotas();
						int i = 0; //filas
						int j = 1; //columnas
						while (estudiantes.next()) {
					%>
					<tr>
						<th scope="row"><%=estudiantes.getInt(1)%></th>
						<td><%=estudiantes.getString(2)%></td>
						<td><%=estudiantes.getString(3)%></td>
						<td><%=estudiantes.getString(4)%></td>

						<td><%=vect_notas[i++][j]%></td>

						<td>
							<button type="button" class="btn btn-danger" data-toggle="modal"
								data-target="#Eliminar_EstudianteModal<%=cont%>">Eliminar
								estudiante</button>

							<button type="button" class="btn btn-primary" data-toggle="modal"
								data-target="#Acutializar_EstudianteModal<%=cont%>">Actualizar
								estudiante</button>

							<button type="button" class="btn btn-success" data-toggle="modal"
								data-target="#VerNotas_EstudianteModal<%=cont%>">ver
								notas</button>
						</td>
					</tr>
					<%
						cont++;
						}
					%>

				</tbody>
			</table>
		</div>
	</div>
	<%
		cont = 0;
		estudiantes = obj_listarEst.listarEstudiantes();
		notas = obj_listarNot.listar_notas_estudiantes();
		int idNota;
		while (estudiantes.next()) {
	%>
	<!-- Modal eliminar estudiante -->
	<div class="modal fade" id="Eliminar_EstudianteModal<%=cont%>">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">¿Esta seguro?</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<form method="get" action="DeleteStudent">

						<input type="hidden" name="id_estudiante_eliminar"
							value="<%=estudiantes.getInt(1)%>">
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
								<input type="submit" class="btn form-control btn-danger"
									value="si">
							</div>
							<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
								<button type="button" class="form-control" data-dismiss="modal">No</button>
							</div>
						</div>
					</form>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
				</div>

			</div>
		</div>
	</div>

	<!-- Modal actualizar estudiante -->
	<div class="modal fade" id="Acutializar_EstudianteModal<%=cont%>">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Actualizar estudiante</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->



				<div class="modal-body">
					<form method="post" action="UpdateStudentsData">
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
								<h6>ID</h6>
							</div>
							<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
								<input type="text" class="form-control " name="idUpdate"
									readonly="readonly" value="<%=estudiantes.getInt(1)%>">
							</div>
						</div>
						<br>


						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
								<h6>Nombre</h6>
							</div>
							<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
								<input type="text" class="form-control "
									value="<%=estudiantes.getString(2)%>" name="NameUpdate"
									required="" maxlength="20" id="actualizarNombre"
									onkeydown="campoNombre('actualizarNombre', 'actualizarForm');">
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
								<h6>Apellido</h6>
							</div>
							<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
								<input type="text" class="form-control "
									value="<%=estudiantes.getString(3)%>" name="LastNameUpdate"
									required="" maxlength="20" id="actualizarApellido"
									onkeydown="campoNombre('actualizarApellido', 'actualizarForm');">
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
								<h6>Grado</h6>
							</div>
							<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
								<input type="text" class="form-control "
									value="<%=estudiantes.getString(4)%>" name="gradeUpdate"
									required="" maxlength="2" id="gradeUpdate" onkeydown="">
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<input type="submit" class="form-control" id="actualizarForm"
									value="Actualizar">
							</div>
						</div>

					</form>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
				</div>

			</div>
		</div>
	</div>

	<!-- Modal ver notas-->
	<div class="modal fade" id="VerNotas_EstudianteModal<%=cont%>">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Notas del alumno</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body - tabla con las notas-->
				<div class="modal-body">
					<table class="table table-responsive-ls">
						<thead class="thead-light">
							<tr>
								<th scope="col">Nombre</th>
								<th scope="col">Porcentaje</th>
								<th scope="col">Valor</th>
							</tr>
						</thead>
						<tbody>
							<%
								notas.next();
									if (notas.isAfterLast() && estudiantes.getInt(5) != 0) {
										notas.previous();
							%>
							<tr>
								<td><%=notas.getString(2)%></td>
								<td><%=notas.getString(3)%></td>
								<td><%=notas.getString(4)%></td>
							</tr>
							<%
								} else if (estudiantes.getInt(5) == 0) {
							%>


							<%
								} else {
										while (notas.getInt(1) == estudiantes.getInt(1)) {
							%>
							<tr>
								<td><%=notas.getString(2)%></td>
								<td><%=notas.getString(3)%></td>
								<td><%=notas.getString(4)%></td>
							</tr>
							<%
								idNota = notas.getInt(1);
											notas.next();
											if (notas.isAfterLast() || idNota != notas.getInt(1)) {
												notas.previous();
												break;
											}

										}
									}
							%>
						</tbody>
					</table>

					<br>
					<div class="card">
						<form method="post" action="RegistrarNota">
							<input type="hidden" name="id_estudiante_registrarNota"
								value="<%=estudiantes.getInt(1)%>">
							<div class="card-body">
								<center>
									<b>Agregar nota</b>
								</center>
								<br>
								<div class="row">
									<br>
									<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
										<h6>Nombre:</h6>
										<br> <input type="text" name="nombreNota" id="nombreNota"
											class="form-control nombreNota" required="" maxlength="20" />
									</div>
									<br>
									<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
										<h6>Porcentaje:</h6>
										<br> <input type="text" name="porcentajeNota"
											id="porcentajeNota<%=cont%>" required="" class="form-control"
											maxlength="3" onkeydown="" />
									</div>
									<br>
									<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
										<h6>Valor:</h6>
										<br> <input type="text" name="valorNota" id="valorNota"
											required="" class="form-control" maxlength="3"
											onkeydown="myFunction('valorNota');" /> <br>
									</div>
									<br>
								</div>
								<p id="errorMesage_asignarNota"></p>
								<input type="submit" class="form-control" id="asignarNota"
									value="Asignar nota" />
							</div>
						</form>
					</div>
					<!-- Modal footer -->
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
					</div>
				</div>

			</div>
		</div>
	</div>

	<br>

	<%
		cont++;
		}
	%>



	<!-- modal crear estudiante -->

	<div class="modal fade" id="Crear_EstudianteModal">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Crear estudiante</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<form action="insetar_estudiante" method="get"
						id="crearEstudianteForm">
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
								<h6>Nombre</h6>
							</div>
							<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
								<input type="text" class="form-control" required=""
									name="crearEstudiante_nombre" id="crearEstudiante_nombre"
									maxlength="20"
									onkeydown="campoNombre('crearEstudiante_nombre', 'btn_crearEstudiante');">

							</div>
						</div>


						<br>
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
								<h6>Apellido</h6>
							</div>
							<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
								<input type="text" class="form-control" required=""
									name="crearEstudiante_apellido" id="crearEstudiante_apellido"
									maxlength="20"
									onkeydown="campoApellido('crearEstudiante_apellido', 'btn_crearEstudiante');">
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
								<h6>Grado</h6>
							</div>
							<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
								<input type="text" class="form-control" required=""
									name="crearEstudiante_grado" id="gradoCrearEst"
									id="crearEstudiante_grado" maxlength="2">
							</div>
						</div>
						<br>
						<div class="container">
							<div class="row">
								<p id="errorEnNombreCrear"></p>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<input type="submit" class="form-control"
									value="Crear estudiante" id="btn_crearEstudiante">
							</div>

						</div>

					</form>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
				</div>

			</div>
		</div>
	</div>

	<br>
	<script src="javascript/script.js"></script>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>

</body>
</html>