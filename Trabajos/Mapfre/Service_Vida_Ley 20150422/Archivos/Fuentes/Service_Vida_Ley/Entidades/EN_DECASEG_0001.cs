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
    public class EN_DECASEG_0001:EN_Comun
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
        public String RUC { get; set; }
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
        /// <summary>
        /// 
        /// </summary>
        [DataMember]
        public String TIPO_MOVIMIENTO{ get; set; }
        /// <summary>
        /// 
        /// </summary>
        [DataMember]
        public String MCA_FACTURADO{ get; set; }
        /// <summary>
        /// 
        /// </summary>
        [DataMember]
        public String MCA_BAJA { get; set; }
    }
}
