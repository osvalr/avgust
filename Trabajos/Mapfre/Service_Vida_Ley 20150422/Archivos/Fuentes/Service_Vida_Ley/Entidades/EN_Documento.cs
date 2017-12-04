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
    public class EN_Documento : EN_Comun
    {
        /* private String lcPoliza;
    private Int32 lnNumSpto;
    private Int32 lnNumApli;
    private Int32 lnNumSptoApli;
    private String lcCodApli;
    private String lcDscDocumento;
    private String lcRuta;
    private String lcUsuario;
    private String lcExtension;
    private String lcNombre;
    private Int32 lnRamo;
    private Int32 lnCia;
    private Int32 lnSize;
    private Byte[] lcFile;*/
        /// <summary>
        /// Archivo
        /// </summary>
        [DataMember]
        public Byte[] File { get; set; }
        /// <summary>
        /// Código de APlicación
        /// </summary>
        [DataMember]
        public String CodApli { get; set; }
        /// <summary>
        /// Ruta del Documento
        /// </summary>
        [DataMember]
        public String Ruta { get; set; }
        /// <summary>
        /// Descrpción del Documento
        /// </summary>
        [DataMember]
        public String DscDocumento { get; set; }
        /// <summary>
        /// Número de Póliza
        /// </summary>
        [DataMember]
        public String Poliza { get; set; }
        /// <summary>
        /// Extensión del Archivo
        /// </summary>
        [DataMember]
        public String Extension { get; set; }
        /// <summary>
        /// Nombre del Archivo
        /// </summary>
        [DataMember]
        public String Nombre { get; set; }
        /// <summary>
        /// Tamaño del Archivo
        /// </summary>
        [DataMember]
        public Int32 Size { get; set; }
        /// <summary>
        /// Número de Suplemento
        /// </summary>
        [DataMember]
        public String NumSpto { get; set; }
        /// <summary>
        /// Número de Aplicación
        /// </summary>
        [DataMember]
        public String NumApli { get; set; }
        /// <summary>
        /// Número de Suplemento Aplicación
        /// </summary>
        [DataMember]
        public String NumSptoApli { get; set; }
        /// <summary>
        /// Código de Compañia
        /// </summary>
        [DataMember]
        public String Cia { get; set; }
        /// <summary>
        /// Código de Ramo
        /// </summary>
        [DataMember]
        public Int32 Ramo { get; set; }
        /// <summary>
        /// Código de Usuario
        /// </summary>
        [DataMember]
        public String Usuario { get; set; }
    }
}
