using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using Entidades;
using LogicaNegocio;

namespace ws_ServiceCentral
{
    /// <summary>
    /// Summary description for wsAsegurados
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class wsAsegurados : System.Web.Services.WebService
    {
        /// <summary>
        /// Archivo Excel con el formato de la trama de asegurados de SCTR, el nombre físico será el número de la póliza.
        /// </summary>
        /// <param name="Num_Poliza">Número de Póliza.</param>
        /// <returns>OK, ER</returns>
        [WebMethod]
        public string CrearExcel(String Num_Poliza)
        {
            LN_General objLN_General = new LN_General();
            return objLN_General.fr_CrearExcel(Num_Poliza);
        }
        /// <summary>
        /// Lee el archivo físico y grabar a las tablas temporales.
        /// </summary>
        /// <param name="Cod_Cia">Código de Compañia.</param>
        /// <param name="Num_Poliza">Número de Póliza.</param>
        /// <param name="Num_Spto">Número de Suplemento.</param>
        /// <param name="Num_Apli">Número de Aplicación.</param>
        /// <param name="Num_Spto_Apli">Número Suplemento Aplicación.</param>
        /// <param name="Cod_Usuario">Código de Usuario.</param>
        /// <param name="Cod_Sistema">Código del Sistema.</param>
        /// <returns>Nro Movimiento</returns>
        [WebMethod]
        public string CargarTrama(String Cod_Cia, String Num_Poliza, String Num_Spto, String Num_Apli, String Num_Spto_Apli, String Cod_Usuario, String Cod_Sistema)
        {
            LN_General objLN_General = new LN_General();
            EN_General objEN_General = new EN_General();
            objEN_General.Param00 = Cod_Cia;
            objEN_General.Param01 = Num_Poliza;
            objEN_General.Param02 = Num_Spto;
            objEN_General.Param03 = Num_Apli;
            objEN_General.Param04 = Num_Spto_Apli;
            objEN_General.Param05 = Cod_Usuario.ToUpper();
            objEN_General.Param06 = Cod_Sistema.ToUpper();
            return objLN_General.fr_CargarTrama(objEN_General);
        }

        //Begin 27/08/2015 JRaffo
        /// <summary>
        /// Graba en las tablas temporales la información del asegurado.
        /// </summary>
        /// <param name="Cod_Cia">Mca_Reseteo</param>
        /// <param name="Cod_Cia">Código de Compañia.</param>
        /// <param name="Num_Poliza">Número de Póliza.</param>
        /// <param name="Num_Spto">Número de Suplemento.</param>
        /// <param name="Num_Apli">Número de Aplicación.</param>
        /// /// <param name="Num_Apli">Num_Poliza_Enlace</param>
        /// <param name="Num_Spto_Apli">Número Suplemento Aplicación.</param>
        /// <param name="Cod_Usuario">Código de Usuario.</param>
        /// <param name="Cod_Sistema">Código del Sistema.</param>
        /// <param name="Cod_Sistema">Tipo_Doc</param>
        /// <param name="Cod_Sistema">Num_Doc</param>
        /// <param name="Cod_Sistema">Ape_Paterno</param>
        /// <param name="Cod_Sistema">Ape_Materno</param>
        /// <param name="Cod_Sistema">Nombre</param>
        /// <param name="Cod_Sistema">Nombre_Completo</param>
        /// <param name="Cod_Sistema">Sueldo</param>
        /// <param name="Cod_Sistema">Fecha_Nacimiento</param>
        /// <param name="Cod_Sistema">Ocupacion</param>
        /// <returns>Nro Movimiento</returns>
        
        [WebMethod]
        public string CargarAsegurado
            (
            String Mca_Reseteo,
            String Cod_Cia, 
            String Num_Poliza, 
            String Num_Spto, 
            String Num_Apli, 
            String Num_Spto_Apli, 
            String Num_Poliza_Enlace,
            String Cod_Usuario, 
            String Cod_Sistema,
            String Tipo_Doc,
            String Num_Doc,
            String Ape_Paterno,
            String Ape_Materno,
            String Nombre,
            String Nombre_Completo,
            String Sueldo,
            String Fecha_Nacimiento,
            String Ocupacion
            )
        {
            LN_General objLN_General = new LN_General();
            EN_Asegurado enAsegurado = new EN_Asegurado();

            //info de polizas
            enAsegurado.MCA_RESETEO = Mca_Reseteo;
            enAsegurado.COD_CIA = Cod_Cia;
            enAsegurado.NUM_POLIZA = Num_Poliza;
            enAsegurado.NUM_SPTO = Num_Spto;
            enAsegurado.NUM_APLI = Num_Apli;
            enAsegurado.NUM_SPTO_APLI = Num_Spto_Apli;
            enAsegurado.NUM_POLIZA_ENLACE = Num_Poliza_Enlace;
            //fin

            // info asegurado
            enAsegurado.TIPDOC = Tipo_Doc;
            enAsegurado.NUMDOC = Num_Doc;
            enAsegurado.APEPAT = Ape_Paterno;
            enAsegurado.APEMAT = Ape_Materno;
            enAsegurado.NOMBRES = Nombre;
            enAsegurado.NOMBRECOMPLETO = Nombre_Completo;
            enAsegurado.SUELDO = Sueldo;
            enAsegurado.FECNAC = Fecha_Nacimiento;
            enAsegurado.OCUPACION = Ocupacion;
            //fin

            //Audotoria
            enAsegurado.COD_USR_REG = Cod_Usuario.ToUpper();
            enAsegurado.COD_SISTEMA = Cod_Sistema.ToUpper();

            //Entidad general
            EN_General objEN_General = new EN_General();
            objEN_General.Param00 = Cod_Cia;
            objEN_General.Param01 = Num_Poliza;
            objEN_General.Param02 = Num_Spto;
            objEN_General.Param03 = Num_Apli;
            objEN_General.Param04 = Num_Spto_Apli;
            objEN_General.Param05 = Cod_Usuario.ToUpper();
            objEN_General.Param06 = Cod_Sistema.ToUpper();

            return objLN_General.fr_CargarAsegurado(objEN_General,enAsegurado);
        }
        //End 27/08/2015 JRaffo

        /// <summary>
        /// Revisar todos los registros cargados en la tabla temporal.
        /// </summary>
        /// <param name="Cod_Cia">Código de Compañia.</param>
        /// <param name="Num_Poliza">Número de Póliza.</param>
        /// <param name="Num_Spto">Número de Suplemento.</param>
        /// <param name="Num_Apli">Número de Aplicación.</param>
        /// <param name="Num_Spto_Apli">Número de Suplemento Aplicación.</param>
        /// <param name="Cod_Usuario">Código de Usuario.</param>
        /// <param name="Cod_Sistema">Código de Sistema.</param>
        /// <returns>OK y ER:MsjError.</returns>
        [WebMethod]
        public string ValidarTrama(String Num_Mvto, String Cod_Cia, String Num_Poliza, String Num_Spto, String Num_Apli, String Num_Spto_Apli, String Cod_Usuario, String Cod_Sistema)
        {
            LN_General objLN_General = new LN_General();
            EN_General objEN_General = new EN_General();
            objEN_General.Param00 = Num_Mvto;
            objEN_General.Param01 = Cod_Cia;
            objEN_General.Param02 = Num_Poliza;
            objEN_General.Param03 = Num_Spto;
            objEN_General.Param04 = Num_Apli;
            objEN_General.Param05 = Num_Spto_Apli;
            objEN_General.Param06 = Cod_Usuario.ToUpper();
            objEN_General.Param07 = Cod_Sistema.ToUpper();
            return objLN_General.fr_ValidarTrama(objEN_General);
        }
        /// <summary>
        /// Registra los datos de las Tablas temporales en las Tablas finales y transferir los asegurados a la tabla centralizada.
        /// </summary>
        /// <param name="Num_Movi">Número de Movimiento.</param>
        /// <param name="Cod_Cia">Código de Compañia.</param>
        /// <param name="Num_Poliza">Número de Póliza.</param>
        /// <param name="Num_Spto">Número de Suplemento.</param>
        /// <param name="Num_Apli">Número de Aplicación.</param>
        /// <param name="Num_Spto_Apli">Número de Suplemento Aplicación.</param>
        /// <param name="Tipo_Movimiento">Tipo de Movimiento.</param>
        /// <param name="Mca_Facturado">Marca Facturado.</param>
        /// <param name="Cod_Usuario">Código de Usuario</param>
        /// <param name="Cod_Sistema">Código de Sistema.</param>
        /// <returns>OK,SI,ER</returns>
        [WebMethod]
        public string RegistrarMovimiento(String Num_Movi, String Cod_Cia,String Num_Poliza,String Num_Spto,String Num_Apli,String Num_Spto_Apli,
String Tipo_Movimiento,String Mca_Facturado,String Cod_Usuario,String Cod_Sistema
)
        {
            LN_General objLN_General = new LN_General();
            EN_General objEN_General = new EN_General();
            objEN_General.Param00 = Num_Movi;
            objEN_General.Param01 = Cod_Cia;
            objEN_General.Param02 = Num_Poliza;
            objEN_General.Param03 = Num_Spto;
            objEN_General.Param04 = Num_Apli;
            objEN_General.Param05 = Num_Spto_Apli;
            objEN_General.Param06 = Tipo_Movimiento;
            objEN_General.Param07 = Mca_Facturado;
            objEN_General.Param08 = Cod_Usuario.ToUpper();
            objEN_General.Param09 = Cod_Sistema.ToUpper();
            return objLN_General.fr_RegistrarMovimiento(objEN_General);
        }
        /// <summary>
        /// Lanza el proceso de emisión declaración/inclusión en tronador.
        /// </summary>
        /// <param name="Num_Mvto">Número de Movimiento.</param>
        /// <returns>OK y ER:MsjError.</returns>
        [WebMethod]
        public string GenerarRecibo(String Num_Mvto, String Tip_Movimiento, String Cod_Cia, String Cod_Ramo)
        {
            LN_General objLN_General = new LN_General();
            EN_General objEN_General = new EN_General();
            objEN_General.Param00 = Num_Mvto;
            objEN_General.Param01 = Tip_Movimiento;
            objEN_General.Param02 = Cod_Cia;
            objEN_General.Param03 = Cod_Ramo;
            return objLN_General.fr_GenerarRecibo(objEN_General);
        }
        /// <summary>
        /// Imprime del recibo en formato PDF y dejarlo en el directorio “V”, la información lo sacara desde mismo tronador a través del número de recibo.
        /// </summary>
        /// <param name="NroRecibo">Número de Recibo.</param>
        /// <returns>OK y ER:MsjError.</returns>
        [WebMethod]
        public string ImprimirRecibo(String NroRecibo)
        {
            LN_General objLN_General = new LN_General();
            EN_General objEN_General = new EN_General();
            objEN_General.Param00 = NroRecibo;
            return objLN_General.fr_ImprimirRecibo(objEN_General);
        }
        /// <summary>
        /// Registra la constancia con todos los datos de obtenidos de la tabla movimiento y esta información no debe actualizarse con el tiempo.
        /// </summary>
        /// <param name="Cod_Cia">Código Compañia.</param>
        /// <param name="Num_Poliza">Número de Póliza.</param>
        /// <param name="Num_Spto">Número de Suplemento.</param>
        /// <param name="Num_Apli">Número de Aplicación.</param>
        /// <param name="Num_Spto_Apli">Número de Suplemento Aplicación.</param>
        /// <param name="Ubicacion">Ubicación.</param>
        /// <param name="Cod_Usuario">Código de Usuario.</param>
        /// <param name="Cod_Sistema">Código de Sistema.</param>
        /// <returns>OK y ER:MsjError.</returns>
        [WebMethod]
        public string RegistrarConstancia(String Num_Mvto, String Cod_Cia, String Num_Poliza, String Num_Spto, String Num_Apli, String Num_Spto_Apli, String Ubicacion, String Cod_Usuario, String Cod_Sistema)
        {
            LN_General objLN_General = new LN_General();
            EN_General objEN_General = new EN_General();
            objEN_General.Param00 = Num_Mvto;
            objEN_General.Param01 = Cod_Cia;
            objEN_General.Param02 = Num_Poliza;
            objEN_General.Param03 = Num_Spto;
            objEN_General.Param04 = Num_Apli;
            objEN_General.Param05 = Num_Spto_Apli;
            objEN_General.Param06 = Ubicacion;
            objEN_General.Param07 = Cod_Usuario;
            objEN_General.Param08 = Cod_Sistema;
            return objLN_General.fr_GenerarConstancia(objEN_General);
        }
        /// <summary>
        /// Imprime del recibo en formato PDF y dejarlo en el directorio “V”, la información lo sacara desde mismo tronador a través del número de recibo.
        /// </summary>
        /// <param name="NroRecibo">Número de Recibo.</param>
        /// <returns>OK y ER:MsjError.</returns>
        [WebMethod]
        public string ImprimirConstancia(String NroConstancia)
        {
            LN_General objLN_General = new LN_General();
            EN_General objEN_General = new EN_General();
            objEN_General.Param00 = NroConstancia;
            return objLN_General.fr_ImpirmirConstancia(objEN_General);
        }
        /// <summary>
        /// Genera la impresión del certificado, carta y el cargo en formato PDF y dejarlo en el directorio “V”.
        /// </summary>
        /// <param name="Num_Mvto">Número de Movimiento.</param>
        /// <param name="Cod_Cia">Código de Compañia.</param>
        /// <param name="Num_Poliza">Número de Póliza.</param>
        /// <param name="Num_Spto">Número de Suplemento.</param>
        /// <param name="Num_Apli">Número de Aplicación.</param>
        /// <param name="Num_Spto_Apli">Número de Suplemento Aplicación.</param>
        /// <param name="Cod_Usuario">Código de Usuario.</param>
        /// <param name="Cod_Sistema">Código de Sistema.</param>
        /// <returns></returns>
        [WebMethod]
        public string ImprimirCertificado(String Num_Mvto,String Cod_Cia,String Num_Poliza,String Num_Spto,String Num_Apli,
String Num_Spto_Apli,String Cod_Usuario,String Cod_Sistema)
        {
            LN_General objLN_General = new LN_General();
            EN_DECASEG_0002 objEN_DECASEG_0002 = new EN_DECASEG_0002();
            objEN_DECASEG_0002.NRO_MOVIMIENTO = Num_Mvto;
            objEN_DECASEG_0002.COD_CIA = Cod_Cia;
            objEN_DECASEG_0002.NUM_POLIZA = Num_Poliza;
            objEN_DECASEG_0002.NUM_SPTO = Num_Spto;
            objEN_DECASEG_0002.NUM_APLI = Num_Apli;
            objEN_DECASEG_0002.NUM_SPTO_APLI = Num_Spto_Apli;
            objEN_DECASEG_0002.COD_USUARIO = Cod_Usuario;
            objEN_DECASEG_0002.COD_SISTEMA = Cod_Sistema;
            return objLN_General.fr_ImprimirCertificado(objEN_DECASEG_0002);
        }
        /// <summary>
        /// Graba el documento adjunto ubicado en el directorio “V” a la base de datos.
        /// </summary>
        /// <param name="Cod_Cia">Código de Compañia.</param>
        /// <param name="Num_Poliza">Número de Póliza.</param>
        /// <param name="Num_Spto">Número de Suplemento.</param>
        /// <param name="Num_Apli">Número de Aplicación.</param>
        /// <param name="Num_Spto_Apli">Número de Suplemento Aplicación.</param>
        /// <param name="Cod_Sistema">Código de Sistema.</param>
        /// <param name="Desc_Archivo">Descripción de Archivo.</param>
        /// <param name="Ruta">Ruta de Archivo.</param>
        /// <param name="Cod_User">Código de Usuario.</param>
        /// <returns></returns>
        [WebMethod]
        public string GrabarDocAdjunto(String Cod_Cia, String Num_Poliza, String Num_Spto
                , String Num_Apli, String Num_Spto_Apli, String Cod_Sistema, String Desc_Archivo, String Ruta, String Cod_User)
        {
            LN_General objLN_General = new LN_General();
            EN_Documento Documento = new EN_Documento();

            Documento.Cia = Cod_Cia;
            Documento.Poliza = Num_Poliza;
            Documento.NumSpto = Num_Spto;
            Documento.NumApli = Num_Apli;
            Documento.NumSptoApli = Num_Spto_Apli;
            Documento.DscDocumento = Desc_Archivo;
            Documento.Ruta = Ruta;
            Documento.CodApli = Cod_Sistema;
            Documento.Usuario = Cod_User;
            return objLN_General.fr_GrabarAdjunto(Documento);
        }
        /*********************************LINEA DE SEPARACION*********************************/
    }
}
