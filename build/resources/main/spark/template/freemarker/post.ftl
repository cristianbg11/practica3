<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Home - Brand</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora">
    <link rel="stylesheet" href="assets/css/Article-Clean.css">
    <link rel="stylesheet" href="assets/css/Article-List.css">
    <link rel="stylesheet" href="assets/css/Bootstrap-Tags-Input.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
    <link rel="stylesheet" href="assets/css/smoothproducts.css">
    <link rel="stylesheet" href="assets/css/survey-comment.css">
    <link rel="stylesheet" href="assets/css/text-box.css">
</head>

<body>
<nav class="navbar navbar-light navbar-expand-lg fixed-top bg-white clean-navbar">
    <div class="container"><a class="navbar-brand logo" href="#">Practica 3</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse"
             id="navcol-1">
            <ul class="nav navbar-nav ml-auto">
                <li class="nav-item" role="presentation"><a class="nav-link" href="index.html">Inicio</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="features.html">Articulos</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="pricing.html">Usuarios</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="contact-us.html">Crear</a></li>
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
<div class="article-list"></div>
<div class="article-clean">
    <div class="container">
        <div class="row">
            <div class="col-lg-10 col-xl-8 offset-lg-1 offset-xl-2">
                <div class="intro">
                    <h1 class="text-center">Your Wonderful Article Title</h1>
                    <p class="text-center"><span class="by">by</span> <a href="#">Author Name</a><span class="date">Sept 8th, 2016 </span></p>
                </div>
                <div class="text">
                    <p class="text-justify" style="font-size: 18px;">Sed lobortis mi. Suspendisse vel placerat ligula. <span style="text-decoration: underline;">Vivamus</span> ac sem lac. Ut vehicula rhoncus elementum. Etiam quis tristique lectus. Aliquam in arcu eget velit pulvinar dictum vel in
                        justo. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae.</p>
                    <figure>
                        <figcaption class="text-justify">Tags:&nbsp;</figcaption>
                    </figure>
                </div>
                <h5 class="text-justify" style="padding-top: 5px;margin-bottom: 0px;">Comentarios</h5>
                <div class="row survey-comment">
                    <div class="col col-9 col-md-10 survey-comment__text"><strong class="survey-comment__author-name">Tony Biskup</strong>
                        <div class="survey-comment__text-content">
                            <p class="text-justify text-secondary" style="font-size: 14px;">Thanks for the gifts! I sold the skin care cream on eBay and made £100 on it. Oh by the way, nothing is stopping me from signing up to all the gifts listed, which I did, lol. Just letting you know.<br></p>
                        </div><div class="survey-comment__date-time">
                            <script>
                                var mydate = new Date()
                                mydate.setDate(mydate.getDate() - 14);
                                var year = mydate.getYear()
                                if (year < 1000)
                                    year += 1900
                                var day = mydate.getDay()
                                var month = mydate.getMonth()
                                var daym = mydate.getDate()
                                if (daym < 10)
                                    daym = "0" + daym
                                var dayarray = new Array("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
                                var montharray = new Array("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December")
                                document.write("" + montharray[month] + " " + daym + ", " + year + "")
                            </script>
                        </div></div>
                </div><div class="card text-white bg-primary mb-1">
                    <div class="card-header">
                        UserName
                        <a class="float-right btn btn-dark"> <i class="fa fa-comment"></i> Comenta</a>
                    </div>
                    <div class="card-body">
                        <div class=" card-text form-group">
          <textarea placeholder="Message" rows="4"
                    class="form-control form-control-lg">
          </textarea>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
<script src="assets/js/smoothproducts.min.js"></script>
<script src="assets/js/theme.js"></script>
<script src="assets/js/Bootstrap-Tags-Input-1.js"></script>
<script src="assets/js/Bootstrap-Tags-Input.js"></script>
</body>

</html>