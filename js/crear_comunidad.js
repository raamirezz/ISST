$(document).ready(function () {
  // Variables globales para almacenar el estado de los checkboxes
  var hasPiscina = false;
  var hasTenis = false;
  var hasPadel = false;
  var hasGym = false;
  var hasLocalEventos = false;

  // Maneja el clic en los botones de instalación
  $(".instalacion-btn").click(function (event) {
    event.preventDefault();
    var mensajeConfirmacion = $(this).find(".mensaje-confirmacion");

    if (mensajeConfirmacion.is(":visible")) {
      mensajeConfirmacion.hide();
      console.log("hide");
    } else {
      mensajeConfirmacion.show();
      console.log("show");
    }
    
    var instalacion = $(this).data('instalacion');

    switch (instalacion) {
      case "Pista de Tenis":
        hasTenis = !hasTenis; // Alternar entre true y false
        console.log("Tenis:", hasTenis);
        break;
      case "Pista de Pádel":
        hasPadel = !hasPadel;
        console.log("Padel:", hasPadel);
        break;
      case "Gimnasio":
        hasGym = !hasGym;
        console.log("Gym:", hasGym);
        break;
      case "Piscina":
        hasPiscina = !hasPiscina;
        console.log("Piscina:", hasPiscina);
        break;
      case "Local de Eventos":
        hasLocalEventos = !hasLocalEventos;
        console.log("Eventos:", hasLocalEventos);
        break;
      default:
        break;
    }
    
  });

  // Maneja el clic en el campo de código de la comunidad para generar un código aleatorio
  $("#community_code").click(function () {
    var communityCode = Math.floor(
      100000000 + Math.random() * 900000000
    ).toString();
    $(this).val(communityCode);
  });

  // Selector para el botón de enviar el formulario
  $("#crear-comunidad-btn").on("click", function (e) {
    e.preventDefault(); // Evita el comportamiento predeterminado del botón

    // Obtener los valores de los campos del formulario
    var communityCode = $("#community_code").val();
    var calle = $("#calle").val();
    var provincia = $("#provincia").val();

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
    fetch("http://localhost:8080/api/comunidad/crear", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(formData),
    })
      .then((response) => {
        if (response.ok) {
          console.log(formData);
          // Puedes agregar aquí cualquier acción adicional que desees después de crear la comunidad
        } else {
          console.error("Error al crear la comunidad.");
          alert("Error al crear la comunidad. Por favor, inténtalo de nuevo.");
          console.log(formData);
        }
      })
      .catch((error) => {
        console.error("Error al realizar la solicitud:", error);
        alert("Error al crear la comunidad. Por favor, inténtalo de nuevo.");
        console.log(formData);
      });
  });
});
