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
    public class EN_General : EN_Comun
    {
        [DataMember]
        public String Param00 { get; set; }
        [DataMember]
        public String Param01 { get; set; }
        [DataMember]
        public String Param02 { get; set; }
        [DataMember]
        public String Param03 { get; set; }
        [DataMember]
        public String Param04 { get; set; }
        [DataMember]
        public String Param05 { get; set; }
        [DataMember]
        public String Param06 { get; set; }
        [DataMember]
        public String Param07 { get; set; }
        [DataMember]
        public String Param08 { get; set; }
        [DataMember]
        public String Param09 { get; set; }
        [DataMember]
        public String Param10 { get; set; }
        [DataMember]
        public String Param11 { get; set; }
        [DataMember]
        public String Param12 { get; set; }
        [DataMember]
        public String Param13 { get; set; }
        [DataMember]
        public String Param14 { get; set; }
        [DataMember]
        public String Param15 { get; set; }
        [DataMember]
        public String Param16 { get; set; }
        [DataMember]
        public String Param17 { get; set; }
        [DataMember]
        public String Param18 { get; set; }
        [DataMember]
        public String Param19 { get; set; }
        [DataMember]
        public String Param20 { get; set; }
        [DataMember]
        public String Param21 { get; set; }
        [DataMember]
        public String Param22 { get; set; }
        [DataMember]
        public String Param23 { get; set; }
        [DataMember]
        public String Param24 { get; set; }
        [DataMember]
        public String Param25 { get; set; }
        [DataMember]
        public String Param26 { get; set; }
        [DataMember]
        public String Param27 { get; set; }
        [DataMember]
        public String Param28 { get; set; }
        [DataMember]
        public String Param29 { get; set; }
        [DataMember]
        public String Param30 { get; set; }
        [DataMember]
        public String Param31 { get; set; }
        [DataMember]
        public String Param32 { get; set; }
        [DataMember]
        public String Param33 { get; set; }
        [DataMember]
        public String Param34 { get; set; }
        [DataMember]
        public String Param35 { get; set; }
        [DataMember]
        public String Param36 { get; set; }
        [DataMember]
        public String Param37 { get; set; }
        [DataMember]
        public String Param38 { get; set; }
        [DataMember]
        public String Param39 { get; set; }
        /// <summary>
        /// Agregar Items(0:SELECCIONE - 1:TODOS)
        /// </summary>
        [DataMember]
        public String ItemInicio { get; set; }
    }
}
