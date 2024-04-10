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

function cargarComentarios(temaId) {
  fetch(`http://localhost:8080/api/comentarios/porTema/${temaId}`) // Asegúrate de que esta URL coincide con el endpoint del backend
    .then(response => response.json())
    .then(comentarios => {
      comentarios.sort((a, b) => new Date(b.fechaCreacion) - new Date(a.fechaCreacion));
      const comentariosDiv = document.getElementById('comentarios');
      comentariosDiv.innerHTML = ''; // Limpiar comentarios existentes
      comentarios.forEach(comentario => {
          const comentarioElement = document.createElement('div');
          comentarioElement.className = 'class_comentarios';
        const haceTiempo = calcularHaceTiempo(comentario.fechaCreacion);
          comentarioElement.innerHTML = `
          <div class="img_comment">
              <img src="../Content/302688.jpg" alt="" />
         </div>
          <div class="details_comment">
          <h4>${comentario.descripcion}</h4>
          <div class="sub-details_comment">
          <span>${haceTiempo}</span>
          </div>
        </div>
            `;
          comentariosDiv.appendChild(comentarioElement);
      });
    })
    .catch(error => console.error('Error al cargar comentarios:', error));
}


document.addEventListener('DOMContentLoaded', function() {
  const urlParams = new URLSearchParams(window.location.search);
  const temaId = urlParams.get('id');

  // Cargar los detalles del tema
  fetch(`http://localhost:8080/api/tema/${temaId}`)
    .then(response => response.json())
    .then(tema => {
      document.getElementById('temaForo').innerHTML = `
        <h2 id="tituloTema">${tema.titulo}</h2>
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
        temaId: temaId, // Asegúrate de enviar el ID del tema correctamente
      };

      // Enviar el comentario a la API
      fetch('http://localhost:8080/api/comentarios/crear', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(comentarioData)
      })
      .then(response => {
        if(response.ok) {
          console.log('Comentario creado exitosamente');
          // Recargar la página para mostrar el nuevo comentario
          window.location.reload();
        } else {
          throw new Error('Error al crear comentario');
        }
      })
      .catch(error => {
        console.error('Error al crear comentario:', error);
      });
    }
  });
});


