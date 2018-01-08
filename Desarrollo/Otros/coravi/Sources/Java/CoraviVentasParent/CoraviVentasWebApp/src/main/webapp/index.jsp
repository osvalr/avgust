<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html ng-app="MyApp">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="resources/favicon.ico">

    <title>CORAVI SAC - MODULO DE VENTAS</title>

    <script src="https://use.fontawesome.com/8331d25879.js"></script>

    <!-- Bootstrap core CSS -->
    <link href="resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="resources/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="resources/css/dashboard.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <script src="resources/js/ie-emulation-modes-warning.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
    <script src="app/app.js"></script>
    <script src="app/service/CommonService.js"></script>
    <script src="app/GestionarArticulo/controller/GestionarArticuloController.js"></script>

    <style>
        .username.ng-valid {
            background-color: lightgreen;
        }
        .username.ng-dirty.ng-invalid-required {
            background-color: red;
        }
        .username.ng-dirty.ng-invalid-minlength {
            background-color: yellow;
        }

        .email.ng-valid {
            background-color: lightgreen;
        }
        .email.ng-dirty.ng-invalid-required {
            background-color: red;
        }
        .email.ng-dirty.ng-invalid-email {
            background-color: yellow;
        }

    </style>

</head>
<body class="ng-cloak">

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">CORAVI VENTAS</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">Dashboard</a></li>
                <li><a href="#">Settings</a></li>
                <li><a href="#">Profile</a></li>
                <li><a href="#">Help</a></li>
            </ul>
            <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="Search...">
            </form>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active"><a href="#">Overview <span class="sr-only">(current)</span></a></li>
                <li><a href="#">Reports</a></li>
                <li><a href="#">Analytics</a></li>
                <li><a href="#">Export</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="">Nav item</a></li>
                <li><a href="">Nav item again</a></li>
                <li><a href="">One more nav</a></li>
                <li><a href="">Another nav item</a></li>
                <li><a href="">More navigation</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="">Nav item again</a></li>
                <li><a href="">One more nav</a></li>
                <li><a href="">Another nav item</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">Gestionar Articulos</h1>
            <div class="generic-container" ng-controller="GestionarArticuloController as ctrl">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <span class="lead">Formulario de Edición</span>
                    </div>
                    <br/>

                    <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Código</label>
                            <div class="col-sm-5">
                                <input type="text" ng-model="ctrl.model.codigo_articulo" name="codigo_articulo" class="username form-control input-sm" readonly/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Nombre</label>
                            <div class="col-sm-5">
                                <input type="text" ng-model="ctrl.user.codigo_articulo" name="codigo_articulo" class="username form-control input-sm" placeholder="Enter your codigo_articulo" required ng-minlength="3"/>
                                <div class="has-error" ng-show="myForm.$dirty">
                                    <span ng-show="myForm.uname.$error.required">This is a required field</span>
                                    <span ng-show="myForm.uname.$error.minlength">Minimum length required is 3</span>
                                    <span ng-show="myForm.uname.$invalid">This field is invalid </span>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-5">
                                <button type="button" type="submit" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid"><i class="fa fa-floppy-o" aria-hidden="true"></i> Grabar</button>
                                <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine"><i class="fa fa-refresh" aria-hidden="true"></i> Reset Form</button>
                            </div>
                        </div>
                    </form>

                </div>
                <div class="panel panel-default">
                    <!-- Default panel contents -->
                    <div class="panel-heading"><span class="lead">Listado de Resultados</span></div>
                    <div class="tablecontainer">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>ID.</th>
                                <th>Name</th>
                                <th>Address</th>
                                <th>Email</th>
                                <th width="20%"></th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr ng-repeat="u in ctrl.response.records">
                                <td><span ng-bind="u.id_articulo"></span></td>
                                <td><span ng-bind="u.codigo_articulo"></span></td>
                                <td><span ng-bind="u.nombre_articulo"></span></td>
                                <td><span ng-bind="u.descrip_estado"></span></td>
                                <td>
                                    <button type="button" ng-click="ctrl.edit(u.id)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="ctrl.remove(u.id)" class="btn btn-danger custom-width">Remove</button>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="resources/js/jquery.min.js"><\/script>')</script>
<script src="resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
<script src="resources/js/holder.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="resources/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>

