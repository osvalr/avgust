<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div style="width:980px;margin: 0 auto;">

<h1>Registro de Visitantes<br /><span> 
	<s:property value="areanatural.categoriaanp.descategoriaanp" />  
	<s:property value="areanatural.desareanatural" />
	</span></h1>

<br />

<s:form id="formRegistroVisitante" method="post" theme="simple">

<div class="l ContentDP">
<fieldset>
		<legend><strong>Datos Personales:</strong></legend>			
			
			<div class="l lb_1"><label>Nombres:</label></div>
			<div class="l"><s:textfield name="visitante.var_nombre" key="visitante.var_nombre" value="" size="25" cssClass="content valid" /></div>
			<div class="clear"></div>
			<div class="l lb_1"><label>Ap. Paterno:</label></div>
			<div class="l"><s:textfield name="visitante.var_ape_paterno" value="" size="15" cssClass="content valid" /></div>
			<div class="clear"></div>
			<div class="l lb_1"><label class="l_1">Ap. Materno:</label></div>
			<div class="l"><s:textfield name="visitante.var_ape_materno" value="" size="15" /></div> <%--cssClass="content valid" --%>
			<div class="clear"></div>
			<div class="l lb_1">
			<label>Tipo Doc.:</label>
			</div>
			<div class="l">
				<s:select listKey="idtipo" 
				listValue="abrevtipo"
				name="visitante.tipodocumento.idtipo"
				theme="simple"
       			headerKey="" headerValue=""
       			list="listatipodocumento"
       			cssClass="selectdoc"
       			onchange="tipodocumento(this.value)"
       			/>
       			<%-- cssClass="select valid selectdoc" --%>
       			
			</div>
			<div class="clear"></div>
			<div class="l lb_1"><label>Numero Doc.:</label></div>
<%-- 			<div class="l divnumdoc"><s:textfield name="visitante.var_num_documento" value="" size="15" cssClass="textdoc" /></div> cssClass="content valid textdoc" --%>
 			<div class="l divnumdoc"><s:textfield name="visitante.var_num_documento" size="15" disabled="true" cssClass="textdoc" /></div>
			<div class="clear"></div>				
			<div class="l lb_1">
			<label>Genero:</label>
			</div>
			<div class="l">
				<s:select listKey="idtipo" 
				listValue="abrevtipo"
				name="visitante.genero.idtipo"
				theme="simple"
       			headerKey="" headerValue=""
       			list="listatipogenero"
       			/>
       			<%-- cssClass="select valid" --%>
			</div>
			<div class="clear"></div>
			<div class="l lb_1"><label>Edad:</label></div>
			<div class="l"><s:textfield name="visitante.int_edad" size="5" cssClass="number onlyDigits" value="" /></div> <%--cssClass="number valid onlyDigits" --%>
			<div class="clear"></div>
			<div class="l lb_1"><label>Pa&iacute;s:</label></div>
			<div class="l">
			<s:select listKey="idpais"
				listValue="nompais"
				name="visitante.pais.idpais"
				theme="simple"
       			headerKey="" headerValue=""
       			list="listapais"
       			cssStyle="width: 150px;" />
       			
       			<%-- cssClass="select valid" --%>
				<%-- required="true" --%>
       			
       			
			</div>
			<div class="clear"></div>
			<div class="l lb_1"><label>Profesion:</label></div>
			<div class="l"><s:textfield name="visitante.var_profesion" value="" size="30" /></div> <%--cssClass="content valid" --%>
			<div class="clear"></div>			
			<div class="l lb_1"><label>Correo:</label></div>
			<div class="l"><s:textfield name="visitante.var_correo" value="" size="30" /></div> <%--cssClass="mail valid" --%>
			<div class="clear"></div>
			<div class="l lb_1"><label>Fecha Visita:</label></div>
			<div class="l"><s:textfield id="fechanigreso" name="visitante.dte_fec_ingreso" theme="simple" size="10" cssClass="dateDMY_ valid datepicker" readonly="true" /></div> <%--cssClass="dateDMY_ valid datepicker" --%>
			<div class="clear"></div>
</fieldset> 
</div>
<div class="l">
	<div>
		<fieldset>
				<legend><strong>Motivo de Visita</strong></legend>
				<div>
<%-- 					<s:textarea name="visitante.txt_mot_visita" cssClass="txtArea"></s:textarea> --%>
					
					<s:select listKey="idtipo" 
				listValue="nombretipo"
				name="visitante.motivovisita.idtipo"
				theme="simple"
       			headerKey="" headerValue=""
       			list="listamotivovisita"
       			/>
				<%-- cssClass="select valid selectdoc" --%>	
				</div>		
		</fieldset>
	</div>
	<div>
		<fieldset>
				<legend><strong>Comentario:</strong></legend>
					<div>
						<s:textarea name="visitante.txt_comentario" cssClass="txtArea"></s:textarea>
					</div>
		</fieldset>
	</div>
	<div>
		<fieldset>
				<legend><strong>Recomendaci&oacute;n:</strong></legend>
					<div>
						<s:textarea name="visitante.txt_recomendacion" cssClass="txtArea"></s:textarea>
					</div>	
		</fieldset>
	</div>
</div>
<div class="clear"></div>
<div>
<fieldset class="fls_btn">

<div class="center divBtnReg"><input type="button" value="Guardar" class="submit3" id="btnInsertaVisitante" /></div>
<div class="right divTotReg" >T. Registrados: <label id="campoTotalReg"><s:property value="totalvisitantesxanp" /></label></div>

</fieldset>
</div>
</s:form>

</div>

<!-- <div class="exitomsg msgExito">Se agreg&oacute; con &eacute;xito</div> -->
<!-- <div class="errormsg msgError">No se pudo ejecutar la acci&oacute;n</div>	 -->