<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <title>ResultCompare</title>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col">
                <h3>${modelName1}</h3>
            </div>
            <div class="col">
                <h3>${modelName2}</h3>
            </div>
        </div>

        <div class="row">
            <div class="col">
                <p>
                    "server": "${serverName}",<br>
                    "ip": "${serverIp}", <br>
                    "domain": ${domainName}, <br>
                    <#list profiles as profile>
                            "profiles": [ <br>
                                    { <br>
                                        "name": ${profile.getName()}, <br>
                                        "driver": ${profile.driver}, <br>
                                        "id": ${profile.id} <br>
                                    } <br>
                            ] <br>
                    </#list>
                </p>
            </div>
            <div class="col">
                <p>
                    "server": "${serverName}",<br>
                    "ip": "${serverIp}", <br>
                    "domain": ${domainName}, <br>
                    <#list profiles as profile>
                            "profiles": [ <br>
                                    { <br>
                                        "name": ${profile.getName()}, <br>
                                        "driver": ${profile.driver}, <br>
                                        "id": ${profile.id} <br>
                                    } <br>
                            ] <br>
                    </#list>
                </p>
            </div>
        </div>
    </div>
</body>
</html>