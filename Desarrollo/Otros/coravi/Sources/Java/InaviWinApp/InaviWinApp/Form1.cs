using Npgsql;
using System;
using System.Data;
using System.IO;
using System.Reflection;
using System.Windows.Forms;
using InaviWinApp.util;
using CrearTicketVenta;

namespace InaviWinApp
{
    public partial class Form1 : Form
    {

        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

            try
            {
                DataSet ds = new DataSet();
                DataTable dt = new DataTable();

                string path = Path.Combine(Path.GetDirectoryName(Assembly.GetExecutingAssembly().Location), @"sql\clientes.sql");
                string sql = File.ReadAllText(@path);

                InaviConnection inaviConnection = new InaviConnection();

                NpgsqlDataAdapter da = new NpgsqlDataAdapter(sql, inaviConnection.getConnection());
                ds.Reset();
                da.Fill(ds);
                dt = ds.Tables[0];

                DataRow dr = dt.NewRow();

                dr["id_persona"] = -1;
                dr["nombres"] = "Todos";

                dt.Rows.InsertAt(dr, 0);

                cbo_cliente.DataSource = dt;
                cbo_cliente.DisplayMember = "nombres";
                cbo_cliente.ValueMember = "id_persona";
                cbo_cliente.DropDownStyle = ComboBoxStyle.DropDownList;
                cbo_cliente.SelectedIndex = 0;

                txt_anio.Text = Convert.ToString(DateTime.Now.Year);
                txt_mes.Text = Convert.ToString(DateTime.Now.Month);
                txt_dia.Text = Convert.ToString(DateTime.Now.Day);

                consultar();
            }
            catch (Exception ex) {
                MessageBox.Show(ex.StackTrace.ToString());
            }

        }


        public void consultar()
        {

            DataTable dt = new DataTable();

            string path = Path.Combine(Path.GetDirectoryName(Assembly.GetExecutingAssembly().Location), @"sql\guias.sql");
            string sql = File.ReadAllText(@path);

            InaviConnection inaviConnection = new InaviConnection();

            using (NpgsqlCommand command = new NpgsqlCommand(sql, inaviConnection.getConnection()))
            {

                int? num_anio = null;
                int? num_mes = null;
                int? num_dia = null;
                int? id_cliente = null;

                if (txt_anio.Text != String.Empty)
                {
                    num_anio = Convert.ToInt32((txt_anio.Text));
                }

                if (txt_mes.Text != String.Empty)
                {
                    num_mes = Convert.ToInt32((txt_mes.Text));
                }

                if (txt_dia.Text != String.Empty)
                {
                    num_dia = Convert.ToInt32((txt_dia.Text));
                }

                id_cliente = Convert.ToInt32(cbo_cliente.SelectedValue.ToString());

                if (id_cliente == -1) {
                    id_cliente = null;
                }

                {
                    NpgsqlParameter npgsqlParameter = new NpgsqlParameter("num_anio", (object)num_anio ?? DBNull.Value);
                    npgsqlParameter.IsNullable = true;
                    npgsqlParameter.DbType = DbType.Int32;
                    command.Parameters.Add(npgsqlParameter);
                }

                {
                    NpgsqlParameter npgsqlParameter = new NpgsqlParameter("num_mes", (object)num_mes ?? DBNull.Value);
                    npgsqlParameter.IsNullable = true;
                    npgsqlParameter.DbType = DbType.Int32;
                    command.Parameters.Add(npgsqlParameter);
                }

                {
                    NpgsqlParameter npgsqlParameter = new NpgsqlParameter("num_dia", (object)num_dia ?? DBNull.Value);
                    npgsqlParameter.IsNullable = true;
                    npgsqlParameter.DbType = DbType.Int32;
                    command.Parameters.Add(npgsqlParameter);
                }

                {
                    NpgsqlParameter npgsqlParameter = new NpgsqlParameter("id_cliente", (object)id_cliente ?? DBNull.Value);
                    npgsqlParameter.IsNullable = true;
                    npgsqlParameter.DbType = DbType.Int32;
                    command.Parameters.Add(npgsqlParameter);
                }

                NpgsqlDataReader reader = command.ExecuteReader();
                dt.Load(reader);

                dgv_guias.AutoGenerateColumns = true;
                dgv_guias.AllowUserToAddRows = false;
                dgv_guias.DataSource = dt;
                dgv_guias.Refresh();

            }

        }

        private void btn_consultar_Click(object sender, EventArgs e)
        {
            try
            {
                consultar();
                dgv_detalle_guias.DataSource = null;
                dgv_detalle_guias.Refresh();
            }
            catch(Exception ex)
            {
                MessageBox.Show(ex.Message);
            }

        }

        private void txt_anio_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (!char.IsControl(e.KeyChar) && !char.IsDigit(e.KeyChar) && (e.KeyChar != '.'))
            {
                e.Handled = true;
            }

            // only allow one decimal point
            if ((e.KeyChar == '.') && ((sender as TextBox).Text.IndexOf('.') > -1))
            {
                e.Handled = true;
            }
        }

        private void txt_mes_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (!char.IsControl(e.KeyChar) && !char.IsDigit(e.KeyChar) && (e.KeyChar != '.'))
            {
                e.Handled = true;
            }

            // only allow one decimal point
            if ((e.KeyChar == '.') && ((sender as TextBox).Text.IndexOf('.') > -1))
            {
                e.Handled = true;
            }
        }

        private void txt_dia_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (!char.IsControl(e.KeyChar) && !char.IsDigit(e.KeyChar) && (e.KeyChar != '.'))
            {
                e.Handled = true;
            }

            // only allow one decimal point
            if ((e.KeyChar == '.') && ((sender as TextBox).Text.IndexOf('.') > -1))
            {
                e.Handled = true;
            }
        }

        private void dgv_guias_CellDoubleClick(object sender, DataGridViewCellEventArgs e)
        {
            foreach (DataGridViewRow row in dgv_guias.SelectedRows)
            {
                string value1 = row.Cells[0].Value.ToString();
                DataTable dt = new DataTable();

                string path = Path.Combine(Path.GetDirectoryName(Assembly.GetExecutingAssembly().Location), @"sql\detalle_guia.sql");
                string sql = File.ReadAllText(@path);

                InaviConnection inaviConnection = new InaviConnection();

                using (NpgsqlCommand command = new NpgsqlCommand(sql, inaviConnection.getConnection()))
                {

                    int id_guia = Convert.ToInt32(value1);

                    {
                        NpgsqlParameter npgsqlParameter = new NpgsqlParameter("id_guia", id_guia);
                        npgsqlParameter.IsNullable = true;
                        npgsqlParameter.DbType = DbType.Int32;
                        command.Parameters.Add(npgsqlParameter);
                    }

                    NpgsqlDataReader reader = command.ExecuteReader();
                    dt.Load(reader);

                    dgv_detalle_guias.AutoGenerateColumns = true;
                    dgv_detalle_guias.AllowUserToAddRows = false;
                    dgv_detalle_guias.DataSource = dt;
                    dgv_detalle_guias.Refresh();
                }
            }
        }

        private void imprimir(DataGridViewRow row)
        {

            /*******************************************/
            string id_guia = row.Cells[0].Value.ToString();
            string nombre_cliente = row.Cells["nombre_cliente"].Value.ToString();
            string fecha_jornada = row.Cells["fecha_jornada"].Value.ToString();
            string descrip_tipo_producto = row.Cells["descrip_tipo_producto"].Value.ToString();

            int cant_aves_bruto = Convert.ToInt32(row.Cells["cant_aves_bruto"].Value.ToString());

            int cant_aves_devolucion = Convert.ToInt32(row.Cells["cant_aves_devolucion"].Value.ToString());

            decimal total_peso_bruto = Convert.ToDecimal(row.Cells["total_peso_bruto"].Value.ToString());

            decimal total_peso_tara = Convert.ToDecimal(row.Cells["total_peso_tara"].Value.ToString());

            decimal total_peso_devolucion = Convert.ToDecimal(row.Cells["total_peso_devolucion"].Value.ToString());

            decimal total_peso_neto = Convert.ToDecimal(row.Cells["total_peso_neto"].Value.ToString());

            decimal total_importe = Convert.ToDecimal(row.Cells["total_importe"].Value.ToString());
            /*******************************************/

            //Creamos una instancia d ela clase CrearTicket
            CrearTicket ticket = new CrearTicket();
            //Ya podemos usar todos sus metodos
            ticket.AbreCajon();//Para abrir el cajon de dinero.

            //De aqui en adelante pueden formar su ticket a su gusto... Les muestro un ejemplo

            //Datos de la cabecera del Ticket.
            ticket.TextoCentro("INAVI");
            ticket.TextoCentro("INVERSIONES AVICOLA LA IQUENA S.A.C.");
            ticket.TextoCentro("AV. MAURTUA NRO. 230 ICA - ICA - ICA.");
            ticket.TextoCentro("RUC: 20534269308");
            ticket.TextoIzquierda("");
            ticket.TextoCentro("HOJA DE PESADA");
            ticket.TextoIzquierda("");
            ticket.lineasAsteriscos();

            //Sub cabecera.
            ticket.TextoIzquierda("");
            ticket.TextoIzquierda("CLIENTE: " + nombre_cliente);
            ticket.TextoIzquierda("PRODUCTO: " + descrip_tipo_producto);
            ticket.TextoIzquierda("FECHA PROCESO: " + fecha_jornada);
            ticket.TextoIzquierda("");
            ticket.TextoExtremos("FECHA: " + DateTime.Now.ToShortDateString(), "HORA: " + DateTime.Now.ToShortTimeString());
            ticket.lineasAsteriscos();

            //Articulos a vender.
            ticket.EncabezadoVenta();//NOMBRE DEL ARTICULO, CANT, PRECIO, IMPORTE
            ticket.lineasAsteriscos();

            ////////////////////////////////

            DataTable dt = new DataTable();

            string path = Path.Combine(Path.GetDirectoryName(Assembly.GetExecutingAssembly().Location), @"sql\detalle_guia.sql");
            string sql = File.ReadAllText(@path);

            InaviConnection inaviConnection = new InaviConnection();

            using (NpgsqlCommand command = new NpgsqlCommand(sql, inaviConnection.getConnection()))
            {

                int int_id_guia = Convert.ToInt32(id_guia);

                {
                    NpgsqlParameter npgsqlParameter = new NpgsqlParameter("id_guia", int_id_guia);
                    npgsqlParameter.IsNullable = true;
                    npgsqlParameter.DbType = DbType.Int32;
                    command.Parameters.Add(npgsqlParameter);
                }

                NpgsqlDataReader reader = command.ExecuteReader();
                while (reader.Read())
                {
                    string tipoPeso = reader.GetString(0).ToUpper();
                    tipoPeso = tipoPeso.Replace("Ó", "O");
                    ticket.AgregaArticulo(tipoPeso, reader.GetInt32(1), reader.GetInt32(2), reader.GetDecimal(3));
                }
            }

            ////////////////////////////////


            ticket.TextoIzquierda("");
            ticket.lineasIgual();
            ticket.TextoCentro("TOTALES");
            ticket.lineasIgual();

            ticket.AgregarTotales("      AVES......................", cant_aves_bruto);
            ticket.AgregarTotales("      AVES DEVOLUCION...........", cant_aves_devolucion);//La M indica que es un decimal en C#
            ticket.AgregarTotales("      P. BRUTO..................", total_peso_bruto);
            ticket.AgregarTotales("      P. TARA...................", total_peso_tara);
            ticket.AgregarTotales("      P. DEVOLUCION.............", total_peso_devolucion);
            ticket.AgregarTotales("      P. NETO...................", total_peso_neto);
            ticket.AgregarTotales("      IMPORTE TOTAL...........S/", total_importe);
            ticket.TextoIzquierda("");


            ticket.CortaTicket();

            string namePrint = System.Configuration.ConfigurationManager.AppSettings["namePrint"];

            ticket.ImprimirTicket(namePrint);//Nombre de la impresora ticketera


        }

        private void btn_imprimir_Click(object sender, EventArgs e)
        {
            foreach (DataGridViewRow row in dgv_guias.SelectedRows)
            {
                imprimir(row);
            }

        }

        private void btn_imprimir_todos_Click(object sender, EventArgs e)
        {
            foreach (DataGridViewRow row in dgv_guias.Rows)
            {
                imprimir(row);
            }
        }

        private void groupBox2_Enter(object sender, EventArgs e)
        {

        }
    }

}
