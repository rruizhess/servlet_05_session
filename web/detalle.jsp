<%@page import="java.util.ArrayList"%>
<%@page import="cl.model.Producto"%>
<%@page import="cl.model.User"%>
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

    <body>
        <%
            User user = (User) session.getAttribute("user");
        %>
        <% if (user != null) {%>
        <nav>
            <div class="nav-wrapper grey lighten-1">
                <a href="#" class="brand-logo">
                    Bienvenido <%=user.getNombre()%><%= user.getApellido() %>
                </a>
                <ul id="nav-mobile" class="right hide-on-med-and-down">
                    <li><a href="productos.jsp">Productos</a></li>
                    <li><a href="carro.jsp">Mi Carro</a></li>
                    <li><a href="cerrar.jsp">Salir</a></li>
                </ul>
            </div>
        </nav>
        <%
            //RESCATAR PARAMETRO ENVIADO POR PRODUCTOS
            String codigo = request.getParameter("codigo");
            //OBTENER LISTA PARA BUSCAR PRODUCTO
            ArrayList<Producto> lista = (ArrayList<Producto>)
                       getServletContext().getAttribute("listaproducto");

            //BUSCAR EL PRODUCTO
            Producto producto = null;
            for (Producto p : lista) {
                if (p.getCodigo() == Integer.parseInt(codigo)) {
                           producto = p;
                           break;
                }
            }
           
        %>    
        <div class="row">
            <div class="col s4"></div>
            <div class="col s4">
                <form action="add.do" method="post">
                    Codigo
                    <input readonly="true" type="text" name="codigo" value="<%= producto.getCodigo() %>">
                    Nombre
                    <input readonly="true" type="text" name="nombre" value="<%= producto.getNombre()%>">   
                    Precio
                    <input readonly="true" type="text" name="precio" value="<%= producto.getPrecio()%>">
                    Cantidad
                    <select name="cantidad">
                        <% for(int i=1; i<= producto.getStock(); i++){ %>
                        <option><%=i%></option>
                        <% } %>
                    </select>
                    <button type="submit" name="bt" class="btn right" >
                        <i class="material-icons">shopping_car</i>Add
                    </button>
                    <br><br>
                    <a href="productos.jsp">volver</a>
                </form>
            </div>
        </div>
                
                
        <% }else{%>
            No tienes permisos para acceder...<br>
            <a href="index.jsp">Home</a>
        <% } %>

        <!--Import jQuery before materialize.js-->
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
    </body>
</html>
