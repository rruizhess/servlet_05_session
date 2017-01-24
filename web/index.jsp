<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!--Import Google Icon Font-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    </head>

    <body >
        <!-- Contenido-->
        <%
            String rut="";
            Cookie[]cookies=request.getCookies();
            for (Cookie item : cookies) {
                if (item.getName().equals("rut")) {
                    rut = item.getValue();
                }
            }
        %>
        
        
        
        <div class="row">
            <div class="col s4">
            </div>
            <div class="col s4">
                <form action="validar.do" method="POST">
                    <div class="input-field">
                        <label for="rut">Rut</label>
                        <input value="<%=rut%>" type="text" name="rut" id="rut"/>
                    </div>
                    <div class="input-field">
                        <label for="pass">Clave</label>
                        <input type="password" name="clave" id="pass"/>
                    </div>
                    <input type="submit" value="aceptar" name="bt" class="btn right"/>
                </form>
                <br>
                ${error}
            </div>
            
        </div>

        <!--Import jQuery before materialize.js-->
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
    </body>
</html>