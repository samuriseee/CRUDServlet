<%-- 
   Document   : productForm
   Created on : May 26, 2022, 10:46:10 PM
   Author     : Kiet
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<html>
    <head>
        <title>User Management Application</title>
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous">
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-md navbar-dark"
                 style="background-color: blue">
                <div>
                    <a href="https://www.xadmin.net" class="navbar-brand"> User Management Application </a>
                </div>
                <ul class="navbar-nav">
                    <li><a href="<%=request.getContextPath()%>/list"
                           class="nav-link">Products</a></li>
                </ul>
            </nav>
        </header>
        <br>
        <div class="container col-md-5">
            <div class="card">
                <div class="card-body">
                    <form action="insert" method="post">
                        <caption>
                            <h2>
                                Add New Product
                            </h2>
                        </caption>
                        <fieldset class="form-group">
                            <label>Product name</label> <input type="text"
                                                               class="form-control"
                                                               name="pdName" required="required">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Product type</label> <input type="text"
                                                               class="form-control"
                                                               name="ptype">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Product price</label> <input type="number"
                                                                class="form-control"
                                                                name="price">
                        </fieldset>
                        <button type="submit"  name="insert" class="btn btn-success">Save</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>