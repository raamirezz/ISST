const join = document.querySelector(".join"),
  overlay = document.querySelector(".overlay"),
  closeBtn = document.querySelector(".overlay .close");


document.getElementById('addTopicBtn').addEventListener('click', function() {
  document.getElementById('addTopicForm').style.display = 'block';
});

function calcularHaceTiempo(fecha) {
  const fechaCreacion = new Date(fecha);
  const ahora = new Date();
  const diferencia = ahora - fechaCreacion; // Diferencia en milisegundos

  const minutos = Math.floor(diferencia / 60000);
  const horas = Math.floor(minutos / 60);
  const dias = Math.floor(horas / 24);

  if (dias > 0) return `Hace ${dias} día(s)`;
  if (horas > 0) return `Hace ${horas} hora(s)`;
  return `Hace ${minutos} minuto(s)`;
}

document.addEventListener('DOMContentLoaded', function() {
  fetch('https://localhost:8443/api/tema/temas')
    .then(response => response.json())
    .then(temas => {
      const innerLeftDiv = document.querySelector('.inner-left');
      temas.forEach(tema => {
        const temaElement = document.createElement('div');
        temaElement.className = 'box_foro';
        const haceTiempo = calcularHaceTiempo(tema.fechaCreacion);
        let botonEliminar = tema.canDelete ? `<button type="button" onclick="eliminarTema(${tema.id})">Eliminar</button>` : '';
        let importanteIcono = tema.isImportant ? '<img src="../Content/importante.png" alt="Importante" style="width:20px;height:20px;"/>' : '';
        let tituloClase = tema.isImportant ? 'titulo-importante' : '';temaElement.innerHTML = `
          <div class="img">
            <img src="../Content/302688.jpg" alt="" />
          </div>
          <div class="details">
          <h3 ${tituloColor}><a href="/temaForo?id=${tema.id}">${tema.titulo}</a>${importanteIcono}</h3>
            <div class="sub-details">
              <span>Creado por: ${tema.nombreUsuario}</span>
              <span>${haceTiempo}</span>
              ${botonEliminar}
            </div>
          </div>
        `;
        innerLeftDiv.appendChild(temaElement);
      });
    })
    .catch(error => console.error('Error al cargar temas:', error));
});


function submitTopic() {
  // Obtener los valores del formulario
  const title = document.getElementById('topicTitle').value;
  const description = document.getElementById('topicDetails').value;
  const isImportant = document.getElementById('importantTopicCheckbox') ? document.getElementById('importantTopicCheckbox').checked : false;

  // Crear el objeto de datos
  const data = {
    titulo: title, // Asegúrate de que estos nombres de propiedades coincidan con los de tu TemaDTO
    descripcion: description,
    isImportant: isImportant
  };

  // Realizar la solicitud POST a la API de Spring Boot para temas
  fetch('https://localhost:8443/api/tema/crear', {
      method: 'POST',
      headers: {
          'Content-Type': 'application/json'
      },
      body: JSON.stringify(data)
  })
  .then(response => {
    if (response.ok) {
        console.log("Tema creado exitosamente");
        // Recargar la página para mostrar el nuevo tema
        location.reload();
    } else {
        throw new Error('La solicitud no se completó como se esperaba.');
    }
})
.catch(error => {
    console.error("Hubo un error al crear el tema", error);
});



  // Restablecer el formulario y cerrarlo
  document.getElementById('addTopicForm').style.display = 'none';
  document.getElementById('topicTitle').value = '';
  document.getElementById('topicDetails').value = '';
}


function eliminarTema(id) {
  if (confirm('¿Estás seguro de querer eliminar este tema?')) {
      fetch(`https://localhost:8443/api/tema/eliminar/${id}`, {
          method: 'DELETE',  // Cambiado a DELETE si tu API lo soporta, sino deja POST
          headers: {
              'Content-Type': 'application/json'
          }
      })
      .then(response => {
          if (response.ok) {
              console.log("Tema eliminado exitosamente");
              location.reload(); // Recargar la página para mostrar la lista actualizada
          } else {
              throw new Error('No se pudo eliminar el tema');
          }
      })
      .catch(error => {
          console.error("Error al eliminar el tema: ", error);
      });
  }
};




function verDetalle(title) {
  window.location.href = '/temaForo';
}
