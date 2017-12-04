CREATE OR REPLACE PROCEDURE TRON2000.sp_genbdpb_mpe(p_anio_ult_bono NUMBER)
IS
--
  l_anual_sil VARCHAR2(3);
  l_existe    VARCHAR2(1);
  l_num_poliza VARCHAR2(13);
  --
  CURSOR c_bonos
  IS
    /* I - LRIOSR */
    /*SELECT a.num_poliza as NP,
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
           --
           ,a.num_silvia
           --
      FROM a2300250_mpe a, taeqcovi b
     WHERE a.cod_cia = 2*/
       /* ==================== INI - EXCEPTUADO POR ANUALIDAD DUPLICADA ==================== */
       --AND a.num_poliza NOT IN ('6010510100090','6020510100152','6020510100962','6050510100009','6070510100511','6070510101000')
       /* ==================== FIN - EXCEPTUADO POR ANUALIDAD DUPLICADA ==================== */
       /*AND a.anio = 2011
       AND b.cod_cia=a.cod_cia
       AND b.cod_ramo=a.cod_ramo
       AND b.cod_modalidad=a.cod_modalidad
       AND b.cod_cob=a.cod_cob
     ORDER BY a.cod_ramo, a.fec_ini_pol ASC, a.num_poliza;*/
   select * from (
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
           ,'SIL' src
      FROM a2300250_mpe a, taeqcovi b
     WHERE a.cod_cia = 92
       --and a.num_poliza = '6010510100012'--'6010510100029'
       and a.anio <= 2004
       /* ==================== INI - EXCEPTUADO POR ANUALIDAD DUPLICADA ==================== */
       AND a.num_poliza NOT IN ('6010510100090','6020510100152','6020510100962','6050510100009','6070510100511','6070510101000')
       /* ==================== FIN - EXCEPTUADO POR ANUALIDAD DUPLICADA ==================== */
       AND b.cod_cia=2--a.cod_cia
       AND b.cod_ramo=a.cod_ramo
       AND b.cod_modalidad=a.cod_modalidad
       AND b.cod_cob=a.cod_cob
    UNION ALL
    SELECT NVL(r.num_poliza,a.num_poliza) as NP,
           b.codmodal as MOD,
           NVL(r.cod_moneda,a.cod_moneda),
           NVL(r.val_intecni,a.val_intecni) int_tecnico,
           NVL(r.val_excesoit,a.val_excesoit) exceso_it,
           NVL(r.mca_sexo,a.mca_sexo) SEXO,
           TO_CHAR(NVL(r.fec_ini_pol,a.fec_ini_pol),'yyyymmdd') FEFECTO,
           DECODE(NVL(r.imp_porsobre,a.imp_porsobre)+NVL(r.imp_sobr_enf,a.imp_sobr_enf)+NVL(r.imp_sobr_prf,a.imp_sobr_prf),0,'N','S') TARADO,
           NVL(r.imp_porsobre,a.imp_porsobre) PORSOBRE,
           NVL(r.imp_sobr_enf,a.imp_sobr_enf) SOBREENF,
           NVL(r.imp_sobr_prf,a.imp_sobr_prf) SOBREPRO,
           NVL(r.val_edad_ini,a.val_edad_ini) X,
           NVL(r.val_dur_pri,a.val_dur_pri) M,
           NVL(r.val_fpago,a.val_fpago) FP,
           NVL(r.val_anualidad,a.val_anualidad) T,
           NVL(r.imp_capvipol,a.imp_capvipol) C,
           NVL(r.imp_capmupol,a.imp_capmupol) CM,
           NVL(r.imp_rbalantp,a.imp_rbalantp) RES_BAL_PO,
           NVL(r.imp_rbalantb,a.imp_rbalantb) RESBONO,
           NVL(r.imp_peso_teso,a.imp_peso_teso) PESOTESO,
           NVL(r.imp_rentabil,a.imp_rentabil) RENT_TOTAL,
           NVL(r.imp_pupor1ca,a.imp_pupor1ca) PU_X_MIL,
           DECODE(NVL(r.cod_ramo,a.cod_ramo),604,NVL(r.imp_capmuer,a.imp_capmuer),NVL(r.imp_capvida,a.imp_capvida)) BONO_ANUAL,
           DECODE(NVL(r.cod_ramo,a.cod_ramo),604,NVL(r.imp_camuboan,a.imp_camuboan)+NVL(r.imp_capmuer,a.imp_capmuer),NVL(r.imp_caviboan,a.imp_caviboan)+NVL(r.imp_capvida,a.imp_capvida)) BONO_ACUM
           ,NVL(r.num_silvia,a.num_silvia)
           ,NVL(r.anio,a.anio)
           ,NVL(r.cod_ramo,a.cod_ramo)
           ,NVL(r.fec_ini_pol,a.fec_ini_pol)
           ,decode(NVL(r.cod_cia,'0'),'0','TRN','RPR') src
      FROM a2300250_mpe a, taeqcovi b, a2300250_rpr_mpe r
     WHERE a.cod_cia = 2
       --and a.num_poliza = '6010510100012'--'6010510100029'
       and a.anio > 2004
       AND b.cod_cia=NVL(r.cod_cia,a.cod_cia)
       AND b.cod_ramo=NVL(r.cod_ramo,a.cod_ramo)
       AND b.cod_modalidad=NVL(r.cod_modalidad,a.cod_modalidad)
       AND b.cod_cob=NVL(r.cod_cob,a.cod_cob)
       and r.cod_cia(+) = a.cod_cia
       and r.num_poliza(+) = a.num_poliza
       and r.anio(+) = a.anio
     --ORDER BY cod_ramo, fec_ini_pol ASC, np, anio ASC
   )
   where exists(select 'S' from a2300250_mpe where cod_cia = 2 and num_poliza = np and anio = 2011)
   ORDER BY cod_ramo, fec_ini_pol ASC, np, anio ASC;
  /* F - LRIOSR */
  --
  /* INI - LRIOSR - NUEVA FORMA DE RECUPERAR DATOS */
  l_anio NUMBER(4);
  --
  CURSOR c_bonos_sil
  IS
    SELECT DISTINCT
           a.num_poliza as NP,
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
      FROM a2300250_mpe a, taeqcovi_2 b
     WHERE a.cod_cia = 92
       and a.num_poliza = NVL(l_num_poliza,a.num_poliza)--'6010510100215'
       and a.anio = l_anio
       /* ==================== INI - EXCEPTUADO POR ANUALIDAD DUPLICADA ==================== */
       AND a.num_poliza NOT IN ('6010510100090','6020510100152','6020510100962','6050510100009','6070510100511','6070510101000')
       /* ==================== FIN - EXCEPTUADO POR ANUALIDAD DUPLICADA ==================== */
       AND b.cod_cia=2--a.cod_cia
       AND b.cod_ramo=a.cod_ramo
       AND (b.cod_modalidad=a.cod_modalidad OR to_number(b.codmodal) = to_number(replace(a.cod_modalidad,'9','')))
       AND (b.cod_cob=a.cod_cob OR a.cod_cob = 9999)
       AND b.fec_validez = (SELECT MAX(fec_validez) FROM taeqcovi_2 i
                             WHERE i.cod_cia = b.cod_cia
                               AND i.cod_ramo = b.cod_ramo
                               AND i.cod_modalidad = b.cod_modalidad
                               AND i.cod_cob = b.cod_cob
                               AND i.fec_validez <= a.fec_ini_pol)
	   AND exists(select 'S' from a2300250_mpe where cod_cia = 2 and num_poliza = a.num_poliza and anio = p_anio_ult_bono)
     ORDER BY cod_ramo, fec_ini_pol ASC, np;
  --
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
  --
  TYPE fetch_table IS TABLE OF c_bonos%ROWTYPE;
  --
  reg_bonos     fetch_table;
  --
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
      FROM tron2000.mp_genbdpb_mpe
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
       AND EXISTS (SELECT 'S' FROM tron2000.mp_genbdpb_mpe WHERE np = tron2000.a2300112_mpe.num_poliza);
  --
  PROCEDURE pp_genbdpb
  IS
  --
  BEGIN
  --
    --mpe_p_traza4('genbdpb','a','pp_genbdpb');
    --
    OPEN c_existe_bdpb ( l_reg_bonos.np, l_reg_bonos.t );
    FETCH c_existe_bdpb INTO l_existe;
    --
    /*mpe_p_traza4('genbdpb','a','DATOS: ' ||
                  l_reg_bonos.np ||', '||
                  l_reg_bonos.mod ||', '||
                  l_reg_bonos.cod_moneda ||', '||
                  l_reg_bonos.int_tecnico ||', '||
                  l_reg_bonos.exceso_it ||', '||
                  l_reg_bonos.sexo ||', '||
                  l_reg_bonos.fefecto ||', '||
                  l_reg_bonos.tarado ||', '||
                  l_reg_bonos.porsobre ||', '||
                  l_reg_bonos.sobreenf ||', '||
                  l_reg_bonos.sobrepro ||', '||
                  l_reg_bonos.x ||', '||
                  l_reg_bonos.m ||', '||
                  l_reg_bonos.fp ||', '||
                  l_reg_bonos.t ||', '||
                  l_reg_bonos.c ||', '||
                  l_reg_bonos.cm ||', '||
                  l_reg_bonos.res_bal_po ||', '||
                  l_reg_bonos.resbono ||', '||
                  l_reg_bonos.pesoteso ||', '||
                  l_reg_bonos.rent_total ||', '||
                  l_reg_bonos.pu_x_mil ||', '||
                  l_reg_bonos.bono_anual ||', '||
                  l_reg_bonos.bono_acum ||', '||
                  l_reg_bonos.num_silvia ||', '||
                  'N' ||', '|| l_reg_bonos.anio
                );*/
    --
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
  --mpe_p_traza4('genbdpb','a','==========INICIO==========');
  /* INI - LRIOSR - NUEVA FORMA DE RECUPERAR DATOS */
  --
  /* INI - LRIOS 04/12/2012 */
  l_num_poliza := trn_k_global.ref_f_global('jbnum_poliza');
  --
  if l_num_poliza is not null
  then
    delete tron2000.mp_genbdpb_mpe where np = l_num_poliza;
  else
    EXECUTE IMMEDIATE('TRUNCATE TABLE tron2000.mp_genbdpb_mpe');
  end if;
  /* FIN - LRIOS 04/12/2012 */
  --
  /* INICIO LRIOS 13/02/2014 Parametro anio = anio hasta el que se quiere generar */
  --FOR i IN 1999..to_number(to_char(sysdate,'yyyy'))-1
  FOR i IN 1999..p_anio_ult_bono
  /* FIN LRIOS 13/02/2014 Parametro anio = anio hasta el que se quiere generar */
  LOOP
  --
    l_anio := i;
    --mpe_p_traza4('genbdpb','a','l_anio = ' || l_anio);
	/* INICIO LRIOS 13/02/2014 Data reprocesada en tabla real */
    /*IF l_anio <= 2004
    THEN
    --
      mpe_p_traza4('genbdpb','a','busca sil');
      OPEN c_bonos_sil;
      --
      LOOP
      --
        FETCH c_bonos_sil INTO l_reg_bonos;
        EXIT WHEN c_bonos_sil%NOTFOUND;
        --
        pp_genbdpb;
      --
      END LOOP;
      --
      CLOSE c_bonos_sil;
    --
    ELSIF l_anio in (2005,2006)
    THEN*/
	/* FIN LRIOS 13/02/2014 Data reprocesada en tabla real */
    --
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
	/* INICIO LRIOS 13/02/2014 Data reprocesada en tabla real */
    /*ELSE
    --
      mpe_p_traza4('genbdpb','a','busca rpr');
      OPEN c_bonos_rpr;
      --
      LOOP
      --
        FETCH c_bonos_rpr INTO l_reg_bonos;
        EXIT WHEN c_bonos_rpr%NOTFOUND;
        --
        pp_genbdpb;
      --
      END LOOP;
      --
      CLOSE c_bonos_rpr;
    --
    END IF;*/
	/* FIN LRIOS 13/02/2014 Data reprocesada en tabla real */
  --
  END LOOP;

--  OPEN c_bonos;
--  --
--  LOOP
--  --
--    FETCH c_bonos
--    BULK COLLECT INTO reg_bonos LIMIT 500;
--    --
--    FOR i IN NVL(reg_bonos.FIRST,0)..NVL(reg_bonos.LAST,-1)
--    LOOP
--    --
--      /*l_anual_sil := '0';
--      --
--      OPEN c_anual_sil ( reg_bonos(i).np );
--      FETCH c_anual_sil INTO l_anual_sil;
--      CLOSE c_anual_sil;
--      --
--      mpe_p_traza4('genbdpb','a','l_anual_sil = ' || l_anual_sil);*/
--      mpe_p_traza4('genbdpb','a','reg_bonos(i).np = ' || reg_bonos(i).np);
--      mpe_p_traza4('genbdpb','a','reg_bonos(i).num_silvia = ' || reg_bonos(i).num_silvia);
--      --
--      /* I - LRIOSR */
--      --FOR reg_val_fp IN c_val_fp ( reg_bonos(i).np, reg_bonos(i).num_silvia )
--      --LOOP
--      --
--        --OPEN c_existe_bdpb ( reg_bonos(i).np, reg_val_fp.anualidad );
--        OPEN c_existe_bdpb ( reg_bonos(i).np, reg_bonos(i).t );
--        /* F - LRIOSR */
--        FETCH c_existe_bdpb INTO l_existe;
--        --
--        mpe_p_traza4('genbdpb','a','DATOS: ' ||
--                    reg_bonos(i).np ||', '||
--                    reg_bonos(i).mod ||', '||
--                    reg_bonos(i).cod_moneda ||', '||
--                    reg_bonos(i).int_tecnico ||', '||
--                    reg_bonos(i).exceso_it ||', '||
--                    reg_bonos(i).sexo ||', '||
--                    reg_bonos(i).fefecto ||', '||
--                    reg_bonos(i).tarado ||', '||
--                    reg_bonos(i).porsobre ||', '||
--                    reg_bonos(i).sobreenf ||', '||
--                    reg_bonos(i).sobrepro ||', '||
--                    reg_bonos(i).x ||', '||
--                    reg_bonos(i).m ||', '||
--                    /* I - LRIOSR */
--                    --reg_val_fp.fp ||', '||
--                    --reg_val_fp.anualidad ||', '||
--                    reg_bonos(i).fp ||', '||
--                    reg_bonos(i).t ||', '||
--                    /* F - LRIOSR */
--                    reg_bonos(i).c ||', '||
--                    reg_bonos(i).cm ||', '||
--                    reg_bonos(i).res_bal_po ||', '||
--                    reg_bonos(i).resbono ||', '||
--                    reg_bonos(i).pesoteso ||', '||
--                    reg_bonos(i).rent_total ||', '||
--                    reg_bonos(i).pu_x_mil ||', '||
--                    reg_bonos(i).bono_anual ||', '||
--                    reg_bonos(i).bono_acum ||', '||
--                    reg_bonos(i).num_silvia ||', '||
--                    'N' ||', '|| reg_bonos(i).anio
--        );
--        --
--        IF c_existe_bdpb%NOTFOUND
--        THEN
--        --
--          mpe_p_traza4('genbdpb','a','notfound - insert');
--          --
--          INSERT INTO TRON2000.MP_GENBDPB_MPE
--                  ( np, mod, cod_moneda, int_tecnico, exceso_it,
--                    sexo, fefecto, tarado, porsobre, sobreenf,
--                    sobrepro, x, m, fp, t, c, cm, res_bal_po,
--                    resbono, pesoteso, rent_total, pu_x_mil,
--                    bono_anual, bono_acum, num_silvia, mca_cambio_fp
--                    /* I - LRIOSR */
--                    , anio
--                    /* F - LRIOSR */
--                  )
--          VALUES  ( reg_bonos(i).np,
--                    reg_bonos(i).mod,
--                    reg_bonos(i).cod_moneda,
--                    reg_bonos(i).int_tecnico,
--                    reg_bonos(i).exceso_it,
--                    reg_bonos(i).sexo,
--                    reg_bonos(i).fefecto,
--                    reg_bonos(i).tarado,
--                    reg_bonos(i).porsobre,
--                    reg_bonos(i).sobreenf,
--                    reg_bonos(i).sobrepro,
--                    reg_bonos(i).x,
--                    reg_bonos(i).m,
--                    /* I - LRIOSR */
--                    --reg_val_fp.fp,
--                    --reg_val_fp.anualidad,
--                    reg_bonos(i).fp,
--                    reg_bonos(i).t,
--                    /* F - LRIOSR */
--                    reg_bonos(i).c,
--                    reg_bonos(i).cm,
--                    reg_bonos(i).res_bal_po,
--                    reg_bonos(i).resbono,
--                    reg_bonos(i).pesoteso,
--                    reg_bonos(i).rent_total,
--                    reg_bonos(i).pu_x_mil,
--                    reg_bonos(i).bono_anual,
--                    reg_bonos(i).bono_acum,
--                    reg_bonos(i).num_silvia,
--                    'N'
--                    /* I - LRIOSR */
--                    , reg_bonos(i).anio
--                    /* F - LRIOSR */
--                  );
--        --
--        ELSE
--        --
--          mpe_p_traza4('genbdpb','a','found - update');
--          --
--          UPDATE TRON2000.MP_GENBDPB_MPE
--             SET mod            =   reg_bonos(i).mod,
--                 cod_moneda     =   reg_bonos(i).cod_moneda,
--                 int_tecnico    =   reg_bonos(i).int_tecnico,
--                 exceso_it      =   reg_bonos(i).exceso_it,
--                 sexo           =   reg_bonos(i).sexo,
--                 fefecto        =   reg_bonos(i).fefecto,
--                 tarado         =   reg_bonos(i).tarado,
--                 porsobre       =   reg_bonos(i).porsobre,
--                 sobreenf       =   reg_bonos(i).sobreenf,
--                 sobrepro       =   reg_bonos(i).sobrepro,
--                 x              =   reg_bonos(i).x,
--                 m              =   reg_bonos(i).m,
--                 /* I - LRIOSR */
--                 --fp             =   reg_val_fp.fp,
--                 fp             =   reg_bonos(i).fp,
--                 /* F - LRIOSR */
--                 c              =   reg_bonos(i).c,
--                 cm             =   reg_bonos(i).cm,
--                 res_bal_po     =   reg_bonos(i).res_bal_po,
--                 resbono        =   reg_bonos(i).resbono,
--                 pesoteso       =   reg_bonos(i).pesoteso,
--                 rent_total     =   reg_bonos(i).rent_total,
--                 pu_x_mil       =   reg_bonos(i).pu_x_mil,
--                 bono_anual     =   reg_bonos(i).bono_anual,
--                 bono_acum      =   reg_bonos(i).bono_acum,
--                 num_silvia     =   reg_bonos(i).num_silvia,
--                 mca_cambio_fp  =   'N'
--                 /* I - LRIOSR */
--                 , anio         =   reg_bonos(i).anio
--                 /* F - LRIOSR */
--           WHERE np = reg_bonos(i).np
--             /* I - LRIOSR */
--             --AND t = reg_val_fp.anualidad;
--             AND t = reg_bonos(i).t;
--             /* F - LRIOSR */
--        --
--        END IF;
--        --
--        CLOSE c_existe_bdpb;
--      --
--      /* I - LRIOSR */
--      --END LOOP;
--      /* F - LRIOSR */
--    --
--    END LOOP;
--    --
--    EXIT WHEN c_bonos%NOTFOUND;
--  --
--  END LOOP;
--  --
--  CLOSE c_bonos;
  --
  /* FIN - LRIOSR - NUEVA FORMA DE RECUPERAR DATOS */
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
           nom_tabla_mort_m3 = reg_excep.nom_tabla_mort_m3,
           pct_gastos_int    = reg_excep.pct_gastos_int,
           pct_gastos_ext    = reg_excep.pct_gastos_ext
     WHERE np = reg_excep.num_poliza;
  --
  END LOOP;
  --
  --mpe_p_traza4('genbdpb','a','commit 2');
  --
  COMMIT;
  --
  --mpe_p_traza4('genbdpb','a','update mca_cambio_fp');
  --
  UPDATE tron2000.mp_genbdpb_mpe
     SET mca_cambio_fp = 'S'
   WHERE np IN (SELECT np
                  FROM (SELECT COUNT(*) cant, np
                          FROM (SELECT DISTINCT np, fp
                                  FROM tron2000.mp_genbdpb_mpe)
                         GROUP BY np)
                 WHERE cant > 1);
  --
  --mpe_p_traza4('genbdpb','a','commit 3');
  --
  COMMIT;
 --
  --mpe_p_traza4('genbdpb','a','==========FIN==========');
--
EXCEPTION
  WHEN OTHERS THEN
    --mpe_p_traza4('genbdpb','a','==========ERROR==========');
    mpe_p_traza4('genbdpb','a','Error = ' || SQLERRM);
    SYS.envia_email( 'produccion@mapfre.com.pe'
                   , 'fgarcia@mapfre.com.pe'
                   , 'ERROR extraccion historica data de bonos de P.B.'
                   , 'ERROR:' || SQLERRM
                   , NULL
                   , 'TEMP2'
                   , NULL );
    ROLLBACK;
--
END sp_genbdpb_mpe;
/
