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

    // Maneja el clic en el botón de crear comunidad
    $('#crear-comunidad-btn').click(function(event) {
        // Evita que se recargue la página al hacer clic en el botón
        event.preventDefault();

        // Muestra una alerta al hacer clic en el botón
        alert('¡Comunidad creada con éxito!');
    });

    // Maneja el clic en el campo de código de la comunidad
    $('#codigo').click(function() {
        // Genera un código aleatorio de 9 dígitos
        var codigoAleatorio = Math.floor(100000000 + Math.random() * 900000000);
        
        // Asigna el código aleatorio al campo de código de la comunidad
        $(this).val(codigoAleatorio);
    });
});

$(document).ready(function() {
    // Selector para el botón de enviar el formulario
    $('#crear-comunidad-btn').on('click', function(e) {
        e.preventDefault(); // Evita el comportamiento predeterminado del botón

        // Obtener los valores de los campos del formulario
        var codigo = $('#codigo').val();
        var calle = $('#calle').val();
        var provincia = $('#provincia').val();
        var instalaciones = []; // Array para almacenar las instalaciones seleccionadas

        // Recorrer todas las instalaciones seleccionadas
        $('.instalacion-btn').each(function() {
            if ($(this).hasClass('seleccionado')) { // Verificar si la instalación está seleccionada
                instalaciones.push($(this).data('instalacion')); // Agregar la instalación al array
            }
        });

        // Objeto con los datos del formulario
        var formData = {
            codigo: codigo,
            calle: calle,
            provincia: provincia,
            instalaciones: instalaciones
        };

        // Petición AJAX para enviar los datos del formulario al backend
        $.ajax({
            type: 'POST',
            url: '/crear_comunidad', // Ruta del controlador en el backend
            data: formData,
            dataType: 'json',
            encode: true
        })
        .done(function(data) {
            // Manejar la respuesta del servidor si la petición fue exitosa
            console.log(data); // Puedes mostrar mensajes de éxito o redireccionar a otra página
        })
        .fail(function(data) {
            // Manejar errores si la petición falla
            console.log(data.responseText); // Mostrar mensajes de error
        });
    });
});

