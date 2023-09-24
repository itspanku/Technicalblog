
<%@page import="com.tech.blog.helper.ConnectionProvider"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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

	<!-- navbar -->
	<%@include file="normal_navbar.jsp"%>

	<!-- banner -->
	<div class="container-fluid p-0 m-0">
		<div class="jumbotron primary-background text-white banner-background">
			<div class="container">
				<h3 class="display-3">Welcome, to TechBlog</h3>
				<h3>Tech Blog</h3>
				<p>Welcome to technical blog, world of Technology A programming
					language is a system of notation for writing computer programs.[1]
					Most programming languages are text-based formal languages, but
					they may also be graphical. They are a kind of computer language.</p>
				<p>The description of a programming language is usually split
					into the two components of syntax (form) and semantics (meaning),
					which are usually defined by a formal language. Some languages are
					defined by a specification document (for example, the C programming
					language is specified by an ISO Standard) while other languages
					(such as Perl) have a dominant implementation that is treated as a
					reference. Some languages have both, with the basic language
					defined by a standard and extensions taken from the dominant
					implementation being common.</p>

				<button class="btn btn-outline-light btn-lg">
					<span class="fa fa-share-square-o"></span>Start ! Its Free
				</button>
				<a href=" login_page.jsp" class="btn btn-outline-light btn-lg"><span
					class="	fa fa-user-circle fa-spin"></span>Login</a>
			</div>
		</div>

	</div>

	<!-- Cards -->
	<div class="container">
		<div class="row mb-2">

			<div class="col-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Java Programming</h5>
						<pre class="card-text">Java is a popular programming language, created in 1995.

It is owned by Oracle, and more than 3 billion devices run Java.

It is used for:

Mobile applications (specially Android apps)
Desktop applications
Web applications
Web servers and application servers
Games
Database connection
And much, much more!
						</pre>
						<a href="#" class="btn primary-background text-white">Read
							More</a>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Python Programming</h5>
						<p class="card-text">Welcome! Are you completely new to programming? If not then we presume you will be looking for information about why and how to get started with Python. Fortunately an experienced programmer in any programming language (whatever it may be) can pick up Python very quickly. It's also easy for beginners to use and learn, so jump in!</p>
						<a href="#" class="btn primary-background text-white">Read
							More</a>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Web Technology</h5>
						<p class="card-text">Web Technology refers to the various tools and techniques that are utilized in the process of communication between different types of devices over the Internet. A web browser is used to access web pages. Web browsers can be defined as programs that display text, data, pictures, animation, and video on the Internet.</p>
						<a href="#" class="btn primary-background text-white">Read
							More</a>
					</div>
				</div>
			</div>

		</div>


		<div class="row">

			<div class="col-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">React js</h5>
						<pre class="card-text">React is a JavaScript library for building user interfaces.

React is used to build single-page applications.

React allows us to create reusable UI components.</pre>
						<a href="#" class="btn primary-background text-white">Read
							More</a>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">C Programming</h5>
						<pre class="card-text">C is a general-purpose programming language created by Dennis Ritchie at the Bell Laboratories in 1972.

It is a very popular language, despite being old.

C is strongly associated with UNIX, as it was developed to write the UNIX operating system.

						</pre>
						<a href="#" class="btn primary-background text-white">Read
							More</a>
					</div>
				</div>
			</div>

			<div class="col-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">C++ Programming</h5>
						<pre class="card-text">C++ is a cross-platform language that can be used to create high-performance applications.

C++ was developed by Bjarne Stroustrup, as an extension to the C language.

C++ gives programmers a high level of control over system resources and memory.

The language was updated 4 major times in 2011, 2014, 2017, and 2020 to C++11, C++14, C++17, C++20.</pre>
						<a href="#" class="btn primary-background text-white">Read
							More</a>
					</div>
				</div>
			</div>

		</div>
	</div>
	


<!--  java Script -->
	<script src="https://code.jquery.com/jquery-3.7.0.min.js"
		integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g="
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>

	<script src="js/myjs.js" type="text/javascript"></script>

</body>
</html>