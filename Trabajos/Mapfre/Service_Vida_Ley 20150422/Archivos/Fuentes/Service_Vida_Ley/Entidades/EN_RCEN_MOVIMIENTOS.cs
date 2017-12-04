using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Runtime.Serialization;

namespace Entidades
{
    /// <summary>
    /// Guarda los movimientos del asegurado en una Póliza, en este caso se modificara para Guardar también el número de movimiento de la tabla DECASEG_0001.
    /// </summary>
    [DataContract]
    [Serializable]
    public class EN_RCEN_MOVIMIENTOS : EN_Comun
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
        public String COD_MOVIM { get; set; }
        /// <summary>
        /// 
        /// </summary>
        [DataMember]
        public String NUM_POLIZA { get; set; }
        /// <summary>
        /// 
        /// </summary>
        [DataMember]
        public String NUM_SPTO { get; set; }
        /// <summary>
        /// 
        /// </summary>
        [DataMember]
        public String NUM_APLI { get; set; }
        /// <summary>
        /// 
        /// </summary>
        [DataMember]
        public String NUM_SPTO_APLI { get; set; }
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
    }
}
