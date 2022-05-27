<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>

<html>
    <head>
        <title>Product Management Application</title>
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous">
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-lg navbar-light bg-white">
                <div class="container-fluid">
                    <button
                        class="navbar-toggler"
                        type="button"
                        data-mdb-toggle="collapse"
                        data-mdb-target="#navbarExample01"
                        aria-controls="navbarExample01"
                        aria-expanded="false"
                        aria-label="Toggle navigation"
                        >
                        <i class="fas fa-bars"></i>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarExample01">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item active">
                                <a class="nav-link" aria-current="page" href="#">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Features</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Pricing</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">About</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <!-- Navbar -->

            <!-- Background image -->
            <div
                class="p-5 text-center bg-image"
                style="
                background-image: url('https://images.pexels.com/photos/1072179/pexels-photo-1072179.jpeg?cs=srgb&dl=pexels-c%C3%A1tia-matos-1072179.jpg&fm=jpg');
                height: 300px;
                background-repeat:none;
                "
                >
                <div class="mask" style="background-color: rgba(0, 0, 0, 0.6);">
                    <div class="d-flex justify-content-center align-items-center h-100">
                        <div class="text-white">
                            <h1 class="mb-3">Product Management Application</h1>
                            <h4 class="mb-3">Java servlet</h4>
                        </div>
                    </div>
                </div>
            </div>
        </header>
            <div class="container min-vh-100 d-flex justify-content-center">
                <div class="container min-vw-70">
                    <div class="card-body">
                        <!-- Grid row -->
                        <div class="row">
                            <!-- Grid column -->
                            <div class="col-md-12">
                                <div class="input-group md-form form-sm form-2 pl-0">
                                    <input class="form-control my-0 py-1 pl-3 purple-border" type="text" placeholder="Search something here..." aria-label="Search">
                                    <span class="input-group-addon waves-effect purple lighten-2" id="basic-addon1"><a><i class="fa fa-search white-text" aria-hidden="true"></i></a></span>
                                </div>
                            </div>
                            <!-- Grid column -->
                        </div>
                        <!-- Grid row -->
                        <!--Table-->

                        <button type="button" class="btn btn-success mt-2 mb-2 " style="float:right;"><a href="<%=request.getContextPath()%>/new" style="text-decoration: none; color: white;">Add new product</a></button>
                        <table class="table table-striped">
                            <!--Table head-->
                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col">ID</th>
                                    <th scope="col">Name</th>
                                    <th scope="col">Type</th>
                                    <th scope="col">Price</th>
                                    <th scope="col">Actions</th>
                                </tr>
                            </thead>
                            <!--Table head-->
                            <!--Table body-->
                            <tbody>
                            <c:forEach  items="${listProduct}" var="product">
                                <tr>
                                    <td scope="row">${product.id}</td>
                                    <td scope="row">${product.pdName}</td>
                                    <td scope="row">${product.ptype}</td>
                                    <td scope="row">${product.price}</td>
                                    <td scope="row">
                                        <button type="button" class="btn btn-danger"><a href="delete?id=<c:out value='${product.id}' />" style="text-decoration: none; color: white;">Delete</a></button>
                                    </td>

                                </tr>
                            </c:forEach>
                            </tbody>
                            <!--Table body-->
                        </table>
                        <div class="d-flex justify-content-center">
                            <!--Pagination -->
                            <nav class="my-4 pt-2">
                                <ul class="pagination pagination-circle pg-blue mb-0">
                                    <!--First-->
                                    <li class="page-item disabled clearfix d-none d-md-block"><a class="page-link">First</a></li>
                                    <!--Arrow left-->
                                    <li class="page-item disabled">
                                        <a class="page-link" aria-label="Previous">
                                            <span aria-hidden="true">&laquo;</span>
                                            <span class="sr-only">Previous</span>
                                        </a>
                                    </li>
                                    <!--Numbers-->
                                    <li class="page-item active"><a class="page-link">1</a></li>
                                    <li class="page-item"><a class="page-link">2</a></li>
                                    <li class="page-item"><a class="page-link">3</a></li>
                                    <li class="page-item"><a class="page-link">4</a></li>
                                    <li class="page-item"><a class="page-link">5</a></li>
                                    <!--Arrow right-->
                                    <li class="page-item">
                                        <a class="page-link" aria-label="Next">
                                            <span aria-hidden="true">&raquo;</span>
                                            <span class="sr-only">Next</span>
                                        </a>
                                    </li>
                                    <!--First-->
                                    <li class="page-item clearfix d-none d-md-block"><a class="page-link">Last</a></li>
                                </ul>
                            </nav>
                            <!--/Pagination -->
                        </div>
                        <!--Table-->
                    </div>
                </div>

                <nav id="sidebar" style="min-width: 270px; max-width: 270px; border-left: 1px solid rgba(0,0,0,.05)">
                    <div class="p-4 pt-5">
                        <h5>Categories</h5>
                        <ul class="list-unstyled components mb-5">
                            <li class="dropdown-toggle collapsed">
                                Mens Shoes
                            </li>
                        </ul>
                        <ul class="list-unstyled components mb-5">
                            <li class="dropdown-toggle collapsed">
                                Mens Shoes
                            </li>
                        </ul>
                        <ul class="list-unstyled components mb-5">
                            <li class="dropdown-toggle collapsed">
                                Mens Shoes
                            </li>
                        </ul>
                        <div class="mb-5">
                            <h5>Tag Cloud</h5>
                            <a href="" class="btn btn-outline-secondary m-1">Dish</a>
                            <a href="" class="btn btn-outline-secondary m-1">Dish</a>
                            <a href="" class="btn btn-outline-secondary m-1">Dish</a>
                            <a href="" class="btn btn-outline-secondary m-1">Dish</a>
                            <a href="" class="btn btn-outline-secondary m-1">Dish</a>
                        </div>
                        <div class="mb-5">
                            <h5>NewsLetter</h5>
                            <form action="#" class="subscribe-form">
                                <div class="form-group d-flex">
                                    <div class="icon"></div>
                                    <input class="form-control" placeholder="Enter Email Address"></input>
                                </div>
                            </form>
                        </div>
                    </div>
                </nav>                   

            </div>
                       
    </body>
</html>
