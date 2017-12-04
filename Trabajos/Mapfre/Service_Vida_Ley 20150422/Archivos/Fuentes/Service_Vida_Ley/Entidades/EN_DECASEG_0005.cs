using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Runtime.Serialization;

namespace Entidades
{
    /// <summary>
    /// Guarda Los datos detalle de una constancia, en este caso la Planilla.
    /// </summary>
    [DataContract]
    [Serializable]
    public class EN_DECASEG_0005 : EN_Comun
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
        public String NRO_CONSTANCIA { get; set; }
    }
}
