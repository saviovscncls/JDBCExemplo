<%-- 
    Document   : criarContato
    Created on : 13/11/2018, 19:59:24
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Criar Contato</h1>
        <form method='POST' action = '/Agenda/SalvarContato'>
            Nome: <input type="text" name="nome"/> <br/>
            Email: <input type="text" name="email"/> <br/>
            Endereço <input type="text" name="endereco"/> <br/>
            Data de Nascimento: <input type="text" name="data"/> <br/><br/><br/>
            <button type="submit">Criar Contato</button>
        </form>
    </body>
</html>
