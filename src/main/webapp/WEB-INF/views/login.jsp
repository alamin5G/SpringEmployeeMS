<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	<%@page isELIgnored="false" %>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]>      <html class="no-js"> <!--<![endif]-->
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Welcome to Employee Management System</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>

</head>

<body class="p-3 m-0 border-0 bd-example m-0 border-0">

    <!-- Example Code -->

    <div class="container">
        <nav class="navbar navbar-expand-md bg-dark border-bottom border-body bg-body-tertiary " data-bs-theme="dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="homepage">Employee MS</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="homepage">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="addEmployee">Add Employee</a>
                        </li>
                         <li class="nav-item">
                            <a class="nav-link" href="login">Login</a>
                        </li>
                         <li class="nav-item">
                            <a class="nav-link" href="registration">Register</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                                aria-expanded="false">
                                Dropdown
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="#">Action</a></li>
                                <li><a class="dropdown-item" href="#">Another action</a></li>
                                <li>
                                    <hr class="dropdown-divider">
                                </li>
                                <li><a class="dropdown-item" href="#">Something else here</a></li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled" aria-disabled="true">Coming Soon</a>
                        </li>
                    </ul>
                    <form class="d-flex" role="search">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
            </div>
        </nav>

    </div>
    
    <div class="container">
        <div class="row">
         <div class="col-md-6 offset-md-3">
                <div class="card bg-success text-white mt-3">
                    <div class="card-header text-center">
                        <h4>Login to your account</h4>
                    </div>
                    <c:if test="${not empty msg }">
                    <div class="bg-danger pt-2 text-center text-white rounded">
                        	
                        		<h5>${msg }</h5>
                        </div>
                        <c:remove var="msg"/>
                     </c:if>
                     
                    	<div class="card-body">
                            <form action="login-process" method="post">
                              
                                <div class="mb-3">
                                    <label for="email" class="from-label">Email Address</label>
                                    <input name="email" type="email" class="form-control" id="email" placeholder="Enter your email address">
                                </div>
                                
                                <div class="mb-3">
                                    <label for="password" class="form-label">Enter Password</label>
                                    <input name="password" type="password" class="form-control" id="password" placeholder="Enter your password">
                                </div>
                                <div class="mb-3 form-check">
                                    <input name="checkbox" type="checkbox" class="form-check-input" id="terms-and-condition">
                                    <label for="terms-and-condition" class="form-check-label">I Agreed on Terms and Condition</label>
                                </div>

                                <div class="mt-1 text-center">
                                    <button type="submit" class="btn btn-outline-warning btn-success mb-2" >Login</button>
                                </div>

                            </form>    
                        </div>
                </div>

            </div>
        </div>
    </div>
    <!--[if lt IE 7]>
            <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="#">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->

</body>

</html>