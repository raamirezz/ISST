function enviarMensaje() {
    // Obtener los valores de los campos del formulario
    var nombre = document.getElementById('nombre').value;
    var email = document.getElementById('email').value;
    var asunto = document.getElementById('asunto').value;
    var mensaje = document.getElementById('mensaje').value;

    // Validar que todos los campos estén completos
    var formularioValido = true;
    var camposRequeridos = document.querySelectorAll('#contact-form [required]');
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

    // Crear un objeto con los datos del formulario
    var data = {
        "nombre": nombre,
        "email": email,
        "asunto": asunto,
        "mensaje": mensaje
    };

    // Realizar la solicitud POST a la API de Spring Boot
    fetch('https://localhost:8443/api/contacto/contacto', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => {
        if (response.ok) {
            console.log("Mensaje enviado con éxito.");
            // alert("¡Mensaje enviado con éxito!");
            // Redirigir al usuario a contacto_exitoso.html después de enviar el mensaje exitosamente
            window.location.href = '/contacto_exitoso';
        } else {
            console.error("Error al enviar el mensaje.");
            alert("Error al enviar el mensaje. Por favor, inténtalo de nuevo.");
        }
    })
    .catch(error => {
        console.error("Error al realizar la solicitud:", error);
        alert("Error al enviar el mensaje. Por favor, inténtalo de nuevo.");
    });
}

function validarEmail(email) {
    // Utilizamos una expresión regular para validar el formato del correo electrónico
    var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
}
