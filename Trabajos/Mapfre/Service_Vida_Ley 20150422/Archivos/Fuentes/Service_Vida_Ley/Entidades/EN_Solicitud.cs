using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Runtime.Serialization;

namespace Entidades
{
    /// <summary>
    /// Tabla cabecera que indica un numero de Movimiento ya sea de Tipo Declaración o de Inclusión o de Generación 
    /// </summary>
    [DataContract]
    [Serializable]
    public class EN_Solicitud
    {
        #region Variables Privadas

        //Datos de solicitud
        private int vNroSolicitud;
        private string vTipPeriodo;
        private string vEmailSolicitud;
        private string vCentroRiesgo;
        private string vColegAseg;
        private string vCodSuscriptor;
        private string vCodEstado;
        private string vDescEstado;
        private string vCodUsuReg;
        private DateTime vFecReg;
        private DateTime vFecSolicitud;
        private string vFecSolicitudCad;
        private DateTime vFecAprobacion;
        private DateTime vFecRechazada;
        private DateTime vFecAceptada;
        private DateTime vFecRechTaza;
        private string vCodUserActu;
        private DateTime vFecActu;
        private string vTipoDoc;
        private string vNroDoc;
        private string vFormaPago;
        private DateTime vFecEfecPoliza;
        private DateTime vFecVctoPoliza;
        private int vCodAgt;
        private string vCodCIIUPol;

        //Datos de Poliza
        private string vNumPoliza;
        private string vNumRecibo;
        private int vCodCia;
        private int vCodRamo;

        //Parametros
        private string vRazonSocial;
        private DateTime vFecIni;
        private DateTime vFecFinal;
        private string vFecIniCad;
        private string vFecFinalCad;
        private string vRolUsu;

        //Paginación
        private int vNumPagina;
        private int vTamPagina;
        private int vTotRegistro;

        //Datos adicionales        
        private int vTipo;
        private int vNroRiesgo;
        private int vSecuenciaReg;
        private string vDescAgt;
        private string vDescCIIUPol;
        private string vEmailEmp;
        private string vMca_emi_pol;
        //private EN_Suscriptor voEnSusc = new EN_Suscriptor();
        private string vMoneda;
        private int vNroConstancia = 0;

        #endregion

        #region Propiedades Públicas
        public int NroSolicitud { get { return vNroSolicitud; } set { vNroSolicitud = value; } }
        public string TipPeriodo { get { return vTipPeriodo; } set { vTipPeriodo = value; } }
        public string EmailSolicitud { get { return vEmailSolicitud; } set { vEmailSolicitud = value; } }
        public string CentroRiesgo { get { return vCentroRiesgo; } set { vCentroRiesgo = value; } }
        public string ColegAseg { get { return vColegAseg; } set { vColegAseg = value; } }
        public string CodSuscriptor { get { return vCodSuscriptor; } set { vCodSuscriptor = value; } }
        public string CodEstado { get { return vCodEstado; } set { vCodEstado = value; } }
        public string DescEstado { get { return vDescEstado; } set { vDescEstado = value; } }
        public string CodUsuReg { get { return vCodUsuReg; } set { vCodUsuReg = value; } }
        public DateTime FecReg { get { return vFecReg; } set { vFecReg = value; } }
        public DateTime FecSolicitud { get { return vFecSolicitud; } set { vFecSolicitud = value; } }
        public string FecSolicitudCad { get { return vFecSolicitudCad; } set { vFecSolicitudCad = value; } }
        public DateTime FecAprobacion { get { return vFecAprobacion; } set { vFecAprobacion = value; } }
        public DateTime FecRechazada { get { return vFecRechazada; } set { vFecRechazada = value; } }
        public DateTime FecAceptada { get { return vFecAceptada; } set { vFecAceptada = value; } }
        public DateTime FecRechTaza { get { return vFecRechTaza; } set { vFecRechTaza = value; } }
        public string CodUserActu { get { return vCodUserActu; } set { vCodUserActu = value; } }
        public DateTime FecActu { get { return vFecActu; } set { vFecActu = value; } }
        public string TipoDoc { get { return vTipoDoc; } set { vTipoDoc = value; } }
        public string NroDoc { get { return vNroDoc; } set { vNroDoc = value; } }
        public string FormaPago { get { return vFormaPago; } set { vFormaPago = value; } }
        public DateTime FecEfecPoliza { get { return vFecEfecPoliza; } set { vFecEfecPoliza = value; } }
        public DateTime FecVctoPoliza { get { return vFecVctoPoliza; } set { vFecVctoPoliza = value; } }
        public int CodAgt { get { return vCodAgt; } set { vCodAgt = value; } }
        public string CodCIIUPol { get { return vCodCIIUPol; } set { vCodCIIUPol = value; } }
        public string NumPoliza { get { return vNumPoliza; } set { vNumPoliza = value; } }
        public string NumRecibo { get { return vNumRecibo; } set { vNumRecibo = value; } }
        public string RazonSocial { get { return vRazonSocial; } set { vRazonSocial = value; } }
        public DateTime FecIni { get { return vFecIni; } set { vFecIni = value; } }
        public DateTime FecFinal { get { return vFecFinal; } set { vFecFinal = value; } }
        public string FecIniCad { get { return vFecIniCad; } set { vFecIniCad = value; } }
        public string FecFinalCad { get { return vFecFinalCad; } set { vFecFinalCad = value; } }
        public string RolUsu { get { return vRolUsu; } set { vRolUsu = value; } }
        public int NumPagina { get { return vNumPagina; } set { vNumPagina = value; } }
        public int TamPagina { get { return vTamPagina; } set { vTamPagina = value; } }
        public int TotRegistro { get { return vTotRegistro; } set { vTotRegistro = value; } }
        public int CodCia { get { return vCodCia; } set { vCodCia = value; } }
        public int CodRamo { get { return vCodRamo; } set { vCodRamo = value; } }
        public int Tipo { get { return vTipo; } set { vTipo = value; } }
        public int NroRiesgo { get { return vNroRiesgo; } set { vNroRiesgo = value; } }
        public int SecuenciaReg { get { return vSecuenciaReg; } set { vSecuenciaReg = value; } }
        public string DescAgt { get { return vDescAgt; } set { vDescAgt = value; } }
        public string DescCIIUPol { get { return vDescCIIUPol; } set { vDescCIIUPol = value; } }
        public string EmailEmp { get { return vEmailEmp; } set { vEmailEmp = value; } }
        public string Mca_emi_pol { get { return vMca_emi_pol; } set { vMca_emi_pol = value; } }
        //public EN_Suscriptor oEnSusc { get { return voEnSusc; } set { voEnSusc = value; } }
        public string Moneda { get { return vMoneda; } set { vMoneda = value; } }
        public int NroConstancia { get { return vNroConstancia; } set { vNroConstancia = value; } }
        #endregion
    }
}
