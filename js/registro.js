function mostrarOcultarCampos() {
    var tipoDireccion = document.getElementById("address-type").value;
    var camposPisoPortal = document.getElementById("portal-piso-letra");
    var campoNumeroCasa = document.getElementById("number");

    if (tipoDireccion === "piso") {
        camposPisoPortal.style.display = "block";
        campoNumeroCasa.style.display = "none"; // Oculta el campo de número de casa
    } else {
        camposPisoPortal.style.display = "none";
        campoNumeroCasa.style.display = "block"; // Muestra el campo de número de casa
    }
}

window.onload = function() {
    mostrarOcultarCampos(); // Asegura que los campos se muestren u oculten correctamente al cargar la página
};