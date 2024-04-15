// Manejo de eventos para mostrar/ocultar el formulario de nueva votación
document.getElementById('formNuevaVotacion').addEventListener('click', function() {
    document.getElementById('addTopicForm').style.display = 'block';
});

// Función para crear una nueva votación
function crearVotacion() {
    // Obtener los valores del formulario
    var pregunta = document.getElementById('pregunta').value;
    var opciones = document.getElementById('opciones').value.split(',');

    // Crear el objeto de la votación
    var votacion = {
        pregunta: pregunta,
        opciones: opciones
    };

    // Aquí podrías enviar los datos al servidor utilizando AJAX o fetch

    // Por ahora, simplemente mostramos los datos en la consola
    console.log('Nueva votación:', votacion);

    // Restablecer el formulario y ocultarlo
    document.getElementById('addTopicForm').style.display = 'none';
    document.getElementById('pregunta').value = '';
    document.getElementById('opciones').value = '';

    // Llamar a la función para cargar las votaciones nuevamente
    cargarVotaciones();
}

// Función para cargar las votaciones existentes
function cargarVotaciones() {
    fetch('/votaciones')
    .then(response => response.json())
    .then(data => {
        // Limpiar la lista de votaciones
        const listaVotaciones = document.getElementById('listaVotaciones');
        listaVotaciones.innerHTML = '';

        // Agregar las votaciones existentes a la lista
        data.forEach(votacion => {
            const votacionElement = document.createElement('div');
            votacionElement.innerHTML = `
                <h3>${votacion.pregunta}</h3>
                <ul>
                    ${votacion.opciones.map(opcion => `<li>${opcion.texto} (${opcion.votos} votos)</li>`).join('')}
                </ul>
                <button onclick="votar('${votacion._id}')">Votar</button>
            `;
            listaVotaciones.appendChild(votacionElement);
        });
    });
}

// Cargar las votaciones al cargar la página
window.addEventListener('load', cargarVotaciones);
