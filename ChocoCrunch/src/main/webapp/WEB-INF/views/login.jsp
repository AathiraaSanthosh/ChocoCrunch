<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />


<c:set var="contextRoot" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>ChocoCrunch - ${title}</title>

<script>
	window.menu = '${title}';

	window.contextRoot = '${contextRoot}';
</script>
<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">


<!-- Bootstrap Readable Theme -->
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">

<%-- <!-- Bootstrap Datatables -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet"> 
 --%>
<link href="${css}/jquery.datatables.min.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="${css}/myapp.css" rel="stylesheet">


<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body style="height: 100%">

	<div class="wrapper">

		<!-- Header -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="${contextRoot}/home">ChocoCrunch</a>
				</div>
			</div>
		</nav>

		<div class="content">
			<div class="container">



				<!-- will be displayed only when the credentials are wrong -->
				<c:if test="${not empty message}">
					<div class="row">
						<div class="col-md-offset-2 col-md-8">



							<div class="alert alert-danger">
								<button type="button" class="close" data-dismiss="alert">&times;</button>
								${message}
							</div>

						</div>
					</div>

				</c:if>

				<!-- will be displayed only when the User logged out-->
				<c:if test="${not empty logout}">
					<div class="row">
						<div class="col-md-offset-2 col-md-8">



							<div class="alert alert-success">
								<button type="button" class="close" data-dismiss="alert">&times;</button>
								${logout}
							</div>

						</div>
					</div>

				</c:if>

				<div class="row">
					<div class="col-md-offset-3 col-md-6">
						<div class="panel panel-primary">

							<div class="panel-heading">
								<h4>Login</h4>
							</div>
							<div class="panel-body">
								<form action="${contextRoot}/login" method="POST"
									class="form-horizontal" id="loginForm">

									<div class="form-group has-success">
										<label for="username" class="col-md-4 control-label">Email:</label>
										<div class="col-md-8">

											<input type="text" name="username" id="username"
												class="form-control" />
										</div>
									</div>

									<div class="form-group has-success">
										<label for="password" class="col-md-4 control-label">Password:</label>
										<div class="col-md-8">

											<input type="password" name="password" id="password"
												class="form-control" />
										</div>
									</div>

									<div class="form-group">
										<div class="col-md-offset-4 col-md-8">

											<input type="submit" value="Login" class="btn btn-primary" />
											<input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" />

										</div>
									</div>

								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>


		<!-- Footer comes here -->
		<%@include file="./shared/footer.jsp"%>

		<!-- jQuery -->
		<script src="${js}/jquery.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>

		<!-- DataTable Plugin -->
		<script src="${js}/jquery.dataTables.js"></script>

		<!-- DataTable Bootstrap Script-->
		<script src="${js}/dataTables.bootstrap.js"></script>

		<!-- Bootbox-->
		<script src="${js}/bootbox.min.js"></script>



		<!-- Self coded javascript -->
		<script src="${js}/myapp.js"></script>


	</div>
</body>

</html>