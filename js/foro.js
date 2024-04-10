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
  fetch('http://localhost:8080/api/tema/temas') // Asegúrate de que la URL coincida con tu endpoint
    .then(response => response.json())
    .then(temas => {
      temas.sort((a, b) => new Date(b.fechaCreacion) - new Date(a.fechaCreacion));
      
      const innerLeftDiv = document.querySelector('.inner-left');
      temas.forEach(tema => {
        const temaElement = document.createElement('div');
        temaElement.className = 'box_foro';
        const haceTiempo = calcularHaceTiempo(tema.fechaCreacion);
        let importantImg = tema.isImportant ? '<img src="../Content/importante.png" alt="Importante" style="width: 30px; height: 30px" />' : '';
        temaElement.innerHTML = `
          <div class="img">
            <img src="../Content/302688.jpg" alt="" />
          </div>
          <div class="details">
          <h3><a href="temaForo.html?id=${tema.id}">${tema.titulo}</a></h3>
            <div class="sub-details">
            <span>${haceTiempo}</span>
            </div>
          </div>
          <div class="img_important">
          ${importantImg}
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

  // Crear el objeto de datos
  const data = {
    titulo: title, // Asegúrate de que estos nombres de propiedades coincidan con los de tu TemaDTO
    descripcion: description,
  };

  // Realizar la solicitud POST a la API de Spring Boot para temas
  fetch('http://localhost:8080/api/tema/crear', {
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



function verDetalle(title) {
  window.location.href = 'temaForo.html';
}
