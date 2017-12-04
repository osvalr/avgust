using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace Entidades
{
    [DataContract]
    [Serializable]
    public class EN_Asegurado : EN_Comun
    {

        [DataMember]
        public String MCA_RESETEO { get; set; }

        [DataMember]
        public String COD_CIA { get; set; }

        [DataMember]
        public String NUM_POLIZA { get; set; }

        [DataMember]
        public String NUM_SPTO { get; set; }

        [DataMember]
        public String NUM_APLI { get; set; }

        [DataMember]
        public String NUM_SPTO_APLI { get; set; }

        [DataMember]
        public String NUM_POLIZA_ENLACE { get; set; }

        //Info asegurados
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
        public String SUELDO { get; set; }
        [DataMember]
        public String FECNAC { get; set; }
        [DataMember]
        public String OCUPACION { get; set; }
        //Fin Info Asegurados
        
        [DataMember]
        public String COD_SISTEMA { get; set; }
        [DataMember]
        public String COD_USR_REG { get; set; }

    }
}
