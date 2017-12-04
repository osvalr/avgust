<%@ taglib prefix="s" uri="/struts-tags"%>

<fieldset class="row">
			<legend>Tipo Turismo</legend>
			<div class="checkboxes" >
			<s:set var="i" value="0" />
				<s:iterator status="st" value="listaTipoturismo">
					<input name="fichaturismo.listaTipoturismoFichaturismo[<s:property value="#i" />].tipoturismo.idtipoturismo" 
					 class="dom tipoturismo" 
						title="<s:property value='nombretipoturismo'/>"  
						type="checkbox" id="tipoturismo_<s:property value='#i'/>"
						value="<s:property value='idtipoturismo'/>"     />
					<label for="tipoturismo_<s:property value='#i'/>"  
						class="checkboxLabel"><s:property value='nombretipoturismo'/></label>
				  <s:set var="i" value="#i+1" /> 
				</s:iterator>
				    
			</div> 
</fieldset>