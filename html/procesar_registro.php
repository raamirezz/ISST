<?php
// Conectarse a la base de datos PostgreSQL
$conn = pg_connect("host=localhost port=5432 dbname=TuComunidad user=postgres password=password");

// Verificar si la conexión se realizó correctamente
if (!$conn) {
    echo "Error: No se pudo conectar a la base de datos.";
    exit;
}

// Recuperar los datos del formulario
$user_name = $_POST['username'];
$password = $_POST['password'];
$name = $_POST['name'];
$lastName = $_POST['last-name'];
$email = $_POST['email'];
$dni = $_POST['dni'];
$telefono = $_POST['phone'];
$street = $_POST['street'];
$province = $_POST['province'];

$community_code = $_POST['community-code'];




// Consulta para insertar el nuevo usuario en la tabla VECINO
$query_vecino = "INSERT INTO VECINO (nombre, apellidos, dni, correo, telefono, nombre_usuario, contraseña, direccion) VALUES ('$name', '$lastName', '$dni', '$email', '$telefono', '$user_name', '$password', '$street')";
$result_vecino = pg_query($conn, $query_vecino);


// Consulta para insertar el nuevo usuario en la otra tabla (por ejemplo, OTRA_TABLA)
$query_comunidad = "INSERT INTO COMUNIDAD (codigo, provincia) VALUES ('$community_code', '$province')";
$result_comunidad = pg_query($conn, $query_comunidad);

// Verificar si las consultas se realizaron correctamente
if ($result_vecino && $result_comunidad) {
    // Redireccionar al usuario a la página de registro exitoso
    header("Location: registro_exitoso.html");
    exit;
} else {
    echo "Error al registrar el usuario.";
}

// Cerrar la conexión a la base de datos
pg_close($conn);
?>


