<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="procesarCartas.aspx.cs" Inherits="CartaAniversarioWebApp.procesarCartas" %>
<html>
<head id="Head1" runat="server">
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

    });


    function listarCartas() {

        $.ajax({
            // En data puedes utilizar un objeto JSON, un array o un query string
            data: { "op": "listCartaCab" },
            //Cambiar a type: POST si necesario
            type: "GET",
            // Formato de datos que se espera en la respuesta
            dataType: "json",
            // URL a la que se enviará la solicitud Ajax
            url: "procesarCartas.aspx"
        })
         .done(function (data, textStatus, jqXHR) {

             $("#table_cartas").find("tr:gt(0)").remove();

             $.each(data, function (i, obj) {

                 var date = new Date(parseInt(obj.fechaFinaliza.substr(6)));

                 var newRowContent = "<tr>" +
                  "<td>" + obj.numeroPoliza + "</td>" +
                  "<td>" + date.toLocaleDateString() + "</td>" +
                  "<td>" + obj.asegurado + "</td>" +
                  "<td>" + obj.agente + "</td>" +
                  "<td><button type=\"button\" class=\"btn btn-danger\" onclick=\"mostrarDetalleCarta(" + i + ")\">Ver Detalle</button></td>" +
              "</tr>";

                 $("#table_cartas tbody").append(newRowContent);
             });
         })
         .fail(function (jqXHR, textStatus, errorThrown) {
             if (console && console.log) {
                 console.log("La solicitud a fallado: " + textStatus);
             }
         });

     }

     function obtenerCarta(indexList) {
         var ajax = $.ajax({
             // En data puedes utilizar un objeto JSON, un array o un query string
             data: { "op": "getCarta", "indexList": indexList },
             //Cambiar a type: POST si necesario
             type: "GET",
             // Formato de datos que se espera en la respuesta
             dataType: "json",
             // URL a la que se enviará la solicitud Ajax
             url: "procesarCartas.aspx"
         });
         return ajax;
     }

     function mostrarDetalleCarta(indexList) {

         var ajax = obtenerCarta(indexList);
         var carta = null;

         

         ajax.done(function (data, textStatus, jqXHR) {

             carta = data;

             $('#modalDetalleCarta').modal('show');

             var fechaFinaliza = new Date(parseInt(carta.fechaFinaliza.substr(6)));
             var fechaDesde = new Date(parseInt(carta.fechaDesde.substr(6)));
             var fechaHasta = new Date(parseInt(carta.fechaHasta.substr(6)));
             var fechaEfectiva = new Date(parseInt(carta.fechaEfectiva.substr(6)));

             $('#fechaFinaliza').val(fechaFinaliza.toLocaleDateString());
             $('#numeroPoliza').val(carta.numeroPoliza);
             $('#fechaDesde').val(fechaDesde.toLocaleDateString());
             $('#fechaHasta').val(fechaHasta.toLocaleDateString());
             $('#fechaEfectiva').val(fechaEfectiva.toLocaleDateString());
             $('#beneficioMuerteBasico1').val(carta.beneficioMuerteBasico1);
             $('#beneficioMuerteBasico2').val(carta.beneficioMuerteBasico2);
             $('#asegurado').val(carta.asegurado);
             $('#agente').val(carta.agente);
             $('#contratante').val(carta.contratante);
             $('#localidadContratante').val(carta.localidadContratante);
             $('#DireccionContratante').val(carta.DireccionContratante);
             $('#valorEfectivoAcumulado1').val(carta.valorEfectivoAcumulado1);
             $('#valorEfectivoAcumulado2').val(carta.valorEfectivoAcumulado2);
             $('#balancePrestamo1').val(carta.balancePrestamo1);
             $('#balancePrestamo2').val(carta.balancePrestamo2);
             $('#cargosRescate1').val(carta.cargosRescate1);
             $('#cargosRescate2').val(carta.cargosRescate2);
             $('#valorEfectivoCorriente1').val(carta.valorEfectivoCorriente1);
             $('#valorEfectivoCorriente2').val(carta.valorEfectivoCorriente2);

             $("#table_carta_items").find("tr:gt(0)").remove();

             $.each(carta.listCartaDet, function (i, obj) {

                 var fechaAnterior = new Date(parseInt(obj.fechaAnterior.substr(6)));

                 var newRowContent = "<tr>" +
                  "<td>" + fechaAnterior.toLocaleDateString() + "</td>" +
                  "<td>" + obj.primaIngresada + "</td>" +
                  "<td>" + obj.cargoAdministrativo + "</td>" +
                  "<td>" + obj.costoSeguro + "</td>" +
                  "<td>" + obj.interesMonto + "</td>" +
                  "<td>" + obj.interesPorcentaje + "</td>" +
                  "<td>" + obj.rescateParcialPrestamo + "</td>"
                 "</tr>";

                 $("#table_carta_items tbody").append(newRowContent);

             });

         });

         ajax.fail(function (jqXHR, textStatus, errorThrown) {
             if (console && console.log) {
                 console.log("La solicitud a fallado: " + textStatus);
             }
         });

     }


     function confirmar() {
         var r = confirm("Estas seguro de continuar?");

         return r;
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
            <li class="active"><a href="procesarCartas.aspx">Procesar</a></li>
            <li><a href="gestionarConfiguraciones.aspx">Configuraciones</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <div class="container">
    <br/>

    <form id="form1" runat="server">

    <div id="div_error" runat ="server" visible="false" class="alert alert-danger" role="alert">
        
    </div>

  <!-- Nav tabs -->
  <ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Cartas</a></li>
  </ul>
  <br />

      <form id="form2" class="form-horizontal" data-toggle="validator" role="form">

          <div class="form-group">
            <label for="fechaFinaliza" class="col-sm-2 control-label">Documento</label>
            <div class="col-sm-6">
         
                <asp:FileUpload ID="fu_doc" class="form-control" runat="server" />
                <%--<asp:RegularExpressionValidator ID="ValidateEx" runat="server"   ValidationExpression="^.*\.(doc|DOC|docx|DOCX)$" ControlToValidate="fu_doc" ErrorMessage="Solo se permite archivos con extesion .doc y .docx"></asp:RegularExpressionValidator>--%>

            </div>
            <div class="col-sm-4">
                <asp:Button ID="Button1" runat="server" Text="Procesar" class="btn btn-danger" onclick="btnProcesar_Click" OnClientClick="return confirmar()" />
                <asp:Button ID="btnBorrarCarga" runat="server" Text="Borrar Carga" class="btn btn-danger" onclick="btnBorrarCarga_Click" OnClientClick="return confirmar()"/>
                <asp:Button ID="btnGrabar" runat="server" Text="Grabar" class="btn btn-danger" onclick="btnGrabar_Click" OnClientClick="return confirmar()"/>
            </div>
          </div>

      </form>

    <br />
    <br />

  <div class="tab-content">
    <div role="tabpanel" class="tab-pane active" id="home">
    


    <table id="table_cartas" class="table table-striped">
      <thead>
        <tr>
          <th>Numero Poliza</th>
          <th>Fecha Finaliza</th>
          <th>Asegurado</th>
          <th>Agente</th>
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
<div class="modal fade" id="modalDetalleCarta" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" style="width: 1024px;" role="document">
    <div class="modal-content">
    <form id="formPropiedad" class="form-horizontal" data-toggle="validator" role="form">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Información de Carta</h4>
      </div>
      <div class="modal-body">
        
          
          <div class="form-group">
            <label for="fechaFinaliza" class="col-sm-2 control-label">Fecha finaliza:</label>
            <div class="col-sm-2">
              <input type="text" class="form-control" id="fechaFinaliza"/>
            </div>
          </div>

          <div class="form-group">
            <label for="numeroPoliza" class="col-sm-2 control-label">Número de Poliza :</label>
            <div class="col-sm-4">
              <input type="text" class="form-control" id="numeroPoliza"/>
            </div>
          </div>

          <div class="form-group">

            <label for="fechaEfectiva" class="col-sm-2 control-label">Fecha Efectiva :</label>
            <div class="col-sm-2">
              <input type="text" class="form-control" id="fechaEfectiva"/>
            </div>

            <label for="fechaDesde" class="col-sm-1 control-label">Desde:</label>
            <div class="col-sm-2">
              <input type="text" class="form-control" id="fechaDesde"/>
            </div>

            <label for="fechaHasta" class="col-sm-1 control-label">Hasta:</label>
            <div class="col-sm-2">
              <input type="text" class="form-control" id="fechaHasta"/>
            </div>

          </div>

          <div class="form-group">
            <label for="asegurado" class="col-sm-2 control-label">Asegurado :</label>
            <div class="col-sm-6">
              <input type="text" class="form-control" id="asegurado"/>
            </div>
          </div>

          <div class="form-group">
            <label for="agente" class="col-sm-2 control-label">Agente :</label>
            <div class="col-sm-6">
              <input type="text" class="form-control" id="agente"/>
            </div>
          </div>

          <div class="form-group">
            <label for="contratante" class="col-sm-2 control-label">Nombre pagador :</label>
            <div class="col-sm-6">
              <input type="text" class="form-control" id="contratante"/>
            </div>
          </div>

          <div class="form-group">
            <label for="localidadContratante" class="col-sm-2 control-label">Localidad :</label>
            <div class="col-sm-6">
              <input type="text" class="form-control" id="localidadContratante"/>
            </div>
          </div>

          <div class="form-group">
            <label for="nombreDireccionPagador" class="col-sm-2 control-label">Dirección :</label>
            <div class="col-sm-6">
              <textarea class="form-control" id="DireccionContratante">  </textarea>
            </div>
          </div>

          <div class="form-group">
            <label for="beneficioMuerteBasico1" class="col-sm-4 control-label">Beneficio de Muerte Básico :</label>
            <div class="col-sm-4">
              <input type="text" class="form-control" id="beneficioMuerteBasico1"/>
            </div>
            <div class="col-sm-4">
              <input type="text" class="form-control" id="beneficioMuerteBasico2"/>
            </div>
          </div>

          <div class="form-group">
            <label for="valorEfectivoAcumulado1" class="col-sm-4 control-label">Valor Efectivo Acumulado :</label>
            <div class="col-sm-4">
              <input type="text" class="form-control" id="valorEfectivoAcumulado1"/>
            </div>
            <div class="col-sm-4">
              <input type="text" class="form-control" id="valorEfectivoAcumulado2"/>
            </div>
          </div>

          <div class="form-group">
            <label for="balancePrestamo1" class="col-sm-4 control-label">( Menos )  Balance de Préstamo :</label>
            <div class="col-sm-4">
              <input type="text" class="form-control" id="balancePrestamo1"/>
            </div>
            <div class="col-sm-4">
              <input type="text" class="form-control" id="balancePrestamo2"/>
            </div>
          </div>

          <div class="form-group">
            <label for="cargosRescate1" class="col-sm-4 control-label">( Menos )  Cargos por Rescate :</label>
            <div class="col-sm-4">
              <input type="text" class="form-control" id="cargosRescate1"/>
            </div>
            <div class="col-sm-4">
              <input type="text" class="form-control" id="cargosRescate2"/>
            </div>
          </div>

          <div class="form-group">
            <label for="valorEfectivoCorriente1" class="col-sm-4 control-label">Valor Efectivo Corriente :</label>
            <div class="col-sm-4">
              <input type="text" class="form-control" id="valorEfectivoCorriente1"/>
            </div>
            <div class="col-sm-4">
              <input type="text" class="form-control" id="valorEfectivoCorriente2"/>
            </div>
          </div>

          <table id="table_carta_items" class="table table-striped">
          <thead>
            <tr>

              <th>Meses Anteriores</th>
              <th>Primas Ingresadas</th>
              <th>Cargos Administrativos</th>
              <th>Costo Seguro</th>
              <th>Intereses Monto</th>
              <th>Intereses Porcentaje</th>
              <th>Rescate Parcial Prestamo</th>

            </tr>
          </thead>
          <tbody>
          </tbody>
        </table>
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
      </div>
      </form>
    </div>
  </div>
</div>
  
  
<div id="modalLoad" class="modal fade" tabindex="-1" role="dialog">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      Cargando....
    </div>
  </div>
</div>
  
</body>
</html>