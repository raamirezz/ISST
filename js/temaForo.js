document.addEventListener('DOMContentLoaded', function() {
    const temaTitulo = localStorage.getItem('temaTitulo'); 
    const temaDescripcion = localStorage.getItem('temaDescripcion'); 
    const usuarioNombre = localStorage.getItem('usuarioNombre');
    const usuarioFoto = localStorage.getItem('usuarioFoto');

    document.getElementById('tituloTema').textContent = temaTitulo;

    const userInfoHTML = `
    <div class="usuario-info">
        <img src="${usuarioFoto}" alt="Foto del usuario" class="usuario-foto">
        <p class="usuario-nombre">${usuarioNombre}</p>
    </div>
`;
    document.getElementById('tituloTema').insertAdjacentHTML('beforebegin', userInfoHTML);
    document.getElementById('descripcionTema').textContent = temaDescripcion;
    document.getElementById('formularioComentario').addEventListener('submit', function(e) {
        e.preventDefault(); 
        
        const textoComentario = document.getElementById('textoComentario').value;
        if (textoComentario) {
            const comentarioHTML = document.createElement('div');
        comentarioHTML.className = 'box_tema';
        comentarioHTML.innerHTML = `
            <div class="img">
                <img src="../Content/302688.jpg" alt="" />
            </div>
            <div class="details">
                <p>${textoComentario}</p>
                <div class="sub-details">
                    <span>User</span>
                    <span>respondió</span>
                    <span>justo ahora</span>
                </div>
            </div>
        `;

        document.getElementById('comentarios').appendChild(comentarioHTML);

        document.getElementById('textoComentario').value = '';
    }
});

    // Placeholder
    const comentarios = [
        "Comentario 1",
        "Comentario 2",
        "Comentario 3"
    ];



    const temaDetalleEl = document.getElementById('temaDetalle');
    temaDetalleEl.innerHTML = `
        <h2>${temaTitulo}</h2>
        <div class="usuario-info">
            <img src="${usuarioFoto}" class="usuario-foto">
            <span class="usuario-nombre">${usuarioNombre}</span>
        </div>
        <p>${temaDescripcion}</p>
    `;

    const comentariosEl = document.getElementById('comentarios');
    comentarios.forEach(comentario => {
        comentariosEl.innerHTML += `<p>${comentario}</p>`;
    });
});

