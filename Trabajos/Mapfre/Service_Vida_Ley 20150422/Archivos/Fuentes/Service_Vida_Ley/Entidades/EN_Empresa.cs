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
    public class EN_Empresa
    {
        #region Variables Privadas

        //Datos de Empresa
        private string vTipDocumento;
        private string vNroDocumento;
        private string vRazonSocial;
        private string vEmailUsu;
        private int vTipDomicilio;
        private string vNomDomicilio;
        private string vDepartamento;
        private string vProvincia;
        private string vDistrito;
        private string vCodPostal;
        private string vTelefono;
        private string vNumMovil;
        private string vRepresentante;
        private string vCargoRepresentante;
        private string vCodCIIUEmp;
        private string vDescCIIUEmp;
        private string vDescTrabajo;
        private string vMcaExtCliTron;
        private string vCodUserReg;
        private DateTime vFecReg;
        private string vPais;
        private string vCodPais;

        //Datos Adicionales
        private string vCodDepartamento;
        private string vCodProvincia;
        private string vCodDistrito;
        private int vCodcia;
        private string vCodActividad;
        private int vCodAgt;
        private string vDescAgt;
        private int vTipo;

        //Paginación
        private int vNumPagina;
        private int vTamPagina;
        private int vTotRegistro;

        //Solicitud       
        private EN_Solicitud voEnSol = new EN_Solicitud();

        //Riesgos
        private EN_Riesgos voEnRies = new EN_Riesgos();

        #endregion

        #region Variables Públicas

        public string TipDocumento { get { return vTipDocumento; } set { vTipDocumento = value; } }
        public string NroDocumento { get { return vNroDocumento; } set { vNroDocumento = value; } }
        public string RazonSocial { get { return vRazonSocial; } set { vRazonSocial = value; } }
        public string EmailUsu { get { return vEmailUsu; } set { vEmailUsu = value; } }
        public int TipDomicilio { get { return vTipDomicilio; } set { vTipDomicilio = value; } }
        public string NomDomicilio { get { return vNomDomicilio; } set { vNomDomicilio = value; } }
        public string Departamento { get { return vDepartamento; } set { vDepartamento = value; } }
        public string Provincia { get { return vProvincia; } set { vProvincia = value; } }
        public string Distrito { get { return vDistrito; } set { vDistrito = value; } }
        public string CodPostal { get { return vCodPostal; } set { vCodPostal = value; } }
        public string Telefono { get { return vTelefono; } set { vTelefono = value; } }
        public string NumMovil { get { return vNumMovil; } set { vNumMovil = value; } }
        public string Representante { get { return vRepresentante; } set { vRepresentante = value; } }
        public string CargoRepresentante { get { return vCargoRepresentante; } set { vCargoRepresentante = value; } }
        public string CodCIIUEmp { get { return vCodCIIUEmp; } set { vCodCIIUEmp = value; } }
        public string DescCIIUEmp { get { return vDescCIIUEmp; } set { vDescCIIUEmp = value; } }
        public string DescTrabajo { get { return vDescTrabajo; } set { vDescTrabajo = value; } }
        public string McaExtCliTron { get { return vMcaExtCliTron; } set { vMcaExtCliTron = value; } }
        public string CodUserReg { get { return vCodUserReg; } set { vCodUserReg = value; } }
        public DateTime FecReg { get { return vFecReg; } set { vFecReg = value; } }
        public string CodDepartamento { get { return vCodDepartamento; } set { vCodDepartamento = value; } }
        public string CodProvincia { get { return vCodProvincia; } set { vCodProvincia = value; } }
        public string CodDistrito { get { return vCodDistrito; } set { vCodDistrito = value; } }
        public int Codcia { get { return vCodcia; } set { vCodcia = value; } }
        public string CodActividad { get { return vCodActividad; } set { vCodActividad = value; } }
        public int CodAgt { get { return vCodAgt; } set { vCodAgt = value; } }
        public string DescAgt { get { return vDescAgt; } set { vDescAgt = value; } }
        public int Tipo { get { return vTipo; } set { vTipo = value; } }
        public int NumPagina { get { return vNumPagina; } set { vNumPagina = value; } }
        public int TamPagina { get { return vTamPagina; } set { vTamPagina = value; } }
        public int TotRegistro { get { return vTotRegistro; } set { vTotRegistro = value; } }
        public EN_Solicitud oEnSol { get { return voEnSol; } set { voEnSol = value; } }
        public EN_Riesgos oEnRies { get { return voEnRies; } set { voEnRies = value; } }
        public string Pais { get { return vPais; } set { vPais = value; } }
        public string CodPais { get { return vCodPais; } set { vCodPais = value; } }

        #endregion
    }
}
