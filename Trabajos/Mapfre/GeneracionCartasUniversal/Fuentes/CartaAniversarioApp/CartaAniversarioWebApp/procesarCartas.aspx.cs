using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using CartaAniversarioBusinessApp.util;
using CartaAniversarioWebApp.util;
using System.Web.Script.Serialization;
using CartaAniversarioBusinessApp.model;
using Microsoft.Office.Interop.Word;
using System.IO;
using System.Configuration;
using CartaAniversarioBusinessApp.repository;

namespace CartaAniversarioWebApp
{
    public partial class procesarCartas : System.Web.UI.Page
    {

        public string connStr = ConfigurationManager.ConnectionStrings["OracleTronCon"].ConnectionString;
        public CartaAniversarioRepository repo = new CartaAniversarioRepository();

        protected void Page_Load(object sender, EventArgs e)
        {

            string op = Request.QueryString["op"];

            if (op != null)
            {

                if (op == "listCartaCab")
                {
                    this.listCartaCab();
                }

                if (op == "getCarta")
                {
                    int indexList = int.Parse(Request.QueryString["indexList"]);
                    this.getCarta(indexList);
                }
            }

            if (Session["listCartCab"] != null) {
                Page.ClientScript.RegisterStartupScript(this.GetType(), "Listado", "listarCartas();", true);
            }
            
        }

        protected void btnProcesar_Click(object sender, EventArgs e)
        {

           insertLog("Inicio del proceso de captura de datos", fu_doc.FileName);

           div_error.Visible = false;
          
           string tempPath = System.Environment.GetEnvironmentVariable("TEMP");
           insertLog("Ruta temporal obtenida: " + tempPath, fu_doc.FileName);

           string docPath = null;

            if (fu_doc.HasFile) {

                if (fu_doc.FileName.ToLower().EndsWith(".docx") || fu_doc.FileName.ToLower().EndsWith(".doc"))
                {
                    insertLog("El archivo cumple con las extensiones requeridas", fu_doc.FileName);

                    if (fu_doc.FileName.ToLower().EndsWith(".doc"))
                    {
                        docPath = tempPath + "\\" + this.createRandomName() + ".doc";
                        fu_doc.PostedFile.SaveAs(docPath);
                        fu_doc.FileContent.Close();
                        docPath = this.ConvertDOCToDOCX(docPath);
                        insertLog("Ruta donde se guardara el documento: " + docPath, fu_doc.FileName);
                    }
                    else {

                        docPath = tempPath + "\\" + this.createRandomName() + ".docx";
                        fu_doc.PostedFile.SaveAs(docPath);
                        fu_doc.FileContent.Close();
                        insertLog("Ruta donde se guardara el documento: " + docPath, fu_doc.FileName);
                    }

                    try
                    {

                        GetTextDocxUtil obj = new GetTextDocxUtil();

                        List<Property> properties = repo.loadProperties(connStr);
                        List<TextLabel> textLabels = repo.loadTextLabels(connStr,true);

                        insertLog("Inicio proceso de parsear el documento enviado", fu_doc.FileName);
                        List<CartaAniversarioBusinessApp.model.CartaCab> listCartCab = obj.process(docPath, properties, textLabels);
                        insertLog("Fin proceso de parsear el documento enviado", fu_doc.FileName);

                        insertLog("Inicio de captura de datos del contratante", fu_doc.FileName);
                        foreach (CartaCab x in listCartCab)
                        {
                            repo.setInfoContratante(x, connStr);
                        }
                        insertLog("Fin de captura de datos del contratante", fu_doc.FileName);

                        insertLog("Se guarda en session las cartas procesadas", fu_doc.FileName);
                        Session["listCartCab"] = listCartCab;
                        insertLog("Se ejectura la funcion de listado de las cartas procesadas", fu_doc.FileName);
                        Page.ClientScript.RegisterStartupScript(this.GetType(), "Listado", "listarCartas();", true);
                        insertLog("Fin del proceso de captura de datos", fu_doc.FileName);
                    }
                    catch (Exception ex)
                    {

                        insertLog(ex.Message, fu_doc.FileName);

                        div_error.Visible = true;
                        div_error.InnerText = "Error: " + ex.Message;

                    }

                }
                else {
                    Page.ClientScript.RegisterStartupScript(this.GetType(), "Error de extension", "alert('Sole se permite archivos con extension *.docx o *.doc')", true);
                }

            }
        }

        public void listCartaCab() {

            List<CartaAniversarioBusinessApp.model.CartaCab> listCartCab = (List<CartaAniversarioBusinessApp.model.CartaCab>) Session["listCartCab"];

            if (listCartCab == null) {
                listCartCab = new List<CartaAniversarioBusinessApp.model.CartaCab>();
            }

            string json = new JavaScriptSerializer().Serialize(listCartCab);

            Response.Clear();
            Response.ContentType = "application/json";
            Response.Write(json);
            Response.Flush();
            Response.End();

        }

        public void getCarta(int indexList)
        {

            List<CartaCab> listCartCab = (List<CartaAniversarioBusinessApp.model.CartaCab>)Session["listCartCab"];

            CartaCab cartaCab = listCartCab[indexList];


            string json = new JavaScriptSerializer().Serialize(cartaCab);

            Response.Clear();
            Response.ContentType = "application/json";
            Response.Write(json);
            Response.Flush();
            Response.End();

        }

        public string ConvertDOCToDOCX(string path)
        {
            Application word = new Application();

            if (path.ToLower().EndsWith(".doc"))
            {
                var sourceFile = new FileInfo(path);
                var doc = word.Documents.Open(sourceFile.FullName);

                string newFileName = sourceFile.FullName.Replace(".doc", ".docx");
                doc.SaveAs2(FileName: newFileName, FileFormat: WdSaveFormat.wdFormatXMLDocument, CompatibilityMode: Microsoft.Office.Interop.Word.WdCompatibilityMode.wdWord2010);

                word.ActiveDocument.Close();
                word.Quit();
                return newFileName;
            }
            else {
                return path;
            }
        }

        protected void btnGrabar_Click(object sender, EventArgs e)
        {
            string msg = "";
            div_error.Visible = false;
            CartaAniversarioRepository repo = new CartaAniversarioRepository();
            string connStr = ConfigurationManager.ConnectionStrings["OracleTronCon"].ConnectionString;
            List<CartaAniversarioBusinessApp.model.CartaCab> listCartCab = (List<CartaAniversarioBusinessApp.model.CartaCab>)Session["listCartCab"];

            if (listCartCab != null && listCartCab.Count > 0)
            {

                try {

                    repo.insertList(listCartCab, connStr);

                    Session["listCartCab"] = null;
                    msg = "Se grabó con éxito la información";
                
                }
                catch (Exception ex) {

                    insertLog(ex.Message, null);

                    div_error.Visible = true;
                    div_error.InnerText = "Error: " + ex.Message;

                    msg = "Ocurrió un error inesperado, inténtelo mas tarde.";
                }

            }
            else {
                msg = "No hay información por grabar.";
            }

            Page.ClientScript.RegisterStartupScript(this.GetType(), "Respuesta", "alert('" + msg + "')", true);
        }

        protected void btnBorrarCarga_Click(object sender, EventArgs e)
        {
            Session["listCartCab"] = null;
        }

        public void insertLog(String msj, String fileName) {
            CartaAniversarioBusinessApp.model.LogError log = new LogError();
            log.descripError = msj;
            log.nombreArchivo = fileName;
            log.codUsr = "TRON2000";
            log.fecReg = DateTime.Today;
            repo.insertLog(log, connStr);
        }

        public string createRandomName() {

            var chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            var random = new Random();
            var result = new string(
                Enumerable.Repeat(chars, 20)
                          .Select(s => s[random.Next(s.Length)])
                          .ToArray());

            return result;
        
        }
    }
}