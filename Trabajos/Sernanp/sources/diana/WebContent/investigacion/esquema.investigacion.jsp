<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page pageEncoding="UTF-8"%>     
<h1>Solicitud de Autorización para realizar investigación.</h1>
<form method="post" action="">

	<fieldset>
		<div >
			<label>Título</label>
			<span><input name="jefatura" type="text" value="" /></span>
			<small>
				(Título de la investigación a desarrollar)
			</small>
		</div> 
		<div >
			<label>Introducción </label>
			<span>
				<textarea rows="5" cols="50"></textarea><br />
			</span>
			<small>
				(Título de la investigación a desarrollar)
			</small>
		</div> 
		<div >
			<label>Clase de investigación </label>
			<span>
				<select>
					<option value="">Elegir...</option>
				</select>
			</span>  
		</div> 
		<div >
			<label>Objetivos Generales </label>
			<span>
				<textarea rows="5" cols="50"></textarea><br />
			</span>
			<small>
				(Debidamente Detallados)
			</small>
		</div> 
		<div >
			<label>Objetivos Específicos </label>
			<span>
				<textarea rows="5" cols="50"></textarea><br />
			</span>
			<small>
				(Debidamente Detallados)
			</small>
		</div> 
		<div>
			<label>Hipótesis </label>
			<span>
				<textarea rows="5" cols="50"></textarea><br />
			</span> 
		</div>
		<div >
			<label>Objetivos Específicos </label>
			<span>
				<textarea rows="5" cols="50"></textarea><br />
			</span>
			<small>
				(Debidamente Detallados)
			</small>
		</div> 
	</fieldset>
	<div class="buttons">
		
	</div>
</form>