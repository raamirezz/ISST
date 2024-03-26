<?php
// Conectarse a la base de datos PostgreSQL
$conn = pg_connect("host=localhost port=5432 dbname=TuComunidad user=postgres password=password");

// Verificar si la conexión se realizó correctamente
if (!$conn) {
    echo "Error: No se pudo conectar a la base de datos.";
    exit;
}

// Recuperar los datos del formulario
$name = $_POST['name'];
$lastName = $_POST['last-name'];
$email = $_POST['email'];
$dni = $_POST['dni'];
$telefono = $_POST['phone'];
// Consulta para insertar el nuevo usuario en la base de datos
$query = "INSERT INTO VECINO (nombre, apellidos, dni, correo, telefono) VALUES ('$name', '$lastName', '$dni', '$email', '$telefono')";
$result = pg_query($conn, $query);

// Verificar si la consulta se realizó correctamente
if ($result) {
    // Redireccionar al usuario a la página de registro exitoso
    header("Location: registro_exitoso.html");
    exit;
} else {
    echo "Error al registrar el usuario.";
}

// Cerrar la conexión a la base de datos
pg_close($conn);
?>

