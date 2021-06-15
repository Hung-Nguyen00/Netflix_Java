<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="DAO.MenuDAO" %>
<%@ page import="model.Menu" %>
<%@ page import="DAO.MovieDAO"%>
<%@ page import="model.Movie" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<head>
     <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
     <c:set var = "root" value="${pageContext.request.contextPath}"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../Inner-Website/lib/css/inner-style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w==" crossorigin="anonymous" />
    <title>Netflix</title>
 </head>

<body>
<h1 style="display:none"> <%=request.getParameter("video_id")%></h1>
<%
	MovieDAO movie_dao = new MovieDAO();
		String video_id= null;
		if(request.getParameter("video_id")!=null)
		{
			video_id= request.getParameter("video_id") ;
		}
	 %>
<div class="play-film open">
        <iframe src="https://www.youtube.com/embed/<%=video_id%>" frameborder="0" allowfullscreen></iframe>
        <div class="close-movie">
            <a href="tvShow.jsp?menu_id=1">
            <i class="fas fa-times"  style="margin-right: 100px !important;"></i> </a>
            <h4 class="back-to-browse" style="margin-right: 100px !important;">Back to Browse</h4>
           
        </div>
    </div>
</body>
</html>