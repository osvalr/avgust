using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Runtime.Serialization;

namespace Entidades
{
    [Serializable]
    [DataContract]
    public class EN_Comun
    {
        [DataMember]
        public string USU_CREA { get; set; }
        [DataMember]
        public Nullable<DateTime> FEC_CREA { get; set; }
        [DataMember]
        public string USU_ACT { get; set; }
        [DataMember]
        public Nullable<DateTime> FEC_ACT { get; set; }
        [DataMember]
        public int NumPagina { get; set; }//Thony
        [DataMember]
        public int TamnioPagina { get; set; }//Thony
        [DataMember]
        public int CantidadRegistros { get; set; }//Thony

        //Hirving
        [DataMember]
        public int Accion { get; set; }
        [DataMember]
        public String Nuevo { get; set; }
        [DataMember]
        public String IndicadorDictamen { get; set; }

    }
}
