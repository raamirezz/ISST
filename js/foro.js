const join = document.querySelector(".join"),
  overlay = document.querySelector(".overlay"),
  closeBtn = document.querySelector(".overlay .close");


document.getElementById('addTopicBtn').addEventListener('click', function() {
  document.getElementById('addTopicForm').style.display = 'block';
});

// function submitTopic() {
//   const title = document.getElementById('topicTitle').value;
//   const description = document.getElementById('topicDetails').value;
//   const user = "Usuario"; 
//   const timeAgo = "Justo ahora"; // placeholder

//   const topicContainer = document.createElement('div');
//   topicContainer.className = 'box_foro';
//   topicContainer.innerHTML = `
//   <div class="img">
//       <img src="../Content/302688.jpg" alt="" />
//   </div>
//   <div class="details">
//       <h3><a href="javascript:void(0);" onclick="verDetalle('${title}')">${title}</a></h3>
//       <div class="sub-details">
//       <span>${user}</span>
//                    <span>${timeAgo}</span>
//                    <div class="comment">
//                        <i class="fa-solid fa-comment"></i>
//                        <span>0</span>
//                    </div>
//       </div>
//   </div>
// `;
//   localStorage.setItem('temaTitulo', title);
//   localStorage.setItem('temaDescripcion', description);
//   localStorage.setItem('usuarioNombre', 'Usuario 1');
// localStorage.setItem('usuarioFoto', '../Content/302688.jpg');

//   document.querySelector('.inner-left').appendChild(topicContainer);

//   document.getElementById('addTopicForm').style.display = 'none';
//   document.getElementById('topicTitle').value = '';
//   document.getElementById('topicDetails').value = '';
// }

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
  .then(response => response.json())
  .then(data => {
      console.log("Tema creado exitosamente", data);
      // Aquí podrías redirigir al usuario o mostrar algún mensaje de éxito
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
