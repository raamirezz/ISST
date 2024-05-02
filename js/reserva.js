$(document).ready(function() {
    // Función para generar las opciones del desplegable con las horas del día
    function generarOpcionesHoras(selectId) {
        var select = $("#" + selectId);
        for (var i = 0; i < 24; i++) {
            var horaInicio = (i < 10) ? "0" + i : i;
            var horaFin = (i + 1 < 10) ? "0" + (i + 1) : i + 1;
            var horaMostrada = horaInicio + ":00 - " + horaFin + ":00";
            var option = $("<option></option>").text(horaMostrada).val(horaInicio);
            select.append(option);
        }
    }

    // Genera las opciones de hora para cada reserva
    generarOpcionesHoras("selectHora1");
    generarOpcionesHoras("selectHora2");
    generarOpcionesHoras("selectHora3");
    generarOpcionesHoras("selectHora4");
    generarOpcionesHoras("selectHora5");

    // Inicializa el Datepicker de Bootstrap cuando el DOM está listo
    $('#datepicker1, #datepicker2, #datepicker3, #datepicker4, #datepicker5').datepicker({
        format: "dd/mm/yyyy",
        autoclose: true,
        todayHighlight: true
    });

    // Agrega un listener al botón "Confirmar" de cada tarjeta
    $('.btn-confirmar').on('click', function() {
        var fechaSeleccionada = $(this).siblings('input[type="text"]').val();
        var horaSeleccionada = $(this).siblings('select').val();
        var tipoInstalacion = $(this).closest('.card').find('.card-title').text();
        var reservaData = {
            fecha: fechaSeleccionada,
            hora: horaSeleccionada,
            tipoInstalacion: tipoInstalacion,
            usuario: "nombreUsuario" // Aquí debes obtener el nombre de usuario del contexto de tu aplicación
        };

        // Enviar los datos al backend
        $.ajax({
            type: "POST",
            url: "/api/reserva/crear",
            contentType: "application/json",
            data: JSON.stringify(reservaData),
            success: function(response) {
                // Manejar la respuesta del servidor si es necesario
                alert(response);
            },
            error: function(xhr, status, error) {
                // Manejar errores de la petición AJAX
                console.error(xhr.responseText);
            }
        });
    });
    // Agrega un listener al botón "Confirmar" de cada tarjeta
    $('#btnConfirmar1').on('click', function() {
        var fechaSeleccionada = $('#datepicker1').val();
        var horaSeleccionada = $('#selectHora1').val();
        alert("Fecha seleccionada para Pista de Pádel: " + fechaSeleccionada + " a las " + horaSeleccionada);
    });

    $('#btnConfirmar2').on('click', function() {
        var fechaSeleccionada = $('#datepicker2').val();
        var horaSeleccionada = $('#selectHora2').val();
        alert("Fecha seleccionada para GYM: " + fechaSeleccionada + " a las " + horaSeleccionada);
    });

    $('#btnConfirmar3').on('click', function() {
        var fechaSeleccionada = $('#datepicker3').val();
        var horaSeleccionada = $('#selectHora3').val();
        alert("Fecha seleccionada para Piscina: " + fechaSeleccionada + " a las " + horaSeleccionada);
    });

    $('#btnConfirmar4').on('click', function() {
        var fechaSeleccionada = $('#datepicker4').val();
        var horaSeleccionada = $('#selectHora4').val();
        alert("Fecha seleccionada para Pista de Tenis: " + fechaSeleccionada + " a las " + horaSeleccionada);
    });

    $('#btnConfirmar5').on('click', function() {
        var fechaSeleccionada = $('#datepicker5').val();
        var horaSeleccionada = $('#selectHora5').val();
        alert("Fecha seleccionada para Zona de Eventos: " + fechaSeleccionada + " a las " + horaSeleccionada);
    });

    // Variable que indica si el usuario es presidente
    var isPresidente = true; // O true según corresponda

    function toggleMantenimientoButton() {
        if (!isPresidente) {
            $('[id^="mantenimientoBtnContainer"]').hide();
            $('[id^="disponibilidadBtnContainer"]').hide(); // Ocultar todos los contenedores de botones de mantenimiento
        }
    }

    $('#btnMantenimiento1').on('click', function() {
        $('#btnMantenimiento1').hide();
        $('#btnDisponible1').show();
        alert("La pista de padel esta disponible!");
    });

    $('#btnDisponible1').on('click', function() {
        $('#btnDisponible1').hide();
        $('#btnMantenimiento1').show();
        alert("La pista de padel no esta disponible!");
    });


    $('#btnMantenimiento2').on('click', function() {
        $('#btnMantenimiento2').hide();
        $('#btnDisponible2').show();
        alert("El servicio está en mantenimiento");
    });

    $('#btnDisponible2').on('click', function() {
        $('#btnDisponible2').hide();
        $('#btnMantenimiento2').show();
        alert("El gimnasio esta disponible!");
    });

    $('#btnMantenimiento3').on('click', function() {
        $('#btnMantenimiento3').hide();
        $('#btnDisponible3').show();
        alert("El gimnasio no esta disponible!");
    });

    $('#btnDisponible3').on('click', function() {
        $('#btnDisponible3').hide();
        $('#btnMantenimiento3').show();
        alert("La piscina ya esta disponible!");
    });

    $('#btnMantenimiento4').on('click', function() {
        $('#btnMantenimiento4').hide();
        $('#btnDisponible4').show();
        alert("La pista de tenis no esta disponible!");
    });

    $('#btnDisponible4').on('click', function() {
        $('#btnDisponible4').hide();
        $('#btnMantenimiento4').show();
        alert("La pista de tenis ya esta disponible!");
    });

    $('#btnMantenimiento5').on('click', function() {
        $('#btnMantenimiento5').hide();
        $('#btnDisponible5').show();
        alert("La zona de eventos no esta disponible!");
    });

    $('#btnDisponible5').on('click', function() {
        $('#btnDisponible5').hide();
        $('#btnMantenimiento5').show();
        alert("La zona de eventos ya esta disponible!");
    });
    // Llamar a la función al cargar la página
    toggleMantenimientoButton(); // Llamar a la función para que se ejecute al cargar la página
});
