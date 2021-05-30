<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.Movie" %>
<%@page import="DAO.MovieDAO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="DAO.BannerDAO" %>
<!DOCTYPE html>
<html>
<head>
	 <c:set var = "root" value="${pageContext.request.contextPath}"/>
</head>
<body>
<%
	MovieDAO movie_dao = new MovieDAO();
	BannerDAO banner_dao = new BannerDAO();
	String menu_id = request.getParameter("menu_id");
	
	Movie movieOfBanner = banner_dao.getMovieBannerOfMenu(Byte.parseByte(menu_id));
	
	 %>
    <!-- Banner start -->
    <div class="banner">
        <div class="banner-img">
            <img src="<%=movieOfBanner.getImage()%>" alt="banner">
        </div>
        <div class="banner-content">
            <div class="banner-content-img">
                <img src="<%=movieOfBanner.getLo()%>"
                    alt="logoFilm">
            </div>
            <h4 class="banner-content-text">
                <span>Top <span class="top">10</span></span>
                <span>#1 in Vietnam Today</span>
                <p><%=movieOfBanner.getDescriptionMovie() %></p>
            </h4>
            <div class="banner-controller">
               <a href="${root}/Inner-Website/play.jsp?video_id=<%=movieOfBanner.getVideo()%>"><i class="fa fa-play"></i>Play</a>
                <a href="#" class="btn banner-btn-info"><i class="fa fa-info"></i>More info</a>
            </div>
        </div>
    </div>
       
     <div class="preloader">
    </div>   
    <div class="trailer-film">
        <iframe src="https://www.youtube.com/embed/<%=movieOfBanner.getVideo()%>>?autoplay=1&loop=1&mute=1&controls=0&playlist=<%=movieOfBanner.getVideo()%>" frameborder="0" allowfullscreen></iframe>
    </div>
  
    <div class="play-film">
        <iframe src="https://www.youtube.com/embed/<%=movieOfBanner.getVideo()%>" frameborder="0" allowfullscreen></iframe>
        <div class="close-movie">
            <i class="fas fa-times"></i>
            <h4 class="back-to-browse">Back to Browse</h4>
        </div>
    </div>
    
   	 <!-- Banner end -->
</body>
</html>