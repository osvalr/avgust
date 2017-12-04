<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="gestionarConfiguraciones.aspx.cs" Inherits="CartaAniversarioWebApp.gestionarConfiguraciones" %>
<!DOCTYPE html>
<html>
<head runat="server">
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>MAPFRE</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="bootstrap-3.3.5/css/bootstrap.css"/>

<!-- Optional theme -->
<link rel="stylesheet" href="bootstrap-3.3.5/css/bootstrap-theme.css"/>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script type="text/javascript" src="bootstrap-3.3.5/js/bootstrap.min.js"></script>

<script type="text/javascript" src="js/validator.min.js"></script>

<script type="text/javascript">

    $(document).ready(function () {
        listarPropiedades();
        listarEtiquetas();

        $('#formPropiedad').validator().on('submit', function (e) {

            if (e.isDefaultPrevented()) {
                return false;
            } else {

                $.ajax({
                    // En data puedes utilizar un objeto JSON, un array o un query string
                    data: $(this).serialize() + "&op=saveProperty&id=" + $('#indexList').val(),
                    //Cambiar a type: POST si necesario
                    type: "GET",
                    // Formato de datos que se espera en la respuesta
                    dataType: "json",
                    // URL a la que se enviará la solicitud Ajax
                    url: "gestionarConfiguraciones.aspx"
                })
                 .done(function (data, textStatus, jqXHR) {

                     if (data.success == true) {
                         $('#modalEditProperties').modal('hide');
                         listarPropiedades();
                     }

                 })
                 .fail(function (jqXHR, textStatus, errorThrown) {
                     if (console && console.log) {
                         console.log("La solicitud a fallado: " + textStatus);
                     }
                 });

                return false;
            }
        });

        $('#formEtiqueta').validator().on('submit', function (e) {

            if (e.isDefaultPrevented()) {
                return false;
            } else {

                $.ajax({
                    // En data puedes utilizar un objeto JSON, un array o un query string
                    data: $(this).serialize() + "&op=saveLabel&id=" + $('#indexListEtiqueta').val(),
                    //Cambiar a type: POST si necesario
                    type: "GET",
                    // Formato de datos que se espera en la respuesta
                    dataType: "json",
                    // URL a la que se enviará la solicitud Ajax
                    url: "gestionarConfiguraciones.aspx"
                })
                 .done(function (data, textStatus, jqXHR) {

                     if (data.success == true) {
                         $('#modalEditEtiqueta').modal('hide');
                         listarEtiquetas();
                     }

                 })
                 .fail(function (jqXHR, textStatus, errorThrown) {
                     if (console && console.log) {
                         console.log("La solicitud a fallado: " + textStatus);
                     }
                 });

                return false;
            }
        });

    });

    function listarPropiedades() { 
    
         $.ajax({
            // En data puedes utilizar un objeto JSON, un array o un query string
            data: {"op" : "listProperties"},
            //Cambiar a type: POST si necesario
            type: "GET",
            // Formato de datos que se espera en la respuesta
            dataType: "json",
            // URL a la que se enviará la solicitud Ajax
            url: "gestionarConfiguraciones.aspx"
        })
         .done(function( data, textStatus, jqXHR ) {

             $("#table_properties").find("tr:gt(0)").remove();

             $.each(data, function(i, obj) {

             var dataType = '';
             switch(obj.dataType) {
                case 1:
                    dataType = 'Numero entero';
                    break;
                case 2:
                    dataType = 'Numero decimal';
                    break;
                case 3:
                    dataType = 'Texto';
                    break;
                case 4:
                    dataType = 'Fecha';
                    break;
                default:
                    dataType = 'Tipo no identificado';
            }

             var newRowContent  ="<tr>"+
                  "<td>"+obj.index+"</td>"+
                  "<td>"+obj.name+"</td>"+
                  "<td>"+((obj.typeProperty == 1) ? 'Cabecera' : 'Detalle')+"</td>"+
                  "<td>"+dataType+"</td>"+
                  "<td>"+((obj.formatDate == null) ? '' : obj.formatDate)+"</td>"+
                  "<td><button type=\"button\" class=\"btn btn-danger\" onclick=\"mostrarEditarPropiedad(" + obj.nro_property + ")\">Editar</button></td>" +
              "</tr>";

              $("#table_properties tbody").append(newRowContent);

            });
         })
         .fail(function( jqXHR, textStatus, errorThrown ) {
             if ( console && console.log ) {
                 console.log( "La solicitud a fallado: " +  textStatus);
             }
        });

    }

    function obtenerPropiedad(indexList) {
        var ajax = $.ajax({
            // En data puedes utilizar un objeto JSON, un array o un query string
            data: { "op": "getProperty", "id": indexList },
            //Cambiar a type: POST si necesario
            type: "GET",
            // Formato de datos que se espera en la respuesta
            dataType: "json",
            // URL a la que se enviará la solicitud Ajax
            url: "gestionarConfiguraciones.aspx"
        });
        return ajax;
     }

     function mostrarEditarPropiedad(indexList) {

         var ajax = obtenerPropiedad(indexList);
         var propiedad = null;

         ajax.done(function (data, textStatus, jqXHR) {

             propiedad = data;
             $('#modalEditProperties').modal('show');

             $('#indexList').val(indexList);

             $('#index').val('');
             $('#name').val('');
             $('#typeProperty').val('');
             $('#dataType').val('');
             $('#formatDate').val('');

             $('#index').val(propiedad.index);
             $('#name').val(propiedad.name);
             $('#typeProperty').val(propiedad.typeProperty);
             $('#dataType').val(propiedad.dataType);
             $('#formatDate').val(propiedad.formatDate);

         });

         ajax.fail(function (jqXHR, textStatus, errorThrown) {
             if (console && console.log) {
                 console.log("La solicitud a fallado: " + textStatus);
             }
         });

     }


     function listarEtiquetas() {

         $.ajax({
             // En data puedes utilizar un objeto JSON, un array o un query string
             data: { "op": "listLabels" },
             //Cambiar a type: POST si necesario
             type: "GET",
             // Formato de datos que se espera en la respuesta
             dataType: "json",
             // URL a la que se enviará la solicitud Ajax
             url: "gestionarConfiguraciones.aspx"
         })
         .done(function (data, textStatus, jqXHR) {

             $("#table_labels").find("tr:gt(0)").remove();

             $.each(data, function (i, obj) {

                 var newRowContent = "<tr>" +
                  "<td>" + obj.text + "</td>" +
                  "<td><button type=\"button\" class=\"btn btn-danger\" onclick=\"mostrarEditarEtiqueta(" + obj.nro_text_label + ")\">Editar</button></td>" +
              "</tr>";

                 $("#table_labels tbody").append(newRowContent);

             });
         })
         .fail(function (jqXHR, textStatus, errorThrown) {
             if (console && console.log) {
                 console.log("La solicitud a fallado: " + textStatus);
             }
         });

     }

     function obtenerEtiqueta(indexList) {
         var ajax = $.ajax({
             // En data puedes utilizar un objeto JSON, un array o un query string
             data: { "op": "getLabel", "id": indexList },
             //Cambiar a type: POST si necesario
             type: "GET",
             // Formato de datos que se espera en la respuesta
             dataType: "json",
             // URL a la que se enviará la solicitud Ajax
             url: "gestionarConfiguraciones.aspx"
         });
         return ajax;
     }

     function mostrarEditarEtiqueta(indexList) {

         var ajax = obtenerEtiqueta(indexList);
         var etiqueta = null;

         ajax.done(function (data, textStatus, jqXHR) {

             etiqueta = data;
             $('#modalEditEtiqueta').modal('show');

             $('#indexListEtiqueta').val(indexList);

             $('#text').val('');

             $('#text').val(etiqueta.text);

         });

         ajax.fail(function (jqXHR, textStatus, errorThrown) {
             if (console && console.log) {
                 console.log("La solicitud a fallado: " + textStatus);
             }
         });

     }

</script>

<style type="text/css">
body {
  padding-top: 50px;
}
.starter-template {
  padding: 40px 15px;
  text-align: center;
}
</style>

</head>
<body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <a class="navbar-brand" href="#">Procesador de Cartas Aniversario</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li ><a href="procesarCartas.aspx">Procesar</a></li>
            <li class="active"><a href="gestionarConfiguraciones.aspx">Configuraciones</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <div class="container">
    <br/>

    <form id="form1" runat="server">

  <!-- Nav tabs -->
  <ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Propiedades</a></li>
    <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">Etiquetas</a></li>
  </ul>

  <!-- Tab panes -->
  <div class="tab-content">
    <div role="tabpanel" class="tab-pane active" id="home">
    
    <table id="table_properties" class="table table-striped">
      <thead>
        <tr>
          <th>Index</th>
          <th>Nombre</th>
          <th>Tipo</th>
          <th>Tipo de dato</th>
          <th>Formato (fecha)</th>
          <th></th>
        </tr>
      </thead>
      <tbody>
      </tbody>
    </table>
    
    </div>
    <div role="tabpanel" class="tab-pane" id="profile">
    
    <table id="table_labels" class="table table-striped">
      <thead>
        <tr>
          <th>Texto</th>
          <th></th>
        </tr>
      </thead>
      <tbody>
      </tbody>
    </table>
    
    </div>
  </div>

    </form>



    </div><!-- /.container -->
    

<!-- Modal -->
<div class="modal fade" id="modalEditProperties" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
    <form id="formPropiedad" class="form-horizontal" data-toggle="validator" role="form">
    <hidden id="indexList" name="indexList" />
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Editar Propiedad</h4>
      </div>
      <div class="modal-body">
        
          
          <div class="form-group">
            <label for="index" class="col-sm-2 control-label">Index</label>
            <div class="col-sm-10">
              <input type="number" min="0" class="form-control" id="index" name="index" required/>
            </div>
          </div>

          <div class="form-group">
            <label for="name" class="col-sm-2 control-label">Nombre</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="name" name="name" required/>
            </div>
          </div>

          <div class="form-group">
            <label for="typeProperty" class="col-sm-2 control-label">Tipo</label>
            <div class="col-sm-10">
                <select id="typeProperty" name="typeProperty" class="form-control" required>
                  <option value="">-- Seleccione --</option>
                  <option value="1">Cabecera</option>
                  <option value="2">Detalle</option>
                </select>
            </div>
          </div>

          <div class="form-group">
            <label for="dataType" class="col-sm-2 control-label">Tipo de dato</label>
            <div class="col-sm-10">
                <select id="dataType" name="dataType" class="form-control" required>
                  <option value="">-- Seleccione --</option>
                  <option value="1">Numero entero</option>
                  <option value="2">Numero real</option>
                  <option value="3">Texto</option>
                  <option value="4">Fecha</option>
                </select>
            </div>
          </div>

          <div class="form-group">
            <label for="formatDate" class="col-sm-2 control-label">Formato</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="formatDate" name="formatDate"/>
            </div>
          </div>

        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
        <button type="submit" class="btn btn-danger">Guardar</button>
      </div>
      </form>
    </div>
  </div>
</div>

<div class="modal fade" id="modalEditEtiqueta" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
    <form id="formEtiqueta" class="form-horizontal" data-toggle="validator" role="form">
    <hidden id="indexListEtiqueta" name="indexListEtiqueta" />
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="H1">Editar Propiedad</h4>
      </div>
      <div class="modal-body">
        
          
          <div class="form-group">
            <label for="text" class="col-sm-2 control-label">Texto</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="text" name="text" required/>
            </div>
          </div>
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
        <button type="submit" class="btn btn-danger">Guardar</button>
      </div>
      </form>
    </div>
  </div>
</div>
    
</body>
</html>
