const join = document.querySelector(".join"),
  overlay = document.querySelector(".overlay"),
  closeBtn = document.querySelector(".overlay .close");


document.getElementById('addTopicBtn').addEventListener('click', function() {
  document.getElementById('addTopicForm').style.display = 'block';
});

function submitTopic() {
  const title = document.getElementById('topicTitle').value; // Título del nuevo tema
  const user = "Usuario"; 
  const timeAgo = "Justo ahora"; // placeholder

  const topicContainer = document.createElement('div');
  topicContainer.className = 'box';

  // topicContainer.innerHTML = `
  //     <div class="img">
  //         <img src="../Content/302688.jpg" alt="" />
  //     </div>
  //     <div class="details">
  //         <h3>${title}</h3>
  //         <div class="sub-details">
  //             <span>${user}</span>
  //             <span>${timeAgo}</span>
  //             <div class="comment">
  //                 <i class="fa-solid fa-comment"></i>
  //                 <span>0</span>
  //             </div>
  //         </div>
  //     </div>
  // `;

  topicContainer.innerHTML = `
  <div class="img">
      <img src="../Content/302688.jpg" alt="" />
  </div>
  <div class="details">
      <h3><a href="javascript:void(0);" onclick="verDetalle('${title}')">${title}</a></h3>
      <div class="sub-details">
      <span>${user}</span>
                   <span>${timeAgo}</span>
                   <div class="comment">
                       <i class="fa-solid fa-comment"></i>
                       <span>0</span>
                   </div>
      </div>
  </div>
`;

  document.querySelector('.inner-left').appendChild(topicContainer);

  document.getElementById('addTopicForm').style.display = 'none';
  document.getElementById('topicTitle').value = '';
  document.getElementById('topicDetails').value = '';
}

function verDetalle(title) {
  // Almaceno el título en localStorage
  localStorage.setItem('temaActual', title);
  // Redireccion
  window.location.href = 'temaForo.html';
}
