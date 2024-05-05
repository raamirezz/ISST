document.addEventListener('DOMContentLoaded', function() {
    // Asociar evento al botón de registro
    var registerButton = document.getElementById('register-button');
    if (registerButton) {
        registerButton.addEventListener('click', registrar);
    } else {
        console.error('El botón de registro no se encontró en el DOM');
    }
});

function registrar() {
    // Obtener los valores de los campos del formulario
    var usuario = document.getElementById('usuario').value;
    var contraseña = document.getElementById('contraseña').value;
    var confirmarContraseña = document.getElementById('confirmar-contraseña').value;
    var name = document.getElementById('name').value;
    var lastName = document.getElementById('last-name').value;
    var email = document.getElementById('email').value;
    var communityCode = document.getElementById('community-code').value;

    // Validaciones
    if (!validarFormulario(usuario, contraseña, confirmarContraseña, name, lastName, email, communityCode)) {
        return; // Detener la ejecución si hay un error de validación
    }

    // Crear un objeto con los datos del formulario
    var data = {
        usuario: usuario,
        contraseña: contraseña,
        nombre: name,
        apellidos: lastName,
        email: email,
        authority: "ROLE_VECINOS",
        communityCode: communityCode,
        enabled: 1
    };

    // Realizar la solicitud POST a la API
    fetch('https://localhost:8443/api/registro/registro', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => {
        if (response.ok) {
            console.log("Datos guardados con éxito.");
            window.location.href = '/registro_exitoso';
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

function validarFormulario(usuario, contraseña, confirmarContraseña, name, lastName, email, communityCode) {
    // Aquí puedes expandir las validaciones como se hizo en la función original
    if (!usuario || !contraseña || !confirmarContraseña || !name || !lastName || !email || !communityCode) {
        alert('Todos los campos son obligatorios.');
        return false;
    }
    if (contraseña !== confirmarContraseña) {
        alert('Las contraseñas no coinciden.');
        return false;
    }
    if (!validarContraseña(contraseña)) {
        alert('La contraseña no cumple con los requisitos mínimos.');
        return false;
    }
    if (!validarEmail(email)) {
        alert('El formato del correo electrónico no es válido.');
        return false;
    }
    if (!/^\d+$/.test(communityCode)) {
        alert('El código de comunidad debe contener solo números.');
        return false;
    }
    return true;
}
