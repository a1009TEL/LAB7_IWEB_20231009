<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ page import="java.util.List" %>
        <%@ page import="java.sql.SQLException" %>
            <%@ page import="com.lab6.app.bean.Entrenador" %>
                <%@ page import="com.lab6.app.dao.EntrenadorDAO" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Veterinaria</title>
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
</head>

<body class="p-8">
    
    <% 
        List<Mascota> mascotas = null;
        try {
        MascotaDAO dao = new MascotaDAO();
        mascotas = dao.getAll();
        } catch(SQLException e) {
        out.println("<p>error : " + e.getMessage() + "</p>");
        }
    %>

    <h1 class="text-xl pb-4">Veterinaria</h1>
    <div class="grid grid-rows-3 gap-2">
        <% if(mascotas !=null) { for(Mascota m : mascotas) { %>
        <div class="m-1 p-2 border-2 rounded border border-indigo-600 border text-indigo-600 bg-indigo-100 shadow flex flex-col">
            <span> <%= m.getNombre() %> </span>
            <span> <%= m.getEdad() %> </span>
            <span> <%= m.getPeso() %> </span>
            <span> <%= m.getNombre() %></span>
            <span> <%= m.getNombre() %> </span>
            <span> <%= m.getNombre() %></span>
        </div>
        <% } } %>
    </div>
</body>
</html>