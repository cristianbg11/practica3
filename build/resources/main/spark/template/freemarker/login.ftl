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
            <input type="hidden" name="administrador" value="FALSE">
            <input type="hidden" name="autor" value="FALSE">
            <button>Enviar</button>
        </form>
    </div>
    <div class="form-container sign-in-container">
        <form action="#">
            <h1>Sign in</h1>
            <input type="text" placeholder="Username" />
            <input type="password" placeholder="Password" />
            <button>Sign In</button>
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
                <h1>Hello, Usuario!</h1>
                <p>Introdusca sus datos personales e inicie este software</p>
                <button class="ghost" id="signUp">Sign Up</button>
            </div>
        </div>
    </div>
</div>

<footer>
</footer>
<script src="js/login.js"></script>
</body>
</html>