<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="DAO.MenuDAO" %>
<%@ page import="model.Menu" %>
<%@ page import="DAO.Account_ChildDAO" %>
<%@ page import="model.AccountChild" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<c:set var = "root" value="${pageContext.request.contextPath}"/>
<title>Header Account</title>
</head>
<body>
<%
	MenuDAO menu_dao = new MenuDAO();
	Account_ChildDAO ac_dao = new Account_ChildDAO();
	String email_session = session.getAttribute("email").toString();
	int id_session = Integer.valueOf(session.getAttribute("account_id").toString());
	 %>
	        <header>
            <a href="index.jsp?menu_id=0" class="logo"><img src="https://truecostmovie.com/img/TTC/wp-content/uploads/2015/10/netflix_logo_digitalvideo-1.png" alt=""></a>
            <ul class="search">
                <li class="dropdown-avatar">
                    <%for(AccountChild ac : ac_dao.getAccountChildsbyId((byte)id_session)) { %>
                <img src="<%=ac.getAvatar() %>" style="max-width: 35px;" alt="">
                <%} %>
                    <ul class="dropdown-iconProfile">
                    	<%for(AccountChild ac : ac_dao.getAccountChildsbyEmail(email_session)) { %>
                    <li>
                        <img class="img-border-radius" src="<%=ac.getAvatar()%>" alt="">
                        <a href="${root}/logintoid?account_id=<%=ac.getAccountId()%>" <%if(ac.getAccountId()==id_session){%> style="font-weight:bold;font-size:1.1rem;text-decoration: underline" <%}%> ><%=ac.getNameAccount() %></a>
                    </li>
                    <%} %>
                        <li class="dropdown-manage"><a href="browse.jsp">Manage Profiles</a></li>
                    <li class="dropdown-borderTop dropdown-manage"><a href="account.jsp">Account</a></li>
                    <li class="dropdown-manage"><a href="#">Help Center</a></li>
                    <li class="dropdown-manage">
                    	<a href="${root}/logout">Sign out of Netflix</a>
                    </li>
                    </ul>
                
                </li>
            
            </ul>
        </header>
</body>
</html>