using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Runtime.Serialization;

namespace Entidades
{
    /// <summary>
    /// Guarda los datos cabecera de una constancia.
    /// </summary>
    [DataContract]
    [Serializable]
    public class EN_DECASEG_0006 : EN_Comun
    {
        /// <summary>
        /// 
        /// </summary>
        [DataMember]
        public String ValNRO_CONSTANCIAor { get; set; }
        /// <summary>
        /// 
        /// </summary>
        [DataMember]
        public String UBICACION { get; set; }
    }
}
