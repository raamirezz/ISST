document.addEventListener('DOMContentLoaded', function () {
    cargarVotaciones();
    document.getElementById('formNuevaVotacion').addEventListener('click', function () {
        document.getElementById('addTopicForm').style.display = 'block';
    });
});

function cargarVotaciones() {
    fetch('/api/votaciones/votaciones')
        .then(response => {
            if (!response.ok) throw new Error('Network response was not ok');
            return response.json();
        })
        .then(votaciones => {
            const container = document.getElementById('listaVotaciones');
            container.innerHTML = ''; // Limpiar votaciones anteriores
            votaciones.forEach(votacion => {
                container.appendChild(crearElementoVotacion(votacion));
            });
        })
        .catch(error => console.error('Error al cargar votaciones:', error));
}

function crearElementoVotacion(votacion) {
    const div = document.createElement('div');
    div.className = 'votacion';
    div.innerHTML = `
        <h3>${votacion.descripcion}</h3>
        <p>A favor: ${votacion.votosFavor}</p>
        <p>En contra: ${votacion.votosContra}</p>
    `;
    const userHasVoted = Array.isArray(votacion.votantes) && votacion.votantes.includes('nombre_usuario_logueado');
    if (!userHasVoted) {
        const btnFavor = document.createElement('button');
        btnFavor.textContent = 'Votar a favor';
        btnFavor.onclick = () => votar(votacion.id, true);
        div.appendChild(btnFavor);

        const btnContra = document.createElement('button');
        btnContra.textContent = 'Votar en contra';
        btnContra.onclick = () => votar(votacion.id, false);
        div.appendChild(btnContra);
    }

    return div;
}


function votar(id, voto) {
    fetch(`/api/votaciones/votar/${id}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ voto: voto })
    }).then(response => {
        if (response.ok) {
            cargarVotaciones(); // Recargar las votaciones para actualizar la vista
        } else {
            alert('Error al votar');
        }
    });
}

function crearVotacion() {
    const descripcion = document.getElementById('descripcionVotacion').value;
    fetch('/api/votaciones/crear', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ descripcion: descripcion })
    }).then(response => {
        if (response.ok) {
            cargarVotaciones(); // Recargar las votaciones
            document.getElementById('addTopicForm').style.display = 'none'; // Ocultar el formulario
            document.getElementById('descripcionVotacion').value = ''; // Limpiar el campo de texto
        } else {
            alert('Error al crear la votación');
        }
    });
}
