function mascaraData(campo, e) {
	var kC = (document.all) ? event.keyCode : e.keyCode;
	var data = campo.value;

	if (kC != 8 && kC != 46) {
		if (data.length == 2) {
			campo.value = data += '/';
		} else if (data.length == 5) {
			campo.value = data += '/';
		} else
			campo.value = data;
	}
}

function mascaraHora(campo, e) {
	var kC = (document.all) ? event.keyCode : e.keyCode;
	var data = campo.value;

	if (kC != 8 && kC != 46) {
		if (data.length == 2) {
			campo.value = data += ':';
		}
		else
			campo.value = data ;
	}
}

function SomenteNumero(e) {
	var tecla = (window.event) ? event.keyCode : e.which;
	if ((tecla > 47 && tecla < 58))
		return true;
	else {
		if (tecla == 8 || tecla == 0)
			return true;
		else
			return false;
	}
}
