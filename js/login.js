document.querySelector('form').addEventListener('submit', function(event) {
    event.preventDefault();
    
    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;

    fetch('/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            username: username,
            password: password
        })
    })
    .then(response => {
        if (response.ok) {
            // Redirigir a la página de creación de comunidad si las credenciales son correctas
            return response.json();
        } else {
            // Manejar errores de inicio de sesión
            console.error('Error al iniciar sesión:', response.statusText);
            throw new Error('Error al iniciar sesión');
        }
    })
    .then(data => {
        if (data.username === 'admin' && data.password === 'admin') {
            // Si el usuario y la contraseña son 'admin', redirigir a la página de creación de comunidad
            window.location.href = 'admin_panel.html';
        } else {
            // Si las credenciales no son 'admin', redirigir a la página de portada
            window.location.href = 'portada.html';
        }
    })
    .catch(error => {
        console.error('Error:', error);
    });
});

