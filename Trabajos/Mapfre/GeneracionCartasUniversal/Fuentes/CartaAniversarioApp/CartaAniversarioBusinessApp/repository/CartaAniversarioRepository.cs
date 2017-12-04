using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Oracle.DataAccess.Client;
using System.Data;
using System.Threading;
using System.Globalization;

namespace CartaAniversarioBusinessApp.repository
{
    public class CartaAniversarioRepository
    {
        public void insertList(List<model.CartaCab> list, string connectionString) {

            Thread.CurrentThread.CurrentCulture = new CultureInfo("es-ES");

            OracleConnection conn = util.Connection.connect(connectionString);
            
            conn.Open();

            OracleTransaction transaction;
            // Start a local transaction
            transaction = conn.BeginTransaction(IsolationLevel.ReadCommitted);

            foreach (model.CartaCab record in list) {
                OracleCommand cmd = conn.CreateCommand() ;
                // Assign transaction object for a pending local transaction
                cmd.Transaction = transaction;

                Int32? seq = this.getSeq(conn);

                // Perform insert using parameters (bind variables)
                cmd.CommandText = "Insert into TRON2000.TA_VU_CARTA_ANIV_CAB (NRO_CARTA_VU, ANIO_CARTA_VU, NUM_POLIZA, NUM_POLIZA_PANAMA, FEC_EFECTIVA_VU, FEC_EFECTIVA_EDT_VU, NOM_ASEGURADO, NOM_CONTRATANTE, DIRECCION_CONTRATANTE, LOCALIDAD_CONTRATANTE, FEC_INI_ANIV_VU, FEC_FIN_ANIV_VU, BENEF_MUER_BAS_1_VU, BENEF_MUER_BAS_2_VU, VAL_EFEC_ACUM_1_VU, VAL_EFEC_ACUM_2_VU, VAL_BAL_PRESTAMO_1_VU, VAL_BAL_PRESTAMO_2_VU, VAL_CARGO_RESCATE_1_VU, VAL_CARGO_RESCATE_2_VU, VAL_EFECT_CTACTE_1_VU, VAL_EFECT_CTACTE_2_VU, FEC_SEG_GARAN_FIN_VU, FEC_SEG_GARAN_FIN_EDT_VU, FEC_ACTU, HORA_ACTU, MCA_INH, COD_USR, MCA_ESTADO_REG)"

                + "VALUES (:NRO_CARTA_VU, :ANIO_CARTA_VU, :NUM_POLIZA, :NUM_POLIZA_PANAMA, :FEC_EFECTIVA_VU, :FEC_EFECTIVA_EDT_VU, :NOM_ASEGURADO, :NOM_CONTRATANTE, :DIRECCION_CONTRATANTE, "
                +":LOCALIDAD_CONTRATANTE, :FEC_INI_ANIV_VU, :FEC_FIN_ANIV_VU, :BENEF_MUER_BAS_1_VU, :BENEF_MUER_BAS_2_VU, "
                +":VAL_EFEC_ACUM_1_VU, :VAL_EFEC_ACUM_2_VU, :VAL_BAL_PRESTAMO_1_VU, :VAL_BAL_PRESTAMO_2_VU, :VAL_CARGO_RESCATE_1_VU, :VAL_CARGO_RESCATE_2_VU, :VAL_EFECT_CTACTE_1_VU, "
                +":VAL_EFECT_CTACTE_2_VU, :FEC_SEG_GARAN_FIN_VU, :FEC_SEG_GARAN_FIN_EDT_VU, :FEC_ACTU, :HORA_ACTU, :MCA_INH, :COD_USR, :MCA_ESTADO_REG)";

                string numeroPoliza = "";
                string asegurado = "";

                {
                    string[] arr = record.numeroPoliza.Split('-');
                    numeroPoliza = arr[2].Trim();
                }

                {
                    string[] arr = record.asegurado.Split('-');
                    asegurado = arr[1].Trim();
                }

                // Here's one way to use parameters aka bind variables:
                // Create parameters to hold values from front-end
                cmd.Parameters.Add(new OracleParameter("NRO_CARTA_VU", OracleDbType.Int64, seq, ParameterDirection.Input));
                cmd.Parameters.Add(new OracleParameter("ANIO_CARTA_VU", OracleDbType.Int64, record.fechaFinaliza.Year, ParameterDirection.Input));
                cmd.Parameters.Add(new OracleParameter("NUM_POLIZA", OracleDbType.Varchar2, "64800"+numeroPoliza, ParameterDirection.Input));
                cmd.Parameters.Add(new OracleParameter("NUM_POLIZA_PANAMA", OracleDbType.Varchar2, numeroPoliza , ParameterDirection.Input));
                cmd.Parameters.Add(new OracleParameter("FEC_EFECTIVA_VU", OracleDbType.Date, record.fechaEfectiva , ParameterDirection.Input));
                cmd.Parameters.Add(new OracleParameter("FEC_EFECTIVA_EDT_VU", OracleDbType.Varchar2, string.Format(record.fechaEfectiva.ToString("dd {0} MMMM {1} yyyy"),"de","de") , ParameterDirection.Input));
                cmd.Parameters.Add(new OracleParameter("NOM_ASEGURADO", OracleDbType.Varchar2, asegurado , ParameterDirection.Input));
                cmd.Parameters.Add(new OracleParameter("NOM_CONTRATANTE", OracleDbType.Varchar2, record.contratante , ParameterDirection.Input));
                cmd.Parameters.Add(new OracleParameter("DIRECCION_CONTRATANTE", OracleDbType.Varchar2,record.DireccionContratante , ParameterDirection.Input));
                cmd.Parameters.Add(new OracleParameter("LOCALIDAD_CONTRATANTE", OracleDbType.Varchar2,record.localidadContratante , ParameterDirection.Input));
                cmd.Parameters.Add(new OracleParameter("FEC_INI_ANIV_VU", OracleDbType.Date,record.fechaDesde , ParameterDirection.Input));
                cmd.Parameters.Add(new OracleParameter("FEC_FIN_ANIV_VU", OracleDbType.Date,record.fechaHasta , ParameterDirection.Input));
                cmd.Parameters.Add(new OracleParameter("BENEF_MUER_BAS_1_VU", OracleDbType.Decimal,record.beneficioMuerteBasico1 , ParameterDirection.Input));
                cmd.Parameters.Add(new OracleParameter("BENEF_MUER_BAS_2_VU", OracleDbType.Decimal,record.beneficioMuerteBasico2 , ParameterDirection.Input));
                cmd.Parameters.Add(new OracleParameter("VAL_EFEC_ACUM_1_VU", OracleDbType.Decimal,record.valorEfectivoAcumulado1 , ParameterDirection.Input));
                cmd.Parameters.Add(new OracleParameter("VAL_EFEC_ACUM_2_VU", OracleDbType.Decimal,record.valorEfectivoAcumulado2 , ParameterDirection.Input));
                cmd.Parameters.Add(new OracleParameter("VAL_BAL_PRESTAMO_1_VU", OracleDbType.Decimal,record.balancePrestamo1 , ParameterDirection.Input));
                cmd.Parameters.Add(new OracleParameter("VAL_BAL_PRESTAMO_2_VU", OracleDbType.Decimal,record.balancePrestamo2 , ParameterDirection.Input));
                cmd.Parameters.Add(new OracleParameter("VAL_CARGO_RESCATE_1_VU", OracleDbType.Decimal,record.cargosRescate1 , ParameterDirection.Input));
                cmd.Parameters.Add(new OracleParameter("VAL_CARGO_RESCATE_2_VU", OracleDbType.Decimal,record.cargosRescate2 , ParameterDirection.Input));
                cmd.Parameters.Add(new OracleParameter("VAL_EFECT_CTACTE_1_VU", OracleDbType.Decimal,record.valorEfectivoCorriente1 , ParameterDirection.Input));
                cmd.Parameters.Add(new OracleParameter("VAL_EFECT_CTACTE_2_VU", OracleDbType.Decimal,record.valorEfectivoCorriente2 , ParameterDirection.Input));
                cmd.Parameters.Add(new OracleParameter("FEC_SEG_GARAN_FIN_VU", OracleDbType.Date,record.fechaFinaliza , ParameterDirection.Input));
                cmd.Parameters.Add(new OracleParameter("FEC_SEG_GARAN_FIN_EDT_VU", OracleDbType.Varchar2, string.Format(record.fechaFinaliza.ToString("dd {0} MMMM {1} yyyy"), "de", "de"), ParameterDirection.Input));
                cmd.Parameters.Add(new OracleParameter("FEC_ACTU", OracleDbType.Date, DateTime.Today , ParameterDirection.Input));
                cmd.Parameters.Add(new OracleParameter("HORA_ACTU", OracleDbType.Varchar2, DateTime.Now.ToString("H:mm:ss") , ParameterDirection.Input));
                cmd.Parameters.Add(new OracleParameter("MCA_INH", OracleDbType.Varchar2,"N" , ParameterDirection.Input));
                cmd.Parameters.Add(new OracleParameter("COD_USR", OracleDbType.Varchar2, "TRON2000", ParameterDirection.Input));
                cmd.Parameters.Add(new OracleParameter("MCA_ESTADO_REG", OracleDbType.Varchar2, "2", ParameterDirection.Input));

                cmd.ExecuteNonQuery();
                int i = 1;
                foreach (model.CartaDet item in record.listCartaDet) {
                    OracleCommand cmdx = conn.CreateCommand();
                    // Assign transaction object for a pending local transaction
                    cmdx.Transaction = transaction;

                    // Perform insert using parameters (bind variables)
                    cmdx.CommandText = "insert into TRON2000.TA_VU_CARTA_ANIV_DET (NRO_CARTA_VU,NRO_CARTA_SEC_VU,FEC_DETALLE_VU,VAL_PRIMA_INGRESADA_VU,VAL_CARGO_ADM_VU,VAL_COSTO_SEGURO_VU,VAL_INTERES_VU,PCT_INTERES_VU,VAL_RESCATE_PARCIAL_VU) "
                    + "VALUES(:NRO_CARTA_VU,:NRO_CARTA_SEC_VU,:FEC_DETALLE_VU,:VAL_PRIMA_INGRESADA_VU,:VAL_CARGO_ADM_VU,:VAL_COSTO_SEGURO_VU,:VAL_INTERES_VU,:PCT_INTERES_VU,:VAL_RESCATE_PARCIAL_VU)";

                    // Here's one way to use parameters aka bind variables:
                    // Create parameters to hold values from front-end
                    cmdx.Parameters.Add(new OracleParameter("NRO_CARTA_VU", OracleDbType.Int64, seq, ParameterDirection.Input));
                    cmdx.Parameters.Add(new OracleParameter("NRO_CARTA_SEC_VU", OracleDbType.Int64, i, ParameterDirection.Input));
                    cmdx.Parameters.Add(new OracleParameter("FEC_DETALLE_VU", OracleDbType.Date, item.fechaAnterior, ParameterDirection.Input));
                    cmdx.Parameters.Add(new OracleParameter("VAL_PRIMA_INGRESADA_VU", OracleDbType.Decimal, item.primaIngresada, ParameterDirection.Input));
                    cmdx.Parameters.Add(new OracleParameter("VAL_CARGO_ADM_VU", OracleDbType.Decimal, item.cargoAdministrativo, ParameterDirection.Input));
                    cmdx.Parameters.Add(new OracleParameter("VAL_COSTO_SEGURO_VU", OracleDbType.Decimal, item.costoSeguro, ParameterDirection.Input));
                    cmdx.Parameters.Add(new OracleParameter("VAL_INTERES_VU", OracleDbType.Decimal, item.interesMonto, ParameterDirection.Input));
                    cmdx.Parameters.Add(new OracleParameter("PCT_INTERES_VU", OracleDbType.Decimal, item.interesPorcentaje, ParameterDirection.Input));
                    cmdx.Parameters.Add(new OracleParameter("VAL_RESCATE_PARCIAL_VU", OracleDbType.Decimal, item.rescateParcialPrestamo, ParameterDirection.Input));

                    cmdx.ExecuteNonQuery();

                    i++;
                }

            }

            transaction.Commit();

            conn.Dispose();
        }

        public Int32? getSeq(Oracle.DataAccess.Client.OracleConnection conn)
        {

            Int32? seq = null;

            OracleCommand command = new OracleCommand("SELECT  TRON2000.SEQ_VU_CARTA_ANIVERSARIO.NEXTVAL as seq FROM dual");
            command.Connection = conn;
            seq = Convert.ToInt32(command.ExecuteScalar());
            return seq;
        }

        public void setInfoContratante(CartaAniversarioBusinessApp.model.CartaCab cartaCab,string connectionString)
        {

            string numeroPoliza = "";
            {
                string[] arr = cartaCab.numeroPoliza.Split('-');
                numeroPoliza = arr[2].Trim();
            }


            string tipoDoc;
            string numDoc;

            this.getTipoYNumeroDocContratante(connectionString, numeroPoliza,out tipoDoc,out numDoc);

            string direccion = this.getDireccionContratante(connectionString, tipoDoc, numDoc);
            string nombres = this.getNombresContratante(connectionString, tipoDoc, numDoc);
            string localidad = this.getLocalidad(connectionString, tipoDoc, numDoc);

            cartaCab.DireccionContratante = direccion;
            cartaCab.contratante = nombres;
            cartaCab.localidadContratante = localidad;

        }

        public void getTipoYNumeroDocContratante(string connectionString, string numeroPoliza,out string tipoDoc,out string numDoc)
        {
            tipoDoc = null;
            numDoc = null;

            OracleConnection conn = util.Connection.connect(connectionString);
            conn.Open();

            OracleCommand command = new OracleCommand("SELECT  A.TIP_DOCUM, A.COD_DOCUM  FROM   A2000030 A  WHERE A.COD_CIA = 02 AND A.NUM_POLIZA = :NUM_POLIZA");
            command.Parameters.Add(new OracleParameter("NUM_POLIZA", OracleDbType.Varchar2, "64800" + numeroPoliza, ParameterDirection.Input));
            command.Connection = conn;
            OracleDataReader dr = command.ExecuteReader(CommandBehavior.CloseConnection);
            DataTable dt = new DataTable();
            dt.Load(dr);

            foreach (DataRow row in dt.Rows)
            {
                tipoDoc = row["TIP_DOCUM"].ToString();
                numDoc = row["COD_DOCUM"].ToString();
            }

        }

        public string getDireccionContratante(string connectionString, string tipoDoc, string numDoc)
        {
            string direccion = null;

            OracleConnection conn = util.Connection.connect(connectionString);
            conn.Open();

            OracleCommand command = new OracleCommand("select nvl(NOM_DOMICILIO1,'') as NOM_DOMICILIO1, nvl(NOM_DOMICILIO2,'') as NOM_DOMICILIO2, nvl(NOM_DOMICILIO3,'') as NOM_DOMICILIO3 from a1001331 where cod_cia=02 and  cod_docum=:cod_docum  AND tip_docum=:tip_docum");
            command.Parameters.Add(new OracleParameter("cod_docum", OracleDbType.Varchar2, numDoc, ParameterDirection.Input));
            command.Parameters.Add(new OracleParameter("tip_docum", OracleDbType.Varchar2, tipoDoc, ParameterDirection.Input));
            command.Connection = conn;
            OracleDataReader dr = command.ExecuteReader(CommandBehavior.CloseConnection);
            DataTable dt = new DataTable();
            dt.Load(dr);

            foreach (DataRow row in dt.Rows)
            {
                direccion = row["NOM_DOMICILIO1"].ToString() + " " + row["NOM_DOMICILIO2"].ToString() + " " +row["NOM_DOMICILIO3"].ToString();
            }
            return direccion;
        }

        public string getNombresContratante(string connectionString, string tipoDoc, string numDoc)
        {
            string nombres = null;

            OracleConnection conn = util.Connection.connect(connectionString);
            conn.Open();

            OracleCommand command = new OracleCommand("select nvl(APE1_TERCERO,'') APE1_TERCERO, nvl(APE2_TERCERO,'') APE2_TERCERO, nvl(NOM_TERCERO,'') NOM_TERCERO from a1001399 where cod_cia=02 and  cod_docum=:cod_docum  AND tip_docum=:tip_docum");
            command.Parameters.Add(new OracleParameter("cod_docum", OracleDbType.Varchar2, numDoc, ParameterDirection.Input));
            command.Parameters.Add(new OracleParameter("tip_docum", OracleDbType.Varchar2, tipoDoc, ParameterDirection.Input));
            
            command.Connection = conn;
            OracleDataReader dr = command.ExecuteReader(CommandBehavior.CloseConnection);
            DataTable dt = new DataTable();
            dt.Load(dr);

            foreach (DataRow row in dt.Rows)
            {
                nombres = row["APE1_TERCERO"].ToString() + " " + row["APE2_TERCERO"].ToString() + ", " + row["NOM_TERCERO"].ToString();
            }
            return nombres;
        }

        public string getLocalidad(string connectionString, string tipoDoc, string numDoc)
        {
            string localidad = null;

            OracleConnection conn = util.Connection.connect(connectionString);
            DataTable dt = new DataTable();
            conn.Open();

            {
                OracleCommand command = new OracleCommand("select NVL(nom_localidad,'SIN DISTRITO') as localidad from a1001331 where cod_cia=02 and  cod_docum=:cod_docum  AND tip_docum=:tip_docum");
                command.Parameters.Add(new OracleParameter("cod_docum", OracleDbType.Varchar2, numDoc, ParameterDirection.Input));
                command.Parameters.Add(new OracleParameter("tip_docum", OracleDbType.Varchar2, tipoDoc, ParameterDirection.Input));
                command.Connection = conn;
                OracleDataReader dr = command.ExecuteReader();
                dt.Load(dr);
            }

            if (dt.Rows.Count > 0)
            {
                foreach (DataRow row in dt.Rows)
                {
                    localidad = row["localidad"].ToString();
                }
            }
            else
            {
                {
                    string query = "select NVL(nom_localidad,'SIN DISTRITO')  as localidad from a1001332 a where a.cod_cia=02 and  a.cod_docum=:cod_docum  AND a.tip_docum=:tip_docum ";
                    query = query + " AND A.FEC_VALIDEZ = (SELECT MAX(B.FEC_VALIDEZ) FROM A1001332 B Where B.cod_cia =2 AND B.tip_docum =:tip_docum ";
                    query = query + " AND B.cod_docum =:cod_docum AND B.cod_act_tercero = 1 )";
                    OracleCommand command = new OracleCommand(query);
                    command.Parameters.Add(new OracleParameter("cod_docum", OracleDbType.Varchar2, numDoc, ParameterDirection.Input));
                    command.Parameters.Add(new OracleParameter("tip_docum", OracleDbType.Varchar2, tipoDoc, ParameterDirection.Input));
                    command.Connection = conn;
                    OracleDataReader dr = command.ExecuteReader();
                    dt.Load(dr);
                }

                if (dt.Rows.Count > 0)
                {
                    foreach (DataRow row in dt.Rows)
                    {
                        localidad = row["localidad"].ToString();
                    }
                }
                else {

                    {
                        string query = "select NVL(nom_localidad,'SIN DISTRITO')  as localidad from a1001300 a where a.cod_cia=02 and  a.cod_docum=:cod_docum  AND a.tip_docum=:tip_docum ";
                        query = query + " AND A.FEC_VALIDEZ = (SELECT MAX(B.FEC_VALIDEZ) FROM a1001300 B Where B.cod_cia =2 AND B.tip_docum =:tip_docum ";
                        query = query + " AND B.cod_docum =:cod_docum AND B.cod_act_tercero = 1 )";
                        OracleCommand command = new OracleCommand(query);
                        command.Parameters.Add(new OracleParameter("cod_docum", OracleDbType.Varchar2, numDoc, ParameterDirection.Input));
                        command.Parameters.Add(new OracleParameter("tip_docum", OracleDbType.Varchar2, tipoDoc, ParameterDirection.Input));
                        command.Connection = conn;
                        OracleDataReader dr = command.ExecuteReader();
                        dt.Load(dr);
                    }

                    foreach (DataRow row in dt.Rows)
                    {
                        localidad = row["localidad"].ToString();
                    }

                }
            }

            conn.Close();

            return localidad;
        }

        public void insertLog(model.LogError logError, string connectionString)
        {

            Thread.CurrentThread.CurrentCulture = new CultureInfo("es-ES");

            OracleConnection conn = util.Connection.connect(connectionString);

            conn.Open();

            OracleTransaction transaction;
            transaction = conn.BeginTransaction(IsolationLevel.ReadCommitted);

                OracleCommand cmd = conn.CreateCommand();
                cmd.Transaction = transaction;

                cmd.CommandText = "Insert into TRON2000.TA_VU_CARTA_LOG_ERR (NRO_ERROR, DESCRIP_ERROR, NOMBRE_ARCHIVO, COD_USR, FEC_REG)"

                + "VALUES (TRON2000.SEQ_VU_CARTA_LOG_ERR.nextval, :DESCRIP_ERROR, :NOMBRE_ARCHIVO, :COD_USR, :FEC_REG)";

                cmd.Parameters.Add(new OracleParameter("DESCRIP_ERROR", OracleDbType.Varchar2, logError.descripError, ParameterDirection.Input));
                cmd.Parameters.Add(new OracleParameter("NOMBRE_ARCHIVO", OracleDbType.Varchar2, logError.nombreArchivo, ParameterDirection.Input));
                cmd.Parameters.Add(new OracleParameter("COD_USR", OracleDbType.Varchar2, logError.codUsr, ParameterDirection.Input));
                cmd.Parameters.Add(new OracleParameter("FEC_REG", OracleDbType.TimeStamp, logError.fecReg, ParameterDirection.Input));

                cmd.ExecuteNonQuery();
            

            transaction.Commit();

            conn.Dispose();
        }

        public void updateProperty(model.Property property, string connectionString)
        {

            Thread.CurrentThread.CurrentCulture = new CultureInfo("es-ES");

            OracleConnection conn = util.Connection.connect(connectionString);

            conn.Open();

            OracleTransaction transaction;
            transaction = conn.BeginTransaction(IsolationLevel.ReadCommitted);

            OracleCommand cmd = conn.CreateCommand();
            cmd.Transaction = transaction;

            cmd.CommandText = "update tron2000.TA_VU_CARTA_PROPERTY set INDEX_PROPERTY = :INDEX_PROPERTY, NAME_PROPERTY = :NAME_PROPERTY,  TYPE_PROPERTY = :TYPE_PROPERTY, DATA_TYPE = :DATA_TYPE, FORMAT_DATE = :FORMAT_DATE, COD_USR = 'tron2000', FEC_ACTU = current_date"

            + " where NRO_PROPERTY = :NRO_PROPERTY";

            cmd.Parameters.Add(new OracleParameter("INDEX_PROPERTY", OracleDbType.Int32, property.index, ParameterDirection.Input));
            cmd.Parameters.Add(new OracleParameter("NAME_PROPERTY", OracleDbType.Varchar2, property.name, ParameterDirection.Input));
            cmd.Parameters.Add(new OracleParameter("TYPE_PROPERTY", OracleDbType.Int32, property.typeProperty, ParameterDirection.Input));
            cmd.Parameters.Add(new OracleParameter("DATA_TYPE", OracleDbType.Int32, property.dataType, ParameterDirection.Input));
            cmd.Parameters.Add(new OracleParameter("FORMAT_DATE", OracleDbType.Varchar2, property.formatDate, ParameterDirection.Input));
            cmd.Parameters.Add(new OracleParameter("NRO_PROPERTY", OracleDbType.Int32, property.nro_property, ParameterDirection.Input));

            cmd.ExecuteNonQuery();


            transaction.Commit();

            conn.Dispose();
        }

        public void updateTextLabel(model.TextLabel textLabel, string connectionString)
        {

            Thread.CurrentThread.CurrentCulture = new CultureInfo("es-ES");

            OracleConnection conn = util.Connection.connect(connectionString);

            conn.Open();

            OracleTransaction transaction;
            transaction = conn.BeginTransaction(IsolationLevel.ReadCommitted);

            OracleCommand cmd = conn.CreateCommand();
            cmd.Transaction = transaction;

            cmd.CommandText = "update tron2000.TA_VU_CARTA_TEXT_LABEL set TEXT_LABEL = :TEXT_LABEL, COD_USR = 'TRON2000', FEC_ACTU = current_date"

            + " where NRO_TEXT_LABEL = :NRO_TEXT_LABEL";

            cmd.Parameters.Add(new OracleParameter("TEXT_LABEL", OracleDbType.Varchar2, textLabel.text, ParameterDirection.Input));
            cmd.Parameters.Add(new OracleParameter("NRO_TEXT_LABEL", OracleDbType.Int32, textLabel.nro_text_label, ParameterDirection.Input));

            cmd.ExecuteNonQuery();


            transaction.Commit();

            conn.Dispose();
        }

        public List<model.Property> loadProperties(string connectionString)
        {
            List<model.Property> properties = new List<model.Property>();

            OracleConnection conn = util.Connection.connect(connectionString);
            conn.Open();

            OracleCommand command = new OracleCommand("select * from tron2000.TA_VU_CARTA_PROPERTY");
            command.Connection = conn;
            OracleDataReader dr = command.ExecuteReader(CommandBehavior.CloseConnection);
            DataTable dt = new DataTable();
            dt.Load(dr);

            foreach (DataRow row in dt.Rows)
            {
                model.Property property = new model.Property();

                property.nro_property = Convert.ToInt32(row["NRO_PROPERTY"].ToString());
                property.index = Convert.ToInt32(row["INDEX_PROPERTY"].ToString());
                property.name = row["NAME_PROPERTY"].ToString();
                property.typeProperty = Convert.ToInt32(row["TYPE_PROPERTY"].ToString());
                property.dataType = Convert.ToInt32(row["DATA_TYPE"].ToString());
                property.formatDate = row["FORMAT_DATE"].ToString();

                properties.Add(property);

            }

            return properties;
        }

        public List<model.TextLabel> loadTextLabels(string connectionString,bool replaceCharSpecial)
        {
            List<model.TextLabel> textLabels = new List<model.TextLabel>();

            OracleConnection conn = util.Connection.connect(connectionString);
            conn.Open();

            OracleCommand command = new OracleCommand("select * from tron2000.TA_VU_CARTA_TEXT_LABEL");
            command.Connection = conn;
            OracleDataReader dr = command.ExecuteReader(CommandBehavior.CloseConnection);
            DataTable dt = new DataTable();
            dt.Load(dr);

            foreach (DataRow row in dt.Rows)
            {
                model.TextLabel textLabel = new model.TextLabel();

                textLabel.nro_text_label = Convert.ToInt32(row["NRO_TEXT_LABEL"].ToString());

                if (replaceCharSpecial)
                {
                    textLabel.text = this.replaceCharacter(row["TEXT_LABEL"].ToString());
                }
                else {
                    textLabel.text = row["TEXT_LABEL"].ToString();
                }

                textLabels.Add(textLabel);

            }

            return textLabels;
        }

        public string replaceCharacter(string val) {

            string[] chars = { "[n]", "[a]", "[e]", "[i]", "[o]", "[u]" };
            string[] charReplaces = { "ñ", "á", "é", "í", "ó", "ú" };

            int index = 0;
            string newString = null;

            foreach ( string cad in chars){

                int pos = val.IndexOf(cad);

                if (pos >= 0) {
                    newString = val.Replace(cad,charReplaces[index]);
                    return newString;
                }

                index++;
            }

            return val;

        }

    }
}
