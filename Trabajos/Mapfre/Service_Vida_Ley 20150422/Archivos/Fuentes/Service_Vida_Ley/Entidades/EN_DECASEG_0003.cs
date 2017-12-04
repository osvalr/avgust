using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Runtime.Serialization;

namespace Entidades
{
    /// <summary>
    /// Registra los datos de los riegos a Declarar o Inclusión.
    /// </summary>
    [DataContract]
    [Serializable]
    public class EN_DECASEG_0003 : EN_Comun
    {
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
        public String RIESGO { get; set; }
        /// <summary>
        /// 
        /// </summary>
        [DataMember]
        public String CANT_TRAB { get; set; }

        /// <summary>
        /// 
        /// </summary>
        [DataMember]
        public String IMPOR_PLANILLA { get; set; }
        /// <summary>
        /// 
        /// </summary>
        [DataMember]
        public String TASA { get; set; }
        /// <summary>
        /// 
        /// </summary>
        [DataMember]
        public String SUB_TOTAL { get; set; }
        /// <summary>
        /// 
        /// </summary>
        [DataMember]
        public String PRIMA_NETA { get; set; }
        /// <summary>
        /// 
        /// </summary>
        [DataMember]
        public String FACTOR { get; set; }
        /// <summary>
        /// 
        /// </summary>
        [DataMember]
        public String PRIMA_TOTAL { get; set; }
    }
}
