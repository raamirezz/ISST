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

        // Toggle para activar la variable a true o false
        var checkbox = $(this).find('input[type="checkbox"]');
        checkbox.prop('checked', !checkbox.prop('checked'));
    });

    // Maneja el clic en el campo de código de la comunidad para generar un código aleatorio
    $('#community_code').click(function() {
        // Genera un código aleatorio de 9 dígitos
        var communityCode = Math.floor(100000000 + Math.random() * 900000000).toString();
        
        // Asigna el código aleatorio al campo de código de la comunidad
        $(this).val(communityCode);
    });

    // Selector para el botón de enviar el formulario
    $('#crear-comunidad-btn').on('click', function(e) {
        e.preventDefault(); // Evita el comportamiento predeterminado del botón

        // Obtener los valores de los campos del formulario
        var communityCode = $('#community_code').val();
        var calle = $('#calle').val();
        var provincia = $('#provincia').val();
        var hasPiscina = $('#piscina').is(':checked');
        var hasTenis = $('#tenis').is(':checked');
        var hasPadel = $('#padel').is(':checked');
        var hasGym = $('#gym').is(':checked');
        var hasLocalEventos = $('#local-eventos').is(':checked');

        // Objeto con los datos del formulario
        var formData = {
            calle: calle,
            community_code: communityCode,
            has_gym: hasGym,
            has_local_eventos: hasLocalEventos,
            has_Padel: hasPadel,
            has_Piscina: hasPiscina,
            has_Tenis: hasTenis,
            provincia: provincia,
        };
        

        // Realizar la solicitud POST a la API
        fetch('http://localhost:8080/api/comunidad/crear', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        })
        .then(response => {
            if (response.ok) {
                console.log(formData);
                // Puedes agregar aquí cualquier acción adicional que desees después de crear la comunidad
            } else {
                console.error("Error al crear la comunidad.");
                alert("Error al crear la comunidad. Por favor, inténtalo de nuevo.");
            }
        })
        .catch(error => {
            console.error("Error al realizar la solicitud:", error);
            alert("Error al crear la comunidad. Por favor, inténtalo de nuevo.");
        });
    });
});
