document.addEventListener("DOMContentLoaded", function() {
    // Capturar el evento de clic en el botón de "Crear Votación"
    document.getElementById('btnCrearVotacion').addEventListener('click', function() {
        // Obtener los valores del formulario
        const pregunta = document.getElementById('pregunta').value;
        const descripcion = document.getElementById('descripcion').value;

        // Llamar a la función para crear la votación
        crearVotacion(pregunta, descripcion);
    });
});

// Función para crear una nueva votación
function crearVotacion(pregunta, descripcion) {
    // Objeto con los datos de la votación
    const data = {
        id: obtenerNuevoID(), // Generar un nuevo ID para la votación
        titulo: pregunta,
        descripcion: descripcion,
        codigoComunidad: "TuCódigoDeComunidad" // Reemplaza esto con el código de tu comunidad
    };

    // Configuración del fetch
    const requestOptions = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    };
    console.log(data)
    // URL del endpoint para crear votación
    const url = '/votaciones/crear';
    //Borrar la siguiente linea si no sirve
    agregarVotacion(data);
    // Realizar la solicitud fetch
    fetch(url, requestOptions)
        .then(response => response.json())
        .then(data => {
            // Manejar la respuesta
            console.log('Votación creada exitosamente:', data);

            // Crear el elemento de la votación en el front-end
            agregarVotacion(data);
        })
        .catch(error => console.error('Error:', error));
}

// Función para obtener un nuevo ID para la votación
function obtenerNuevoID() {

    return listaVotaciones.childElementCount + 1;
}

// Función para agregar una nueva votación al front-end
function agregarVotacion(votacion) {
    var listaVotaciones = document.getElementById('listaVotaciones');

    // Crear el elemento de la votación
    var votacionElement = document.createElement('div');
    votacionElement.className = 'card mb-3';
    votacionElement.innerHTML = `
        <div class="card-body">
            <h3 class="card-title">${votacion.titulo}</h3>
            <p class="card-text">${votacion.descripcion}</p>
            <div class="d-flex justify-content-between mt-3">
            <button class="btn btn-success" onclick="votarConAlerta(true, ${votacion.id})">A Favor</button>
            <button class="btn btn-danger" onclick="votarConAlerta(false, ${votacion.id})">En Contra</button>
            </div>
        </div>
    `;

    // Agregar la votación al final de la lista de votaciones
    listaVotaciones.appendChild(votacionElement);
}
// Función para registrar el voto y mostrar una alerta
function votarConAlerta(esAFavor, idVotacion) {
    // Objeto con los datos del voto
    const data = {
        idVotacion: idVotacion,
        codigoComunidad: "TuCódigoDeComunidad", // Reemplaza esto con el código de tu comunidad
        nombreUsuario: "NombreUsuario", // Reemplaza esto con el nombre del usuario que está votando
        voto: esAFavor // true si es a favor, false si es en contra
    };

    // Configuración del fetch para registrar el voto
    const requestOptions = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    };

    // URL del endpoint para registrar el voto
    const url = '/votaciones/votar';
    console.log(data)
    // Realizar la solicitud fetch para registrar el voto
    fetch(url, requestOptions)
        .then(response => response.json())
        .then(data => {
            // Manejar la respuesta
            console.log('Voto registrado exitosamente:', data);
            // Mostrar una alerta indicando que el voto se ha registrado
            alert('Voto registrado exitosamente');
        })
        .catch(error => {
            console.error('Error:', error);
            // Mostrar una alerta en caso de error
            alert('Error al registrar el voto');
        });
}