function calcularHaceTiempo(fecha) {
  const fechaCreacion = new Date(fecha);
  const ahora = new Date();
  const diferencia = ahora - fechaCreacion; // Diferencia en milisegundos

  const minutos = Math.floor(diferencia / 60000);
  const horas = Math.floor(minutos / 60);
  const dias = Math.floor(horas / 24);

  if (dias > 0) return `Hace ${dias} día(s)`;
  if (horas > 0) return `Hace ${horas} hora(s)`;
  return `hace ${minutos} minuto(s)`;
}

document.addEventListener('DOMContentLoaded', function() {
  const urlParams = new URLSearchParams(window.location.search);
  const temaId = urlParams.get('id');
  

  // Cargar los detalles del tema
  fetch(`https://localhost:8443/api/tema/${temaId}`)
    .then(response => response.json())
    .then(tema => {
      const haceTiempo = calcularHaceTiempo(tema.fechaCreacion);
      document.getElementById('temaForo').innerHTML = `
        <h2 id="tituloTema">${tema.titulo}</h2>
        <div id="usuarioFecha">${tema.nombreUsuario}</div>
        <div id="usuarioFecha">${haceTiempo}</div>

        <p id="descripcionTema">${tema.descripcion}</p>
      `;
      // Llamar a cargarComentarios después de cargar el tema
      cargarComentarios(temaId);
    })
    .catch(error => console.error('Error al cargar el tema:', error));

  // Enviar un nuevo comentario
  document.getElementById('formularioComentario').addEventListener('submit', function(e) {
      e.preventDefault(); 
      const textoComentario = document.getElementById('textoComentario').value;

      if (textoComentario) {
          const comentarioData = {
              descripcion: textoComentario,
              temaId: temaId, // Asegúrate de enviar el ID del tema
          };

          // Enviar el comentario a la API
          fetch('https://localhost:8443/api/comentarios/crear', {
              method: 'POST',
              headers: {
                  'Content-Type': 'application/json'
              },
              body: JSON.stringify(comentarioData)
          })
          .then(response => response.json())
          .then(comentario => {
              console.log('Comentario creado:', comentario);
              // Llamar a cargarComentarios para actualizar la lista de comentarios
              document.getElementById('textoComentario').value = '';
              cargarComentarios(temaId);
          })
          .catch(error => console.error('Error al crear comentario:', error));
      }
  });
});

function cargarComentarios(temaId) {
  fetch(`https://localhost:8443/api/comentarios/porTema/${temaId}`)
    .then(response => response.json())
    .then(comentarios => {
      // Ordenar comentarios por fecha de creación de forma descendente
      comentarios.sort((a, b) => new Date(b.fechaCreacion) - new Date(a.fechaCreacion));

      const comentariosDiv = document.getElementById('comentarios');
      comentariosDiv.innerHTML = ''; // Limpiar comentarios existentes
      comentarios.forEach(comentario => {
          const comentarioElement = document.createElement('div');
          const haceTiempo = calcularHaceTiempo(comentario.fechaCreacion);
          let botonEliminar = comentario.canDelete ? `<button type="button" onclick="eliminarComentario(${comentario.id})">Eliminar</button>` : '';
          comentarioElement.className = 'comentario';
          comentarioElement.innerHTML = `
            <p>${comentario.descripcion}</p>
            <small>${comentario.nombreUsuario}</small>
            <small>${haceTiempo}</small>
            ${botonEliminar}
          `;
          comentariosDiv.appendChild(comentarioElement);
      });
    })
    .catch(error => console.error('Error al cargar comentarios:', error));
}

function eliminarComentario(id) {
  if (confirm('¿Estás seguro de querer eliminar este comentario?')) {
      fetch(`https://localhost:8443/api/comentarios/eliminar/${id}`, {
          method: 'DELETE',  // Cambiado a DELETE si tu API lo soporta, sino deja POST
          headers: {
              'Content-Type': 'application/json'
          }
      })
      .then(response => {
          if (response.ok) {
              console.log("Comentario eliminado exitosamente");
              location.reload(); // Recargar la página para mostrar la lista actualizada
          } else {
              throw new Error('No se pudo eliminar el comentario');
          }
      })
      .catch(error => {
          console.error("Error al eliminar el comentario: ", error);
      });
  }

}
