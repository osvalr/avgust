using System;
using System.IO;
using System.Windows.Forms;
using System.Xml;
using System.Text;
using System.Security.Cryptography;
using System.Security.Cryptography.X509Certificates;
using System.Drawing;
using System.Collections.Generic;
using FatcaDesktopApp.util;



namespace WindowsFormsApplication1
{
    public partial class MainForm : Form
    {
        public MainForm()
        {
            InitializeComponent();
            //Begin JRaffo 11/08/2015
            string directory = AppDomain.CurrentDomain.BaseDirectory;
            Dictionary<string, string> data = ReadProperties.read(directory + "\\config.properties");
            txtFileNameZip.Text = data["pre_fijo_file"] + DateTime.Now.Year + "_" + data["sufijo_file"] + ".zip";
            txtFileNameXml.Text = data["pre_fijo_file"] + DateTime.Now.Year + "_" + data["sufijo_file"] + ".xml";
            //End JRaffo 11/08/2015
        }

        

        private void btnBrowseXml_Click(object sender, EventArgs e)
        {
            // load XML
            txtXmlFile.Text = dlgOpen.ShowDialogWithFilter("XML Files (*.xml)|*.xml");
        }

        private void btnBrowseCert_Click(object sender, EventArgs e)
        {
            // load certificate
            txtCert.Text = dlgOpen.ShowDialogWithFilter("Signing Certificates (*.pfx, *.p12)|*.pfx;*.p12;");
        }

        private void btnBrowseKeyCert_Click(object sender, EventArgs e)
        {
            // load AES key encryption certificate
            txtKeyCert.Text = dlgOpen.ShowDialogWithFilter("Certificate Files (*.cer, *.pfx, *.p12)|*.cer;*.pfx;*.p12;");
        }

        private void btnSignXML_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrWhiteSpace(txtXmlFile.Text))
            {
                // files validation
                MessageBox.Show("The XML file was not specified!", Text, MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }

            if (string.IsNullOrWhiteSpace(txtCert.Text))
            {
                // files validation
                MessageBox.Show("The Signing Certificate was not specified!", Text, MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }

            if (string.IsNullOrWhiteSpace(txtCertPass.Text))
            {
                // certificate password validation
                MessageBox.Show("Signing Certificate password was not specified!", Text, MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }

            if (string.IsNullOrWhiteSpace(txtKeyCert.Text))
            {
                // files validation
                MessageBox.Show("Encryption Certificate was not specified!", Text, MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }

            //Begin JRaffo 11/08/2015
            if (string.IsNullOrWhiteSpace(txtFileNameZip.Text))
            {
                // files validation
                MessageBox.Show("Nombre del archivo ZIP a generar no esta especificado!", Text, MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }

            if (!txtFileNameZip.Text.ToLower().EndsWith(".zip"))
            {
                // files validation
                MessageBox.Show("Extension incorrecta el en campo del nombre del archivo ZIP (se espera '*.zip')!", Text, MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
            
            if (string.IsNullOrWhiteSpace(txtFileNameXml.Text))
            {
                // files validation
                MessageBox.Show("Nombre del archivo XML a generar no esta especificado!", Text, MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }

            if (!txtFileNameXml.Text.ToLower().EndsWith(".xml"))
            {
                // files validation
                MessageBox.Show("Extension incorrecta el en campo del nombre del archivo XML (se espera '*.xml')!", Text, MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }

            if (string.IsNullOrWhiteSpace(txtPathResult.Text))
            {
                // files validation
                MessageBox.Show("Ruta donde se guardaran los archivos generados no esta especificada!", Text, MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }

            if (!System.IO.Directory.Exists(txtPathResult.Text))
            {
                // files validation
                MessageBox.Show("No existe la ruta especificada en el campo de ruta donde se guardaran los archivos generados!", Text, MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
            //End JRaffo 11/08/2015

            try
            {
                // load XML file content
                byte[] xmlContent = File.ReadAllBytes(txtXmlFile.Text);
                string senderGIIN = Path.GetFileNameWithoutExtension(txtXmlFile.Text);
                
                //BEGIN JRaffo 05/08/2015
                string nameFolder = "";
                nameFolder = txtFileNameZip.Text.ToLower().Replace(".zip", "").ToUpper();
                string filePath = txtPathResult.Text + "\\" + nameFolder;
                //END JRaffo 05/08/2015

                // perform sign
                byte[] envelopingSignature = XmlManager.Sign(XmlSignatureType.Enveloping, xmlContent, txtCert.Text, txtCertPass.Text);
                
                //BEGIN JRaffo 05/08/2015

                //string envelopingFileName = txtXmlFile.Text.Replace(".xml", "_Payload.xml");
                string directory = filePath;
                bool exists = System.IO.Directory.Exists(directory);

                if (!exists) {
                    System.IO.Directory.CreateDirectory(directory);
                }

                string envelopingFileName = directory + "\\" + txtFileNameXml.Text.Replace(".XML",".xml");

                //string zipFileName = envelopingFileName.Replace(".xml", ".zip");
                string zipFileName = directory + "\\" + txtFileNameZip.Text.Replace(".ZIP",".zip");

                //END JRaffo 05/08/2015

                // save enveloping version to disk
                File.WriteAllBytes(envelopingFileName, envelopingSignature);

                // add enveloping signature to ZIP file
                ZipManager.CreateArchive(envelopingFileName, zipFileName);

                // generate AES key (32 bytes) & default initialization vector (empty)
                byte[] aesEncryptionKey = AesManager.GenerateRandomKey(AesManager.KeySize / 8);
                byte[] aesEncryptionVector = AesManager.GenerateRandomKey(16, true);

                // encrypt file & save to disk
                string encryptedFileName = zipFileName.Replace(".zip", "");
                string encryptedHCTAFileName = zipFileName.Replace(".zip", "");
                string payloadFileName = encryptedFileName;
                AesManager.EncryptFile(zipFileName, encryptedFileName, aesEncryptionKey, aesEncryptionVector);

                // encrypt key with public key of certificate & save to disk
                encryptedFileName = Path.GetDirectoryName(zipFileName) + "\\000000.00000.TA.840_Key"; 
                AesManager.EncryptAesKey(aesEncryptionKey, txtKeyCert.Text, txtKeyCertPassword.Text, encryptedFileName);
                //For Model1 Option2 Only, encrypt the AES Key with the HCTA Public Key
                if (chkM1O2.Checked) {
                    encryptedHCTAFileName = Path.GetDirectoryName(zipFileName) + "\\000000.00000.TA." + txtHCTACode.Text + "_Key";
                    AesManager.EncryptAesKey(aesEncryptionKey, txtHCTACert.Text, txtHCTACertPassword.Text, encryptedHCTAFileName);
                }

                // cleanup
                envelopingSignature = null;
                aesEncryptionKey = aesEncryptionVector = null;

                //Start creating XML metadata
                XmlWriter writer = null;
                string fileCreationDateTime = "";
                fileCreationDateTime = DateTime.Now.ToString("yyyy'-'MM'-'dd'T'HH':'mm':'ssZ");

                DateTime uDat = new DateTime();
                uDat = DateTime.UtcNow;
                string senderFile = uDat.ToString("yyyyMMddTHHmmssfffZ") + "_" + senderGIIN;

                try
                {

                    // Create an XmlWriterSettings object with the correct options. 
                    XmlWriterSettings settings = new XmlWriterSettings();
                    settings.Indent = true;
                    settings.IndentChars = ("\t");
                    settings.OmitXmlDeclaration = false;
                    settings.NewLineHandling = NewLineHandling.Replace;
                    settings.CloseOutput = true;

                    string metadataFileName = filePath + "\\" + senderGIIN + "_Metadata.xml";

                    // Create the XmlWriter object and write some content.
                    writer = XmlWriter.Create(metadataFileName, settings);
                    writer.WriteStartElement("FATCAIDESSenderFileMetadata", "urn:fatca:idessenderfilemetadata");
                    writer.WriteAttributeString("xmlns", "xsi", null, "http://www.w3.org/2001/XMLSchema-instance");
                    writer.WriteStartElement("FATCAEntitySenderId");
                    writer.WriteString(senderGIIN);
                    writer.WriteEndElement();
                    writer.WriteStartElement("FATCAEntityReceiverId");
                    writer.WriteString("000000.00000.TA.840");
                    writer.WriteEndElement();
                    writer.WriteStartElement("FATCAEntCommunicationTypeCd");
                    writer.WriteString("RPT");
                    writer.WriteEndElement();
                    writer.WriteStartElement("SenderFileId");
                    writer.WriteString(senderFile);
                    writer.WriteEndElement();
                    writer.WriteStartElement("FileCreateTs");
                    writer.WriteString(fileCreationDateTime);
                    writer.WriteEndElement();
                    writer.WriteStartElement("TaxYear");
                    writer.WriteString("2014");
                    writer.WriteEndElement();
                    writer.WriteStartElement("FileRevisionInd");
                    writer.WriteString("false");
                    writer.WriteEndElement();
                    //Close the XmlTextWriter.
                    writer.WriteEndDocument();
                    writer.Close();
                    writer.Flush();


                    //Add the metadata, payload, and key files to the final zip package
                    // add enveloping signature to ZIP file
                    ZipManager.CreateArchive(metadataFileName, filePath + "\\" + senderFile + ".zip");
                    ZipManager.UpdateArchive(encryptedFileName, filePath + "\\" + senderFile + ".zip");
                    ZipManager.UpdateArchive(payloadFileName, filePath + "\\" + senderFile + ".zip");
                    //Add the HCTA Key file for a M1O2 packet
                    if (chkM1O2.Checked)
                    {
                        ZipManager.UpdateArchive(encryptedHCTAFileName, filePath + "\\" + senderFile + ".zip");
                    }

                    // success
                    MessageBox.Show("XML Signing and Encryption process is complete!", Text, MessageBoxButtons.OK, MessageBoxIcon.Information);


                }
                finally
                {
                    if (writer != null)
                        writer.Close();
                }



            }
            catch (Exception ex)
            {
                ex.DisplayException(Text);
            }
        }

        private void btnBrowseNotificationZip_Click(object sender, EventArgs e)
        {
            // load Notification Zip file
            txtNotificationZip.Text = dlgOpen.ShowDialogWithFilter("ZIP Files (*.zip)|*.zip");
        }

        private void btnBrowseRecCert_Click(object sender, EventArgs e)
        {
            // load Notification Receiver key
            txtReceiverCert.Text = dlgOpen.ShowDialogWithFilter("Certificate Files (*.cer, *.pfx, *.p12)|*.cer;*.pfx;*.p12");
        }

        private void btnDecryptZip_Click(object sender, EventArgs e)
        {

            if (string.IsNullOrWhiteSpace(txtNotificationZip.Text) || string.IsNullOrWhiteSpace(txtReceiverCert.Text))
            {
                // files validation
                MessageBox.Show("Either the ZIP file or certificate was not specified!", Text, MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }

            string zipFolder = "";
            try
            {
                //Deflate the zip archive
                zipFolder = ZipManager.ExtractArchive(txtNotificationZip.Text, txtNotificationFolder.Text);

            }
            catch (Exception ex)
            {
                ex.DisplayException(Text);
                return;
            }
            // select encrypted key file
            string encryptedKeyFile = "";
            string encryptedPayloadFile = "";
            string[] keyFiles = Directory.GetFiles(zipFolder, "*_Key", SearchOption.TopDirectoryOnly);
            string[] payloadFiles = Directory.GetFiles(zipFolder, "*_Payload", SearchOption.TopDirectoryOnly);

            if (keyFiles.Length == 0)
            {
                // key file validation
                MessageBox.Show("There was no file found containing the encrypted AES key!", Text, MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
            if (payloadFiles.Length == 0)
            {
                // key file validation
                MessageBox.Show("There was no file found containing the encrypted Payload!", Text, MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
            encryptedKeyFile = keyFiles[0];
            encryptedPayloadFile = payloadFiles[0];



            byte[] encryptedAesKey = null;
            byte[] decryptedAesKey = null;
            byte[] aesVector = null;

            try
            {
                // load encrypted AES key
                encryptedAesKey = File.ReadAllBytes(encryptedKeyFile);

                // decrypt AES key & generate default (empty) initialization vector
                decryptedAesKey = AesManager.DecryptAesKey(encryptedAesKey, txtReceiverCert.Text, txtRecKeyPassword.Text);
                aesVector = AesManager.GenerateRandomKey(16, true);

                // decrypt encrypted ZIP file using decrypted AES key
                string decryptedFileName = encryptedPayloadFile.Replace("_Payload", "_Payload_decrypted.zip");
                AesManager.DecryptFile(encryptedPayloadFile, decryptedFileName, decryptedAesKey, aesVector);


                //Deflate the decrypted zip archive
                ZipManager.ExtractArchive(decryptedFileName, decryptedFileName, false);



                // success
                MessageBox.Show("Notification decryption process is complete!", Text, MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
            catch (Exception ex)
            {
                ex.DisplayException(Text);
            }
            finally
            {
                if (encryptedAesKey != null)
                {
                    encryptedAesKey = null;
                }

                if (decryptedAesKey != null)
                {
                    decryptedAesKey = null;
                }

                if (aesVector != null)
                {
                    aesVector = null;
                }
            }
        }

        private void btnBrowseOutput_Click(object sender, EventArgs e)
        {
            // load AES key encryption certificate
            if (dlgOpenFolder.ShowDialog() == DialogResult.OK)
            {
                txtNotificationFolder.Text = dlgOpenFolder.SelectedPath;
            }
        }


        private void chkM1O2_CheckedChanged(object sender, EventArgs e)
        {
            if (chkM1O2.Checked)
            {
                this.lblHCTAKey.Location = new Point(
                this.lblHCTAKey.Location.X,
                this.lblHCTAKey.Location.Y - 40
                );
                this.btnBrowseHCTACert.Location = new Point(
                this.btnBrowseHCTACert.Location.X,
                this.btnBrowseHCTACert.Location.Y - 40
                );
                this.txtHCTACert.Location = new Point(
                this.txtHCTACert.Location.X,
                this.txtHCTACert.Location.Y - 40
                );
                this.lblEncryptionHCTAPassword.Location = new Point(
                this.lblEncryptionHCTAPassword.Location.X,
                this.lblEncryptionHCTAPassword.Location.Y - 40
                );
                this.txtHCTACertPassword.Location = new Point(
                this.txtHCTACertPassword.Location.X,
                this.txtHCTACertPassword.Location.Y - 40
                );
                this.lblHCTACode.Location = new Point(
                this.lblHCTACode.Location.X,
                this.lblHCTACode.Location.Y - 40
                );
                this.txtHCTACode.Location = new Point(
                this.txtHCTACode.Location.X,
                this.txtHCTACode.Location.Y - 40
                );
                this.btnSignXML.Location = new Point(
                this.btnSignXML.Location.X,
                this.btnSignXML.Location.Y + 140
                );
                

                lblHCTAKey.Visible = true;
                txtHCTACert.Visible = true;
                btnBrowseHCTACert.Visible = true;
                lblEncryptionHCTAPassword.Visible = true;
                txtHCTACertPassword.Visible = true;
                lblHCTACode.Visible = true;
                txtHCTACode.Visible = true;
            }
            else
            {
                this.lblHCTAKey.Location = new Point(
                this.lblHCTAKey.Location.X,
                this.lblHCTAKey.Location.Y + 40
                );
                this.btnBrowseHCTACert.Location = new Point(
                this.btnBrowseHCTACert.Location.X,
                this.btnBrowseHCTACert.Location.Y + 40
                );
                this.txtHCTACert.Location = new Point(
                this.txtHCTACert.Location.X,
                this.txtHCTACert.Location.Y + 40
                );
                this.lblEncryptionHCTAPassword.Location = new Point(
                this.lblEncryptionHCTAPassword.Location.X,
                this.lblEncryptionHCTAPassword.Location.Y + 40
                );
                this.txtHCTACertPassword.Location = new Point(
                this.txtHCTACertPassword.Location.X,
                this.txtHCTACertPassword.Location.Y + 40
                );
                this.lblHCTACode.Location = new Point(
                this.lblHCTACode.Location.X,
                this.lblHCTACode.Location.Y + 40
                );
                this.txtHCTACode.Location = new Point(
                this.txtHCTACode.Location.X,
                this.txtHCTACode.Location.Y + 40
                );
                this.btnSignXML.Location = new Point(
                this.btnSignXML.Location.X,
                this.btnSignXML.Location.Y - 140
                );

                lblHCTAKey.Visible = false;
                txtHCTACert.Visible = false;
                btnBrowseHCTACert.Visible = false;
                lblEncryptionHCTAPassword.Visible = false;
                txtHCTACertPassword.Visible = false;
                lblHCTACode.Visible = false;
                txtHCTACode.Visible = false;
            }
        }


        private void btnBrowseHCTACert_Click(object sender, EventArgs e)
        {
            // load AES key encryption certificate
            txtHCTACert.Text = dlgOpen.ShowDialogWithFilter("Certificate Files (*.cer, *.pfx, *.p12)|*.cer;*.pfx;*.p12");
      
        }

        private void MainForm_Load(object sender, EventArgs e)
        {

            lblHCTAKey.Visible = false;
            txtHCTACert.Visible = false;
            btnBrowseHCTACert.Visible = false;
            lblEncryptionHCTAPassword.Visible = false;
            txtHCTACertPassword.Visible = false;
            lblHCTACode.Visible = false;
            txtHCTACode.Visible = false;

        }

        private void btnBrowserPathResult_Click(object sender, EventArgs e)
        {
            DialogResult result = folderBrowserDialog1.ShowDialog();
            if (result == DialogResult.OK)
            {
                txtPathResult.Text = folderBrowserDialog1.SelectedPath;
            }
        }


       
    }
}
