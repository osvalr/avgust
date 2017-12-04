CREATE OR REPLACE PROCEDURE TRON2000.sp_genbdpb_2015_mpe(p_anio_ult_bono NUMBER,p_num_poliza varchar2)
IS
--
  l_anual_sil VARCHAR2(3);
  l_existe    VARCHAR2(1);
  l_num_poliza VARCHAR2(13);
  --
  
   /* Inicio JRaffo 18/09/2015 */
  
  l_cod_modalidad VARCHAR2(13);
  l_fec_ini_efecto varchar(100);
  l_num_poliza_antigua varchar(100);
  l_mca_sexo varchar(100);
  l_fec_validez     varchar2(100);
  l_prima_comercial number(10,2);
  
  /* Fin JRaffo 18/09/2015 */
  
  /* INI - LRIOSR - NUEVA FORMA DE RECUPERAR DATOS */
  l_anio NUMBER(4);

  CURSOR c_bonos_trn
  IS
    SELECT a.num_poliza as NP,
           b.codmodal as MOD,
           a.cod_moneda,
           a.val_intecni int_tecnico,
           a.val_excesoit exceso_it,
           a.mca_sexo SEXO,
           TO_CHAR(a.fec_ini_pol,'yyyymmdd') FEFECTO,
           DECODE(a.imp_porsobre+a.imp_sobr_enf+a.imp_sobr_prf,0,'N','S') TARADO,
           a.imp_porsobre PORSOBRE,
           a.imp_sobr_enf SOBREENF,
           a.imp_sobr_prf SOBREPRO,
           a.val_edad_ini X,
           a.val_dur_pri M,
           a.val_fpago FP,
           a.val_anualidad T,
           a.imp_capvipol C,
           a.imp_capmupol CM,
           a.imp_rbalantp RES_BAL_PO,
           a.imp_rbalantb RESBONO,
           a.imp_peso_teso PESOTESO,
           a.imp_rentabil RENT_TOTAL,
           a.imp_pupor1ca PU_X_MIL,
           DECODE(a.cod_ramo,604,a.imp_capmuer,a.imp_capvida) BONO_ANUAL,
           DECODE(a.cod_ramo,604,a.imp_camuboan+a.imp_capmuer,a.imp_caviboan+a.imp_capvida) BONO_ACUM
           ,a.num_silvia
           ,a.anio
           ,a.cod_ramo
           ,a.fec_ini_pol
           /* Inicio JRaffo 10/09/2015 */
           ,a.cod_cob
           ,a.cod_modalidad
           /* Inicio JRaffo 10/09/2015 */
      FROM a2300250_mpe a, taeqcovi_2 b
     WHERE a.cod_cia = 2
       and a.num_poliza = NVL(l_num_poliza,a.num_poliza)--'6010510100215'
       and a.anio = l_anio
       /* ==================== INI - EXCEPTUADO POR ANUALIDAD DUPLICADA ==================== */
       AND a.num_poliza NOT IN ('6010510100090','6020510100152','6020510100962','6050510100009','6070510100511','6070510101000')
       /* ==================== FIN - EXCEPTUADO POR ANUALIDAD DUPLICADA ==================== */
       AND b.cod_cia=a.cod_cia
       AND b.cod_ramo=a.cod_ramo
       AND b.cod_modalidad=a.cod_modalidad
       AND b.cod_cob=a.cod_cob
       AND b.fec_validez = (SELECT MAX(fec_validez) FROM taeqcovi_2 i
                             WHERE i.cod_cia = b.cod_cia
                               AND i.cod_ramo = b.cod_ramo
                               AND i.cod_modalidad = b.cod_modalidad
                               AND i.cod_cob = b.cod_cob
                               AND i.fec_validez <= a.fec_ini_pol)
       AND exists(select 'S' from a2300250_mpe where cod_cia = 2 and num_poliza = a.num_poliza and anio = p_anio_ult_bono)
     ORDER BY cod_ramo, fec_ini_pol ASC, np;
  --
  CURSOR c_bonos_rpr
  IS
    SELECT
      /* INI - LRIOS 04/12/2012 */
      np, mod, cod_moneda, int_tecnico, exceso_it, sexo, fefecto, tarado, porsobre, sobreenf, sobrepro, x, m, fp, t, c, cm,
      res_bal_po, resbono, pesoteso, rent_total, pu_x_mil, bono_anual, bono_acum, num_silvia, anio, cod_ramo, fec_ini_pol
      --*
            /* Inicio JRaffo 29/09/2015 */ 
      ,cod_cob
      ,cod_modalidad
      /* Fin JRaffo 29/09/2015 */
      /* FIN - LRIOS 04/12/2012 */
    FROM (
     SELECT * FROM (
      SELECT a.num_poliza as NP,
             b.codmodal as MOD,
             a.cod_moneda,
             a.val_intecni int_tecnico,
             a.val_excesoit exceso_it,
             a.mca_sexo SEXO,
             TO_CHAR(a.fec_ini_pol,'yyyymmdd') FEFECTO,
             DECODE(a.imp_porsobre+a.imp_sobr_enf+a.imp_sobr_prf,0,'N','S') TARADO,
             a.imp_porsobre PORSOBRE,
             a.imp_sobr_enf SOBREENF,
             a.imp_sobr_prf SOBREPRO,
             a.val_edad_ini X,
             a.val_dur_pri M,
             a.val_fpago FP,
             a.val_anualidad T,
             a.imp_capvipol C,
             a.imp_capmupol CM,
             a.imp_rbalantp RES_BAL_PO,
             a.imp_rbalantb RESBONO,
             a.imp_peso_teso PESOTESO,
             a.imp_rentabil RENT_TOTAL,
             a.imp_pupor1ca PU_X_MIL,
             DECODE(a.cod_ramo,604,a.imp_capmuer,a.imp_capvida) BONO_ANUAL,
             DECODE(a.cod_ramo,604,a.imp_camuboan+a.imp_capmuer,a.imp_caviboan+a.imp_capvida) BONO_ACUM
             ,a.num_silvia
             ,a.anio
             ,a.cod_ramo
             ,a.fec_ini_pol
             /* INI - LRIOS 04/12/2012 */
             ,'RPR' SRC
             /* FIN - LRIOS 04/12/2012 */
            /* INI - JRAFFO 18/09/2015 */
             ,a.cod_cob
             ,a.cod_modalidad
            /* INI - JRAFFO 18/09/2015 */
        FROM a2300250_rpr_mpe a, taeqcovi_2 b
       WHERE a.cod_cia = 2
         and a.num_poliza = NVL(l_num_poliza,a.num_poliza)--'6010510100215'
         and a.anio = l_anio
         /* ==================== INI - EXCEPTUADO POR ANUALIDAD DUPLICADA ==================== */
         AND a.num_poliza NOT IN ('6010510100090','6020510100152','6020510100962','6050510100009','6070510100511','6070510101000')
         /* ==================== FIN - EXCEPTUADO POR ANUALIDAD DUPLICADA ==================== */
         AND b.cod_cia=a.cod_cia
         AND b.cod_ramo=a.cod_ramo
         AND b.cod_modalidad=a.cod_modalidad
         AND b.cod_cob=a.cod_cob
         AND b.fec_validez = (SELECT MAX(fec_validez) FROM taeqcovi_2 i
                               WHERE i.cod_cia = b.cod_cia
                                 AND i.cod_ramo = b.cod_ramo
                                 AND i.cod_modalidad = b.cod_modalidad
                                 AND i.cod_cob = b.cod_cob
                                 AND i.fec_validez <= a.fec_ini_pol)
         AND exists(select 'S' from a2300250_mpe where cod_cia = 2 and num_poliza = a.num_poliza and anio = p_anio_ult_bono)
      UNION ALL
      SELECT a.num_poliza as NP,
             b.codmodal as MOD,
             a.cod_moneda,
             a.val_intecni int_tecnico,
             a.val_excesoit exceso_it,
             a.mca_sexo SEXO,
             TO_CHAR(a.fec_ini_pol,'yyyymmdd') FEFECTO,
             DECODE(a.imp_porsobre+a.imp_sobr_enf+a.imp_sobr_prf,0,'N','S') TARADO,
             a.imp_porsobre PORSOBRE,
             a.imp_sobr_enf SOBREENF,
             a.imp_sobr_prf SOBREPRO,
             a.val_edad_ini X,
             a.val_dur_pri M,
             a.val_fpago FP,
             a.val_anualidad T,
             a.imp_capvipol C,
             a.imp_capmupol CM,
             a.imp_rbalantp RES_BAL_PO,
             a.imp_rbalantb RESBONO,
             a.imp_peso_teso PESOTESO,
             a.imp_rentabil RENT_TOTAL,
             a.imp_pupor1ca PU_X_MIL,
             DECODE(a.cod_ramo,604,a.imp_capmuer,a.imp_capvida) BONO_ANUAL,
             DECODE(a.cod_ramo,604,a.imp_camuboan+a.imp_capmuer,a.imp_caviboan+a.imp_capvida) BONO_ACUM
             ,a.num_silvia
             ,a.anio
             ,a.cod_ramo
             ,a.fec_ini_pol
             /* INI - LRIOS 04/12/2012 */
             ,'TRN' SRC
             /* FIN - LRIOS 04/12/2012 */
             /* INI - JRAFFO 18/09/2015 */
             ,a.cod_cob
             ,a.cod_modalidad
            /* INI - JRAFFO 18/09/2015 */
        FROM a2300250_mpe a, taeqcovi_2 b
       WHERE a.cod_cia = 2
         and a.num_poliza = NVL(l_num_poliza,a.num_poliza)--'6010510100215'
         and a.anio = l_anio
         /* ==================== INI - EXCEPTUADO POR ANUALIDAD DUPLICADA ==================== */
         AND a.num_poliza NOT IN ('6010510100090','6020510100152','6020510100962','6050510100009','6070510100511','6070510101000')
         /* ==================== FIN - EXCEPTUADO POR ANUALIDAD DUPLICADA ==================== */
         AND b.cod_cia=a.cod_cia
         AND b.cod_ramo=a.cod_ramo
         AND b.cod_modalidad=a.cod_modalidad
         AND b.cod_cob=a.cod_cob
         AND b.fec_validez = (SELECT MAX(fec_validez) FROM taeqcovi_2 i
                               WHERE i.cod_cia = b.cod_cia
                                 AND i.cod_ramo = b.cod_ramo
                                 AND i.cod_modalidad = b.cod_modalidad
                                 AND i.cod_cob = b.cod_cob
                                 AND i.fec_validez <= a.fec_ini_pol)
         AND exists(select 'S' from a2300250_mpe where cod_cia = 2 and num_poliza = a.num_poliza and anio = p_anio_ult_bono) )
     MINUS
     SELECT a.num_poliza as NP,
            b.codmodal as MOD,
            a.cod_moneda,
            a.val_intecni int_tecnico,
            a.val_excesoit exceso_it,
            a.mca_sexo SEXO,
            TO_CHAR(a.fec_ini_pol,'yyyymmdd') FEFECTO,
            DECODE(a.imp_porsobre+a.imp_sobr_enf+a.imp_sobr_prf,0,'N','S') TARADO,
            a.imp_porsobre PORSOBRE,
            a.imp_sobr_enf SOBREENF,
            a.imp_sobr_prf SOBREPRO,
            a.val_edad_ini X,
            a.val_dur_pri M,
            a.val_fpago FP,
            a.val_anualidad T,
            a.imp_capvipol C,
            a.imp_capmupol CM,
            a.imp_rbalantp RES_BAL_PO,
            a.imp_rbalantb RESBONO,
            a.imp_peso_teso PESOTESO,
            a.imp_rentabil RENT_TOTAL,
            a.imp_pupor1ca PU_X_MIL,
            DECODE(a.cod_ramo,604,a.imp_capmuer,a.imp_capvida) BONO_ANUAL,
            DECODE(a.cod_ramo,604,a.imp_camuboan+a.imp_capmuer,a.imp_caviboan+a.imp_capvida) BONO_ACUM
            ,a.num_silvia
            ,a.anio
            ,a.cod_ramo
            ,a.fec_ini_pol
            /* INI - LRIOS 04/12/2012 */
             ,'TRN' SRC
             /* FIN - LRIOS 04/12/2012 */
             /* INI - JRAFFO 18/09/2015 */
             ,a.cod_cob
             ,a.cod_modalidad
            /* INI - JRAFFO 18/09/2015 */
       FROM a2300250_mpe a, taeqcovi_2 b, a2300250_rpr_mpe c
      WHERE a.cod_cia = 2
        and a.num_poliza = NVL(l_num_poliza,a.num_poliza)--'6010510100215'
        and a.anio = l_anio
        /* ==================== INI - EXCEPTUADO POR ANUALIDAD DUPLICADA ==================== */
        AND a.num_poliza NOT IN ('6010510100090','6020510100152','6020510100962','6050510100009','6070510100511','6070510101000')
        /* ==================== FIN - EXCEPTUADO POR ANUALIDAD DUPLICADA ==================== */
        AND b.cod_cia=a.cod_cia
        AND b.cod_ramo=a.cod_ramo
        AND b.cod_modalidad=a.cod_modalidad
        AND b.cod_cob=a.cod_cob
        AND b.fec_validez = (SELECT MAX(fec_validez) FROM taeqcovi_2 i
                              WHERE i.cod_cia = b.cod_cia
                                AND i.cod_ramo = b.cod_ramo
                                AND i.cod_modalidad = b.cod_modalidad
                                AND i.cod_cob = b.cod_cob
                                AND i.fec_validez <= a.fec_ini_pol)
        AND exists(select 'S' from a2300250_mpe where cod_cia = 2 and num_poliza = a.num_poliza and anio = p_anio_ult_bono)
        AND c.cod_cia = a.cod_cia
        AND c.num_poliza = a.num_poliza
        AND c.anio = a.anio )
    ORDER BY cod_ramo, fec_ini_pol ASC, np;
  --
  l_reg_bonos   c_bonos_rpr%ROWTYPE;
  /* FIN - LRIOSR - NUEVA FORMA DE RECUPERAR DATOS */

  CURSOR c_anual_sil ( pc_num_poliza VARCHAR2 )
  IS
    SELECT val_anualidad
      FROM a2300250_mpe
     WHERE cod_cia = 2
       AND num_poliza = pc_num_poliza
       AND val_sist_bono = 'SIL';
  --
  CURSOR c_val_fp ( pc_num_poliza VARCHAR2, pc_numpoliz VARCHAR2 )
  IS
    SELECT to_number(anualida) anualidad, to_number(codfpago) fp
      FROM tron2000.tamig_s_phpol
     WHERE numpoliz = pc_numpoliz
       AND anualida <= l_anual_sil
     UNION ALL
    SELECT val_anualidad anualidad, val_fpago fp
      FROM a2300250_mpe
     WHERE cod_cia = 2
       AND num_poliza = pc_num_poliza
       AND val_sist_bono = 'TRN'
     ORDER BY anualidad ASC;
  --
  CURSOR c_existe_bdpb ( pc_np VARCHAR2, pc_t NUMBER )
  IS
    SELECT 'S'
      FROM tron2000.MP_GENBDPB_2015_MPE
     WHERE np = pc_np
       AND t = pc_t;
  --
  CURSOR c_excep
  IS
    SELECT num_poliza,
           nom_tabla_mort_h1, nom_tabla_mort_h2, nom_tabla_mort_h3,
           nom_tabla_mort_m1, nom_tabla_mort_m2, nom_tabla_mort_m3,
           pct_gastos_int, pct_gastos_ext
      FROM tron2000.a2300112_mpe
     WHERE cod_cia = 2
       AND mca_inh = 'N'
       AND SUBSTR(num_poliza,1,3) NOT IN ('603','608')
       AND EXISTS (SELECT 'S' FROM tron2000.MP_GENBDPB_2015_MPE WHERE np = tron2000.a2300112_mpe.num_poliza);
  --
  
    --
  
    /* Inicio JRaffo 18/09/2015 */
  --
  
    CURSOR c_polizas_saldadas
    IS
    select 
    
        a.anio,
        x.num_poliza, 
        add_months(x.fec_efec_spto,-12) fec_efec_spto,
        x.fec_actu
         
    from tron2000.MP_GENBDPB_2015_MPE a ,
    (select * from a2000030 where tip_spto = 'RD' and cod_cia = 2) x 

    where 
         a.np = x.num_poliza;-- and extract (year from x.fec_actu) = a.anio;
  
    CURSOR c_polizas_anticipo
    IS
    select 

        a.anio,
        x.num_poliza,
        x.fec_actu,
        z.cap_spto
    
    from tron2000.MP_GENBDPB_2015_MPE a ,
    (select * from a2000030 where tip_spto = 'AN' and cod_cia = 2) x ,
    a2300333 z 

    where 
        x.num_poliza = a.np and
        Z.COD_CIA = x.cod_cia and 
        z.num_poliza = x.num_poliza and 
        z.num_spto = x.num_spto and
        extract (year from x.fec_actu) = a.anio and
        x.fec_actu = (select max(fec_actu) from a2000030 where tip_spto = 'AN' and cod_cia = 2 and num_poliza = a.np) and
        x.num_spto = (select max(num_spto) from a2000030 where tip_spto = 'AN' and cod_cia = 2 and num_poliza = a.np);
  
  --
  /* Fin JRaffo 18/09/2015 */
  
  PROCEDURE pp_genbdpb
  IS
  --
  BEGIN

    OPEN c_existe_bdpb ( l_reg_bonos.np, l_reg_bonos.t );
    FETCH c_existe_bdpb INTO l_existe;
    --
       
    /* INICIO JRAFFO 17/09/2015 */
    begin
    
        select sf_recupera_dv_vig(2,l_reg_bonos.np,1,1,'FEC_INI_EFECTO',l_reg_bonos.cod_ramo,'VAL') into l_fec_ini_efecto from dual;
        select sf_recupera_dv_vig(2,l_reg_bonos.np,1,1,'NUM_POLIZA_ANTIGUA',l_reg_bonos.cod_ramo,'VAL') into l_num_poliza_antigua from dual;
        select sf_recupera_dv_vig(2,l_reg_bonos.np,1,1,'MCA_SEXO',l_reg_bonos.cod_ramo,'VAL') into l_mca_sexo from dual;

        select to_char(X.FEC_VALIDEZ,'ddmmyyyy') into l_fec_validez  from a2000030 x where x.num_poliza = l_reg_bonos.np and x.num_spto = 0 and x.cod_cia = 2;
        
         trn_k_global.asigna( 'COD_CIA',2 );
         trn_k_global.asigna( 'num_poliza',l_reg_bonos.np );
         trn_k_global.asigna( 'FEC_VALIDEZ',l_fec_validez );
         trn_k_global.asigna( 'DVFEC_INI_EFECTO',l_fec_ini_efecto );
         trn_k_global.asigna( 'DVNUM_POLIZA_ANTIGUA',l_num_poliza_antigua);
         trn_k_global.asigna( 'DVMCA_SEXO',l_mca_sexo );
        
         ev_k_cobertura_vida_mpe.carga(l_reg_bonos.cod_ramo, l_reg_bonos.cod_modalidad, l_reg_bonos.cod_cob, true);
    
    exception
       when others then
            trn_k_global.asigna( 'COD_CIA',2 );
    end; 
    
    begin 
           
         SELECT
         
            x.imp_prima_neta into l_prima_comercial
         
         FROM a5020120_mpv x
         WHERE x.cod_cia    = 2
           AND x.num_poliza = l_reg_bonos.np
           AND x.cod_cob    = l_reg_bonos.cod_cob
           AND x.anio_mes   = to_number(to_char(l_anio) || '12') ;
     
     exception
         when others then
                  l_prima_comercial := null;
     end;
    
    IF c_existe_bdpb%NOTFOUND
    THEN
    --
      --mpe_p_traza4('genbdpb','a','notfound - insert');
      --
      INSERT INTO TRON2000.MP_GENBDPB_MPE
              ( np, mod, cod_moneda, int_tecnico, exceso_it, sexo,
                fefecto, tarado, porsobre, sobreenf, sobrepro, x,
                m, fp, t, c, cm, res_bal_po, resbono, pesoteso,
                rent_total, pu_x_mil, bono_anual, bono_acum,
                num_silvia, mca_cambio_fp, anio
                /* INICIO JRAFFO 17/09/2015 */
                ,PCT_GASTOS_INT
                ,PCT_GASTOS_EXT
                ,PCOM
                /* FIN JRAFFO 17/09/2015 */
              )
      VALUES  ( l_reg_bonos.np,
                l_reg_bonos.mod,
                l_reg_bonos.cod_moneda,
                l_reg_bonos.int_tecnico,
                l_reg_bonos.exceso_it,
                l_reg_bonos.sexo,
                l_reg_bonos.fefecto,
                l_reg_bonos.tarado,
                l_reg_bonos.porsobre,
                l_reg_bonos.sobreenf,
                l_reg_bonos.sobrepro,
                l_reg_bonos.x,
                l_reg_bonos.m,
                l_reg_bonos.fp,
                l_reg_bonos.t,
                l_reg_bonos.c,
                l_reg_bonos.cm,
                l_reg_bonos.res_bal_po,
                l_reg_bonos.resbono,
                l_reg_bonos.pesoteso,
                l_reg_bonos.rent_total,
                l_reg_bonos.pu_x_mil,
                l_reg_bonos.bono_anual,
                l_reg_bonos.bono_acum,
                l_reg_bonos.num_silvia,
                'N',
                l_reg_bonos.anio
                /* INICIO JRAFFO 17/09/2015 */
                ,EV_K_COBERTURA_VIDA_MPE.GI
                ,ev_k_cobertura_vida_mpe.GE
                ,l_prima_comercial
                /* FIN JRAFFO 17/09/2015 */
              );
    --
    ELSE
    --
      --mpe_p_traza4('genbdpb','a','found - update');
      --
      UPDATE TRON2000.MP_GENBDPB_MPE
         SET mod            =   l_reg_bonos.mod,
             cod_moneda     =   l_reg_bonos.cod_moneda,
             int_tecnico    =   l_reg_bonos.int_tecnico,
             exceso_it      =   l_reg_bonos.exceso_it,
             sexo           =   l_reg_bonos.sexo,
             fefecto        =   l_reg_bonos.fefecto,
             tarado         =   l_reg_bonos.tarado,
             porsobre       =   l_reg_bonos.porsobre,
             sobreenf       =   l_reg_bonos.sobreenf,
             sobrepro       =   l_reg_bonos.sobrepro,
             x              =   l_reg_bonos.x,
             m              =   l_reg_bonos.m,
             fp             =   l_reg_bonos.fp,
             c              =   l_reg_bonos.c,
             cm             =   l_reg_bonos.cm,
             res_bal_po     =   l_reg_bonos.res_bal_po,
             resbono        =   l_reg_bonos.resbono,
             pesoteso       =   l_reg_bonos.pesoteso,
             rent_total     =   l_reg_bonos.rent_total,
             pu_x_mil       =   l_reg_bonos.pu_x_mil,
             bono_anual     =   l_reg_bonos.bono_anual,
             bono_acum      =   l_reg_bonos.bono_acum,
             num_silvia     =   l_reg_bonos.num_silvia,
             mca_cambio_fp  =   'N',
             anio         =   l_reg_bonos.anio
             /* INICIO JRAFFO 17/09/2015 */
             ,pct_gastos_int    = EV_K_COBERTURA_VIDA_MPE.GI
             ,pct_gastos_ext    = EV_K_COBERTURA_VIDA_MPE.GE
             ,PCOM = l_prima_comercial
             /* FIN JRAFFO 17/09/2015 */
       WHERE np = l_reg_bonos.np
         AND t = l_reg_bonos.t;
    --
    END IF;
    --
    CLOSE c_existe_bdpb;
  --
  END pp_genbdpb;
--
BEGIN
--

  IF p_num_poliza IS NOT NULL THEN 
  
      l_num_poliza := p_num_poliza; 
      EXECUTE IMMEDIATE('TRUNCATE TABLE tron2000.MP_GENBDPB_2015_MPE');
  ELSE
  
      /* INI - LRIOSR - NUEVA FORMA DE RECUPERAR DATOS */
      --
      /* INI - LRIOS 04/12/2012 */
      l_num_poliza := trn_k_global.ref_f_global('jbnum_poliza');
      --
      if l_num_poliza is not null
      then
        delete tron2000.MP_GENBDPB_2015_MPE where np = l_num_poliza;
      else
        EXECUTE IMMEDIATE('TRUNCATE TABLE tron2000.MP_GENBDPB_2015_MPE');
      end if;
      /* FIN - LRIOS 04/12/2012 */
  
  END IF;


  --
  /* INICIO LRIOS 13/02/2014 Parametro anio = anio hasta el que se quiere generar */
  FOR i IN 1999..p_anio_ult_bono
  /* FIN LRIOS 13/02/2014 Parametro anio = anio hasta el que se quiere generar */
  LOOP
  --
    l_anio := i;
    --mpe_p_traza4('genbdpb','a','l_anio = ' || l_anio);
  
      --mpe_p_traza4('genbdpb','a','busca trn');
      OPEN c_bonos_trn;
      --
      LOOP
      --
        FETCH c_bonos_trn INTO l_reg_bonos;
        EXIT WHEN c_bonos_trn%NOTFOUND;
        --
        pp_genbdpb;
      --
      END LOOP;
      --
      CLOSE c_bonos_trn;
    --
   
  --
  END LOOP;

  --
  --mpe_p_traza4('genbdpb','a','commit 1');
  --
  COMMIT;
  --
  --mpe_p_traza4('genbdpb','a','loop excep');
  --
  FOR reg_excep IN c_excep LOOP
  --
    --mpe_p_traza4('genbdpb','a','update np = ' || reg_excep.num_poliza);
    --
    UPDATE TRON2000.MP_GENBDPB_MPE
       SET nom_tabla_mort_h1 = reg_excep.nom_tabla_mort_h1,
           nom_tabla_mort_h2 = reg_excep.nom_tabla_mort_h2,
           nom_tabla_mort_h3 = reg_excep.nom_tabla_mort_h3,
           nom_tabla_mort_m1 = reg_excep.nom_tabla_mort_m1,
           nom_tabla_mort_m2 = reg_excep.nom_tabla_mort_m2,
           nom_tabla_mort_m3 = reg_excep.nom_tabla_mort_m3
           /* Inicio JRaffo 18/09/2015 */
                 
           /*,
           pct_gastos_int    = reg_excep.pct_gastos_int,
           pct_gastos_ext    = reg_excep.pct_gastos_ext
           */
           
           /* Fin JRaffo 18/09/2015 */
     WHERE np = reg_excep.num_poliza;
  --
  END LOOP;
  
    /* Inicio JRaffo 18/09/2015 */
  FOR reg IN c_polizas_saldadas LOOP
   
   update tron2000.MP_GENBDPB_2015_MPE
    set MCA_SALD = 'S',
         FEC_SALD = reg.fec_efec_spto
    where np = reg.num_poliza and anio = reg.anio;
    
  END LOOP;
  
    FOR reg IN c_polizas_anticipo LOOP
   
   update tron2000.MP_GENBDPB_2015_MPE
    set MCA_PRES = 'S',
         SAL_PRES = reg.cap_spto,
         FEC_PRES = reg.fec_actu
    where np = reg.num_poliza and anio = reg.anio;
    ----
    
    update tron2000.MP_GENBDPB_2015_MPE
    set MCA_PRES = 'S',
         SAL_PRES = 
    (
    
            select 
        z.cap_spto
    from
    
    (select * from a2000030 where tip_spto = 'AN' and cod_cia = 2) x ,
    tron2000.a2300333 z 

    where 
        Z.COD_CIA = x.cod_cia and 
        z.num_poliza = x.num_poliza and 
        z.num_spto = x.num_spto and
        z.tip_spto = 'AN' and
        x.fec_actu = (select max(fec_actu) from a2000030 where tip_spto = 'AN' and cod_cia = 2 and num_poliza = x.num_poliza) and
        x.num_spto = (select max(num_spto) from a2000030 where tip_spto = 'AN' and cod_cia = 2 and num_poliza =x.num_poliza) and
        extract (year from x.fec_actu) =  reg.anio and
       x.num_poliza =reg.num_poliza
    
    )
    where np = reg.num_poliza and anio >= reg.anio;
    
  END LOOP;
  
  /* Fin JRaffo 18/09/2015 */
  
  COMMIT;

  UPDATE tron2000.MP_GENBDPB_2015_MPE
     SET mca_cambio_fp = 'S'
   WHERE np IN (SELECT np
                  FROM (SELECT COUNT(*) cant, np
                          FROM (SELECT DISTINCT np, fp
                                  FROM tron2000.MP_GENBDPB_2015_MPE)
                         GROUP BY np)
                 WHERE cant > 1);

  COMMIT;

EXCEPTION
  WHEN OTHERS THEN
    --mpe_p_traza4('genbdpb','a','==========ERROR==========');
    /*
    mpe_p_traza4('genbdpb','a','Error = ' || SQLERRM);
    SYS.envia_email( 'produccion@mapfre.com.pe'
                   , 'fgarcia@mapfre.com.pe'
                   , 'ERROR extraccion historica data de bonos de P.B.'
                   , 'ERROR:' || SQLERRM
                   , NULL
                   , 'TEMP2'
                   , NULL ); */
    --ROLLBACK;
    
    dbms_output.put_line('ERROR:' || SQLERRM); 
--
END sp_genbdpb_2015_mpe;
/
