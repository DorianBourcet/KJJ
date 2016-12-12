<%@page import="com.kjj.entites.Membre"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kijiji 2.0</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.5/css/bootstrap.min.css" integrity="sha384-AysaV+vQoT3kOAXZkl02PThvDr8HYKPZhNT5h/CXfBThSRXQ6jW5DO2ekP5ViFdi" crossorigin="anonymous">
        <link type="text/css" rel="stylesheet" href="resources/kijijiCss.css"/>
    </head>

    <body>
        <jsp:include page="menu.jsp" />
        <div id="main">
            <jsp:include page="accueil.jsp" />
            <jsp:include page="inscription.jsp"/>
            <jsp:include page="login.jsp"/>
            <jsp:include page="exploration.jsp"/>
            <jsp:include page="article.jsp"/>
        </div>
    </body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <%  if (session.getAttribute("connecte") != null ){%>
            <style>#menu-inscription,#menu-login{display: none}#dash{display: block;}#menu-membre{display: block}</style>
            <input type="hidden" id="hidden-name" value="<%out.print(((Membre)session.getAttribute("connecte")).getUsername());%>">
            <script>$("#name-membre").html($("#hidden-name").val());</script>
        <%}%>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.5/js/bootstrap.min.js" integrity="sha384-BLiI7JTZm+JWlgKa0M0kGRpJbF2J8q+qreVrKBC47e3K6BW78kGLrCkeRX6I9RoK" crossorigin="anonymous"></script>
    <script src="resources/kijijiJS.js"></script>
</html>
