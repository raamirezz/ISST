document.addEventListener('DOMContentLoaded', function() {
    const temaTitulo = localStorage.getItem('temaTitulo'); 
    const temaDescripcion = localStorage.getItem('temaDescripcion'); 

    // Placeholder
    const comentarios = [
        "Comentario 1",
        "Comentario 2",
        "Comentario 3"
    ];

    const temaDetalleEl = document.getElementById('temaDetalle');
    temaDetalleEl.innerHTML = `
        <h2>${temaTitulo}</h2>
        <p>${temaDescripcion}</p>
    `;

    const comentariosEl = document.getElementById('comentarios');
    comentarios.forEach(comentario => {
        comentariosEl.innerHTML += `<p>${comentario}</p>`;
    });
});

