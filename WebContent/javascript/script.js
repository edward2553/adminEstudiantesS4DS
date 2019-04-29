/**
 * 
 * El nombre de la nota no puede ser null DONE El nombre de la nota no puede ser
 * un campo en blanco DONE
 */
function myFunction(id) {
	var input = document.getElementById(id);
	input.addEventListener("keypress", function(event) {
		var key = event.keyCode;
		if (key === 32) {
			event.preventDefault();
		}
	});
}

function campoNombre(id_nombre,id_boton){
	var nombre = document.getElementById(id_nombre);
	var boton = document.getElementById(id_boton);
	var errorEnNombre = document.getElementById("errorEnNombreCrear");
	if (!isNaN(nombre.value)){
		boton.disabled = true;
		errorEnNombre.innerHTML = "Ingrese un nombre valido";
	}else if(isNaN(nombre.value)){
		boton.disabled = false;
		errorEnNombre.innerHTML = "";
	}else if (nombre.value === " " || nombre.value === "  " || nombre.value === "   "
		|| nombre.value === "    " || nombre.value === "     "
		|| nombre.value === "      " || nombre.value === "      "
		|| nombre.value === "        " || nombre.value === "         "
		|| nombre.value === "          " || nombre.value === "           "
		|| nombre.value === "            "
		|| nombre.value === "             "
		|| nombre.value === "              "
		|| nombre.value === "              "
		|| nombre.value === "                "
		|| nombre.value === "                 "
		|| nombre.value === "                  "
		|| nombre.value === "                    ") {
	
		boton.disabled = true;
	errorEnNombre.innerHTML = "Ingrese un nombre valido";
}else{
	boton.disabled = false;
	errorEnNombre.innerHTML = "";
}
}

function campoApellido(id_nombre,id_boton){
	var nombre = document.getElementById(id_nombre);
	var boton = document.getElementById(id_boton);
	var errorEnNombre = document.getElementById("errorEnNombreCrear");
	if (!isNaN(nombre.value)){
		boton.disabled = true;
		errorEnNombre.innerHTML = "Ingrese un apellido valido";
	}else if(isNaN(nombre.value)){
		boton.disabled = false;
		errorEnNombre.innerHTML = "";
	}else if (nombre.value === " " || nombre.value === "  " || nombre.value === "   "
		|| nombre.value === "    " || nombre.value === "     "
		|| nombre.value === "      " || nombre.value === "      "
		|| nombre.value === "        " || nombre.value === "         "
		|| nombre.value === "          " || nombre.value === "           "
		|| nombre.value === "            "
		|| nombre.value === "             "
		|| nombre.value === "              "
		|| nombre.value === "              "
		|| nombre.value === "                "
		|| nombre.value === "                 "
		|| nombre.value === "                  "
		|| nombre.value === "                    ") {
	
		boton.disabled = true;
	errorEnNombre.innerHTML = "Ingrese un apellido valido";
}else{
	boton.disabled = false;
	errorEnNombre.innerHTML = "";
}
}

function gradoCampo(id_grado,botonGrado){
	var grado = document.getElementById(id_grado);
	var boton = document.getElementById(botonGrado);
	var errorEnNombre = document.getElementById("errorEnNombreCrear");
	var numb = parseInt(grado.value);
	if(isNaN(numb)){
		boton.disabled = true;
		errorEnNombre.innerHTML = "Ingrese un grado valido";
	}else if(numb<=0 || numb>=12 ){
		boton.disabled = true;
		errorEnNombre.innerHTML = "Ingrese un grado valido";
	}else{
		boton.disabled = false;
		errorEnNombre.innerHTML = "";
	}
	
	
}



