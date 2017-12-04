using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Runtime.Serialization;

namespace Entidades
{
    [DataContract]
    [Serializable]
    public class EN_RCEN_ASEG0004_TEMP
    {
        [DataMember]
        public String NRO_MOVIMIENTO { get; set; }
        [DataMember]
        public String NRO_MOVIMIENTO_REG { get; set; }
        [DataMember]
        public String NRO_FILA { get; set; }
        [DataMember]
        public String TIPDOC { get; set; }
        [DataMember]
        public String NUMDOC { get; set; }
        [DataMember]
        public String APEPAT { get; set; }
        [DataMember]
        public String APEMAT { get; set; }
        [DataMember]
        public String NOMBRES { get; set; }
        [DataMember]
        public String NOMBRECOMPLETO { get; set; }
        [DataMember]
        public String FECNAC { get; set; }
        [DataMember]
        public String SUELDO { get; set; }
        [DataMember]
        public String OCUPACION { get; set; }
        [DataMember]
        public String COD_SISTEMA { get; set; }
        [DataMember]
        public String COD_USR_REG { get; set; }
        [DataMember]
        public String FEC_REG { get; set; }
        [DataMember]
        public String COD_USR_ACTU { get; set; }
        [DataMember]
        public String FEC_ACTU { get; set; }
        [DataMember]
        public String MENSAJE { get; set; }
    }
}
