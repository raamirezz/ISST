<?php
// Datos de conexión a la base de datos PostgreSQL
$host = "localhost";
$port = "5432";
$dbname = "TuComunidad";
$user = "postgres";
$password = "password";

// Establecer conexión a la base de datos
$conn = pg_connect("host=$host port=$port dbname=$dbname user=$user password=$password");

// Verificar si la conexión se realizó correctamente
if (!$conn) {
    echo "Error: No se pudo conectar a la base de datos.";
    exit;
}

// Recuperar las credenciales del formulario
$username = $_POST['username'];
$password = $_POST['password'];

// Consulta para buscar al usuario en la base de datos
$query = "SELECT * FROM vecino WHERE nombre_usuario = '$username' AND contraseña = '$password'";
$result = pg_query($conn, $query);

// Verificar si se encontró al usuario
if ($row = pg_fetch_assoc($result)) {
    // Usuario autenticado correctamente
    echo "¡Bienvenido, $username!";
} else {
    // Usuario no encontrado o contraseña incorrecta
    echo "Usuario o contraseña incorrectos";
}

// Cerrar la conexión a la base de datos
pg_close($conn);
?>