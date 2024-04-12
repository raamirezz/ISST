// Constante con los datos de los vecinos
const vecinos = [
    { nombre: "Juan", apellido: "Pérez", dni: "12345678A", correo: "juan@example.com", presidente: false },
    { nombre: "María", apellido: "García", dni: "87654321B", correo: "maria@example.com", presidente: false },
    { nombre: "Carlos", apellido: "Martínez", dni: "56789123C", correo: "carlos@example.com", presidente: false },
    { nombre: "Ana", apellido: "López", dni: "43218765D", correo: "ana@example.com", presidente: false },
    { nombre: "Pedro", apellido: "Sánchez", dni: "98765432E", correo: "pedro@example.com", presidente: false },
    { nombre: "Laura", apellido: "Rodríguez", dni: "54321678F", correo: "laura@example.com", presidente: false },
    { nombre: "David", apellido: "Fernández", dni: "34567891G", correo: "david@example.com", presidente: false },
    { nombre: "Sara", apellido: "López", dni: "98765432H", correo: "sara@example.com", presidente: false },
    { nombre: "Manuel", apellido: "Gómez", dni: "65432187I", correo: "manuel@example.com", presidente: false },
    { nombre: "Carmen", apellido: "Martín", dni: "32167854J", correo: "carmen@example.com", presidente: false },
    { nombre: "Diego", apellido: "Pérez", dni: "98765432K", correo: "diego@example.com", presidente: false },
    { nombre: "Elena", apellido: "Ruiz", dni: "87654321L", correo: "elena@example.com", presidente: false },
    { nombre: "Javier", apellido: "Hernández", dni: "76543219M", correo: "javier@example.com", presidente: false },
    { nombre: "Paula", apellido: "García", dni: "65432187N", correo: "paula@example.com", presidente: false },
    { nombre: "Miguel", apellido: "Sánchez", dni: "54321987O", correo: "miguel@example.com", presidente: false },
    { nombre: "Lucía", apellido: "Martínez", dni: "43219876P", correo: "lucia@example.com", presidente: false },
];



// Función para actualizar la vista de los vecinos
function actualizarVecinos() {
    const vecinosList = document.getElementById('vecinos-list');
    vecinosList.innerHTML = ''; // Limpiar la lista antes de agregar los vecinos actualizados

    vecinos.forEach((vecino, index) => {
        const vecinoItem = document.createElement('div');
        vecinoItem.classList.add('col-md-4', 'mb-4', 'vecino');
        if (vecino.presidente) {
            vecinoItem.classList.add('presidente');
        }
        vecinoItem.innerHTML = `
            <h3>${vecino.nombre} ${vecino.apellido}</h3>
            <p>DNI: ${vecino.dni}</p>
            <div class="categoria ${vecino.presidente ? 'presidente' : 'vecino'}">${vecino.presidente ? 'Presidente' : 'Vecino'}</div>
            <button class="presidente-btn" data-index="${index}">${vecino.presidente ? 'Quitar de Presidente' : 'Hacer Presidente'}</button>
        `;
        vecinosList.appendChild(vecinoItem);
    });

    // Añadir eventos click a los botones "Hacer Presidente"
    const presidentBtns = document.querySelectorAll('.presidente-btn');
    presidentBtns.forEach(btn => {
        btn.addEventListener('click', () => {
            const index = btn.getAttribute('data-index');
            hacerPresidente(index);
        });
    });
}

// Función para hacer presidente a un vecino
function hacerPresidente(index) {
    // Si el vecino ya es presidente, quitarle el cargo
    if (vecinos[index].presidente) {
        vecinos[index].presidente = false;
    } else {
        // Restablecer la propiedad "presidente" de todos los vecinos a false
        vecinos.forEach(vecino => vecino.presidente = false);
        // Establecer la propiedad "presidente" del vecino seleccionado a true
        vecinos[index].presidente = true;
    }
    // Actualizar la vista de los vecinos
    actualizarVecinos();
}

// Función para guardar cambios
const guardarCambios = () => {
    // Implementa la lógica para guardar los cambios aquí
    alert('Cambios guardados correctamente.');
};


// Cargar los vecinos al cargar la página
window.addEventListener('load', () => {
    actualizarVecinos();
});