function validarContraseña(contraseña) {
    // Verificar longitud
    if (contraseña.length < 6 || contraseña.length > 14) {
        return false;
    }

    // Verificar al menos una mayúscula, una minúscula y un número
    var tieneMayuscula = false;
    var tieneMinuscula = false;
    var tieneNumero = false;

    for (var i = 0; i < contraseña.length; i++) {
        var char = contraseña.charAt(i);
        if (char >= 'A' && char <= 'Z') {
            tieneMayuscula = true;
        } else if (char >= 'a' && char <= 'z') {
            tieneMinuscula = true;
        } else if (char >= '0' && char <= '9') {
            tieneNumero = true;
        }
    }

    return tieneMayuscula && tieneMinuscula && tieneNumero;
}

function validarEmail(email) {
    // Utilizamos una expresión regular para validar el formato del correo electrónico
    var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
}

function registrar() {
    // Obtener los valores de los campos del formulario
    var usuario = document.getElementById('usuario').value;
    var contraseña = document.getElementById('contraseña').value;
    var confirmarContraseña = document.getElementById('confirmar-contraseña').value;
    var name = document.getElementById('name').value;
    var lastName = document.getElementById('last-name').value;
    var email = document.getElementById('email').value;
    var communityCode = document.getElementById('community-code').value;

    // Validar que todos los campos estén completos
    var formularioValido = true;
    var camposRequeridos = document.querySelectorAll('#registration-form [required]');
    camposRequeridos.forEach(function(campo) {
        if (!campo.value.trim()) {
            campo.classList.add('is-invalid'); // Agregar clase para indicar campo inválido
            formularioValido = false;
        } else {
            campo.classList.remove('is-invalid'); // Eliminar clase si el valor es válido
        }
    });

    if (!formularioValido) {
        alert('Todos los campos son obligatorios.');
        return;
    }

    // Validar que las contraseñas coincidan
    if (contraseña !== confirmarContraseña) {
        var confirmarContraseñaHelp = document.getElementById('confirmar-contraseña-help');
        confirmarContraseñaHelp.textContent = "Las contraseñas no coinciden.";
        confirmarContraseñaHelp.style.color = "red"; // Cambiar color del texto a rojo
        return;
    }

    // Limpiar mensaje de ayuda de confirmar contraseña en caso de que coincidan
    var confirmarContraseñaHelp = document.getElementById('confirmar-contraseña-help');
    confirmarContraseñaHelp.textContent = "";

    // Validar la complejidad de la contraseña
    if (!validarContraseña(contraseña)) {
        var contraseñaHelp = document.getElementById('contraseña-help');
        contraseñaHelp.textContent = "La contraseña debe tener entre 6 y 14 caracteres y contener al menos una mayúscula, una minúscula y un número.";
        contraseñaHelp.style.color = "red"; // Cambiar color del texto a rojo
        return;
    }

    // Limpiar mensaje de ayuda de la contraseña en caso de que sea válida
    var contraseñaHelp = document.getElementById('contraseña-help');
    contraseñaHelp.textContent = "";

    // Validar el formato del correo electrónico
    if (!validarEmail(email)) {
        var emailHelp = document.getElementById('email-help');
        emailHelp.textContent = "El formato del correo electrónico no es válido.";
        emailHelp.style.color = "red"; // Cambiar color del texto a rojo
        return;
    }

    // Limpiar mensaje de ayuda del correo electrónico en caso de que sea válido
    var emailHelp = document.getElementById('email-help');
    emailHelp.textContent = "";

    // Validar que communityCode solo contenga números
    var communityCodeInput = document.getElementById('community-code');
    var communityCodeHelp = document.getElementById('community-code-help');
    if (!/^\d+$/.test(communityCode)) {
        communityCodeInput.classList.add('is-invalid'); // Agregar clase para indicar campo inválido
        communityCodeHelp.textContent = "Solo se permiten números.";
        communityCodeHelp.style.color = "red"; // Cambiar color del texto a rojo
        return;
    } else {
        communityCodeInput.classList.remove('is-invalid'); // Eliminar clase si el valor es válido
        communityCodeHelp.textContent = "";
    }

    // Crear un objeto con los datos del formulario
    var data = {
        "usuario": usuario,
        "contraseña": contraseña,
        "nombre": name,
        "apellidos": lastName,
        "email": email,
        "communityCode": communityCode,
    };

    // Realizar la solicitud POST a la API
    fetch('http://localhost:8080/api/registro/registro', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => {
        if (response.ok) {
            console.log("Datos guardados con éxito.");
            // alert("¡Registro exitoso!");
            // Redirigir al usuario a registro_exitoso.html después de un registro exitoso
            window.location.href = 'registro_exitoso.html';
        } else {
            console.error("Error al guardar los datos.");
            alert("Error al registrar. Por favor, inténtalo de nuevo.");
        }
    })
    .catch(error => {
        console.error("Error al realizar la solicitud:", error);
        alert("Error al registrar. Por favor, inténtalo de nuevo.");
    });
}
