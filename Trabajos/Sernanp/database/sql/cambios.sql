	ALTER TABLE personal.t_postulante_personal_archivo ADD COLUMN int_id_tipo_documento int;
	ALTER TABLE sernanp.t_postulante_cnv_area_org ADD COLUMN srl_id_archivo int;

update sernanp.personanatural  set numerodoc = null
where trim(numerodoc) = trim('');

update sernanp.personanatural  set ruc = null
where trim(ruc) = trim('');

update sernanp.persona  set ruc = null
where trim(ruc) = trim('');
	