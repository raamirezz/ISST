document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('register-button').addEventListener('click', function() {
        if (!validarFormulario()) {
            console.log("Validación fallida.");
            return; // Detener la ejecución si hay un error de validación
        }
        registrar();
    });
});


function registrar() {
    var data = {
        usuario: document.getElementById('usuario').value,
        contraseña: document.getElementById('contraseña').value,
        nombre: document.getElementById('name').value,
        apellidos: document.getElementById('last-name').value,
        email: document.getElementById('email').value,
        authority: document.getElementById('role').value,
        communityCode: document.getElementById('community-code').value,
        enabled: 1
    };

    fetch('https://localhost:8443/api/registro/registro', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(data)
    })
    .then(response => response.ok ? window.location.href = '/registro_exitoso' : Promise.reject('Error al registrar.'))
    .catch(error => {
        console.error("Error al realizar la solicitud:", error);
        alert("Error al registrar. Por favor, inténtalo de nuevo.");
    });
}

function validarFormulario() {
    var usuario = document.getElementById('usuario').value;
    var contraseña = document.getElementById('contraseña').value;
    var confirmarContraseña = document.getElementById('confirmar-contraseña').value;
    var email = document.getElementById('email').value;
    var communityCode = document.getElementById('community-code').value;

    if (!usuario || !contraseña || !confirmarContraseña || !document.getElementById('name').value || !document.getElementById('last-name').value || !email || !communityCode) {
        alert('Todos los campos son obligatorios.');
        return false;
    }
    if (contraseña !== confirmarContraseña) {
        alert('Las contraseñas no coinciden.');
        return false;
    }
    // Suponiendo que estas funciones existen y están correctamente definidas:
    if (!validarContraseña(contraseña) || !validarEmail(email) || !/^\d+$/.test(communityCode)) {
        alert('Revisa los campos, uno o más no cumplen los requisitos.');
        return false;
    }
    return true;
}

function validarContraseña(contraseña) {
    // Un ejemplo simple de validación de contraseña
    // Revisa si la longitud de la contraseña es mayor o igual a 8 caracteres
    return contraseña.length >= 8;
}

function validarEmail(email) {
    // Un ejemplo simple de validación de email usando una expresión regular
    return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
}
