function registrar() {
    // Obtener los valores de los campos del formulario
    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;
    var name = document.getElementById('name').value;
    var lastName = document.getElementById('last-name').value;
    var email = document.getElementById('email').value;
    var communityCode = document.getElementById('community-code').value;
    var street = document.getElementById('street').value;
    var province = document.getElementById('province').value;
    var phone = document.getElementById('phone').value;
    var dni = document.getElementById('dni').value;

    // Crear un objeto con los datos del formulario
    var data = {
        "nombre": name,
        "apellidos": lastName,
        "email": email,
        "communityCode": communityCode,
        "calle": street,
        "provincia": province,
        "telefono": phone,
        "dni": dni
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
            alert("¡Registro exitoso!");
            // Puedes redirigir al usuario a otra página o realizar alguna otra acción después de guardar los datos
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
