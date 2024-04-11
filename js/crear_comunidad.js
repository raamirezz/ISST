$(document).ready(function() {
    // Maneja el clic en los botones de instalación
    $('.instalacion-btn').click(function(event) {
        // Evita que se cargue la página al hacer clic en el enlace
        event.preventDefault();

        // Encuentra el mensaje de confirmación asociado a esta instalación
        var mensajeConfirmacion = $(this).find('.mensaje-confirmacion');
        
        // Comprueba si el mensaje de confirmación está visible
        if (mensajeConfirmacion.is(':visible')) {
            // Oculta el mensaje de confirmación si ya está visible
            mensajeConfirmacion.hide();
        } else {
            // Muestra el mensaje de confirmación si no está visible
            mensajeConfirmacion.show();
        }
    });
});




$(document).ready(function() {
    // Maneja el clic en el campo de código de la comunidad
    $('#codigo').click(function() {
        // Genera un código aleatorio de 9 dígitos
        var codigoAleatorio = Math.floor(100000000 + Math.random() * 900000000);
        
        // Asigna el código aleatorio al campo de código de la comunidad
        $(this).val(codigoAleatorio);
    });
});




