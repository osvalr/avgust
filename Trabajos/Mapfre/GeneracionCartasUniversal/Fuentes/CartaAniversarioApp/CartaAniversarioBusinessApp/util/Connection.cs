using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Oracle.DataAccess.Client;

namespace CartaAniversarioBusinessApp.util
{
    public class Connection
    {
        public static OracleConnection connect(string connectionString) {

            OracleConnection conn = new OracleConnection(connectionString);

            return conn;
        }

    }
}
