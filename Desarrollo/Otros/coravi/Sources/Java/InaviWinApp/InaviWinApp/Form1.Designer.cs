namespace InaviWinApp
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.btn_imprimir_todos = new System.Windows.Forms.Button();
            this.btn_imprimir = new System.Windows.Forms.Button();
            this.btn_consultar = new System.Windows.Forms.Button();
            this.txt_dia = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.txt_mes = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.txt_anio = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.cbo_cliente = new System.Windows.Forms.ComboBox();
            this.label1 = new System.Windows.Forms.Label();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.dgv_guias = new System.Windows.Forms.DataGridView();
            this.groupBox3 = new System.Windows.Forms.GroupBox();
            this.dgv_detalle_guias = new System.Windows.Forms.DataGridView();
            this.groupBox1.SuspendLayout();
            this.groupBox2.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgv_guias)).BeginInit();
            this.groupBox3.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgv_detalle_guias)).BeginInit();
            this.SuspendLayout();
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.btn_imprimir_todos);
            this.groupBox1.Controls.Add(this.btn_imprimir);
            this.groupBox1.Controls.Add(this.btn_consultar);
            this.groupBox1.Controls.Add(this.txt_dia);
            this.groupBox1.Controls.Add(this.label4);
            this.groupBox1.Controls.Add(this.txt_mes);
            this.groupBox1.Controls.Add(this.label3);
            this.groupBox1.Controls.Add(this.txt_anio);
            this.groupBox1.Controls.Add(this.label2);
            this.groupBox1.Controls.Add(this.cbo_cliente);
            this.groupBox1.Controls.Add(this.label1);
            this.groupBox1.Location = new System.Drawing.Point(12, 12);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(817, 82);
            this.groupBox1.TabIndex = 0;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Filtros";
            // 
            // btn_imprimir_todos
            // 
            this.btn_imprimir_todos.Image = ((System.Drawing.Image)(resources.GetObject("btn_imprimir_todos.Image")));
            this.btn_imprimir_todos.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.btn_imprimir_todos.Location = new System.Drawing.Point(634, 41);
            this.btn_imprimir_todos.Name = "btn_imprimir_todos";
            this.btn_imprimir_todos.Size = new System.Drawing.Size(103, 23);
            this.btn_imprimir_todos.TabIndex = 10;
            this.btn_imprimir_todos.Text = "Imprimir &Todos";
            this.btn_imprimir_todos.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.btn_imprimir_todos.UseVisualStyleBackColor = true;
            this.btn_imprimir_todos.Click += new System.EventHandler(this.btn_imprimir_todos_Click);
            // 
            // btn_imprimir
            // 
            this.btn_imprimir.Image = ((System.Drawing.Image)(resources.GetObject("btn_imprimir.Image")));
            this.btn_imprimir.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.btn_imprimir.Location = new System.Drawing.Point(553, 41);
            this.btn_imprimir.Name = "btn_imprimir";
            this.btn_imprimir.Size = new System.Drawing.Size(75, 23);
            this.btn_imprimir.TabIndex = 9;
            this.btn_imprimir.Text = "&Imprimir";
            this.btn_imprimir.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.btn_imprimir.UseVisualStyleBackColor = true;
            this.btn_imprimir.Click += new System.EventHandler(this.btn_imprimir_Click);
            // 
            // btn_consultar
            // 
            this.btn_consultar.Image = ((System.Drawing.Image)(resources.GetObject("btn_consultar.Image")));
            this.btn_consultar.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.btn_consultar.Location = new System.Drawing.Point(472, 41);
            this.btn_consultar.Name = "btn_consultar";
            this.btn_consultar.Size = new System.Drawing.Size(75, 23);
            this.btn_consultar.TabIndex = 8;
            this.btn_consultar.Text = "&Consultar";
            this.btn_consultar.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.btn_consultar.UseVisualStyleBackColor = true;
            this.btn_consultar.Click += new System.EventHandler(this.btn_consultar_Click);
            // 
            // txt_dia
            // 
            this.txt_dia.Location = new System.Drawing.Point(408, 42);
            this.txt_dia.Name = "txt_dia";
            this.txt_dia.Size = new System.Drawing.Size(58, 20);
            this.txt_dia.TabIndex = 7;
            this.txt_dia.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.txt_dia_KeyPress);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(405, 24);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(23, 13);
            this.label4.TabIndex = 6;
            this.label4.Text = "Dia";
            // 
            // txt_mes
            // 
            this.txt_mes.Location = new System.Drawing.Point(344, 43);
            this.txt_mes.Name = "txt_mes";
            this.txt_mes.Size = new System.Drawing.Size(58, 20);
            this.txt_mes.TabIndex = 5;
            this.txt_mes.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.txt_mes_KeyPress);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(341, 25);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(27, 13);
            this.label3.TabIndex = 4;
            this.label3.Text = "Mes";
            // 
            // txt_anio
            // 
            this.txt_anio.Location = new System.Drawing.Point(280, 44);
            this.txt_anio.Name = "txt_anio";
            this.txt_anio.Size = new System.Drawing.Size(58, 20);
            this.txt_anio.TabIndex = 3;
            this.txt_anio.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.txt_anio_KeyPress);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(277, 26);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(29, 13);
            this.label2.TabIndex = 2;
            this.label2.Text = "Año:";
            // 
            // cbo_cliente
            // 
            this.cbo_cliente.FormattingEnabled = true;
            this.cbo_cliente.Location = new System.Drawing.Point(6, 44);
            this.cbo_cliente.Name = "cbo_cliente";
            this.cbo_cliente.Size = new System.Drawing.Size(268, 21);
            this.cbo_cliente.TabIndex = 1;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(3, 28);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(42, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Cliente:";
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.dgv_guias);
            this.groupBox2.Location = new System.Drawing.Point(12, 100);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(817, 211);
            this.groupBox2.TabIndex = 1;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "Guia";
            this.groupBox2.Enter += new System.EventHandler(this.groupBox2_Enter);
            // 
            // dgv_guias
            // 
            this.dgv_guias.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgv_guias.EditMode = System.Windows.Forms.DataGridViewEditMode.EditProgrammatically;
            this.dgv_guias.Location = new System.Drawing.Point(7, 19);
            this.dgv_guias.MultiSelect = false;
            this.dgv_guias.Name = "dgv_guias";
            this.dgv_guias.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dgv_guias.Size = new System.Drawing.Size(804, 186);
            this.dgv_guias.TabIndex = 0;
            this.dgv_guias.CellDoubleClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dgv_guias_CellDoubleClick);
            // 
            // groupBox3
            // 
            this.groupBox3.Controls.Add(this.dgv_detalle_guias);
            this.groupBox3.Location = new System.Drawing.Point(13, 317);
            this.groupBox3.Name = "groupBox3";
            this.groupBox3.Size = new System.Drawing.Size(816, 218);
            this.groupBox3.TabIndex = 2;
            this.groupBox3.TabStop = false;
            this.groupBox3.Text = "Detalle Guia";
            // 
            // dgv_detalle_guias
            // 
            this.dgv_detalle_guias.AllowUserToAddRows = false;
            this.dgv_detalle_guias.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgv_detalle_guias.EditMode = System.Windows.Forms.DataGridViewEditMode.EditProgrammatically;
            this.dgv_detalle_guias.Location = new System.Drawing.Point(6, 19);
            this.dgv_detalle_guias.Name = "dgv_detalle_guias";
            this.dgv_detalle_guias.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dgv_detalle_guias.Size = new System.Drawing.Size(804, 183);
            this.dgv_detalle_guias.TabIndex = 1;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(841, 547);
            this.Controls.Add(this.groupBox3);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.groupBox1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MaximizeBox = false;
            this.Name = "Form1";
            this.Text = "Modulo de Consultas e Impresiones - InaviApp v1.0";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.groupBox2.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.dgv_guias)).EndInit();
            this.groupBox3.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.dgv_detalle_guias)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.ComboBox cbo_cliente;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button btn_imprimir;
        private System.Windows.Forms.Button btn_consultar;
        private System.Windows.Forms.TextBox txt_dia;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox txt_mes;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox txt_anio;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.DataGridView dgv_guias;
        private System.Windows.Forms.GroupBox groupBox3;
        private System.Windows.Forms.DataGridView dgv_detalle_guias;
        private System.Windows.Forms.Button btn_imprimir_todos;
    }
}

