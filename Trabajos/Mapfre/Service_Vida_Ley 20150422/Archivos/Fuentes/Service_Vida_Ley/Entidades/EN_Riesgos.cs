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
    public class EN_Riesgos
    {
        #region Variables Privadas

        private int vCantTrab;
        private int vCodCia;
        private int vCodRamo;
        private string vCodUserReg;
        private double vFactor = 0D;
        private DateTime vFecActu;
        private DateTime vFecReg;
        private double vImporPlanilla = 0D;
        private int vNroSolicitud;
        private int vNroRiesgo;
        private double vPrimaNeta = 0D;
        private string vRiesgo;
        private double vSubTotal = 0D;
        private double vTasa = 0D;
        private string vNumPoliza;
        private int vNumSpto;
        private int vNumApli;
        private int vNumSptoApli;
        private int vNumRecibo;
        private double vPrimaTotal = 0D;

        //Datos adicionales
        private int vTipo;
        private Int32 vRetorno;
        private string vMensajeRet;
        private double vImporteRecargo = 0D;
        private double vImporteIntereses = 0D;
        private double vImporteIgv = 0D;
        private string vFecVctoRecibo;
        private string vNombreRiesgo;
        //Temporal solo para enviar al Emitir
        private int vCantTrabSal;
        private double vImporPlanillaSal = 0D;
        private double vTasaSal = 0D;
        //private EN_Poliza voEnPol = new EN_Poliza();

        #endregion

        #region Variables Públicas

        public int CantTrab { get { return vCantTrab; } set { vCantTrab = value; } }
        public int CodCia { get { return vCodCia; } set { vCodCia = value; } }
        public int CodRamo { get { return vCodRamo; } set { vCodRamo = value; } }
        public string CodUserReg { get { return vCodUserReg; } set { vCodUserReg = value; } }
        public double Factor { get { return vFactor; } set { vFactor = value; } }
        public DateTime FecActu { get { return vFecActu; } set { vFecActu = value; } }
        public DateTime FecReg { get { return vFecReg; } set { vFecReg = value; } }
        public double ImporPlanilla { get { return vImporPlanilla; } set { vImporPlanilla = value; } }
        public int NroSolicitud { get { return vNroSolicitud; } set { vNroSolicitud = value; } }
        public int NroRiesgo { get { return vNroRiesgo; } set { vNroRiesgo = value; } }
        public double PrimaNeta { get { return vPrimaNeta; } set { vPrimaNeta = value; } }
        public string Riesgo { get { return vRiesgo; } set { vRiesgo = value; } }
        public double SubTotal { get { return vSubTotal; } set { vSubTotal = value; } }
        public double Tasa { get { return vTasa; } set { vTasa = value; } }
        public string NumPoliza { get { return vNumPoliza; } set { vNumPoliza = value; } }
        public int NumSpto { get { return vNumSpto; } set { vNumSpto = value; } }
        public int NumApli { get { return vNumApli; } set { vNumApli = value; } }
        public int NumSptoApli { get { return vNumSptoApli; } set { vNumSptoApli = value; } }
        public int NumRecibo { get { return vNumRecibo; } set { vNumRecibo = value; } }
        public double PrimaTotal { get { return vPrimaTotal; } set { vPrimaTotal = value; } }
        public int Tipo { get { return vTipo; } set { vTipo = value; } }
        public Int32 Retorno { get { return vRetorno; } set { vRetorno = value; } }
        public string MensajeRet { get { return vMensajeRet; } set { vMensajeRet = value; } }
        public double ImporteRecargo { get { return vImporteRecargo; } set { vImporteRecargo = value; } }
        public double ImporteIntereses { get { return vImporteIntereses; } set { vImporteIntereses = value; } }
        public double ImporteIgv { get { return vImporteIgv; } set { vImporteIgv = value; } }
        public string FecVctoRecibo { get { return vFecVctoRecibo; } set { vFecVctoRecibo = value; } }
        public string NombreRiesgo { get { return vNombreRiesgo; } set { vNombreRiesgo = value; } }
        public int CantTrabSal { get { return vCantTrabSal; } set { vCantTrabSal = value; } }
        public double ImporPlanillaSal { get { return vImporPlanillaSal; } set { vImporPlanillaSal = value; } }
        public double TasaSal { get { return vTasaSal; } set { vTasaSal = value; } }
        //public EN_Poliza oEnPol { get { return voEnPol; } set { voEnPol = value; } }

        #endregion
    }
}
