using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.OracleClient;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using AccesoDatos;
using Entidades;
using CrystalDecisions.CrystalReports.Engine;
using CrystalDecisions.Shared;
using PdfSharp.Pdf;
using PdfSharp.Pdf.IO;

namespace LogicaNegocio
{
    public class LN_General
    {
        AD_General objAD_General;
        static String[] Tip_Certificado = { "CER", "CRT", "CRG" };//Certificado - CartC:\Users\nfire\Desktop\Aplicaciones\Service_Vida_Ley\Service_Vida_Ley\LogicaNegocio\LN_General.csa - Cargo
        public LN_General()
        {
            objAD_General = new AD_General();
        }

        private void escribirlog(String p_Sistema, String p_Poliza, String p_Parametros, String p_Mensaje)
        {
            String p_Usuario = System.Security.Principal.WindowsIdentity.GetCurrent().Name.ToString();
            objAD_General.fr_InsertarLog(p_Usuario, p_Sistema, p_Poliza, DateTime.Now, p_Parametros, p_Mensaje);
        }

        public String fr_CrearExcel(String NroPoliza)
        {
            String Rpta = "OK";
            LoginUser objLoginUser = new LoginUser();
            try
            {
                escribirlog("TronWeb", NroPoliza, "NroPoliza", "fr_CrearExcel(): INICIO PROCEDIMIENTO");

                if (objLoginUser.impersonateValidUser(ConfigurationManager.AppSettings["UserNameImp"], ConfigurationManager.AppSettings["DominioImp"], ConfigurationManager.AppSettings["UserPassImp"]))
                {
                    //Me.escribirlog("[r-p" & lcPoliza & "-s] Usuario :" & WindowsIdentity.GetCurrent().Name.ToString)
                    if (NroPoliza.Trim().Length > 0)
                    {
                        String Plantilla = ConfigurationManager.AppSettings["PlantillaExcel"].ToString();
                        String StrFileDest = ConfigurationManager.AppSettings["DirExcel"].ToString() + NroPoliza + ".xls";
                        //escribirlog("TronWeb", NroPoliza, "NroPoliza", "fr_CrearExcel(): StrFileDest=" + StrFileDest);
                        File.Delete(StrFileDest);
                        //escribirlog("TronWeb", NroPoliza, "NroPoliza", "fr_CrearExcel(): Valida que no exista StrFileDest=" + StrFileDest);

                        System.IO.File.Copy(Plantilla, StrFileDest, true);
                        //escribirlog("TronWeb", NroPoliza, "NroPoliza", "fr_CrearExcel(): System.IO.File.Copy(" + Plantilla + "," + StrFileDest + ",true");
                    }
                    else
                    {
                        throw new Exception("ER: Número de Póliza Vacía.");
                    }
                    Rpta = "OK";
                }
                else
                {
                    Rpta = "ER: ERROR_IMPERSONATE";
                    //Me.escribirlog("[r-p" & lcPoliza & "-s] ERROR_IMPERSONATE")
                }
                escribirlog("TronWeb", NroPoliza, "NroPoliza", "fr_CrearExcel(): " + Rpta);
            }
            catch (Exception ex)
            {
                Rpta = "ER: " + ex.Message;
                escribirlog("TronWeb", NroPoliza, "NroPoliza", "fr_CrearExcel(): EXCEPTION PROCEDIMIENTO: " + Rpta);
            }
            finally
            {
                escribirlog("TronWeb", NroPoliza, "NroPoliza", "CrearExcel(): FIN PROCEDIMIENTO");
            }
            return Rpta;
        }

        public String fr_CargarTrama(EN_General objEN_General)
        {
            escribirlog("TronWeb", objEN_General.Param01, "NroPoliza", "fr_CargarTrama(): INICIO PROCEDIMIENTO");
            String Rpta = "OK";
            Int32 lcContador = 0;
            //********************CARGAR TRAMA********************//
            String TramaExcel = ConfigurationManager.AppSettings["DirExcel"].ToString() + objEN_General.Param01 + ".xls";
            System.Data.DataTable dt = new System.Data.DataTable();
            dt = Utilitarios.General.LeerExcel(TramaExcel);
            //********************CARGAR TRAMA********************//
            OracleConnection objOracleConx = new OracleConnection();
            OracleTransaction objTrans;
            objOracleConx.ConnectionString = ConfigurationManager.ConnectionStrings["OracleWebCon"].ConnectionString;
            objOracleConx.Open();
            objTrans = objOracleConx.BeginTransaction();
            try
            {
                escribirlog("TronWeb", objEN_General.Param01, "NroPoliza", "fr_CargarTrama(): INICIO try");
                //validamos que el excel tenga columnas de acuerdo al formato
                if (dt.Columns[0].ToString().Trim() == "DNI" || dt.Columns[0].ToString().Trim() == "CEX" ||
                dt.Columns[0].ToString().Trim() == "PEX" || dt.Columns[0].ToString().Trim() == "RUC" ||
                dt.Columns[0].ToString().Trim() == "CIP" || dt.Columns[6].ToString().Trim().Contains("/")//Fecha
                )
                    throw new Exception("Por favor carge la plantilla correcta con los datos a registrar.");
                //validamos que el excel tenga datos
                if (dt.Rows.Count == 0) throw new Exception("Excel no tiene datos.");
                String Nro_Movimiento = objAD_General.fr_GenerarMovimiento(objEN_General, ref objOracleConx, ref objTrans);
                foreach (System.Data.DataRow dr in dt.Rows)
                {
                    Int32 fila = lcContador + 2;
                    lcContador++;
                    if (dr[0].ToString().Trim().Length > 0 || dr[1].ToString().Trim().Length > 0 ||
                        dr[2].ToString().Trim().Length > 0 || dr[3].ToString().Trim().Length > 0 ||
                        dr[4].ToString().Trim().Length > 0 || dr[5].ToString().Trim().Length > 0 ||
                        dr[6].ToString().Trim().Length > 0 || dr[7].ToString().Trim().Length > 0 ||
                        (objEN_General.Param01.Substring(0, 3) == "610" && dr[8].ToString().Trim().Length > 0))
                    {
                        EN_RCEN_ASEG0004_TEMP objAsegurado = new EN_RCEN_ASEG0004_TEMP();
                        #region "Parametros"
                        //0:tipo doc
                        objAsegurado.TIPDOC = dr[0].ToString().Trim();
                        //1:Nro Doc
                        objAsegurado.NUMDOC = dr[1].ToString().Trim();
                        //2:Ape paterno
                        objAsegurado.APEPAT = dr[2].ToString().Trim();
                        //3:Ape Materno
                        objAsegurado.APEMAT = dr[3].ToString().Trim();
                        //4:Nombres
                        objAsegurado.NOMBRES = dr[4].ToString().Trim();
                        //5:NomCompleto
                        objAsegurado.NOMBRECOMPLETO = dr[5].ToString().Trim();
                        //6:FecNacimiento
                        objAsegurado.FECNAC = dr[6].ToString().Trim();
                        //7:Sueldo
                        objAsegurado.SUELDO = dr[7].ToString().Trim();
                        //8:Ocupacion
                        objAsegurado.OCUPACION = dr[8].ToString().Trim();
                        //Nro Movimiento
                        objAsegurado.NRO_MOVIMIENTO = Nro_Movimiento;
                        //Cod Usuario
                        objAsegurado.COD_USR_REG = objEN_General.Param05;
                        //Cod Sistema
                        objAsegurado.COD_SISTEMA = objEN_General.Param06;
                        //Fila
                        objAsegurado.NRO_FILA = fila.ToString();
                        #endregion
                        objAD_General.fr_InsertarDatosTrama(objAsegurado, ref objOracleConx, ref objTrans);
                    }
                }
                objTrans.Commit();
                objOracleConx.Close();
                escribirlog("TronWeb", objEN_General.Param01, "NroPoliza", "fr_CargarTrama(): FIN DEL PROCEDIMIENTO");
                return Nro_Movimiento;
            }
            catch (Exception ex)
            {
                escribirlog("TronWeb", objEN_General.Param01, "NroPoliza", "fr_CargarTrama() ERROR:" + ex.Message);
                objTrans.Rollback();
                objOracleConx.Close();
                return "ER: " + ex.Message;
            }
        }

        public String fr_CargarAsegurado(EN_General objEN_General, EN_Asegurado objEn_Asegurado)
        {
            escribirlog("TronWeb", objEn_Asegurado.NUM_POLIZA, "NroPoliza", "fr_CargarTrama(): INICIO PROCEDIMIENTO");
            String Rpta = "OK";
            Int32 lcContador = 0;

            //********************CARGAR ASEGURADO********************//
            OracleConnection objOracleConx = new OracleConnection();
            OracleTransaction objTrans;
            objOracleConx.ConnectionString = ConfigurationManager.ConnectionStrings["OracleWebCon"].ConnectionString;
            objOracleConx.Open();
            objTrans = objOracleConx.BeginTransaction();
            try
            {
                escribirlog("TronWeb", objEn_Asegurado.NUM_POLIZA, "NroPoliza", "fr_CargarAsegurado(): INICIO try");

                if(objEn_Asegurado.MCA_RESETEO.ToUpper() == "S"){
                    objAD_General.fr_EliminarMovimientosYAsegurados(objEN_General, ref objOracleConx, ref objTrans);
                }

                int? int_Nro_Movimiento = objAD_General.fr_ObtenerNroMovimientoPorPoliza(objEN_General, ref objOracleConx, ref objTrans);
                String Nro_Movimiento = null;

                if (int_Nro_Movimiento == null)
                {
                    Nro_Movimiento = objAD_General.fr_GenerarMovimiento(objEN_General, ref objOracleConx, ref objTrans);
                }
                else 
                {
                    Nro_Movimiento = int_Nro_Movimiento.ToString();
                }

                if (!string.IsNullOrEmpty(objEn_Asegurado.NUM_POLIZA_ENLACE))
                {
                    objEN_General.Param07 = Nro_Movimiento;
                    objEN_General.Param08 = objEn_Asegurado.NUM_POLIZA_ENLACE;
                    objAD_General.fr_RegistrarPolizaEnlace(objEN_General, ref objOracleConx, ref objTrans);
                }

                int numFila = objAD_General.fr_ObtenerUltimaFilaAsegurado(Convert.ToInt32(Nro_Movimiento), ref objOracleConx, ref objTrans);
                    
                        EN_RCEN_ASEG0004_TEMP objAsegurado = new EN_RCEN_ASEG0004_TEMP();
                        #region "Parametros"
                        //0:tipo doc
                        objAsegurado.TIPDOC = objEn_Asegurado.TIPDOC;
                        //1:Nro Doc
                        objAsegurado.NUMDOC = objEn_Asegurado.NUMDOC;
                        //2:Ape paterno
                        objAsegurado.APEPAT = objEn_Asegurado.APEPAT;
                        //3:Ape Materno
                        objAsegurado.APEMAT = objEn_Asegurado.APEMAT;
                        //4:Nombres
                        objAsegurado.NOMBRES = objEn_Asegurado.NOMBRES;
                        //5:NomCompleto
                        objAsegurado.NOMBRECOMPLETO = objEn_Asegurado.NOMBRECOMPLETO;
                        //6:FecNacimiento
                        objAsegurado.FECNAC = objEn_Asegurado.FECNAC;
                        //7:Sueldo
                        objAsegurado.SUELDO = objEn_Asegurado.SUELDO;
                        //8:Ocupacion
                        objAsegurado.OCUPACION = objEn_Asegurado.OCUPACION;
                        //Nro Movimiento
                        objAsegurado.NRO_MOVIMIENTO = Nro_Movimiento;
                        //Cod Usuario
                        objAsegurado.COD_USR_REG = objEn_Asegurado.COD_USR_REG;
                        //Cod Sistema
                        objAsegurado.COD_SISTEMA = objEn_Asegurado.COD_SISTEMA;
                        //Fila
                        objAsegurado.NRO_FILA = numFila.ToString();
                        #endregion
                        objAD_General.fr_InsertarDatosTrama(objAsegurado, ref objOracleConx, ref objTrans);
                    
                
                objTrans.Commit();
                objOracleConx.Close();
                escribirlog("TronWeb", objEN_General.Param01, "NroPoliza", "fr_CargarAsegurado(): FIN DEL PROCEDIMIENTO");
                return Nro_Movimiento;
            }
            catch (Exception ex)
            {
                escribirlog("TronWeb", objEN_General.Param01, "NroPoliza", "fr_CargarAsegurado() ERROR:" + ex.Message);
                objTrans.Rollback();
                objOracleConx.Close();
                return "ER: " + ex.Message;
            }
        }

        public String fr_ValidarTrama(EN_General objEN_General)
        {
            escribirlog(objEN_General.Param07, objEN_General.Param01, "NroPoliza", "fr_ValidarTrama() INICIO DEL PROCEDIMIENTO");
            String Rpta = "";
            try
            {
                List<EN_RCEN_ASEG0004_TEMP> lst = objAD_General.fr_ValidarTrama(objEN_General);
                if (lst != null && lst.Count > 0)
                {
                    foreach (EN_RCEN_ASEG0004_TEMP item in lst)
                    {
                        if (item.TIPDOC != null)
                            if (Rpta == "") Rpta = item.TIPDOC;
                            else Rpta = Rpta + "|" + item.TIPDOC;
                        if (item.NUMDOC != null)
                            if (Rpta == "") Rpta = item.NUMDOC;
                            else Rpta = Rpta + "|" + item.NUMDOC;
                        if (item.APEPAT != null)
                            if (Rpta == "") Rpta = item.APEPAT;
                            else Rpta = Rpta + "|" + item.APEPAT;
                        if (item.APEMAT != null)
                            if (Rpta == "") Rpta = item.APEMAT;
                            else Rpta = Rpta + "|" + item.APEMAT;
                        if (item.NOMBRES != null)
                            if (Rpta == "") Rpta = item.NOMBRES;
                            else Rpta = Rpta + "|" + item.NOMBRES;
                        if (item.NOMBRECOMPLETO != null)
                            if (Rpta == "") Rpta = item.NOMBRECOMPLETO;
                            else Rpta = Rpta + "|" + item.NOMBRECOMPLETO;
                        if (item.FECNAC != null)
                            if (Rpta == "") Rpta = item.FECNAC;
                            else Rpta = Rpta + "|" + item.FECNAC;
                        if (item.SUELDO != null)
                            if (Rpta == "") Rpta = item.SUELDO;
                            else Rpta = Rpta + "|" + item.SUELDO;
                        if (item.OCUPACION != null)
                            if (Rpta == "") Rpta = item.OCUPACION;
                            else Rpta = Rpta + "|" + item.OCUPACION;
                        //********************VALIDA SI EXISTE UN REGISTRO REPETIDO********************//
                        if (item.MENSAJE != null)
                            if (Rpta == "") Rpta = item.MENSAJE;
                            else Rpta = Rpta + item.MENSAJE;
                        //********************VALIDA SI EXISTE UN REGISTRO REPETIDO********************//
                    }
                }
                else Rpta = "OK";
                escribirlog(objEN_General.Param07, objEN_General.Param01, "NroPoliza", "fr_ValidarTrama() FIN DEL PROCEDIMIENTO");
            }
            catch (Exception ex)
            {
                escribirlog(objEN_General.Param07, objEN_General.Param01, "NroPoliza", "fr_ValidarTrama() ERROR: " + ex.Message);
                Rpta = ex.Message;
            }
            return Rpta;
        }

        public String fr_GenerarRecibo(EN_General objEN_General)
        {
            escribirlog("OIM", objEN_General.Param00, "NroMovimiento", "fr_GenerarRecibo() INICIO DEL PROCEDIMIENTO");
            String mensaje = objAD_General.fr_GenerarRecibo(objEN_General);
            escribirlog("OIM", objEN_General.Param00, "NroMovimiento", "fr_GenerarRecibo() FIN DEL PROCEDIMIENTO RECIBO:" + mensaje);
            return mensaje;
        }

        public String fr_RegistrarMovimiento(EN_General objEN_General)
        {
            if (!objEN_General.Param00.Equals("")) escribirlog(objEN_General.Param09, objEN_General.Param00, "NroMovimiento", "fr_RegistrarMovimiento() INICIO DEL PROCEDIMIENTO");
            else escribirlog(objEN_General.Param09, objEN_General.Param02, "NroPoliza", "fr_RegistrarMovimiento() INICIO DEL PROCEDIMIENTO");
            String mensaje = objAD_General.fr_RegistrarMovimiento(objEN_General);
            if (!objEN_General.Param00.Equals("")) escribirlog(objEN_General.Param09, objEN_General.Param00, "NroMovimiento", "fr_RegistrarMovimiento() FIN DEL PROCEDIMIENTO mensaje" + mensaje);
            else escribirlog(objEN_General.Param09, objEN_General.Param02, "NroPoliza", "fr_RegistrarMovimiento() FIN DEL PROCEDIMIENTO mensaje" + mensaje);
            return mensaje;
        }

        public String fr_ImprimirRecibo(EN_General objEN_General)
        {
            try
            {
                escribirlog("OIM", objEN_General.Param00, "NroRecibo", "fr_ImprimirRecibo() INICIO DEL PROCEDIMIENTO");
                App_Data.SctrEmision dsDeclaracion = new App_Data.SctrEmision();
                ReportDocument rd = new ReportDocument();

                EN_Aplicacion oEnAplicacion = new EN_Aplicacion();
                oEnAplicacion.oEnEmp = new EN_Empresa();
                oEnAplicacion.oEnEmp.oEnRies = new EN_Riesgos();
                oEnAplicacion.oEnEmp.oEnSol = new EN_Solicitud();

                oEnAplicacion.oEnEmp.oEnRies.NumRecibo = Convert.ToInt32(objEN_General.Param00);//Número de Recibo
                new AD_General().RecuperarDatosRecibo(ref oEnAplicacion);

                ObtenerReciboDS(oEnAplicacion, ref dsDeclaracion);

                rd.Load(ConfigurationManager.AppSettings["DirReportes_RTP"].ToString() + "declaracion.rpt");//Si es para salud o Pension
                //rd.Load(System.Web.Hosting.HostingEnvironment.MapPath("~\\Reportes\\declaracion.rpt"));//Si es para salud o Pension
                oEnAplicacion.NombrePdf = String.Format("RECIBO_{0}_{1}.PDF", oEnAplicacion.oEnEmp.oEnRies.NumRecibo.ToString(), String.Format("{0:dd_MM_yyyy_H_mm_ss}", DateTime.Now));

                rd.SetDataSource(dsDeclaracion);
                rd.ExportToDisk(ExportFormatType.PortableDocFormat, ConfigurationManager.AppSettings["DirRecibos"].ToString() + "\\" + oEnAplicacion.NombrePdf);
                rd.Close();
                rd = null;
                //string PATH_VIRTUAL = String.Format("http://{0}/FILE/PDF/{1}", ConfigurationManager.AppSettings["SERVER"].ToString(), oEnAplicacion.NombrePdf);
                escribirlog("OIM", objEN_General.Param00, "NroRecibo", "fr_ImprimirRecibo() FIN DEL PROCEDIMIENTO");
                return oEnAplicacion.NombrePdf;
            }
            catch (Exception ex)
            {
                escribirlog("OIM", objEN_General.Param00, "NroRecibo", "fr_ImprimirRecibo() ERROR:" + ex.Message);
                return "ER:ERROR AL GENERAR RECIBO.";
            }
        }

        protected void ObtenerReciboDS(EN_Aplicacion oEnAplicacion, ref App_Data.SctrEmision dsSctrEmision)
        {
            escribirlog("OIM", oEnAplicacion.oEnEmp.oEnRies.NumRecibo.ToString(), "NroRecibo", "ObtenerReciboDS() INICIO DEL PROCEDIMIENTO");
            dsSctrEmision.DeclaCab.AddDeclaCabRow(oEnAplicacion.oEnEmp.oEnRies.NumPoliza, oEnAplicacion.NroAplicacion.ToString(),
                oEnAplicacion.oEnEmp.NroDocumento, oEnAplicacion.oEnEmp.oEnRies.NumRecibo.ToString(), oEnAplicacion.oEnEmp.RazonSocial.Replace("¿", "Ñ"),
                oEnAplicacion.oEnEmp.NomDomicilio, oEnAplicacion.oEnEmp.CodCIIUEmp, oEnAplicacion.oEnEmp.oEnSol.ColegAseg,
                oEnAplicacion.oEnEmp.oEnSol.FecIniCad, oEnAplicacion.oEnEmp.oEnSol.FecFinalCad, oEnAplicacion.FecEfectoApli,
                oEnAplicacion.FecVctoApli, oEnAplicacion.oEnEmp.oEnSol.FormaPago, oEnAplicacion.oEnEmp.oEnSol.Moneda,
                oEnAplicacion.FecEmisionPoliza, oEnAplicacion.oEnEmp.oEnRies.PrimaNeta, oEnAplicacion.oEnEmp.oEnRies.ImporteRecargo,
                oEnAplicacion.oEnEmp.oEnRies.ImporteIntereses, oEnAplicacion.oEnEmp.oEnRies.PrimaTotal, oEnAplicacion.oEnEmp.oEnRies.FecVctoRecibo,
                oEnAplicacion.oEnEmp.oEnRies.ImporteIgv);

            List<EN_Riesgos> lista = new List<EN_Riesgos>();
            new AD_General().ListarRiesgoRecibo(oEnAplicacion.oEnEmp.oEnRies.NumRecibo, ref lista);
            foreach (EN_Riesgos oEnriesgo in lista)
            {
                dsSctrEmision.Riesgos.AddRiesgosRow(oEnriesgo.NombreRiesgo, oEnriesgo.CantTrab, oEnriesgo.ImporPlanilla.ToString(),
                    oEnriesgo.Tasa, oEnriesgo.PrimaNeta, oEnAplicacion.oEnEmp.oEnRies.NumRecibo.ToString());
            }
            escribirlog("OIM", oEnAplicacion.oEnEmp.oEnRies.NumRecibo.ToString(), "NroRecibo", "ObtenerReciboDS() FIN DEL PROCEDIMIENTO");
        }

        public String fr_GenerarConstancia(EN_General objEN_General)
        {
            return objAD_General.fr_GenerarConstancia(objEN_General);
        }

        public String fr_ImpirmirConstancia(EN_General objEN_General)
        {
            try
            {
                escribirlog("OIM", objEN_General.Param00, "NroConstancia", "fr_ImpirmirConstancia() INICIO DEL PROCEDIMIENTO");
                App_Data.SctrEmision dsConstancia = new App_Data.SctrEmision();
                ReportDocument rd = new ReportDocument();

                String nombreConstancia = String.Empty;

                EN_ConstanciaSCTR oEnConstancia = new EN_ConstanciaSCTR();
                oEnConstancia.NumeroConstancia = objEN_General.Param00;
                new AD_General().pr_RecuperarConstancia(ref oEnConstancia);

                ObtenerConstanciaDS(oEnConstancia, ref dsConstancia);
                //rd.Load(System.Web.Hosting.HostingEnvironment.MapPath("~\\Reportes\\Constancia.rpt"));//Si es para salud o Pension
                rd.Load(ConfigurationManager.AppSettings["DirReportes_RTP"].ToString() + "Constancia.rpt");//Si es para salud o Pension
                nombreConstancia = String.Format("CONSTANCIA_{0}_{1}.PDF", oEnConstancia.SecuencialConstancia, String.Format("{0:dd_MM_yyyy_H_mm_ss}", DateTime.Now));
                rd.SetDataSource(dsConstancia);
                rd.ExportToDisk(ExportFormatType.PortableDocFormat, ConfigurationManager.AppSettings["DirRecibos"].ToString() + "\\" + nombreConstancia);
                rd.Close();
                rd = null;
                escribirlog("OIM", objEN_General.Param00, "NroConstancia", "fr_ImpirmirConstancia() INICIO DEL PROCEDIMIENTO");
                return nombreConstancia;
            }
            catch (Exception ex)
            {
                escribirlog("OIM", objEN_General.Param00, "NroConstancia", "fr_ImpirmirConstancia() INICIO DEL PROCEDIMIENTO");
                return "ER:ERROR AL IMPRIMIR LA CONSTANCIA";
            }
        }

        protected void ObtenerConstanciaDS(EN_ConstanciaSCTR oEnConstancia, ref App_Data.SctrEmision dsSctrEmision)
        {
            String Hora = "Horas: " + String.Format("{0:H:mm:ss}", DateTime.Now);
            String Dir_Fecha = "Miraflores, " + DateTime.Now.Day.ToString() + " de " + Utilitarios.General.ObtenerNombreMes(DateTime.Now) + " de " + DateTime.Now.Year.ToString();
            escribirlog("OIM", oEnConstancia.NumeroConstancia, "NroConstancia", "ObtenerConstanciaDS() INICIO DEL PROCEDIMIENTO");
            dsSctrEmision.Constancias.AddConstanciasRow(oEnConstancia.SecuencialConstancia,
                oEnConstancia.NumeroPolizaPension, oEnConstancia.RazonSocial.Replace("¿", "Ñ"), oEnConstancia.FechaInicioVigencia,
                oEnConstancia.FechaFinVigencia, oEnConstancia.NumeroPolizaSalud, oEnConstancia.UbicacionTrabajo,
                oEnConstancia.FechaMovimiento, oEnConstancia.NumeroConstancia, oEnConstancia.NombreCompleto, oEnConstancia.NumeroPolizaVL,
                Dir_Fecha, Hora, oEnConstancia.NombreUsuario);

            List<EN_Trabajador> lstTrab = new List<EN_Trabajador>();
            new AD_General().pr_RecuperarTrabajadorConstancia(oEnConstancia, ref lstTrab);
            int secuencial = 0;
            foreach (EN_Trabajador oEnTrab in lstTrab)
            {
                secuencial++;
                dsSctrEmision.Trabajadores.AddTrabajadoresRow(oEnConstancia.SecuencialConstancia, oEnTrab.TipoDoc,
                    oEnTrab.NumDoc, oEnTrab.ApePat, oEnTrab.ApeMat, oEnTrab.Nombres,
                    oEnTrab.NombreCompleto, secuencial, oEnTrab.Ocupacion);
            }
            escribirlog("OIM", oEnConstancia.NumeroConstancia, "NroConstancia", "ObtenerConstanciaDS() FIN DEL PROCEDIMIENTO");
        }

        public string fr_GrabarAdjunto(EN_Documento objDocumento)
        {
            escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "fr_GrabarAdjunto(): PASO 1");
            LoginUser objLoginUser = new LoginUser();
            Int32 lnMin = 0;
            String lcError = "";
            String Rpta = "";
            try
            {
                escribirlog(objDocumento.CodApli, objDocumento.Poliza,
                    "[p:" + objDocumento.Poliza + "-s:" + objDocumento.NumSpto + "-a:" + objDocumento.NumApli + "-sa:" + objDocumento.NumSptoApli + "-CodApli:" + objDocumento.CodApli + "-DscArch:" + objDocumento.DscDocumento + "-Ruta:" + objDocumento.Ruta + "-Usr:" + objDocumento.Usuario + "]",
                    "fr_GrabarAdjunto()");

                if (objLoginUser.impersonateValidUser(ConfigurationManager.AppSettings["UserNameImp"], ConfigurationManager.AppSettings["DominioImp"], ConfigurationManager.AppSettings["UserPassImp"]))
                {
                    escribirlog(objDocumento.CodApli, objDocumento.Poliza,
                        "[p" + objDocumento.Poliza + "-s] Usuario :" + System.Security.Principal.WindowsIdentity.GetCurrent().Name.ToString(),
                        "fr_GrabarAdjunto()");
                    if (System.IO.File.Exists(objDocumento.Ruta))
                    {
                        Byte[] fileConstancia = null;
                        FileStream file__1 = null;
                        do
                        {
                            try
                            {
                                file__1 = File.Open(objDocumento.Ruta, FileMode.Open);
                                break;
                            }
                            catch (Exception ex)
                            {
                                System.Threading.Thread.Sleep(5000);
                                lnMin = lnMin + 1;
                                lcError = lcError + "Intento (" + lnMin.ToString() + ")" + ex.Message + "\r";
                            }

                            if (lnMin >= 35)
                            {
                                break;
                            }
                        } while (lnMin <= 35);

                        if (lcError.Trim().Length > 0)
                        {
                            return lcError;
                        }

                        fileConstancia = new Byte[file__1.Length - 1];
                        file__1.Read(fileConstancia, 0, fileConstancia.Length);
                        file__1.Close();

                        String[] arr = objDocumento.Ruta.Split('.');

                        String strMensaje;
                        strMensaje = null;
                        objDocumento.File = fileConstancia;
                        objDocumento.Size = fileConstancia.Length;

                        if (arr.Length > 1)
                        {
                            String[] arr1 = arr[arr.Length - 2].Split('\\');
                            objDocumento.Nombre = arr1[arr1.Length - 1].ToUpper();
                            objDocumento.Extension = arr[arr.Length - 1].ToUpper();
                        }
                        else
                        {
                            objDocumento.Nombre = "";
                            objDocumento.Extension = "";
                        }
                        /* --> comentado hasta que sea necesario
                        escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "fr_GrabarAdjunto(): PASO 1.11");
                        escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "strMensaje: " + strMensaje);

                        escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "Documento.Cia: " + objDocumento.Cia.ToString());
                        escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "Documento.Poliza: " + objDocumento.Poliza.ToString());
                        escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "Documento.NumSpto: " + objDocumento.NumSpto.ToString());
                        escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "Documento.NumApli: " + objDocumento.NumApli.ToString());
                        escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "Documento.NumSptoApli: " + objDocumento.NumSptoApli.ToString());

                        escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "Documento.CodApli: " + objDocumento.CodApli.ToString());
                        escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "Documento.DscDocumento: " + objDocumento.DscDocumento.ToString());
                        escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "Documento.Nombre: " + objDocumento.Nombre.ToString());
                        escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "Documento.Extension: " + objDocumento.Extension.ToString());
                        escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "Documento.Size: " + objDocumento.Size.ToString());
                        escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "Documento.Ruta: " + objDocumento.Ruta.ToString());
                        escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "Documento.Usuario: " + objDocumento.Usuario.ToString());
                        escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "WindowsIdentity.GetCurrent.Name: " +
                            System.Security.Principal.WindowsIdentity.GetCurrent().Name);
                        escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "HttpContext.Current.User.Identity.Name: "
                            + System.Web.HttpContext.Current.User.Identity.Name);
                        */
                        try
                        {
                            fr_GrabarDocumentoAdjunto(objDocumento, ref strMensaje);
                        }
                        catch (Exception ex)
                        {
                            escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "strMensaje: " + strMensaje);
                            escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "strMensaje2: " + ex.Message);
                        }

                        escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "strMensaje: " + strMensaje);
                        escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "fr_GrabarAdjunto(): PASO 1.12");
                        if (Convert.IsDBNull(strMensaje) || strMensaje == "" || strMensaje == "null")
                        {
                            escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "fr_GrabarAdjunto(): PASO 1.13");
                            Rpta = "OK";
                            escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "[r-p" + objDocumento.Poliza + "-s] OK");
                        }
                        else
                        {
                            escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "fr_GrabarAdjunto(): PASO 1.14");
                            Rpta = "ER: " + strMensaje;
                            escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "[r-p" + objDocumento.Poliza + "-s] ERROR " + strMensaje);
                        }
                        escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "fr_GrabarAdjunto(): PASO 1.15");
                    }
                    else
                    {
                        Rpta = "ER: Error, no existe en la ruta especificada o no tiene permisos para acceder al archivo.";
                    }
                    //-----------------------------------
                    escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "[Resultado=" + Rpta + "-s] OK constancias.GrabaDocumentoAdjunto");
                    objLoginUser.undoImpersonation();
                }
                else
                {
                    Rpta = "ER: " + "ERROR_IMPERSONATE";
                    escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "[p" + objDocumento.Poliza + "-s] ERROR_IMPERSONATE");
                }

                escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "[p" + objDocumento.Poliza + "-s] (f) constancias.GrabaDocumentoAdjunto");
            }
            catch (Exception ex)
            {
                Rpta = "ER: " + ex.Message;
                //Me.escribirlog()
                escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "[p" + objDocumento.Poliza +
                    "-s] (f) Error constancias.GrabaDocumentoAdjunto - " + ex.Message);
            }
            return Rpta;
        }

        public void fr_GrabarDocumentoAdjunto(EN_Documento objDocumento, ref String mensaje)
        {
            escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "fr_GrabarDocumentoAdjunto-LN_General");
            new AD_General().pr_GrabarDocumentoAdjunto(objDocumento, ref mensaje);
        }

        public String fr_ImprimirCertificado(EN_DECASEG_0002 objEN_DECASEG_0002)
        {
            try
            {
                escribirlog(objEN_DECASEG_0002.COD_SISTEMA, objEN_DECASEG_0002.NUM_POLIZA + "|" + objEN_DECASEG_0002.NUM_APLI, "NroPoliza|NroAplicacion", "fr_ImprimirCertificado() INICIO DEL PROCEDIMIENTO");
                String Nom_Certific = String.Empty;
                App_Data.dsCertificado dsCertificado = null;
                ReportDocument rd = null;

                String nombreCertificado = String.Empty;

                new AD_General().pr_RecuperarCertificado(ref objEN_DECASEG_0002);

                foreach (String item in Tip_Certificado)
                {
                    dsCertificado = dsCertificado = new App_Data.dsCertificado();
                    rd = new ReportDocument();
                    objEN_DECASEG_0002.TIP_CERTIFICADO = item;
                    ObtenerCertificadoDS(objEN_DECASEG_0002, ref dsCertificado);
                    if (objEN_DECASEG_0002.TIP_CERTIFICADO == "CER")//Certificado
                    {
                        rd.Load(ConfigurationManager.AppSettings["DirReportes_RTP"].ToString() + "Certificado.rpt");//Si es para salud o Pension
                        //rd.Load(System.Web.Hosting.HostingEnvironment.MapPath("~\\Reportes\\Certificado.rpt"));//Si es para salud o Pension
                        nombreCertificado = String.Format("CERTIFICADO_{0}.PDF",
                            String.Format("{0:dd_MM_yyyy_H_mm_ss}", DateTime.Now));
                    }
                    else if (objEN_DECASEG_0002.TIP_CERTIFICADO == "CRT")//Carta
                    {
                        rd.Load(ConfigurationManager.AppSettings["DirReportes_RTP"].ToString() + "Carta.rpt");//Si es para salud o Pension
                        //rd.Load(System.Web.Hosting.HostingEnvironment.MapPath("~\\Reportes\\Carta.rpt"));//Si es para salud o Pension
                        nombreCertificado = String.Format("CARTA_{0}.PDF",
                            String.Format("{0:dd_MM_yyyy_H_mm_ss}", DateTime.Now));
                    }
                    else //if (objEN_General.Param08 == "CRG")//Cargo
                    {
                        rd.Load(ConfigurationManager.AppSettings["DirReportes_RTP"].ToString() + "Cargo.rpt");//Si es para salud o Pension
                        //rd.Load(System.Web.Hosting.HostingEnvironment.MapPath("~\\Reportes\\Cargo.rpt"));//Si es para salud o Pension
                        nombreCertificado = String.Format("CARGO_{0}.PDF",
                            String.Format("{0:dd_MM_yyyy_H_mm_ss}", DateTime.Now));
                    }
                    rd.SetDataSource(dsCertificado);
                    rd.ExportToDisk(ExportFormatType.PortableDocFormat, ConfigurationManager.AppSettings["DirRecibos"].ToString() + "\\" + nombreCertificado);
                    rd.Close();
                    rd = null;
                    if (Nom_Certific == "") Nom_Certific = nombreCertificado;
                    else Nom_Certific = Nom_Certific + ";" + nombreCertificado;
                }

                String[] array = Nom_Certific.Split(';');
                escribirlog(objEN_DECASEG_0002.COD_SISTEMA, objEN_DECASEG_0002.NUM_POLIZA + "|" + objEN_DECASEG_0002.NUM_APLI, "NroPoliza|NroAplicacion", "fr_ImprimirCertificado() num_nomcertificado:" + array.Length);
                if (array.Length > 0)
                {
                    PdfDocument outputDocument = new PdfDocument();
                    for (int i = 0; i < array.Length; i++)
                    {
                        PdfDocument inputDocument = PdfReader.Open(ConfigurationManager.AppSettings["DirRecibos"].ToString() + "\\" + array[i], PdfDocumentOpenMode.Import);
                        int count = inputDocument.PageCount;
                        for (int idx = 0; idx < count; idx++)
                        {
                            PdfPage page = inputDocument.Pages[idx];
                            outputDocument.AddPage(page);
                        }
                        inputDocument = null;
                        System.IO.File.Delete(ConfigurationManager.AppSettings["DirRecibos"].ToString() + "\\" + array[i]);
                    }
                    String Nom_Archivo = String.Format("CERTIFICADO_{0}.pdf", String.Format("{0:dd_MM_yyyy_H_mm_ss}", DateTime.Now));
                    String filename = ConfigurationManager.AppSettings["DirRecibos"].ToString() + "\\" + Nom_Archivo;
                    outputDocument.Save(filename);
                    escribirlog(objEN_DECASEG_0002.COD_SISTEMA, objEN_DECASEG_0002.NUM_POLIZA + "|" + objEN_DECASEG_0002.NUM_APLI, "NroPoliza|NroAplicacion", "fr_ImprimirCertificado() FIN DEL PROCEDIMIENTO nombre_archivo:" + filename);
                    return Nom_Archivo;
                }
                else
                {
                    escribirlog(objEN_DECASEG_0002.COD_SISTEMA, objEN_DECASEG_0002.NUM_POLIZA + "|" + objEN_DECASEG_0002.NUM_APLI, "NroPoliza|NroAplicacion", "fr_ImprimirCertificado() nombre_archivo: ERROR AL GENERAR CERTIFICADOS");
                    throw new Exception("ER:ERROR AL GENERAR CERTIFICADOS.");
                }
            }
            catch (Exception ex)
            {
                escribirlog(objEN_DECASEG_0002.COD_SISTEMA, objEN_DECASEG_0002.NUM_POLIZA + "|" + objEN_DECASEG_0002.NUM_APLI, "NroPoliza|NroAplicacion", "fr_ImprimirCertificado() nombre_archivo: ERROR: " + ex.Message);
                return "ER:ERROR AL GENERAR CERTIFICADO.";
            }

        }

        protected void ObtenerCertificadoDS(EN_DECASEG_0002 oEnCertificado, ref App_Data.dsCertificado dsCertificado)
        {
            escribirlog(oEnCertificado.COD_SISTEMA, oEnCertificado.NUM_POLIZA + "|" + oEnCertificado.NUM_APLI, "NroPoliza|NroAplicacion", "ObtenerCertificadoDS() INICIO DEL PROCEDIMIENTO");
            int Cont = 0;
            if (oEnCertificado.TIP_CERTIFICADO == "CER")//Certificado
            {
                dsCertificado.tbCertificado.AddtbCertificadoRow(oEnCertificado.NOM_RAZON_SOCIAL_CIA, oEnCertificado.TIP_DOCUM_CIA,
                    oEnCertificado.COD_DOCUM_CIA, oEnCertificado.DIRECCION_CIA, oEnCertificado.TLF_NUMERO_CIA,
                    oEnCertificado.FAX_NUMERO_CIA, oEnCertificado.CONTRATANTE, oEnCertificado.DIRECCION_CONT,
                    oEnCertificado.TIP_DOCUM_CONT, oEnCertificado.COD_DOCUM_CONT, oEnCertificado.TELEFONO_CONT,
                    oEnCertificado.NUM_POLIZA, oEnCertificado.FEC_EMISION, oEnCertificado.FEC_INI_VIG, oEnCertificado.FEC_FIN_VIG);
                List<EN_Trabajador> lstTrab = new List<EN_Trabajador>();
                new AD_General().pr_RecuperarTrabajadorCertificado(oEnCertificado, ref lstTrab);
                foreach (EN_Trabajador oEnTrab in lstTrab)
                {
                    Cont++;
                    dsCertificado.tbTrabajadores.AddtbTrabajadoresRow(oEnTrab.TipoDoc, oEnTrab.NumDoc, oEnTrab.ApePat,
                        oEnTrab.ApeMat, oEnTrab.Nombres, oEnTrab.NombreCompleto, oEnTrab.FecNac, oEnTrab.Sueldo.ToString(), oEnTrab.Ocupacion, String.Format("{0:00000}", Cont), oEnTrab.Ocupacion);
                }
            }
            else if (oEnCertificado.TIP_CERTIFICADO == "CRT")//Carta
            {
                dsCertificado.tbCarta.AddtbCartaRow(oEnCertificado.CONTRATANTE, oEnCertificado.DIRECCION_CONT, oEnCertificado.NUM_POLIZA);
                List<EN_Trabajador> lstTrab = new List<EN_Trabajador>();
                new AD_General().pr_RecuperarTrabajadorCertificado(oEnCertificado, ref lstTrab);
                foreach (EN_Trabajador oEnTrab in lstTrab)
                {
                    Cont++;
                    dsCertificado.tbTrabajadores.AddtbTrabajadoresRow(oEnTrab.TipoDoc, oEnTrab.NumDoc, oEnTrab.ApePat,
                        oEnTrab.ApeMat, oEnTrab.Nombres, oEnTrab.NombreCompleto, oEnTrab.FecNac, oEnTrab.Sueldo.ToString(), oEnTrab.Ocupacion, String.Format("{0:00}", Cont), oEnTrab.Ocupacion);
                }
            }
            else//if (objEN_General.Param08 == "CRG")//Cargo
            {
                dsCertificado.tbCargo.AddtbCargoRow(oEnCertificado.NUM_POLIZA, oEnCertificado.NUM_SPTO, oEnCertificado.NUM_APLI,
                    oEnCertificado.NUM_SPTO_APLI, oEnCertificado.CONTRATANTE, oEnCertificado.FEC_TRANSFERENCIA,
                    oEnCertificado.COD_DOCUM_CONT, String.Format("{0:dd/MM/yyyy hh:mm:ss}", DateTime.Now));
                List<EN_Trabajador> lstTrab = new List<EN_Trabajador>();
                new AD_General().pr_RecuperarTrabajadorCertificado(oEnCertificado, ref lstTrab);
                foreach (EN_Trabajador oEnTrab in lstTrab)
                {
                    Cont++;
                    dsCertificado.tbTrabajadores.AddtbTrabajadoresRow(oEnTrab.TipoDoc, oEnTrab.NumDoc, oEnTrab.ApePat,
                        oEnTrab.ApeMat, oEnTrab.Nombres, oEnTrab.NombreCompleto, oEnTrab.FecNac, oEnTrab.Sueldo.ToString(), oEnTrab.Ocupacion, String.Format("{0:00}", Cont), oEnTrab.Ocupacion);
                }
            }

            escribirlog(oEnCertificado.COD_SISTEMA, oEnCertificado.NUM_POLIZA + "|" + oEnCertificado.NUM_APLI, "NroPoliza|NroAplicacion", "ObtenerCertificadoDS() FIN DEL PROCEDIMIENTO");
        }
    }
}
