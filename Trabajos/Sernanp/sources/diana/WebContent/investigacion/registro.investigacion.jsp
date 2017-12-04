<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page pageEncoding="UTF-8"%>     
<h1>Solicitud de Autorización para realizar investigación.</h1>
<form method="post" action="">

	<fieldset>
		<div >
			<label>Jefatura</label>
			<span><input name="jefatura" type="text" value="" /></span>
			<small>
				(Señalar la denominación del Área Natural Protegida, y de no contar con Jefatura, 
				dirigirse a la Dirección de Gestión de las Áreas Naturales Protegidas)
			</small>
		</div>
		<div >
			<label>Nombre</label>
			<span><input name="nombre" type="text" value="" /></span>
			<small>
				(Denominación o razón social)
			</small>
		</div>
		<div >
			<label>Documento de Identidad</label>
			<span>
				<select name="tipodoc">
					<option value="">Elegir...</option>
				</select>
				<input name="doc" type="text" value="" />
			</span>
			<small>
				(Documento de Identidad o Registro Único de Contribuyentes)
			</small>
		</div>
		<div>
			<label>Domicilio</label>
			<span>
				<input name="nombre" type="text" value="" />
			</span>
			<small>
				(Colocar Vía, Número, Zona)
			</small>
		</div>
		<div>
			<label>Departamento</label>
			<span>
				<select name="departamento">
					<option value="">Elegir...</option>
				</select>
			</span>
		</div>
		<div>
			<label>Provincia</label>
			<span>
				<select name="provincia">
					<option value="">Elegir...</option>
				</select>
			</span>
		</div>
		<div>
			<label>Distrito</label>
			<span>
				<select name="distrito">
					<option value="">Elegir...</option> 
				</select>
			</span>
		</div> 
		<div>
			<label>Correo Electrónico</label>
			<span>
				<input name="email" type="text" value="" />
			</span> 
		</div>
		<div>
			<label>Teléfono Fijo</label>
			<span>
				<input name="telefono" type="text" value="" />
			</span> 
		</div>
		<div>
			<label>Teléfono Móvil</label>
			<span>
				<input name="movil" type="text" value="" />
			</span> 
		</div>
	</fieldset>
	<fieldset>
		<div>
			<label>Representado por:</label>
			<span><input name="nombre" type="text" value="" /></span>
		</div>
		<div >
			<label>Documento de Identidad del Representante:</label>
			<span>
				<select name="tipodoc">
					<option value="">Elegir...</option>
				</select>
				# <input name="doc" type="text" value="" />
			</span>
			<small>
				(Documento de Identidad o Registro Único de Contribuyentes)
			</small>
		</div>
		<div>
			<label>Documento de Representación:</label>
			<span>
				<input name="doc" type="text" value="" />
			</span>
			<small>
				(Indicar el documento a través del cual se otorga el poder)
			</small>
		</div>
	</fieldset>
	<fieldset>
		<div>
			<label>Procedimiento TUPA N°:</label>
			<span>
				<input name="tupa" type="text" value="" />
			</span>
			<small>
				(Indicar el número del Texto Único de Procedimientos Administrativos (TUPA) del SERNANP)
			</small>
		</div>
		<div>
			<label>Investigación:</label>
			<span>
				<input name="tupa" type="text" value="" />
			</span>
			<small>
				(Colocar la clase de investigación solicitada)
			</small>
		</div>
		<div>
			<label>Zona de Investigación:</label>
			<span>
				<input name="tupa" type="text" value="" />
			</span>
			<small>
				(Colocar la zona del ANP en la que se llevará a cabo la investigación)
			</small>
		</div>
		
		<div>
			<label>Periodo:</label>
			<span>
				Desde
				<input name="tupa" class="datepicker" type="text" value="" size="10" />
				Hasta
				<input name="tupa" class="datepicker" type="text" value="" size="10" />
			</span>
			<small>
				(Fechas entre las cuales se llevará a cabo la investigación)
			</small>
		</div>
		
		<div>
			<label>Solicitud Adicional:</label>
			<span>
				<textarea rows="5" cols="60">
				</textarea>
			</span>
			<small> 
				<br />(Solicitud con el fin de desarrollar el Plan de investigación)
			</small>
		</div>  
		<div>
			<input name="tupa" type="checkbox" value="1" /> 
			Declaro bajo juramento tener pleno conocimiento de los alcances de la Resolución
			 Presidencial Nº <input type="text" name="resolucion" />,  la misma que aprueba la Directiva que regula las 
			 Investigaciones al Interior de las Áreas Naturales Protegidas, 
			 y por ende declaro dar fiel cumplimiento a las disposiciones señaladas en 
			 la misma.
		</div> 
	</fieldset>
	<div class="buttons">
		
	</div>
</form>