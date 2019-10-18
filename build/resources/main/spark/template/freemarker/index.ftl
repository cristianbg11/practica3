<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Practica3</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/Article-List.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
    <link rel="stylesheet" href="assets/css/smoothproducts.css">
    <link rel="stylesheet" href="css/view.css">
</head>
<body>

<nav class="navbar navbar-light navbar-expand-lg fixed-top bg-white clean-navbar">
    <div class="container"><a class="navbar-brand logo" href="/index">Practica 3</a><button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse"
             id="navcol-1">
            <ul class="nav navbar-nav ml-auto">
                <li class="nav-item" role="presentation"><a class="nav-link active" href="/index">Home</a></li>
                <#if usuario.administrador == true>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="/articulo">Articulos</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="/user">Usuarios</a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="/crear">Crear</a></li>
                </#if>
                <li class="nav-item" role="presentation"><a class="nav-link" href="/">Salir</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="table-responsive">
    <table class="table">
        <thead>
        <tr>
            <th>Column 1</th>
            <th>Column 2</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>Cell 1</td>
            <td>Cell 2</td>
        </tr>
        <tr></tr>
        </tbody>
    </table>
</div>
<div class="article-list">
    <div class="container">
        <div class="intro">
            <h2 class="text-center">Ultimos articulos</h2>
            <p class="text-center">Nunc luctus in metus eget fringilla. Aliquam sed justo ligula. Vestibulum nibh erat, pellentesque ut laoreet vitae. </p>
        </div>
        <div class="row articles">
            <div class="col-sm-6 col-md-4 item"><a href="#"></a>
                <h3 class="name">Article Title</h3>
                <p class="description">Aenean tortor est, vulputate quis leo in, vehicula rhoncus lacus. Praesent aliquam in tellus eu gravida. Aliquam varius finibus est, interdum justo suscipit id.</p><a href="#" class="action" id="viewopen"><i class="fa fa-arrow-circle-right"></i></a></div>
            <div
                    class="col-sm-6 col-md-4 item"><a href="#"></a>
                <h3 class="name">Article Title</h3>
                <p class="description">Aenean tortor est, vulputate quis leo in, vehicula rhoncus lacus. Praesent aliquam in tellus eu gravida. Aliquam varius finibus est, interdum justo suscipit id.</p><a href="#" class="action"><i class="fa fa-arrow-circle-right"></i></a></div>
            <div
                    class="col-sm-6 col-md-4 item"><a href="#"></a>
                <h3 class="name">Article Title</h3>
                <p class="description">Aenean tortor est, vulputate quis leo in, vehicula rhoncus lacus. Praesent aliquam in tellus eu gravida. Aliquam varius finibus est, interdum justo suscipit id.</p><a href="#" class="action"><i class="fa fa-arrow-circle-right"></i></a></div>
        </div>
    </div>
</div>
<div class="pop">
    <span>X</span>
    <h1>jQuery Pop Up</h1>
    <p>This is a random pop up, hopefully its not annoying.</p>
    <div class="form-group"><label>Comentario</label><textarea class="form-control"></textarea></div>
    <div class="form-group"><button class="btn btn-primary btn-block" type="submit" style="margin: 0 auto;width: 82px;height: 38px;">Enviar</button></div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
<script src="assets/js/smoothproducts.min.js"></script>
<script src="assets/js/theme.js"></script>
<script src="js/view.js"></script>
</body>
</html>