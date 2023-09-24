<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page isErrorPage= "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sorry ! Something went wrong</title>
<!-- CSS styling  -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="css/mystyle.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.banner-background {
	clip-path: polygon(10% 0, 100% 0%, 91% 100%, 0% 100%);
	clip-path: polygon(6% 0, 99% 2%, 94% 100%, 1% 98%);
}
</style>
</head>
<body>

<div class="container text-center">
<img alt="" src="img/error.png" class="img-fluid">
<h3 class="display">Sorry ! Something went wrong.....</h3>
<%= exception %>
<a href="index.jsp"><button class="btn primary-background btn-lg text-white mt-3">Home</button></a>

</div>
</body>
</html>