<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <title>Compare_json</title>
</head>
<body>
    <div class="container">
        <h3>Welcome to Compare Json's</h3>
        <p>
            This web application is needed for comparison a couple of json files. <br>
            To compare a couple of json files you need to upload theese files to our service. <br>
            Then you need to push the "compare" button. After that we will be able to see a result of comparison.    
        </p>

        <form method="POST">
           <div class="input-group">
                <input type="file" class="form-control" id="inputGroupFile01" aria-describedby="inputGroupFileAddon04" aria-label="Upload">
                <button class="btn btn-outline-secondary" type="button" id="inputGroupFileAddon01">Upload_file_1</button>
            </div>

            <div class="input-group">
                <input type="file" class="form-control" id="inputGroupFile02" aria-describedby="inputGroupFileAddon04" aria-label="Upload">
                <button class="btn btn-outline-secondary" type="button" id="inputGroupFileAddon02">Upload_file_2</button>
            </div>
            <button class="btn btn-outline-secondary" type="button" id="inputGroupFileAddon03">Compare</button> 
        </form>
        
    </div>
    
</body>
</html>