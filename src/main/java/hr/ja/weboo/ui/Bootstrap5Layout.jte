@param hr.ja.weboo.ui.Bootstrap5Layout layout


<!doctype html>
<html lang="en">
<body>
<div class="container">
    ${layout.getPage().getTitle()}
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
        crossorigin="anonymous"></script>
<script src="weboo.js"></script>
</body>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

</head>
<body>


<div class="container">
    <h2>Ovo je bootstrap 5 layout</h2>

    <p>Page</p>
    <div>${layout.getPage()}</div>
</div>
</body>


</html>