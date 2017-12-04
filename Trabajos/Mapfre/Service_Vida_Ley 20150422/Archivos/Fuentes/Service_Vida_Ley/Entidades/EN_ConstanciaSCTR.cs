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
    public class EN_ConstanciaSCTR
    {
        #region Variables Privadas
        private int vSecuencialConstancia = 0;
        private String vNumeroConstancia = String.Empty;
        private String vNumeroPolizaPension = String.Empty;
        private String vRazonSocial = String.Empty;
        private String vFechaInicioVigencia;
        private String vFechaFinVigencia;
        private String vNumeroPolizaSalud = String.Empty;
        private String vNumeroPolizaVL = String.Empty;
        private String vUbicacionTrabajo = String.Empty;
        private String vFechaMovimiento;
        private String vNombreCompleto = String.Empty;
        #endregion

        #region Propiedades Públicas
        public int SecuencialConstancia { get { return vSecuencialConstancia; } set { vSecuencialConstancia = value; } }
        public String NumeroConstancia { get { return vNumeroConstancia; } set { vNumeroConstancia = value; } }
        public String NumeroPolizaPension { get { return vNumeroPolizaPension; } set { vNumeroPolizaPension = value; } }
        public String RazonSocial { get { return vRazonSocial; } set { vRazonSocial = value; } }
        public String FechaInicioVigencia { get { return vFechaInicioVigencia; } set { vFechaInicioVigencia = value; } }
        public String FechaFinVigencia { get { return vFechaFinVigencia; } set { vFechaFinVigencia = value; } }
        public String NumeroPolizaSalud { get { return vNumeroPolizaSalud; } set { vNumeroPolizaSalud = value; } }

        public String NumeroPolizaVL { get { return vNumeroPolizaVL; } set { vNumeroPolizaVL = value; } }
        public String UbicacionTrabajo { get { return vUbicacionTrabajo; } set { vUbicacionTrabajo = value; } }
        public String FechaMovimiento { get { return vFechaMovimiento; } set { vFechaMovimiento = value; } }
        public String NombreCompleto { get { return vNombreCompleto; } set { vNombreCompleto = value; } }
        public String NombreUsuario { get { return vNombreCompleto; } set { vNombreCompleto = value; } }

        #endregion
    }
}