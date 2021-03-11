<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <%
        if(session != null){
            String email = (String) session.getAttribute("email");
            if(email != null){
            }
            else{
                response.sendRedirect(".");
            }
        }
        String email = (String) session.getAttribute("email");
        
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Horóscopo</title>
        <meta charset="UTF-8">
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="js/functions.js" type="text/javascript"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body id="corpo">
        <div class="container">
            
            <br>
            <div class="md-form">
                <form id="form" onsubmit="geraHoroscopo(this)">
                    <h4>Informe sua data de nascimento</h4>
                     <input type="date" name="dtnasc" id="dtnasc" max="3000-12-31" 
                        min="1000-01-01" class="form-control"> 
                     <br>
                     <input type="submit" class="btn btn-dark btn-block btn-lg " value="Descubra">
                </form>
                <div id="previsao">
                    
                </div>
                <p class="bg-primary">Horóscopo - <%= email %></p>
                <a href="servletLoggout" class="badge badge-danger bt-logout">Sair</a>
            </div>
        </div>
        <br>
    </body>
    
</html>
