// Lista de las imágenes de las urbanizaciones
var imagenesUrbanizaciones = [
    "../static/Content/Urbanización1.jpeg",
    "../static/Content/Urbanización2.jpeg",
    "../static/Content/Urbanización3.jpg",
    "../static/Content/Urbanización4.jpg"
];

// Función para cambiar la imagen cada 5 segundos
var indexImagen = 0; // Índice de la imagen actual
function cambiarImagen() {
    document.getElementById("urbanizacion").src = imagenesUrbanizaciones[indexImagen];
    indexImagen = (indexImagen + 1) % imagenesUrbanizaciones.length; // Avanzar al siguiente índice
}

// Esperar a que el DOM esté completamente cargado antes de ejecutar la función cambiarImagen
document.addEventListener("DOMContentLoaded", function() {
    // Cambiar la imagen inicial
    cambiarImagen();

    // Cambiar la imagen cada 5 segundos
    setInterval(cambiarImagen, 5000); // 5000 milisegundos = 5 segundos
});
