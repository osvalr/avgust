using Npgsql;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InaviWinApp.util
{
    public class InaviConnection
    {
        private string connstring = System.Configuration.ConfigurationManager.ConnectionStrings["pgsql"].ConnectionString;
        //private string connstring = String.Format("Server=127.0.0.1;Port=5432;Database=bd_acme;User Id=postgres;Password=1234;");
        NpgsqlConnection conn = null;

        public void open() {
            conn = new NpgsqlConnection(connstring);
            conn.Open();
        }

        public NpgsqlConnection getConnection()
        {
            if (conn == null)
            {
                this.open();
            }
            else if(this.conn.State == System.Data.ConnectionState.Closed){
                conn.Open();
            }

            return conn;
        }
    }
}
