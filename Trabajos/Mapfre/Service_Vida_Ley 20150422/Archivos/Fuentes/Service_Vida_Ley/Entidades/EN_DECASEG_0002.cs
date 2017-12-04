using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Runtime.Serialization;
namespace Entidades
{
    /// <summary>
    /// Registrara los datos de la Póliza (Llave completa) y el Numero del Recibo.
    /// </summary>
    [DataContract]
    [Serializable]
    public class EN_DECASEG_0002 : EN_Comun
    {
        /// <summary>
        /// Número de Movimiento.
        /// </summary>
        [DataMember]
        public String NRO_MOVIMIENTO { get; set; }
        /// <summary>
        /// Código  Compañia
        /// </summary>
        [DataMember]
        public String COD_CIA { get; set; }

        /// <summary>
        /// Razón Social Compañia
        /// </summary>
        [DataMember]
        public String NOM_RAZON_SOCIAL_CIA { get; set; }
        /// <summary>
        /// Razón Social Compañia 2
        /// </summary>
        [DataMember]
        public String NOM_RAZON_SOCIAL_CIA_2 { get; set; }
        /// <summary>
        /// Tipo Documento Compañia
        /// </summary>
        [DataMember]
        public String TIP_DOCUM_CIA { get; set; }
        /// <summary>
        /// Código Documento Compañia
        /// </summary>
        [DataMember]
        public String COD_DOCUM_CIA { get; set; }
        /// <summary>
        /// Dirección Número Compañia
        /// </summary>
        [DataMember]
        public String DIRECCION_CIA { get; set; }
        /// <summary>
        /// Teléfono Número Compañia
        /// </summary>
        [DataMember]
        public String TLF_NUMERO_CIA { get; set; }
        /// <summary>
        /// FAX Número Compañia
        /// </summary>
        [DataMember]
        public String FAX_NUMERO_CIA { get; set; }
        /// <summary>
        /// Código Ramo
        /// </summary>
        [DataMember]
        public String COD_RAMO { get; set; }
        /// <summary>
        /// Número de Recibo
        /// </summary>
        [DataMember]
        public String NUM_RECIBO { get; set; }
        /// <summary>
        /// Número de Aplicación
        /// </summary>
        [DataMember]
        public String NUM_APLI { get; set; }
        /// <summary>
        /// Número de Suplemento Aplicación
        /// </summary>
        [DataMember]
        public String NUM_SPTO_APLI { get; set; }
        /// <summary>
        /// Número de Suplemento
        /// </summary>
        [DataMember]
        public String NUM_SPTO { get; set; }
        /// <summary>
        /// Número de Póliza
        /// </summary>
        [DataMember]
        public String NUM_POLIZA { get; set; }
        /// <summary>
        /// Fecha de Emisión Póliza
        /// </summary>
        [DataMember]
        public String FEC_EMISION { get; set; }
        /// <summary>
        /// Fecha Inicio Vigencia
        /// </summary>
        [DataMember]
        public String FEC_INI_VIG { get; set; }
        /// <summary>
        /// Fecha Fin Vigencia
        /// </summary>
        [DataMember]
        public String FEC_FIN_VIG { get; set; }
        /// <summary>
        /// Código de Usuario
        /// </summary>
        [DataMember]
        public String COD_USUARIO { get; set; }
        /// <summary>
        /// Código de Sistema
        /// </summary>
        [DataMember]
        public String COD_SISTEMA { get; set; }

        /// <summary>
        /// Tipo Certificado
        /// </summary>
        [DataMember]
        public String TIP_CERTIFICADO { get; set; }
        /// <summary>
        /// Nombre Contratante
        /// </summary>
        [DataMember]
        public String CONTRATANTE { get; set; }
        /// <summary>
        /// Tipo Documento Contratante
        /// </summary>
        [DataMember]
        public String TIP_DOCUM_CONT { get; set; }
        /// <summary>
        /// Número Documento Contratante
        /// </summary>
        [DataMember]
        public String COD_DOCUM_CONT { get; set; }
        /// <summary>
        /// Dirección Contratante
        /// </summary>
        [DataMember]
        public String DIRECCION_CONT { get; set; }
        /// <summary>
        /// Teléfono Contratante
        /// </summary>
        [DataMember]
        public String TELEFONO_CONT { get; set; }
        /// <summary>
        /// Fecha Transferencia
        /// </summary>
        [DataMember]
        public String FEC_TRANSFERENCIA { get; set; }
    }
}
