using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Runtime.Serialization;

namespace Entidades
{
    /// <summary>
    /// Tabla padrón de asegurados.
    /// </summary>
    [DataContract]
    [Serializable]
    public class EN_RCEN_ASEGURADOS : EN_Comun
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
        public String TIP_DOCUM { get; set; }
        /// <summary>
        /// 
        /// </summary>
        [DataMember]
        public String COD_DOCUM { get; set; }
        /// <summary>
        /// 
        /// </summary>
        [DataMember]
        public String NOMBRE { get; set; }
        /// <summary>
        /// 
        /// </summary>
        [DataMember]
        public String APE_PATER { get; set; }
        /// <summary>
        /// 
        /// </summary>
        [DataMember]
        public String APE_MATER { get; set; }
        /// <summary>
        /// 
        /// </summary>
        [DataMember]
        public String NOM_COMPLETO { get; set; }
        /// <summary>
        /// 
        /// </summary>
        [DataMember]
        public Nullable<DateTime> FEC_NACIMIENTO{ get; set; }
    }
}
