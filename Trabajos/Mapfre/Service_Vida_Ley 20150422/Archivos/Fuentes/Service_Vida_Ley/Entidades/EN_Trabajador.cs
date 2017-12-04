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
    public class EN_Trabajador
    {
        #region Variables Privadas
        private int vNroSolicitud;
        private int vNroFila;
        private string vTipoDoc;
        private string vNumDoc;
        private string vApePat;
        private string vApeMat;
        private string vNombres;
        private string vNombreCompleto;
        private string vFecNac;
        private double vSueldo = 0D;
        private string vCodUserReg;
        private string vError;
        private int vTipo;
        private string vOcupacion;
        #endregion

        #region Variables Publicas

        public int NroSolicitud { get { return vNroSolicitud; } set { vNroSolicitud = value; } }
        public int NroFila { get { return vNroFila; } set { vNroFila = value; } }
        public string TipoDoc { get { return vTipoDoc; } set { vTipoDoc = value; } }
        public string NumDoc { get { return vNumDoc; } set { vNumDoc = value; } }
        public string ApePat { get { return vApePat; } set { vApePat = value; } }
        public string ApeMat { get { return vApeMat; } set { vApeMat = value; } }
        public string Nombres { get { return vNombres; } set { vNombres = value; } }
        public string NombreCompleto { get { return vNombreCompleto; } set { vNombreCompleto = value; } }
        public string FecNac { get { return vFecNac; } set { vFecNac = value; } }
        public double Sueldo { get { return vSueldo; } set { vSueldo = value; } }
        public string CodUserReg { get { return vCodUserReg; } set { vCodUserReg = value; } }

        public string Error { get { return vError; } set { vError = value; } }
        public int Tipo { get { return vTipo; } set { vTipo = value; } }

        public string Ocupacion { get { return vOcupacion; } set { vOcupacion = value; } }
        #endregion
    }
}