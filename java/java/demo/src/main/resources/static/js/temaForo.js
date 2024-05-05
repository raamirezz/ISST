// document.addEventListener('DOMContentLoaded', function() {
//     // Extrae el ID del tema de la URL
//     const urlParams = new URLSearchParams(window.location.search);
//     const temaId = urlParams.get('id');
  
//     fetch(`http://localhost:8443/api/tema/${temaId}`) // Ajusta la URL según tu API
//       .then(response => response.json())
//       .then(tema => {
//         document.getElementById('temaForo').innerHTML = `
//           <h2 id="tituloTema">${tema.titulo}</h2>
//           <p id="descripcionTema">${tema.descripcion}</p>
//           <div id="comentarios"></div>
//         `;
//       })
//       .catch(error => console.error('Error al cargar el tema:', error));
//   });
  
document.addEventListener('DOMContentLoaded', function() {
  const urlParams = new URLSearchParams(window.location.search);
  const temaId = urlParams.get('id');

  // Cargar los detalles del tema
  fetch(`https://localhost:8443/api/tema/${temaId}`)
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
              cargarComentarios(temaId);
          })
          .catch(error => console.error('Error al crear comentario:', error));
      }
  });
});

// Función para cargar y mostrar comentarios
// function cargarComentarios(temaId) {
//   fetch(`https://localhost:8443/api/comentarios/porTema/${temaId}`)
//     .then(response => response.json())
//     .then(comentarios => {
//       const comentariosDiv = document.getElementById('comentarios');
//       comentariosDiv.innerHTML = ''; // Limpiar comentarios existentes
//       comentarios.forEach(comentario => {
//           const comentarioElement = document.createElement('div');
//           comentarioElement.className = 'comentario';
//           comentarioElement.innerHTML = `
//             <p>${comentario.descripcion}</p>
//           `;
//           comentariosDiv.appendChild(comentarioElement);
//       });
//     })
//     .catch(error => console.error('Error al cargar comentarios:', error));
// }
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
          comentarioElement.className = 'comentario';
          comentarioElement.innerHTML = `
            <p>${comentario.descripcion}</p>
            <small>${new Date(comentario.fechaCreacion).toLocaleString()}</small>
          `;
          comentariosDiv.appendChild(comentarioElement);
      });
    })
    .catch(error => console.error('Error al cargar comentarios:', error));
}
