$(document).ready(function () {
  // Función para generar las opciones del desplegable con las horas del día
  function generarOpcionesHoras(selectId) {
    var select = $("#" + selectId);
    for (var i = 0; i < 24; i++) {
      var horaInicio = i < 10 ? "0" + i : i;
      var horaFin = i + 1 < 10 ? "0" + (i + 1) : i + 1;
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
  $(
    "#datepicker1, #datepicker2, #datepicker3, #datepicker4, #datepicker5"
  ).datepicker({
    format: "dd/mm/yyyy",
    autoclose: true,
    todayHighlight: true,
  });

  // Función para realizar la solicitud de reserva
  function confirmarReserva(instalacion, id) {
    var date = "#datepicker" + id;
    console.log(date);
    // Obtener la fecha y hora seleccionadas
    var fechaSeleccionada = $("#datepicker" + id).val();
    var horaSeleccionada = $("#selectHora" + id).val();
    console.log("Fecha seleccionada:", fechaSeleccionada);
    console.log("Hora seleccionada:", horaSeleccionada);
    // Mostrar un mensaje de alerta con los detalles de la reserva
    alert(
      "Fecha seleccionada para " +
        instalacion +
        ": " +
        fechaSeleccionada +
        " a las " +
        horaSeleccionada
    );

    // Datos de la reserva
    var data = {
      fecha: fechaSeleccionada,
      hora: horaSeleccionada,
      instalacion: instalacion,
      usuario: "Nombre de Usuario", // Aquí debes obtener el nombre de usuario del contexto de tu aplicación
    };

    // Realizar la solicitud POST a la API
    fetch("http://localhost:8080/api/reserva/crear", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    })
      .then((response) => {
        if (response.ok) {
          console.log("Datos guardados con éxito.");
          alert("¡Reserva confirmada para " + instalacion + "!");
          // Aquí podrías redirigir al usuario o realizar alguna otra acción
        } else {
          console.error("Error al guardar los datos.");
          alert(
            "Error al confirmar la reserva para " +
              instalacion +
              ". Por favor, inténtalo de nuevo."
          );
        }
      })
      .catch((error) => {
        console.error("Error al realizar la solicitud:", error);
        alert(
          "Error al confirmar la reserva para " +
            instalacion +
            ". Por favor, inténtalo de nuevo."
        );
      });
    console.log(data);
  }

  // Agrega un listener al botón "Confirmar" de cada tarjeta
  $("#btnConfirmar1").on("click", function () {
    confirmarReserva("Pista de Pádel", 1);
  });

  $("#btnConfirmar2").on("click", function () {
    confirmarReserva("GYM", 2);
  });

  $("#btnConfirmar3").on("click", function () {
    confirmarReserva("Piscina", 3);
  });

  $("#btnConfirmar4").on("click", function () {
    confirmarReserva("Pista de Tenis", 4);
  });

  $("#btnConfirmar5").on("click", function () {
    confirmarReserva("Zona de Eventos", 5);
  });

  // Variable que indica si el usuario es presidente
  var isPresidente = true; // O true según corresponda

  function toggleMantenimientoButton() {
    if (!isPresidente) {
      $('[id^="mantenimientoBtnContainer"]').hide();
      $('[id^="disponibilidadBtnContainer"]').hide(); // Ocultar todos los contenedores de botones de mantenimiento
    }
  }

  var disponibilidadPadel = true;
  var disponibilidadGYM = true;
  var disponibilidadPiscina = true;
  var disponibilidadTenis = true;
  var disponibilidadEventos = true;

  var disponibilidad = {
    ComunityCode: "12345678",
    dispPadel: disponibilidadPadel,
    dispGYM: disponibilidadGYM,
    dispPiscina: disponibilidadPiscina,
    dispTenis: disponibilidadTenis,
    dispEventos: disponibilidadEventos,
  };

  function cambiarDisponibilidad(instalacion, disponible) {
    switch (instalacion) {
      case "Padel":
        disponibilidad.dispPadel = disponible;
        break;
      case "GYM":
        disponibilidad.dispGYM = disponible;
        break;
      case "Piscina":
        disponibilidad.dispPiscina = disponible;
        break;
      case "Tenis":
        disponibilidad.dispTenis = disponible;
        break;
      case "Eventos":
        disponibilidad.dispEventos = disponible;
        break;
      default:
        console.error("Instalación no reconocida.");
        return;
    }

    fetch(`http://localhost:8080/api/reserva/actualizarDisponibilidad`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(disponibilidad),
    })
      .then((response) => {
        if (response.ok) {
          console.log("Estado de disponibilidad actualizado correctamente.");
          // Podrías mostrar un mensaje o realizar alguna otra acción si lo deseas
        } else {
          console.error("Error al actualizar el estado de disponibilidad.");
          // Podrías manejar el error de alguna manera si lo deseas
        }
      })
      .catch((error) => {
        console.error("Error al realizar la solicitud:", error);
        // Podrías manejar el error de alguna manera si lo deseas
      });
  }

  // Asignar listeners a los botones de mantenimiento y disponibilidad
  $("#btnMantenimiento1").on("click", function () {
    cambiarDisponibilidad('Padel', false); // Indicar que la pista de pádel no está disponible
    alert("La pista de padel no esta disponible!");
    $("#btnMantenimiento1").hide();
    $("#btnDisponible1").show();
    console.log(disponibilidad);
  });

  $("#btnDisponible1").on("click", function () {
    cambiarDisponibilidad('Padel', true); // Cambiar la disponibilidad de la pista de pádel a disponible
    alert("La pista de padel esta disponible!");
    $("#btnDisponible1").hide();
    $("#btnMantenimiento1").show();
    console.log(disponibilidad);
  });

  // Asignar listeners a los botones de mantenimiento y disponibilidad para la instalación 2
  $("#btnMantenimiento2").on("click", function () {
    cambiarDisponibilidad('GYM', false); // Indicar que el GYM no está disponible
    alert("El servicio está en mantenimiento");
    $("#btnMantenimiento2").hide();
    $("#btnDisponible2").show();
    console.log(disponibilidad);
  });

  $("#btnDisponible2").on("click", function () {
    cambiarDisponibilidad('GYM', true); // Cambiar la disponibilidad del GYM a disponible
    alert("El gimnasio está disponible!");
    $("#btnDisponible2").hide();
    $("#btnMantenimiento2").show();
    console.log(disponibilidad);
  });

  // Asignar listeners a los botones de mantenimiento y disponibilidad para la instalación 3
  $("#btnMantenimiento3").on("click", function () {
    cambiarDisponibilidad('Piscina', false); // Indicar que la piscina no está disponible
    alert("El gimnasio no está disponible!");
    $("#btnMantenimiento3").hide();
    $("#btnDisponible3").show();
    console.log(disponibilidad);
  });

  $("#btnDisponible3").on("click", function () {
    cambiarDisponibilidad('Piscina', true); // Cambiar la disponibilidad de la piscina a disponible
    alert("La piscina ya está disponible!");
    $("#btnDisponible3").hide();
    $("#btnMantenimiento3").show();
    console.log(disponibilidad);
  });

  // Asignar listeners a los botones de mantenimiento y disponibilidad para la instalación 4
  $("#btnMantenimiento4").on("click", function () {
    cambiarDisponibilidad('Tenis', false); // Indicar que la pista de tenis no está disponible
    alert("La pista de tenis no está disponible!");
    $("#btnMantenimiento4").hide();
    $("#btnDisponible4").show();
    console.log(disponibilidad);
  });

  $("#btnDisponible4").on("click", function () {
    cambiarDisponibilidad('Tenis', true); // Cambiar la disponibilidad de la pista de tenis a disponible
    alert("La pista de tenis ya está disponible!");
    $("#btnDisponible4").hide();
    $("#btnMantenimiento4").show();
    console.log(disponibilidad);
  });

  // Asignar listeners a los botones de mantenimiento y disponibilidad para la instalación 5
  $("#btnMantenimiento5").on("click", function () {
    cambiarDisponibilidad('Eventos', false); // Indicar que la zona de eventos no está disponible
    alert("La zona de eventos no está disponible!");
    $("#btnMantenimiento5").hide();
    $("#btnDisponible5").show();
    console.log(disponibilidad);
  });

  $("#btnDisponible5").on("click", function () {
    cambiarDisponibilidad('Eventos', true); // Cambiar la disponibilidad de la zona de eventos a disponible
    alert("La zona de eventos ya está disponible!");
    $("#btnDisponible5").hide();
    $("#btnMantenimiento5").show();
    console.log(disponibilidad);
  });

  // Llamar a la función al cargar la página
  toggleMantenimientoButton(); // Llamar a la función para que se ejecute al cargar la página
});
