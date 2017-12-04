using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Runtime.Serialization;

namespace Entidades
{
    /// <summary>
    /// Registra la relación entre la tabla padrón de Asegurados(rcen_asegurados) y el Riesgos(DECASEG_0003) Guarda la planilla de Declaración o Inclusión.
    /// </summary>
    [DataContract]
    [Serializable]
    public class EN_DECASEG_0004 : EN_Comun
    {
        /// <summary>
        /// 
        /// </summary>
        [DataMember]
        public String COD_ASEG { get; set; }
        /// <summary>
        /// 
        /// </summary>
        [DataMember]
        public String NRO_MOVIMIENTO { get; set; }
        /// <summary>
        /// 
        /// </summary>
        [DataMember]
        public String COD_CIA { get; set; }
        /// <summary>
        /// 
        /// </summary>
        [DataMember]
        public String COD_RAMO { get; set; }
        /// <summary>
        /// 
        /// </summary>
        [DataMember]
        public String NUM_RIESGO { get; set; }
        /// <summary>
        /// 
        /// </summary>
        [DataMember]
        public String SUELDO { get; set; }
        /// <summary>
        /// 
        /// </summary>
        [DataMember]
        public Nullable<DateTime> FEC_INI_VIG { get; set; }
        /// <summary>
        /// 
        /// </summary>
        [DataMember]
        public Nullable<DateTime> FEC_FIN_VIG { get; set; }
    }
}
