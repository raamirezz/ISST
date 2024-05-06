// Lista de las imágenes de las urbanizaciones
var imagenesUrbanizaciones = [
    "../Content/Urbanización1.jpeg",
    "../Content/Urbanización2.jpeg",
    "../Content/Urbanización3.jpg",
    "../Content/Urbanización4.jpg"
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

// Lista de imágenes de urbanizaciones
const urbanizaciones = [
    "../Content/Urbanización1.jpeg",
    "../Content/Urbanización2.jpeg",
    "../Content/Urbanización3.jpg",
    "../Content/Urbanización4.jpg"
];

// Función para seleccionar una imagen aleatoria
function seleccionarImagenAleatoria() {
    const indiceAleatorio = Math.floor(Math.random() * urbanizaciones.length);
    return urbanizaciones[indiceAleatorio];
}

// Función para cargar una imagen aleatoria al cargar la página
window.onload = function() {
    const imagenAleatoria = seleccionarImagenAleatoria();
    const urbanizacionImg = document.getElementById("urbanizacionImg");
    urbanizacionImg.src = imagenAleatoria;
    urbanizacionImg.style.display = "block"; // Muestra la imagen
};

