<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <title>EmptyFiles</title>
</head>
<body>
    <div class="container">
        <h3>Your files have not been uploaded!</h3>
        <h5>Causes: there is an empty file or file doesn't exist</h5>
        <#list tests as test>
            <p style="color: ${color0}">${test}${test?index}</p>
        </#list>
    </div>
</body>
</html>