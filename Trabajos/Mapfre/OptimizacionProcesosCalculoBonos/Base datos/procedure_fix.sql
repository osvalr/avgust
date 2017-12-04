CREATE OR REPLACE procedure sp_fix_poliza_ramo_809_810

as

cursor cursor_ramo_809 is
select 
*
from 
( 
select num_poliza, fec_efec_poliza, 
   to_char(add_months(fec_efec_poliza,-12),'ddmmyyyy') as fec_ini_efecto_temporal,   
   sf_recupera_dv_vig(cod_cia, num_poliza, 0, 1, 'FEC_INI_EFECTO', cod_ramo, 'VAL') as fec_ini_efecto_dv 
from a2000030 a 
where cod_cia=2 and num_poliza like '809%' and num_spto=0 
   and not exists (select 1 from a2000030 b where b.cod_cia=a.cod_cia and b.num_poliza=a.num_poliza and b.mca_poliza_anulada='S' and b.mca_spto_anulado='N' and b.mca_provisional='N') 
) where fec_ini_efecto_temporal <> fec_ini_efecto_dv;


cursor cursor_ramo_810 is
select 
*
from 
( 
select num_poliza, fec_efec_poliza, 
   to_char(add_months(fec_efec_poliza,-12),'ddmmyyyy') as fec_ini_efecto_temporal,   
   sf_recupera_dv_vig(cod_cia, num_poliza, 0, 1, 'FEC_INI_EFECTO', cod_ramo, 'VAL') as fec_ini_efecto_dv 
from a2000030 a 
where cod_cia=2 and num_poliza like '810%' and num_spto=0 
   and not exists (select 1 from a2000030 b where b.cod_cia=a.cod_cia and b.num_poliza=a.num_poliza and b.mca_poliza_anulada='S' and b.mca_spto_anulado='N' and b.mca_provisional='N') 
) where fec_ini_efecto_temporal <> fec_ini_efecto_dv;


BEGIN


   FOR r in cursor_ramo_809
   LOOP
   
        update a2000020_809 set val_campo= r.fec_ini_efecto_temporal where cod_cia=2 and num_poliza= r.num_poliza and cod_campo='FEC_INI_EFECTO';  
   
   END LOOP;

   FOR r in cursor_ramo_810
   LOOP
   
        update a2000020_810 set val_campo= r.fec_ini_efecto_temporal where cod_cia=2 and num_poliza= r.num_poliza and cod_campo='FEC_INI_EFECTO';   
   
   END LOOP;
   
   --commit;

END;

