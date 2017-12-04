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
    public class EN_Aplicacion:EN_Comun
    {
        #region Variables Privadas

        private int vNroAplicacion = 0;
        private string vFecEfectoApli = string.Empty;
        private string vFecVctoApli = string.Empty;
        private string vFecEmisionPoliza = string.Empty;
        private EN_Empresa voEnEmp = new EN_Empresa();
        private String vNombrePdf = String.Empty;

        #endregion

        #region Propiedades Públicas

        public int NroAplicacion { get { return vNroAplicacion; } set { vNroAplicacion = value; } }
        public string FecEfectoApli { get { return vFecEfectoApli; } set { vFecEfectoApli = value; } }
        public string FecVctoApli { get { return vFecVctoApli; } set { vFecVctoApli = value; } }
        public string FecEmisionPoliza { get { return vFecEmisionPoliza; } set { vFecEmisionPoliza = value; } }
        public EN_Empresa oEnEmp { get { return voEnEmp; } set { voEnEmp = value; } }
        public String NombrePdf { get { return vNombrePdf; } set { vNombrePdf = value; } }

        #endregion
    }
}
