namespace WindowsFormsApplication1
{
    partial class MainForm
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
            this.lblLoadXML = new System.Windows.Forms.Label();
            this.txtXmlFile = new System.Windows.Forms.TextBox();
            this.btnBrowseXml = new System.Windows.Forms.Button();
            this.lblCert = new System.Windows.Forms.Label();
            this.txtCert = new System.Windows.Forms.TextBox();
            this.btnBrowseCert = new System.Windows.Forms.Button();
            this.lblCertPass = new System.Windows.Forms.Label();
            this.txtCertPass = new System.Windows.Forms.TextBox();
            this.btnBrowseKeyCert = new System.Windows.Forms.Button();
            this.txtKeyCert = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.txtKeyCertPassword = new System.Windows.Forms.TextBox();
            this.lblKeyEncryptionCertPassword = new System.Windows.Forms.Label();
            this.btnSignXML = new System.Windows.Forms.Button();
            this.btnBrowseNotificationZip = new System.Windows.Forms.Button();
            this.txtNotificationZip = new System.Windows.Forms.TextBox();
            this.lblZipFile = new System.Windows.Forms.Label();
            this.btnBrowseRecCert = new System.Windows.Forms.Button();
            this.txtReceiverCert = new System.Windows.Forms.TextBox();
            this.lblReceiverCert = new System.Windows.Forms.Label();
            this.txtRecKeyPassword = new System.Windows.Forms.TextBox();
            this.lblRecPass = new System.Windows.Forms.Label();
            this.btnDecryptZip = new System.Windows.Forms.Button();
            this.txtSenderCode = new System.Windows.Forms.TextBox();
            this.lblSender = new System.Windows.Forms.Label();
            this.txtReceiverCode = new System.Windows.Forms.TextBox();
            this.lblReceiver = new System.Windows.Forms.Label();
            this.btnBrowseOutput = new System.Windows.Forms.Button();
            this.txtNotificationFolder = new System.Windows.Forms.TextBox();
            this.lblOutput = new System.Windows.Forms.Label();
            this.dlgOpen = new System.Windows.Forms.OpenFileDialog();
            this.dlgSave = new System.Windows.Forms.SaveFileDialog();
            this.dlgOpenFolder = new System.Windows.Forms.FolderBrowserDialog();
            this.chkM1O2 = new System.Windows.Forms.CheckBox();
            this.btnBrowseHCTACert = new System.Windows.Forms.Button();
            this.txtHCTACert = new System.Windows.Forms.TextBox();
            this.lblHCTAKey = new System.Windows.Forms.Label();
            this.txtHCTACertPassword = new System.Windows.Forms.TextBox();
            this.lblEncryptionHCTAPassword = new System.Windows.Forms.Label();
            this.txtHCTACode = new System.Windows.Forms.TextBox();
            this.lblHCTACode = new System.Windows.Forms.Label();
            this.txtFileNameZip = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.txtFileNameXml = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.txtPathResult = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.btnBrowserPathResult = new System.Windows.Forms.Button();
            this.folderBrowserDialog1 = new System.Windows.Forms.FolderBrowserDialog();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.groupBox1.SuspendLayout();
            this.groupBox2.SuspendLayout();
            this.SuspendLayout();
            // 
            // lblLoadXML
            // 
            this.lblLoadXML.AutoSize = true;
            this.lblLoadXML.Location = new System.Drawing.Point(16, 28);
            this.lblLoadXML.Name = "lblLoadXML";
            this.lblLoadXML.Size = new System.Drawing.Size(68, 13);
            this.lblLoadXML.TabIndex = 0;
            this.lblLoadXML.Text = "Archivo XML";
            // 
            // txtXmlFile
            // 
            this.txtXmlFile.Location = new System.Drawing.Point(16, 44);
            this.txtXmlFile.Name = "txtXmlFile";
            this.txtXmlFile.Size = new System.Drawing.Size(173, 20);
            this.txtXmlFile.TabIndex = 1;
            // 
            // btnBrowseXml
            // 
            this.btnBrowseXml.Font = new System.Drawing.Font("Tahoma", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnBrowseXml.Location = new System.Drawing.Point(198, 42);
            this.btnBrowseXml.Name = "btnBrowseXml";
            this.btnBrowseXml.Size = new System.Drawing.Size(28, 23);
            this.btnBrowseXml.TabIndex = 2;
            this.btnBrowseXml.Text = "...";
            this.btnBrowseXml.UseVisualStyleBackColor = true;
            this.btnBrowseXml.Click += new System.EventHandler(this.btnBrowseXml_Click);
            // 
            // lblCert
            // 
            this.lblCert.AutoSize = true;
            this.lblCert.Location = new System.Drawing.Point(16, 79);
            this.lblCert.Name = "lblCert";
            this.lblCert.Size = new System.Drawing.Size(239, 13);
            this.lblCert.TabIndex = 3;
            this.lblCert.Text = "Certificado de firma ( clave privada del remitente )";
            // 
            // txtCert
            // 
            this.txtCert.Location = new System.Drawing.Point(16, 95);
            this.txtCert.Name = "txtCert";
            this.txtCert.Size = new System.Drawing.Size(173, 20);
            this.txtCert.TabIndex = 4;
            // 
            // btnBrowseCert
            // 
            this.btnBrowseCert.Font = new System.Drawing.Font("Tahoma", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnBrowseCert.Location = new System.Drawing.Point(198, 95);
            this.btnBrowseCert.Name = "btnBrowseCert";
            this.btnBrowseCert.Size = new System.Drawing.Size(28, 23);
            this.btnBrowseCert.TabIndex = 5;
            this.btnBrowseCert.Text = "...";
            this.btnBrowseCert.UseVisualStyleBackColor = true;
            this.btnBrowseCert.Click += new System.EventHandler(this.btnBrowseCert_Click);
            // 
            // lblCertPass
            // 
            this.lblCertPass.AutoSize = true;
            this.lblCertPass.Location = new System.Drawing.Point(16, 122);
            this.lblCertPass.Name = "lblCertPass";
            this.lblCertPass.Size = new System.Drawing.Size(171, 13);
            this.lblCertPass.TabIndex = 6;
            this.lblCertPass.Text = "Contraseña del Certificado de firma";
            // 
            // txtCertPass
            // 
            this.txtCertPass.Location = new System.Drawing.Point(16, 138);
            this.txtCertPass.Name = "txtCertPass";
            this.txtCertPass.PasswordChar = '*';
            this.txtCertPass.Size = new System.Drawing.Size(173, 20);
            this.txtCertPass.TabIndex = 7;
            // 
            // btnBrowseKeyCert
            // 
            this.btnBrowseKeyCert.Font = new System.Drawing.Font("Tahoma", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnBrowseKeyCert.Location = new System.Drawing.Point(198, 182);
            this.btnBrowseKeyCert.Name = "btnBrowseKeyCert";
            this.btnBrowseKeyCert.Size = new System.Drawing.Size(28, 23);
            this.btnBrowseKeyCert.TabIndex = 10;
            this.btnBrowseKeyCert.Text = "...";
            this.btnBrowseKeyCert.UseVisualStyleBackColor = true;
            this.btnBrowseKeyCert.Click += new System.EventHandler(this.btnBrowseKeyCert_Click);
            // 
            // txtKeyCert
            // 
            this.txtKeyCert.Location = new System.Drawing.Point(16, 182);
            this.txtKeyCert.Name = "txtKeyCert";
            this.txtKeyCert.Size = new System.Drawing.Size(173, 20);
            this.txtKeyCert.TabIndex = 9;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(16, 166);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(238, 13);
            this.label3.TabIndex = 8;
            this.label3.Text = "Certificado Cifrado ( la clave pública del receptor)";
            // 
            // txtKeyCertPassword
            // 
            this.txtKeyCertPassword.Location = new System.Drawing.Point(16, 228);
            this.txtKeyCertPassword.Name = "txtKeyCertPassword";
            this.txtKeyCertPassword.Size = new System.Drawing.Size(173, 20);
            this.txtKeyCertPassword.TabIndex = 12;
            // 
            // lblKeyEncryptionCertPassword
            // 
            this.lblKeyEncryptionCertPassword.AutoSize = true;
            this.lblKeyEncryptionCertPassword.Location = new System.Drawing.Point(16, 212);
            this.lblKeyEncryptionCertPassword.Name = "lblKeyEncryptionCertPassword";
            this.lblKeyEncryptionCertPassword.Size = new System.Drawing.Size(249, 13);
            this.lblKeyEncryptionCertPassword.TabIndex = 11;
            this.lblKeyEncryptionCertPassword.Text = "Contraseña del Certificado Cifrado ( si es necesario)";
            // 
            // btnSignXML
            // 
            this.btnSignXML.Location = new System.Drawing.Point(16, 388);
            this.btnSignXML.Name = "btnSignXML";
            this.btnSignXML.Size = new System.Drawing.Size(173, 23);
            this.btnSignXML.TabIndex = 13;
            this.btnSignXML.Text = "Firmar y cifrar XML";
            this.btnSignXML.UseVisualStyleBackColor = true;
            this.btnSignXML.Click += new System.EventHandler(this.btnSignXML_Click);
            // 
            // btnBrowseNotificationZip
            // 
            this.btnBrowseNotificationZip.Font = new System.Drawing.Font("Tahoma", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnBrowseNotificationZip.Location = new System.Drawing.Point(199, 43);
            this.btnBrowseNotificationZip.Name = "btnBrowseNotificationZip";
            this.btnBrowseNotificationZip.Size = new System.Drawing.Size(30, 23);
            this.btnBrowseNotificationZip.TabIndex = 16;
            this.btnBrowseNotificationZip.Text = "...";
            this.btnBrowseNotificationZip.UseVisualStyleBackColor = true;
            this.btnBrowseNotificationZip.Click += new System.EventHandler(this.btnBrowseNotificationZip_Click);
            // 
            // txtNotificationZip
            // 
            this.txtNotificationZip.Location = new System.Drawing.Point(17, 45);
            this.txtNotificationZip.Name = "txtNotificationZip";
            this.txtNotificationZip.Size = new System.Drawing.Size(173, 20);
            this.txtNotificationZip.TabIndex = 15;
            // 
            // lblZipFile
            // 
            this.lblZipFile.AutoSize = true;
            this.lblZipFile.Location = new System.Drawing.Point(17, 29);
            this.lblZipFile.Name = "lblZipFile";
            this.lblZipFile.Size = new System.Drawing.Size(63, 13);
            this.lblZipFile.TabIndex = 14;
            this.lblZipFile.Text = "Archivo ZIP";
            // 
            // btnBrowseRecCert
            // 
            this.btnBrowseRecCert.Font = new System.Drawing.Font("Tahoma", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnBrowseRecCert.Location = new System.Drawing.Point(199, 93);
            this.btnBrowseRecCert.Name = "btnBrowseRecCert";
            this.btnBrowseRecCert.Size = new System.Drawing.Size(30, 23);
            this.btnBrowseRecCert.TabIndex = 19;
            this.btnBrowseRecCert.Text = "...";
            this.btnBrowseRecCert.UseVisualStyleBackColor = true;
            this.btnBrowseRecCert.Click += new System.EventHandler(this.btnBrowseRecCert_Click);
            // 
            // txtReceiverCert
            // 
            this.txtReceiverCert.Location = new System.Drawing.Point(17, 95);
            this.txtReceiverCert.Name = "txtReceiverCert";
            this.txtReceiverCert.Size = new System.Drawing.Size(173, 20);
            this.txtReceiverCert.TabIndex = 18;
            // 
            // lblReceiverCert
            // 
            this.lblReceiverCert.AutoSize = true;
            this.lblReceiverCert.Location = new System.Drawing.Point(20, 79);
            this.lblReceiverCert.Name = "lblReceiverCert";
            this.lblReceiverCert.Size = new System.Drawing.Size(230, 13);
            this.lblReceiverCert.TabIndex = 17;
            this.lblReceiverCert.Text = "Certificado del receptor (receptor llave privada )";
            // 
            // txtRecKeyPassword
            // 
            this.txtRecKeyPassword.Location = new System.Drawing.Point(17, 138);
            this.txtRecKeyPassword.Name = "txtRecKeyPassword";
            this.txtRecKeyPassword.PasswordChar = '*';
            this.txtRecKeyPassword.Size = new System.Drawing.Size(173, 20);
            this.txtRecKeyPassword.TabIndex = 21;
            // 
            // lblRecPass
            // 
            this.lblRecPass.AutoSize = true;
            this.lblRecPass.Location = new System.Drawing.Point(20, 122);
            this.lblRecPass.Name = "lblRecPass";
            this.lblRecPass.Size = new System.Drawing.Size(213, 13);
            this.lblRecPass.TabIndex = 20;
            this.lblRecPass.Text = "Contraseña del Certificado ( si es necesario)";
            // 
            // btnDecryptZip
            // 
            this.btnDecryptZip.Location = new System.Drawing.Point(17, 182);
            this.btnDecryptZip.Name = "btnDecryptZip";
            this.btnDecryptZip.Size = new System.Drawing.Size(173, 23);
            this.btnDecryptZip.TabIndex = 22;
            this.btnDecryptZip.Text = "Descifrar Notificación\r\n";
            this.btnDecryptZip.UseVisualStyleBackColor = true;
            this.btnDecryptZip.Click += new System.EventHandler(this.btnDecryptZip_Click);
            // 
            // txtSenderCode
            // 
            this.txtSenderCode.Location = new System.Drawing.Point(17, 256);
            this.txtSenderCode.Name = "txtSenderCode";
            this.txtSenderCode.Size = new System.Drawing.Size(69, 20);
            this.txtSenderCode.TabIndex = 24;
            // 
            // lblSender
            // 
            this.lblSender.AutoSize = true;
            this.lblSender.Location = new System.Drawing.Point(17, 240);
            this.lblSender.Name = "lblSender";
            this.lblSender.Size = new System.Drawing.Size(103, 13);
            this.lblSender.TabIndex = 23;
            this.lblSender.Text = "Código del remitente";
            // 
            // txtReceiverCode
            // 
            this.txtReceiverCode.Location = new System.Drawing.Point(120, 256);
            this.txtReceiverCode.Name = "txtReceiverCode";
            this.txtReceiverCode.Size = new System.Drawing.Size(78, 20);
            this.txtReceiverCode.TabIndex = 26;
            // 
            // lblReceiver
            // 
            this.lblReceiver.AutoSize = true;
            this.lblReceiver.Location = new System.Drawing.Point(120, 240);
            this.lblReceiver.Name = "lblReceiver";
            this.lblReceiver.Size = new System.Drawing.Size(82, 13);
            this.lblReceiver.TabIndex = 25;
            this.lblReceiver.Text = "Código receptor\r\n";
            // 
            // btnBrowseOutput
            // 
            this.btnBrowseOutput.Font = new System.Drawing.Font("Tahoma", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnBrowseOutput.Location = new System.Drawing.Point(199, 302);
            this.btnBrowseOutput.Name = "btnBrowseOutput";
            this.btnBrowseOutput.Size = new System.Drawing.Size(29, 23);
            this.btnBrowseOutput.TabIndex = 29;
            this.btnBrowseOutput.Text = "...";
            this.btnBrowseOutput.UseVisualStyleBackColor = true;
            this.btnBrowseOutput.Click += new System.EventHandler(this.btnBrowseOutput_Click);
            // 
            // txtNotificationFolder
            // 
            this.txtNotificationFolder.Location = new System.Drawing.Point(17, 302);
            this.txtNotificationFolder.Name = "txtNotificationFolder";
            this.txtNotificationFolder.Size = new System.Drawing.Size(173, 20);
            this.txtNotificationFolder.TabIndex = 28;
            // 
            // lblOutput
            // 
            this.lblOutput.AutoSize = true;
            this.lblOutput.Location = new System.Drawing.Point(17, 286);
            this.lblOutput.Name = "lblOutput";
            this.lblOutput.Size = new System.Drawing.Size(183, 13);
            this.lblOutput.TabIndex = 27;
            this.lblOutput.Text = "Carpeta de salida para la Notificación";
            // 
            // dlgOpen
            // 
            this.dlgOpen.Title = "Open File";
            // 
            // dlgSave
            // 
            this.dlgSave.Filter = "XML Files (*.xml)|*.xml";
            this.dlgSave.Title = "Save File";
            // 
            // dlgOpenFolder
            // 
            this.dlgOpenFolder.RootFolder = System.Environment.SpecialFolder.MyComputer;
            // 
            // chkM1O2
            // 
            this.chkM1O2.AutoSize = true;
            this.chkM1O2.Location = new System.Drawing.Point(338, 19);
            this.chkM1O2.Name = "chkM1O2";
            this.chkM1O2.Size = new System.Drawing.Size(116, 17);
            this.chkM1O2.TabIndex = 30;
            this.chkM1O2.Text = "Modelo 1 Opción 2";
            this.chkM1O2.UseVisualStyleBackColor = true;
            this.chkM1O2.CheckedChanged += new System.EventHandler(this.chkM1O2_CheckedChanged);
            // 
            // btnBrowseHCTACert
            // 
            this.btnBrowseHCTACert.Font = new System.Drawing.Font("Tahoma", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnBrowseHCTACert.Location = new System.Drawing.Point(198, 452);
            this.btnBrowseHCTACert.Name = "btnBrowseHCTACert";
            this.btnBrowseHCTACert.Size = new System.Drawing.Size(28, 23);
            this.btnBrowseHCTACert.TabIndex = 33;
            this.btnBrowseHCTACert.Text = "...";
            this.btnBrowseHCTACert.UseVisualStyleBackColor = true;
            this.btnBrowseHCTACert.Visible = false;
            this.btnBrowseHCTACert.Click += new System.EventHandler(this.btnBrowseHCTACert_Click);
            // 
            // txtHCTACert
            // 
            this.txtHCTACert.Location = new System.Drawing.Point(16, 452);
            this.txtHCTACert.Name = "txtHCTACert";
            this.txtHCTACert.Size = new System.Drawing.Size(173, 20);
            this.txtHCTACert.TabIndex = 32;
            this.txtHCTACert.Visible = false;
            // 
            // lblHCTAKey
            // 
            this.lblHCTAKey.AutoSize = true;
            this.lblHCTAKey.Location = new System.Drawing.Point(16, 436);
            this.lblHCTAKey.Name = "lblHCTAKey";
            this.lblHCTAKey.Size = new System.Drawing.Size(248, 13);
            this.lblHCTAKey.TabIndex = 31;
            this.lblHCTAKey.Text = "Llave del certificado cifrado ( HCTA Llave Pública )";
            this.lblHCTAKey.Visible = false;
            // 
            // txtHCTACertPassword
            // 
            this.txtHCTACertPassword.Location = new System.Drawing.Point(16, 493);
            this.txtHCTACertPassword.Name = "txtHCTACertPassword";
            this.txtHCTACertPassword.Size = new System.Drawing.Size(173, 20);
            this.txtHCTACertPassword.TabIndex = 35;
            this.txtHCTACertPassword.Visible = false;
            // 
            // lblEncryptionHCTAPassword
            // 
            this.lblEncryptionHCTAPassword.AutoSize = true;
            this.lblEncryptionHCTAPassword.Location = new System.Drawing.Point(16, 477);
            this.lblEncryptionHCTAPassword.Name = "lblEncryptionHCTAPassword";
            this.lblEncryptionHCTAPassword.Size = new System.Drawing.Size(335, 13);
            this.lblEncryptionHCTAPassword.TabIndex = 34;
            this.lblEncryptionHCTAPassword.Text = "Contraseña de la Llave del Certificado cifrado HCTA ( si es necesario)";
            this.lblEncryptionHCTAPassword.Visible = false;
            // 
            // txtHCTACode
            // 
            this.txtHCTACode.Location = new System.Drawing.Point(16, 536);
            this.txtHCTACode.Name = "txtHCTACode";
            this.txtHCTACode.Size = new System.Drawing.Size(78, 20);
            this.txtHCTACode.TabIndex = 37;
            // 
            // lblHCTACode
            // 
            this.lblHCTACode.AutoSize = true;
            this.lblHCTACode.Location = new System.Drawing.Point(16, 517);
            this.lblHCTACode.Name = "lblHCTACode";
            this.lblHCTACode.Size = new System.Drawing.Size(72, 13);
            this.lblHCTACode.TabIndex = 36;
            this.lblHCTACode.Text = "Código HCTA";
            // 
            // txtFileNameZip
            // 
            this.txtFileNameZip.Location = new System.Drawing.Point(16, 270);
            this.txtFileNameZip.Name = "txtFileNameZip";
            this.txtFileNameZip.Size = new System.Drawing.Size(345, 20);
            this.txtFileNameZip.TabIndex = 39;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(16, 254);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(165, 13);
            this.label1.TabIndex = 38;
            this.label1.Text = "Nombre de archivo ZIP a generar";
            // 
            // txtFileNameXml
            // 
            this.txtFileNameXml.Location = new System.Drawing.Point(16, 314);
            this.txtFileNameXml.Name = "txtFileNameXml";
            this.txtFileNameXml.Size = new System.Drawing.Size(345, 20);
            this.txtFileNameXml.TabIndex = 41;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(16, 298);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(225, 13);
            this.label2.TabIndex = 40;
            this.label2.Text = "Nombre de archivo XML empaquetado en ZIP";
            // 
            // txtPathResult
            // 
            this.txtPathResult.Location = new System.Drawing.Point(16, 362);
            this.txtPathResult.Name = "txtPathResult";
            this.txtPathResult.Size = new System.Drawing.Size(345, 20);
            this.txtPathResult.TabIndex = 43;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(16, 346);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(234, 13);
            this.label4.TabIndex = 42;
            this.label4.Text = "Ruta donde se guardara los archivos generados";
            // 
            // btnBrowserPathResult
            // 
            this.btnBrowserPathResult.Font = new System.Drawing.Font("Tahoma", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnBrowserPathResult.Location = new System.Drawing.Point(367, 359);
            this.btnBrowserPathResult.Name = "btnBrowserPathResult";
            this.btnBrowserPathResult.Size = new System.Drawing.Size(28, 23);
            this.btnBrowserPathResult.TabIndex = 44;
            this.btnBrowserPathResult.Text = "...";
            this.btnBrowserPathResult.UseVisualStyleBackColor = true;
            this.btnBrowserPathResult.Click += new System.EventHandler(this.btnBrowserPathResult_Click);
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.txtRecKeyPassword);
            this.groupBox1.Controls.Add(this.lblZipFile);
            this.groupBox1.Controls.Add(this.txtNotificationZip);
            this.groupBox1.Controls.Add(this.btnBrowseNotificationZip);
            this.groupBox1.Controls.Add(this.lblReceiverCert);
            this.groupBox1.Controls.Add(this.txtReceiverCert);
            this.groupBox1.Controls.Add(this.btnBrowseRecCert);
            this.groupBox1.Controls.Add(this.lblRecPass);
            this.groupBox1.Controls.Add(this.btnDecryptZip);
            this.groupBox1.Controls.Add(this.lblSender);
            this.groupBox1.Controls.Add(this.txtSenderCode);
            this.groupBox1.Controls.Add(this.lblReceiver);
            this.groupBox1.Controls.Add(this.txtReceiverCode);
            this.groupBox1.Controls.Add(this.lblOutput);
            this.groupBox1.Controls.Add(this.txtNotificationFolder);
            this.groupBox1.Controls.Add(this.btnBrowseOutput);
            this.groupBox1.Location = new System.Drawing.Point(491, 18);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(306, 340);
            this.groupBox1.TabIndex = 45;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Otros Paises";
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.btnBrowserPathResult);
            this.groupBox2.Controls.Add(this.txtKeyCert);
            this.groupBox2.Controls.Add(this.txtPathResult);
            this.groupBox2.Controls.Add(this.lblLoadXML);
            this.groupBox2.Controls.Add(this.label4);
            this.groupBox2.Controls.Add(this.txtXmlFile);
            this.groupBox2.Controls.Add(this.txtFileNameXml);
            this.groupBox2.Controls.Add(this.btnBrowseXml);
            this.groupBox2.Controls.Add(this.label2);
            this.groupBox2.Controls.Add(this.lblCert);
            this.groupBox2.Controls.Add(this.txtFileNameZip);
            this.groupBox2.Controls.Add(this.txtCert);
            this.groupBox2.Controls.Add(this.label1);
            this.groupBox2.Controls.Add(this.btnBrowseCert);
            this.groupBox2.Controls.Add(this.txtHCTACode);
            this.groupBox2.Controls.Add(this.lblCertPass);
            this.groupBox2.Controls.Add(this.lblHCTACode);
            this.groupBox2.Controls.Add(this.txtCertPass);
            this.groupBox2.Controls.Add(this.txtHCTACertPassword);
            this.groupBox2.Controls.Add(this.label3);
            this.groupBox2.Controls.Add(this.lblEncryptionHCTAPassword);
            this.groupBox2.Controls.Add(this.btnBrowseKeyCert);
            this.groupBox2.Controls.Add(this.btnBrowseHCTACert);
            this.groupBox2.Controls.Add(this.lblKeyEncryptionCertPassword);
            this.groupBox2.Controls.Add(this.txtHCTACert);
            this.groupBox2.Controls.Add(this.txtKeyCertPassword);
            this.groupBox2.Controls.Add(this.lblHCTAKey);
            this.groupBox2.Controls.Add(this.btnSignXML);
            this.groupBox2.Controls.Add(this.chkM1O2);
            this.groupBox2.Location = new System.Drawing.Point(12, 18);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(460, 570);
            this.groupBox2.TabIndex = 46;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "Solo Perú";
            // 
            // MainForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(818, 600);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.groupBox2);
            this.Name = "MainForm";
            this.Text = "Generador de reporte FATCA para la SUNAT";
            this.Load += new System.EventHandler(this.MainForm_Load);
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Label lblLoadXML;
        private System.Windows.Forms.TextBox txtXmlFile;
        private System.Windows.Forms.Button btnBrowseXml;
        private System.Windows.Forms.Label lblCert;
        private System.Windows.Forms.TextBox txtCert;
        private System.Windows.Forms.Button btnBrowseCert;
        private System.Windows.Forms.Label lblCertPass;
        private System.Windows.Forms.TextBox txtCertPass;
        private System.Windows.Forms.Button btnBrowseKeyCert;
        private System.Windows.Forms.TextBox txtKeyCert;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox txtKeyCertPassword;
        private System.Windows.Forms.Label lblKeyEncryptionCertPassword;
        private System.Windows.Forms.Button btnSignXML;
        private System.Windows.Forms.Button btnBrowseNotificationZip;
        private System.Windows.Forms.TextBox txtNotificationZip;
        private System.Windows.Forms.Label lblZipFile;
        private System.Windows.Forms.Button btnBrowseRecCert;
        private System.Windows.Forms.TextBox txtReceiverCert;
        private System.Windows.Forms.Label lblReceiverCert;
        private System.Windows.Forms.TextBox txtRecKeyPassword;
        private System.Windows.Forms.Label lblRecPass;
        private System.Windows.Forms.Button btnDecryptZip;
        private System.Windows.Forms.TextBox txtSenderCode;
        private System.Windows.Forms.Label lblSender;
        private System.Windows.Forms.TextBox txtReceiverCode;
        private System.Windows.Forms.Label lblReceiver;
        private System.Windows.Forms.Button btnBrowseOutput;
        private System.Windows.Forms.TextBox txtNotificationFolder;
        private System.Windows.Forms.Label lblOutput;
        private System.Windows.Forms.OpenFileDialog dlgOpen;
        private System.Windows.Forms.SaveFileDialog dlgSave;
        private System.Windows.Forms.FolderBrowserDialog dlgOpenFolder;
        private System.Windows.Forms.CheckBox chkM1O2;
        private System.Windows.Forms.Button btnBrowseHCTACert;
        private System.Windows.Forms.TextBox txtHCTACert;
        private System.Windows.Forms.Label lblHCTAKey;
        private System.Windows.Forms.TextBox txtHCTACertPassword;
        private System.Windows.Forms.Label lblEncryptionHCTAPassword;
        private System.Windows.Forms.TextBox txtHCTACode;
        private System.Windows.Forms.Label lblHCTACode;
        private System.Windows.Forms.TextBox txtFileNameZip;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox txtFileNameXml;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox txtPathResult;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Button btnBrowserPathResult;
        private System.Windows.Forms.FolderBrowserDialog folderBrowserDialog1;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.GroupBox groupBox2;
    }
}

