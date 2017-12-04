using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using System.Data.OracleClient;
using Entidades;
using Utilitarios;
using System.Text.RegularExpressions;
using System.Globalization;
using System.Configuration;
using System.Data.OleDb;


namespace AccesoDatos
{
    public class AD_General : AD_Base
    {
        public String fr_validarExcelSCTR(String num_poliza, String Sist_Origen)
        {

            DataSet myDataset = new DataSet();
            String Nom_Sistema = "TRONWEB";
            String nom_archivo = ConfigurationManager.AppSettings["DirExcel"].ToString() + num_poliza + ".xls";
            System.Data.DataTable dt = new System.Data.DataTable();
            dt = Utilitarios.General.LeerExcel(nom_archivo);
            //dt = General.LeerExcel(nom_archivo);
            String mostrarerror = "";
            Int32 j;
            String rpta;
            Int32 lcContador = 0;
            Int32 colum_vacia = 0;
            rpta = "";

            foreach (DataRow dr in dt.Rows)
            {

                if (dr[0].ToString().Trim().Length > 0 || dr[1].ToString().Trim().Length > 0 ||
                    dr[2].ToString().Trim().Length > 0 || dr[3].ToString().Trim().Length > 0 ||
                    dr[4].ToString().Trim().Length > 0 || dr[5].ToString().Trim().Length > 0 ||
                    dr[6].ToString().Trim().Length > 0 || dr[7].ToString().Trim().Length > 0)
                {
                    Int32 fila = lcContador + 2;
                    //----------------------------------------------------------------------------------
                    //------------VALIDAR QUE SI EXISTE UNA COLUMNA VACIA ------------------------------
                    if (colum_vacia > 0)
                    {
                        if (mostrarerror == "") mostrarerror = "La fila: " + fila.ToString() + ", Contiene Valores Nulos o Vacios.";
                        else mostrarerror = mostrarerror + "|La fila: " + fila.ToString() + ", Contiene Valores Nulos o Vacios.";
                        if (Sist_Origen.ToUpper() == Nom_Sistema) break;
                    }
                    //----------------------------------------------------------------------------------
                    //------------VALIDA EL TIPO DE DOCUMENTO SEA NO NULO O VACIO ---------------
                    if (Convert.IsDBNull(dr[0].ToString().Trim()) || dr[0].ToString().Trim().Equals(""))
                    {
                        if (mostrarerror == "") mostrarerror = "TIPODOC vacío o nulo, fila: " + fila.ToString() + ", Dato obligatorio.";
                        else mostrarerror = mostrarerror + "|TIPODOC vacío o nulo, fila: " + fila.ToString() + ", Dato obligatorio.";
                    }
                    else
                    {
                        Int32 tamano;
                        tamano = dr[0].ToString().Length;
                        if (tamano != 3)
                        {
                            if (mostrarerror == "") mostrarerror = "TIPODOC incorrecto, fila: " + fila.ToString() + ", Longitud 3 caracteres.";
                            else mostrarerror = mostrarerror + "|TIPODOC incorrecto, fila: " + fila.ToString() + ", Longitud 3 caracteres.";
                        }
                    }
                    //----------------------------------------------------------------------------------
                    //------------VALIDA EL TIPO DE DOCUMENTO EXISTA ENTRE DNI, CEX, PEX ---------------
                    if (!(dr[0].ToString().ToUpper().Trim().Equals("DNI") || dr[0].ToString().ToUpper().Trim().Equals("CEX") || dr[0].ToString().ToUpper().Trim().Equals("")))
                    {
                        if (mostrarerror == "") mostrarerror = "TIPODOC incorrecto, fila: " + fila.ToString() + ", Valores permitos DNI CEX PEX.";
                        else mostrarerror = mostrarerror + "|TIPODOC incorrecto, fila: " + fila.ToString() + ", Valores permitos DNI CEX PEX.";
                    }
                    //----------------------------------------------------------------------------------
                    //------------VALIDA NUMERO DE DOCUMENTO--------------------------------------------

                    if (Convert.IsDBNull(dr[1]) || dr[1].ToString().Trim() == "")
                    {
                        if (mostrarerror == "") mostrarerror = "NUMDOC vacío o nulo, fila: " + fila.ToString() + ", Dato obligatorio.";
                        else mostrarerror = mostrarerror + "|NUMDOC vacío o nulo, fila: " + fila.ToString() + ", Dato obligatorio.";
                    }
                    else
                    {
                        Int32 tamano;
                        tamano = dr[1].ToString().Length;
                        if (dr[0].ToString().ToUpper().Trim().Equals("DNI"))
                        {
                            if (tamano != 8)
                            {
                                if (mostrarerror == "") mostrarerror = "NUMDOC incorrecto, fila: " + fila.ToString() + ", Longitud 8 dígitos.";
                                else mostrarerror = mostrarerror + "|NUMDOC incorrecto, fila: " + fila.ToString() + ", Longitud 8 dígitos.";
                            }
                            else
                            {
                                try
                                {
                                    Convert.ToInt32(dr[1].ToString());
                                }
                                catch (Exception ex)
                                {
                                    if (mostrarerror == "") mostrarerror = "NUMDOC incorrecto, fila: " + fila.ToString() + ", Valor debe ser numérico.";
                                    else mostrarerror = mostrarerror + "|NUMDOC incorrecto, fila: " + fila.ToString() + ", Valor debe ser numérico.";
                                }
                            }

                        }
                        else
                        {
                            if (tamano > 15)
                            {
                                if (mostrarerror == "") mostrarerror = "NUMDOC incorrecto, fila: " + fila.ToString() + ", Longitud Max. 15 dígitos.";
                                else mostrarerror = mostrarerror + "|NUMDOC incorrecto, fila: " + fila.ToString() + ", Longitud Max. 15 dígitos.";
                            }
                        }
                    }
                    //----------------------------------------------------------------------------------
                    //------------VALIDA NOMBRE COMPLETO----------------------------------------------
                    if (dr[5].ToString().Length > 80)
                    {
                        if (mostrarerror == "") mostrarerror = "NOMBRECOMPLETO incorrecto, fila: " + fila.ToString() + ", Longitud máxima 80 caracteres.";
                        else mostrarerror = mostrarerror + "|NOMBRECOMPLETO incorrecto, fila: " + fila.ToString() + ", Longitud máxima 80 caracteres.";
                    }
                    else
                    {
                        if (!Regex.IsMatch(dr[5].ToString().Trim().Replace(" ", "F").Replace(",", "F"), @"^[\p{L}]+$") && !dr[5].ToString().Trim().Equals(""))
                        {
                            if (mostrarerror == "") mostrarerror = "NOMBRECOMPLETO incorrecto, fila: " + fila.ToString() + ", Valores permitidos solo letras.";
                            else mostrarerror = mostrarerror + "|NOMBRECOMPLETO incorrecto, fila: " + fila.ToString() + ", Valores permitidos solo letras.";
                        }
                    }
                    //----------------------------------------------------------------------------------
                    //------------VALIDA AL MENOS QUE SE INGRESE LOS APELLIDOS Y NOMBRES-------------------------------
                    if (dr[5].ToString().Trim().Length == 0)
                    {
                        if (dr[2].ToString().Trim().Length == 0 || dr[3].ToString().Trim().Length == 0 || dr[4].ToString().Trim().Length == 0)
                        {
                            if (mostrarerror == "") mostrarerror = "NOMBRES vacío o nulo, fila: " + fila.ToString() + ", Dato obligatorio NOMBRE,APP,APM O NOMBRECOMPLETO.";
                            else mostrarerror = mostrarerror + "|NOMBRES vacío o nulo, fila: " + fila.ToString() + ", Dato obligatorio NOMBRE,APP,APM O NOMBRECOMPLETO.";
                        }
                    }
                    //----------------------------------------------------------------------------------
                    //------------VALIDA APELLIDO PATERNO----------------------------------------------
                    if (dr[2].ToString().Length > 20)
                    {
                        if (mostrarerror == "") mostrarerror = "APEPATERNO incorrecto, fila: " + fila.ToString() + ", Longitud máxima 20 caracteres.";
                        else mostrarerror = mostrarerror + "|APEPATERNO incorrecto, fila: " + fila.ToString() + ", Longitud máxima 20 caracteres.";
                    }
                    else
                    {

                        if (!Regex.IsMatch(dr[2].ToString().Trim().Replace(" ", "F"), @"^[\p{L}]+$") && !dr[2].ToString().Trim().Equals(""))
                        {
                            if (mostrarerror == "") mostrarerror = "APEPATERNO incorrecto, fila: " + fila.ToString() + ",  Valores permitidos solo letras.";
                            else mostrarerror = mostrarerror + "|APEPATERNO incorrecto, fila: " + fila.ToString() + ",  Valores permitidos solo letras.";
                        }

                    }
                    //----------------------------------------------------------------------------------
                    //------------VALIDA APELLIDO MATERNO----------------------------------------------
                    if (dr[3].ToString().Length > 20)
                    {
                        if (mostrarerror == "") mostrarerror = "APEMATERNO incorrecto, fila: " + fila.ToString() + ", Longitud máxima 20 caracteres.";
                        else mostrarerror = mostrarerror + "|APEMATERNO incorrecto, fila: " + fila.ToString() + ", Longitud máxima 20 caracteres.";
                    }
                    else
                    {
                        if (!Regex.IsMatch(dr[3].ToString().Trim().Replace(" ", "F"), @"^[\p{L}]+$") && !dr[3].ToString().Trim().Equals(""))
                        {
                            if (mostrarerror == "") mostrarerror = "APEMATERNO incorrecto, fila: " + fila.ToString() + ",  Valores permitidos solo letras.";
                            else mostrarerror = mostrarerror + "|APEMATERNO incorrecto, fila: " + fila.ToString() + ",  Valores permitidos solo letras.";
                        }
                    }
                    //----------------------------------------------------------------------------------
                    //------------VALIDA NOMBRES-------------------------------------------------------
                    if (dr[4].ToString().Length > 30)
                    {
                        if (mostrarerror == "") mostrarerror = "NOMBRE incorrecto, fila: " + fila.ToString() + ", Longitud máxima 30 caracteres.";
                        else mostrarerror = mostrarerror + "|NOMBRE incorrecto, fila: " + fila.ToString() + ", Longitud máxima 30 caracteres.";
                    }
                    else
                    {
                        if (!Regex.IsMatch(dr[4].ToString().Trim().Replace(" ", "F"), @"^[\p{L}]+$") && !dr[4].ToString().Trim().Equals(""))
                        {
                            if (mostrarerror == "") mostrarerror = "NOMBRE incorrecto, fila: " + fila.ToString() + ",  Valores permitidos solo letras.";
                            else mostrarerror = mostrarerror + "|NOMBRE incorrecto, fila: " + fila.ToString() + ",  Valores permitidos solo letras.";
                        }
                    }
                    //----------------------------------------------------------------------------------
                    //------------VALIDA FECHA DE NACIMIENTO----------------------------------------------
                    if (dr[6] == null || dr[6].ToString().Trim().Equals(""))
                    {
                        if (mostrarerror == "") mostrarerror = "En la FEC_NACIMIENTO de la fila: " + fila.ToString() + " - Valor Nulo o Vacio";
                        else mostrarerror = mostrarerror + "|En la FEC_NACIMIENTO de la fila: " + fila.ToString() + " - Valor Nulo o Vacio";
                    }
                    else
                    {

                        String[] formats = { "dd/MM/yyyy" };
                        DateTime dateValue;
                        String str_fecha = dr[6].ToString().Trim();
                        System.IFormatProvider miFp = new System.Globalization.CultureInfo("es-ES", false);
                        try
                        {
                            if (!System.DateTime.TryParseExact(str_fecha, formats, miFp, DateTimeStyles.None, out dateValue))
                            {
                                if (mostrarerror == "") mostrarerror = "NACIMIENTO incorrecto, fila: " + fila.ToString() + " Formato debe ser DD/MM/YYYY";
                                else mostrarerror = mostrarerror + "|NACIMIENTO incorrecto, fila: " + fila.ToString() + " Formato debe ser DD/MM/YYYY";
                            }
                        }
                        catch (Exception)
                        {
                            if (mostrarerror == "") mostrarerror = "NACIMIENTO incorrecto, fila: " + fila.ToString() + ".";
                            else mostrarerror = mostrarerror + "|NACIMIENTO incorrecto, fila: " + fila.ToString() + ".";
                        }

                        if (Convert.ToDateTime(dr[6].ToString().Trim()).Year < 1900)
                        {
                            if (mostrarerror == "") mostrarerror = "NACIMIENTO incorrecto, fila: " + fila.ToString() + ", fecha debe ser mayor a 1900.";
                            else mostrarerror = mostrarerror + "|NACIMIENTO incorrecto, fila: " + fila.ToString() + ", fecha debe ser mayor a 1900.";
                        }
                    }
                    //----------------------------------------------------------------------------------
                    //------------VALIDA SUELDO--------------------------------------------------------
                    if (Convert.IsDBNull(dr[7]) || dr[7].ToString().Trim() == "")
                    {
                        if (mostrarerror == "") mostrarerror = "SUELDO vacío o nulo, fila: " + fila.ToString() + ", Dato obligatorio.";
                        else mostrarerror = mostrarerror + "|SUELDO vacío o nulo, fila: " + fila.ToString() + ", Dato obligatorio.";
                    }
                    else
                    {
                        try
                        {
                            Convert.ToDouble(dr[7].ToString());
                        }
                        catch (Exception ex)
                        {
                            if (mostrarerror == "") mostrarerror = "SUELDO incorrecto, fila: " + fila.ToString() + ", Valor debe ser numérico.";
                            else mostrarerror = mostrarerror + "|SUELDO incorrecto, fila: " + fila.ToString() + ", Valor debe ser numérico.";
                        }
                        if (Convert.ToDouble(dr[7]) < 750)
                        {
                            if (mostrarerror == "") mostrarerror = "SUELDO incorrecto, fila: " + fila.ToString() + ", Valor mínimo 750.";
                            else mostrarerror = mostrarerror + "|SUELDO incorrecto, fila: " + fila.ToString() + ", Valor mínimo 750.";
                        }
                    }
                    //------------------------------------------------------------------------------------------
                    //-----------VALIDA SI EXISTE UN REGISTRO REPETIDO -----------------------------------------
                    Int32 lcContador2 = 0;
                    foreach (DataRow dr2 in dt.Rows)
                    {
                        Int32 fila2 = lcContador2 + 2;
                        if (fila != fila2 && dr[0].Equals(dr2[0]) && dr[1].Equals(dr2[1]))
                        {
                            if (mostrarerror == "") mostrarerror = "NUMDOC duplicado, filas: " + " (" + fila2.ToString() + " y " + fila.ToString() + "), Dato único.";
                            else mostrarerror = mostrarerror + "|NUMDOC duplicado, filas: " + " (" + fila2.ToString() + " y " + fila.ToString() + "), Dato único.";
                        }
                        lcContador2 = lcContador2 + 1;
                    }
                    //-----------------------------------------------------------------------------------------
                    //lcContador = lcContador + 1;
                }
                else
                {
                    colum_vacia = colum_vacia + 1;
                }
                lcContador = lcContador + 1;
            }

            if (mostrarerror != "")
            {
                rpta = mostrarerror;
            }
            else
            {
                if (lcContador == 0)
                {
                    rpta = "Ingresar Planilla - Excel sin datos de Planilla";
                }
                //if (!Convert.IsDBNull(lcValidaNroReg) && lcValidaNroReg == "S")
                //{
                //    if (lcContador != lnNumReg)
                //    {
                //        rpta = "El numero de trabajadores registrados no es igual a lo declarado.";
                //    }
                //}
            }

            return rpta;
        }

        public String fr_validarPlanillaVidaLey(Int32 Cod_CIA, Int32 Cod_Ramo, String num_poliza, String Sist_Origen)
        {
            /******************/
            DataSet myDataset = new DataSet();
            String nom_archivo = "";
            String Nom_Sistema = "TRONWEB";
            //int contador = 0; --> 28-08-2013
            //int cont_trabajadores = 0; ---> 28-08-2013
            //int registro_invalido = 0; ---- 28-08-2013
            OleDbDataAdapter myData = new OleDbDataAdapter();
            nom_archivo = ConfigurationManager.AppSettings["DirExcel"].ToString() + num_poliza + ".xls";

            /**** VALIDACIONES ****/
            //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
            //DataTable dt = null;
            System.Data.DataTable dt = new System.Data.DataTable();
            dt = Utilitarios.General.LeerExcel(nom_archivo);

            //dt = General.LeerExcel(nom_archivo);
            string mostrarerror = "";
            int[] j = null;

            //Alta de Nueva Planilla
            string rpta = null;
            int colum_vacia = 0;
            int lcContador = 0;
            double ln_sueldo_tope = 0;
            rpta = "";

            recupera_sueldo_topeVidaLey(Cod_CIA, Cod_Ramo, ref ln_sueldo_tope);

            foreach (DataRow dr in dt.Rows)
            {
                if (dr[0].ToString().Trim().Length > 0 || dr[1].ToString().Trim().Length > 0 || dr[2].ToString().Trim().Length > 0 || dr[3].ToString().Trim().Length > 0 || dr[4].ToString().Trim().Length > 0 || dr[5].ToString().Trim().Length > 0 || dr[6].ToString().Trim().Length > 0 || dr[7].ToString().Trim().Length > 0 || dr[8].ToString().Trim().Length > 0)
                {
                    int fila = lcContador + 2;
                    //FTELLO: INICIO ----> 26-08-2013
                    //----------------------------------------------------------------------------------
                    //------------VALIDAR QUE NO EXISTA COLUMNAS VACIAS O NULAS---------------
                    if (colum_vacia > 0)
                    {
                        if (mostrarerror == "") mostrarerror = "La fila: " + fila + ", Contiene Valores Nulos o Vacios.";
                        else mostrarerror = mostrarerror + "|La fila: " + fila + ", Contiene Valores Nulos o Vacios.";
                        if (Sist_Origen.ToUpper() == Nom_Sistema) break;
                    }
                    //----------------------------------------------------------------------------------
                    //------------VALIDA QUE EL TIPO DE DOCUMENTO SEA NULO O VACIO  --------------------
                    if (dr[0] == null || string.IsNullOrEmpty(dr[0].ToString().Trim()))
                    {
                        if (mostrarerror == "") mostrarerror = "TIPODOC vacío o nulo, fila: " + fila.ToString() + ", Dato Obligatorio.";
                        else mostrarerror = mostrarerror + "|TIPODOC vacío o nulo, fila: " + fila.ToString() + ", Dato Obligatorio.";
                    }
                    //----------------------------------------------------------------------------------
                    //------------VALIDA EL TIPO DE DOCUMENTO EXISTA ENTRE DNI, CEX, PEX ---------------
                    if (!(dr[0].ToString() == "DNI" || dr[0].ToString() == "CEX" || dr[0].ToString() == "PEX"))
                    {
                        if (mostrarerror == "") mostrarerror = "TIPODOC incorrecto, fila: " + fila.ToString() + ", Valores permitos DNI CEX PEX.";
                        else mostrarerror = mostrarerror + "|TIPODOC incorrecto, fila: " + fila.ToString() + ", Valores permitos DNI CEX PEX.";
                    }
                    //----------------------------------------------------------------------------------
                    //------------VALIDA NUMERO DE DOCUMENTO--------------------------------------------

                    if (dr[1] == null || string.IsNullOrEmpty(dr[1].ToString().Trim()))
                    {
                        if (mostrarerror == "") mostrarerror = "NUMDOC vacío o nulo, fila: " + fila.ToString() + ", Dato obligatorio.";
                        else mostrarerror = mostrarerror + "|NUMDOC vacío o nulo, fila: " + fila.ToString() + ", Dato obligatorio.";
                    }
                    else
                    {
                        int tamaño = 0;
                        tamaño = dr[1].ToString().Trim().Length;
                        if (dr[0].ToString().Equals("DNI") & tamaño != 8)
                        {
                            if (mostrarerror == "") mostrarerror = "NUMDOC incorrecto, fila: " + fila.ToString() + ", Longitud 8 dígitos.";
                            else mostrarerror = mostrarerror + "|NUMDOC incorrecto, fila: " + fila.ToString() + ", Longitud 8 dígitos.";
                        }
                        else
                        {
                            try
                            {
                                Convert.ToInt32(dr[1].ToString());
                            }
                            catch (Exception ex)
                            {
                                if (mostrarerror == "") mostrarerror = "NUMDOC incorrecto, fila: " + fila.ToString() + ", Valor debe ser numérico.";
                                else mostrarerror = mostrarerror + "|NUMDOC incorrecto, fila: " + fila.ToString() + ", Valor debe ser numérico.";
                            }

                        }
                        //Continue For ----> FTELLO
                    }
                    //----------------------------------------------------------------------------------
                    //------------VALIDA NOMBRE COMPLETO----------------------------------------------
                    if (dr[5].ToString().Length > 80)
                    {
                        if (mostrarerror == "") mostrarerror = "NOMBRECOMPLETO incorrecto, fila: " + fila.ToString() + ", Longitud máxima 80 caracteres.";
                        else mostrarerror = mostrarerror + "|NOMBRECOMPLETO incorrecto, fila: " + fila.ToString() + ", Longitud máxima 80 caracteres.";
                    }
                    else
                    {
                        if (!Regex.IsMatch(dr[5].ToString().Trim().Replace(' ', 'F').Replace(',', 'F'), @"^[\p{L}]+$") && !dr[5].ToString().Trim().Equals(""))
                        {
                            if (mostrarerror == "") mostrarerror = "NOMBRECOMPLETO incorrecto, fila: " + fila.ToString() + ", Valores permitidos solo letras.";
                            else mostrarerror = mostrarerror + "|NOMBRECOMPLETO incorrecto, fila: " + fila.ToString() + ", Valores permitidos solo letras.";
                        }
                    }
                    //----------------------------------------------------------------------------------
                    //------------VALIDA QUE SE INGRESE AL MENOS APELLIDOS Y NOMBRES---------------------
                    if (dr[5].ToString().Trim().Length == 0)
                    {
                        if (dr[2].ToString().Trim().Length == 0 || dr[3].ToString().Trim().Length == 0 || dr[4].ToString().Trim().Length == 0)
                        {
                            if (mostrarerror == "") mostrarerror = "NOMBRES vacío o nulo, fila: " + fila.ToString() + ", Dato obligatorio NOMBRE,APP,APM O NOMBRECOMPLETO.";
                            else mostrarerror = mostrarerror + "|NOMBRES vacío o nulo, fila: " + fila.ToString() + ", Dato obligatorio NOMBRE,APP,APM O NOMBRECOMPLETO.";
                        }
                    }
                    //----------------------------------------------------------------------------------
                    //------------VALIDA APELLIDO PATERNO----------------------------------------------
                    if (dr[2].ToString().Length > 20)
                    {
                        if (mostrarerror == "") mostrarerror = "APEPATERNO incorrecto, fila: " + fila.ToString() + ", Longitud máxima 20 caracteres.";
                        else mostrarerror = mostrarerror + "|APEPATERNO incorrecto, fila: " + fila.ToString() + ", Longitud máxima 20 caracteres.";
                    }
                    else
                    {
                        if (!Regex.IsMatch(dr[2].ToString().Trim().Replace(' ', 'F'), @"^[\p{L}]+$") && !dr[2].ToString().Trim().Equals(""))
                        {
                            if (mostrarerror == "") mostrarerror = "APEPATERNO incorrecto, fila: " + fila.ToString() + ",  Valores permitidos solo letras.";
                            else mostrarerror = mostrarerror + "|APEPATERNO incorrecto, fila: " + fila.ToString() + ",  Valores permitidos solo letras.";
                        }
                    }

                    //----------------------------------------------------------------------------------
                    //------------VALIDA APELLIDO MATERNO----------------------------------------------

                    if (dr[3].ToString().Length > 20)
                    {
                        if (mostrarerror == "") mostrarerror = "APEMATERNO incorrecto, fila: " + fila.ToString() + ", Longitud máxima 20 caracteres.";
                        else mostrarerror = mostrarerror + "|APEMATERNO incorrecto, fila: " + fila.ToString() + ", Longitud máxima 20 caracteres.";
                    }
                    else
                    {
                        if (!Regex.IsMatch(dr[3].ToString().Trim().Replace(' ', 'F'), @"^[\p{L}]+$") && !dr[3].ToString().Trim().Equals(""))
                        {
                            if (mostrarerror == "") mostrarerror = "APEMATERNO incorrecto, fila: " + fila.ToString() + ",  Valores permitidos solo letras.";
                            else mostrarerror = mostrarerror + "|APEMATERNO incorrecto, fila: " + fila.ToString() + ",  Valores permitidos solo letras.";
                        }
                    }

                    //---------------------------------------------------------------------------------------
                    //------------VALIDA NOMBRES-------------------------------------------------------------
                    if (dr[4].ToString().Length > 30)
                    {
                        if (mostrarerror == "") mostrarerror = "NOMBRE incorrecto, fila: " + fila.ToString() + ", Longitud máxima 30 caracteres.";
                        else mostrarerror = mostrarerror + "|NOMBRE incorrecto, fila: " + fila.ToString() + ", Longitud máxima 30 caracteres.";
                    }
                    else
                    {
                        if (!Regex.IsMatch(dr[4].ToString().Trim().Replace(' ', 'F'), @"^[\p{L}]+$") && !dr[4].ToString().Trim().Equals(""))
                        {
                            if (mostrarerror == "") mostrarerror = "NOMBRE incorrecto, fila: " + fila.ToString() + ",  Valores permitidos solo letras.";
                            else mostrarerror = mostrarerror + "|NOMBRE incorrecto, fila: " + fila.ToString() + ",  Valores permitidos solo letras.";
                        }
                    }
                    //-----------------------------------------------------------------------------------
                    //-----------VALIDAR FECHA_NACIMIENTO -----------------------------------------------

                    if (dr[6] == null || dr[6].ToString().Trim().Equals(""))
                    {
                        if (mostrarerror == "") mostrarerror = "En la FEC_NACIMIENTO de la fila: " + fila.ToString() + " - Valor Nulo o Vacío.";
                        else mostrarerror = mostrarerror + "|En la FEC_NACIMIENTO de la fila: " + fila.ToString() + " - Valor Nulo o Vacío.";
                    }
                    else
                    {
                        String[] formats = { "dd/MM/yyyy" };
                        DateTime dateValue;
                        String str_fecha = dr[6].ToString().Trim();
                        System.IFormatProvider miFp = new System.Globalization.CultureInfo("es-ES", false);
                        try
                        {
                            if (!System.DateTime.TryParseExact(str_fecha, formats, miFp, DateTimeStyles.None, out dateValue))
                            {
                                if (mostrarerror == "") mostrarerror = "NACIMIENTO incorrecto, fila: " + fila.ToString() + " Formato debe ser DD/MM/YYYY.";
                                else mostrarerror = mostrarerror + "|NACIMIENTO incorrecto, fila: " + fila.ToString() + " Formato debe ser DD/MM/YYYY.";
                            }
                        }
                        catch (Exception e1)
                        {
                            String err = e1.Message;
                        }

                        if (Convert.ToInt32(dr[6].ToString().Trim().Split('/')[2]) < 1900)
                        {
                            if (mostrarerror == "") mostrarerror = "NACIMIENTO incorrecto, fila: " + fila.ToString() + ", fecha debe ser mayor a 1900.";
                            else mostrarerror = mostrarerror + "|NACIMIENTO incorrecto, fila: " + fila.ToString() + ", fecha debe ser mayor a 1900.";
                        }
                    }
                    //----------------------------------------------------------------------------------
                    //------------VALIDA SUELDO---------------------------------------------------------
                    if (dr[7] == null || dr[7].ToString().Trim() == "")
                    {
                        if (mostrarerror == "") mostrarerror = "EL SUELDO vacío o nulo, fila: " + fila.ToString() + ", Dato obligatorio.";
                        else mostrarerror = mostrarerror + "|EL SUELDO vacío o nulo, fila: " + fila.ToString() + ", Dato obligatorio.";
                    }
                    else
                    {
                        try
                        {
                            Convert.ToDouble(dr[7].ToString());
                        }
                        catch (Exception ex)
                        {
                            if (mostrarerror == "") mostrarerror = "SUELDO incorrecto, fila: " + fila.ToString() + ", Valor debe ser numérico.";
                            else mostrarerror = mostrarerror + "|SUELDO incorrecto, fila: " + fila.ToString() + ", Valor debe ser numérico.";
                        }

                        if (Convert.ToDouble(dr[7]) < 750)
                        {
                            if (mostrarerror == "") mostrarerror = "SUELDO incorrecto, fila: " + fila.ToString() + ", Valor mínimo 750.";
                            else mostrarerror = mostrarerror + "|SUELDO incorrecto, fila: " + fila.ToString() + ", Valor mínimo 750.";
                        }
                        if (ln_sueldo_tope > 0 && Convert.ToDouble(dr[7]) > ln_sueldo_tope)
                        {
                            if (mostrarerror == "") mostrarerror = "SUELDO incorrecto, fila: " + fila.ToString() + ", Supero el Tope de Sueldo de S/." + ln_sueldo_tope;
                            else mostrarerror = mostrarerror + "|SUELDO incorrecto, fila: " + fila.ToString() + ", Supero el Tope de Sueldo de S/." + ln_sueldo_tope;
                        }
                    }
                    //------------------------------------------------------------------------------------
                    //----------------- VALIDAR OCUPACION -----------------------------------------------
                    if (dr[8].ToString().Length > 40)
                    {
                        if (mostrarerror == "") mostrarerror = "OCUPACIÓN incorrecto, fila: " + fila.ToString() + ", Longitud máxima 40 caracteres.";
                        else mostrarerror = mostrarerror + "|OCUPACIÓN incorrecto, fila: " + fila.ToString() + ", Longitud máxima 40 caracteres.";
                    }
                    else
                    {
                        if (!Regex.IsMatch(dr[8].ToString().Trim().Replace(' ', 'F'), @"^[\p{L}]+$") && !dr[8].ToString().Trim().Equals(""))
                        {
                            if (mostrarerror == "") mostrarerror = "OCUPACIÓN incorrecto, fila: " + fila.ToString() + ", Valores permitidos solo letras.";
                            else mostrarerror = mostrarerror + "|OCUPACIÓN incorrecto, fila: " + fila.ToString() + ", Valores permitidos solo letras.";
                        }
                    }

                    //--------------------------------------------------------------
                    //-----------VALIDA SI EXISTE UN REGISTRO REPETIDO -------------
                    int lcContador2 = 0;
                    foreach (DataRow dr2 in dt.Rows)
                    {
                        int fila2 = lcContador2 + 2;
                        if (fila != fila2 & dr[0].Equals(dr2[0]) & dr[1].Equals(dr2[1]))
                        {
                            if (mostrarerror == "") mostrarerror = "NUMDOC duplicado, filas: " + " (" + fila2.ToString() + " y " + fila.ToString() + "), Dato único.";
                            else mostrarerror = mostrarerror + "|NUMDOC duplicado, filas: " + " (" + fila2.ToString() + " y " + fila.ToString() + "), Dato único.";
                        }
                        lcContador2 = lcContador2 + 1;
                    }
                    //----------------------------------------------------------------------------------
                    //lcContador = lcContador + 1;
                }
                else
                {
                    colum_vacia = colum_vacia + 1;
                }
                lcContador = lcContador + 1;
            }

            if (!mostrarerror.Equals(""))
            {
                rpta = mostrarerror;
            }
            else
            {
                if (lcContador == 0)
                {
                    rpta = "Ingresar Planilla - Excel sin datos de Planilla";
                }
                //if (validaNroAseg != null & validaNroAseg == "S")
                //{
                //    if (lcContador != num_asegurados)
                //    {
                //        rpta = "El numero de trabajadores registrados no es igual a lo declarado.";
                //    }
                //}
            }

            return rpta;
        }

        public void recupera_sueldo_topeVidaLey(int cod_cia, int cod_ramo, ref double sueldo_tope)
        {
            String str_metodo = "PlanillaDAL.recupera_sueldo_tope()";
            OracleCommand cmd = new OracleCommand();
            OracleConnection conn = new OracleConnection(ConfigurationManager.ConnectionStrings["OracleTronCon"].ConnectionString);
            String procedimiento = "sctr.sctr_gest_aseg.p_recupera_sueldo_tope";
            OracleParameter Param;
            try
            {
                Param = new OracleParameter("p_cod_cia", OracleType.Number);
                Param.Value = cod_cia;
                cmd.Parameters.Add(Param);

                Param = new OracleParameter("p_cod_ramo", OracleType.Number);
                Param.Value = cod_ramo;
                cmd.Parameters.Add(Param);

                Param = new OracleParameter("p_sueldo_tope", OracleType.Number);
                Param.Direction = ParameterDirection.Output;
                cmd.Parameters.Add(Param);

                /**************************************/
                cmd.CommandText = procedimiento;
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.Connection = conn;
                conn.Open();
                cmd.ExecuteNonQuery();
                /**************************************/
                if (!Convert.IsDBNull(cmd.Parameters["p_sueldo_tope"].Value)) sueldo_tope = double.Parse(cmd.Parameters["p_sueldo_tope"].Value.ToString());
                else sueldo_tope = 0;
            }
            catch (Exception e)
            {
                sueldo_tope = 99999;
            }
            finally
            {
                conn.Close();
            }
        }

        public String fr_GenerarMovimiento(EN_General objEN_General, ref OracleConnection obj_OracleConx, ref OracleTransaction obj_Trans)
        {
            try
            {
                OracleCommand cmd = new OracleCommand();
                cmd.Connection = obj_OracleConx;
                cmd.Transaction = obj_Trans;
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.CommandText = "OIM.PCK_GEST_ASEG.PGEAS001";
                OracleParameter Param;
                //01
                Param = new OracleParameter("as_Cod_Cia", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param00);
                cmd.Parameters.Add(Param);
                //02
                Param = new OracleParameter("as_Num_Poliza", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param01);
                cmd.Parameters.Add(Param);
                //03
                Param = new OracleParameter("as_Num_Spto", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param02);
                cmd.Parameters.Add(Param);
                //04
                Param = new OracleParameter("as_Num_Apli", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param03);
                cmd.Parameters.Add(Param);
                //05
                Param = new OracleParameter("as_Num_Spto_Apli", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param04);
                cmd.Parameters.Add(Param);
                //06
                Param = new OracleParameter("as_Cod_Usuario", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param05);
                cmd.Parameters.Add(Param);
                //07
                Param = new OracleParameter("as_Cod_Sistema", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param06);
                cmd.Parameters.Add(Param);
                //********************PARAMETROS DE RETORNO********************//
                //08
                Param = new OracleParameter("p_nRetorno", OracleType.Number);
                Param.Direction = ParameterDirection.Output;
                cmd.Parameters.Add(Param);
                //09
                Param = new OracleParameter("p_cMensaje", OracleType.VarChar, 2000);
                Param.Direction = ParameterDirection.Output;
                cmd.Parameters.Add(Param);
                //********************PARAMETROS DE RETORNO********************//
                int nResult = cmd.ExecuteNonQuery();// base.ExecuteNoneQuery(cmd);
                string cResult = "";
                if (!Convert.IsDBNull(cmd.Parameters["p_nRetorno"]))
                {
                    cResult = Convert.ToString(cmd.Parameters["p_nRetorno"].Value);
                    if (cResult == "-1")
                        throw new Exception(Convert.ToString(cmd.Parameters["p_cMensaje"].Value));
                }
                return cResult;
            }
            catch (OracleException ex)
            {
                General.LogError(ex);
                throw new Exception(ex.Message);

            }
            catch (Exception ex)
            {
                General.LogError(ex);
                throw new Exception(ex.Message);
            }
        }

        //Begin JRaffo 28/08/2015

        public int? fr_ObtenerNroMovimientoPorPoliza(EN_General objEN_General, ref OracleConnection obj_OracleConx, ref OracleTransaction obj_Trans)
        {
            try
            {
                OracleCommand cmd = new OracleCommand();
                cmd.Connection = obj_OracleConx;
                cmd.Transaction = obj_Trans;
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.CommandText = "OIM.PCK_GEST_ASEG.f_obte_num_mvto_por_plz";
                OracleParameter Param;
                //01
                Param = new OracleParameter("p_Cod_Cia", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param00);
                cmd.Parameters.Add(Param);
                //02
                Param = new OracleParameter("p_Num_Poliza", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param01);
                cmd.Parameters.Add(Param);
                //03
                Param = new OracleParameter("p_Num_Spto", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param02);
                cmd.Parameters.Add(Param);
                //04
                Param = new OracleParameter("p_Num_Apli", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param03);
                cmd.Parameters.Add(Param);
                //05
                Param = new OracleParameter("p_Num_Spto_Apli", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param04);
                cmd.Parameters.Add(Param);
                //06
                Param = new OracleParameter("p_Cod_Usuario", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param05);
                cmd.Parameters.Add(Param);
                //07
                Param = new OracleParameter("p_Cod_Sistema", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param06);
                cmd.Parameters.Add(Param);

                Param = new OracleParameter("nro_mov", OracleType.Number);
                Param.Direction = ParameterDirection.ReturnValue;
                Param.IsNullable = true;
                cmd.Parameters.Add(Param);

                cmd.ExecuteNonQuery();

                String result = cmd.Parameters["nro_mov"].Value.ToString();

                int nro_mov = ((String.IsNullOrEmpty(result)) ? -1 : Convert.ToInt32(result));

                if (nro_mov == -1) {
                    return null;
                }

                return nro_mov;
            }
            catch (OracleException ex)
            {
                General.LogError(ex);
                throw new Exception(ex.Message);

            }
            catch (Exception ex)
            {
                General.LogError(ex);
                throw new Exception(ex.Message);
            }
        }

        public int fr_ObtenerUltimaFilaAsegurado(int NroMovimiento, ref OracleConnection obj_OracleConx, ref OracleTransaction obj_Trans)
        {
            try
            {
                OracleCommand cmd = new OracleCommand();
                cmd.Connection = obj_OracleConx;
                cmd.Transaction = obj_Trans;
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.CommandText = "OIM.PCK_GEST_ASEG.f_obt_ultima_fila_aseg";
                OracleParameter Param;
                //01
                Param = new OracleParameter("p_Num_Movimiento", OracleType.Number);
                Param.Value = NroMovimiento;
                cmd.Parameters.Add(Param);

                Param = new OracleParameter("nro_fila", OracleType.Number);
                Param.Direction = ParameterDirection.ReturnValue;
                cmd.Parameters.Add(Param);

                cmd.ExecuteNonQuery();

                int nro_fila = Convert.ToInt32(cmd.Parameters["nro_fila"].Value);

                return nro_fila;
            }
            catch (OracleException ex)
            {
                General.LogError(ex);
                throw new Exception(ex.Message);

            }
            catch (Exception ex)
            {
                General.LogError(ex);
                throw new Exception(ex.Message);
            }
        }

        public void fr_EliminarMovimientosYAsegurados(EN_General objEN_General, ref OracleConnection obj_OracleConx, ref OracleTransaction obj_Trans)
        {
            try
            {
                OracleCommand cmd = new OracleCommand();
                cmd.Connection = obj_OracleConx;
                cmd.Transaction = obj_Trans;
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.CommandText = "OIM.PCK_GEST_ASEG.PGEAS013";
                OracleParameter Param;
                //01
                Param = new OracleParameter("as_Cod_Cia", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param00);
                cmd.Parameters.Add(Param);
                //02
                Param = new OracleParameter("as_Num_Poliza", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param01);
                cmd.Parameters.Add(Param);
                //03
                Param = new OracleParameter("as_Num_Spto", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param02);
                cmd.Parameters.Add(Param);
                //04
                Param = new OracleParameter("as_Num_Apli", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param03);
                cmd.Parameters.Add(Param);
                //05
                Param = new OracleParameter("as_Num_Spto_Apli", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param04);
                cmd.Parameters.Add(Param);
                //06
                Param = new OracleParameter("as_Cod_Usuario", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param05);
                cmd.Parameters.Add(Param);
                //07
                Param = new OracleParameter("as_Cod_Sistema", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param06);
                cmd.Parameters.Add(Param);
                //********************PARAMETROS DE RETORNO********************//
                //09
                Param = new OracleParameter("p_cMensaje", OracleType.VarChar, 2000);
                Param.Direction = ParameterDirection.Output;
                cmd.Parameters.Add(Param);
                //********************PARAMETROS DE RETORNO********************//

                cmd.ExecuteNonQuery();// base.ExecuteNoneQuery(cmd);
                string cResult = Convert.ToString(cmd.Parameters["p_cMensaje"].Value);
               
                if (cResult != "OK") {
                   throw new Exception(cResult);
                }

            }
            catch (OracleException ex)
            {
                General.LogError(ex);
                throw new Exception(ex.Message);

            }
            catch (Exception ex)
            {
                General.LogError(ex);
                throw new Exception(ex.Message);
            }
        }

        public void fr_RegistrarPolizaEnlace(EN_General objEN_General, ref OracleConnection obj_OracleConx, ref OracleTransaction obj_Trans)
        {
            try
            {
                OracleCommand cmd = new OracleCommand();
                cmd.Connection = obj_OracleConx;
                cmd.Transaction = obj_Trans;
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.CommandText = "OIM.PCK_GEST_ASEG.PGEAS014";
                OracleParameter Param;

                //00
                Param = new OracleParameter("as_Num_Movimiento", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param07);
                cmd.Parameters.Add(Param);
                //01
                Param = new OracleParameter("as_Cod_Cia", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param00);
                cmd.Parameters.Add(Param);
                //02
                Param = new OracleParameter("as_Num_Poliza", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param08);
                cmd.Parameters.Add(Param);
                //03
                Param = new OracleParameter("as_Num_Spto", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param02);
                cmd.Parameters.Add(Param);
                //04
                Param = new OracleParameter("as_Num_Apli", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param03);
                cmd.Parameters.Add(Param);
                //05
                Param = new OracleParameter("as_Num_Spto_Apli", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param04);
                cmd.Parameters.Add(Param);
                //06
                Param = new OracleParameter("as_Cod_Usuario", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param05);
                cmd.Parameters.Add(Param);
                //07
                Param = new OracleParameter("as_Cod_Sistema", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param06);
                cmd.Parameters.Add(Param);
                //********************PARAMETROS DE RETORNO********************//
                //09
                Param = new OracleParameter("p_cMensaje", OracleType.VarChar, 2000);
                Param.Direction = ParameterDirection.Output;
                cmd.Parameters.Add(Param);
                //********************PARAMETROS DE RETORNO********************//

                cmd.ExecuteNonQuery();// base.ExecuteNoneQuery(cmd);
                string cResult = Convert.ToString(cmd.Parameters["p_cMensaje"].Value);

                if (cResult != "OK") {
                    throw new Exception(cResult);
                }

            }
            catch (OracleException ex)
            {
                General.LogError(ex);
                throw new Exception(ex.Message);

            }
            catch (Exception ex)
            {
                General.LogError(ex);
                throw new Exception(ex.Message);
            }
        }

        //End JRaffo 28/08/2015

        public String fr_InsertarDatosTrama(EN_RCEN_ASEG0004_TEMP obj_Asegurado, ref OracleConnection obj_OracleConx, ref OracleTransaction obj_Trans)
        {
            try
            {
                OracleCommand cmd = new OracleCommand();
                cmd.Connection = obj_OracleConx;
                cmd.Transaction = obj_Trans;
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.CommandText = "OIM.PCK_GEST_ASEG.PGEAS002";
                OracleParameter Param;
                //01
                Param = new OracleParameter("as_TipDoc", OracleType.VarChar);
                Param.Value = Formateo_Texto(obj_Asegurado.TIPDOC);
                cmd.Parameters.Add(Param);
                //02
                Param = new OracleParameter("as_NumDoc", OracleType.VarChar);
                Param.Value = Formateo_Texto(obj_Asegurado.NUMDOC);
                cmd.Parameters.Add(Param);
                //03
                Param = new OracleParameter("as_ApePaterno", OracleType.VarChar);
                Param.Value = Formateo_Texto(obj_Asegurado.APEPAT);
                cmd.Parameters.Add(Param);
                //04
                Param = new OracleParameter("as_ApeMaterno", OracleType.VarChar);
                Param.Value = Formateo_Texto(obj_Asegurado.APEMAT);
                cmd.Parameters.Add(Param);
                //05
                Param = new OracleParameter("as_Nombres", OracleType.VarChar);
                Param.Value = Formateo_Texto(obj_Asegurado.NOMBRES);
                cmd.Parameters.Add(Param);
                //06
                Param = new OracleParameter("as_NombreCompleto", OracleType.VarChar);
                Param.Value = Formateo_Texto(obj_Asegurado.NOMBRECOMPLETO);
                cmd.Parameters.Add(Param);
                //07
                Param = new OracleParameter("as_Fec_Nacimiento", OracleType.VarChar);
                Param.Value = Formateo_Texto(obj_Asegurado.FECNAC);
                cmd.Parameters.Add(Param);
                //08
                Param = new OracleParameter("an_Sueldo", OracleType.Number);
                try { Param.Value = float.Parse(obj_Asegurado.SUELDO); }
                catch (Exception) { Param.Value = 0; }
                cmd.Parameters.Add(Param);
                //09
                Param = new OracleParameter("as_Ocupacion", OracleType.VarChar);
                Param.Value = Formateo_Texto(obj_Asegurado.OCUPACION);
                cmd.Parameters.Add(Param);
                //10
                Param = new OracleParameter("as_Nro_Movimiento", OracleType.VarChar);
                Param.Value = Formateo_Texto(obj_Asegurado.NRO_MOVIMIENTO);
                cmd.Parameters.Add(Param);
                //11
                Param = new OracleParameter("as_Cod_Usuario", OracleType.VarChar);
                Param.Value = Formateo_Texto(obj_Asegurado.COD_USR_REG);
                cmd.Parameters.Add(Param);
                //12
                Param = new OracleParameter("as_Cod_Sistema", OracleType.VarChar);
                Param.Value = Formateo_Texto(obj_Asegurado.COD_SISTEMA);
                cmd.Parameters.Add(Param);
                //13
                Param = new OracleParameter("an_NumFila", OracleType.Number);
                Param.Value = Formateo_Texto(obj_Asegurado.NRO_FILA);
                cmd.Parameters.Add(Param);
                //********************PARAMETROS DE RETORNO********************//
                //14
                Param = new OracleParameter("p_nRetorno", OracleType.Number);
                Param.Direction = ParameterDirection.Output;
                cmd.Parameters.Add(Param);
                //15
                Param = new OracleParameter("p_cMensaje", OracleType.VarChar, 2000);
                Param.Direction = ParameterDirection.Output;
                cmd.Parameters.Add(Param);
                //********************PARAMETROS DE RETORNO********************//
                int nResult = cmd.ExecuteNonQuery();
                string cResult = "";
                if (!Convert.IsDBNull(cmd.Parameters["p_nRetorno"]))
                {
                    cResult = Convert.ToString(cmd.Parameters["p_nRetorno"].Value);
                    if (cResult == "-1")
                        throw new Exception(Convert.ToString(cmd.Parameters["p_cMensaje"].Value));
                }
                return cResult;
            }
            catch (OracleException ex)
            {
                General.LogError(ex);
                throw new Exception(ex.Message);

            }
            catch (Exception ex)
            {
                General.LogError(ex);
                throw new Exception(ex.Message);
            }
        }

        public List<EN_RCEN_ASEG0004_TEMP> fr_ValidarTrama(EN_General objEN_General)
        {
            List<EN_RCEN_ASEG0004_TEMP> lstValidar = null;
            OracleDataReader dr = null;
            try
            {
                OracleCommand cmd = new OracleCommand();
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.CommandText = "OIM.PCK_GEST_ASEG.PGEAS003";
                OracleParameter Param;
                //01-Número Movimiento
                Param = new OracleParameter("as_Num_Movimiento", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param00);
                cmd.Parameters.Add(Param);
                //02-Código Compañia
                Param = new OracleParameter("as_Cod_Cia", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param01);
                cmd.Parameters.Add(Param);
                //03-Número de Póliza
                Param = new OracleParameter("as_Num_Poliza", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param02);
                cmd.Parameters.Add(Param);
                //04-Número de Suplemento
                Param = new OracleParameter("as_Num_Spto", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param03);
                cmd.Parameters.Add(Param);
                //05-Número de Aplicación
                Param = new OracleParameter("as_Num_Apli", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param04);
                cmd.Parameters.Add(Param);
                //06-Número de Suplemento Aplicación
                Param = new OracleParameter("as_Num_Spto_Apli", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param05);
                cmd.Parameters.Add(Param);
                //07-Código de Usuario
                Param = new OracleParameter("as_Cod_Usuario", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param06);
                cmd.Parameters.Add(Param);
                //08-Código del Sistema
                Param = new OracleParameter("as_Cod_Sistema", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param07);
                cmd.Parameters.Add(Param);
                //********************PARAMETROS DE RETORNO********************//
                //09
                Param = new OracleParameter("o_cursor", OracleType.Cursor);
                Param.Direction = ParameterDirection.Output;
                cmd.Parameters.Add(Param);
                //********************PARAMETROS DE RETORNO********************//
                dr = base.GetDataReader(cmd);
                if (dr.HasRows)
                {
                    lstValidar = new List<EN_RCEN_ASEG0004_TEMP>();
                    while (dr.Read())
                    {
                        EN_RCEN_ASEG0004_TEMP objGeneral = new EN_RCEN_ASEG0004_TEMP();
                        if (!Convert.IsDBNull(dr["NRO_MOVIMIENTO"]))
                            objGeneral.NRO_MOVIMIENTO = Convert.ToString(dr["NRO_MOVIMIENTO"]);
                        if (!Convert.IsDBNull(dr["NRO_FILA"]))
                            objGeneral.NRO_FILA = Convert.ToString(dr["NRO_FILA"]);
                        if (!Convert.IsDBNull(dr["TIP_DOCUMEN"]))
                            objGeneral.TIPDOC = Convert.ToString(dr["TIP_DOCUMEN"]);
                        if (!Convert.IsDBNull(dr["NRO_DOCUMEN"]))
                            objGeneral.NUMDOC = Convert.ToString(dr["NRO_DOCUMEN"]);
                        if (!Convert.IsDBNull(dr["MOM_COMPLETO"]))
                            objGeneral.NOMBRECOMPLETO = Convert.ToString(dr["MOM_COMPLETO"]);
                        if (!Convert.IsDBNull(dr["APE_PATERNO"]))
                            objGeneral.APEPAT = Convert.ToString(dr["APE_PATERNO"]);
                        if (!Convert.IsDBNull(dr["APE_MATERNO"]))
                            objGeneral.APEMAT = Convert.ToString(dr["APE_MATERNO"]);
                        if (!Convert.IsDBNull(dr["NOMBRE"]))
                            objGeneral.NOMBRES = Convert.ToString(dr["NOMBRE"]);
                        if (!Convert.IsDBNull(dr["FEC_NACIMIENTO"]))
                            objGeneral.FECNAC = Convert.ToString(dr["FEC_NACIMIENTO"]);
                        if (!Convert.IsDBNull(dr["SUELDO"]))
                            objGeneral.SUELDO = Convert.ToString(dr["SUELDO"]);
                        if (!Convert.IsDBNull(dr["OCUPACION"]))
                            objGeneral.OCUPACION = Convert.ToString(dr["OCUPACION"]);
                        if (!Convert.IsDBNull(dr["FILA_REPETIDA"]))
                            objGeneral.MENSAJE = Convert.ToString(dr["FILA_REPETIDA"]);
                        lstValidar.Add(objGeneral);
                    }
                }
            }
            catch (OracleException ex)
            {
                General.LogError(ex);
                throw new Exception(ex.Message);

            }
            catch (Exception ex)
            {
                General.LogError(ex);
                throw new Exception(ex.Message);
            }
            finally
            {
                dr.Close();
                CloseOracleConnection();
            }
            return lstValidar;
        }

        public String fr_RegistrarMovimiento(EN_General objEN_General)
        {
            OracleConnection Cnx = new OracleConnection(ConfigurationManager.ConnectionStrings["OracleWebCon"].ConnectionString);
            OracleCommand cmd = new OracleCommand();
            try
            {
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.CommandText = "OIM.PCK_GEST_ASEG.PGEAS004";
                OracleParameter Param;
                //01
                Param = new OracleParameter("as_Num_Movimiento", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param00);
                cmd.Parameters.Add(Param);
                //02
                Param = new OracleParameter("as_Cod_Cia", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param01);
                cmd.Parameters.Add(Param);
                //03
                Param = new OracleParameter("as_Num_Poliza", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param02);
                cmd.Parameters.Add(Param);
                //04
                Param = new OracleParameter("as_Num_Spto", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param03);
                cmd.Parameters.Add(Param);
                //05
                Param = new OracleParameter("as_Num_Apli", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param04);
                cmd.Parameters.Add(Param);
                //06
                Param = new OracleParameter("as_Num_Spto_Apli", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param05);
                cmd.Parameters.Add(Param);
                //07
                Param = new OracleParameter("as_Tip_Movimiento", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param06);
                cmd.Parameters.Add(Param);
                //08
                Param = new OracleParameter("as_Mca_Facturado", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param07);
                cmd.Parameters.Add(Param);
                //09
                Param = new OracleParameter("as_Cod_Usuario", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param08);
                cmd.Parameters.Add(Param);
                //10
                Param = new OracleParameter("as_Cod_Sistema", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param09);
                cmd.Parameters.Add(Param);
                //********************PARAMETROS DE RETORNO********************//
                //11
                Param = new OracleParameter("p_nRetorno", OracleType.Number);
                Param.Direction = ParameterDirection.Output;
                cmd.Parameters.Add(Param);
                //12
                Param = new OracleParameter("p_cMensaje", OracleType.VarChar, 4000);
                Param.Direction = ParameterDirection.Output;
                cmd.Parameters.Add(Param);
                //********************PARAMETROS DE RETORNO********************//
                Cnx.Open();
                cmd.Connection = Cnx;
                int nResult = cmd.ExecuteNonQuery(); //base.ExecuteNoneQuery(cmd);
                string cResult = "";
                if (!Convert.IsDBNull(cmd.Parameters["p_nRetorno"]))
                {
                    cResult = Convert.ToString(cmd.Parameters["p_nRetorno"].Value);
                    if (cResult == "-1")
                        throw new Exception(Convert.ToString(cmd.Parameters["p_cMensaje"].Value));
                }
                return cResult;
            }
            catch (OracleException ex)
            {
                General.LogError(ex);
                throw new Exception(ex.Message);

            }
            catch (Exception ex)
            {
                General.LogError(ex);
                throw new Exception(ex.Message);
            }
            finally
            {
                Cnx.Close();
            }
        }

        public String fr_GenerarRecibo(EN_General objEN_General)
        {
            OracleConnection Cnx = new OracleConnection(ConfigurationManager.ConnectionStrings["OracleTronCon"].ConnectionString);
            OracleCommand cmd = new OracleCommand();
            try
            {
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.CommandText = "TRON2000.PCK_GESTASEG_GENRECIBOS.RECIBOS_APLICACION_INI";
                OracleParameter Param;

                //01:Número de Movimiento
                Param = new OracleParameter("p_num_mov", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param00);
                cmd.Parameters.Add(Param);
                //02:Tipo de Movimiento
                Param = new OracleParameter("p_tip_mov", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param01);
                cmd.Parameters.Add(Param);
                //03:Código de Compañia
                Param = new OracleParameter("p_cod_cia", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param02);
                cmd.Parameters.Add(Param);
                //04:Número de Ramo
                Param = new OracleParameter("p_cod_ramo", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param03.Substring(0, 3));
                cmd.Parameters.Add(Param);
                //05:Código de Usuario
                Param = new OracleParameter("p_cod_usr", OracleType.VarChar);
                Param.Value = Formateo_Texto("TRON2000");
                cmd.Parameters.Add(Param);
                //********************PARAMETROS DE RETORNO********************//
                //06
                Param = new OracleParameter("p_tip_situacion", OracleType.Number);
                Param.Direction = ParameterDirection.Output;
                cmd.Parameters.Add(Param);
                //07
                Param = new OracleParameter("p_num_recibo", OracleType.Number);
                Param.Direction = ParameterDirection.Output;
                cmd.Parameters.Add(Param);
                //08
                Param = new OracleParameter("p_num_spto", OracleType.Number);
                Param.Direction = ParameterDirection.Output;
                cmd.Parameters.Add(Param);
                //09
                Param = new OracleParameter("p_num_spto_apli", OracleType.Number);
                Param.Direction = ParameterDirection.Output;
                cmd.Parameters.Add(Param);
                //10
                Param = new OracleParameter("p_error", OracleType.VarChar, 2000);
                Param.Direction = ParameterDirection.Output;
                cmd.Parameters.Add(Param);
                //********************PARAMETROS DE RETORNO********************//
                Cnx.Open();
                cmd.Connection = Cnx;
                int nResult = cmd.ExecuteNonQuery();
                string cResult = "";
                if (!Convert.IsDBNull(cmd.Parameters["p_error"]) && Convert.ToString(cmd.Parameters["p_error"]) != "")
                    cResult = Convert.ToString(cmd.Parameters["p_error"].Value);
                if (cResult.Trim() == "") cResult = Convert.ToString(cmd.Parameters["p_num_recibo"].Value);
                else cResult = "ER: " + cResult;
                //}
                //else cResult = "OK";
                return cResult;
            }
            catch (OracleException ex)
            {
                General.LogError(ex);
                throw new Exception(ex.Message);

            }
            catch (Exception ex)
            {
                General.LogError(ex);
                throw new Exception(ex.Message);
            }
            finally
            {
                Cnx.Close();
            }
        }

        /// <summary>
        /// Inserta Log para auditoria de la estabilidad del procedimiento invocado.
        /// </summary>
        /// <param name="p_Usuario">Usuario Invoca</param>
        /// <param name="p_Sistema">Sistema Invoca</param>
        /// <param name="p_Poliza">Número de Póliza</param>
        /// <param name="p_Fecha">Fecha</param>
        /// <param name="p_Parametros">Parámetres del Método Invocado</param>
        /// <param name="p_Mensaje">Mensaje</param>
        /// <returns>OK - ER:MsjError</returns>
        public String fr_InsertarLog(String p_Usuario, String p_Sistema, String p_Poliza, DateTime p_Fecha, String p_Parametros, String p_Mensaje)
        {
            String Rpta = "";
            try
            {
                OracleCommand cmd = new OracleCommand();
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.CommandText = "OIM.PCK_GEST_ASEG.PGEAS000";
                OracleParameter Param;

                Param = new OracleParameter("as_Usuario", OracleType.VarChar);
                Param.Value = Formateo_Texto(p_Usuario);
                cmd.Parameters.Add(Param);

                Param = new OracleParameter("as_Sistema", OracleType.VarChar);
                Param.Value = Formateo_Texto(p_Sistema);
                cmd.Parameters.Add(Param);

                Param = new OracleParameter("as_Nro_Poliza", OracleType.VarChar);
                Param.Value = Formateo_Texto(p_Poliza);
                cmd.Parameters.Add(Param);

                Param = new OracleParameter("ad_Fecha", OracleType.DateTime);
                Param.Value = Formateo_Fecha(p_Fecha);
                cmd.Parameters.Add(Param);

                Param = new OracleParameter("as_Parametros", OracleType.VarChar);
                Param.Value = Formateo_Texto(p_Parametros);
                cmd.Parameters.Add(Param);

                Param = new OracleParameter("as_Mensaje", OracleType.VarChar);
                Param.Value = Formateo_Texto(p_Mensaje);
                cmd.Parameters.Add(Param);

                Param = new OracleParameter("p_nRetorno", OracleType.Number);
                Param.Direction = ParameterDirection.Output;
                cmd.Parameters.Add(Param);

                Param = new OracleParameter("p_cMensaje", OracleType.VarChar, 1000);
                Param.Direction = ParameterDirection.Output;
                cmd.Parameters.Add(Param);

                int nResult = base.ExecuteNoneQuery(cmd);
                string cResult = "";
                if (!Convert.IsDBNull(cmd.Parameters["p_nRetorno"]))
                {
                    cResult = Convert.ToString(cmd.Parameters["p_nRetorno"].Value);
                    if (cResult == "1")
                    {
                        Rpta = Convert.ToString(cmd.Parameters["p_cMensaje"].Value);
                    }
                    if (cResult == "-1")
                        Rpta = Convert.ToString(cmd.Parameters["p_cMensaje"].Value);
                }
                return Rpta;
            }
            catch (OracleException ex)
            {
                General.LogError(ex);
                throw new Exception(ex.Message);
            }
            catch (Exception ex)
            {
                General.LogError(ex);
                throw new Exception(ex.Message);
            }
        }

        public void RecuperarDatosRecibo(ref EN_Aplicacion oEnAplicacion)
        {
            OracleDataReader dr = null;
            try
            {
                OracleCommand Cmd = new OracleCommand();
                Cmd.CommandText = "oim.pck_gest_aseg.PGEAS012";
                Cmd.CommandType = CommandType.StoredProcedure;
                OracleParameter Param;

                Param = new OracleParameter("p_numero_recibo", OracleType.Number);
                Param.Value = oEnAplicacion.oEnEmp.oEnRies.NumRecibo;
                Cmd.Parameters.Add(Param);
                //********************PARAMETROS DE RETORNO********************//
                Param = new OracleParameter("o_cursor", OracleType.Cursor);
                Param.Direction = ParameterDirection.Output;
                Cmd.Parameters.Add(Param);
                //********************PARAMETROS DE RETORNO********************//
                dr = base.GetDataReader(Cmd);
                if (dr.HasRows)
                {
                    while (dr.Read())
                    {
                        #region "Objeto"
                        if (!Convert.IsDBNull(dr["numero_poliza"]))
                            oEnAplicacion.oEnEmp.oEnRies.NumPoliza = Convert.ToString(dr["numero_poliza"]);
                        if (!Convert.IsDBNull(dr["numero_aplicacion"]))
                            oEnAplicacion.NroAplicacion = Convert.ToInt32(dr["numero_aplicacion"]);
                        if (!Convert.IsDBNull(dr["codigo_documento"]))
                            oEnAplicacion.oEnEmp.NroDocumento = Convert.ToString(dr["codigo_documento"]);
                        if (!Convert.IsDBNull(dr["numero_recibo"]))
                            oEnAplicacion.oEnEmp.oEnRies.NumRecibo = Convert.ToInt32(dr["numero_recibo"]);
                        if (!Convert.IsDBNull(dr["cliente"]))
                            oEnAplicacion.oEnEmp.RazonSocial = Convert.ToString(dr["cliente"]);
                        if (!Convert.IsDBNull(dr["direccion"]))
                            oEnAplicacion.oEnEmp.NomDomicilio = Convert.ToString(dr["direccion"]);
                        if (!Convert.IsDBNull(dr["actividad_economica"]))
                            oEnAplicacion.oEnEmp.CodCIIUEmp = Convert.ToString(dr["actividad_economica"]);
                        if (!Convert.IsDBNull(dr["colectivo"]))
                            oEnAplicacion.oEnEmp.oEnSol.ColegAseg = Convert.ToString(dr["colectivo"]);
                        if (!Convert.IsDBNull(dr["fecha_efecto_poliza"]))
                            //oEnAplicacion.oEnEmp.oEnSol.FecIniCad = Convert.ToString(dr["fecha_efecto_poliza"]);
                            oEnAplicacion.oEnEmp.oEnSol.FecIniCad = String.Format("{0:dd/MM/yyyy}", Convert.ToDateTime(dr["fecha_efecto_poliza"]));
                        if (!Convert.IsDBNull(dr["fecha_vcto_poliza"]))
                            //oEnAplicacion.oEnEmp.oEnSol.FecFinalCad = Convert.ToString(dr["fecha_vcto_poliza"]);
                            oEnAplicacion.oEnEmp.oEnSol.FecFinalCad = String.Format("{0:dd/MM/yyyy}", Convert.ToDateTime(dr["fecha_vcto_poliza"]));
                        if (!Convert.IsDBNull(dr["fecha_efecto_aplicacion"]))
                            //oEnAplicacion.FecEfectoApli = Convert.ToString(dr["fecha_efecto_aplicacion"]);
                            oEnAplicacion.FecEfectoApli = String.Format("{0:dd/MM/yyyy}", Convert.ToDateTime(dr["fecha_efecto_aplicacion"]));
                        if (!Convert.IsDBNull(dr["fecha_vcto_aplicacion"]))
                            //oEnAplicacion.FecVctoApli = Convert.ToString(dr["fecha_vcto_aplicacion"]);
                            oEnAplicacion.FecVctoApli = String.Format("{0:dd/MM/yyyy}", Convert.ToDateTime(dr["fecha_vcto_aplicacion"]));
                        if (!Convert.IsDBNull(dr["forma_pago"]))
                            oEnAplicacion.oEnEmp.oEnSol.FormaPago = Convert.ToString(dr["forma_pago"]);
                        if (!Convert.IsDBNull(dr["moneda"]))
                            oEnAplicacion.oEnEmp.oEnSol.Moneda = Convert.ToString(dr["moneda"]);
                        if (!Convert.IsDBNull(dr["fecha_emision_poliza"]))
                            //oEnAplicacion.FecEmisionPoliza = Convert.ToString(dr["fecha_emision_poliza"]);
                            oEnAplicacion.FecEmisionPoliza = String.Format("{0:dd/MM/yyyy}", Convert.ToDateTime(dr["fecha_emision_poliza"]));
                        if (!Convert.IsDBNull(dr["prima_neta"]))
                            oEnAplicacion.oEnEmp.oEnRies.PrimaNeta = Convert.ToDouble(dr["prima_neta"]);
                        if (!Convert.IsDBNull(dr["importe_recargo"]))
                            oEnAplicacion.oEnEmp.oEnRies.ImporteRecargo = Convert.ToDouble(dr["importe_recargo"]);
                        if (!Convert.IsDBNull(dr["importe_interes"]))
                            oEnAplicacion.oEnEmp.oEnRies.ImporteIntereses = Convert.ToDouble(dr["importe_interes"]);
                        if (!Convert.IsDBNull(dr["prima_total"]))
                            oEnAplicacion.oEnEmp.oEnRies.PrimaTotal = Convert.ToDouble(dr["prima_total"]);
                        if (!Convert.IsDBNull(dr["fecha_vencimiento"]))
                            //oEnAplicacion.oEnEmp.oEnRies.FecVctoRecibo = Convert.ToString(dr["fecha_vencimiento"]);
                            oEnAplicacion.oEnEmp.oEnRies.FecVctoRecibo = String.Format("{00:dd/MM/yyyy}", Convert.ToDateTime(dr["fecha_vencimiento"]));
                        if (!Convert.IsDBNull(dr["importe_igv"]))
                            oEnAplicacion.oEnEmp.oEnRies.ImporteIgv = Convert.ToDouble(dr["importe_igv"]);
                        #endregion
                    }
                }
            }
            catch (OracleException ex)
            {
                General.LogError(ex);
                throw new Exception("EXCEPCION AL RECUPERAR DATOS DE RECIBO: " + ex.Message.ToString() + "- [AD_Poliza_RecuperarDatosRecibo]");

            }
            catch (Exception ex)
            {
                General.LogError(ex);
                throw new Exception(ex.Message);
            }
            finally
            {
                dr.Close();
                CloseOracleConnection();
            }
        }

        /// <summary>
        /// Listar riesgo de recibo
        /// </summary>      
        /// <returns></returns>
        public void ListarRiesgoRecibo(Int32 numRecibo, ref List<EN_Riesgos> lstRiesgo)
        {
            OracleDataReader dr = null;
            try
            {
                OracleCommand Cmd = new OracleCommand();
                Cmd.CommandText = "oim.pck_gest_aseg.PGEAS005";
                Cmd.CommandType = CommandType.StoredProcedure;
                OracleParameter Param;

                Param = new OracleParameter("p_numero_recibo", OracleType.Number);
                Param.Value = numRecibo;
                Cmd.Parameters.Add(Param);
                //********************PARAMETROS DE RETORNO********************//
                Param = new OracleParameter("o_cursor", OracleType.Cursor);
                Param.Direction = ParameterDirection.Output;
                Cmd.Parameters.Add(Param);
                //********************PARAMETROS DE RETORNO********************//
                dr = base.GetDataReader(Cmd);
                if (dr.HasRows)
                {
                    while (dr.Read())
                    {
                        EN_Riesgos oEnRiesgo = new EN_Riesgos();
                        #region "Objeto"
                        if (!Convert.IsDBNull(dr["nom_riesgo"]))
                            oEnRiesgo.NombreRiesgo = Convert.ToString(dr["nom_riesgo"]);
                        if (!Convert.IsDBNull(dr["cantidad_planilla"]))
                            oEnRiesgo.CantTrab = Convert.ToInt32(dr["cantidad_planilla"]);
                        if (!Convert.IsDBNull(dr["importe_planilla"]))
                            oEnRiesgo.ImporPlanilla = Convert.ToDouble(dr["importe_planilla"]);
                        if (!Convert.IsDBNull(dr["tasa"]))
                            oEnRiesgo.Tasa = Convert.ToDouble(dr["tasa"]);
                        if (!Convert.IsDBNull(dr["prima"]))
                            oEnRiesgo.PrimaNeta = Convert.ToDouble(dr["prima"]);
                        lstRiesgo.Add(oEnRiesgo);
                        #endregion
                    }
                }
            }
            catch (OracleException ex)
            {
                General.LogError(ex);
                throw new Exception("EXCEPCION AL LISTAR RIESGO DE RECIBO: " + ex.Message.ToString() + "- [AD_Riesgo_ListarRiesgoRecibo]");
            }
            catch (Exception ex)
            {
                General.LogError(ex);
                throw new Exception(ex.Message);
            }
            finally
            {
                dr.Close();
                CloseOracleConnection();
            }
        }

        /// <summary>
        /// General la constacia.
        /// </summary>      
        /// <returns></returns>
        public String fr_GenerarConstancia(EN_General objEN_General)
        {
            OracleCommand cmd = new OracleCommand();
            try
            {
                cmd.CommandType = CommandType.StoredProcedure;
                cmd.CommandText = "OIM.PCK_GEST_ASEG.PGEAS006";
                OracleParameter Param;

                //01:Número de Movimiento
                Param = new OracleParameter("as_Num_Movimiento", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param00);
                cmd.Parameters.Add(Param);
                //02:Código de Compañia
                Param = new OracleParameter("as_Cod_Cia", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param01);
                cmd.Parameters.Add(Param);
                //03:Número de Ramo
                Param = new OracleParameter("as_Num_Poliza", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param02);
                cmd.Parameters.Add(Param);
                //04:Número de Ramo
                Param = new OracleParameter("as_Num_Spto", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param03);
                cmd.Parameters.Add(Param);
                //05:Número de Ramo
                Param = new OracleParameter("as_Num_Apli", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param04);
                cmd.Parameters.Add(Param);
                //06:Número de Ramo
                Param = new OracleParameter("as_Num_Spto_Apli", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param05);
                cmd.Parameters.Add(Param);
                //07:Número de Ramo
                Param = new OracleParameter("as_Ubicacion", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param06);
                cmd.Parameters.Add(Param);
                //08:Código de Usuario
                Param = new OracleParameter("as_Cod_Usuario", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param07);
                cmd.Parameters.Add(Param);
                //09:Código de Usuario
                Param = new OracleParameter("as_Cod_Sistema", OracleType.VarChar);
                Param.Value = Formateo_Texto(objEN_General.Param08);
                cmd.Parameters.Add(Param);
                //********************PARAMETROS DE RETORNO********************//
                //10:Parametro de Retorno
                Param = new OracleParameter("p_nRetorno", OracleType.Number);
                Param.Direction = ParameterDirection.Output;
                cmd.Parameters.Add(Param);
                //11:Parametro de Retorno
                Param = new OracleParameter("p_cMensaje", OracleType.VarChar, 2000);
                Param.Direction = ParameterDirection.Output;
                cmd.Parameters.Add(Param);
                //********************PARAMETROS DE RETORNO********************//

                int nResult = base.ExecuteNoneQuery(cmd);
                string cResult = "";
                if (!Convert.IsDBNull(cmd.Parameters["p_nRetorno"]))
                {
                    cResult = Convert.ToString(cmd.Parameters["p_nRetorno"].Value);
                    if (cResult == "-1") cResult = "ER: " + Convert.ToString(cmd.Parameters["p_cMensaje"].Value);
                    //else cResult = "OK";
                }
                return cResult;
            }
            catch (OracleException ex)
            {
                General.LogError(ex);
                throw new Exception("EXCEPCION AL GENERAR LA CONSTANCIA: " +
                    ex.Message.ToString() + "- [AD_fr_GenerarConstancia]");

            }
            catch (Exception ex)
            {
                General.LogError(ex);
                throw new Exception(ex.Message);
            }
        }

        public void pr_RecuperarConstancia(ref EN_ConstanciaSCTR oEnConstancia)
        {
            OracleDataReader dr = null;
            try
            {
                OracleCommand Cmd = new OracleCommand();
                Cmd.CommandType = CommandType.StoredProcedure;
                Cmd.CommandText = "OIM.PCK_GEST_ASEG.PGEAS007";
                OracleParameter Param;

                Param = new OracleParameter("as_nro_constancia", OracleType.Number);
                Param.Value = oEnConstancia.NumeroConstancia;
                Cmd.Parameters.Add(Param);
                //********************PARAMETROS DE RETORNO********************//
                Param = new OracleParameter("o_cursor", OracleType.Cursor);
                Param.Direction = ParameterDirection.Output;
                Cmd.Parameters.Add(Param);
                //********************PARAMETROS DE RETORNO********************//
                dr = base.GetDataReader(Cmd);
                if (dr.HasRows)
                    while (dr.Read())
                    {
                        if (!Convert.IsDBNull(dr["ID_CONSTANCIA"]))
                            oEnConstancia.SecuencialConstancia = Convert.ToInt32(dr["ID_CONSTANCIA"]);
                        if (!Convert.IsDBNull(dr["POLPEN"]))
                            oEnConstancia.NumeroPolizaPension = (dr["POLPEN"]).ToString();
                        else oEnConstancia.NumeroPolizaPension = "NO";
                        if (!Convert.IsDBNull(dr["NOMBRE"]))
                            oEnConstancia.RazonSocial = (dr["NOMBRE"]).ToString();
                        if (!Convert.IsDBNull(dr["FECINI"]))
                            oEnConstancia.FechaInicioVigencia = dr["FECINI"].ToString();
                        if (!Convert.IsDBNull(dr["FECHAS"]))
                            oEnConstancia.FechaFinVigencia = dr["FECHAS"].ToString();
                        if (!Convert.IsDBNull(dr["POLSAL"]))
                            oEnConstancia.NumeroPolizaSalud = (dr["POLSAL"]).ToString();
                        else oEnConstancia.NumeroPolizaSalud = "NO";
                        if (!Convert.IsDBNull(dr["POLVL"]))
                            oEnConstancia.NumeroPolizaVL = (dr["POLVL"]).ToString();
                        else oEnConstancia.NumeroPolizaVL = "NO";
                        if (!Convert.IsDBNull(dr["UBICACION"]))
                            oEnConstancia.UbicacionTrabajo = (dr["UBICACION"]).ToString();
                        if (!Convert.IsDBNull(dr["NUMERO"]))
                            oEnConstancia.NumeroConstancia = (dr["NUMERO"]).ToString();
                        if (!Convert.IsDBNull(dr["FEC_MOV"]))
                            oEnConstancia.FechaMovimiento = dr["FEC_MOV"].ToString();
                        if (!Convert.IsDBNull(dr["NOMBRE_USUARIO"]))
                            oEnConstancia.NombreUsuario = (dr["NOMBRE_USUARIO"]).ToString();
                    }
            }
            catch (OracleException ex)
            {
                General.LogError(ex);
                throw new Exception("EXCEPCION AL RECUPERAR LA CONSTANCIA: " +
                    ex.Message.ToString() + "- [AD_pr_RecuperarConstancia]");
            }
            catch (Exception ex)
            {
                General.LogError(ex);
                throw new Exception(ex.Message);
            }
            finally
            {
                dr.Close();
                CloseOracleConnection();
            }
        }

        /// <summary>
        /// Recupera Trabajadores de la constancia
        /// </summary>      
        /// <returns></returns>
        public void pr_RecuperarTrabajadorConstancia(EN_ConstanciaSCTR oEnConstancia, ref List<EN_Trabajador> lista)
        {
            OracleDataReader dr = null;
            try
            {
                OracleCommand Cmd = new OracleCommand();
                Cmd.CommandText = "OIM.PCK_GEST_ASEG.PGEAS008";
                Cmd.CommandType = CommandType.StoredProcedure;
                OracleParameter Param = new OracleParameter();

                Param = new OracleParameter("as_nro_constancia", OracleType.Number);
                Param.Value = oEnConstancia.SecuencialConstancia;
                Cmd.Parameters.Add(Param);
                //********************PARAMETROS DE RETORNO********************//
                Param = new OracleParameter("o_cursor", OracleType.Cursor);
                Param.Direction = ParameterDirection.Output;
                Cmd.Parameters.Add(Param);
                //********************PARAMETROS DE RETORNO********************//
                dr = base.GetDataReader(Cmd);
                if (dr.HasRows)
                {
                    while (dr.Read())
                    {
                        EN_Trabajador oEnTrab = new EN_Trabajador();
                        #region "Objeto"
                        if (!Convert.IsDBNull(dr["APEPAT"]))
                            oEnTrab.ApePat = (dr["APEPAT"]).ToString();
                        else oEnTrab.ApePat = " ";
                        if (!Convert.IsDBNull(dr["APEMAT"]))
                            oEnTrab.ApeMat = (dr["APEMAT"]).ToString();
                        else oEnTrab.ApeMat = " ";
                        if (!Convert.IsDBNull(dr["NOMBRES"]))
                            oEnTrab.Nombres = (dr["NOMBRES"]).ToString();
                        else oEnTrab.Nombres = " ";
                        if (!Convert.IsDBNull(dr["NOMBRE_COMPLETO"]))
                            oEnTrab.NombreCompleto = (dr["NOMBRE_COMPLETO"]).ToString();
                        else oEnTrab.NombreCompleto = " ";
                        if (!Convert.IsDBNull(dr["TIP_DOC"]))
                            oEnTrab.TipoDoc = (dr["TIP_DOC"]).ToString();
                        else oEnTrab.TipoDoc = " ";
                        if (!Convert.IsDBNull(dr["NUM_DOC"]))
                            oEnTrab.NumDoc = (dr["NUM_DOC"]).ToString();
                        else oEnTrab.NumDoc = " ";
                        if (!Convert.IsDBNull(dr["OCUPACION"]))
                            oEnTrab.Ocupacion = (dr["OCUPACION"]).ToString();
                        else oEnTrab.Ocupacion = " ";
                        lista.Add(oEnTrab);
                        #endregion
                    }
                }
            }
            catch (OracleException ex)
            {
                General.LogError(ex);
                throw new Exception("EXCEPCION AL LISTAR TRABAJADORES DE LA CONSTANCIA: " +
                    ex.Message.ToString() + "- [AD_pr_RecuperarTrabajadorConstancia]");
            }
            catch (Exception ex)
            {
                General.LogError(ex);
                throw new Exception(ex.Message);
            }
            finally
            {
                dr.Close();
                CloseOracleConnection();
            }
        }

        public void pr_GrabarDocumentoAdjunto(EN_Documento objDocumento, ref String mensaje)
        {
            escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "pr_GrabarDocumentoAdjunto-DA_General paso 01");
            OracleConnection conn = new OracleConnection(ConfigurationManager.ConnectionStrings["OracleTronCon"].ConnectionString);
            escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "pr_GrabarDocumentoAdjunto-DA_General paso 02");
            try
            {
                escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "pr_GrabarDocumentoAdjunto-DA_General paso 03");
                conn.Open();
                escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "pr_GrabarDocumentoAdjunto-DA_General paso 04");
            }
            catch (Exception ex)
            {
                escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "pr_GrabarDocumentoAdjunto-DA_General paso 05");
                escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "Errorrrrrrrr: " + ex.Message);
                escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "strCon: " + ConfigurationManager.ConnectionStrings["OracleTronCon"].ConnectionString);
            }
            try
            {
                OracleCommand cmd = new OracleCommand();
                escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "pr_GrabarDocumentoAdjunto-DA_General paso 06");
                cmd.CommandText = "TRON2000.DC_K_SCTR.PT_GRABA_DOC_ADJ";
                escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "pr_GrabarDocumentoAdjunto-DA_General paso 07");
                cmd.Connection = conn;
                cmd.CommandType = CommandType.StoredProcedure;
                OracleParameter Param;
                escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "pr_GrabarDocumentoAdjunto-DA_General paso 08");
                //01
                Param = new OracleParameter("p_cod_cia", OracleType.Int32);
                Param.Value = objDocumento.Cia;
                cmd.Parameters.Add(Param);
                //02
                Param = new OracleParameter("p_num_poliza", OracleType.VarChar);
                Param.Value = objDocumento.Poliza;
                cmd.Parameters.Add(Param);
                //03
                Param = new OracleParameter("p_num_spto", OracleType.Int32);
                Param.Value = objDocumento.NumSpto;
                cmd.Parameters.Add(Param);
                //04
                Param = new OracleParameter("p_num_apli", OracleType.Int32);
                Param.Value = objDocumento.NumApli;
                cmd.Parameters.Add(Param);
                //05
                Param = new OracleParameter("p_num_spto_apli", OracleType.Int32);
                Param.Value = objDocumento.NumSptoApli;
                cmd.Parameters.Add(Param);
                //06
                Param = new OracleParameter("p_cod_apli_arch", OracleType.VarChar);
                Param.Value = objDocumento.CodApli;
                cmd.Parameters.Add(Param);
                //07
                Param = new OracleParameter("p_dsc_arch", OracleType.VarChar);
                Param.Value = objDocumento.DscDocumento;
                cmd.Parameters.Add(Param);
                //08
                Param = new OracleParameter("p_nom_arch", OracleType.VarChar);
                Param.Value = objDocumento.Nombre;
                cmd.Parameters.Add(Param);
                //09
                Param = new OracleParameter("p_ext_arch", OracleType.VarChar);
                Param.Value = objDocumento.Extension;
                cmd.Parameters.Add(Param);
                //10
                Param = new OracleParameter("p_obj_arch", OracleType.Blob);
                Param.Value = objDocumento.File;
                cmd.Parameters.Add(Param);
                //11
                Param = new OracleParameter("p_size_arch", OracleType.Float);
                Param.Value = objDocumento.Size;
                cmd.Parameters.Add(Param);
                //12
                Param = new OracleParameter("p_ruta_arch", OracleType.VarChar);
                Param.Value = objDocumento.Ruta;
                cmd.Parameters.Add(Param);
                //13
                Param = new OracleParameter("p_cod_usr", OracleType.VarChar);
                Param.Value = objDocumento.Usuario;
                cmd.Parameters.Add(Param);
                //********************PARAMETROS DE RETORNO********************//
                //14
                Param = new OracleParameter("p_mensaje", OracleType.VarChar, 2000);
                Param.Direction = ParameterDirection.Output;
                cmd.Parameters.Add(Param);
                //********************PARAMETROS DE RETORNO********************//
                escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "pr_GrabarDocumentoAdjunto-DA_General paso 09");
                cmd.ExecuteNonQuery();
                escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "pr_GrabarDocumentoAdjunto-DA_General paso 10");
                Console.WriteLine("Image file inserted to database from ");
                escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "pr_GrabarDocumentoAdjunto-DA_General paso 11");
                if (!Convert.IsDBNull(cmd.Parameters["p_mensaje"].Value))
                    mensaje = cmd.Parameters["p_mensaje"].Value.ToString();
                escribirlog(objDocumento.CodApli, objDocumento.Poliza, "", "pr_GrabarDocumentoAdjunto-DA_General paso 12");
            }
            catch (Exception ex)
            {
                conn.Close();
                mensaje = String.Format("Error al insertar el documento: {0}", ex.Message.ToString());
            }
            finally
            {
                conn.Close();
            }
        }

        public void pr_RecuperarCertificado(ref EN_DECASEG_0002 objEN_DECASEG_0002)
        {
            OracleDataReader dr = null;
            try
            {
                OracleCommand Cmd = new OracleCommand();
                Cmd.CommandType = CommandType.StoredProcedure;
                Cmd.CommandText = "OIM.PCK_GEST_ASEG.PGEAS009";
                OracleParameter Param;
                //01
                Param = new OracleParameter("as_Num_Movimiento", OracleType.VarChar);
                Param.Value = objEN_DECASEG_0002.NRO_MOVIMIENTO;
                Cmd.Parameters.Add(Param);
                //02
                Param = new OracleParameter("as_Cod_Cia", OracleType.VarChar);
                Param.Value = objEN_DECASEG_0002.COD_CIA;
                Cmd.Parameters.Add(Param);
                //03
                Param = new OracleParameter("as_Num_Poliza", OracleType.VarChar);
                Param.Value = objEN_DECASEG_0002.NUM_POLIZA;
                Cmd.Parameters.Add(Param);
                //04
                Param = new OracleParameter("as_Num_Spto", OracleType.VarChar);
                Param.Value = objEN_DECASEG_0002.NUM_SPTO;
                Cmd.Parameters.Add(Param);
                //05
                Param = new OracleParameter("as_Num_Apli", OracleType.VarChar);
                Param.Value = objEN_DECASEG_0002.NUM_APLI;
                Cmd.Parameters.Add(Param);
                //06
                Param = new OracleParameter("as_Num_Spto_Apli", OracleType.VarChar);
                Param.Value = objEN_DECASEG_0002.NUM_SPTO_APLI;
                Cmd.Parameters.Add(Param);
                //07
                Param = new OracleParameter("as_Cod_Usuario", OracleType.VarChar);
                Param.Value = objEN_DECASEG_0002.COD_USUARIO;
                Cmd.Parameters.Add(Param);
                //08
                Param = new OracleParameter("as_Cod_Sistema", OracleType.VarChar);
                Param.Value = objEN_DECASEG_0002.COD_SISTEMA;
                Cmd.Parameters.Add(Param);
                //09
                //Param = new OracleParameter("as_tip_certificado", OracleType.VarChar);
                //Param.Value = objEN_DECASEG_0002.TIP_CERTIFICADO;
                //Cmd.Parameters.Add(Param);
                //********************PARAMETROS DE RETORNO********************//
                //10
                Param = new OracleParameter("o_cursor", OracleType.Cursor);
                Param.Direction = ParameterDirection.Output;
                Cmd.Parameters.Add(Param);
                //********************PARAMETROS DE RETORNO********************//
                dr = base.GetDataReader(Cmd);
                if (dr.HasRows)
                    while (dr.Read())
                    {
                        if (!Convert.IsDBNull(dr["NUM_POLIZA"]))
                            objEN_DECASEG_0002.NUM_POLIZA = Convert.ToString(dr["NUM_POLIZA"]);
                        if (!Convert.IsDBNull(dr["NUM_SPTO"]))
                            objEN_DECASEG_0002.NUM_SPTO = Convert.ToString(dr["NUM_SPTO"]);
                        if (!Convert.IsDBNull(dr["NUM_APLI"]))
                            objEN_DECASEG_0002.NUM_APLI = Convert.ToString(dr["NUM_APLI"]);
                        if (!Convert.IsDBNull(dr["NUM_SPTO_APLI"]))
                            objEN_DECASEG_0002.NUM_SPTO_APLI = Convert.ToString(dr["NUM_SPTO_APLI"]);
                        if (!Convert.IsDBNull(dr["FEC_EMISION"]))
                            objEN_DECASEG_0002.FEC_EMISION = Convert.ToString(dr["FEC_EMISION"]);
                        if (!Convert.IsDBNull(dr["FEC_INI_VIG"]))
                            objEN_DECASEG_0002.FEC_INI_VIG = Convert.ToString(dr["FEC_INI_VIG"]);
                        if (!Convert.IsDBNull(dr["FEC_FIN_VIG"]))
                            objEN_DECASEG_0002.FEC_FIN_VIG = Convert.ToString(dr["FEC_FIN_VIG"]);
                        if (!Convert.IsDBNull(dr["CONTRATANTE"]))
                            objEN_DECASEG_0002.CONTRATANTE = Convert.ToString(dr["CONTRATANTE"]);
                        if (!Convert.IsDBNull(dr["FEC_TRANSFERENCIA"]))
                            objEN_DECASEG_0002.FEC_TRANSFERENCIA = Convert.ToString(dr["FEC_TRANSFERENCIA"]);
                        if (!Convert.IsDBNull(dr["TIP_DOCUM_CONT"]))
                            objEN_DECASEG_0002.TIP_DOCUM_CONT = Convert.ToString(dr["TIP_DOCUM_CONT"]);
                        if (!Convert.IsDBNull(dr["COD_DOCUM_CONT"]))
                            objEN_DECASEG_0002.COD_DOCUM_CONT = Convert.ToString(dr["COD_DOCUM_CONT"]);
                        if (!Convert.IsDBNull(dr["DIRECCION_CONT"]))
                            objEN_DECASEG_0002.DIRECCION_CONT = Convert.ToString(dr["DIRECCION_CONT"]);
                        if (!Convert.IsDBNull(dr["TELEFONO_CONT"]))
                            objEN_DECASEG_0002.TELEFONO_CONT = Convert.ToString(dr["TELEFONO_CONT"]);
                        if (!Convert.IsDBNull(dr["NOM_RAZON_SOCIAL_CIA"]))
                            objEN_DECASEG_0002.NOM_RAZON_SOCIAL_CIA = Convert.ToString(dr["NOM_RAZON_SOCIAL_CIA"]);
                        if (!Convert.IsDBNull(dr["NOM_RAZON_SOCIAL_CIA_2"]))
                            objEN_DECASEG_0002.NOM_RAZON_SOCIAL_CIA_2 = Convert.ToString(dr["NOM_RAZON_SOCIAL_CIA_2"]);
                        if (!Convert.IsDBNull(dr["TIP_DOCUM_CIA"]))
                            objEN_DECASEG_0002.TIP_DOCUM_CIA = Convert.ToString(dr["TIP_DOCUM_CIA"]);
                        if (!Convert.IsDBNull(dr["COD_DOCUM_CIA"]))
                            objEN_DECASEG_0002.COD_DOCUM_CIA = Convert.ToString(dr["COD_DOCUM_CIA"]);
                        if (!Convert.IsDBNull(dr["DIRECCION_CIA"]))
                            objEN_DECASEG_0002.DIRECCION_CIA = Convert.ToString(dr["DIRECCION_CIA"]);
                        if (!Convert.IsDBNull(dr["TLF_NUMERO_CIA"]))
                            objEN_DECASEG_0002.TLF_NUMERO_CIA = Convert.ToString(dr["TLF_NUMERO_CIA"]);
                        if (!Convert.IsDBNull(dr["FAX_NUMERO_CIA"]))
                            objEN_DECASEG_0002.FAX_NUMERO_CIA = Convert.ToString(dr["FAX_NUMERO_CIA"]);
                    }
            }
            catch (OracleException ex)
            {
                General.LogError(ex);
                throw new Exception("EXCEPCION AL RECUPERAR LA CONSTANCIA: " +
                    ex.Message.ToString() + "- [AD_pr_RecuperarConstancia]");
            }
            catch (Exception ex)
            {
                General.LogError(ex);
                throw new Exception(ex.Message);
            }
            finally
            {
                dr.Close();
                CloseOracleConnection();
            }
        }

        public void pr_RecuperarTrabajadorCertificado(EN_DECASEG_0002 oEnCertificado, ref List<EN_Trabajador> lista)
        {
            OracleDataReader dr = null;
            try
            {
                OracleCommand Cmd = new OracleCommand();
                Cmd.CommandText = "OIM.PCK_GEST_ASEG.PGEAS010";
                Cmd.CommandType = CommandType.StoredProcedure;
                OracleParameter Param = new OracleParameter();

                //Número de Movimiento
                Param = new OracleParameter("as_nro_movi", OracleType.VarChar);
                Param.Value = oEnCertificado.NRO_MOVIMIENTO;
                Cmd.Parameters.Add(Param);
                //********************PARAMETROS DE RETORNO********************//
                Param = new OracleParameter("o_cursor", OracleType.Cursor);
                Param.Direction = ParameterDirection.Output;
                Cmd.Parameters.Add(Param);
                //********************PARAMETROS DE RETORNO********************//
                dr = base.GetDataReader(Cmd);
                if (dr.HasRows)
                {
                    while (dr.Read())
                    {
                        EN_Trabajador oEnTrab = new EN_Trabajador();
                        #region "Objeto"
                        if (!Convert.IsDBNull(dr["NOMBRE_COMPLETO"]))
                            oEnTrab.NombreCompleto = (dr["NOMBRE_COMPLETO"]).ToString();
                        if (!Convert.IsDBNull(dr["TIP_DOC"]))
                            oEnTrab.TipoDoc = (dr["TIP_DOC"]).ToString();
                        if (!Convert.IsDBNull(dr["NUM_DOC"]))
                            oEnTrab.NumDoc = (dr["NUM_DOC"]).ToString();
                        if (!Convert.IsDBNull(dr["FECNAC"]))
                            oEnTrab.FecNac = (dr["FECNAC"]).ToString();
                        if (!Convert.IsDBNull(dr["SUELDO"]))
                            oEnTrab.Sueldo = Convert.ToDouble(dr["SUELDO"]);
                        if (!Convert.IsDBNull(dr["OCUPACION"]))
                            oEnTrab.Ocupacion = (dr["OCUPACION"]).ToString();
                        lista.Add(oEnTrab);
                        #endregion
                    }
                }
            }
            catch (OracleException ex)
            {
                General.LogError(ex);
                throw new Exception("EXCEPCION AL LISTAR TRABAJADORES DE LA CONSTANCIA: " +
                    ex.Message.ToString() + "- [AD_pr_RecuperarTrabajadorConstancia]");
            }
            catch (Exception ex)
            {
                General.LogError(ex);
                throw new Exception(ex.Message);
            }
            finally
            {
                dr.Close();
                CloseOracleConnection();
            }
        }

        private void escribirlog(String p_Sistema, String p_Poliza, String p_Parametros, String p_Mensaje)
        {
            String p_Usuario = System.Security.Principal.WindowsIdentity.GetCurrent().Name.ToString();
            fr_InsertarLog(p_Usuario, p_Sistema, p_Poliza, DateTime.Now, p_Parametros, p_Mensaje);
        }
    }
}
