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
                    <span style="background-color: ${serverConfigModel.getServerColor()};">"server": "${serverConfigModel.getServer()}",</span><br>
                    <span style="background-color: ${serverConfigModel.getServerIpColor()};">"ip": "${serverConfigModel.getIp()}",</span><br>
                    <span style="background-color: ${serverConfigModel.getDomainColor()};">"domain": ${serverConfigModel.getDomain()},</span><br>
                    "profiles": 
                        [<br>
                            <#list profiles as profile>
                                { <br>
                                    <span style="background-color: ${profile.getNameColor()};">"name": ${profile.getName()},</span><br>
                                    <span style="background-color: ${profile.getDriverColor()};">"driver": ${profile.getDriver()},</span><br>
                                    <span style="background-color: ${profile.getIdColor()};">"id": ${profile.getId()}</span><br>
                                } <br>
                            </#list>
                        ]<br>
                </p>
            </div>
            <div class="col">
                <p>
                    <span style="background-color: ${serverConfigModel1.getServerColor()};">"server": "${serverConfigModel1.getServer()}",</span><br>
                    <span style="background-color: ${serverConfigModel1.getServerIpColor()};">"ip": "${serverConfigModel1.getIp()}",</span><br>
                    <span style="background-color: ${serverConfigModel1.getDomainColor()};">"domain": ${serverConfigModel1.getDomain()},</span><br>
                    "profiles": 
                        [<br>
                            <#list profiles1 as profile1>
                                { <br>
                                    <span style="background-color: ${profile1.getNameColor()};">"name": ${profile1.getName()},</span><br>
                                    <span style="background-color: ${profile1.getDriverColor()};">"driver": ${profile1.getDriver()},</span><br>
                                    <span style="background-color: ${profile1.getIdColor()};">"id": ${profile1.getId()}</span><br>
                                } <br>
                            </#list>
                        ]<br>
                </p>
            </div>
        </div>

        <div class="row">
            <form method="GET" action="/">
                <button class="btn btn-outline-secondary" type="submit" id="inputGroupFileAddon03">Back home</button>
            </form>
        </div>
    </div>
</body>
</html>