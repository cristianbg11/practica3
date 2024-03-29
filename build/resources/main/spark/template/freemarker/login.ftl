<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="css/login.css" rel="stylesheet" type="text/css">
    <title>Login</title>
</head>
<body>
<h2>Sign in/up</h2>
<div class="container" id="container">
    <div class="form-container sign-up-container">
        <form action="/insertar" method="POST">
            <h1>Crear Cuenta</h1>
            <input type="text" placeholder="Username" name="username"/>
            <input type="text" placeholder="Nombre" name="nombre"/>
            <input type="password" placeholder="Password" name="password"/>
            <input type="hidden" name="administrador" value="TRUE">
            <input type="hidden" name="autor" value="TRUE">
            <button>Enviar</button>
        </form>
    </div>
    <div class="form-container sign-in-container">
        <form action="/sesion" method="POST">
            <h1>Sign in</h1>
            <input type="text" placeholder="Username" name="user" />
            <input type="password" placeholder="Password" name="pass" />
            <button>Iniciar</button>
        </form>
    </div>
    <div class="overlay-container">
        <div class="overlay">
            <div class="overlay-panel overlay-left">
                <h1>Bienvenido!</h1>
                <p>Para seguir conectado, inicie sesion con sus datos personales</p>
                <button class="ghost" id="signIn">Sign In</button>
            </div>
            <div class="overlay-panel overlay-right">
                <h1>Hola, Usuario!</h1>
                <p>Introdusca sus datos personales e inicie este software</p>
                <button class="ghost" id="signUp">Registrarse</button>
            </div>
        </div>
    </div>
</div>

<footer>
</footer>
<script src="js/login.js"></script>
</body>
</html>