<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="model.Actor" %>
<%@page import="DAO.ActorDAO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <c:set var="root" value="${pageContext.request.contextPath}" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Actors</title>
    <link href="${root}/Admin/dist/css/styles.css" rel="stylesheet" />
    <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js" crossorigin="anonymous"></script>
</head>

<body class="sb-nav-fixed">
	<% ActorDAO actorDAO = new ActorDAO(); %>
	<% String actor_id = request.getParameter("actor_id");
		Actor actor = new Actor();
		if(actor_id != null)
		{
			actor = actorDAO.getActor(Integer.parseInt(actor_id));
		}
	
	%>
	<jsp:include page="Header.jsp"></jsp:include>
   <div class="modelAcc open">
            <div class="model-account bgc-white p-20 bd">
                <h6 class="c-grey-900 pt-3 text-center">Edit Account</h6>
                <div class="mT-30 pr-2 pl-2 pb-2">
                    <form action="${root}/ManagerActorServlet" method="post">
                        <div class="form-group">
                           <label for="frist_Name">First Name</label>
                            <input type="text" class="form-control"  value="<%= actor.getFirstName() %>" name="first_name" placeholder="First Name">
                        </div>
                        <div class="form-group">
                            <label for="last_Name">Last Name</label>
                            <input type="text" class="form-control" name="last_name"  value="<%= actor.getLastName() %>" placeholder="Last Name">
                        </div>
                        <div class="form-group">
                            <div class="checkbox checkbox-circle checkbox-info peers ai-c">
                                <label for="inputCall2" class="peers peer-greed js-sb ai-c">
                                    <span class="peer peer-greed">Director</span>
                                </label>
                                <%if(actor.getDirector() == 1){ %>
                                <input type="checkbox" id="director" checked name="director" class="director peer ml-1">
                                <%}else{ %>
                                <input type="checkbox" id="director" name="director" class="director peer ml-1">
                                <%} %>
                            </div>
                        </div>
                        <input type="hidden" value="<%=actor.getActorId()%>" name="actor_id">
                          <input type="hidden" name="command" value="update">
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>
        </div>
        <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid">
                    <h1 class="mt-4">Actors</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item"><a href="${root}/Admin/dist/index.jsp">Dashboard</a></li>
                        <li class="breadcrumb-item active">Actors</li>
                        <li class="ml-5">  <%String succced = (String)request.getAttribute("succced"); %>
                                <%if(succced != null){ %>
                                	<p class="text-success"><%=succced%> </p>
                                <%} %>
                               </li>
                    </ol>
                    <div class="card mb-4">
                        <div class="card-header">
                            <i class="fas fa-table mr-1"></i>Actors
                            <button class="btn-add float-right w-auto btn-info border-0 p-1 pr-2 pl-2">
                                <div>
                                    <i class="fas fa-plus"></i>
                                    <span>Add</span>
                                </div>
                            </button>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                
                            </div>
                        </div>
                    </div>
                </div>
            </main>
            <footer class="py-4 bg-light mt-auto">
                <div class="container-fluid">
                    <div class="d-flex align-items-center justify-content-between small">
                        <div class="text-muted">Copyright &copy; Your Website 2020</div>
                        <div>
                            <a href="#">Privacy Policy</a> &middot;
                            <a href="#">Terms &amp; Conditions</a>
                        </div>
                    </div>
                </div>
            </footer>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" crossorigin="anonymous"></script>

    <script>


    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
     <script src="${root}/Admin/dist/js/scripts.js"></script>
    <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
    <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
     <script src="${root}/Admin/dist/assets/demo/datatables-demo.js"></script>
</body>

</html>