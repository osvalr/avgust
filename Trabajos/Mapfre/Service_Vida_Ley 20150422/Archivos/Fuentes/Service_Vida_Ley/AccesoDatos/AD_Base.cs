using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using System.Configuration;
using System.Data.OracleClient;


namespace AccesoDatos
{
    public class AD_Base
    {
        #region Variables Privadas
        private OracleConnection OracleConn;
        #endregion

        #region Constructor
        public AD_Base()
        {
            OracleConn = new OracleConnection();
            //if (OracleConn == null)
                OracleConn.ConnectionString = ConfigurationManager.ConnectionStrings["OracleWebCon"].ConnectionString;
        }
        #endregion

        #region Metodos Privados

        private void OpenOracleConnection()
        {
            if (OracleConn.State != ConnectionState.Open)
            {
                OracleConn.Open();
            }
        }

        public void CloseOracleConnection()
        {
            if (OracleConn.State == ConnectionState.Open)
            {
                OracleConn.Close();
            }
        }


        #endregion

        #region Metodos Publicos

        public DataSet GetDataSet(OracleCommand OracleComm)
        {
            OracleDataAdapter OracleDataAdp;
            DataSet dsData;
            try
            {
                OracleComm.Connection = OracleConn;
                OracleDataAdp = new OracleDataAdapter(OracleComm);
                dsData = new DataSet();
                OracleDataAdp.Fill(dsData);
                return dsData;
            }
            catch (Exception ex)
            {
                throw ex;
            }
            finally
            {
                OracleDataAdp = null;
                dsData = null;
            }
        }

        public int ExecuteNoneQuery(OracleCommand OracleComm)
        {
            try
            {
                OpenOracleConnection();
                OracleComm.Connection = OracleConn;
                int i = OracleComm.ExecuteNonQuery();
                return i;

            }
            catch (Exception ex)
            {
                throw ex;
            }
            finally
            {
                CloseOracleConnection();
            }
        }

        public Object ExecuteScalar(OracleCommand OracleComm)
        {
            try
            {
                OpenOracleConnection();
                OracleComm.Connection = OracleConn;
                return OracleComm.ExecuteScalar();

            }
            catch (Exception ex)
            {
                throw ex;
            }
            finally
            {
                CloseOracleConnection();
            }
        }


        public OracleDataReader GetDataReader(OracleCommand OracleComm)
        {

            try
            {
                OpenOracleConnection();
                OracleComm.Connection = OracleConn;
                return OracleComm.ExecuteReader();
            }
            catch (Exception ex)
            {
                CloseOracleConnection();
                throw ex;
            }
        }

        public OracleDataAdapter GetDataAdapter(OracleCommand OracleComm)
        {
            try
            {
                OpenOracleConnection();
                OracleComm.Connection = OracleConn;
                return new OracleDataAdapter(OracleComm);
            }
            catch (Exception ex)
            {
                CloseOracleConnection();
                throw ex;
            }
        }

        #endregion

        #region Metodos Formateo
        //  <summary>
        //  Formateo Dato Decimal
        //  </summary>
        //  <param name="objValor">Dato a Formatear</param>
        //  <returns></returns>
        public object Formateo_Numero(object ObjValor)
        {
            if (ObjValor != null)
            {
                ObjValor = Convert.ToInt32(ObjValor);
            }

            if (((ObjValor != null)
                        && !(ObjValor.Equals(0) || ObjValor.Equals(0.0))))
            {
                return ObjValor;
            }
            else
            {
                return DBNull.Value;
            }
        }

        //  <summary>
        //  Formateo Dato Cadena 
        //  </summary>
        //  <param name="objValor">Dato a Formatear</param>
        //  <returns></returns>
        public object Formateo_Texto(string ObjValor)
        {
            if (((ObjValor != null)
                        && (ObjValor != String.Empty)))
            {
                return ObjValor;
            }
            else
            {
                return DBNull.Value;
            }
        }

        //  <summary>
        //  Formateo Dato Fecha
        //  </summary>
        //  <param name="objValor">Dato a Formatear</param>
        //  <returns></returns>
        public object Formateo_Fecha(object ObjValor)
        {
            if (ObjValor != null)
            {
                var anio = Convert.ToDateTime(ObjValor).Year;
                if (anio == 1)
                    return DBNull.Value;
                else
                    return ObjValor;
            }
            else
            {
                return DBNull.Value;
            }
        }

        #endregion  

    }
}