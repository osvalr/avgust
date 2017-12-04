truncate visitante;
delete from personanatural  where idpersona > 4;
alter table personanatural  auto_increment=5;
delete from persona  where idpersona > 4;
alter table persona auto_increment=5;